package personal.learning.model.dao;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import personal.learning.model.entity.School;
import personal.learning.web.view.SchoolTopperSummaryView;

@Repository
public class SchoolRepository {
	
	private SessionFactory sessionFactory;
	
	public SchoolRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
    }
	
	public School getSchoolInfo() {
		Session session = getSession();
		Transaction txn = session.beginTransaction();
		
		School school = (School) session.createQuery("from school sc where sc.school_code = :code")
										.setParameter("code", "KHEMS")
										.getResultList()
										.get(0);
		
		txn.commit();
		return school;
	}
	
	public String getSchoolName() throws Exception {
		Session session = getSession();
		Transaction txn = session.beginTransaction();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append("    sc.school_name ");
		sb.append("FROM ");
		sb.append("    school sc ");
		sb.append("WHERE ");
		sb.append("    school_code = 'KHEMS' ");
		
		List<String> resultList = new GeneralRepository<String>().query(session, sb.toString());
		if(ObjectUtils.isEmpty(resultList)) {
			throw new Exception("School Name not found");
		}
		String schoolName = resultList.get(0);
		
		txn.commit();
		return schoolName;
	}
	
	public List<SchoolTopperSummaryView> getToppersList() {
		Session session = getSession();
		Transaction txn = session.beginTransaction();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append("    iit.roll_no as iit_roll_no,");
		sb.append("    iit.name as student_name, ");
		sb.append("    iit.rank as rank, ");
		sb.append("    sc.school_name as school_name, ");
		sb.append("    sc.board_short_name as board_short_name ");
		sb.append("FROM ");
		sb.append("    iitjee_rank_holder   iit, ");
		sb.append("    school               sc ");
		sb.append("WHERE ");
		sb.append("    sc.school_code = 'KHEMS' ");
		
		List<SchoolTopperSummaryView> topperList = new GeneralRepository<SchoolTopperSummaryView>()
														.query(session, sb.toString(), SchoolTopperSummaryView.class);
		
		txn.commit();
		return topperList;
	}
}
