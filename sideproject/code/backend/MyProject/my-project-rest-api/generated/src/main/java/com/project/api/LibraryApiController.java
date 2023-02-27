package com.project.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Controller
@RequestMapping("${openapi.libraryService.base-path:}")
public class LibraryApiController implements LibraryApi {

    private final LibraryApiDelegate delegate;

    public LibraryApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) LibraryApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new LibraryApiDelegate() {});
    }

    @Override
    public LibraryApiDelegate getDelegate() {
        return delegate;
    }

}
