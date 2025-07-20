package dio.pad.projeto.spring.service.impl;

/*
* Implementção da <b>Strategy</b> {@link ClienteService}, a Qual pode ser injetada pelo Spring
* (via {@link Autowired}). Com isso, como essa classe é um {@link Service}, ela será tratada como um <b>Singleton</b>
* */

import dio.pad.projeto.spring.model.Cliente;
import dio.pad.projeto.spring.model.ClienteRepository;
import dio.pad.projeto.spring.model.Endereco;
import dio.pad.projeto.spring.model.EnderecoRepository;
import dio.pad.projeto.spring.service.ClienteService;
import dio.pad.projeto.spring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
   private ClienteRepository clienteRepository;
    @Autowired
   private EnderecoRepository enderecoRepository;
    @Autowired
   private ViaCepService viaCepSerivce;

    //Stategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Cliente> buscarTodos() {
        // Buscar todos os clientes
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        // Buscar cliente por ID
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        // Buscar Cliente por ID, caso exista:
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        //  deletar Cliente por Id.
        clienteRepository.deleteById(id);
    }

    public void salvarClienteComCep(Cliente cliente) {
        // verificar se o endereçp do cliente já existe (pelo CEP)
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista integrar com viaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepSerivce.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        // Inserir cliente, vinculando o Endereco (novo ou existente).
        clienteRepository.save(cliente);
    }


}











