import java.util.Scanner;

public class Biblioteca {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		String[][] livros;
		int quantLivros;
		String nome, autor, status, pessoa;
		
		System.out.print("Digite a quantidade de livros existentes em sua biblioteca: ");
		quantLivros = sc.nextInt();
		System.out.println("Próximo passo: Cadastrar seus livros\n");
		
		livros = new String[quantLivros][4];
		
		for (int i = 0; i < livros.length; i++) {
		
//			if (i == 0) {
				System.out.print("Digite o nome do livro " + (i+1) +": ");
				nome = sc.nextLine();
				sc.nextLine();  // Consume newline left-over
				System.out.print("Digite o autor desse livro: ");
				autor = sc.nextLine();
				
				System.out.print("Digite o status desse livro: ");
				status = sc.nextLine();
				
				System.out.print("Digite o nome da pessoa que pegou esse livro: ");
				pessoa = sc.nextLine();
				
				livros[i][0] = nome.toUpperCase();
				livros[i][1] = autor.toUpperCase();
				livros[i][2] = status.toUpperCase();
				livros[i][3] = pessoa.toUpperCase();
				
				System.out.println("Livro " + (i+1) + " cadastrado!");
				
//			} else {
//				String resposta;
//				System.out.println("Quer cadastrar mais um livro? Responda SIM ou NÃO");
//				resposta = sc.next();
//				
//				if (resposta.equalsIgnoreCase("SIM")) {
//					cadastrar(livros);
//				} else if (resposta.equalsIgnoreCase("N�O")) {
//					int restante = livros.length - i;
//					System.out.println("Existe(m) " + restante + " livro(s) não cadastrado(s).");
//				} else {
//					System.out.println("Digite uma op��o v�lida!");
//				}
//				
//			}
			
		}
		
		int op = 0;
		
