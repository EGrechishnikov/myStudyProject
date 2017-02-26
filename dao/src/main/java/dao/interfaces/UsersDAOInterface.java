package dao.interfaces;

import bean.User;

public interface UsersDAOInterface extends BaseDAOInterface<User> {
    /**
     * get user from db by login
     *
     * @param login - login for search
     * @return user
     */
    User get(String login);

    /**
     * Check is email exist
     *
     * @param email - email for check
     * @return true if exist
     */
    boolean isEmailExist(String email);

    /**
     * Check is login exist
     *
     * @param login - email for check
     * @return true if exist
     */
    boolean isLoginExist(String login);
}
