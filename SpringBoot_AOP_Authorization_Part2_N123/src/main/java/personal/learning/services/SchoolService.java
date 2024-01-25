package personal.learning.services;

import java.util.List;

import personal.learning.model.entity.School;
import personal.learning.web.view.SchoolTopperSummaryView;

public interface SchoolService {
	
	School getSchoolInfo();
	
	List<SchoolTopperSummaryView> getToppersList();
	
	String getSchoolName();
}
