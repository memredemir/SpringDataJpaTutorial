package com.example.demo.repository;

import com.example.demo.domain.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
}
