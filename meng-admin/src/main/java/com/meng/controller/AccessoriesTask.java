package com.meng.controller;

import com.meng.service.balance.IAccessoriesService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AccessoriesTask {

    private final IAccessoriesService accessoriesService;

    public AccessoriesTask(IAccessoriesService accessoriesService) {
        this.accessoriesService = accessoriesService;
    }

    // 每小时执行一次
    @Scheduled(fixedRate = 3600000)  // 单位为毫秒，3600000ms = 1小时
    public void updateAccessoriesData() {
        System.out.println("定时任务成功执行");
        accessoriesService.updateAccessoriesData(100);
        System.out.println("定时任务执行结束");
    }
}