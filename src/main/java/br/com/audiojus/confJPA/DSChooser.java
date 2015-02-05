package br.com.audiojus.confJPA;

import java.net.UnknownHostException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class DSChooser {

	@Autowired
	@Qualifier("dataSourceTeste")
	private DataSource teste;
	@Autowired
	@Qualifier("dataSourceProducao")
	private DataSource producao;
	@Autowired
	Environment env;

	@Bean(name = "dataSourceEscolhido")
	public DataSource getDs() {
		String[] activeProfiles = env.getActiveProfiles();
		if (activeProfiles == null || activeProfiles.length == 0
				|| activeProfiles[0].equalsIgnoreCase("producao"))
			return producao;
		else
			return teste;
	}
}
