package com.example.secondkill.miaosha.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {

    @Autowired
    JedisPool jedisPool;

    /**
     * 第二个参数为redis里key value对中， string化的对象类型，用于类型转化返回
     *
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = jedis.get(key);
            T t = stringToBean(str, clazz);
            return t;
        } finally {
            returnToPool(jedis);
        }
    }

    private <T> T stringToBean(String string, Class<T> clazz) {
        if (string == null || string.length() <= 0) {
            return null;
        }

        if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(string);
        } else if (clazz == String.class) {
            return (T) string;
        } else if (clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(string);
        }
        return (T) JSON.toJavaObject(JSON.parseObject(string), clazz);

    }

    public <T> boolean set(String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = beanToString(value);
            if (str == null) {
                return false;
            }
            jedis.set(key, str);
            return true;
        } finally {
            returnToPool(jedis);
        }
    }

    private <T> String beanToString(T value) {
        if (value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return "" + value;
        } else if (clazz == String.class) {
            return (String) value;
        } else if (clazz == long.class || clazz == Long.class) {
            return "" + value;
        } else {
            return JSON.toJSONString(value);
        }
    }

    private void returnToPool(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

}
