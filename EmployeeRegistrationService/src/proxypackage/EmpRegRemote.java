
/*
 * Remote method for a EJB
 */
package proxypackage;

import java.util.List;


import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.kmangtan.empregister.entity.Emp;


@WebService
@Remote
public  interface EmpRegRemote{
	
	@WebMethod
	public List<Emp> search(String search_text,String search_using);
	
	
	

}
