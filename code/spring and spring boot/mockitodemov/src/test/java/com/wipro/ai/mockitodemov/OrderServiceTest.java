package com.wipro.ai.mockitodemov;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    @Test
    public void testPlaceOrderMocked() {
        
        OrderService orderServiceMock = mock(OrderService.class);
        when(orderServiceMock.placeOrder("ORD-01")).thenReturn("successful");
        String result = orderServiceMock.placeOrder("ORD-01");
        assertEquals("successful", result);
    }
}

