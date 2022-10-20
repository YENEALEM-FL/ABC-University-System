package com.adminmodule.ABCUniversity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adminmodule.ABCUniversity.entity.Registrar;
@Repository
public interface RegistrarRepository extends JpaRepository<Registrar, Long>{

}
