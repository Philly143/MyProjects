package edu.miu.membership.service;

import edu.miu.membership.domain.Location;
import edu.miu.membership.dto.LocationDto;

import java.util.List;
import java.util.Optional;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Asma Aiouez
 * @DATE 5/16/22
 */


public interface LocationService {

    List<Location> findAll();

    Location save(Location location);

    Location getById(Long id);

    void deleteById(Long id);

    Optional<LocationDto> findById(Long id);
}
