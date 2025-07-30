package org.software.engineers.inn.dry.wrong;

/** Notice how you are repeating yourself making the same validation logic
 * for create and update **/
public class UserService {

    /** User create logic **/
    public void createUser(String name, String email){
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is invalid");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email is invalid");
        }
    }

    /** User update logic **/
    public void updateUser(String name, String email){
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is invalid");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email is invalid");
        }
    }
}
