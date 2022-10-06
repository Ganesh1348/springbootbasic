package com.webb.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketsDao extends CrudRepository<owners, Long> 
{

	void save(List<owners> owner);

}
