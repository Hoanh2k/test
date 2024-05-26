package com.java5.assigment1.Invoice;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @NotBlank(message ="Mời nhập lại")
    private String id;
    @NotBlank(message ="Mời nhập lại")
    private String idNV;
    @NotBlank(message ="Mời nhập lại")
    private String idKH;
    @NotBlank(message ="Mời nhập lại")
    private String ngayMuaHang;
    private boolean trangThai;
}
