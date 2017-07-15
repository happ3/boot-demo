package com.boot.demo.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service
public class RedisService {
    private Logger logger = LoggerFactory.getLogger(RedisService.class);
	
    private JedisPool cachePool;

    @Autowired
    public RedisService(@Value("${redis.host}") String hosts,
                        @Value("${redis.port}") Integer port,
                        @Value("${redis.password}") String password) {
        if (StringUtil.isNotEmpty(password) && !StringUtil.stringEquals(password, "empty")) {
            cachePool = new JedisPool(new JedisPoolConfig(), hosts, port, 10 * 1000, password);
        } else {
            cachePool = new JedisPool(new JedisPoolConfig(), hosts, port);
        }
    }
    
    public boolean set(String key, String value, int second) {
        Jedis jedis = null;

        try {
            jedis = this.cachePool.getResource();
            jedis.setex(key, second, value);
            boolean ex = true;
            return ex;
        } catch (Exception var9) {
            this.logger.error("set error.", var9);
        } finally {
            this.close(jedis);
        }

        return false;
    }
    
    /**
     * 添加到List
     *
     * @param key   key值
     * @param value 值
     * @return 是否添加成功
     */
    public boolean addList(String key, String... value) {
        if (key == null || value == null) {
            return false;
        }
        Jedis jedis = null;
        try {
            jedis = cachePool.getResource();
            jedis.lpush(key, value);
            return true;
        } catch (Exception ex) {
        } finally {
            close(jedis);
        }
        return false;
    }
    
    
    
    private void close(Jedis jedis) {
        try {
            if (jedis != null) {
                jedis.close();
            }
        } catch (Exception e) {
        }
    }
}
