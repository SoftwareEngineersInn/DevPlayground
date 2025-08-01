package org.software.engineers.inn.yagni.ok;

import org.software.engineers.inn.yagni.common.Address;

/**
 *
 This way, you only implement what's strictly necessary for the current requirement. If the system really needs multiple
 addresses later, you can refactor.
 * **/
public class User {
    private String name;
    private Address address; // We only need ONE by now

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
