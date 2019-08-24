package cn.lcools.service;

import cn.lcools.bean.SecAuthorize;
import cn.lcools.dao.SecAuthorizeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Copyright: Copyright (c) 2019 -Linkage
 *
 * @ClassName: SecAuthorizeService
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: liushuai3
 * @date: 2019/8/23 11:57
 * *****
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019/8/23     liushuai3           v1.0.0               修改原因
 */

@Service
public class SecAuthorizeService implements ISecAuthorizeInterface{

    @Autowired
    SecAuthorizeMapper secAuthorizeMapper;

    @Override
    public List<SecAuthorize> selectByUserId(Long userId) {
        return secAuthorizeMapper.selectByUserId(userId);
    }

    @Override
    public Set<String> selectRoleCodesByUserId(Long userId) {
        return secAuthorizeMapper.selectRoleCodesByUserId(userId);
    }
}
