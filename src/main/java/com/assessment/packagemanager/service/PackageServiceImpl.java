package com.assessment.packagemanager.service;

import com.assessment.packagemanager.dao.PackageRepository;
import com.assessment.packagemanager.model.Package;
import com.assessment.packagemanager.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PackageServiceImpl implements PackageService {

    PackageRepository packageRepository;
    private EntityManager entityManager;

    @Autowired
    public PackageServiceImpl(PackageRepository thePackageRepository,EntityManager theEntityManager){
        entityManager=theEntityManager;
        packageRepository= thePackageRepository;
    }

    @Override
    public List<Package> getAllPackages() {

        return packageRepository.findAll();
    }



    @Override
    public List<Package> getAllPackagesSorted(String sortDirection) {
        if(sortDirection.equalsIgnoreCase("asc"))
        return packageRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
        else if(sortDirection.equalsIgnoreCase("des"))
        return packageRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
        else return packageRepository.findAll();

    }
    @Override
    public Package getPackageById(Integer id) {

        Package pack = packageRepository.findById(id).orElse(new Package());
       return pack;
    }

    @Override
    @Transactional
    public Object addPackage(Package pkg) {
        try {
            ArrayList<Product> products=(ArrayList<Product>) pkg.getProducts();
            pkg.setProductsandFixPrices(products);
            return entityManager.merge(pkg);

        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Object deletePackage(Integer id) {
        Package pack = packageRepository.findById(id).orElse(null);
        if(pack==null){
            return false;
        }
        else{
            packageRepository.delete(pack);
            return true;
        }
    }

    @Override
    public Object updatePackage(Package pkg) {
        Package pack = packageRepository.findById(pkg.getId()).orElse(null);
        if(pack==null){
            return false;
        }
        else{
            ArrayList<Product> products=(ArrayList<Product>) pkg.getProducts();
            pkg.setProductsandFixPrices(products);
            packageRepository.save(pkg);
            return pack;
        }
    }
}
