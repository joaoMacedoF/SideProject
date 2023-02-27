package com.project.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.project.model.MetadataDto;
import com.project.model.RoleDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PageRoleDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class PageRoleDto   {
  @JsonProperty("metadata")
  private MetadataDto metadata;

  @JsonProperty("data")
  @Valid
  private List<RoleDto> data = new ArrayList<>();

  public PageRoleDto metadata(MetadataDto metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Get metadata
   * @return metadata
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public MetadataDto getMetadata() {
    return metadata;
  }

  public void setMetadata(MetadataDto metadata) {
    this.metadata = metadata;
  }

  public PageRoleDto data(List<RoleDto> data) {
    this.data = data;
    return this;
  }

  public PageRoleDto addDataItem(RoleDto dataItem) {
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<RoleDto> getData() {
    return data;
  }

  public void setData(List<RoleDto> data) {
    this.data = data;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageRoleDto pageRoleDto = (PageRoleDto) o;
    return Objects.equals(this.metadata, pageRoleDto.metadata) &&
        Objects.equals(this.data, pageRoleDto.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadata, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageRoleDto {\n");
    
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

