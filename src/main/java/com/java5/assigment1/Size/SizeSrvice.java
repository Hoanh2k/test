package com.java5.assigment1.Size;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SizeSrvice {

    private List<Size> list = new ArrayList<>();
    public SizeSrvice(){
        list.add(new Size("1","S","Từ 40kg-50",true));
        list.add(new Size("2","M","Từ 50kg-60",true));
        list.add(new Size("3","L","Từ 60kg-70",true));
        list.add(new Size("4","XL","Từ 70kg-80",true));
    }

    public List<Size> getList(){
        return list;
    }

    public void create(Size size){
        list.add(size);
    }

    public Size getById(String id){
        for (Size size:list ) {
            if(size.getId().equals(id)){
                return size;
            }
        }
        return null;
    }

    public void delete(String id){
        List<Size> listDel = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id)){
                listDel.add(list.get(i));
            }
        }
        list.removeAll(listDel);
    }

    public void update(Size size){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(size.getId())){
                list.set(i, size);
            }
        }
    }

    public List<Size> getByCode(String code) {
        List<Size> listCode= new ArrayList<>();
        for (Size si : list) {
            if(si.getCode().equals(code)){
                listCode.add(si);
            }
        }
        return listCode;
    }
    public List<Size> getPaginatedList(int page, int size) {
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
