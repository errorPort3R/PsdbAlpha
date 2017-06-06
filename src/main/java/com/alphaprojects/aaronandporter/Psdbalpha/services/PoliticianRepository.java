package com.alphaprojects.aaronandporter.Psdbalpha.services;

import com.alphaprojects.aaronandporter.Psdbalpha.entities.Politician;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jeffryporter on 6/5/17.
 */
public interface PoliticianRepository extends CrudRepository<Politician, Integer>
{
    Iterable findPoliticianByLevelAndRegion(Enum level, String region);
}
