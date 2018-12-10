package com.poc.boldconnect.bl;

import static org.junit.Assert.assertTrue;

import com.poc.boldconnect.exception.ClientSideException;
import org.junit.Test;

public class ParameterValidatorTest {
    private ParameterValidator parameterValidator = new ParameterValidator();

    @Test(expected = ClientSideException.class)
    public void givenShortStoreNumberThenThrowClientSideException() throws ClientSideException {
        parameterValidator.validateAccountId("12");
    }

    @Test(expected = ClientSideException.class)
    public void givenLongStoreNumberThenThrowClientSideException() throws ClientSideException {
        parameterValidator.validateAccountId("12345624324324324244234324324234324");
    }

    @Test(expected = ClientSideException.class)
    public void givenAlphaStoreNumberThenThrowClientSideException() throws ClientSideException {
        parameterValidator.validateAccountId("Store121");
    }

    @Test(expected = ClientSideException.class)
    public void givenSpaceStoreNumberThenThrowClientSideException() throws ClientSideException {
        parameterValidator.validateAccountId("Store 0121");
    }

    @Test
    public void givenGoodStoreNumberThenDontThrowClientSideException() throws ClientSideException {
        parameterValidator.validateAccountId("161640");
        assertTrue(true);
    }
}
