package ru.itis.spring_11_402.dto;

import lombok.Builder;
import lombok.Data;
import ru.itis.spring_11_402.models.Article;
import ru.itis.spring_11_402.models.Service;

import javax.swing.plaf.basic.BasicButtonUI;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class ServiceDto {
    private Long id;
    private String name;
    private String cost;
    private String date;

    public static ServiceDto of(Service service) {
        return ServiceDto.builder()
                .id(service.getServiceId())
                .name(service.getName())
                .cost(service.getCost())
                .date(service.getDate())
                .build();
    }

    public static List<ServiceDto> from(List<Service> services){
        return services.stream()
                .map(ServiceDto::of)
                .collect(Collectors.toList());
    }
}
