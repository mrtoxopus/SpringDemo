package com.nhl.demo.mapper;

import java.util.List;

public interface Mapper<T, U> {
    
    T toDTO(U u);
    
    List<T> toDTO(List<U> u);
    
    U toEntity(T t);
}
