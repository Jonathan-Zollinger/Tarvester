package com.github.graqr.threshr;

import com.github.graqr.threshr.model.products.Products;
import io.micronaut.http.HttpResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ThreshrControllerTest extends ThreshrTest {

    @Test
    void fetchProducts() {
        HttpResponse<Products> response = controller.fetchProducts(testApiKey, tcinList, targetStore);
        response.body();
        assertTrue(okResponse.test(response));
        assertTrue(productsCount.test(response));
    }
}