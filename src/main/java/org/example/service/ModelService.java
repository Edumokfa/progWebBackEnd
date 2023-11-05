package org.example.service;

import org.example.model.*;
import org.example.utils.DatabaseCommunication;

import java.util.List;

public class ModelService extends DatabaseCommunication<Model> {

    public List<Model> getAllModelsFromBrand(Integer brandId) {
        List<Model> model = findFromDatabase("SELECT m FROM Model m WHERE m.brandId.id = " + brandId);
        return model;
    }
}