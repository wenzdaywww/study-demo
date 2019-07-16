package com.www.demo.app.service;

import com.www.demo.model.vo.SysuserVO;
/**
 * 服务层
 * @author www
 *
 */
public interface IMyService {
	/**
	 * 数据回滚
	 * @param sysuserVO
	 * @return
	 */
	public boolean modifyUserPawsswdWithRollBack(SysuserVO sysuserVO);
	/**
	 *  数据不回滚
	 * @param sysuserVO
	 * @return
	 */
	public boolean modifyUserPawsswdWithoutRollBack(SysuserVO sysuserVO);
}
