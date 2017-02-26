package service.interfaces;

import bean.User;

public interface UserServiceInterface extends BaseServiceInterface<User> {
    /**
     * Save or update user in db
     *
     * @param bean - entity
     */
    void saveOrUpdate(User bean);

    /**
     * Get user by login
     *
     * @param login - login
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
