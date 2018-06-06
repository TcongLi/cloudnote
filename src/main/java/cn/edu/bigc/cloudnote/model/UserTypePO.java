package cn.edu.bigc.cloudnote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class UserTypePO {
    private Integer typeId;

    private String typeCode;

    private String typeName;

    private String typeDesc;

    private Integer maxNote;
}
