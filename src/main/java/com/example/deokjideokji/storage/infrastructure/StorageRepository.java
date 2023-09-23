package com.example.deokjideokji.storage.infrastructure;

import com.example.deokjideokji.storage.domain.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {
    List<Storage> findAllByUserId(String userId);
}
