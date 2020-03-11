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
	private static Scanner scan;
	
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
			System.out.println("8.\t Ver cotações do dia ");
			System.out.println("**********************************");
			System.out.println("9.\t Ver dividendos do mês ");
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
					System.out.println("CPF já existente");
					System.out.println("\n**********************************");
				}else{
					corretora.add(conta);
					System.out.println("\n**********************************");
					System.out.println("Pessoa Cadastrada com sucesso");
					System.out.println("**********************************");
				}
			}
	
			if (opcao == 2) {
				System.out.println("Informe o seu CPF: ");	
				String cpfTitular = scan.next();
				Conta contaEncontrada = corretora.encontrar(cpfTitular);
				if (contaEncontrada != null) {
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
				} else {
					System.out.println("\n**********************************");
					System.out.println("Pessoa não Encontrada");
					System.out.println("**********************************");
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
					System.out.println("Pessoa não Encontrada");
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
					System.out.println("\n**********************************");
					System.out.println("Pessoa não Encontrada");
					System.out.println("**********************************");
				}
				
			}
			
			if(opcao == 5) {
				System.out.println("Informe o seu CPF: ");	
				String cpfTitular = scan.next();
				Conta contaEncontrada = corretora.encontrar(cpfTitular);
				if(contaEncontrada != null) {
					System.out.print("Quanto você deseja resgatar do saldo:");
					double rSaldo = scan.nextDouble();
					corretora.resgatarTed(contaEncontrada, rSaldo);
				}else{
					System.out.println("\n**********************************");
					System.out.println("Pessoa não Encontrada");
					System.out.println("**********************************");
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
					System.out.println("Descrição: " + f.getDescricao());
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
					
					if(opcao == 1) {
						Fundo fundoss = new Fundo();
						System.out.println("Informe o seu CPF: ");	
						String cpfTitular = scan.next();
						Conta contaEncontrada = corretora.encontrar(cpfTitular);
						
						if(contaEncontrada != null) {
							System.out.println("Informe o ID do fundo que você deseja comprar:");	
							String encontrarFundo = scan.next();
							Fundo fundoEncontrado = corretora.encontrarCodigo(encontrarFundo);
							
							if(fundoEncontrado != null) {
								System.out.println("Informe quantas cotas você deseja comprar deste fundo:");	
								int qtdeCotas = scan.nextInt();
									if(qtdeCotas > 0) {
										fundoEncontrado.setQtde(qtdeCotas);
										double qtdeCotasTotal = qtdeCotas * fundoEncontrado.getValorCota();
								    	if(qtdeCotasTotal <= contaEncontrada.getSaldo()) {
											double saldoCorretora = contaEncontrada.getSaldo();
											saldoCorretora -= qtdeCotasTotal;
											double valorDividendoTotal = qtdeCotas * fundoEncontrado.getDividendo();
											double saldoAtualizado = saldoCorretora + valorDividendoTotal;
											double dividendos = corretora.getDividendoMensal();
											double dividendoGeral = dividendos + valorDividendoTotal;
											contaEncontrada.setSaldo(saldoAtualizado);
											corretora.setDividendoMensal(dividendoGeral);
//											Fundo fundoEncontradoInvestidor = contaEncontrada.encontrarFundo(encontrarFundo);
//											System.out.println(fundoEncontradoInvestidor);
//											if(fundoEncontradoInvestidor == fundoEncontrado) {
//												double dividendoAtualizado = fundoEncontradoInvestidor.getDividendo() + fundoEncontrado.getDividendo();
//												System.out.println(dividendoAtualizado);
//												fundoEncontradoInvestidor.setDividendo(dividendoAtualizado);
//												int qtdeAtualizada = fundoEncontradoInvestidor.getQtde() + fundoEncontrado.getQtde();
//												fundoEncontradoInvestidor.setQtde(qtdeAtualizada);
//												double valorCotaAtualizado = fundoEncontradoInvestidor.getValorCota() + fundoEncontrado.getValorCota();
//												fundoEncontradoInvestidor.setValorCota(valorCotaAtualizado);
												
//											}else {
												contaEncontrada.add(fundoEncontrado);
//											}
											System.out.println("\n**********************************");
											System.out.println("Parabêns você acabou de comprar " + qtdeCotas + " cotas do fundo " + fundoEncontrado.getDescricao());
											System.out.println("**********************************");
										}else{
											System.out.println("\n**********************************");
											System.out.println("Saldo insuficiente para comprar cotas");
											System.out.println("**********************************");
										}
										break;
									}else{
										System.out.println("\n**********************************");
										System.out.println("A quantidade não pode ser menor que 1");
										System.out.println("**********************************");
									}
							}else{
								System.out.println("\n**********************************");
								System.out.println("Fundo não Encontrado");
								System.out.println("**********************************");
							}
						}else{
							System.out.println("\n**********************************");
							System.out.println("Pessoa não Encontrada");
							System.out.println("**********************************");
							break;
						}
					}
					
					if(opcao == 2) {
						System.out.println("Informe o seu CPF: ");	
						String cpfTitular = scan.next();
						Conta contaEncontrada = corretora.encontrar(cpfTitular);
						
						if(contaEncontrada != null) {
							System.out.println("Informe o codigo do fundo que você deseja vender:");	
							String encontrarFundo = scan.next();
							Fundo fundoEncontrado = contaEncontrada.encontrarFundo(encontrarFundo);
							System.out.println(fundoEncontrado);
							if(fundoEncontrado != null) {
								System.out.println("Informe quantas cotas você deseja vender deste fundo:");	
								int qtdeCotas = scan.nextInt();
								
								if(qtdeCotas <= fundoEncontrado.getQtde() && qtdeCotas > 0) {
								double qtdeCotasTotal = qtdeCotas * fundoEncontrado.getValorCota();
								
									if(qtdeCotasTotal <= contaEncontrada.getSaldo()) {
										double saldoCorretora = contaEncontrada.getSaldo();
										saldoCorretora += qtdeCotasTotal;
										contaEncontrada.setSaldo(saldoCorretora);
										
										if(qtdeCotas == fundoEncontrado.getQtde()) {
											contaEncontrada.remove(fundoEncontrado);
										}
										System.out.println("\n**********************************");
										System.out.println("Parabêns você acabou de vender " + qtdeCotas + " cotas das " + fundoEncontrado.getQtde()  + " cotas que você possui do fundo " + fundoEncontrado.getDescricao());
										System.out.println("**********************************");
										int qtdeAtualCotas = fundoEncontrado.getQtde() - qtdeCotas;
										fundoEncontrado.setQtde(qtdeAtualCotas);
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
								System.out.println("Fundo não Encontrado");
								System.out.println("**********************************");
							}
						}else{
							System.out.println("\n**********************************");
							System.out.println("Pessoa não Encontrada");
							System.out.println("**********************************");
							break;
						}
					}
				} while(opcao != 0); {
					
				}
				
			}
			
			if(opcao == 7) {
				System.out.println("Informe o seu CPF: ");	
				String cpfTitular = scan.next();
				Conta contaEncontrada = corretora.encontrar(cpfTitular);
				if(contaEncontrada != null) {
					List<Fundo> fundos = contaEncontrada.getFundosIvestidor();
					for (Fundo p : fundos) {
						System.out.println("ID:" + p.getCodigo());
						System.out.println("Descrição: " + p.getDescricao());
						System.out.println("Valor da Cota: " + p.getValorCota());
						System.out.println("Dividendos: " + p.getDividendo());
						System.out.println("Quantidade: " + p.getQtde());
						System.out.println();
					}
				}else{
					System.out.println("**********************************");
					System.out.println("Pessoa não Encontrada");
					System.out.println("**********************************");
				}
			}
			
			if(opcao == 8) {
				System.out.println("Informe o seu CPF: ");	
				String cpfTitular = scan.next();
				Conta contaEncontrada = corretora.encontrar(cpfTitular);
				if(contaEncontrada != null) {
					
				}else {
					
				}
			}
			
			if(opcao == 9) {
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
