package UserService; /**
 * Created by wjl198435 on 1/9/2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-08-08 15:49
 */
@Component("userService")
public class UserServiceImpl implements  IUserServer {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("#{config[name]}")
    private String name;

    @Value("#{config[age]}")
    private Integer age;

    @Value("#{config[password]}")
    private String password;

    @Override
    public void login(String username){
        System.out.println("name:"+name+",age="+age+",password="+password);
    }


}
