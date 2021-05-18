package com.www.demo.app.service.impl;

import com.www.demo.app.service.IMyService;
import org.springframework.stereotype.Service;

/**
 * 服务层
 *
 * @author www
 */
@Service
public class MyServiceImpl implements IMyService {


//    @Transactional(rollbackFor = IllegalArgumentException.class)
    @Override
    public boolean modifyUserPawsswdWithRollBack() {
        return false;
    }

//    @Transactional(noRollbackFor = IllegalArgumentException.class)
    @Override
    public boolean modifyUserPawsswdWithoutRollBack() {
        return false;
    }

}
