package br.com.cwi.utils;

import java.io.FileWriter;
import java.io.IOException;

public class EscreveArquivo {

  private static String caminho = "C:/Users/Eshi/Downloads/gatling-load-tests-template-workshop-develop-d759f9b3dffe62bd03e37358b9b81c25f7b875ed/src/src/test/resources/bodies/login/produto.json";

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
