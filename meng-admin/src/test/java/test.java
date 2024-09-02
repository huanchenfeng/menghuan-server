
import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meng.MengHaunApplication;
import com.meng.mapper.balance.AccessoriesMapper;
import com.meng.service.balance.IAccessoriesService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@SpringBootTest(classes = MengHaunApplication.class)
public class test {
    @Autowired
    private IAccessoriesService accessoriesService;

    @Autowired
    private AccessoriesMapper accessoriesMapper;
    @Test
    public void testAdd() throws JsonProcessingException {
//        for (int i = 1; i < 440; i++) {
//            String url = "https://api.csqaq.com/api/v1/info/exchange_detail";
//            String response = sendPostRequest(url, createRequestBody(217));
//            ObjectMapper objectMapper = new ObjectMapper();
//
//            // 获取 "data" 字段的数据并转换为 List<ItemInfo>
//            List<Accessories> items = objectMapper.readValue(
//                    objectMapper.readTree(response).get("data").toString(),
//                    new TypeReference<List<Accessories>>() {
//                    }
//            );
//            accessoriesService.saveOrUpdateBatch(items);
////        }
//        accessoriesService.updateAccessoriesData(100);
        String param = "{\"code\": 200,\"msg\": \"Success\",\"data\": {\"name\": \"2733828240@qq.com\",\"isBindWeChat\": false,\"apiToken\": \"VEZEW1I7T2R4O8J3R3N1O0H3\",\"bindIp\": \"117.30.219.153\"}}";

        String result = HttpUtil.post("https://csqaq.com/proxies/api/v1/sys/bind_ip", param);
        System.out.println(result);
//        HttpRequest httpRequest = HttpRequest.get("https://www.youtube.com").timeout(30000);
//        httpRequest.setProxy(new Proxy(Proxy.Type.HTTP,new InetSocketAddress("127.0.0.1",7890)));
//        //
//
//        httpRequest.setUrl("https://steamcommunity.com/market/search/render/?query=&start=30&count=100&search_descriptions=0&sort_column=popular&sort_dir=desc");
//        String body = httpRequest.execute().body();
//        System.out.println(body);
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

    private static String createRequestBody(int i) {
        return "{\"page_index\":"+i+" , \"res\": 0, \"platforms\": \"BUFF-YYYP\", \"sort_by\": 1, \"turnover\": 0, \"min_price\": 0, \"max_price\": 200000}";

    }
    @Test
    public void updateSteamIdFromJson() throws Exception {
        // 读取 JSON 文件
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Map<String, String>> items = objectMapper.readValue(new File("D:/Edge浏览器下载/SteamTradingSite-ID-Mapper-main/SteamTradingSite-ID-Mapper-main/steam/730.json"), new TypeReference<Map<String, Map<String, String>>>() {});
        // 遍历 JSON 数据，更新表
        for (Map.Entry<String, Map<String, String>> entry : items.entrySet()) {
            String enName = entry.getValue().get("en_name");
            Integer steamId = Integer.valueOf(entry.getValue().get("name_id"));
            // 更新数据库
            accessoriesMapper.updateSteamIdBySteamName(steamId, enName);
        }
    }
}
