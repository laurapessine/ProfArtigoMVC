package br.ufscar.dc.dsw;

import br.ufscar.dc.dsw.dao.IArtigoDAO;
import br.ufscar.dc.dsw.dao.IProfessorDAO;
import br.ufscar.dc.dsw.domain.Artigo;
import br.ufscar.dc.dsw.domain.Professor;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProfArtigoMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfArtigoMvcApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(IProfessorDAO professorDAO, IArtigoDAO artigoDAO) {
		return (args) -> {

			Professor p1 = new Professor();
			p1.setNome("Delano Medeiros Beder");
			p1.setEmail("delano@ufscar.br");
			p1.setTitulacao("Doutorado");
			p1.setFoto("https://servicosweb.cnpq.br/wspessoa/servletrecuperafoto?tipo=1&id=K4790683Y6");
			p1.setLattes("http://lattes.cnpq.br/5845245549777383");
			professorDAO.save(p1);

			Professor p2 = new Professor();
			p2.setNome("Helena de Medeiros Caseli");
			p2.setEmail("helenacaseli@ufscar.br");
			p2.setTitulacao("Pós-Doutorado");
			p2.setFoto("https://servicosweb.cnpq.br/wspessoa/servletrecuperafoto?tipo=1&id=K4764535U1");
			p2.setLattes("http://lattes.cnpq.br/6608582057810385");
			professorDAO.save(p2);

			Professor p3 = new Professor();
			p3.setNome("Mário César San Felice");
			p3.setEmail("felice@ufscar.br");
			p3.setTitulacao("Pós-Doutorado");
			p3.setFoto("https://servicosweb.cnpq.br/wspessoa/servletrecuperafoto?tipo=1&id=K4559326J1");
			p3.setLattes("http://lattes.cnpq.br/0452415038078829");
			professorDAO.save(p3);
			
			Artigo a1 = new Artigo();
			a1.setTitulo("Exact approaches for the Minimum Subgraph Diameter Problem");
			a1.setResumo("Este trabalho aborda o Minimum Subgraph Diameter Problem (MSDP), propondo um modelo de programação inteira mista (MILP) e novas estratégias exatas para encontrar subgrafos com diâmetro mínimo sob restrição de custo. Os resultados mostram a eficácia das abordagens propostas.");
			a1.setAnoPublicacao(2022);
			a1.setAutores(List.of(p3));
			artigoDAO.save(a1);

			Artigo a2 = new Artigo();
			a2.setTitulo("Classificação da qualidade da argumentação em tweets no domínio da política brasileira.");
			a2.setResumo("Este artigo avalia a qualidade da argumentação em tweets políticos em português do Brasil, utilizando algoritmos tradicionais de aprendizado de máquina e modelos neurais (BERTimbau e RobertaTwitterBR). Os resultados mostram que o BERTimbau, após ajuste fino, obteve a melhor precisão, destacando a relevância do estudo para a avaliação automática de argumentos em português.");
			a2.setPalavrasChave("avaliação da qualidade da argumentação, tweet, BERT, política brasileira");
			a2.setAnoPublicacao(2023);
			a2.setAutores(List.of(p2));
			artigoDAO.save(a2);

			Artigo a3 = new Artigo();
			a3.setTitulo("Computação em Nuvem e Big Data"); // fictício!
			a3.setResumo("Uma análise sobre a sinergia entre Cloud e Big Data.");
			a3.setAnoPublicacao(2025);
			a3.setAutores(List.of(p1, p2, p3));
			artigoDAO.save(a3);
		};
	}
}