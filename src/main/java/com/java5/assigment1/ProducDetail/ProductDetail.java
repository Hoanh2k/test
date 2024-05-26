package com.java5.assigment1.ProducDetail;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail {
    @NotBlank(message = "id không được trống ")
    private String id;
    @NotBlank(message = "mã spct không được trống ")
    private String maSPCT;
    @NotBlank(message = "id khích thước không được trống ")
    private String idKichThuoc;
    @NotBlank(message = "id màu sắc không được trống ")
    private String idMauSac;
    @NotBlank(message = "id sản phẩm không được trống ")
    private String idSanPham;
    @NotNull(message = "số lượng không được trống ")
    @Min(value =1,message = "tuổi phải lơn hơn 0")
    private Integer soLuong;
    @NotNull(message = "đơn giá không được trống ")
    private Integer donGia;
    private boolean trangThai;
}
