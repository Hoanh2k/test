package com.java5.assigment1.Product;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @NotBlank(message = "Chưa nhập Id")
    private String id;
    @NotBlank(message = "Chưa nhập mã")
    private  String code;
    @NotBlank(message = "Chưa nhập tên")
    private String name;
    private Boolean status;
}
