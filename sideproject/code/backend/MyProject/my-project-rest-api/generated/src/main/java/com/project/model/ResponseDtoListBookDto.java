package com.project.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.project.model.BookDto;
import com.project.model.ResponseDto;
import com.project.model.ResponseDtoListBookDtoAllOf;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ResponseDtoListBookDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ResponseDtoListBookDto extends ResponseDto  {
  @JsonProperty("response")
  @Valid
  private List<BookDto> response = new ArrayList<>();

  public ResponseDtoListBookDto response(List<BookDto> response) {
    this.response = response;
    return this;
  }

  public ResponseDtoListBookDto addResponseItem(BookDto responseItem) {
    this.response.add(responseItem);
    return this;
  }

  /**
   * Get response
   * @return response
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<BookDto> getResponse() {
    return response;
  }

  public void setResponse(List<BookDto> response) {
    this.response = response;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseDtoListBookDto responseDtoListBookDto = (ResponseDtoListBookDto) o;
    return Objects.equals(this.response, responseDtoListBookDto.response) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(response, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseDtoListBookDto {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
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

