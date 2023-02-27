package com.project.api;

import com.project.model.CreateOrUpdateRoleApiRequestDto;
import com.project.model.ErrorResponseObject;
import org.springframework.data.domain.Pageable;
import com.project.model.RequestDtoPageRoleDto;
import com.project.model.ResponseDtoPageRoleDto;
import com.project.model.ResponseDtoRoleDto;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link RoleApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public interface RoleApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * PUT /roles : createOrUpdateRole
     *
     * @param apiRequest apiRequest (required)
     * @return OK (status code 200)
     *         or Common error (status code 400)
     *         or The user doesn&#39;t have permission to make the operation. (status code 403)
     * @see RoleApi#createOrUpdateRoleUsingPUT
     */
    default ResponseEntity<ResponseDtoRoleDto> createOrUpdateRoleUsingPUT(CreateOrUpdateRoleApiRequestDto apiRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "null";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /roles : getRoles
     *
     * @param apiRequest  (optional)
     * @param pageable  (optional)
     * @param unpaged  (optional)
     * @return OK (status code 200)
     *         or Common error (status code 400)
     *         or The user doesn&#39;t have permission to make the operation. (status code 403)
     * @see RoleApi#getRolesUsingGET
     */
    default ResponseEntity<ResponseDtoPageRoleDto> getRolesUsingGET(RequestDtoPageRoleDto apiRequest,
        Pageable pageable,
        Boolean unpaged) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "null";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
