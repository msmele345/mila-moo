package com.mitchmele.milamoo.memory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemoriesResponse {

    private List<Memory> memories;
    private String status;
}
