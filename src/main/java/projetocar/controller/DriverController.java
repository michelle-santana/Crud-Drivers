package projetocar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetocar.domain.dto.DriverDTO;
import projetocar.repository.DriverRepository;
import projetocar.repository.entities.DriverEntity;
import projetocar.service.DriverService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/drivers")
public class DriverController {

    @Autowired
    private DriverRepository repository;

    private DriverDTO driverDTO;

    private DriverService service;


    @GetMapping(value = "/driver", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DriverEntity> getAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/driver/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DriverEntity> GetById(@PathVariable(value = "id") long id) {
        Optional<DriverEntity> driver = repository.findById(id);
        if(driver.isPresent())
            return new ResponseEntity<DriverEntity>(driver.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/drivers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DriverEntity> save(@RequestBody DriverEntity driver){
        repository.save(driver);

        return new ResponseEntity<>(driver, HttpStatus.OK);
    }

    @PutMapping(value = "/driver/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DriverEntity> Put(@PathVariable(value = "id") long id, @Valid @RequestBody DriverEntity newDriver)
    {
        Optional<DriverEntity> oldDriver = repository.findById(id);
        if(oldDriver.isPresent()){
            DriverEntity driver = oldDriver.get();
            driver.setName(newDriver.getName());
            repository.save(driver);
            return new ResponseEntity<DriverEntity>(driver, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping(value = "/driver/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<DriverEntity> driver = repository.findById(id);
        if(driver.isPresent()){
           repository.delete(driver.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
