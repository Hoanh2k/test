package com.java5.assigment1.Invoice;


import com.java5.assigment1.Color.Color;
import com.java5.assigment1.Staff.Staff;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class InvoiceService {
    List<Invoice> list = new ArrayList<>();

    public InvoiceService() {
        list.add(new Invoice("HD01", "01", "201", "05/05/2024", true));
        list.add(new Invoice("HD02", "02", "202", "15/05/2024", true));
        list.add(new Invoice("HD03", "03", "203", "25/05/2024", true));
        list.add(new Invoice("HD04", "04", "204", "16/05/2024", true));
        list.add(new Invoice("HD05", "05", "205", "20/05/2024", true));

    }

    public List<Invoice> getAll() {
        return list;
    }

    public Invoice finByID(String id) {
        for (Invoice in : list) {
            if (in.getId().equals(id)) {
                return in;
            }
        }
        return null;
    }

    public void add(Invoice in) {
        list.add(in);
    }

    public void update(Invoice in) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(in.getId())) {
                list.set(i, in);
            }
        }
    }

    public void delete(String id) {
        List<Invoice> listDel = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                listDel.add(list.get(i));
            }
        }
        list.removeAll(listDel);
    }

    public List<Invoice> getByCode(String code){
        List<Invoice> listC = new ArrayList<>();
        for (Invoice cl:list ) {
            if(cl.getId().equals(code)){
                listC.add(cl);
            }
        }
        return listC;
    }

    public List<Invoice> getPaginatedList(int page, int size) {
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
