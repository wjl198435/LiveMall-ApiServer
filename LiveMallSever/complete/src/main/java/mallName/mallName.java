package mallName;
import com.alibaba.fastjson.JSONObject;

public class mallName {

    private final int code;
    private final Object data;
    private final String msg;
    public mallName(int code, com.alibaba.fastjson.JSONObject json,String msg) {
        this.code = code;
        this.data = json;
        this.msg=msg;

    }

    public long getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

}
