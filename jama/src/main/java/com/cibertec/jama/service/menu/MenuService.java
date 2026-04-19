package com.cibertec.jama.service.menu;

import com.cibertec.jama.entities.menu.MenuCategory;
import com.cibertec.jama.entities.menu.MenuType;
import com.cibertec.jama.repositories.menu.MenuCategoryRepository;
import com.cibertec.jama.repositories.menu.MenuRepository;
import com.cibertec.jama.repositories.menu.MenuSkuRepository;
import com.cibertec.jama.repositories.menu.MenuTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final MenuTypeRepository menuTypeRepository;
    private final MenuCategoryRepository menuCategoryRepository;
    private final MenuSkuRepository menuSkuRepository;


    public List<MenuType> getAllTypes() {
        return menuTypeRepository.findAll();
    }

    public List<MenuCategory> getAllCategories() {
        return menuCategoryRepository.findAll();
    }

    public void saveType(MenuType type) {
        if (type != null) {
            menuTypeRepository.save(type);
        }
    }

    public MenuType getTypeById(int id) {
        return menuTypeRepository.findById(id).orElse(null);
    }

    public void updateType(MenuType type, int id) {
        var dbType = menuTypeRepository.findById(id).orElse(null);
        if (dbType != null) {
            dbType.setNombre(type.getNombre());
            dbType.setDescripcion(type.getDescripcion());
            menuTypeRepository.save(dbType);
        }
    }

    public void deleteType(int deleteId) {
        menuTypeRepository.deleteById(deleteId);
    }

    public void initTipos() {
        var types = menuTypeRepository.findAll();
        if (!types.isEmpty()) {
            return;
        }

        var list = new ArrayList<MenuType>();

        var extra = new MenuType();
        extra.setNombre("extra");
        extra.setDescripcion("Extra");

        var postre = new MenuType();
        postre.setNombre("postre");
        postre.setDescripcion("Postre");

        var entrada = new MenuType();
        entrada.setNombre("entrada");
        entrada.setDescripcion("Entrada");

        var ensalada = new MenuType();
        ensalada.setNombre("ensalada");
        ensalada.setDescripcion("Ensalada");

        var main = new MenuType();
        main.setNombre("main");
        main.setDescripcion("Main");

        list.add(extra);
        list.add(postre);
        list.add(entrada);
        list.add(ensalada);
        menuTypeRepository.saveAll(list);
    }


    /*categoria*/
    public void saveCategory(MenuCategory category) {
        menuCategoryRepository.save(category);
    }

    public void updateCategory(MenuCategory category, int id) {
        var dbType = menuTypeRepository.findById(id).orElse(null);
        if (dbType != null) {
            dbType.setNombre(category.getName());
            dbType.setDescripcion(category.getDescription());
            menuTypeRepository.save(dbType);
        }
    }

    public void deleteCategory(int id) {
        menuCategoryRepository.deleteById(id);
    }

    public MenuCategory getCategoriesById(int id) {
        return menuCategoryRepository.findById(id).orElse(null);
    }
    public void initCategories() {
        var categories = menuCategoryRepository.findAll();
        if (!categories.isEmpty()) {
            return;
        }


        var list = new ArrayList<MenuCategory>();

        var pasta = new MenuCategory();
        pasta.setName("pasta");
        pasta.setDescription("Pasta");

        var arroces = new MenuCategory();
        arroces.setName("arroces");
        arroces.setDescription("Arroces");

        var criollos = new MenuCategory();
        criollos.setName("criollos");
        criollos.setDescription("Criollos");

        var bebidas = new MenuCategory();
        bebidas.setName("bebidas");
        bebidas.setDescription("Bebidas");

        var saltados = new MenuCategory();
        saltados.setName("saltados");
        saltados.setDescription("Saltados");

        list.add(pasta);
        list.add(arroces);
        list.add(criollos);
        list.add(bebidas);
        list.add(saltados);
        menuCategoryRepository.saveAll(list);
    }
}
