package br.com.cwi.model;

import java.util.Random;
import java.util.UUID;

public class Produto {

  public String nome;
  public int preco;
  public int quantidade;
  public String descricao;

  public static Produto criaProduto() {

    Produto p = new Produto();

    p.nome = UUID.randomUUID().toString();
    p.preco = new Random().nextInt(5000);
    p.quantidade = new Random().nextInt(20);
    p.descricao = UUID.randomUUID().toString();
    return p;
  }

}
