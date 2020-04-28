package com.nan.cebo.signup.service.Impl;

import com.nan.cebo.signup.domain.Account;
import com.nan.cebo.signup.domain.SchoolInformation;
import com.nan.cebo.signup.persistence.AccountMapper;
import com.nan.cebo.signup.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/23 13:53
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountMapper accountMapper;

    @Override
    public int checkAccountStatus(String openId,String nickName) {
        Account account=accountMapper.getUserInformation(openId);
        if(null==account){
            Account account1=new Account();
            account1.setNickName(nickName);
            account1.setUuid(openId);
            accountMapper.insertAccount(account1);
            return 0;
        }
        else {
            if(account.getStudentId()!=null){
                return 1;
            }
        }
        return 0;
    }

    @Override
    public String getWeChatUid(String code) {
        try {
            String result="";
            URL url = new URL("https://api.weixin.qq.com/sns/jscode2session?appid=wxec8feaef0bcaa9ce&secret=7725b03e4d19bfa34badba5d386788d7&js_code="+code+"&grant_type=authorization_code&connect_redirect=1");
            //打开和url之间的连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            PrintWriter out = null;
            //请求方式
            //conn.setRequestMethod("POST");
            //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            //设置是否向httpUrlConnection输出，设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
            //最常用的Http请求无非是get和post，get请求可以获取静态页面，也可以把参数放在URL字串后面，传递给servlet，
            //post与get的 不同之处在于post的参数不是放在URL字串里面，而是放在http请求的正文内。
            conn.setRequestMethod("GET");
            //GET和POST必须全大写
            /**GET方法请求*****start*/
            /**
             * 如果只是发送GET方式请求，使用connet方法建立和远程资源之间的实际连接即可；
             * 如果发送POST方式的请求，需要获取URLConnection实例对应的输出流来发送请求参数。
             * */
            conn.connect();
            Map<String, List<String>> map = conn.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String line;
            String openid = null;
            while ((line = in.readLine()) != null) {
                result += line;
                System.out.println(line);
                openid=line.split(",")[1].split(":")[1].replace("\"","").replace("}","");
            }
            return openid;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateSchoolInformation(SchoolInformation information) {
        try {
            accountMapper.updateSchoolInformation(information);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean insertAccount(Account account){
        try {
            accountMapper.insertAccount(account);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Account getAccountInformation(String openId) {
        Account account=accountMapper.getUserInformation(openId);
        if(null!=account){
            return account;
        }
        return null;
    }
}
