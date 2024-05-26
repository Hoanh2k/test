package com.java5.assigment1.Guest;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@ToString
public class Guest {
    @NotBlank(message = "Chưa nhập Id")
    private String id;
    @NotBlank(message = "Chưa nhập tên")
    private String name;
    @NotBlank(message = "Chưa nhập số điện thoại")
    private String phone;
    @NotBlank(message = "Chưa nhập mã khách hàng")
    private String code;
    private Boolean status;

}
