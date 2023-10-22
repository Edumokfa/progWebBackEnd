package org.example.service;

import org.example.model.Brand;
import org.example.utils.ListUtil;

import static org.example.service.LocalCacheService.LOCAL_CACHE_SERVICE;

import java.util.List;

public class BrandService {


    public List<Brand> getAllBrands() {
        return LOCAL_CACHE_SERVICE.getBrandList();
    }

    public Brand createBrand(Brand brand) {
        List<Brand> brandList = LOCAL_CACHE_SERVICE.getBrandList();
        boolean hasBrand = ListUtil.isNotEmpty(brandList) && brandList.stream().anyMatch(b -> b.getId() == brand.getId() || b.getName().equals(brand.getName()));
        if (hasBrand) {
            return null;
        }
        brandList.add(brand);
        return brand;
    }

    public Brand updateBrand(Brand brand) {
        List<Brand> brandList = LOCAL_CACHE_SERVICE.getBrandList();
        Brand existentBrand = brandList.stream().filter(b -> b.getId() == brand.getId() || b.getName().equals(brand.getName())).findFirst().orElse(null);
        if (existentBrand == null) {
            return null;
        }
        existentBrand.setName(brand.getName());
        return brand;
    }

    public boolean deleteBrand(Integer brandId) {
        List<Brand> brandList = LOCAL_CACHE_SERVICE.getBrandList();
        Brand existentBrand = brandList.stream().filter(b -> b.getId() == brandId).findFirst().orElse(null);
        if (existentBrand == null) {
            return false;
        }
        brandList.remove(existentBrand);
        return true;
    }
}