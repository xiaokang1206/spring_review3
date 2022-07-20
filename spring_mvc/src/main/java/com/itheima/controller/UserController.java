package com.itheima.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import com.itheima.domain.VO;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
//请求地址 http://localhost:8080:/user/success.jsp
    //页面跳转，返回字符串
    @RequestMapping(value = "/quick",method = RequestMethod.GET  )//params = {"username"}请求参数中必须包含username
                                                                    //produces = {"text/html;charset=utf-8"} 设置响应格式
    public String save(){
        System.out.println("Controller save Running..");

        return "success";
       //forward:/success.jsp
    }

    //页面跳转，返回ModelAndView对象
    @RequestMapping(value = "/quick2")
    public ModelAndView save2(){
        /**
         * Model:模型 作用封装数据
         * View：视图 作用展示数据
         */
 ModelAndView modelAndView=new ModelAndView();
        //设置模型数据
        modelAndView.addObject("username","itcast");

        //设置视图名称:跳转到的页面
        modelAndView.setViewName("success");

        return modelAndView;

    }
    //页面跳转，返回 modelAndView对象
    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
                //该对象由springMVC注入
        modelAndView.addObject("username","itcast");
        modelAndView.setViewName("success");
        return modelAndView;

    }

    //页面跳转，返回 model对象
    @RequestMapping(value = "/quick4")
    public String save4(Model model){
        model.addAttribute("username","博学谷");
        return "success";

    }
    //页面跳转  获取request对象
    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request){
        String servletPath = request.getServletPath();
        request.setAttribute("username","itcast2");

        return "success";

    }

    //不页面跳转，返回字符串
    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response) throws IOException {

          response.getWriter().write("hello,world");
    }

    //不页面跳转，返回字符串
    @RequestMapping(value = "/quick7")
    @ResponseBody //告诉springMVC框架不进行页面跳转,直接数据响应
    public String save7() throws IOException {

        return "hello,itheima";

    }

    //返回字符串
    @RequestMapping(value = "/quick8")
    @ResponseBody //告诉springMVC框架不进行页面跳转,直接数据响应
    public String save8() {

        return "{\"username\":\"zhangsan\",\"age\":\"18\"}";//响应json格式数据

    }
    //返回json对象(字符串)
    @RequestMapping(value = "/quick9")
    @ResponseBody //告诉springMVC框架不进行页面跳转,直接数据响应
    public String save9() throws IOException {
            User user=new User();
            user.setUsername("lisi");
            user.setAge(18);
            //使用json的转换工具将对象转换为json格式的字符串
        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        return json;

    }

    //返回字符串
    @RequestMapping(value = "/quick10")
    @ResponseBody //告诉springMVC框架不进行页面跳转,直接数据响应
    //期望springMVC自动将User转换成json格式的字符串,需要配置RequestMappingHandlerAdapter"
    public User save10() throws IOException {
        User user=new User();
        user.setUsername("lisi");
        user.setAge(18);
        return user;

    }


    @RequestMapping(value = "/quick11")
    @ResponseBody
    //获取请求参数 username&age
    public void save11(String username ,int age) throws IOException {

        System.out.println(username);
        System.out.println(age);


    }
    //获取请求参数
    @RequestMapping(value = "/quick12")
    @ResponseBody
    //获取请求参数 username&age,用对象接收，请求参数名需要和属性名一致
    public void save12(User user) throws IOException {
        System.out.println(user);
    }

    //获取请求参数
    @RequestMapping(value = "/quick13")
    @ResponseBody
    //用一个数组接收请求参数,strs=aaa&strs=bbb
    public void save13(String[] strs) throws IOException {

        System.out.println(Arrays.asList(strs));
    }

    //获取请求参数
    @RequestMapping(value = "/quick14")
    @ResponseBody
    //用一个集合接收请求参数，要将集合包装到一个POJO中,用post方式提交
    public void save14(VO vo) throws IOException {

        System.out.println(vo);

    }
    //获取请求参数
    @RequestMapping(value = "/quick15")
    @ResponseBody
    //用一个集合接收请求参数,使用@RequestBody，把请求体内容直接封装到集合中，无需POJO类
    public void save15(@RequestBody List<User> userList) throws IOException {

        System.out.println(userList);

    }

    @RequestMapping(value = "/quick16")
    @ResponseBody
    //获取请求参数,使用@RequestParam将name映射到username上 ,required =false表示该参数在请求时可以不带上,
    // defaultValue = "itcast"表示没有请求参数是默认请求参数是itcast
    public void save16(@RequestParam( value = "name",required = false,defaultValue = "itcast") String username) throws IOException {
        System.out.println(username);
    }

    //Restful风格获取请求参数
    //http://localhost:8080/user/quick17zhangsan  相当于,不用？去连接了
    @RequestMapping(value = "/quick17{username}" ,method = RequestMethod.GET)//占位符
    @ResponseBody
    public void save17(@PathVariable(value = "username" ) String name) throws IOException {
        /**
         *  GET:用于获取资源
         *  POST:用于新建资源
         *  PUT：用于更新资源
         *  DELETE：用于删除资源
         */

        System.out.println(name);

    }

//测试类型转换器
    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(Date date  )  {
        System.out.println(date);

    }

    //获取请求头
    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void save19(@RequestHeader(value = "User-Agent",required = false) String user_agent)  {

        System.out.println(user_agent);

    }

    //获取cookie中的JSESSIONID
    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(@CookieValue(value = "JSESSIONID",required = false) String jsessionId)  {

        System.out.println(jsessionId);

    }
    //文件上传
    @RequestMapping(value = "/quick21")
    @ResponseBody //MultipartFile名称需要和你上传的文件的表单项名称一致
    public void save21(String username,MultipartFile uploadFile,MultipartFile uploadFile2) throws IOException {
        System.out.println(username);
        //获取上传文件的名称
        String originalFilename = uploadFile.getOriginalFilename();//文件的真实名称
        String originalFilename1 = uploadFile2.getOriginalFilename();
        uploadFile.transferTo(new File("D:\\uploads\\"+originalFilename));
uploadFile2.transferTo(new File("D:\\uploads\\"+originalFilename1));

    }

    //表单项文件名称相同的文件上传
    @RequestMapping(value = "/quick22")
    @ResponseBody //MultipartFile名称需要和你上传的文件的表单项名称一致
    public void save22(String username,MultipartFile[] uploadFile ) throws IOException {
        System.out.println(username);

        for (MultipartFile multipartFile : uploadFile) {
            String originalFilename = multipartFile.getOriginalFilename();//获取文件真实名

             multipartFile.transferTo(new File("D:\\uploads\\"+originalFilename));
        }

    }

}
