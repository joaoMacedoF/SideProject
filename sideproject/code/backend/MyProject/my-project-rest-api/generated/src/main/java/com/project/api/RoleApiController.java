package com.project.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Controller
@RequestMapping("${openapi.libraryService.base-path:}")
public class RoleApiController implements RoleApi {

    private final RoleApiDelegate delegate;

    public RoleApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) RoleApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new RoleApiDelegate() {});
    }

    @Override
    public RoleApiDelegate getDelegate() {
        return delegate;
    }

}
