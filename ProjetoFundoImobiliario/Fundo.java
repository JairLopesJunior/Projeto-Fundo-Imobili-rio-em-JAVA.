import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Fundo {

   private String codigo;
   private String descricao;
   private double valorCota;
   private double dividendo;
   private int qtde;
   
   public Fundo(String codigo, String descricao, String valorCota, String dividendo, String qtde) {
	   this.codigo = codigo;
	   this.descricao = descricao;
	   this.valorCota = Double.parseDouble(valorCota);
	   this.dividendo = Double.parseDouble(dividendo); 
	   this.qtde = Integer.parseInt(qtde);
   }
   
	@Override
	public boolean equals(Object obj) {
		Fundo outraPessoa = (Fundo) obj;
		String codigoOutraPessoa = outraPessoa.getCodigo();
		return codigo.equals(codigoOutraPessoa);
	}

   public Fundo() {
      this( "", 0.0 );
   } 

   public Fundo( String codigo, double cota ) {
      setCodigo( codigo );
      setCota( cota );
   } 

   public void setCodigo( String codigo ) {
      this.codigo = codigo;
   }

   public String getCodigo(){
      return this.codigo;
   } 

   public void setCota ( double cota ) {
      this.valorCota = cota;
   } 

   public double getValorCota() {
      return this.valorCota;
   }

	public double getDividendo() {
		return this.dividendo;
	}
	
	public void setDividendo(double dividendo) {
		this.dividendo = dividendo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	} 

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	
	public void setValorCota(double valorCota) {
		this.valorCota = valorCota;
	}
	
	
}