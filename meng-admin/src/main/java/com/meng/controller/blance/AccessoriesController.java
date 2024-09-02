package com.meng.controller.blance;

import com.meng.service.balance.IAccessoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 饰品信息表 前端控制器
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-28 17:01:16
 */
@RestController
@RequestMapping("/accessories")
public class AccessoriesController {
    @Autowired
    private IAccessoriesService accessoriesService;

    @PostMapping("/updateAccessoriesData")
    public String updateAccessoriesData(@RequestBody int pageSum) {
        accessoriesService.updateAccessoriesData(pageSum);
        return "Items saved successfully";
    }

}
