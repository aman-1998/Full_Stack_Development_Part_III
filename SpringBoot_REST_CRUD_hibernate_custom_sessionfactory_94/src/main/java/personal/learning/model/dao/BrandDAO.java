package personal.learning.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import personal.learning.model.entity.Brand;

@Repository
public class BrandDAO {
	
	@Autowired
    private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
    }

	public List<Brand> getAllBrands() {
		Session session = getSession();
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
		Session session = getSession();
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

	@Transactional
	public boolean createBrand(Brand brand) {
		Session session = getSession();
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

	@Transactional
	public boolean updateBrand(Brand brand) {
		Session session = getSession();
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

	@Transactional
	public boolean deleteBrand(int brandId) {
		Session session = getSession();
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
