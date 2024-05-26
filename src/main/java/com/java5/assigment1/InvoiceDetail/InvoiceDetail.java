package com.java5.assigment1.InvoiceDetail;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDetail {
    @NotBlank(message = "mời nhập lại")
    private String id;
    @NotBlank(message = "mời nhập lại")
    private String idHoaDon;
    @NotBlank(message = "mời nhập lại")
    private String idSPCT;
    @Positive(message = "mời nhập lại")
    private Integer soLuong;
    @Positive(message = "mời nhập lại")
    private Integer donGia;
    private boolean trangThai;
}
