package cn.lcools.service;

import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Copyright: Copyright (c) 2019 -Linkage
 *
 * @ClassName: ISecRoleFunGrantInterface
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: liushuai3
 * @date: 2019/8/24 15:58
 * *****
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019/8/24     liushuai3           v1.0.0               修改原因
 */
@Service
public interface ISecRoleFunGrantInterface {
    Set<String> selectFuncIdsByUserId(Long userId);
}
