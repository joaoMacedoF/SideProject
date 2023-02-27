package com.project.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.project.model.ElementsDto;
import com.project.model.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MetadataDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class MetadataDto   {
  @JsonProperty("page")
  private PageDto page;

  @JsonProperty("elements")
  private ElementsDto elements;

  @JsonProperty("sort")
  @Valid
  private List<String> sort = new ArrayList<>();

  public MetadataDto page(PageDto page) {
    this.page = page;
    return this;
  }

  /**
   * Get page
   * @return page
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public PageDto getPage() {
    return page;
  }

  public void setPage(PageDto page) {
    this.page = page;
  }

  public MetadataDto elements(ElementsDto elements) {
    this.elements = elements;
    return this;
  }

  /**
   * Get elements
   * @return elements
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public ElementsDto getElements() {
    return elements;
  }

  public void setElements(ElementsDto elements) {
    this.elements = elements;
  }

  public MetadataDto sort(List<String> sort) {
    this.sort = sort;
    return this;
  }

  public MetadataDto addSortItem(String sortItem) {
    this.sort.add(sortItem);
    return this;
  }

  /**
   * Get sort
   * @return sort
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public List<String> getSort() {
    return sort;
  }

  public void setSort(List<String> sort) {
    this.sort = sort;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MetadataDto metadataDto = (MetadataDto) o;
    return Objects.equals(this.page, metadataDto.page) &&
        Objects.equals(this.elements, metadataDto.elements) &&
        Objects.equals(this.sort, metadataDto.sort);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, elements, sort);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MetadataDto {\n");
    
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    elements: ").append(toIndentedString(elements)).append("\n");
    sb.append("    sort: ").append(toIndentedString(sort)).append("\n");
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

