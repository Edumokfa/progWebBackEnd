package org.example.service;

import org.example.model.Brand;
import org.example.utils.DatabaseCommunication;

import java.util.List;

public class BrandService extends DatabaseCommunication<Brand> {

    public Brand createBrand(Brand brand) {
        saveOnDatabase(brand);
        return brand;
    }

    public Brand updateBrand(Brand brand) {
        saveOnDatabase(brand);
        return brand;
    }

    public boolean deleteBrand(Integer brandId) {
        removeFromDatabase(brandId);
        return true;
    }

    public List<Brand> getAllBrands(){
        return findFromDatabase("SELECT b FROM Brand b");
    }
}