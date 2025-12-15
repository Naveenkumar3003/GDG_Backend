package com.gdg.canteen.service;

import com.gdg.canteen.dto.MenuItemRequestDTO;
import com.gdg.canteen.dto.MenuItemResponseDTO;

import java.util.List;

public interface MenuItemService {

    MenuItemResponseDTO createMenuItem(MenuItemRequestDTO requestDTO);

    List<MenuItemResponseDTO> getAllMenuItems();

    MenuItemResponseDTO updateMenuItem(Long id, MenuItemRequestDTO requestDTO);

    void deleteMenuItem(Long id);
}