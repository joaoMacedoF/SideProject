package com.project.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ResponseDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "response_type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = ResponseDtoListBookDto.class, name = "ResponseDtoListBookDto"),
  @JsonSubTypes.Type(value = ResponseDtoPageRoleDto.class, name = "ResponseDtoPageRoleDto"),
  @JsonSubTypes.Type(value = ResponseDtoRoleDto.class, name = "ResponseDtoRoleDto"),
})

public class ResponseDto   {
  @JsonProperty("error")
  private String error;

  @JsonProperty("message")
  private String message;

  @JsonProperty("optionals")
  @Valid
  private Map<String, String> optionals = null;

  public ResponseDto error(String error) {
    this.error = error;
    return this;
  }

  /**
   * Get error
   * @return error
  */
  @ApiModelProperty(value = "")


  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public ResponseDto message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ResponseDto optionals(Map<String, String> optionals) {
    this.optionals = optionals;
    return this;
  }

  public ResponseDto putOptionalsItem(String key, String optionalsItem) {
    if (this.optionals == null) {
      this.optionals = new HashMap<>();
    }
    this.optionals.put(key, optionalsItem);
    return this;
  }

  /**
   * Get optionals
   * @return optionals
  */
  @ApiModelProperty(value = "")


  public Map<String, String> getOptionals() {
    return optionals;
  }

  public void setOptionals(Map<String, String> optionals) {
    this.optionals = optionals;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseDto responseDto = (ResponseDto) o;
    return Objects.equals(this.error, responseDto.error) &&
        Objects.equals(this.message, responseDto.message) &&
        Objects.equals(this.optionals, responseDto.optionals);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error, message, optionals);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseDto {\n");
    
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    optionals: ").append(toIndentedString(optionals)).append("\n");
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

