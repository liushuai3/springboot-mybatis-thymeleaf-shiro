package cn.lcools.service;

import cn.lcools.bean.SecUser;
import cn.lcools.dao.SecUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright: Copyright (c) 2019 -Linkage
 *
 * @ClassName: UserService
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: liushuai3
 * @date: 2019/8/20 9:43
 * *****
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019/8/20     liushuai3           v1.0.0               修改原因
 */
@Service
public class SecUserService implements ISecUserInterface {

    @Autowired
    SecUserMapper secUserMapper;

    @Override
    public SecUser getUserByUserCode(String userCode) {
        SecUser secUser = secUserMapper.selectByUserCode(userCode);
        return secUser;
    }
}
