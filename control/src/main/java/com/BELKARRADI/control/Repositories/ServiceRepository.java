package com.BELKARRADI.control.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BELKARRADI.control.beans.Service;
@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {

}
