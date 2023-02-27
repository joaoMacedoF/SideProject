package com.project.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreateOrUpdateRoleApiRequestDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class CreateOrUpdateRoleApiRequestDto   {
  @JsonProperty("roleDescription")
  private String roleDescription;

  @JsonProperty("roleName")
  private String roleName;

  @JsonProperty("pk")
  private Long pk;

  public CreateOrUpdateRoleApiRequestDto roleDescription(String roleDescription) {
    this.roleDescription = roleDescription;
    return this;
  }

  /**
   * Get roleDescription
   * @return roleDescription
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getRoleDescription() {
    return roleDescription;
  }

  public void setRoleDescription(String roleDescription) {
    this.roleDescription = roleDescription;
  }

  public CreateOrUpdateRoleApiRequestDto roleName(String roleName) {
    this.roleName = roleName;
    return this;
  }

  /**
   * Get roleName
   * @return roleName
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public CreateOrUpdateRoleApiRequestDto pk(Long pk) {
    this.pk = pk;
    return this;
  }

  /**
   * Get pk
   * @return pk
  */
  @ApiModelProperty(value = "")


  public Long getPk() {
    return pk;
  }

  public void setPk(Long pk) {
    this.pk = pk;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateOrUpdateRoleApiRequestDto createOrUpdateRoleApiRequestDto = (CreateOrUpdateRoleApiRequestDto) o;
    return Objects.equals(this.roleDescription, createOrUpdateRoleApiRequestDto.roleDescription) &&
        Objects.equals(this.roleName, createOrUpdateRoleApiRequestDto.roleName) &&
        Objects.equals(this.pk, createOrUpdateRoleApiRequestDto.pk);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roleDescription, roleName, pk);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateOrUpdateRoleApiRequestDto {\n");
    
    sb.append("    roleDescription: ").append(toIndentedString(roleDescription)).append("\n");
    sb.append("    roleName: ").append(toIndentedString(roleName)).append("\n");
    sb.append("    pk: ").append(toIndentedString(pk)).append("\n");
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

