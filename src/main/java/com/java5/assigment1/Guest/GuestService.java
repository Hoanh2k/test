package com.java5.assigment1.Guest;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestService {
    private List<Guest> list = new ArrayList<>();

    public GuestService(){
        list.add(new Guest("1","Trần Xuân Hoành", "0123456789","txh",true));
        list.add(new Guest("5","Nguyễn Thị Hà", "0123888889","nth",false));
        list.add(new Guest("4","Kiều Văn An", "01234222229","kva",true));
        list.add(new Guest("3","Lê Anh Dũng", "0123333339","lad",true));
        list.add(new Guest("2","Nguyễn Văn Trường", "012345555","nvt",true));
    }

    public List<Guest> getList(){
        return list;
    }


    public Guest getById(String id){
        for (Guest guest:list ) {
            if(guest.getId().equals(id)){
                return guest;
            }
        }
        return null;
    }

    public void create(Guest guest){
        list.add(guest);
    }

    public void update(Guest guest){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(guest.getId())){
                list.set(i,guest);
            }
        }
    }

    public void delete(String id){
        List<Guest> listDel= new ArrayList<>();
        for (Guest guest: list ) {
            if(guest.getId().equals(id)){
                listDel.add(guest);
            }
        }

        list.removeAll(listDel);
    }

    public List<Guest> getByCode(String code){
        List<Guest> listCode= new ArrayList<>();
        for (Guest guest:list ) {
            if(guest.getCode().equals(code)){
                listCode.add( guest);
            }
        }
        return listCode;
    }


    public List<Guest> getPaginatedList(int page, int size) {
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
