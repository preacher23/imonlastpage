package com.verinite.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.verinite.bookstore.entity.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {
	Optional<ImageModel> findByName(String name);
}

