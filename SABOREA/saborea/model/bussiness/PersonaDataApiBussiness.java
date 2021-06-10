package saborea.model.bussiness;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.ExecutionException;

import com.google.gson.Gson;


import saborea.model.bussiness.DTO.DataApiBE;

public class PersonaDataApiBussiness {

	DataApiBE Obj ;
	
	public PersonaDataApiBussiness(){
		Obj= new DataApiBE();
	}
	
	public DataApiBE PersonDataApi(String dniConsulta)   {
		
//		System.out.println(dniConsulta);
//		System.out.println(Integer.parseInt(dniConsulta));
		//HttpClient es una parte de una librería de la ultima versión de java para consumir un servicio (API REST)
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()//COSNTRUIR EL ENLACE PARA ENVIAR A LA API
			      .uri(URI.create("https://dniruc.apisperu.com/api/v1/dni/"+dniConsulta+"?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImVybmVzdG8uc20uOTVAaG90bWFpbC5jb20ifQ.E3XN1bWBUPi4ZZIYCZ_5MKlSkNsb-BD7-H8QKN89jDM"))
			      .build();
		
		//System.out.println(request);
		//HttpRequest request=enlace;
		String resString;
		
		try {// try and catch sirve para el tratamiento de las excepciones 
			
			resString = client.sendAsync(request, BodyHandlers.ofString()).get().body();//ejecuta asincronicamente no de manera líneal
			Gson g=new Gson();//es un protocolo de formato para enviar y recibir datos
			Obj=g.fromJson(resString,DataApiBE.class);
			
			//System.out.println("DataApiBE.class : " + Obj.toString());
			//System.out.println("resString" +resString);
			//int StatusCode=client.sendAsync(request, BodyHandlers.ofString()).get().statusCode();
			//System.out.println("StatusCode" +StatusCode);
			
		} catch (InterruptedException e) {
			//error de servidor,mal funcionamiento de la pc, mal funcionamiento del sistema operativo
			e.printStackTrace();//es un método en java señalará la línea exacta en la que el método generó la excepción
			//System.out.println("1era exce");
		} catch (ExecutionException e) {
			//error de autenticación de la misma api
			//System.out.println(e.printStackTrace());
			//System.out.println("2da exce");
			e.printStackTrace();
		}		
		
		
		return Obj;
	}
	
	
	
}
