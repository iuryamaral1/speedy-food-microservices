package com.speedy.food.resources;

import com.speedy.food.Mapper;
import com.speedy.food.dto.InputDto;
import com.speedy.food.dto.OutputDto;
import com.speedy.food.model.Entity;
import com.speedy.food.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public abstract class AbstractResource<T extends Entity, RE extends PagingAndSortingRepository<T, Long>, IDto extends InputDto,
                                        ODto extends OutputDto, M extends Mapper<T, IDto, ODto>, S extends AbstractService<T, RE>> {

    @Autowired
    protected M mapper;

    @Autowired
    protected S service;

    @GetMapping(produces = { APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> findAll() {
        List<T> allObjects = service.findAll();
        List<OutputDto> outputDtoList = allObjects.stream()
                .map(object -> mapper.entityToOutputDto(object)).collect(Collectors.toList());
        return new ResponseEntity<>( outputDtoList, HttpStatus.OK );
    }

    @GetMapping(value = "/{id}", produces = { APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) {
        T objectFound = service.findBydId(id);

        if (Objects.isNull(objectFound)) {
            return ResponseEntity.notFound().build();
        }

        OutputDto outputDto = mapper.entityToOutputDto(objectFound);
        return new ResponseEntity<>( outputDto, HttpStatus.OK );
    }

    @PostMapping(consumes = { APPLICATION_JSON_VALUE }, produces = { APPLICATION_JSON_VALUE })
    public Response create(@RequestBody IDto iDto) throws Exception {
        try {
            T object = service.create(mapper.inputDtoToEntity(iDto));
            OutputDto outputObject = mapper.entityToOutputDto(object);
            return Response.status(Response.Status.CREATED).entity(outputObject).build();
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    @PutMapping(value = "/{id}", consumes = { APPLICATION_JSON_VALUE }, produces = { APPLICATION_JSON_VALUE })
    public Response update(@RequestBody IDto idto, @PathVariable("id") Long id) {
        T objectFound = service.findBydId(id);
        mapper.updateEntityFromDto(idto, objectFound);
        T updatedObject = service.update(objectFound);
        OutputDto outputDto = mapper.entityToOutputDto(updatedObject);
        return Response.ok().entity(outputDto).build();
    }

    @DeleteMapping(value = "/{id}", consumes = { APPLICATION_JSON_VALUE }, produces = { APPLICATION_JSON_VALUE })
    public Response delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return Response.ok().build();
    }

    protected abstract Class<T> getEntityClass();
}