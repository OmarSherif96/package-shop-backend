package com.assessment.packagemanager.service;

import com.assessment.packagemanager.model.Package;

import java.util.List;

public interface PackageService {
public List<Package> getAllPackages();
public Package getPackageById(Integer id);
public Object addPackage(Package pkg);
public Object deletePackage(Integer id);
public Object updatePackage(Package pkg);
public List<Package> getAllPackagesSorted(String sortDirection);

}
