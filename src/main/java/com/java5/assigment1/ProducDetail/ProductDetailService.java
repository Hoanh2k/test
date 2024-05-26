package com.java5.assigment1.ProducDetail;

import com.java5.assigment1.Staff.Staff;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDetailService {
    List<ProductDetail> list = new ArrayList<>();

    public ProductDetailService() {
        list.add(new ProductDetail("301", "SPCT01", "2001", "1001", "001", 200, 150, true));
        list.add(new ProductDetail("302", "SPCT02", "2002", "1002", "002", 200, 150, true));
        list.add(new ProductDetail("303", "SPCT03", "2003", "1003", "003", 200, 150, true));
        list.add(new ProductDetail("304", "SPCT04", "2004", "1004", "004", 200, 150, true));
        list.add(new ProductDetail("305", "SPCT05", "2001", "1005", "005", 200, 150, true));

    }

    public List<ProductDetail> getAll() {
        return list;
    }

    public ProductDetail finByID(String id) {
        for (ProductDetail pdt : list) {
            if (pdt.getId().equals(id)) {
                return pdt;
            }
        }
        return null;
    }

    public void add(ProductDetail pdt) {
        list.add(pdt);
    }

    public void update(ProductDetail pdt) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(pdt.getId())) {
                list.set(i, pdt);
            }
        }
    }

    public void delete(String id) {
        List<ProductDetail> listDel = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                listDel.add(list.get(i));
            }
        }
        list.removeAll(listDel);
    }

    public ProductDetail searchName(String ma) {
        for (ProductDetail pdt : list) {
            if (pdt.getMaSPCT().equals(ma)) {
                return pdt;
            }
        }
        return null;
    }
    public List<ProductDetail> getPaginatedList(int page, int size) {
        int fromIndex = page * size;
        if (list == null || list.size() < fromIndex) {
            return new ArrayList<>();
        }
        return list.subList(fromIndex, Math.min(fromIndex + size, list.size()));
    }

    public int getTotalPages(int size) {
        if (list == null || size <= 0) {
            return 0;
        }
        return (int) Math.ceil((double) list.size() / size);
    }
}
