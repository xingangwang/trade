package net.jeeshop.services.manage.system;

import net.jeeshop.core.Services;
import net.jeeshop.core.model.User;

public interface UserInteface extends Services<User> {
	/**
	 * @param e
	 * @return
	 */
	public User login(User e);
}
