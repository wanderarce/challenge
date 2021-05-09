## Projeto Meta Backend

### Configurações

	* Mavem
	* JDK: 1.8.0_211
	* IDE utilizada: Spring Tools Suite
	
### Estrutura

	* O projeto foi divididos nos seguintes packages tendo como raiz br.com.wander.meta.challenge:
		* config: Responsável pelas Class de configurações do projeto tendo apenas o tratamento de Cors;
		* controllers: possui todas as Class responsáveis pela disponibilização e execução dos endpoints;
		* entities: contêm as Class de Modelos com o Hibernate; 
		* erros: Class com responsabilidades de tratamento de exceções
		* repositories: Camada contendo as interfaces para controle de persistencia de dados 
		* services: Camada de controle das regras de negócio
		
### Intruções para execução

	* H2 file: spring.datasource.url=jdbc:h2:file:C:/temp/test (Utilizei Windows)
	* Execução do projeto pelo Spring Tools Suite: Importar o projeto e executar a Class ChallengeApplication disponibilizada no pacote br.com.wander.meta.challenge;
	* Execução via terminal: navegar até a pasta do projeto e exceutar o cmd mvnw spring-boot:run
	