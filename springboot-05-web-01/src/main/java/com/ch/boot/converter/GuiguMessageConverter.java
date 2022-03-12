/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/3/4 13:02
 * 开发名称：GuiguMessageConverter
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.boot.converter;

import com.ch.boot.bean.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 自定义converter
 * */
public class GuiguMessageConverter implements HttpMessageConverter<Person> {
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        /**能不能把Person类型的数据读成某种类型
         * 这个方法功能是：请求参数被@RequestBody标识使用
         * */
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        /**请求返回值类型是Person 就支持写*/
        return clazz.isAssignableFrom(Person.class);
    }

    /**
     * 服务器要统计所有MessageConverter能写出哪些类容类型
     *
     * 在这里要指明 能操作 application/x-guigu 类型
     * @return
     * */
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        /**因为要求返回MediaType类型集合
         * 我们需要将字符串转换成媒体类型集合*/
        return MediaType.parseMediaTypes("application/x-guigu");
    }


    @Override
    public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    /**自定义协议数据的写出*/
    @Override
    public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        /*准备好了自定数据类型*/
        String data = person.getUserName()+";" + person.getAge() +";"+person.getBirth()+";"+person.getPet();
        /*写出数据*/
        /*它是一个输出流*/
        OutputStream body = outputMessage.getBody();
        /*写出*/
        body.write(data.getBytes("GBK"));
    }
}