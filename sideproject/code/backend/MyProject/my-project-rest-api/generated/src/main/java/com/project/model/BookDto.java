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
 * This is the book model
 */
@ApiModel(description = "This is the book model")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class BookDto   {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("bookAuthor")
  private String bookAuthor;

  public BookDto id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * The name of book
   * @return id
  */
  @ApiModelProperty(value = "The name of book")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public BookDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of book
   * @return name
  */
  @ApiModelProperty(value = "The name of book")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BookDto bookAuthor(String bookAuthor) {
    this.bookAuthor = bookAuthor;
    return this;
  }

  /**
   * name of author
   * @return bookAuthor
  */
  @ApiModelProperty(value = "name of author")


  public String getBookAuthor() {
    return bookAuthor;
  }

  public void setBookAuthor(String bookAuthor) {
    this.bookAuthor = bookAuthor;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookDto bookDto = (BookDto) o;
    return Objects.equals(this.id, bookDto.id) &&
        Objects.equals(this.name, bookDto.name) &&
        Objects.equals(this.bookAuthor, bookDto.bookAuthor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, bookAuthor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    bookAuthor: ").append(toIndentedString(bookAuthor)).append("\n");
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

