package com.ltmg;
import com.agorapulse.gru.Gru;
import com.agorapulse.gru.micronaut.Micronaut;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

@MicronautTest
class HelloWorldGruControllerTest {

    @Inject
    Gru gru;

    @Test
    void testGet() throws Throwable {
        gru.verify(test -> test
            .get("/gru")
            .expect(response -> response.json("gruIndex.json"))
        );
    }

}