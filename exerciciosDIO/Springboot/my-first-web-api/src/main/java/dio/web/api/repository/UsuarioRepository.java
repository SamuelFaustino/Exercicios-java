package dio.web.api.repository;

import dio.web.api.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    public void save(Usuario usuario) {
        if(usuario.getId() == null)
            System.out.println("SAVE - Recebendo o usuário na camada de repositorio");
        else
            System.out.println("UPDATE - Recebendo o usuário na camada de repositorio");

        System.out.println(usuario);
    }
    public void deleteById(Integer id) {
        System.out.println(String.format(" DELETE/ID - Recebendo id: %d para excluir usuário",id));
        System.out.println(id);
    }

    public List<Usuario> findAll() {
        System.out.println("LIST _ Listando os usuários do sistema");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("samuel","12345"));
        usuarios.add(new Usuario("joao", "9876"));

        return usuarios;
    }

    public Usuario findById(Integer id) {
        System.out.println(String.format("FInd/ID - Recebendo o id: %d para Localizar usuário",id));

        return new Usuario("samuel", "pass123");
    }

    public Usuario findByUsername(String username) {
        System.out.println(String.format("Find/Username - Recebendo o username para localizar usuário"));
        return new Usuario("Samuel", "pass123");
    }


}
