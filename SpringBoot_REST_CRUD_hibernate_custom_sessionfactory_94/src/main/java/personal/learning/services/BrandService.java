package personal.learning.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import personal.learning.model.dao.BrandDAO;
import personal.learning.model.entity.Brand;

@Service
public class BrandService {
	
	@Autowired
	private BrandDAO brandRepo;
	
	public List<Brand> getAllBrands() {
		return brandRepo.getAllBrands();
	}
	
	public Brand getBrand(int brandId) {
		return brandRepo.getBrand(brandId);
	}
	
	public boolean createBrand(Brand brand) {
		return brandRepo.createBrand(brand);
	}
	
	public boolean updateBrand(int brandId, Brand brand) {
		if(brandId != brand.getBrandId()) {
			return false;
		}
		
		Brand existingbrand = brandRepo.getBrand(brandId);
		if(existingbrand == null) {
			return false;
		}
		return brandRepo.updateBrand(brand);
	}

	public boolean deleteBrand(int brandId) {
		Brand brand = brandRepo.getBrand(brandId);
		if(brand == null) {
			return false;
		}
		return brandRepo.deleteBrand(brandId);
	}
	
}
