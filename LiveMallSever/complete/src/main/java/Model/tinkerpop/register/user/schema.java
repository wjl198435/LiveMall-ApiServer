package Model.tinkerpop.register.user;

import org.apache.tinkerpop.gremlin.process.traversal.Order;
import org.apache.tinkerpop.gremlin.structure.Direction;
import org.apache.tinkerpop.gremlin.structure.Property;
import org.janusgraph.core.*;
import org.janusgraph.core.schema.JanusGraphManagement;
//import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wjl198435 on 5/9/2017.
 */
public  class schema {
    private static final Logger LOGGER = LoggerFactory.getLogger(schema.class);


//     userInfo.put("openId", userInfoJSON.get("openId"));
//                userInfo.put("nickName", userInfoJSON.get("nickName"));
//                userInfo.put("gender", userInfoJSON.get("gender"));
//                userInfo.put("city", userInfoJSON.get("city"));
//                userInfo.put("province", userInfoJSON.get("province"));
//                userInfo.put("country", userInfoJSON.get("country"));
//                userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
//                userInfo.put("unionId", userInfoJSON.get("unionId"));

   // static private  String[] vertexLabel={labVertexUser};


    /*******************用户注册标签******************************/
    static private final String labVertexUser="User";

    static private  String[] vertexLabel={labVertexUser};




    /*******************微信注册用户信息*********************/

    //注册渠道
    static  private final String reg_channel="reg_channel";

    //static  private final String lab_Vertex_wx_reg="wx_register";

    //微信用户在本小程序openId
    static  private final String wx_openId="wx_openId";

    //微信号
    static private final String wx_account ="wx_account";

    //微信开发者appId(公众号、小程序)通用唯一id
    static private final String wx_unionId="wx_unionId";

    //微信用户小程序呢称
    static  private final String wx_nickName="wx_nickName";

    //微信用户头像
    static  private final String wx_avatarUrl="wx_avatarUrl";

    //微信用户登记性别
    static private final String wx_gender="wx_gender";

    //微信用户登记所在国家
    static private final String wx_country="wx_country";
    //微信用户登记所在省份
    static private final String wx_province="wx_province";
    //微信用户登记所在城市
    static private final String wx_city="wx_city";



    static private  String[] wxUserInfoPropertyKeyArray ={reg_channel,wx_account,wx_openId,wx_unionId,
            wx_nickName,wx_avatarUrl,wx_gender,wx_country,wx_province, wx_city};


    //注册时间
    static private final String REG_Time="reg_time";

    /**海蛙平台**/
    //用户id
    static private final String uId="uId";
    //用户名
    static private final String userName="userName";

    //用户名
    static private final String userPWD="userPWD";

    //手机号码
    static private final String tel="Tel";

    //绑定手机号码
    static private final String bindTel="bindTel";

    //绑定email
    static private final String bindEmail="bindEmail";

    //会员QQ
    static private final String QQ="QQ";

    //身份证号码
    static private final String idNumber="IDNumber";

    //用户类别(买家、卖家，派送小哥、....)
    static private final String userType="userType";

    //会员等级
    static private final String userLevel="userLevel";

    





    public static void main(String[] args) {

        for(int i=0;i<wxUserInfoPropertyKeyArray.length;i++){
            //LOGGER.info(wxUserInfoArray[i]);

            switch(wxUserInfoPropertyKeyArray[i])
            {
                case reg_channel :
                    {
                        LOGGER.info("reg_channel:"+wxUserInfoPropertyKeyArray[i]);
                    break;
                   }


                default:LOGGER.info(wxUserInfoPropertyKeyArray[i]);
            }

        }




       // String conf = "/data/graph/janusgraph-hbase-es.properties";
       // JanusGraph graph = JanusGraphFactory.open(conf);
//    //makeVertexPropertyKeyIndex(graph,"seqID4","seqID4",true)
//
        //create(graph)
//
//    //makeEdgeLabel(graph,"seqIDE",null)
//    //    createSchema(JanusGraphInstance.getGraph)
//    //    JanusGraphInstance.getGraph.close()
//    //createSchema(conf)
//
       // graph.close();
    }

}
