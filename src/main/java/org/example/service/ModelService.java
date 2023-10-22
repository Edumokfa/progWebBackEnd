package org.example.service;

import org.example.model.*;

import java.util.List;

import static org.example.service.LocalCacheService.LOCAL_CACHE_SERVICE;

public class ModelService {

    public List<Model> getAllModelsFromBrand(Integer brandId) {
        List<Model> modelFromBrand = LOCAL_CACHE_SERVICE.getModelList().stream().filter(model -> model.getBrandId().equals(brandId)).toList();
        return modelFromBrand;
    }
}