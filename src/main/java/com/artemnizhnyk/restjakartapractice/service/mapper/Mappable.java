package com.artemnizhnyk.restjakartapractice.service.mapper;

import com.artemnizhnyk.restjakartapractice.domain.model.Task;

import java.util.List;

public interface Mappable<E, D> {

    E toEntity(final D dto);

    D toDto(final E entity);

    List<E> toEntity(final List<D> dto);

    List<D> toDto(final List<E> entity);

}
