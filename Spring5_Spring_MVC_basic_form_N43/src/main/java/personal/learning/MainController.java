package personal.learning;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome() {
		return "basicForm";
	}
	
	@RequestMapping(value="displayInformation", method=RequestMethod.POST)
	public String displayInfo(HttpServletRequest request) {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String gender = request.getParameter("gender");
		String[] languages = request.getParameterValues("language");
		String country = request.getParameter("country");
		request.setAttribute("fname", fname);
		request.setAttribute("lname", lname);
		request.setAttribute("gender", gender);
		request.setAttribute("languages", languages);
		request.setAttribute("country", country);
		return "displayAllInformation";
	}
}
