package com.amazon.pa.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GreeterTest {

    @Mock
    private Context mockContext;
    @Mock
    private ClientContext mockClientContext;

    @Mock
    private LambdaLogger mockLambdaLogger;

    @Before
    public void setup() {
        when(mockContext.getLogger()).thenReturn(mockLambdaLogger);

    }

    @Test
    public void testThatGreetingContainsTheGreetedsName() {
        String greetedsName = "Keith";
        Request ourRequest = new Request();
        ourRequest.setValue(greetedsName);

        Greeter target = new Greeter();
        Response ourResponse = target.handleRequest(ourRequest, mockContext);

        ArgumentCaptor<String> logMessageCaptor = ArgumentCaptor.forClass(String.class);
        verify(mockLambdaLogger).log(logMessageCaptor.capture());
        assertThat(ourResponse.getValue().contains(greetedsName), is(true));
        assertThat(logMessageCaptor.getValue().contains(greetedsName), is(true));
    }
}
