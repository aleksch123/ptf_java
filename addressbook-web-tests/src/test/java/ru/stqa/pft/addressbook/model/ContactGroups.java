package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Алексей on 26.06.2017.
 */
public class ContactGroups extends ForwardingSet<ContactGroupData> {

    private Set<ContactGroupData> delegate;

    public ContactGroups(ContactGroups contactGroups) {
        this.delegate = new HashSet<ContactGroupData>(contactGroups.delegate);
    }

    public ContactGroups() {
        this.delegate = new HashSet<ContactGroupData>();
    }

    @Override
    protected Set<ContactGroupData> delegate() {
        return null;
    }

    public ContactGroups(Collection<ContactGroupData> contactGroups) {
        this.delegate = new HashSet<ContactGroupData>(contactGroups);
    }
}