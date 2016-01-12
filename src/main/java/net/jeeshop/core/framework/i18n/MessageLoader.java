package net.jeeshop.core.framework.i18n;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dylan on 15-1-26.
 */
public class MessageLoader {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageLoader.class);
	
    private MessageLoader(){
        init();
    }
    private static MessageLoader instance = null;
    public static MessageLoader instance(){
        if(instance == null){
            instance = new MessageLoader();
        }
        instance = new MessageLoader();
        return instance;
    }

    public String getMessage(String key){
        if(resourceBundle == null){
            return key;
        }
        return resourceBundle.getString(key);
    }

    private ResourceBundle resourceBundle;


    public synchronized void init(){
        if(resourceBundle == null){
			resourceBundle = ResourceBundle.getBundle("i18n/jeeshop");
            Map<String,String> entrys = new HashMap<String, String>();
            for (Enumeration<String> iterator = resourceBundle.getKeys(); iterator.hasMoreElements();) {
            	entrys.put(iterator.nextElement(), resourceBundle.getString(iterator.nextElement()));
			}
            logger.info("init MessageLoader.. Local:{}, Entrys:{}", resourceBundle.getLocale(), entrys);
        }
    }
}
