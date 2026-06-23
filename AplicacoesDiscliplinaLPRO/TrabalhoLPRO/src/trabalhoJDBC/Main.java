package trabalhoJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int opcao = 0;
		do {
			System.out.println("1 - Consultar todos produtos");
			System.out.println("2 - Inserir um novo produto");
			System.out.println("3 - Atualizar um produto");
			System.out.println("4 - Remover um produto");
			System.out.println("5 - Sair");
			opcao = in.nextInt();
			
			// ======== OPÇÃO 1: LISTAR PRODUTOS ========
			if (opcao == 1) {
				System.out.println("Listagem de produto");
				Connection conn = null;
				try {
					// "try" é um bloco que tenta executar um trecho de código que pode dar erro.
					// Se der erro (por exemplo, problema na conexão com o banco), ele será tratado no "catch".
					
					String sql = "Select * from Produto";
					conn = Conexao.abrir(); // abre conexão com o banco
					
					// PreparedStatement é uma forma mais segura e eficiente de executar comandos SQL.
					// Ele evita erros de sintaxe e protege contra SQL Injection (ver explicação abaixo).
					PreparedStatement pstm = conn.prepareStatement(sql);
					
					ResultSet rs = pstm.executeQuery(); // executa a consulta e retorna os resultados
					
					while (rs.next()) {
						int id = rs.getInt("id");
						String nome_produto = rs.getString("nome");
						float valor = rs.getFloat("valor");
						System.out.println(id + " - nome:" + nome_produto + " valor: " + valor);
					}
					
				} catch (Exception e) {
					// "catch" captura o erro que ocorreu no bloco "try"
					// e permite tratar de forma amigável, sem travar o programa.
					System.out.println("Deu ruim: " + e.getMessage());
				} finally {
					// "finally" é executado sempre, mesmo se der erro ou não.
					// Aqui é usado para garantir que a conexão com o banco seja fechada.
					Conexao.fechar(conn);
				}
				
			// ======== OPÇÃO 2: INSERIR PRODUTO ========
			} else if (opcao == 2) {
				System.out.println("Digite o nome do novo produto:");
				String nome_produto = in.next();
				System.out.println("Digite o valor do novo produto :");
				float valor = in.nextFloat();
				
				// O "?" é um espaço reservado que será substituído por valores seguros.
				// Isso evita o risco de SQL Injection.
				String sql = "Insert into Produto (nome,valor) values (?,?)";
				Connection conn = null;
				
				try {
					conn = Conexao.abrir();
					
					// PreparedStatement evita SQL Injection.
					// SQL Injection é quando um usuário malicioso tenta "injetar" comandos SQL
					// no input para danificar ou roubar dados do banco.
					// Exemplo de ataque: digitar algo como "'; DROP TABLE Produto; --"
					// O PreparedStatement impede isso, pois ele trata o valor como texto comum.
					PreparedStatement statement = conn.prepareStatement(sql);
					
					// Aqui, cada "?" do SQL é substituído de forma segura.
					statement.setString(1, nome_produto); // substitui o primeiro "?" pelo nome
					statement.setFloat(2, valor);         // substitui o segundo "?" pelo valor
					
					// Executa o comando SQL no banco de dados
					statement.execute();
					
					System.out.println("Cadastro com Sucesso");
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					Conexao.fechar(conn);
				}
			}	
		// ==========================================
// OPÇÃO 3 → ATUALIZAR PRODUTO
// ==========================================
else if (opcao == 3) {
    try {
        // ---------- PRIMEIRO TRY ----------
        // Este bloco try serve para capturar ERROS DE ENTRADA DO USUÁRIO.
        // Ou seja, se o usuário digitar letras em vez de números, por exemplo.

        System.out.print("Digite o ID do produto que deseja atualizar: ");
        int id = in.nextInt(); // pode gerar erro se o usuário digitar algo não numérico

        System.out.print("Digite o novo nome do produto: ");
        String novoNome = in.next(); // lê o novo nome

        System.out.print("Digite o novo valor do produto: ");
        float novoValor = in.nextFloat(); // lê o novo valor

        // Aqui montamos o comando SQL para atualizar o produto no banco.
        String sql = "UPDATE Produto SET nome = ?, valor = ? WHERE id = ?";
        // Os "?" são espaços reservados (placeholders) que serão substituídos por valores reais.
        // Isso é mais seguro e evita ataques de SQL Injection.

        Connection conn = null; // variável que guardará a conexão com o banco

        try {
            // ---------- SEGUNDO TRY ----------
            // Este bloco try é responsável pela PARTE DO BANCO DE DADOS.
            // Ele tenta abrir a conexão e executar o comando SQL.

            conn = Conexao.abrir(); // abre a conexão com o banco PostgreSQL
            PreparedStatement stmt = conn.prepareStatement(sql);
            // PreparedStatement prepara o comando SQL e permite preencher os "?" de forma segura.

            // Preenche os "?" na ordem que aparecem no SQL
            stmt.setString(1, novoNome);  // substitui o primeiro ? pelo novo nome
            stmt.setFloat(2, novoValor);  // substitui o segundo ? pelo novo valor
            stmt.setInt(3, id);           // substitui o terceiro ? pelo ID

            // Executa o comando SQL e retorna o número de linhas afetadas
            int linhasAfetadas = stmt.executeUpdate();

            // Verifica se algum produto foi realmente atualizado
            if (linhasAfetadas > 0) {
                System.out.println("✅ Produto atualizado com sucesso!");
            } else {
                System.out.println("⚠️ Nenhum produto encontrado com esse ID.");
            }

        } catch (Exception e) {
            // ---------- CATCH DO SEGUNDO TRY ----------
            // Este catch captura erros que acontecem dentro do bloco de banco de dados.
            // Exemplo: conexão falhou, tabela não existe, erro no SQL etc.
            System.out.println("❌ Erro ao atualizar produto: " + e.getMessage());
        } finally {
            // ---------- FINALLY ----------
            // O bloco "finally" é executado SEMPRE — mesmo se der erro no try ou no catch.
            // Ele é usado para FECHAR a conexão e liberar recursos do banco.
            Conexao.fechar(conn);
        }

    } catch (Exception e) {
        // ---------- CATCH DO PRIMEIRO TRY ----------
        // Este catch captura erros de entrada de dados do usuário.
        // Exemplo: o usuário digitar letras no lugar de números (InputMismatchException).
        System.out.println("⚠️ Entrada inválida. Use apenas números para o ID e o valor.");
        in.nextLine(); // limpa o buffer do Scanner para evitar bugs na próxima leitura
    }


				}

				// ==========================================
				// OPÇÃO 4 → REMOVER PRODUTO
				// ==========================================
				else if (opcao == 4) {
					try {
						System.out.print("Digite o ID do produto que deseja remover: ");
						int id = in.nextInt();

						String sql = "DELETE FROM Produto WHERE id = ?";
						Connection conn = null;

						try {
							conn = Conexao.abrir();
							PreparedStatement stmt = conn.prepareStatement(sql); //Variável do tipo PreparedStatement
																				//Guarda o comando preparado (é o mesmo tipo, só muda o nome da variável)
							stmt.setInt(1, id);

							int linhasAfetadas = stmt.executeUpdate();//Quando você faz um UPDATE, INSERT ou DELETE, o Java pode te informar quantas linhas foram realmente alteradas no banco.
																		//Se o comando funcionar e alterar algo, por exemplo atualizar 1 produto,
						
							if (linhasAfetadas > 0) {
								System.out.println("Produto removido com sucesso!");
							} else {
								System.out.println("Nenhum produto encontrado com esse ID.");
							}
						} catch (Exception e) {
							System.out.println("Erro ao remover produto: " + e.getMessage());
						} finally {
							Conexao.fechar(conn);
						}
					} catch (Exception e) {
						System.out.println("Entrada inválida. O ID deve ser um número.");
						in.nextLine();
					}
				}

			} while (opcao != 5); // repete o menu até escolher sair

			System.out.println("Programa encerrado. Até mais!");
			in.close(); // fecha o Scanner
		}
}
