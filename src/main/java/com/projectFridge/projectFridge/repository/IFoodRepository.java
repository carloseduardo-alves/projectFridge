package com.projectFridge.projectFridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projectFridge.projectFridge.entity.Food;

public interface IFoodRepository extends JpaRepository<Food, Long> { }
