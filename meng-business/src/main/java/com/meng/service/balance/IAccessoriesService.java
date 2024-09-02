package com.meng.service.balance;

import com.meng.entity.balance.Accessories;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 饰品信息表 服务类
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-28 17:01:16
 */
public interface IAccessoriesService extends IService<Accessories> {

    void updateAccessoriesData(int pageSum);

    String dateAnalys();
}
