package personal.learning.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import personal.learning.dao.AppDao;

@Service
public class AppService {
	
	@Autowired
	private AppDao appDao;
	
	public String getSchoolName() {
		Optional<String> schoolNameOp = appDao.getSchoolName();
		return schoolNameOp.orElseGet(() -> "Name of the School");
	}
}
