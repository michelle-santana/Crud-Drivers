package projetocar.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import projetocar.domain.dto.DriverDTO;
import projetocar.repository.DriverRepository;
import projetocar.repository.entities.DriverEntity;

import java.util.List;

@Service
@Slf4j
public class DriverService {


    private DriverDTO driverDTO;

    private DriverEntity entity;

    private DriverRepository repository;


    public List<DriverDTO> listAll() {
        List<DriverEntity> allPeople = repository.findAll();
        return listAll();

    }
}
