package me.dio.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // identificador gerado automaticamente
    private Long id;
    private String name;
    // 1 usuario possui uma conta(onetoOne) - cascade garante que a entidade tenha relacionamento forte. Deleta em conjunto as entidades estando ligadas)
    // Fará com que a tabela de usuário tenha uma chave estrangeira para tabela de conta
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;
    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    // Feature e novidades são listas então o relacionamento é de um para muitos.
    // Fetch = EAGER - Toda vez que buscar o usuário no banco, trará também a lista de features
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Feature> features;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<News> news;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

}