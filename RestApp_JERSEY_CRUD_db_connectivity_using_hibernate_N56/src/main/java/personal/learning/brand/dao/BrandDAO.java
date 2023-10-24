package personal.learning.brand.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import personal.learning.brand.Brand;

public class BrandDAO {
	
	SessionFactory sessionFactory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Brand.class)
			.buildSessionFactory();

	public List<Brand> getAllBrands() {
		Session session = sessionFactory.getCurrentSession();
		Transaction txn = null;
		List<Brand> brandList = new ArrayList<Brand>();
		try {
			txn = session.beginTransaction();
			brandList = session.createQuery("from BRAND").getResultList();
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
		return brandList;
	}

	public Brand getBrand(int brandId) {
		Session session = sessionFactory.getCurrentSession();
		Transaction txn = null;
		Brand brand = new Brand();
		try {
			txn = session.beginTransaction();
			brand = session.get(Brand.class, brandId);
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
		return brand;
	}

	public boolean createBrand(Brand brand) {
		Session session = sessionFactory.getCurrentSession();
		Transaction txn = null;
		try {
			txn = session.beginTransaction();
			session.save(brand);
			txn.commit();
		} catch(Exception ex) {
			if(txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
			return false;
		} finally {
			session.close();
			//sessionFactory.close();
		}
		return true;
	}

	public boolean updateBrand(Brand brand) {
		Session session = sessionFactory.getCurrentSession();
		Transaction txn = null;
		try {
			Brand updatedBrand = new Brand();
			txn = session.beginTransaction();
			updatedBrand  = session.get(Brand.class, brand.getBrandId());
			updatedBrand.setBrandName(brand.getBrandName());
			txn.commit();
		} catch(Exception ex) {
			if(txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
			return false;
		} finally {
			session.close();
			//sessionFactory.close();
		}
		return true;
	}

	public boolean deleteBrand(int brandId) {
		Session session = sessionFactory.getCurrentSession();
		Transaction txn = null;
		try {
			Brand brand = new Brand();
			txn = session.beginTransaction();
			brand = session.get(Brand.class, brandId);
			session.delete(brand);
			txn.commit();
		} catch(Exception ex) {
			if(txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
			return false;
		} finally {
			session.close();
			//sessionFactory.close();
		}
		return true;
	}

}
