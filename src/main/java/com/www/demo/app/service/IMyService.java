package com.www.demo.app.service;

import com.www.demo.model.vo.SysuserVO;

public interface IMyService {
	/**
	 * 数据回滚
	 */
	public boolean modifyUserPawsswdWithRollBack(SysuserVO sysuserVO);
	/**
	 * 数据不回滚
	 */
	public boolean modifyUserPawsswdWithoutRollBack(SysuserVO sysuserVO);
}
