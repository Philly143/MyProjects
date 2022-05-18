package edu.miu.membership.service;

import edu.miu.membership.domain.Badge;
import edu.miu.membership.domain.Location;
import edu.miu.membership.dto.BadgeDto;
import edu.miu.membership.dto.LocationDto;
import edu.miu.membership.exception.custom.EntityNotFoundException;
import edu.miu.membership.modelmapper.MapStruct;
import edu.miu.membership.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Asma Aiouez
 * @DATE 5/16/22
 */

@Service
@Transactional
public class LocationServiceImpl implements LocationService{

    private LocationRepository locationRepository;
    private MapStruct mapStruct;

    @Autowired
    LocationServiceImpl(LocationRepository locationRepository, MapStruct mapStruct){
        this.locationRepository= locationRepository;
        this.mapStruct = mapStruct;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location getById(Long id) {
        return locationRepository.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        locationRepository.deleteById(id);
    }

    @Override
    public Optional<LocationDto> findById(Long id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id+ " not found"));
        return Optional.of(mapStruct.convertToLocationDto(location));
    }
}
