package com.dbms.repositories;

import com.dbms.domain.Company;
import com.dbms.domain.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mengleisun on 4/12/16.
 */
@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, Integer> {
    @Query("select count (company) from Company company")
    public int findTotal();
}
