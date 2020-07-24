package br.com.etecia.tcc;

public class Produto {

    private String nome;
    private int logo;

    public Produto(){
    }

    public Produto(String nome, int logo) {
        this.nome = nome;
        this.logo = logo;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
