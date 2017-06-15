import java.util.Scanner;

public class Biblioteca {
	private static Scanner sc;
	public static void main(String[] args) {
	
		sc = new Scanner(System.in);
		String[][] livros; // variável principal que contem todos os livros.
		int quantLivros, i=0;
		String nomeLivro;
		
		System.out.print("Digite a quantidade de livros existentes em sua biblioteca: ");
		quantLivros = sc.nextInt();
		System.out.println("Próximo passo: Cadastrar seus livros\n");
		sc.nextLine();  // Consume newline left-over
		livros = new String[quantLivros][4];
		
		// Cadastro inicial dos livros
		while(1==1) { // loop infinito
			String[] livro = criarLivro();
			nomeLivro = livro[0];
			
			// Verifica se o livro já foi cadastrado (procurando por nome)
			if (existePorTitulo(livros, nomeLivro) > -1) {
				System.out.println("Livro " + livro[0] + " Já cadastrado");
				continue; // volta para o inicio do loop
			} else {
				livros[i] = livro;
			}
			
			i++; // incremento do livro
			if (i == quantLivros) break; // se chegou a qtd de livros, sai do loop
		}
		
		int op = 0;
		
		do {
			
			gerarMenu();
			op = sc.nextInt();
			if (op == 1) {
				System.out.println("Procurar livro");
				procurar(livros);
			} else if (op == 2) {
				System.out.println("Emprestar livro");
				emprestar(livros);
			} else if (op == 3) {
				System.out.println("Devolver livro");
				devolver(livros);
			} else if (op == 4) {
				System.out.println("Ver todos os livros");
				imprimir(livros);
			} else if (op == 0) {
				System.out.println("Saindo");
			} else {
				System.out.println("Escolha uma opção correta!");
			}
			
		} while (op != 0);
		
	}
	
	public static void gerarMenu() {
		
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println("1 - Procurar livros");
		System.out.println("2 - Emprestar livros");
		System.out.println("3 - Devolver livros");
		System.out.println("4 - Ver todos os livros");
		System.out.println("0 - Sair");
		System.out.println("-----------------------------------");
		System.out.print("Digite uma dessas opções: ");
		
	}
	
	/*
	 * Método para criar um livro
	 * */
	public static String[] criarLivro() {
		
		String nome, autor, status, pessoa ;
		String[] livro = new String[4];
			
		System.out.print("Digite o título do livro: ");
		nome = sc.nextLine();
		System.out.print("Digite o autor desse livro: ");
		autor = sc.nextLine();
		System.out.print("Digite o status desse livro: ");
		status = sc.nextLine();
		
		livro[0] = nome.trim(); // .trim() Removendo Espaço em branco no inicio e fim da String
		livro[1] = autor.trim(); 
		livro[2] = status.trim(); 
		livro[3] = "";
		
		return livro;
	}
	
	/*
	 * Questão 1: Emprestar Livro
	 * */
	public static void procurar(String[][] livros) {
		
		int op = 0;
		
		
		do {
			
			op = menuProcurar();
			
			if (op == 1) {
				System.out.println("\nProcurar livro por título");
				procurarTitulo(livros);
			} else if (op == 2) {
				System.out.println("\nProcurar livro por autor");
				procurarAutor(livros);
			} else if (op == 3) {
				System.out.println("\nExibir todos os livros disponíveis");
				exibirDisponivel(livros);
			} else if (op == 0) {
				System.out.println("Saindo");
				break;
			} else {
				System.out.println("Escolha uma opção correta!");
			}
			
		} while (op != 0);
		
	}
	
	public static int menuProcurar() {
	
		Scanner sc = new Scanner(System.in);
		int op;
		
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println("1 - Procurar livro por título");
		System.out.println("2 - Procurar livro por autor");
		System.out.println("3 - Exibir todos os livros disponíveis");
		System.out.println("0 - Sair");
		System.out.println("-----------------------------------");
		System.out.print("Escolha uma dessas opções: ");
		
		op = sc.nextInt();
		return op;
		
	}
	
	public static void procurarTitulo(String[][] livros) {

		String busca;
		System.out.print("Digite o título do livro: ");
		busca = sc.next().trim(); // removendo do texto os caracteres em branco do inicio e fim do texto 
		System.out.println();
		
		for (int i = 0; i < livros.length; i++) {
		
			if (livros[i][0].equals(busca)) {
				exibirLivro(livros[i]);
				return;
			}
			
		}
		
		System.out.println("Livro não encontrado!");
		
	}
	
