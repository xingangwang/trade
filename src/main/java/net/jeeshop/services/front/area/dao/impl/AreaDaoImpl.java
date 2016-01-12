package net.jeeshop.services.front.area.dao.impl;import java.util.List;import net.jeeshop.core.BaseDao;import net.jeeshop.dao.page.PagerModel;import net.jeeshop.services.front.account.bean.Account;import net.jeeshop.services.front.area.bean.Area;import net.jeeshop.services.front.area.dao.AreaDao;import org.springframework.stereotype.Repository;import org.springframework.stereotype.Service;import javax.annotation.Resource;@Repository("areaDaoFront")public class AreaDaoImpl implements AreaDao {    @Resource	private BaseDao dao;	public void setDao(BaseDao dao) {		this.dao = dao;	}	public PagerModel selectPageList(Area e) {		return dao.selectPageList("front.area.selectPageList",				"front.area.selectPageCount", e);	}	public List selectList(Area e) {		return dao.selectList("front.area.selectList", e);	}	public Area selectOne(Area e) {		return (Area) dao.selectOne("front.area.selectOne", e);	}	public int delete(Area e) {		return dao.delete("front.area.delete", e);	}	public int update(Area e) {		return dao.update("front.area.update", e);	}	public int deletes(String[] ids) {		Area e = new Area();		for (int i = 0; i < ids.length; i++) {			e.setId(ids[i]);			delete(e);		}		return 0;	}	public int insert(Area e) {		return dao.insert("front.area.insert", e);	}	public int deleteById(int id) {		return dao.delete("front.area.deleteById", id);	}	public Area selectById(String id) {		return (Area) dao.selectOne("account.selectById", id);	}}