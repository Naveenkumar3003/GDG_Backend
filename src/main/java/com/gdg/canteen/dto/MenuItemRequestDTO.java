package com.gdg.canteen.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemRequestDTO {

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    private Double price;

    @NotBlank(message = "Category is required")
    @Pattern(regexp = "Breakfast|Lunch|Dinner|Snacks|Drinks|Desserts",
            message = "Category must be one of: Breakfast, Lunch, Dinner, Snacks, Drinks, Desserts")
    private String category;

    @NotNull(message = "Availability status is required")
    private Boolean availability;
}