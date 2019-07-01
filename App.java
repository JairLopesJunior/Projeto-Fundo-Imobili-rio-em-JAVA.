import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App 
{
	private static Scanner scan;//static usa sempre que for acessar o main
	
	public static void main( String[] args )
    {
    	Corretora corretora = new Corretora();
    	Fundo fundo = new Fundo();
    	scan = new Scanner(System.in);

		int opcao;
		
		do {
			System.out.println("\nFundo Imobiliario");	
			System.out.println("==================================");	
			System.out.println("1.\t Criar uma conta");	
			System.out.println("**********************************");
			System.out.println("2.\t Encontrar Conta ");
			System.out.println("**********************************");
			System.out.println("3.\t Editar Conta ");
			System.out.println("**********************************");
			System.out.println("4.\t Simular TED ");
			System.out.println("**********************************");
			System.out.println("5.\t Simular Resgate do saldo ");
			System.out.println("**********************************");
			System.out.println("6.\t Consultar Fundos ");
			System.out.println("**********************************");
			System.out.println("7.\t Ver meus Fundos ");
			System.out.println("**********************************");
			System.out.println("8.\t Ver dividendos do mes ");
            System.out.println("**********************************");
            
			System.out.println("0.\t Encerrar sistema");	
			opcao = scan.nextInt();

			if (opcao == 1) {
				Conta conta = new Conta();
				DadosBancario dadosBancarios = new DadosBancario();
				System.out.print("Digite o nome do cliente: ");	
				String nome = scan.next();
				conta.setNome(nome);
				System.out.print("Digite o CPF do cliente (Ex: 000.000.000-00): ");
				String cpfTitular = scan.next();
				conta.setCpfTitular(cpfTitular);
				
				//expressão regular		
				if(conta.getCpfTitularReg() == false) {				
					System.out.println("\n**********************************");
					System.out.print("Digite um CPF Valido: ");	
					System.out.println("\n**********************************");
				}else{
				System.out.print("Digite o nome banco: ");	
				String banco = scan.next();
				dadosBancarios.setBanco(banco);
				System.out.print("Digite a agencia: ");	
				String agencia = scan.next();
				dadosBancarios.setAgencia(agencia);
				System.out.print("Digite o numero da conta: ");	
				int numeroConta = scan.nextInt();	
				dadosBancarios.setNumeroConta(numeroConta);
				System.out.print("Digite o saldo da sua conta: ");	
				int saldo = scan.nextInt();	
				dadosBancarios.setSaldo(saldo);
				conta.setDadosBancario(dadosBancarios);
				Conta contaEncontrada = corretora.encontrar(cpfTitular);
				if(contaEncontrada != null) {
					System.out.println("\n**********************************");
					System.out.println("CPF ja existente");
					System.out.println("\n**********************************");
				}else{
					corretora.add(conta);
					System.out.println("\n**********************************");
					System.out.println("Pessoa Cadastrada com sucesso");
					System.out.println("**********************************");
					}
				}
			}
			
			if (opcao == 2) {
				System.out.println("Informe o seu CPF: ");	
				String cpfTitular = scan.next();
				Conta contaEncontrada = corretora.encontrar(cpfTitular);
				if (contaEncontrada != null) {
					System.out.print("*******************************");
					System.out.print("Nome: ");
					System.out.println(contaEncontrada.getNome());
					System.out.print("CPF: ");
					System.out.println(contaEncontrada.getCpfTitular());
					System.out.print("Banco: ");
					System.out.println(contaEncontrada.getDadosBancario().getBanco());
					System.out.print("Agencia: ");
					System.out.println(contaEncontrada.getDadosBancario().getAgencia());
					System.out.print("Numero da Conta: ");
					System.out.println(contaEncontrada.getDadosBancario().getNumeroConta());
					System.out.print("Saldo Bancario: ");
					System.out.println(contaEncontrada.getDadosBancario().getSaldo());
					System.out.print("Saldo na Corretora: ");
					System.out.println(contaEncontrada.getSaldo());
					System.out.print("*******************************");
				} else {
					System.out.print("*******************************");
					System.out.println("Pessoa nao encontrada");
					System.out.print("*******************************");
				}
			}
			if (opcao == 3) {
				System.out.println("Informe o seu CPF: ");	
				String cpfTitular = scan.next();
				Conta contaEncontrada = corretora.encontrar(cpfTitular);
				if(contaEncontrada != null) {
					System.out.print("Digite o nome do cliente: ");
					String nome = scan.next();
					contaEncontrada.setNome(nome);
					System.out.print("Digite o nome banco: ");	
					String banco = scan.next();
					contaEncontrada.getDadosBancario().setBanco(banco);
					System.out.print("Digite a agencia: ");	
					String agencia = scan.next();
					contaEncontrada.getDadosBancario().setAgencia(agencia);
					System.out.print("Digite o numero da conta: ");	
					int numeroConta = scan.nextInt();	
					contaEncontrada.getDadosBancario().setNumeroConta(numeroConta);
					System.out.println("\n**********************************");
					System.out.println("Pessoa editada com sucesso");
					System.out.println("**********************************");
				}else{
					System.out.println("**********************************");
					System.out.println("Pessoa nao Encontrada");
					System.out.println("**********************************");
				}
			}
			
			if(opcao == 4) {
				System.out.println("Informe o seu CPF: ");	
				String cpfTitular = scan.next();
				Conta contaEncontrada = corretora.encontrar(cpfTitular);
				if(contaEncontrada != null) {
					System.out.print("Informe o valor da transferencia:");
					double valor = scan.nextDouble();
					corretora.realizarTed(contaEncontrada, valor);
				}else {
					System.out.print("*******************************");
					System.out.println("Pessoa nao Encontrada");
					System.out.print("*******************************");
				}
				
			}
			
			if(opcao == 5) {
				System.out.println("Informe o seu CPF: ");	
				String cpfTitular = scan.next();
				Conta contaEncontrada = corretora.encontrar(cpfTitular);
				if(contaEncontrada != null) {
					System.out.print("Quanto voce deseja resgatar do saldo:");
					double rSaldo = scan.nextDouble();
					corretora.resgatarTed(contaEncontrada, rSaldo);
				}else{
					System.out.print("*******************************");
					System.out.println("Pessoa nao Encontrada");
					System.out.print("*******************************");
				}
				
			}
			
			if(opcao == 6) {
				System.out.println();	
				System.out.println("**********************************");
				System.out.println("==============FUNDOS==============");	
				System.out.println("**********************************");
				System.out.println();	
				
				//Ler arquivo Txt					    
				List<Fundo> fundos = corretora.getFundos();
				for (Fundo f : fundos) {
					System.out.println("ID:" + f.getCodigo());
					System.out.println("Descricao: " + f.getDescricao());
					System.out.println("Valor da Cota: " + f.getValorCota());
					System.out.println("Dividendos: " + f.getDividendo());
					System.out.println();
				}
				
				do {
					System.out.println("==================================");	
					System.out.println("1.\t Comprar cotas ");
					System.out.println("**********************************");
					System.out.println("2.\t Vender cotas ");
					System.out.println("**********************************");
					System.out.println("0.\t Voltar para Home");	
					opcao = scan.nextInt();
					
					//busca o cpf
					if(opcao == 1) {
						Fundo fundoss = new Fundo();
						System.out.println("Informe o seu CPF: ");	
						String cpfTitular = scan.next();
						Conta contaEncontrada = corretora.encontrar(cpfTitular);
						
						//se encontrar o cpf, buscar o fundo que deseja comprar
						if(contaEncontrada != null) {
							System.out.println("Informe o ID do fundo que vocÃª deseja comprar:");	
							String Codigo = scan.next();
							Fundo fundoEncontrado = corretora.encontrarCodigo(Codigo);
							
							//se fundo for encontrado, permitir comprar as cotas
							if(fundoEncontrado != null) {
								System.out.println("Informe quantas cotas vocÃª deseja comprar deste fundo:");	
								int qtdeCotas = scan.nextInt();
								
									if(qtdeCotas > 0) {
										fundoEncontrado.setQtde(qtdeCotas);
										double qtdeCotasTotal = qtdeCotas * fundoEncontrado.getValorCota();
										
										if(qtdeCotasTotal <= contaEncontrada.getSaldo()) {
											double saldoCorretora = contaEncontrada.getSaldo();
											saldoCorretora -= qtdeCotasTotal;
											double valorDividendoTotal = qtdeCotas * fundoEncontrado.getDividendo();//10
											double saldoAtualizado = saldoCorretora + valorDividendoTotal;//20
											double dividendos = corretora.getDividendoMensal();//0
											double dividendoGeral = dividendos + valorDividendoTotal;//10
											contaEncontrada.setSaldo(saldoAtualizado);//20
											corretora.setDividendoMensal(dividendoGeral);//10
											contaEncontrada.add(fundoEncontrado);
											System.out.println("\n**********************************");
											System.out.println("Parabens voce acabou de comprar " + qtdeCotas + " cotas do fundo " + fundoEncontrado.getDescricao());
											System.out.println("**********************************");
										}else{
											System.out.println("\n**********************************");
											System.out.println("Saldo insuficiente para comprar cotas");
											System.out.println("**********************************");
										}
										break;
									}else{
										System.out.println("\n**********************************");
										System.out.println("A quantidade nao pode ser menor que 1");
										System.out.println("**********************************");
									}
							}else{
								System.out.println("\n**********************************");
								System.out.println("Fundo nao Encontrado");
								System.out.println("**********************************");
							}
						}else{
							System.out.println("\n**********************************");
							System.out.println("Pessoa nao Encontrada");
							System.out.println("**********************************");
							break;
						}
					}
					//verificar cpf
					if(opcao == 2) {
						System.out.println("Informe o seu CPF: ");	
						String cpfTitular = scan.next();
						Conta contaEncontrada = corretora.encontrar(cpfTitular);
						//verifica se a pessoa possui o fundo
						if(contaEncontrada != null) {
							System.out.println("Informe o codigo do fundo que voce deseja vender:");	
							String encontrarFundo = scan.next();
							Fundo fundoEncontrado = contaEncontrada.encontrarFundo(encontrarFundo);
							
							//se o fundo existir, permitir venda
							if(fundoEncontrado != null) {
								System.out.println("Informe quantas cotas voce deseja vender deste fundo:");	
								int qtdeCotas = scan.nextInt();
								
								//verifica se a quantidade a ser vendida é menor ou igual ao que a pessoa possui
								if(qtdeCotas <= fundoEncontrado.getQtde() && qtdeCotas > 0) {
								double qtdeCotasTotal = qtdeCotas * fundoEncontrado.getValorCota();
								
									if(qtdeCotasTotal <= contaEncontrada.getSaldo()) {
										double saldoCorretora = contaEncontrada.getSaldo();
										saldoCorretora += qtdeCotasTotal;//saldoCorretora = saldoCorretora + qtdeCotasTotal ;
										contaEncontrada.setSaldo(saldoCorretora);
										double valorDividendoTotal = qtdeCotas * fundoEncontrado.getDividendo();//10
										double saldoAtualizado = saldoCorretora - valorDividendoTotal;//20
										double dividendos = corretora.getDividendoMensal();//0
										double dividendoGeral = dividendos - valorDividendoTotal;//10
										contaEncontrada.setSaldo(saldoAtualizado);//20
										corretora.setDividendoMensal(dividendoGeral);//10
										
										if(qtdeCotas == fundoEncontrado.getQtde()) {	
										contaEncontrada.remove(fundoEncontrado);//se a qtd a ser vendida = a qtd que o usuario tem, entao remove o fundo da lista
										}
										System.out.println("\n**********************************");
										System.out.println("Parabens voce acabou de vender " + qtdeCotas + " cotas das " + fundoEncontrado.getQtde()  + " cotas que vocÃª possui do fundo " + fundoEncontrado.getDescricao());
										System.out.println("**********************************");
										int qtdeAtualCotas = fundoEncontrado.getQtde() - qtdeCotas;//qtdeAtualCotas recebe a quantidade antiga menos a quantidade vendida
										fundoEncontrado.setQtde(qtdeAtualCotas);//seta a nova qtd
										
									}else{
										System.out.println("\n**********************************");
										System.out.println("Saldo insuficiente para comprar cotas");
										System.out.println("**********************************");
									}
									break;
								}else{
									System.out.println("\n**********************************");
									System.out.println("Informe uma quantidade valida");
									System.out.println("**********************************");
								}
							}else{
								System.out.println("\n**********************************");
								System.out.println("Fundo nao Encontrado");
								System.out.println("**********************************");
							}
						}else{
							System.out.println("\n**********************************");
							System.out.println("Pessoa nao Encontrada");
							System.out.println("**********************************");
							break;
						}
					}
				} while(opcao != 0); {
					
				}
				
			}
			//listar os fundos
			if(opcao == 7) {
				System.out.println("Informe o seu CPF: ");	
				String cpfTitular = scan.next();
				Conta contaEncontrada = corretora.encontrar(cpfTitular);
				if(contaEncontrada != null) {
					List<Fundo> fundos = contaEncontrada.getFundosIvestidor();//todos os fundos que a pessoa comprar vai ser armazenada em "fundos"
					for (Fundo i : fundos) {
						System.out.println("ID:" + i.getCodigo());
						System.out.println("Descricao: " + i.getDescricao());
						System.out.println("Valor da Cota: " + i.getValorCota());
						System.out.println("Dividendos: " + i.getDividendo());
						System.out.println("Quantidade: " + i.getQtde());
						System.out.println();
					}
				}else{
					System.out.println("**********************************");
					System.out.println("Pessoa nao Encontrada");
					System.out.println("**********************************");
				}
			}
			
						
			if(opcao == 8) {
				System.out.println("Informe o seu CPF: ");	
				String cpfTitular = scan.next();
				Conta contaEncontrada = corretora.encontrar(cpfTitular);
				if(contaEncontrada != null) {
					System.out.println("\nO valor do seu dividendo no mês é " + corretora.getDividendoMensal() + " junto com o saldo é " + contaEncontrada.getSaldo());
				}else{
					System.out.println("\n**********************************");
					System.out.println("Pessoa não Encontrada");
					System.out.println("**********************************");
				}
			}
			
		} while ( opcao != 0 );
		{
			System.out.println("****************************************");
			System.out.println("\t Fundo Imobiliario");
			System.out.println("\t Volte Sempre !");
			System.out.println("****************************************");
		}
    }
}