	public static void procurarAutor(String[][] livros) {
	
		String busca;
		int contador = 0;
		System.out.print("Digite o autor do(s) livro(s): ");
		busca = sc.next().trim(); // removendo do texto os caracteres em branco do inicio e fim do texto 
		System.out.println();
		
		for (int i = 0; i < livros.length; i++) {
			
			if (livros[i][1].equals(busca)) {
				exibirLivro(livros[i]);
				contador++;
			}			
		}
		
		if (contador == 0) {
			System.out.println("Livro não encontrado!");
		}
	}
	
	public static void exibirDisponivel(String[][] livros) {
		
		System.out.println("Nome\t\t" + "Autor\t\t" + "Status\t\t" + "Pessoa\t\t");
		
		for (int i = 0; i < livros.length; i++) {
			
			if (livros[i][2].equalsIgnoreCase("DISPONIVEL")) {
				imprimirLivro(livros[i]);
			}
		}
		
	}
	
	/*
	 * Questão 2: Emprestar Livro
	 * */
	public static void emprestar(String[][] livros) {
		
		String titulo, nome;
		int indice;
		sc.nextLine();  // Consume newline left-over
		System.out.println();
		System.out.print("Digite o título do livro que vai ser emprestado: ");
		titulo = sc.nextLine();
		System.out.print("Digite o nome da pessoa que vai pegar esse livro: ");
		nome = sc.nextLine();
		
		indice = existePorTitulo(livros, titulo);
		
		if (indice == -1) {
			System.out.println("Livro não existe!");
			return;
		}
		
		if (livros[indice][2].equalsIgnoreCase("EMPRESTADO")) {
			System.out.println("Livro não disponível!");
			return;
		}
		
		livros[indice][2] = "emprestado";
		livros[indice][3] = nome;
		System.out.println("Livro " + titulo + " EMPRESTADO com sucesso!");
		
	}
	
	/*
	 * Questão 3: Devolver Livro
	 * */
	public static void devolver(String[][] livros) {
		
		String titulo;
		int indice;
		sc.nextLine();  // Consume newline left-over
		System.out.println();
		System.out.print("Digite o título do livro que vai ser emprestado: ");
		titulo = sc.nextLine();
		

		indice = existePorTitulo(livros, titulo);
		
		if (indice == -1) {
			System.out.println("Livro não existe!");
			return;
		}
		
		if (livros[indice][2].equalsIgnoreCase("DISPONIVEL")) {
			System.out.println("Livro não esta EMPRESTADO!");
			return;
		}
		
		livros[indice][2] = "disponivel";
		livros[indice][3] = "";
		System.out.println("Livro " + titulo + " DEVOLVIDO com sucesso!");
		
	}
	
	/*
	 * Questão 4: Ver todos os livros
	 * */
	public static void imprimir(String[][] livros) {
		int op;
		
		System.out.println("Título\t\t" + "Autor\t\t" + "Status\t\t" + "Pessoa\t\t");
		
		for (int i = 0; i < livros.length; i++) {
			
				imprimirLivro(livros[i]);
		}		
	}
	
	public static int menuImprimir () {
		
		int op;
		
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println("1 - Ver todos os livros disponíveis");
		System.out.println("2 - Ver todos os livros emprestados");
		System.out.println("0 - Sair");
		System.out.println("-----------------------------------");
		System.out.print("Escolha uma dessas opções: ");
		
		op = sc.nextInt();
		return op;
		
	}
	
	
	/*
	 * Métodos auxiliares
	 * */

	public static int existePorTitulo(String[][] livros, String titulo) {
		int indice = -1;
		
		for (int i = 0; i < livros.length; i++) {
			
			if (livros[i][0] == null) {
				continue; // volta para o início do for
			}
			// Veficica se o livro já esta cadastrado
			if (livros[i][0].equals(titulo.trim())) {
				indice = i;
				break;
			}
		}
		
		return indice;
	}

	
	public static void exibirLivro(String[] livro) {
		
		System.out.println("Título: " + livro[0]);
		System.out.println("Autor: " + livro[0]);
		System.out.println("Status: " + livro[2]);
		System.out.println("Pessoa: " + livro[3] + "\n");
	}
	
	public static void imprimirLivro(String[] livro) {
				
		System.out.print(livro[0] + "\t\t" + livro[1] + "\t\t" + livro[2] + "\t\t" + livro[3] + "\r\n"); // [Robertha]: melhorar a tabulação. Apagar comentário
	}
	
}
