package com.java5.assigment1.InvoiceDetail;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class InvoiceDetailService {
    List<InvoiceDetail> list = new ArrayList<>();

    public InvoiceDetailService() {
        list.add(new InvoiceDetail("HDCT01", "HD01", "301", 50, 100, true));
        list.add(new InvoiceDetail("HDCT02", "HD02", "302", 20, 200, true));
        list.add(new InvoiceDetail("HDCT03", "HD03", "303", 80, 500, true));
        list.add(new InvoiceDetail("HDCT04", "HD04", "304", 60, 300, true));
        list.add(new InvoiceDetail("HDCT05", "HD05", "305", 90, 100, true));

    }

    public List<InvoiceDetail> getAll() {
        return list;
    }

    public InvoiceDetail finByID(String id) {
        for (InvoiceDetail idt : list) {
            if (idt.getId().equals(id)) {
                return idt;
            }
        }
        return null;
    }

    public void add(InvoiceDetail idt) {
        list.add(idt);
    }

    public void update(InvoiceDetail idt) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(idt.getId())) {
                list.set(i, idt);
            }
        }
    }

    public void delete(String id) {
        List<InvoiceDetail> listDel = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                listDel.add(list.get(i));
            }
        }
        list.removeAll(listDel);
    }

    public List<InvoiceDetail> searchName(String id) {
        List<InvoiceDetail> listc = new ArrayList<>();
        for (InvoiceDetail idt : list) {
            if (idt.getId().equals(id)) {
                listc.add( idt);
            }
        }
        return listc;
    }

    public List<InvoiceDetail> getPaginatedList(int page, int size) {
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
