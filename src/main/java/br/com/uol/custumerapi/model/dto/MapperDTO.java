package br.com.uol.custumerapi.model.dto;

import java.util.List;

public interface MapperDTO<DTO, MODEL> {
    MODEL fromDTO(DTO dto);
    DTO toDTO(MODEL object);
    List<MODEL> fromDTO(List<DTO> dto);
    List<DTO> toDTO(List<MODEL> object);
    Class<MODEL> returnModelClass();
    Class<DTO> returnDTOClass();
}
