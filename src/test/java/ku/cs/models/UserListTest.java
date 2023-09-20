package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("duck", "duck");
        userList.addUser("suck", "suck");
        userList.addUser("puck", "puck");
        // TODO: find one of them
        User user = userList.findUserByUsername("duck");
        // TODO: assert that UserList found User
         String expected = "duck";
         String actual = user.getUsername();
         assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("duck", "duck");
        userList.addUser("suck", "suck");
        userList.addUser("puck", "puck");
        // TODO: change password of one user
        boolean can = userList.changePassword("duck", "duck", "ducky");
        // TODO: assert that user can change password
        boolean actual = userList.findUserByUsername("duck").validatePassword("ducky");
        assertTrue(actual);
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("duck", "duck");
        userList.addUser("suck", "suck");
        userList.addUser("puck", "puck");

        // TODO: call login() with correct username and password
        User actual = userList.login("duck", "duck");
        // TODO: assert that User object is found
         assertEquals("duck", actual.getUsername());
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("duck", "duck");
        userList.addUser("suck", "suck");
        userList.addUser("puck", "puck");
        // TODO: call login() with incorrect username or incorrect password
        User actual = userList.login("duck", "12312");
        // TODO: assert that the method return null
        assertNull(actual);
    }
}