package com.mdt.open.springdemo.persistence.jpa;

import com.mdt.open.springdemo.domain.jpa.RedPackInfoJpa;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RedPackInfoRepositoryJpa extends PagingAndSortingRepository<RedPackInfoJpa,Long> {
}
