package cn.lcools.service;

import cn.lcools.dao.SecRoleFunGrantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Copyright: Copyright (c) 2019 -Linkage
 *
 * @ClassName: SecRoleFunGrantService
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: liushuai3
 * @date: 2019/8/24 16:12
 * *****
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019/8/24     liushuai3           v1.0.0               修改原因
 */
@Service
public class SecRoleFunGrantService implements ISecRoleFunGrantInterface{
    @Autowired
    SecRoleFunGrantMapper secRoleFunGrantMapper;

    @Override
    public Set<String> selectFuncIdsByUserId(Long userId) {
        return secRoleFunGrantMapper.selectFuncIdsByUserId(userId);
    }
}
