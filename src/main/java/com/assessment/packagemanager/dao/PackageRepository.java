package com.assessment.packagemanager.dao;

import com.assessment.packagemanager.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Package, Integer> {
}
