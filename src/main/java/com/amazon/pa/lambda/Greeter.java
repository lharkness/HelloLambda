package com.amazon.pa.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Greeter implements RequestHandler<Request, Response> {

    public Response handleRequest(Request request, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("received : " + request.getValue());
        return new Response("Greetings " + request.getValue());
    }
}