		do {
			
			op = gerarMenu();
			
			if (op == 1) {
				System.out.println("Cadastrar livros");
				cadastrar(livros);
			} else if (op == 2) {
				System.out.println("Procurar livro");
				procurar(livros);
			} else if (op == 3) {
				System.out.println("Emprestar livro");
				livros = emprestar(livros);
			} else if (op == 4) {
				System.out.println("Devolver livro");
				livros = devolver(livros);
			} else if (op == 5) {
				System.out.println("Ver todos os livros");
				imprimir(livros);
			} else if (op == 6) {
				System.out.println("Ver os relat�rios");
				relatorios(livros);
			} else if (op == 0) {
				System.out.println("Saindo");
				break;
			} else {
				System.out.println("Escolha uma op��o correta!");
			}
			
		} while (op == 0);
		
	}
	
	public static int gerarMenu() {
	
		Scanner sc = new Scanner(System.in);
		int op;
		
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println("1 - Cadastrar livros");
		System.out.println("2 - Procurar livros");
		System.out.println("3 - Emprestar livros");
		System.out.println("4 - Devolver livros");
		System.out.println("5 - Ver todos os livros");
		System.out.println("6 - Ver os relat�rios");
		System.out.println("0 - Sair");
		System.out.println("-----------------------------------");
		System.out.print("Digite uma dessas op��es: ");
		
		op = sc.nextInt();
		return op;
		
	}
	
	public static void cadastrar(String[][] livros) {
		
		Scanner sc = new Scanner(System.in);
		String nome, autor, status, pessoa;
		
		for (int i = 1; i < livros.length; i++) {
			
			System.out.print("Digite o nome do " + (i+1) + "� livro: ");
			nome = sc.next();
			System.out.print("Digite o autor desse livro: ");
			autor = sc.next();
			System.out.print("Digite o status desse livro: ");
			status = sc.next();
			System.out.print("Digite o nome da pessoa que pegou esse livro: ");
			pessoa = sc.next();
			
			livros[i][0] = nome.toUpperCase();
			livros[i][1] = autor.toUpperCase();
			livros[i][2] = status.toUpperCase();
			livros[i][3] = pessoa.toUpperCase();
			
			int diminuir = i - 1;
			
			if (livros[i][0].equalsIgnoreCase(nome)) {
				if(livros[i][0].equalsIgnoreCase(livros[diminuir][0])) {
					System.out.println("O livro j� foi cadastrado!");
				} else {
					System.out.println("Livro cadastrado!");
				}
			}
		}
	}
	
	public static void procurar(String[][] livros) {
		
		int op = 0;
		
		
		do {
			
			op = menuProcurar();
			
			if (op == 1) {
				System.out.println("\nProcurar livro por t�tulo");
				procurarTitulo(livros);
			} else if (op == 2) {
				System.out.println("\nProcurar livro por autor");
				livros = procurarAutor(livros);
			} else if (op == 3) {
				System.out.println("\nExibir todos os livros dispon�veis");
				livros = exibirDisponivel(livros);
			} else if (op == 0) {
				System.out.println("Saindo");
				break;
			} else {
				System.out.println("Escolha uma op��o correta!");
			}
			
		} while (op == 0);
		
	}
	
	public static int menuProcurar() {
	
		Scanner sc = new Scanner(System.in);
		int op;
		
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println("1 - Procurar livro por t�tulo");
		System.out.println("2 - Procurar livro por autor");
		System.out.println("3 - Exibir todos os livros dispon�veis");
		System.out.println("0 - Sair");
		System.out.println("-----------------------------------");
		System.out.print("Escolha uma dessas op��es: ");
		
		op = sc.nextInt();
		return op;
		
	}
	
	public static void procurarTitulo(String[][] livros) {
	
		Scanner sc = new Scanner(System.in);
		String busca;
		System.out.print("Digite o nome do livro: ");
		busca = sc.next();
		System.out.println();
		
		for (int i = 0; i < livros.length; i++) {
		
			if (livros[i][0].equalsIgnoreCase(busca)) {
				System.out.println("Nome: " + livros[i][0]);
				System.out.println("Autor: " + livros[i][1]);
				System.out.println("Status: " + livros[i][2]);
				System.out.println("Pessoa: " + livros[i][3] + "\n");
				return;
			}
			
		}
		
		System.out.println("Livro n�o encontrado!");
		
	}
	
	public static String[][] procurarAutor(String[][] livros) {
	
		Scanner sc = new Scanner(System.in);
		String busca;
		System.out.print("Digite o autor do(s) livro(s): ");
		busca = sc.next();
		System.out.println();
		
		for (int i = 0; i < livros.length; i++) {
			
			String autor = livros[i][1];
			
			if (livros[i][1].equalsIgnoreCase(busca)) {
				if (livros[i][1].equalsIgnoreCase(autor)){
					System.out.println("Nome: " + livros[i][0]);
					System.out.println("Autor: " + autor);
					System.out.println("Status: " + livros[i][2]);
					System.out.println("Pessoa: " + livros[i][3] + "\n");
			} else {
				System.out.println("Livro n�o encontrado!");
				return livros;
			}
			
			}
			
		}
		
		return livros;
		
	}
	
	public static String[][] exibirDisponivel(String[][] livros) {
		
		System.out.println("Nome\t\t" + "Autor\t\t" + "Status\t\t" + "Pessoa\t\t");
		
		for (int i = 0; i < livros.length; i++) {
			
			if (livros[i][2].equalsIgnoreCase("DISPONIVEL")) {
				System.out.print(livros[i][0] + "\t\t");
				System.out.print(livros[i][1] + "\t\t" + livros[i][2] + "\t\t" + livros[i][3]);
				System.out.println();
			}
			
		}
		
		return livros;
		
	}
	
	public static String[][] emprestar(String[][] livros) {
		
		Scanner sc = new Scanner(System.in);
		String entrada, pessoa;
		System.out.println();
		System.out.print("Digite o nome do livro que vai ser emprestado: ");
		entrada = sc.next();
		System.out.print("Digite o nome da pessoa que vai pegar esse livro: ");
		pessoa = sc.next();
		String nome = pessoa;
		
		
		for (int i = 0; i < livros.length; i++) {

				if (livros[i][0].equalsIgnoreCase(entrada)) {
						
					if (livros[i][2].equalsIgnoreCase("EMPRESTADO")) {
						System.out.println("Livro n�o dispon�vel! Escolha outro!");
					} else {
						
						if (livros[i][3].equalsIgnoreCase(pessoa)) {
							
							pessoa = "1";
							int vezes = Integer.parseInt(pessoa);
							
							
							if (vezes < 4) {
								livros[i][2] = "EMPRESTADO";
								livros[i][3] = nome;
								System.out.println("Livro Emprestado!");
								System.out.println("Essa pessoa pegou " + "livro(s)");
							} else {
								System.out.println("");
							}
						}
								
					}
						
					return livros;
						
				}
				
			
			
		}
		
		System.out.println("Livro n�o encontrado!");
		return livros;
		
	}
	
	public static String[][] devolver(String[][] livros) {
		
		Scanner sc = new Scanner(System.in);
		String entrada;
		System.out.println();
		System.out.print("Digite o nome do livro que vai ser devolvido: ");
		entrada = sc.next();
		
		for (int i = 0; i < livros.length; i++) {
		
			if (livros[i][0].equalsIgnoreCase(entrada)) {
				
				if (livros[i][2].equalsIgnoreCase("DISPONIVEL")) {
					System.out.println("Livro n�o est� emprestado!");
				} else {
					livros[i][2] = "DISPONIVEL";
					livros[i][3] = " - ";
					System.out.println("Livro devolvido!");
				}
				
				return livros;
				
			}
			
		}
		
		System.out.println("Livro n�o encontrado!");
		return livros;
		
	}
	
	public static String[][] imprimir(String[][] livros) {
		
		System.out.println("Nome\t\t" + "Autor\t\t" + "Status\t\t" + "Pessoa");
		
		for (int i = 0; i < livros.length; i++) {
			System.out.print(livros[i][0] + "\t\t");
			System.out.print(livros[i][1] + "\t\t" + livros[i][2] + "\t\t" + livros[i][3]);
			System.out.println();
		}
		
		return livros;
		
	}
	
	public static void relatorios(String[][] livros) {
	
		int op = 0;
		
		do {
		
			op = menuRelatorio();
			
			if (op == 1) {
				System.out.println("Ver todos os livros dispon�veis\n");
				livroDisponivel(livros);
			} else if (op == 2) {
				System.out.println("Ver todos os livros emprestados\n");
				livroEmprestado(livros);
			} else if (op == 3) {
				System.out.println("Ver a quantidade de livros n�o cadastrados\n");
				livroNaoCadastrado(livros);
			} else if (op == 0) {
				System.out.println("Saindo");
				break;
			} else {
				System.out.println("Escolha uma op��o correta!");
			}
				
		} while (op == 0);
		
	}
	
	public static int menuRelatorio () {
		
		Scanner sc = new Scanner(System.in);
		int op;
		
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println("1 - Ver todos os livros dispon�veis");
		System.out.println("2 - Ver todos os livros emprestados");
		System.out.println("3 - Ver a quantidade de livros n�o cadastrados");
		System.out.println("0 - Sair");
		System.out.println("-----------------------------------");
		System.out.print("Escolha uma dessas op��es: ");
		
		op = sc.nextInt();
		return op;
		
	}
	
	public static String[][] livroDisponivel (String[][] livros) {
			
		for (int i = 0; i < livros.length; i++) {
			if (livros[i][2].equalsIgnoreCase("DISPONIVEL")) {
				System.out.println("Existe(m) " + livros[i][2] + " livro(s) com esse status.");	
			}
		
		}
		return livros;
		
	}
	
	public static String[][] livroEmprestado (String[][] livros) {
	
		for (int i = 0; i < livros.length; i++) {
		
			if (livros[i][2].equalsIgnoreCase("EMPRESTADO")) {
				System.out.println("Existe(m) " + i + " livro(s) com esse status.");
			}
		
		}
	
		return livros;
		
	}
	
	public static String[][] livroNaoCadastrado (String[][] livros) {
		
		for (int i = 0; i < livros.length; i++) {
			int restante = livros.length - (i + 1);
			System.out.println("Existe(m) " + restante + " livros n�o cadastrados");	
		}
		
		return livros;
		
	}
	
}
