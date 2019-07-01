import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Corretora {
	
	private List<Conta> contas = new ArrayList<Conta>();
	private List<Fundo> fundos = new ArrayList<Fundo>();
	
	private double dividendoMensal = 0;
	
	public Corretora() {
		lerFundos();
	}
	
	public List<Fundo> getFundos() {
		return fundos;
	}
	
	public List<Conta> getContas() {
		return contas;
	}

	public void add(Conta conta) {
		
		if(conta.getCpfTitularReg() == false) {
			System.out.println("\nCPF invalido");
		}else{
		contas.add(conta);
		}
	}
	
		
	public void atualizar(Conta conta) {
		contas.remove(conta);
		contas.add(conta);
	}
	
	
	//fundos txt
	public Fundo encontrarCodigo(String Codigo) {
		for (Fundo fundo : fundos) {
			String codigoCorrente = fundo.getCodigo();
			if (codigoCorrente.equals(Codigo))
				return fundo;
		}
		return null;
	}
	
	public Conta encontrar(String cpfTitular) {
		for (Conta conta : contas) {
			String cpfCorrente = conta.getCpfTitular();
			if (cpfCorrente.equals(cpfTitular))
				return conta;
		}
		return null;
	}
	
	public void realizarTed(Conta conta, double valor) {
		double saldoCorrente = conta.getSaldo();//saldo corretora
		double saldoBancario = conta.getDadosBancario().getSaldo();//saldo banco
		if(valor <= saldoBancario) {
			saldoCorrente += valor;
			conta.setSaldo(saldoCorrente);
			saldoBancario -= valor;
			conta.getDadosBancario().setSaldo(saldoBancario);
			System.out.println("\n**********************************");
			System.out.println("Transferência realizada com sucesso");
			System.out.println("**********************************");
		}else{
			System.out.println("\n**********************************");
			System.out.println("Saldo insuficiente para realizar TED");
			System.out.println("**********************************");
		}
	}
	
	public void resgatarTed(Conta conta, double valor) {
		double saldoCorrente = conta.getSaldo();
		double saldoBancario = conta.getDadosBancario().getSaldo();
		if(valor <= saldoCorrente) {
			saldoCorrente -= valor;
			conta.setSaldo(saldoCorrente);
			saldoBancario += valor;
			conta.getDadosBancario().setSaldo(saldoBancario);
			System.out.println("\n**********************************");
			System.out.println("Resgate realizado com sucesso");
			System.out.println("**********************************");
		}else{
			System.out.println("\n**********************************");
			System.out.println("Saldo insuficiente para resgatar TED");
			System.out.println("**********************************");
		}
	}
	
	private void lerFundos() {
		try{
	        FileReader fr = new FileReader("FII.txt");
	        BufferedReader br = new BufferedReader(fr);
	        String temp;
	        while ((temp = br.readLine()) != null) {
	            String[] a = temp.split(";");
	            Fundo fundoArray = new Fundo(a[0], a[1], a[2], a[3], a[4]);
	            fundos.add(fundoArray);
	        }
	    }
	    catch (FileNotFoundException e ) {
	        System.out.println("Arquivo não Encontrado!");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public double getDividendoMensal() {
		return dividendoMensal;
	}

	public void setDividendoMensal(double dividendoMensal) {
		this.dividendoMensal = dividendoMensal;
	}
	
}
