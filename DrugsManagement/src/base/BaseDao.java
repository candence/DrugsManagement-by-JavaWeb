package base;

import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.drugsDao;
import Dao.getindao;
import Dao.getoutdao;
import Dao.usersdao;
import Objective.DAO;

import Util.DBUtil;

/*
 * ģ��˵����
 * �������࣬���ݴ����ö����Ķ������ͽ�����ɾ���
 * 
 * */

/**
 * @author caden wuye 2019-05-27
 * 
 */
public abstract class BaseDao {

	private static BaseDao baseDAO;
	protected ResultSet rs;
	protected final DBUtil db = DBUtil.getDBUtil();

	public BaseDao() {
		init();
	}

	private void init() {
		// ��װ��������
	}

	// �ṩ��ȡdao���ʵ������
	public static synchronized BaseDao getAbilityDAO(DAO dao) {
		switch (dao) {
		case drugs:
			if (baseDAO == null || baseDAO.getClass() != drugsDao.class) {
				baseDAO = drugsDao.getInstance();
			}
			break;
		case users:
			if (baseDAO == null || baseDAO.getClass() != usersdao.class) {
				baseDAO = usersdao.getInstance();
			}
			break;
		case getin:
			if (baseDAO == null || baseDAO.getClass() != getindao.class) {
				baseDAO = getindao.getInstance();
			}
			break;
		case getout:
			if (baseDAO == null || baseDAO.getClass() != getoutdao.class) {
				baseDAO = getoutdao.getInstance();
			}
			break;
		default:
			break;
		}
		return baseDAO;
	}

	// �ȹرս�������ڹرչ�����
	protected void destroy() {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException s) {
				s.printStackTrace();
			} finally {
				db.close();
			}
		}
	}

}
