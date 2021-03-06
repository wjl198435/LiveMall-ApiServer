package Controller;

import Model.tinkerpop.Dao.user.register.WX_Register;
import com.alibaba.fastjson.JSON;
import com.haiwar.properties.GetProperties;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import wxLogin.AesCbcUtil;
import wxLogin.HttpRequest;

import java.util.HashMap;
import java.util.Map;


@Controller
//@ResponseBody
////@RequestMapping(value = "/decodeUserInfo", method = RequestMethod.POST)
//@RequestMapping("/decodeUserInfo")
public class wxRegisterUserController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 解密用户敏感数据
     *
     * @param encryptedData 明文,加密数据
     * @param iv            加密算法的初始向量
     * @param code          用户允许登录后，回调内容会带上 code（有效期五分钟），开发者需要将 code 发送到开发者服务器后台，使用code 换取 session_key api，将 code 换成 openid 和 session_key
     * @return
     */

    @RequestMapping(value ="/mall/user/wxapp/register/complex",method=RequestMethod.POST)
    public @ResponseBody Map registerUserInfo(String encryptedData, String iv, String code) {

        //logger.info("registerUserInfo: Enter!!!");

       // logger.info("code:"+code);

        Map map = new HashMap();



        //登录凭证不能为空
        if (code == null || code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            return map;
        }

        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        GetProperties loginInfo = appContext.getBean(GetProperties.class);
        //小程序唯一标识   (在微信小程序管理后台获取)
        String wxspAppid = loginInfo.getWxspAppid();
        //小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = loginInfo.getWxspSecret();
        //授权（必填）
        String grant_type = "authorization_code";


        //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////
        //请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        //解析相应内容（转换成json对象）
        //JSONObject json = JSONObject.fromObject(sr);

        JSONObject json = JSONObject.parseObject(sr);

        logger.info(json.toJSONString());

        //获取会话密钥（session_key）
        String session_key = json.get("session_key").toString();
        //用户的唯一标识（openid）
        String openid = (String) json.get("openid");
        map.put("status", -1);

        //////////////// 2、对encryptedData加密数据进行AES解密 ////////////////
        try {
            String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
            if (null != result && result.length() > 0) {


                //JSONObject userInfoJSON = JSONObject.fromObject(result);
                JSONObject userInfoJSON = JSONObject.parseObject(result);

                //logger.info("userInfoJSON:"+userInfoJSON.toJSONString());



                Map userInfo = new HashMap();

                userInfo.put(WX_Register.getOpenId(), userInfoJSON.get(WX_Register.getOpenId()));
                userInfo.put(WX_Register.getNickName(), userInfoJSON.get(WX_Register.getNickName()));
                userInfo.put(WX_Register.getGender(), userInfoJSON.get(WX_Register.getGender()));
                userInfo.put(WX_Register.getCity(), userInfoJSON.get(WX_Register.getCity()));
                userInfo.put(WX_Register.getProvince(), userInfoJSON.get(WX_Register.getProvince()));
                userInfo.put(WX_Register.getCountry(), userInfoJSON.get(WX_Register.getCountry()));
                userInfo.put(WX_Register.getAvatarUrl(), userInfoJSON.get(WX_Register.getAvatarUrl()));
                userInfo.put(WX_Register.getUnionId(), userInfoJSON.get(WX_Register.getUnionId()));
                userInfo.put(WX_Register.getTime(), System.currentTimeMillis());

                JSONObject UserInfoJson =(JSONObject) JSON.toJSON(userInfo);

                WX_Register.Register(UserInfoJson,map);

//                 JSON.toJSON(userInfo);

                map.put("userInfo", userInfo);
                logger.info(map.toString());
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        map.put("msg", "解密失败");
        return map;
    }



//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();
//
//    @RequestMapping(method=RequestMethod.GET)
//    public @ResponseBody
//    hello.mallName sayHello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
//        return new mallName(counter.incrementAndGet(), String.format(template, name));
//    }

}
