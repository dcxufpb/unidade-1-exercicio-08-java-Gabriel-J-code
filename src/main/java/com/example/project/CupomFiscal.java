package com.example.project;

public class CupomFiscal {

	private static boolean isEmpty(String s){
		if (s == null) return true;
		if (s.equals("")) return true;
		return false;
	}	

	public static String dadosLojaObjeto(Loja loja) {
		if (isEmpty(loja.getNomeLoja())) {
			throw new RuntimeException("O campo nome da loja é obrigatório");		
		}
		if (isEmpty(loja.getLogradouro())){
			throw new RuntimeException("O campo logradouro do endereço é obrigatório");
		}		
		if (isEmpty(loja.getMunicipio())){
			throw new RuntimeException("O campo município do endereço é obrigatório");
		}
		if (isEmpty(loja.getEstado())){
			throw new RuntimeException("O campo estado do endereço é obrigatório");
		} 
		if (isEmpty(loja.getCnpj())){
			throw new RuntimeException("O campo CNPJ da loja é obrigatório");
		} 
		if (isEmpty(loja.getInscricaoEstadual())){
			throw new RuntimeException("O campo inscrição estadual da loja é obrigatório");
		}

		String _NUMERO = "s/n";
		if (loja.getNumero() > 0){
			_NUMERO = Integer.toString(loja.getNumero());
		}
		
		String _COMPLEMENTO = "";
		if (!isEmpty(loja.getComplemento())){
			_COMPLEMENTO = " " + loja.getComplemento();
		}
	
		String _BAIRRO = "";
		if(!isEmpty(loja.getBairro())){
			_BAIRRO = loja.getBairro() + " - " ;
		}
	
		String _CEP = "";
		if(!isEmpty(loja.getCep())){
			_CEP = "CEP:" + loja.getCep();
		}
		
		String _TELEFONE = "";
		if(!isEmpty(loja.getTelefone())){
			_TELEFONE = "Tel " + loja.getTelefone();

			if(!isEmpty(loja.getCep())){
				_TELEFONE = " " + _TELEFONE;
			}
		}		
	
		String _OBSERVACAO = "";
		if (!isEmpty(loja.getObservacao())){
			_OBSERVACAO = loja.getObservacao();
		}

		String BREAK = System.lineSeparator();

		String nota = String.format("%s",loja.getNomeLoja()) + BREAK;
		nota += String.format("%s, %s%s",loja.getLogradouro(),_NUMERO,_COMPLEMENTO) + BREAK;
		nota += String.format("%s%s - %s",_BAIRRO,loja.getMunicipio(),loja.getEstado()) + BREAK;
		nota += String.format("%s%s",_CEP,_TELEFONE) + BREAK;
		nota += String.format("%s",_OBSERVACAO) + BREAK;
		nota += String.format("CNPJ: %s",loja.getCnpj()) + BREAK;
		nota += String.format("IE: %s",loja.getInscricaoEstadual()) + BREAK;
	
		return nota;
	}

}
