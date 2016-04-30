package com.mdt.open.springdemo.persistence.jpa;

import com.mdt.open.springdemo.domain.jpa.RedPackJpa;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RedPackRepositoryJpa extends PagingAndSortingRepository<RedPackJpa,String> {
}
