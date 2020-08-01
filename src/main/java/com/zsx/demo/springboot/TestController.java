package com.zsx.demo.springboot;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

//@RequestMapping //是一个用来处理请求地址映射的注解，可用于类或方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径
@RestController //用来返回Json
@Controller
@Api(value = "/test", tags = "测试接口")  //swagger分类标题注解
public class TestController {
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    @ApiOperation("获取Info")
    public Info getInfo(){
        Info info = new Info();
        info.id = "59192";
        info.data = "It's name is too complaint...";
        return info;
    }

    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    @ApiOperation("根获取指定Info")
    @ApiImplicitParam(name = "person", value = "名称", defaultValue = "John", required = true)
    public Info getUserInfo(String person){
        Info info = new Info();
        info.id = "59192";
        info.data = "name:"+person;
        return info;
    }
}

class Info {
    public String id;
    public String data;
}