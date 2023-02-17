package com.example.andreyshop.repositories;

import com.example.andreyshop.domein.entities.Item;
import com.example.andreyshop.domein.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {


    Optional<Item> findByName(String name);

    Optional<Item> findByGender(Gender gender);


}
