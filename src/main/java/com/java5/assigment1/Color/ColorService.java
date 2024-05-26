package com.java5.assigment1.Color;

import com.java5.assigment1.Color.Color;
import com.java5.assigment1.Staff.Staff;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColorService {
    private List<Color> list = new ArrayList<>();

    public ColorService(){
        list.add(new Color("1","1378","Tím",true));
        list.add(new Color("2","5378","Xanh",true));
        list.add(new Color("3","2378","Trắng",true));
        list.add(new Color("4","4378","Vàng",true));
    }

    public List<Color> getList(){
        return list;
    }

    public Color getById(String id){
        for (Color cl:list ) {
            if(cl.getId().equals(id)){
                return cl;
            }
        }
        return null;
    }

    public void create(Color cl){
        list.add(cl);
    }

    public void update(Color cl){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(cl.getId())){
                list.set(i,cl);
            }
        }
    }

    public void delete(String id){
        List<Color> listDel= new ArrayList<>();
        for (Color cl: list ) {
            if(cl.getId().equals(id)){
                listDel.add(cl);
            }
        }

        list.removeAll(listDel);
    }

    public List<Color> getByCode(String code){
        List<Color> listC = new ArrayList<>();
        for (Color cl:list ) {
            if(cl.getCode().equals(code)){
                listC.add(cl);
            }
        }
        return listC;
    }


    public List<Color> getPaginatedList(int page, int size) {
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
