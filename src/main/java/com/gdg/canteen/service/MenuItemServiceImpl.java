package com.gdg.canteen.service;

import com.gdg.canteen.dto.MenuItemRequestDTO;
import com.gdg.canteen.dto.MenuItemResponseDTO;
import com.gdg.canteen.entity.MenuItem;
import com.gdg.canteen.exception.MenuItemNotFoundException;
import com.gdg.canteen.repository.MenuItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

    @Override
    @Transactional
    public MenuItemResponseDTO createMenuItem(MenuItemRequestDTO requestDTO) {
        MenuItem menuItem = new MenuItem();
        menuItem.setName(requestDTO.getName());
        menuItem.setPrice(requestDTO.getPrice());
        menuItem.setCategory(requestDTO.getCategory());
        menuItem.setAvailability(requestDTO.getAvailability());

        MenuItem savedItem = menuItemRepository.save(menuItem);
        return mapToResponseDTO(savedItem);
    }

    @Override
    public List<MenuItemResponseDTO> getAllMenuItems() {
        return menuItemRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MenuItemResponseDTO updateMenuItem(Long id, MenuItemRequestDTO requestDTO) {
        MenuItem menuItem = menuItemRepository.findById(id)
                .orElseThrow(() -> new MenuItemNotFoundException("Menu item not found with id: " + id));

        menuItem.setName(requestDTO.getName());
        menuItem.setPrice(requestDTO.getPrice());
        menuItem.setCategory(requestDTO.getCategory());
        menuItem.setAvailability(requestDTO.getAvailability());

        MenuItem updatedItem = menuItemRepository.save(menuItem);
        return mapToResponseDTO(updatedItem);
    }

    @Override
    @Transactional
    public void deleteMenuItem(Long id) {
        if (!menuItemRepository.existsById(id)) {
            throw new MenuItemNotFoundException("Menu item not found with id: " + id);
        }
        menuItemRepository.deleteById(id);
    }

    private MenuItemResponseDTO mapToResponseDTO(MenuItem menuItem) {
        return new MenuItemResponseDTO(
                menuItem.getId(),
                menuItem.getName(),
                menuItem.getPrice(),
                menuItem.getCategory(),
                menuItem.getAvailability()
        );
    }
}