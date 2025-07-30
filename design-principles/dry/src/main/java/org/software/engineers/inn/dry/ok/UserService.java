package org.software.engineers.inn.dry.ok;

/** Now the repetitive validation logic is centralized **/
public class UserService {
    private void dataValidation(String name, String email){
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is invalid");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email is invalid");
        }
    }

    /** User create logic **/
    public void createUser(String name, String email){
        dataValidation(name, email);
    }

    /** User update logic **/
    public void updateUser(String name, String email){
        dataValidation(name, email);
    }
}
