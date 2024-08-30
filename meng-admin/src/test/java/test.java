import cn.hutool.http.HttpRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meng.MengHaunApplication;
import com.meng.entity.balance.Accessories;
import com.meng.mapper.balance.AccessoriesMapper;
import com.meng.service.balance.IAccessoriesService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String proxyHost = "127.0.0.1";
        String proxyPort = "7980";
        String url = "https://steamcommunity.com/market/listings/730/AK-47%20%7C%20Redline%20%28Field-Tested%29";
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36 Edg/128.0.0.0";

        try {
            // 配置代理服务器
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, Integer.parseInt(proxyPort)));

            // Fetch the webpage
            Document doc = Jsoup.connect(url)
                    .userAgent(userAgent)
                    .proxy(proxy)
                    .header("Cookie", "timezoneOffset=28800,0; sessionid=2f45e3d042b4222278907203; steamCountry=JP%7C879390bd2415b03e576317141e32ad97")
                    .get();


            // Extract data using regex
            Pattern pattern = Pattern.compile("<script.*?line1=(.*?);.*?</script>", Pattern.DOTALL);
            Matcher matcher = pattern.matcher(doc.html());

            if (matcher.find()) {
                String result = matcher.group(1);

                // Remove unwanted characters
                result = result.replaceAll("[\":+\\[\\]]", "");

                // Split data into lists
                String[] data = result.split(",");
                FileWriter csvWriter = new FileWriter("ak47list.csv");

                csvWriter.append("time,price,number\n");

                // Write data to CSV
                for (int i = 0; i < data.length; i += 3) {
                    csvWriter.append(data[i] + "," + data[i + 1] + "," + data[i + 2] + "\n");
                }
                csvWriter.flush();
                csvWriter.close();

                System.out.println("Data saved to ak47list.csv");
            } else {
                System.out.println("No data found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
