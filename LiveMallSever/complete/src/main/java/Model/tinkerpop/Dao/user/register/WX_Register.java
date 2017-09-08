package Model.tinkerpop.Dao.user.register;

/**
 * Created by wjl198435 on 8/9/2017.
 */
public class WX_Register {

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
}
