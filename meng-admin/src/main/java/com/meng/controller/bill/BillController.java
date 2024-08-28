package com.meng.controller.bill;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-23 15:27:27
 */
@RestController
@RequestMapping("/bill")
public class BillController {

    public static void main(String[] args) {
        String url = "https://api.csqaq.com/api/v1/info/exchange_detail";
        String response = sendPostRequest(url, createRequestBody());
        System.out.println(response);
    }

    private static String sendPostRequest(String url, String requestBody) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("ApiToken","VEZEW1I7T2R4O8J3R3N1O0H3");
        try {
            // 设置请求体
            StringEntity entity = new StringEntity(requestBody, "UTF-8");
            httpPost.setEntity(entity);

            // 发送请求
            CloseableHttpResponse response = httpClient.execute(httpPost);
            try {
                // 获取响应实体
                HttpEntity responseEntity = response.getEntity();
                if (responseEntity != null) {
                    return EntityUtils.toString(responseEntity, "UTF-8");
                }
            } finally {
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static String createRequestBody() {
        return "{\"page_index\": 1, \"res\": 0, \"platforms\": \"BUFF-YYYP\", \"sort_by\": 1, \"turnover\": 10, \"min_price\": 1, \"max_price\": 5000}";
    }
}
