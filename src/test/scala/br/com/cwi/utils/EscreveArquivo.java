package br.com.cwi.utils;

import java.io.FileWriter;
import java.io.IOException;

public class EscreveArquivo {

  private static String caminho = System.getProperty("user.dir").concat("/src/test/resources/bodies/login/produto.json");

  public static void salvaArquivo(String obj) {
    try {
      FileWriter arquivo = new FileWriter(caminho);
      arquivo.write(obj);
      arquivo.close();

    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

  }
}
