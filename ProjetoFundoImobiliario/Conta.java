
import java.util.ArrayList;
import java.util.List;

public class Conta {
	
	private List<Fundo> fundosIvestidor = new ArrayList<Fundo>();
	
	private String nome;
	private String cpfTitular;
	private double saldo;
	private DadosBancario dadosBancario;
	private Fundo fundo;
	
	public void add(Fundo fundo) {
		fundosIvestidor.add(fundo);
	}
	
	public void remove(Fundo fundo) {
		fundosIvestidor.remove(fundo);
	}
	
	@Override
	public boolean equals(Object obj) {
		Conta outraPessoa = (Conta) obj;
		String cpfOutraPessoa = outraPessoa.getCpfTitular();
		return cpfTitular.equals(cpfOutraPessoa);
	}
	
	public Fundo encontrarFundo(String encontrarFundo) {
		for (Fundo fundo : fundosIvestidor) {
			String codigoCorrente = fundo.getCodigo();
			if (codigoCorrente.equals(encontrarFundo))
				return fundo;
		}
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public List<Fundo> getFundosIvestidor() {
		return fundosIvestidor;
	}

	public void setFundosIvestidor(List<Fundo> fundosIvestidor) {
		this.fundosIvestidor = fundosIvestidor;
	}

}

