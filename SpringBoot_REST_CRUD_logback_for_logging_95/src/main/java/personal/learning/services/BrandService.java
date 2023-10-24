package personal.learning.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import personal.learning.model.dao.BrandDAO;
import personal.learning.model.entity.Brand;

@Service
public class BrandService {
	
	private static final Logger logger = LoggerFactory.getLogger(BrandService.class);
	
	@Autowired
	private BrandDAO brandRepo;
	
	public List<Brand> getAllBrands() {
		List<Brand> listOfAllBrands = brandRepo.getAllBrands();
		if(listOfAllBrands.isEmpty()) {
			logger.warn("There are no brands available");
		}
		return listOfAllBrands;
	}
	
	public Brand getBrand(int brandId) {
		Brand brand = brandRepo.getBrand(brandId);
		if(brand.getBrandId() == 0 && brand.getBrandName().equals("####")) {
			logger.warn("There are no brands with brand_id["+brandId+"]");
		}
		return brand;
	}
	
	public boolean createBrand(Brand brand) {
		boolean isCreated =  brandRepo.createBrand(brand);
		if(!isCreated) {
			logger.error("Brand with brand_name = ["+brand.getBrandName()+"] already exist");
		}
		return isCreated;
	}
	
	public boolean updateBrand(int brandId, Brand brand) {
		if(brandId != brand.getBrandId()) {
			logger.error("Brand_Id["+brandId+"] in URL is not matching with Brand_Id["+brand.getBrandId()+"] of payload");
			return false;
		}
		
		Brand existingbrand = brandRepo.getBrand(brandId);
		if(existingbrand == null) {
			logger.error("Brand with brand_id["+brandId+"] doesn't exist");
			return false;
		}
		return brandRepo.updateBrand(brand);
	}

	public boolean deleteBrand(int brandId) {
		Brand brand = brandRepo.getBrand(brandId);
		if(brand == null) {
			logger.error("Brand with brand_id["+brandId+"] doesn't exist");
			return false;
		}
		return brandRepo.deleteBrand(brandId);
	}
	
}
