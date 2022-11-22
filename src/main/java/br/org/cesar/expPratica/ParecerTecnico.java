package br.org.cesar.expPratica;

import javax.persistence.*;

@Entity
@Table(name = "parecer_tecnico")
public class ParecerTecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "equipamento", nullable = false)
    private String equipamento;
    @Column(name = "defeito", nullable = false)
    private String defeito;
    @Column(name = "parecer", nullable = false)
    private String parecer;

    public ParecerTecnico() {
    }

    public ParecerTecnico(String nome, String equipamento, String defeito, String parecer) {
        this.nome = nome;
        this.equipamento = equipamento;
        this.defeito = defeito;
        this.parecer = parecer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public String getParecer() {
        return parecer;
    }

    public void setParecer(String parecer) {
        this.parecer = parecer;
    }
}
