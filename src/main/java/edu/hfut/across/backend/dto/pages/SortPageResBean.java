package edu.hfut.across.backend.dto.pages;

import edu.hfut.across.backend.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SortPageResBean {
    private List<Type> listType;
}
