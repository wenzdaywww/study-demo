package com.www.demo.app.service;

/**
 * 服务层
 * @author www
 *
 */
public interface IMyService {
	/**
	 * 数据回滚
	 * @return
	 */
	public boolean modifyUserPawsswdWithRollBack();
	/**
	 *  数据不回滚
	 * @return
	 */
	public boolean modifyUserPawsswdWithoutRollBack();
}
