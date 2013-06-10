/*
 * Created a new EJB to reduce the complexity of wsdl document
 * This EJB contains a reference to the search functionality of existing EJB
 * 
 */
package proxypackage;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import com.kmangtan.empregister.entity.Emp;
import com.kmangtan.empregister.registerservice.EmployeeRegisterRemoteInterface;

/**
 * @author kushal
 *	Implements the search method defined in the Remote Interface
 */
@WebService(endpointInterface = "proxypackage.EmpRegRemote", serviceName = "EmpRegWebService")
@Stateless
public class EmpRegImplement implements EmpRegRemote {

	@EJB
	EmployeeRegisterRemoteInterface remote;

	public List<Emp> search(String search_text, String search_using) {
		List<Emp> l1 = new ArrayList<Emp>();
		l1 = remote.searchEmployeeRecord(search_text, search_using);

		return l1;
	}

}
