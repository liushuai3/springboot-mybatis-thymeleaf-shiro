package cn.lcools.service;

import cn.lcools.bean.SecAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Copyright: Copyright (c) 2019 -Linkage
 *
 * @ClassName: ISecAuthorizeInterface
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: liushuai3
 * @date: 2019/8/23 11:49
 * *****
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019/8/23     liushuai3           v1.0.0               修改原因
 */

@Service
public interface ISecAuthorizeInterface {
    List<SecAuthorize> selectByUserId(Long userId);
    Set<String> selectRoleCodesByUserId(Long userId);
}
