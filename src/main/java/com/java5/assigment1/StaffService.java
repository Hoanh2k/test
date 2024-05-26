package com.java5.assigment1;

import com.java5.assigment1.Size.Size;
import com.java5.assigment1.Staff.Staff;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
public class StaffService {

    private List<Staff> list;
    public StaffService(){
        list =  new ArrayList<>();
        list.add(new Staff("1","Trần Xuân Hoành","hoanhtx","123456",true));
        list.add(new Staff("2","Trần Xuân Hoành1","hoanhtx1","12345",true));
        list.add(new Staff("3","Trần Xuân Hoành2","hoanhtx2","1234",false));
        list.add(new Staff("4","Trần Xuân Hoành3","hoanhtx3","123",true));

    }

    public List<Staff> getList(){
        return list;
    }


    public void create(Staff staff){
        list.add(staff);
    }

    public Staff getById(String id){
        for (Staff staff:list ) {
            if(staff.getId().equals(id)){
                return staff;
            }
        }
        return null;
    }

    public Staff getByUserAndPass(String user, String pass){
        for (Staff staff:list ) {
            if(staff.getUserName().equals(user)&&staff.getPassWord().equals(pass)){

                    return staff;
                }

        }
        return null;
    }

    public void delete(String id){
        List<Staff> listDel = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id)){
                listDel.add(list.get(i));
            }
        }
        list.removeAll(listDel);
    }

    public void update(Staff staff){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(staff.getId())){
                list.set(i, staff);
            }
        }
    }

    public List<Staff> getByCode(String username) {
        List<Staff> listCode= new ArrayList<>();
        for (Staff st : list) {
            if(st.getUserName().equals(username)){
                listCode.add(st);
            }
        }
        return listCode;
    }


    public List<Staff> getPaginatedList(int page, int size) {
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

    public boolean isAdmin(Staff staff) {
        return  staff.getStatus();
    }
//
//    Staff staff= getByUserAndPass();
//    public Boolean manager(){
//        Boolean manager = staff.getStatus(true);
//    }
}
