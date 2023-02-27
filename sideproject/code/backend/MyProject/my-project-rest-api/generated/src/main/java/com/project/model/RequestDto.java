package com.project.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RequestDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "request_type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = RequestDtoPageRoleDto.class, name = "RequestDtoPageRoleDto"),
})

public class RequestDto   {
  @JsonProperty("export")
  private String export;

  public RequestDto export(String export) {
    this.export = export;
    return this;
  }

  /**
   * Get export
   * @return export
  */
  @ApiModelProperty(value = "")


  public String getExport() {
    return export;
  }

  public void setExport(String export) {
    this.export = export;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestDto requestDto = (RequestDto) o;
    return Objects.equals(this.export, requestDto.export);
  }

  @Override
  public int hashCode() {
    return Objects.hash(export);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestDto {\n");
    
    sb.append("    export: ").append(toIndentedString(export)).append("\n");
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

