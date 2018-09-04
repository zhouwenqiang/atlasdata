package com.atlas.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/8/31.
 * zwq
 */
public class HttpUtils {
    private static CloseableHttpClient httpclient = null;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    static {
        PoolingHttpClientConnectionManager phcm = new PoolingHttpClientConnectionManager(
                120, TimeUnit.SECONDS);
        phcm.setMaxTotal(1000);
        phcm.setDefaultMaxPerRoute(1000);
        phcm.closeExpiredConnections();
        phcm.closeIdleConnections(300, TimeUnit.SECONDS);
        RequestConfig globalConfig = RequestConfig.custom()
                .setCookieSpec(CookieSpecs.BROWSER_COMPATIBILITY)
                .setSocketTimeout(180000).setConnectTimeout(300000)
                .setConnectionRequestTimeout(180000).build();
        httpclient = HttpClients.custom().setConnectionManager(phcm)
                .setDefaultRequestConfig(globalConfig).build();
    }
    /**
     *@param "http请求"
     *@param "Post"
     *@param url=被请求地址
     *@param contentType= 请参考MediaType(org.springframework.http.MediaType;)
     *@param str=xml字符串，或者JSON字符串
     *@param "传送和返回都是UTF-8"
     * */
    public static String httpPost(String url,String contentType,String str) throws Exception {
            String responseBody = "";
            HttpPost httppost = new HttpPost(url);
            httppost.setHeader(HTTP.CONTENT_TYPE, contentType);
            httppost.setEntity(new StringEntity(str, HTTP.UTF_8));
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                public String handleResponse(final HttpResponse response)
                        throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException(
                                "Unexpected response status: " + status);
                    }
                }
            };
        try {
            responseBody = httpclient.execute(httppost, responseHandler);
        } catch (IOException e) {
       
            throw new Exception("POST请求错误 ",e);
            
        }
        /*try {
            responseBody=new String(responseBody.getBytes(HTTP.UTF_8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new UnsupportedEncodingException("POST请求后得到回复解析编码转换错误");
        }*/
        return responseBody;
    }

    public static String httpGet(String url,String contentType) throws IOException {
        String responseBody = "";
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader(HTTP.CONTENT_TYPE, contentType);
        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
            public String handleResponse(final HttpResponse response)
                    throws ClientProtocolException, IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException(
                            "Unexpected response status: " + status);
                }
            }
        };
        responseBody = httpclient.execute(httpGet, responseHandler);
        return responseBody;
    }
    public static void main(String[] args) {
        String url="http://221.182.1.87:81/rs/ws/InterfaceForADCService";
        String xml="<?xml version=\"1.0\" encoding=\"utf-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><soap:Header/><soap:Body><ADCSIInterface xmlns=\"http://adc.siinterface.com/\"><request><BizCode>SI201</BizCode><TransID>SC201708110000000999</TransID><TimeStamp>2017/8/11 10:26:29</TimeStamp><ActionCode>1</ActionCode><SIAppID>423005</SIAppID><TestFlag>0</TestFlag><Dealkind>0</Dealkind><Priority>0</Priority><Version>V1.0</Version><SvcCont><![CDATA[<ADCProvisioningRequest>  <BODY>    <SICode>423005</SICode>    <SIName>四川启程科技发展有限公司</SIName>    <OptType>0</OptType>    <ECCode>19511007254111</ECCode>    <ECName>测试－中国移动巴中分公司</ECName>    <PrdCode>ACCZ50286</PrdCode>    <ServiceCode>10657001</ServiceCode>    <PrdOrdNum>ASC0011501</PrdOrdNum>    <ServiceName>位讯通</ServiceName>    <AccessNo>SC</AccessNo>    <ECAccessPort>1065700100000001</ECAccessPort>    <StartEfft>2017/8/1 0:00:00</StartEfft>    <EndEfft>2067/8/1 0:00:00</EndEfft>    <AdminUser>13880219687</AdminUser>    <Priority>0</Priority>    <TrialInfo>      <TrailFlag>0</TrailFlag>      <ToBusinessTime />      <BusiLimit />    </TrialInfo>    <PARAMMAP>      <PARAMNAME>ShortCorpName</PARAMNAME>      <PARAMVALUE>巴中移动测试</PARAMVALUE>    </PARAMMAP>    <PARAMMAP>      <PARAMNAME>CityCode</PARAMNAME>      <PARAMVALUE>09</PARAMVALUE>    </PARAMMAP>    <PARAMMAP>      <PARAMNAME>ECDistrictCode</PARAMNAME>      <PARAMVALUE>01</PARAMVALUE>    </PARAMMAP>    <LICENSE>0</LICENSE>    <OPTNOTE />  </BODY></ADCProvisioningRequest>]]>" +
                "</SvcCont></request></ADCSIInterface></soap:Body></soap:Envelope>";
        String returnxml= null;
        try {
            String urlget="http://218.205.252.26:32000/rest/1.0/WsGetActTermiMean?appKey=11000592&bat_id=&contact_iccid=13408552114&date_begin=20180201&date_end=20180301010101&login_no=aagh27&page_number=1&page_size=10&request_method=&res_code=86535502&send_time=20180328213825&timeStamp=20180328213825&userName=linfeng&sign=NOYuXIjZUL9BbQlR4vUrwzXhihSZnAFRFQD27bY4VctUgVXREjFutE6YG8CJddZ6wwU7SPESVSw0R7g9OxwYga8KAYX%2Fg1orwPlbxHNkxhLrprebcUr2wURat2mOdnDO%2BMNOIXs0CxbRON%2BtBP%2Fengz4MyjLeppLpwYj6MAeTwg%3D";
            //returnxml = HttpUtils.httpPost(url, MediaType.APPLICATION_FORM_URLENCODED, xml);
            returnxml=HttpUtils.httpGet(urlget,MediaType.APPLICATION_JSON);
            System.out.println(returnxml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
