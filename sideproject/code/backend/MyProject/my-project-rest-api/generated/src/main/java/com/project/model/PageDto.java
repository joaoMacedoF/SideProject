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
 * PageDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class PageDto   {
  @JsonProperty("empty")
  private Boolean empty;

  @JsonProperty("first")
  private Boolean first;

  @JsonProperty("last")
  private Boolean last;

  @JsonProperty("page")
  private Integer page;

  @JsonProperty("totalPages")
  private Integer totalPages;

  @JsonProperty("paged")
  private Boolean paged;

  public PageDto empty(Boolean empty) {
    this.empty = empty;
    return this;
  }

  /**
   * Informa se a página atual está vazia.
   * @return empty
  */
  @ApiModelProperty(required = true, value = "Informa se a página atual está vazia.")
  @NotNull


  public Boolean getEmpty() {
    return empty;
  }

  public void setEmpty(Boolean empty) {
    this.empty = empty;
  }

  public PageDto first(Boolean first) {
    this.first = first;
    return this;
  }

  /**
   * Informa se a página atual é a primeira.
   * @return first
  */
  @ApiModelProperty(required = true, value = "Informa se a página atual é a primeira.")
  @NotNull


  public Boolean getFirst() {
    return first;
  }

  public void setFirst(Boolean first) {
    this.first = first;
  }

  public PageDto last(Boolean last) {
    this.last = last;
    return this;
  }

  /**
   * Informa se a página atual é a última.
   * @return last
  */
  @ApiModelProperty(required = true, value = "Informa se a página atual é a última.")
  @NotNull


  public Boolean getLast() {
    return last;
  }

  public void setLast(Boolean last) {
    this.last = last;
  }

  public PageDto page(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * Número da página atual.
   * @return page
  */
  @ApiModelProperty(required = true, value = "Número da página atual.")
  @NotNull


  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public PageDto totalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  /**
   * Número total de páginas.
   * @return totalPages
  */
  @ApiModelProperty(required = true, value = "Número total de páginas.")
  @NotNull


  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public PageDto paged(Boolean paged) {
    this.paged = paged;
    return this;
  }

  /**
   * Informa se a resposta tem paginação.
   * @return paged
  */
  @ApiModelProperty(required = true, value = "Informa se a resposta tem paginação.")
  @NotNull


  public Boolean getPaged() {
    return paged;
  }

  public void setPaged(Boolean paged) {
    this.paged = paged;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageDto pageDto = (PageDto) o;
    return Objects.equals(this.empty, pageDto.empty) &&
        Objects.equals(this.first, pageDto.first) &&
        Objects.equals(this.last, pageDto.last) &&
        Objects.equals(this.page, pageDto.page) &&
        Objects.equals(this.totalPages, pageDto.totalPages) &&
        Objects.equals(this.paged, pageDto.paged);
  }

  @Override
  public int hashCode() {
    return Objects.hash(empty, first, last, page, totalPages, paged);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageDto {\n");
    
    sb.append("    empty: ").append(toIndentedString(empty)).append("\n");
    sb.append("    first: ").append(toIndentedString(first)).append("\n");
    sb.append("    last: ").append(toIndentedString(last)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("    paged: ").append(toIndentedString(paged)).append("\n");
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

