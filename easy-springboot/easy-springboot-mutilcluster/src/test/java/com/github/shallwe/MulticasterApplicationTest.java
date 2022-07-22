package com.github.shallwe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MulticasterApplicationTest {

    @Test
    public void publish() {
        Publisher.publishEvent(new TenantCreatedEvent(new TenantId(123)));
    }

}