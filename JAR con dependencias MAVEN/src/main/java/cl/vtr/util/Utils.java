package cl.vtr.util;

import cl.vtr.model.Customer;

public class Utils {
	
	public static String generateXMLInput(Customer customer ) {
		
		StringBuffer strb = new StringBuffer();	
		strb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n");
		strb.append("<Customer id=\""+customer.getId()+"\" xmlns=\"urn:eventis:crm:2.0\">\r\n");
		strb.append("<NPVRQuota>"+customer.getNpvrQuota()+"</NPVRQuota></Customer>");
		return strb.toString();
		
		
	}
}
