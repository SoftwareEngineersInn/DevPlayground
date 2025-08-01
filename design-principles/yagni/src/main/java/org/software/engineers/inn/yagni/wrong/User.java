package org.software.engineers.inn.yagni.wrong;

import org.software.engineers.inn.yagni.common.Address;

import java.util.ArrayList;
import java.util.List;

/**
 * Suppose you're developing a user management system, and you think, "Maybe in the future users will have multiple
 * addresses, so I'd better implement it now."
 * **/
public class User {
    private String name;
    private List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public List<Address> getAddresses() {
        return addresses;
    }
}
/**
 * But in your current system, only one address is needed per user. So, implementing List<Address> and its methods is
 * over-engineered, and violates YAGNI.
 * **/