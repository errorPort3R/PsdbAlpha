package com.alphaprojects.aaronandporter.Psdbalpha.services;

import com.alphaprojects.aaronandporter.Psdbalpha.entities.Bill;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jeffryporter on 6/5/17.
 */
public interface BillRepository extends CrudRepository<Bill, Integer>
{
    Iterable findBillByLevelAndRegion(Enum level, String region);
}
