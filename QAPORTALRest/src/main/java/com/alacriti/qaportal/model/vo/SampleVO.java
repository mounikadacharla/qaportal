package com.alacriti.qaportal.model.vo;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;




@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2016-11-24T11:58:59.086+05:30")
public class SampleVO   {
  
  private String addressLine1 = null;
  private String addressLine2 = null;
  private String addressCity = null;
  private String addressState = null;
  private String addressCountry = null;
  private String addressZip1 = null;
  private String addressZip2 = null;

  /**
   **/
  
  @JsonProperty("address_line1")
  public String getAddressLine1() {
    return addressLine1;
  }
  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  /**
   **/
  
  @JsonProperty("address_line2")
  public String getAddressLine2() {
    return addressLine2;
  }
  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }

  /**
   **/
  
  @JsonProperty("address_city")
  public String getAddressCity() {
    return addressCity;
  }
  public void setAddressCity(String addressCity) {
    this.addressCity = addressCity;
  }

  /**
   **/
  
  @JsonProperty("address_state")
  public String getAddressState() {
    return addressState;
  }
  public void setAddressState(String addressState) {
    this.addressState = addressState;
  }

  /**
   * The 3 digit ISO country code.
   **/
  
  @JsonProperty("address_country")
  public String getAddressCountry() {
    return addressCountry;
  }
  public void setAddressCountry(String addressCountry) {
    this.addressCountry = addressCountry;
  }

  /**
   **/
  
  @JsonProperty("address_zip1")
  public String getAddressZip1() {
    return addressZip1;
  }
  public void setAddressZip1(String addressZip1) {
    this.addressZip1 = addressZip1;
  }

  /**
   **/
  
  @JsonProperty("address_zip2")
  public String getAddressZip2() {
    return addressZip2;
  }
  public void setAddressZip2(String addressZip2) {
    this.addressZip2 = addressZip2;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SampleVO address = (SampleVO) o;
    return Objects.equals(addressLine1, address.addressLine1) &&
        Objects.equals(addressLine2, address.addressLine2) &&
        Objects.equals(addressCity, address.addressCity) &&
        Objects.equals(addressState, address.addressState) &&
        Objects.equals(addressCountry, address.addressCountry) &&
        Objects.equals(addressZip1, address.addressZip1) &&
        Objects.equals(addressZip2, address.addressZip2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addressLine1, addressLine2, addressCity, addressState, addressCountry, addressZip1, addressZip2);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Address {\n");
    
    sb.append("    addressLine1: ").append(toIndentedString(addressLine1)).append("\n");
    sb.append("    addressLine2: ").append(toIndentedString(addressLine2)).append("\n");
    sb.append("    addressCity: ").append(toIndentedString(addressCity)).append("\n");
    sb.append("    addressState: ").append(toIndentedString(addressState)).append("\n");
    sb.append("    addressCountry: ").append(toIndentedString(addressCountry)).append("\n");
    sb.append("    addressZip1: ").append(toIndentedString(addressZip1)).append("\n");
    sb.append("    addressZip2: ").append(toIndentedString(addressZip2)).append("\n");
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

