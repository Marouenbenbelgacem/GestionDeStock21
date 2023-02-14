package org.sid.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sid.dto.CategoryDto;
import org.sid.exception.EntityNotFoundException;
import org.sid.exception.ErrorCodes;
import org.sid.exception.InvalidEntityException;
import org.sid.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) // utliser le springRunner pour executer les test unitaires
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void shouldSaveCategoryWithSuccess() {

        CategoryDto expectedCategory = CategoryDto.builder()
                .codeCategory("cat test")
                .designation("designation test")
                .idEntreprise(1)
                .build();

        CategoryDto savedCategory = categoryService.save(expectedCategory);

        assertNotNull(savedCategory);
        assertNotNull(savedCategory.getId());
        assertEquals(expectedCategory.getCodeCategory(), savedCategory.getCodeCategory());
        assertEquals(expectedCategory.getDesignation(), savedCategory.getDesignation());
        assertEquals(expectedCategory.getIdEntreprise(), savedCategory.getIdEntreprise());

    }

    @Test
    public void shouldUpdateCategoryWithSuccess() {

        CategoryDto expectedCategory = CategoryDto.builder()
                .codeCategory("cat test")
                .designation("designation test")
                .idEntreprise(1)
                .build();

        CategoryDto savedCategory = categoryService.save(expectedCategory);
        CategoryDto categoryToUpdate = savedCategory;

        categoryToUpdate.setCodeCategory("cat update");
        CategoryDto savedCategory2 = categoryService.save(categoryToUpdate);

        assertNotNull(categoryToUpdate);
        assertNotNull(categoryToUpdate.getId());
        assertEquals(categoryToUpdate.getCodeCategory(), savedCategory.getCodeCategory());
        assertEquals(categoryToUpdate.getDesignation(), savedCategory.getDesignation());
        assertEquals(categoryToUpdate.getIdEntreprise(), savedCategory.getIdEntreprise());

    }

    @Test
    public void shouldThrowInvalidEntityException() {
        CategoryDto expectedCategory = CategoryDto.builder().build();
        InvalidEntityException expectedException = assertThrows(InvalidEntityException.class, () -> categoryService.save(expectedCategory));
        assertEquals(ErrorCodes.CATEGORY_NOT_VALID, expectedException.getErrorCode());
        assertEquals(1, expectedException.getErrors().size());
        assertEquals("Veuillez saisir votre code correctement !!", expectedException.getErrors().get(0));
    }

    @Test
    public void shouldThrowEntityNotFoundException() {

        EntityNotFoundException expectedException = assertThrows(EntityNotFoundException.class, () -> categoryService.findById(0));
        assertEquals(ErrorCodes.CATEGORY_NOT_FOUND, expectedException.getErrorCode());
        assertEquals("Category n'est pas trouvé avec ce ID = 0 dans la BDD", expectedException.getMessage());

    }
    @Test(expected = EntityNotFoundException.class)
    public void shouldThrowEntityNotFoundException2() {

      categoryService.findById(0);

    }



}
