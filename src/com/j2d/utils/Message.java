package com.j2d.utils;

public class Message {

	public static final int SUCCESS_MENSAGE=0;
	public static final int ERRO_MENSAGE=1;
	public static final int WARRAING_MENSAGE=2;
	
	
	private static final String[] MENSAGES=new String[]{"Ação executada com sucesso!","Ocorreu um erro na execução desta ação!","Aten&ccedil;&atilde;o, algumas tarefas n&atilde;o sairam como esperado!"};
	
	public static String getMensage(int m){
		return MENSAGES[m];
	}
	
}
