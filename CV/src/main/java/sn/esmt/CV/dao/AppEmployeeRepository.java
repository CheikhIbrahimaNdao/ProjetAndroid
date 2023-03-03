package sn.esmt.CV.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.esmt.CV.entities.AppEmployeeEntity;
@Repository
public interface AppEmployeeRepository extends JpaRepository<AppEmployeeEntity,Integer> { }