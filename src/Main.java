import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Criando conteudos, devs e bootcamps

        Curso cursoGit = new Curso("Curso de GIT", "Venha aprender a trabalhar com GitHub", 2);
        Curso cursoJS = new Curso("Curso de JS iniciante", "Primeiro contato com a linguagem", 5);
        Curso cursoJava = new Curso("Curso de Java iniciante", "Primeiro contato com a linguagem", 5);
        Mentoria mentoriaJS = new Mentoria("Talk com expert de JS", "Venha saber mais sobre a linguagem");
        Mentoria mentoriaJava = new Mentoria("Talk com expert de Java", "Venha saber mais sobre a linguagem");

        Bootcamp bootcampJava = new Bootcamp("Bootcamp de Java", "Aprenda Java do ZERO");
        bootcampJava.getConteudos().add(cursoGit);
        bootcampJava.getConteudos().add(cursoJava);
        bootcampJava.getConteudos().add(mentoriaJava);
        Bootcamp bootcampJS = new Bootcamp("Bootcamp de JavaScript", "Aprenda JavaScript do ZERO");
        bootcampJS.getConteudos().add(cursoGit);
        bootcampJS.getConteudos().add(cursoJS);
        bootcampJS.getConteudos().add(mentoriaJS);

        Dev devGuilherme = new Dev("Guilherme");
        Dev devPedro = new Dev("Pedro");

        // Mão na massa!

        // Dia 01 - Increvendo os devs nos bootcamps
        System.out.println("------------------------ DIA 1 ------------------------ \n");
        devGuilherme.inscrever(bootcampJava);
        devPedro.inscrever(bootcampJS);

        imprimeConteudosInscritos(devGuilherme);
        imprimeConteudosInscritos(devPedro);
        imprimeConteudosConcluidos(devGuilherme);
        imprimeConteudosConcluidos(devPedro);
        System.out.println("XP do dev Guilherme: " + devGuilherme.calcularTotalXp());
        System.out.println("XP do dev Pedro: " + devPedro.calcularTotalXp());

        // Dia 02 - Guilherme encerra dois conteudos, Pedro encerra um
        System.out.println("------------------------ DIA 2 ------------------------ \n");

        devGuilherme.progredir();
        devGuilherme.progredir();
        devPedro.progredir();

        imprimeConteudosInscritos(devGuilherme);
        imprimeConteudosInscritos(devPedro);
        imprimeConteudosConcluidos(devGuilherme);
        imprimeConteudosConcluidos(devPedro);
        System.out.println("XP do dev Guilherme: " + devGuilherme.calcularTotalXp());
        System.out.println("XP do dev Pedro: " + devPedro.calcularTotalXp());

        // Dia 03 - Guilherme se increve no bootcamp de JS também.
        // Obs: Não deve se increver no conteúdo de git, pois ele já fez
        System.out.println("------------------------ DIA 3 ------------------------ \n");

        devGuilherme.inscrever(bootcampJS);

        imprimeConteudosInscritos(devGuilherme);
        imprimeConteudosInscritos(devPedro);
        imprimeConteudosConcluidos(devGuilherme);
        imprimeConteudosConcluidos(devPedro);
        System.out.println("XP do dev Guilherme: " + devGuilherme.calcularTotalXp());
        System.out.println("XP do dev Pedro: " + devPedro.calcularTotalXp());

        // Dia 04 - Guilherme se confunde e tenta se inscrever novamente no bootcamp de java.
        // Deve retornar erro
        System.out.println("------------------------ DIA 4 ------------------------ \n");

        devGuilherme.inscrever(bootcampJava);

        // Dia 05 - Forçando Pedro a progredir sem conteúdo matriculado.
        // Deve retornar erro
        System.out.println("------------------------ DIA 5 ------------------------ \n");

        devPedro.progredir();
        devPedro.progredir();
        devPedro.progredir();

        imprimeConteudosInscritos(devPedro);
        imprimeConteudosConcluidos(devPedro);
        System.out.println("XP do dev Pedro: " + devPedro.calcularTotalXp());
    }


    public static void imprimeConteudosInscritos(Dev dev) {
        System.out.println("Conteúdos inscritos do dev " + dev.getNome());
        dev.getConteudosInscritos().forEach(System.out::println);
        System.out.println("\n");
    }

    public static void imprimeConteudosConcluidos(Dev dev) {
        System.out.println("Conteúdos concluidos do dev " + dev.getNome());
        dev.getConteudosConcluidos().forEach(System.out::println);
        System.out.println("\n");
    }
}
