package com.meng.service.impl.balance;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meng.entity.balance.Accessories;
import com.meng.mapper.balance.AccessoriesMapper;
import com.meng.service.balance.IAccessoriesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 饰品信息表 服务实现类
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-28 17:01:16
 */
@Service
public class AccessoriesServiceImpl extends ServiceImpl<AccessoriesMapper, Accessories> implements IAccessoriesService {
    public static void main(String[] args) {

    }

    @Override
    public void updateAccessoriesData(int pageSum) {
        String url = "https://api.csqaq.com/api/v1/info/exchange_detail";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("res", 0);
        paramMap.put("platforms", "BUFF-YYYP");
        paramMap.put("sort_by", 1);
        paramMap.put("turnover", 0);
        paramMap.put("min_price", 0);
        paramMap.put("max_price", 200000);
        for (int i = 1; i <= pageSum; i++) {
            paramMap.put("page_index", i);
            String jsonMap = JSONUtil.toJsonStr(paramMap);
            String response = HttpRequest.post(url)
                    .header("Content-Type", "application/json")
                    .header("ApiToken", "VEZEW1I7T2R4O8J3R3N1O0H3")
                    .body(jsonMap)//表单内容
                    .timeout(20000)//超时，毫秒
                    .execute().body();
            ObjectMapper objectMapper = new ObjectMapper();
            // 获取 "data" 字段的数据并转换为 List<ItemInfo>
            try {
                List<Accessories> items = objectMapper.readValue(
                        objectMapper.readTree(response).get("data").toString(),
                        new TypeReference<List<Accessories>>() {
                        }
                );
                this.saveOrUpdateBatch(items);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e+"第"+i+"页出现的问题");
            }
        }

    }

    @Override

    public String dateAnalys() {
        List<Accessories> items = this.list();
        return null;

    }

}
