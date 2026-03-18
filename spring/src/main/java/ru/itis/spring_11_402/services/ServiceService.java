package ru.itis.spring_11_402.services;

import ru.itis.spring_11_402.dto.ServiceDto;
import ru.itis.spring_11_402.dto.ServiceForm;

import java.util.List;

public interface ServiceService {
    ServiceDto addService(ServiceForm serviceForm);
    List<ServiceDto> search(Integer page, Integer size, String query, String directionParameter, String sortParameter);
}
