package br.com.uol.customerapi.model.dto;

import org.modelmapper.ModelMapper;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class DTOMapper<DTO, MODEL> implements MapperDTO<DTO, MODEL>, Serializable {
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public MODEL fromDTO(DTO dto) {
        return modelMapper.map(dto, this.returnModelClass());
    }

    @Override
    public DTO toDTO(MODEL object) {
        return modelMapper.map(object, this.returnDTOClass());
    }

    @Override
    public List<MODEL> fromDTO(List<DTO> dtos) {
        return Optional.ofNullable(dtos)
                .map(d -> d.stream().map(this::fromDTO).collect(Collectors.toList()))
                .orElse(null);
    }

    @Override
    public List<DTO> toDTO(List<MODEL> objects) {
        return Optional.ofNullable(objects)
                .map(o -> o.stream().map(this::toDTO).collect(Collectors.toList()))
                .orElse(null);
    }

}
