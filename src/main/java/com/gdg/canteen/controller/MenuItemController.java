package com.gdg.canteen.controller;

import com.gdg.canteen.dto.MenuItemRequestDTO;
import com.gdg.canteen.dto.MenuItemResponseDTO;
import com.gdg.canteen.service.MenuItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class MenuItemController {

    private final MenuItemService menuItemService;

    @PostMapping
    public ResponseEntity<MenuItemResponseDTO> createMenuItem(
            @Valid @RequestBody MenuItemRequestDTO requestDTO) {
        MenuItemResponseDTO responseDTO = menuItemService.createMenuItem(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MenuItemResponseDTO>> getAllMenuItems() {
        List<MenuItemResponseDTO> items = menuItemService.getAllMenuItems();
        return ResponseEntity.ok(items);
    }


    @PutMapping("/{id}")
    public ResponseEntity<MenuItemResponseDTO> updateMenuItem(
            @PathVariable Long id,
            @Valid @RequestBody MenuItemRequestDTO requestDTO) {
        MenuItemResponseDTO responseDTO = menuItemService.updateMenuItem(id, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long id) {
        menuItemService.deleteMenuItem(id);
        return ResponseEntity.noContent().build();
    }
}