package net.jeeshop.services.manage.system.impl;

import java.util.List;

import javax.annotation.Resource;

import net.jeeshop.core.BaseDao;
import net.jeeshop.core.Services;
import net.jeeshop.core.model.Privilege;
import net.jeeshop.core.model.Role;
import net.jeeshop.dao.page.PagerModel;

import org.springframework.stereotype.Service;


/**
 * 权限业务逻辑实现类
 * 
 * @author huangf
 * 
 */
@Service
public class PrivilegeService implements Services<Privilege> {
    @Resource
	private BaseDao dao;

	public void setDao(BaseDao dao) {
		this.dao = dao;
	}

	public List<Privilege> selectList(Privilege privilege) {
		if (privilege == null)
			return dao.selectList("privilege.selectList");
		return dao.selectList("privilege.selectList", privilege);
	}

	public Privilege selectOne(Privilege privilege) {
		return (Privilege) dao.selectOne("privilege.selectOne", privilege);
	}

	public int insert(Privilege privilege) {
		return dao.insert("privilege.insert", privilege);
	}

	public int delete(Privilege privilege) {
		return dao.delete("privilege.delete", privilege);
	}

	public int update(Privilege privilege) {
		return dao.update("privilege.update", privilege);
	}

	/**
	 * 根绝角色删除权限
	 * 
	 * @param role
	 */
	public void deleteByRole(Role role) {
		Privilege privilege = new Privilege();
		privilege.setRid(role.getId());
		delete(privilege);
	}

	public PagerModel selectPageList(Privilege e) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deletes(String[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Privilege selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
