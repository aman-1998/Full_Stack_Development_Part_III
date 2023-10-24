package personal.learning.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import personal.learning.configuration.DBConfiguration;
import personal.learning.model.entity.Brand;
import personal.learning.model.entity.Product;

@Repository
public class ProductDAO {
	
	@Autowired
    private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
    }

	public List<Product> getProductsByBrandId(int brandId) {
		Session session = getSession();
		Transaction txn = null;
		List<Product> productList = new ArrayList<Product>();
		try {
			txn = session.beginTransaction();
			Query query = session.createQuery("from PRODUCT where BRAND_ID = "+brandId);
			//query.setInteger("brandId", brandId);
			productList = query.getResultList();
			txn.commit();
		} catch(Exception ex) {
			if(txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
			//sessionFactory.close();
		}
		return productList;
	}

	public List<Product> getProductsByBrandIdAndCategory(int brandId, String category) {
		Session session = getSession();
		Transaction txn = null;
		List<Product> productList = new ArrayList<Product>();
		try {
			txn = session.beginTransaction();
			Query query = session.createQuery("from PRODUCT where BRAND_ID = "+brandId+" and category = '"+category+"'");
			productList = query.getResultList();
			txn.commit();
		} catch(Exception ex) {
			if(txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
			//sessionFactory.close();
		}
		return productList;
	}

}
