package cn.edu.bigc.cloudnote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class GroupNotepagePO {
    private Integer id;

    private Integer groupId;

    private Integer notepageId;
}
