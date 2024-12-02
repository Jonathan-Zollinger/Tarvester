package com.graqr.threshr

import com.graqr.threshr.model.queryparam.TargetStore
import com.graqr.threshr.model.queryparam.Tcin
import com.graqr.threshr.model.redsky.product.RelatedCategory
import com.graqr.threshr.model.redsky.store.Store
import com.graqr.threshr.model.redsky.store.nearby.NearbyStoreRoot
import groovy.sql.Sql
import io.micronaut.context.annotation.Value
import io.micronaut.core.io.ResourceLoader
import io.micronaut.serde.ObjectMapper
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Shared
import spock.lang.Specification

import java.util.stream.Stream

@MicronautTest
class ThreshrSpec extends Specification {

    @Inject
    @Shared
    Threshr threshrController

    @Inject
    @Shared
    ThreshrClient threshrClient

    @Inject
    @Shared
    ObjectMapper mapper

    @Shared
    Sql sql

    @Shared
    @Value('${test.datasources.default.url}')
    String url

    @Inject
    @Shared
    ResourceLoader resourceLoader

    @Shared
    @Value('${test.datasources.file.stores}')
    String storesFilePath

    @Shared
    RelatedCategory[] testCategories

    @Shared
    Store[] expectedStores

    @Shared
    Tcin[] testTcins

    byte[] getResourceFromFile(String filepath) {
        try {
            return resourceLoader.getResourceAsStream(filepath).get().readAllBytes()
        } catch (IOException e) {
            throw new ThreshrException(String.format("failed to load '%s'.", filepath), e)
        }
    }


    void setupSpec() {
        url = null != url ? url : System.getenv("TEST_DATASOURCES_DEFAULT_URL")
        sql = Sql.newInstance(url)
        testCategories = sql.rows('select id, category_name from test_target_categories')
                .stream().map(it -> new RelatedCategory(it.get('id') as String, it.get('category_name') as String))
        testTcins = sql.rows('select tcin from test_target_categories')
                .stream().map(it -> new Tcin(List.of(it.get('tcin') as String)))
//        expectedStores = sql.rows('select * from target_stores').stream().map(it -> mapper.readValue(it, Store)).toArray(Store[]::new)


    }

    @Shared
    // TODO configure test data to be provided, not hardcoded
    TargetStore targetStore = new TargetStore(
            "1750",
            "UT",
            "84014-1752",
            40.91825,
            -111.887)

    @Shared
    Tcin tcin =
}