package com.product.utils;

import java.util.Properties;

public class DataLoader {
    private final Properties properties;
    private static DataLoader dataLoader;

    private DataLoader(){
        properties = PropertyUtils.propertyLoader("src/test/resources/data.properties");
    }

    public static DataLoader getInstance(){
        if(dataLoader == null){
            dataLoader = new DataLoader();
        }
        return dataLoader;
    }

    public String getGetUser01Id(){
        String prop = properties.getProperty("get_user_id");
        if(prop != null) return prop;
        else throw new RuntimeException("property get_user_id is not specified in the data.properties file");
    }

    public String getGetUser01Name(){
        String prop = properties.getProperty("get_user1_name");
        if(prop != null) return prop;
        else throw new RuntimeException("property get_user1_name is not specified in the data.properties file");
    }

    public String getGetUser01Email(){
        String prop = properties.getProperty("get_user1_email");
        if(prop != null) return prop;
        else throw new RuntimeException("property get_user1_email is not specified in the data.properties file");
    }
    public String makePostTitle(){
        String prop = properties.getProperty("make_post_title");
        if(prop != null) return prop;
        else throw new RuntimeException("property make_post_title is not specified in the data.properties file");
    }
    public String makePostBody(){
        String prop = properties.getProperty("make_post_body");
        if(prop != null) return prop;
        else throw new RuntimeException("property make_post_body is not specified in the data.properties file");
    }
    public String getCommentTitle(){
        String prop = properties.getProperty("comment_title");
        if(prop != null) return prop;
        else throw new RuntimeException("property comment_title is not specified in the data.properties file");
    }
    public String getCommentBody(){
        String prop = properties.getProperty("comment_body");
        if(prop != null) return prop;
        else throw new RuntimeException("property comment_body is not specified in the data.properties file");
    }
}
