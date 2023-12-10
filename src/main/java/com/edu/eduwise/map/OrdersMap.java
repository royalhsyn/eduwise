package com.edu.eduwise.map;

import com.edu.eduwise.dto.OrdersDto;
import com.edu.eduwise.model.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrdersMap {

    OrdersDto toDto(Orders orders);

    @Mapping(target = "id", ignore = true)
    Orders toEntity(OrdersDto ordersDto);


    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(@MappingTarget() Orders orders, OrdersDto ordersDto);
}
