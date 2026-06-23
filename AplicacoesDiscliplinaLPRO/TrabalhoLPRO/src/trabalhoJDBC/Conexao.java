package trabalhoJDBC; 
// Define o pacote onde a classe está. Serve para organizar o código do projeto.

import java.sql.Connection;
import java.sql.DriverManager;
// Importa classes da biblioteca JDBC (Java Database Connectivity).
// - Connection: representa uma conexão aberta com o banco de dados.
// - DriverManager: é quem cria e gerencia as conexões com o banco.

public class Conexao {
	// Classe responsável por abrir e fechar conexões com o banco de dados PostgreSQL.

	public static Connection abrir() {
		// Método que abre a conexão com o banco.
		// É "static" porque pode ser chamado diretamente pela classe (Conexao.abrir()) 
		// sem precisar criar um objeto "new Conexao()".
		// Retorna um objeto do tipo Connection, que representa a conexão aberta.

		// Informações para acessar o banco de dados
		String usuario = "postgres";      // Usuário do banco (padrão do PostgreSQL)
		String senha = "1234";            // Senha do banco
		String server = "localhost:5432"; // Endereço do servidor e porta (5432 é padrão do PostgreSQL)
		String banco = "Loja";            // Nome do banco de dados
		// Essas variáveis guardam os dados necessários para montar o endereço de conexão.

		// Monta a URL completa de conexão JDBC
		String url = "jdbc:postgresql://" + server + "/" + banco;
		// "jdbc:postgresql://" → indica que será usada uma conexão com o PostgreSQL.
		// A URL completa ficará assim: jdbc:postgresql://localhost:5432/Loja

		Connection conn = null; 
		// Cria a variável que vai guardar o objeto da conexão (inicialmente vazia/null).

		try {
			// Bloco try tenta executar o código que pode gerar erro.
			// Aqui, pode dar erro se o banco não existir, estiver desligado, ou a senha estiver errada.

			conn = DriverManager.getConnection(url, usuario, senha);
			// Usa o DriverManager para abrir a conexão com o banco, 
			// passando a URL, o nome de usuário e a senha.

			return conn;
			// Se deu tudo certo, retorna o objeto Connection (conexão aberta) 
			// para a classe que chamou este método.

		} catch (Exception e) {
			// Se der erro em qualquer parte do try, o catch é executado.

			System.err.println("Erro ao abrir conexão: " + e.getMessage());
			// Mostra no console a mensagem de erro (em vermelho, por usar System.err).
			// e.getMessage() mostra o texto do erro retornado pelo Java (ex: senha incorreta).
		}

		return null;
		// Se der erro, o método retorna null, indicando que a conexão não foi aberta.
	}

	// -------------------------------------------------------
	// MÉTODO PARA FECHAR A CONEXÃO
	// -------------------------------------------------------

	public static void fechar(Connection conn) {
		// Método responsável por fechar a conexão com o banco.
		// Também é "static", assim pode ser chamado diretamente (Conexao.fechar(conn)).

		if (conn != null) {
			// Verifica se a conexão existe (não é nula).
			// Isso evita tentar fechar algo que não foi aberto.

			try {
				conn.close();
				// Fecha a conexão com o banco de dados.
				// Isso é essencial para liberar recursos da memória e evitar travamentos.

			} catch (Exception e) {
				// Se der erro ao tentar fechar (por exemplo, a conexão já foi encerrada),
				// o catch é executado.

				System.err.println("Erro ao fechar conexão: " + e.getMessage());
				// Mostra no console o erro ocorrido ao fechar a conexão.
			}
		}
		// Se a conexão for nula, o método simplesmente não faz nada.
	}
	// Fim do método fechar()
}
// Fim da classe Conexao
