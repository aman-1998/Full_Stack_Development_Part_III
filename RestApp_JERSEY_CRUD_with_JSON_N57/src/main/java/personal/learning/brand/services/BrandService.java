package personal.learning.brand.services;

import java.util.List;

import personal.learning.brand.Brand;
import personal.learning.brand.dao.BrandDAO;

public class BrandService {
	
	BrandDAO dao = new BrandDAO();
	
	public List<Brand> getAllBrands() {
		return dao.getAllBrands();
	}
	
	public Brand getBrand(int brandId) {
		return dao.getBrand(brandId);
	}
	
	public boolean createBrand(Brand brand) {
		return dao.createBrand(brand);
	}
	
	public boolean updateBrand(int brandId, Brand brand) {
		if(brandId != brand.getBrandId()) {
			return false;
		}
		
		Brand existingbrand = dao.getBrand(brandId);
		if(existingbrand == null) {
			return false;
		}
		return dao.updateBrand(brand);
	}

	public boolean deleteBrand(int brandId) {
		Brand brand = dao.getBrand(brandId);
		if(brand == null) {
			return false;
		}
		return dao.deleteBrand(brandId);
	}
	
}
