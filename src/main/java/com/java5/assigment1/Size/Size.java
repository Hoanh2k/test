package com.java5.assigment1.Size;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Size {
    @NotBlank(message = "Chưa nhập Id")
    private String id;
    @NotBlank(message = "Chưa nhập mã")
    private String code;
    @NotBlank(message = "Chưa nhập tên")
    private String name;
    private Boolean status;
}
