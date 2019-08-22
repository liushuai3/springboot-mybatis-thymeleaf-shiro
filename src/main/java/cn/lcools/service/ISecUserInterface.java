package cn.lcools.service;

import cn.lcools.bean.SecUser;
import org.springframework.stereotype.Service;

/**
 * Copyright: Copyright (c) 2019 Asiainfo-Linkage
 *
 * @ClassName: IUserInterface
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
public interface ISecUserInterface {
    SecUser getUserByUserCode(String userCode);
}
