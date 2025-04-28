package spring.boot.desafio.gps.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_ponto_interesse")
public class poi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private long x;
    private long y;

    public poi() {}

    public poi(String nome, long x, long y) {
        this.nome = nome;
        this.x = x;
        this.y = y;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }
}
