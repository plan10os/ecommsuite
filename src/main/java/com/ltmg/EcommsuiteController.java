package com.ltmg;

import io.micronaut.http.annotation.*;

@Controller("/ecommsuite")
public class EcommsuiteController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}