package br.com.cwi;

import com.microsoft.aad.msal4j.*;

import java.util.Collections;
import java.util.Set;

public class ADClient {

  public static IAuthenticationResult acquireTokenUsernamePassword(String email, String password, String authority, String clientId, String scope) throws Exception {
    TokenCacheAspect tokenCacheAspect = new TokenCacheAspect("sample_cache.json");
    Set<String> SCOPE = Collections.singleton(scope);

    PublicClientApplication pca = PublicClientApplication.builder(clientId)
      .b2cAuthority(authority)
      .setTokenCacheAccessAspect(tokenCacheAspect)
      .build();

    IAuthenticationResult result;
    try {
      // Carrega as informações do cache
      Set<IAccount> accountsInCache = pca.getAccounts().join();
      IAccount account = accountsInCache.iterator().next();

      SilentParameters silentParameters =
        SilentParameters
          .builder(SCOPE, account)
          .build();

      //Tenta buscar o token usando a autenticação do cache, se existir e ainda for válida
      result = pca.acquireTokenSilently(silentParameters).join();
    } catch (Exception ex) {
      UserNamePasswordParameters parameters = UserNamePasswordParameters.builder(SCOPE, email, password.toCharArray()).build();

      // Tenta autenticação com usuario e senha
      result = pca.acquireToken(parameters).join();
    }
    return result;
  }
}


