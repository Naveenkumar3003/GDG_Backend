package com.gdg.canteen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemResponseDTO {

    private Long id;
    private String name;
    private Double price;
    private String category;
    private Boolean availability;
}