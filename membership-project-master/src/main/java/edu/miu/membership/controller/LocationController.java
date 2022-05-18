package edu.miu.membership.controller;


import edu.miu.membership.domain.Location;
import edu.miu.membership.domain.Member;
import edu.miu.membership.service.LocationService;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/miu/locations")
public class LocationController {

    LocationService locationService;

    @Autowired
    LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @GetMapping()
    public ResponseEntity<List<Location>> findAll(){
        return ResponseEntity.ok(locationService.findAll());
    }

    @PostMapping()
    public ResponseEntity<Location> save(@RequestBody Location location) throws IOException, OutputException, BarcodeException {
        return new ResponseEntity<>(locationService.save(location), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(locationService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        locationService.deleteById(id);
        return new ResponseEntity<>("Delete operation successful!", HttpStatus.OK);

    }
}
