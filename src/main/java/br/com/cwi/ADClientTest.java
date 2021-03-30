package br.com.cwi;

public class ADClientTest {

  public static void main(String args[]) throws Exception {

    String token = ADClient.acquireTokenUsernamePassword(
      "load-test@gmail.com",
      "123qweasd",
      "https://b2c.b2clogin.com/tfp/b2c.onmicrosoft.com/B2C_1_ROPC/",
      "4e5df32d-dc19-40f6-bdee-a88e2faaba5e",
      "4e5df32d-dc19-40f6-bdee-a88e2faaba5e")
    .accessToken();

    System.out.println(token);
  }
}


