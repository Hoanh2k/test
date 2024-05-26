package com.java5.assigment1.Product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {
    private List<Product> list = new ArrayList<>();

    public ProductService(){
        list.add(new Product("1","1378","Cà Tím",true));
        list.add(new Product("2","5378","Cà Xanh",true));
        list.add(new Product("3","2378","Cải Trắng",true));
        list.add(new Product("4","4378","Cúc Vàng",true));
    }

    public List<Product> getList(){
        return list;
    }

    public Product getById(String id){
        for (Product cl:list ) {
            if(cl.getId().equals(id)){
                return cl;
            }
        }
        return null;
    }

    public void create(Product cl){
        list.add(cl);
    }

    public void update(Product cl){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(cl.getId())){
                list.set(i,cl);
            }
        }
    }

    public void delete(String id){
        List<Product> listDel= new ArrayList<>();
        for (Product cl: list ) {
            if(cl.getId().equals(id)){
                listDel.add(cl);
            }
        }

        list.removeAll(listDel);
    }

    public List<Product> getByCode(String code){
        List<Product> listCode = new ArrayList<>();
        for (Product cl:list ) {
            if(cl.getCode().equals(code)){
                listCode.add(cl);
            }
        }
        return listCode;
    }

    public List<Product> getPaginatedList(int page, int size) {
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
