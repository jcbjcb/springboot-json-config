package com.jcb.spring.json.config.beanUtil.bean;

import com.alibaba.fastjson.JSONObject;
import com.jcb.spring.json.config.beanUtil.remote.config.build.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public class BasicConfig {

    //{"db": {"host": "192.168.12.216", "name": "strategy", "port": 3309, "password": "root", "username": "root"},
    // "redis": {"db": 1, "host": "192.168.12.216", "port": 6379, "password": null},
    // "channel": {"stop": "strategy::stop", "task": "strategy::task", "start": "strategy::start", "status": "strategy::status"}}

    private static final String CONFIG_FILE_NAME="config.json";

    private MysqlConfig mysqlConfig;

    private RedisConfig redisConfig;

    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private ApplicationArguments args;
    @Autowired
    private Environment env;

    String url ;
    String name ;
    String nonce ;
    String token ;
    long  timeStamp;
    String signature;


    @PostConstruct
    @SuppressWarnings("unchecked")
    public void loadConfig() throws IOException {


        List<String> argsList= args.getNonOptionArgs();
        String arg;
        String file = "classpath:config.json";
        String configJosn = "";
        boolean  useDefaultConfig = false;
       if(argsList.contains("-p")){

           try {
               int index= argsList.indexOf("-p")+1;
               arg=argsList.get(index);

               name =NameUtil.nameBuild(arg);
               url= env.getProperty("remote.config.url");
               nonce = NonceUtil.getNonce();
               token = TokenBuild.tokenBuild();
               timeStamp=TenLenTimeStamp.getTenLenTimeStamp();
               signature= SignatureUtil.signtureUtil(timeStamp,token,nonce);

               url=ConfigUrlBuild.buildUrl(url,name,timeStamp,nonce,signature);

               String josnStr= restTemplate.getForObject(url,String.class);

               System.out.println("josn:"+josnStr);
               configJosn=josnStr;
           } catch (Exception e) {
               useDefaultConfig=true;
           }

       }else if(argsList.contains("-c")){
           try {
               int index= argsList.indexOf("-c")+1;
               file=argsList.get(index);
               File configFile = new File(file);

               configJosn=getConfig(configFile);
           } catch (Exception e) {
               useDefaultConfig=true;
           }
       }else{
           useDefaultConfig=true;
       }
       if(useDefaultConfig){
           file="classpath:config.json";
           File configFile= ResourceUtils.getFile(file);
           configJosn=getConfig(configFile);
       }
        System.out.println(configJosn);
        JSONObject json= JSONObject.parseObject(configJosn);
        this.mysqlConfig= json.getObject("db",MysqlConfig.class);
        this.redisConfig= json.getObject("redis",RedisConfig.class);

        Map<String,String> redisChannel=json.getObject("channel", Map.class);

        this.redisConfig.setChannel(redisChannel);
        if(!useDefaultConfig) {
            saveConfig(configJosn);
        }
    }

    public MysqlConfig getMysqlConfig() {
        return mysqlConfig;
    }

    public void setMysqlConfig(MysqlConfig mysqlConfig) {
        this.mysqlConfig = mysqlConfig;
    }

    public RedisConfig getRedisConfig() {
        return redisConfig;
    }

    public void setRedisConfig(RedisConfig redisConfig) {
        this.redisConfig = redisConfig;
    }


    private String getConfig(File configFile) throws IOException {

        FileInputStream fio= new FileInputStream(configFile);
        byte[] b = new byte[1024];
        int len = 0;
        StringBuilder sb = new StringBuilder();
        while((len=fio.read(b))!=-1){

            sb.append(new String(b,0,len));
        }

        fio.close();
//        System.out.println("sb:"+sb.toString());
        return sb.toString().replaceAll("\r\n","").replaceAll(" ","");
    }

    private void saveConfig(String config) throws IOException {


        String path= ResourceUtils.getURL("classpath:").getPath();
        File file =new File(path+"/"+CONFIG_FILE_NAME);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(config.getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();

    }

}
