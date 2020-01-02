package cl.vtr.application;

import javax.ws.rs.core.Response;


import cl.vtr.http.RestClient;
import cl.vtr.model.Customer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[]command=args[0].split(";");
		
		String[] id= command[0].split("=");
		String[] cuota = command[1].split("=");
		
		System.out.println("id:" + id[1]);
		System.out.println("cuota:" + cuota[1]);
		
		Customer customer = new Customer();
		customer.setId(id[1]);
		customer.setNpvrQuota(Long.valueOf(cuota[1]));
		Response response;
		RestClient restClient = new RestClient();
		response=restClient.doPut(customer);
		
		System.out.println("status: " + response.getStatus());
		
		if(response.getStatus()==201) 
		{
			System.out.println("FLAG=N;DESCRIPCION=Transaccion OK");

		}
		else {
			System.out.println("FLAG=S;DESCRIPCION=Codigo http: " +response.getStatus());

		}
		}
	}


