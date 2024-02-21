package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public Dev(String nome) {
        this.nome = nome;
    }

    public void inscrever(Bootcamp bootcamp) {

        if (!bootcamp.getDevsInscritos().contains(this)) {

         /* Caso o dev ainda não se inscreveu no bootcamp, ira verificar cada conteudo para saber se o aluno já
            tem o mesmo inscrito ou finalizado, caso não tenha para ambos, irá se inscrever   */

            bootcamp.getConteudos().forEach(conteudo -> {
                if (!this.conteudosInscritos.contains(conteudo) && !this.conteudosConcluidos.contains(conteudo)) {
                    this.conteudosInscritos.add(conteudo);
                }
            });

            bootcamp.getDevsInscritos().add(this);

        } else {
            //Caso dev já tenha se matriculado no bootcamp dá erro
            System.out.println("Aluno já matriculado! \n");
        }

    }

    public void progredir() {
        Optional<Conteudo> first = this.conteudosInscritos.stream().findFirst();

        if (first.isPresent()) {
            this.conteudosConcluidos.add(first.get());
            this.conteudosInscritos.remove(first.get());
        } else {
            System.out.println("Dev " + this.nome + " não está matriculado em nenhum conteúdo! \n");
        }
    }

    public double calcularTotalXp(){
        return this.conteudosConcluidos.stream().mapToDouble(Conteudo::calculaXp).sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return nome;
    }
}
