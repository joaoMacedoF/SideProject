package com.project.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.project.model.RequestDto;
import com.project.model.RequestDtoPageRoleDtoAllOf;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RequestDtoPageRoleDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class RequestDtoPageRoleDto extends RequestDto  {
  @JsonProperty("roleName")
  private String roleName;

  @JsonProperty("roleDescription")
  private String roleDescription;

  public RequestDtoPageRoleDto roleName(String roleName) {
    this.roleName = roleName;
    return this;
  }

  /**
   * Get roleName
   * @return roleName
  */
  @ApiModelProperty(value = "")


  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public RequestDtoPageRoleDto roleDescription(String roleDescription) {
    this.roleDescription = roleDescription;
    return this;
  }

  /**
   * Get roleDescription
   * @return roleDescription
  */
  @ApiModelProperty(value = "")


  public String getRoleDescription() {
    return roleDescription;
  }

  public void setRoleDescription(String roleDescription) {
    this.roleDescription = roleDescription;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestDtoPageRoleDto requestDtoPageRoleDto = (RequestDtoPageRoleDto) o;
    return Objects.equals(this.roleName, requestDtoPageRoleDto.roleName) &&
        Objects.equals(this.roleDescription, requestDtoPageRoleDto.roleDescription) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roleName, roleDescription, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestDtoPageRoleDto {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    roleName: ").append(toIndentedString(roleName)).append("\n");
    sb.append("    roleDescription: ").append(toIndentedString(roleDescription)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

