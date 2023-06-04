package com.example.demo.repository;

import com.example.demo.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CatRepository extends JpaRepository<Cat, UUID> {
}