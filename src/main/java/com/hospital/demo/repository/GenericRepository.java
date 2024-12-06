package com.hospital.demo.repository;

import com.hospital.demo.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T extends BaseModel> extends JpaRepository<T, Long> {
}
