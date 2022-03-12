/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/2/24 22:19
 * 开发名称：ParameterTestController
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.boot.contriller;



import com.ch.boot.bean.Person;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {

    /**
     * 数据绑定：页面提交的请求数据（GET、POST）都可以和对象属性进行绑定
     * @param person
     * @return
     * */
    @PostMapping("saveUser")
    public Person saveUser(Person person){

        return person;
    }

    @GetMapping("/car/{id}/owner/{username}/{age}")
    public Map<String, Object> getCar(@PathVariable("id") String id,
                                      @PathVariable("username") String name,
                                      @PathVariable("age") String age,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader() Map<String, String> headers,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestParam("aa") Integer aa,
                                      @RequestParam("inters") List<String> inters,
                                      @RequestParam MultiValueMap<String, String> params
                                      ) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("age", age);
        map.put("headers", headers);
        map.put("user-agent", userAgent);
        map.put("pv", pv);

        map.put("aa",aa);
        map.put("inters",inters);
        map.put("params",params);

        return map;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<Object, Object> map = new HashMap<>();
        map.put("content",content);
        return map;
    }
}