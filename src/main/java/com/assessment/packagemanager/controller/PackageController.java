package com.assessment.packagemanager.controller;


import com.assessment.packagemanager.model.Package;
import com.assessment.packagemanager.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PackageController {


    private PackageService packageService;

    private  final Logger logger = Logger.getLogger(getClass().getName());


    @Autowired
    public PackageController(PackageService thePackageService) {
        packageService = thePackageService;
    }

    @PostMapping("/package")
    public Object createPackage(@RequestBody Package pkg){
        System.out.println("The PACKAGE "+pkg.toString());
        return packageService.addPackage(pkg);
    }

    @GetMapping("/package/{id}")
    public Package getPackageById(@PathVariable Integer id){
        return packageService.getPackageById(id);
    }

    @PutMapping("/package")
    public Object updatePackage(@RequestBody Package pkg){
        return packageService.updatePackage(pkg);
    }


    @DeleteMapping("/package/{id}")
    public Object deletePackage(@PathVariable Integer id){
        return packageService.deletePackage(id);
    }


    @GetMapping(value = "/packages/{direction}")
    public List<Package> getPackages(@PathVariable String direction){
        List<Package> packages = packageService.getAllPackagesSorted(direction);
        return packages;
    }
    }

