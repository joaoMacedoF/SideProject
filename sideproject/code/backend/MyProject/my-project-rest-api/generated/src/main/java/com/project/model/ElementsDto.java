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
 * ElementsDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ElementsDto   {
  @JsonProperty("size")
  private Integer size;

  @JsonProperty("numberElements")
  private Integer numberElements;

  @JsonProperty("totalElements")
  private Long totalElements;

  public ElementsDto size(Integer size) {
    this.size = size;
    return this;
  }

  /**
   * Número de elementos por página.
   * @return size
  */
  @ApiModelProperty(required = true, value = "Número de elementos por página.")
  @NotNull


  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public ElementsDto numberElements(Integer numberElements) {
    this.numberElements = numberElements;
    return this;
  }

  /**
   * Número da elementos na página atual.
   * @return numberElements
  */
  @ApiModelProperty(required = true, value = "Número da elementos na página atual.")
  @NotNull


  public Integer getNumberElements() {
    return numberElements;
  }

  public void setNumberElements(Integer numberElements) {
    this.numberElements = numberElements;
  }

  public ElementsDto totalElements(Long totalElements) {
    this.totalElements = totalElements;
    return this;
  }

  /**
   * Número total de elementos.
   * @return totalElements
  */
  @ApiModelProperty(required = true, value = "Número total de elementos.")
  @NotNull


  public Long getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(Long totalElements) {
    this.totalElements = totalElements;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ElementsDto elementsDto = (ElementsDto) o;
    return Objects.equals(this.size, elementsDto.size) &&
        Objects.equals(this.numberElements, elementsDto.numberElements) &&
        Objects.equals(this.totalElements, elementsDto.totalElements);
  }

  @Override
  public int hashCode() {
    return Objects.hash(size, numberElements, totalElements);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ElementsDto {\n");
    
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    numberElements: ").append(toIndentedString(numberElements)).append("\n");
    sb.append("    totalElements: ").append(toIndentedString(totalElements)).append("\n");
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

