
import java.util.ArrayList;
import java.util.List;

public class Conta {
	
	private List<Fundo> fundosIvestidor = new ArrayList<Fundo>();//lista de fundos que o usuario comprar
	
	private String nome;
	private String cpfTitular;
	private double saldo;
	private DadosBancario dadosBancario;
	private Fundo fundo;
	
	//adiciona o fundo comprado
	public void add(Fundo fundo) { 
		fundosIvestidor.add(fundo);
	}
	
	//remove o fundo quando for = 0
	public void remove(Fundo fundo) {
		fundosIvestidor.remove(fundo);
	}
	
	public boolean equals(Object obj) {
		Conta outraPessoa = (Conta) obj;
		String cpfOutraPessoa = outraPessoa.getCpfTitular();
		return cpfTitular.equals(cpfOutraPessoa);
	}
	
	//encontrar fundo comprado
	public Fundo encontrarFundo(String encontrarFundo) {
		for (Fundo fundo : fundosIvestidor) {
			String codigoCorrente = fundo.getCodigo();
			if (codigoCorrente.equals(encontrarFundo))
				return fundo;
		}
		return null;
	}
//gets e sets
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean getCpfTitularReg(){
	      return cpfTitular.matches( "\\d{3}.\\d{3}.\\d{3}-\\d{2}");

		}
	

	public String getCpfTitular() {
		return cpfTitular;
		
	}

	public void setCpfTitular(String cpfTitular) {
		this.cpfTitular = cpfTitular;
	}
	
	

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public DadosBancario getDadosBancario() {
		return dadosBancario;
	}

	public void setDadosBancario(DadosBancario dadosBancario) {
		this.dadosBancario = dadosBancario;
	}
//para ser possivel acessar de fora da classe
	public List<Fundo> getFundosIvestidor() {
		return fundosIvestidor;
	}

	public void setFundosIvestidor(List<Fundo> fundosIvestidor) {
		this.fundosIvestidor = fundosIvestidor;
	}

}

