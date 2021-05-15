package saborea.model.dao;

import java.util.ArrayList;

//IDAO=interface data access object //un objeto de acceso a datos es un componente de software que suministra una interfaz 
									//com�n entre la aplicaci�n y uno o m�s dispositivos de almacenamiento de datos(SQL SERVER), tales como una Base de datos o un archivo
public interface IDAO {
	
	//m�todos tipo public  //where ID=1 en query 
	public ArrayList listar(boolean join);	
	public void insertar(Object obj);
	public void modificar(Object obj);
	public void eliminar(int cod);
	public ArrayList buscar(String condition,boolean join);	
	
	/*What's Object java.lang -> El java.lang es La clase de objeto es la ra�z de la jerarqu�a de clases.
	 Cada clase tiene Object como superclase. Todos los objetos , incluidas las matrices, implementan los m�todos de esta clase.*/

	


}
