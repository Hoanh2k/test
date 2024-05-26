package com.java5.assigment1.Staff;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    @NotBlank(message = "Chưa nhập Id")
    private String id;
    @NotBlank(message = "Chưa nhập tên")
    private String name;
    @NotBlank(message = "Chưa nhập tên đăng nhập")
    private String userName;
    @NotBlank(message = "Chưa nhập mật khẩu")
    private String passWord;
    private Boolean status;
}
