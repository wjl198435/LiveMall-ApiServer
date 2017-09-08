package Model.tinkerpop.Dao.user.register;

import Model.tinkerpop.Dao.GremlinWithRemote;
import Model.tinkerpop.Dao.IDAOVertex;
import com.alibaba.fastjson.JSONObject;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wjl198435 on 8/9/2017.
 */
public class WX_Register extends IDAOVertex {

    private static final Logger LOGGER = LoggerFactory.getLogger(WX_Register.class);

    /*******************用户注册标签******************************/
    static private final String labVertexUser = "wxUser";

    static private String[] vertexLabel = {labVertexUser};


    /*******************微信注册用户信息*********************/

    //注册时间
    static private final String time = "time";

    //static  private final String lab_Vertex_wx_reg="wx_register";

    //微信用户在本小程序openId
    static private final String openId = "openId";

    //微信号
    static private final String account = "account";

    //微信开发者appId(公众号、小程序)通用唯一id
    static private final String unionId = "unionId";

    //微信用户小程序呢称
    static private final String nickName = "nickName";

    //微信用户头像
    static private final String avatarUrl = "avatarUrl";

    //微信用户登记性别
    static private final String gender = "gender";

    //微信用户登记所在国家
    static private final String country = "country";
    //微信用户登记所在省份
    static private final String province = "province";
    //微信用户登记所在城市
    static private final String city = "city";

    static public boolean isOpenIdRegister(String openId,Map map) {
        ArrayList<Map<String, Object>> l = new ArrayList<Map<String, Object>>();
        map.put("status", 10000);
        map.put("msg", "用户未注册");
        boolean res = false;
        try {
            GraphTraversalSource g = GremlinWithRemote.getInstance();
            //g1.V().hasLabel('wxUser').has('openId','oxb8P0WuEFZtTFVCC2Dj06jOcc_M').id()
            l = (ArrayList) g.V().hasLabel(labVertexUser).has(getOpenId(), openId).id().toList();
            if (l.isEmpty()) {

                return res;

            } else {
                map.put("id", l.get(0));

            }

        } catch (java.util.NoSuchElementException e) {
            LOGGER.warn("Not existing openId:" + openId);
            return res;

        } catch (Exception e) {
            map.put("status", -1);
            map.put("msg", "内部网络错误");
            LOGGER.error(e.getMessage());
            return res;
        }
        map.put("status", 0);
        map.put("msg", "登录成功");
        res = true;
        return res;
    }


    static public boolean Register(JSONObject userInfo,Map map) {

        LOGGER.info(userInfo.toJSONString());

        boolean res = false;

        try {
            doInsertVertex(labVertexUser, userInfo);
        } catch (Exception e) {

            map.put("status", 1);

            map.put("msg", "注册失败");

            LOGGER.error(e.getMessage());
            return res;
        }

        map.put("status", 0);
        map.put("id", 0);
        map.put("msg", "注册成功");
        res = true;
        return res;
    }


    public static void main(String[] args) {
        String label = labVertexUser;
        JSONObject jsonObj = new JSONObject();
        long time = 10;
        //jsonObj.put(wxUserData.getAccount(), wxUserData.getAccount() + time);
        //jsonObj.put(wxUserData.getOpenId(), wxUserData.getOpenId() + i);
        //jsonObj.put(wxUserData.getAvatarUrl(), wxUserData.getAvatarUrl() + time);
        //jsonObj.put(wxUserData.getNickName(), wxUserData.getNickName() + time);
        jsonObj.put(openId, "test");
        try {
            IDAOVertex.doInsertVertex(label, jsonObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getLabVertexUser() {
        return labVertexUser;
    }

    public static String[] getVertexLabel() {
        return vertexLabel;
    }

    public static String getTime() {
        return time;
    }

    public static String getOpenId() {
        return openId;
    }

    public static String getAccount() {
        return account;
    }

    public static String getUnionId() {
        return unionId;
    }

    public static String getNickName() {
        return nickName;
    }

    public static String getAvatarUrl() {
        return avatarUrl;
    }

    public static String getGender() {
        return gender;
    }

    public static String getCountry() {
        return country;
    }

    public static String getProvince() {
        return province;
    }

    public static String getCity() {
        return city;
    }
}
