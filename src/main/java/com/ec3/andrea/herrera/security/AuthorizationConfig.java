package com.ec3.andrea.herrera.security;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private  AuthenticationManager manager;
	 
	@Autowired
	private JwtTokenStore store;
	
	@Autowired
	private JwtAccessTokenConverter accessTokenConverter;	
	

	// Metodo para personalizar el token
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// TODO Auto-generated method stub
		super.configure(security);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

		clients.inMemory()
			.withClient("alumnaherrera")
			.secret(new BCryptPasswordEncoder().encode("alumnaherrera"))
			.authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
			.scopes("read", "write", "trust")
			.accessTokenValiditySeconds(1*60*60)
			.refreshTokenValiditySeconds(5*60*60);
		
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain tokenChain = new TokenEnhancerChain();
		tokenChain.setTokenEnhancers(Arrays.asList(  new TokenEnhancer() {
			
			@Override
			public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
				
				// datos en el cuerpo token
				Map<String, Object> informacionAdicional = new HashMap<>();
				
				informacionAdicional.put("evaluacion", "continua");
				informacionAdicional.put("numero", "EC3-AndreaHerreraHospitalIDAT");
				
				DefaultOAuth2AccessToken token = new DefaultOAuth2AccessToken(accessToken);
				
				token.setAdditionalInformation(informacionAdicional);
				
				return token;
			}
			
		}   ,accessTokenConverter ));
		 
		endpoints.tokenStore(store)
			.authenticationManager(manager)
			.accessTokenConverter(accessTokenConverter)
			.tokenEnhancer(tokenChain);
	}

	
}
