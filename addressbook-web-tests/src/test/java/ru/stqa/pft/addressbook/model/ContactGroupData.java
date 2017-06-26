package ru.stqa.pft.addressbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Алексей on 26.06.2017.
 */
@Entity
@Table (name = "address_in_groups")
public class ContactGroupData {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "group_id")
    private int group_id;



    public int getId() {
        return id;
    }

    public int getGroup_id() {
        return group_id;
    }







}
