import br.com.dio.desafio.dominio.BootCamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso01  = new Curso();

        curso01.setTitulo("Curso java poo");
        curso01.setDescricao("Descricao do curso java poo");
        curso01.setCargaHoraria(8);

        Curso curso02 = new Curso();
        curso02.setTitulo("Curso java-scrip");
        curso02.setDescricao("Descricao do curso java-script não é java");
        curso02.setCargaHoraria(2);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria java");
        mentoria.setDescricao("descricao mentoria java");
        mentoria.setData(LocalDate.now());

//        System.out.println(curso01);
//        System.out.println(curso02);
//        System.out.println(mentoria);

        BootCamp bootcamp1 = new BootCamp();
        bootcamp1.setNome("Bootcamp java");
        bootcamp1.setDescricao("Descricao bootcamp java");
        bootcamp1.getConteudos().add(curso01);
        bootcamp1.getConteudos().add(curso02);
        bootcamp1.getConteudos().add(mentoria);

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp1);
        System.out.println("COnteudos: " + devJoao.getConteudosInscritos());
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();

        System.out.println("Apos progredir");
        System.out.println("Conteudos concluidos "+devJoao.getConteudosConcluidos());
        System.out.println("COnteudos Inscritos: " + devJoao.getConteudosInscritos());
        System.out.println("----XP: "+ devJoao.calcularTotalXp());

        System.out.println("****");
        Dev devMaria = new Dev();
        devMaria.inscreverBootcamp(bootcamp1);
        devMaria.setNome("Maria");
        System.out.println("Conteudos: "+ devMaria.getConteudosInscritos());
        devMaria.progredir();
        System.out.println("Conteudos concluidos: "+ devMaria.getConteudosConcluidos());
        System.out.println("----XP: "+ devMaria.calcularTotalXp());




    }
}
