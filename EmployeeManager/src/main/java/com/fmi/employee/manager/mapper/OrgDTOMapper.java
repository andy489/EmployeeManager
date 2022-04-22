package com.fmi.employee.manager.mapper;

import com.fmi.employee.manager.dto.OrgDTO;
import com.fmi.employee.manager.dto.OrgDTOWithId;
import com.fmi.employee.manager.model.Organization;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrgDTOMapper {
   public OrgDTO toDTO(Organization org){
      return new OrgDTO(org.getName(), org.getWebsite());
   }

   public OrgDTOWithId toDTOWithId(Organization org){
      return new OrgDTOWithId(org.getId(), org.getName(), org.getWebsite());
   }

   public List<OrgDTO> toDTOList(List<Organization> orgList){
      return orgList.stream().map(this::toDTO).collect(Collectors.toList());
   }
}
