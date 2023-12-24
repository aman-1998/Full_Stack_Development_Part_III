package personal.learning.services;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import personal.learning.model.dao.SchoolRepository;
import personal.learning.model.entity.School;
import personal.learning.web.view.SchoolTopperSummaryView;

@Service
public class SchoolServiceImpl implements SchoolService {
	
	private SchoolRepository schoolRepository;
	
	public SchoolServiceImpl(SchoolRepository schoolRepository) {
		this.schoolRepository = schoolRepository;
	}

	@Override
	public String getSchoolName() {
		String name = StringUtils.EMPTY;
		try {
			name = schoolRepository.getSchoolName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}

	@Override
	public School getSchoolInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SchoolTopperSummaryView> getToppersList() {
		// TODO Auto-generated method stub
		return null;
	}
}
