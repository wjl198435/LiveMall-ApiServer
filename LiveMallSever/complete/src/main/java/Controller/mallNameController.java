package Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;
import MallName.*;

@Controller
@RequestMapping("/mall/config/get-value")
public class mallNameController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody
    mallName sayHello(@RequestParam(value="key", required=false, defaultValue= "MallName") String KEY) {



        int code=0;
        String msg="success";

        mallNameInfo info=new mallNameInfo();

        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String CreatAt = formatter.format(currentTime);
        info.setCreatAt(CreatAt);

        int DateType=0;
        info.setDateType(DateType);

        int id=9;
        info.setId(id);

        String key= KEY;
        info.setKey(key);

        String remark= "商城名称";
        info.setRemark(remark);

        Date currentTime1 = new Date();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String UpdateAt = formatter.format(currentTime1);
        info.setUpdateAt(UpdateAt);

        int userId=100;
        info.setUserId(userId);

        String value="阳光行动";
        info.setValue(value);

       //JSONObject json=JSON.parseObject(JSON.toJSONString(info)) ;
        JSONObject obj =(JSONObject) JSON.toJSON(info);
        //String str_json= JSON.toJSONString(info);

        return new mallName(code, obj,msg);
    }

}
