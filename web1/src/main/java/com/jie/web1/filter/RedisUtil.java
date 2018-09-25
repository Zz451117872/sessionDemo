package com.jie.web1.filter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Redis 工具类
 * Created by shuzheng on 2016/11/26.
 */
public class RedisUtil {

	protected static ReentrantLock lockPool = new ReentrantLock();
	protected static ReentrantLock lockJedis = new ReentrantLock();

	private static final Logger LOGGER = LoggerFactory.getLogger(RedisUtil.class);

	// Redis服务器IP
	private static String IP = "localhost";

	// Redis的端口号
	private static int PORT = 6379;

	// 访问密码
	private static String PASSWORD = "com.ant.com.redis";

	// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
	private static boolean TEST_ON_BORROW = false;

	private static JedisPool jedisPool = null;

	/**
	 * redis过期时间,以秒为单位
	 */
	// 一小时
	public final static int EXRP_HOUR = 60 * 60;
	// 一天
	public final static int EXRP_DAY = 60 * 60 * 24;
	// 一个月
	public final static int EXRP_MONTH = 60 * 60 * 24 * 30;

	/**
	 * 初始化Redis连接池
	 */
	private static void initialPool() {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setTestOnBorrow(TEST_ON_BORROW);
			jedisPool = new JedisPool(config, IP, PORT);
		} catch (Exception e) {
			LOGGER.error("First create JedisPool error : " + e);
		}
	}

	/**
	 * 在多线程环境同步初始化
	 */
	private static synchronized void poolInit() {
		if (null == jedisPool) {
			initialPool();
		}
	}


	/**
	 * 同步获取Jedis实例
	 * @return Jedis
	 */
	public synchronized static Jedis getJedis() {
		poolInit();
		Jedis jedis = null;
		try {
			if (null != jedisPool) {
				jedis = jedisPool.getResource();
				try {
					jedis.auth(PASSWORD);
				} catch (Exception e) {

				}
			}
		} catch (Exception e) {
			LOGGER.error("Get jedis error : " + e);
		}
		return jedis;
	}

	/**
	 * 设置 String
	 * @param key
	 * @param value
	 */
	public synchronized static void set(String key, String value) {
		try {
			value = StringUtils.isBlank(value) ? "" : value;
			Jedis jedis = getJedis();
			jedis.set(key, value);
			jedis.close();
		} catch (Exception e) {
			LOGGER.error("Set key error : " + e);
		}
	}

	public synchronized static void setExpire( String key , Integer expireTime){
		try {
			Jedis jedis = getJedis();

			jedis.expireAt( key , expireTime );
			jedis.close();
		} catch (Exception e) {
			LOGGER.error("Set key error : " + e);
		}
	}

	public synchronized static void removeKey( String key){
		try {
			Jedis jedis = getJedis();
			if( jedis.exists( key )){
				jedis.del(key);
			}
			jedis.close();
		} catch (Exception e) {
			LOGGER.error("Set key error : " + e);
		}
	}

	public synchronized  static void hset( String key , String field , String value , Integer expireTime){
		try {
			value = StringUtils.isBlank(value) ? "" : value;
			Jedis jedis = getJedis();
			jedis.hset( key , field ,value );
			jedis.expireAt( key , expireTime );

			jedis.close();
		} catch (Exception e) {
			LOGGER.error("Set key error : " + e);
		}
	}

	public synchronized static void expireAt( String key , Integer expireTime){
		try {
			Jedis jedis = getJedis();
			jedis.expireAt( key , expireTime );
			jedis.close();
		} catch (Exception e) {
			LOGGER.error("Set key error : " + e);
		}
	}

	public synchronized  static String hget( String key , String field ){
		Jedis jedis = getJedis();
		if (null == jedis) {
			return null;
		}
		String value = jedis.hget( key ,field);
		jedis.close();
		return value;
	}


	public synchronized  static void hset( String key , String field , String value ){
		try {
			value = StringUtils.isBlank(value) ? "" : value;
			Jedis jedis = getJedis();
			jedis.hset( key , field ,value );
			jedis.close();
		} catch (Exception e) {
			LOGGER.error("Set key error : " + e);
		}
	}


	/**
	 * 设置 byte[]
	 * @param key
	 * @param value
	 */
	public synchronized static void set(byte[] key, byte[] value) {
		try {
			Jedis jedis = getJedis();
			jedis.set(key, value);
			jedis.close();
		} catch (Exception e) {
			LOGGER.error("Set key error : " + e);
		}
	}

	/**
	 * 设置 String 过期时间
	 * @param key
	 * @param value
	 * @param seconds 以秒为单位
	 */
	public synchronized static void set(String key, String value, int seconds) {
		try {
			value = StringUtils.isBlank(value) ? "" : value;
			Jedis jedis = getJedis();
			jedis.setex(key, seconds, value);
			jedis.close();
		} catch (Exception e) {
			LOGGER.error("Set keyex error : " + e);
		}
	}

	/**
	 * 设置 byte[] 过期时间
	 * @param key
	 * @param value
	 * @param seconds 以秒为单位
	 */
	public synchronized static void set(byte[] key, byte[] value, int seconds) {
		try {
			Jedis jedis = getJedis();
			jedis.set(key, value);
			jedis.expire(key, seconds);
			jedis.close();
		} catch (Exception e) {
			LOGGER.error("Set key error : " + e);
		}
	}

	/**
	 * 获取String值
	 * @param key
	 * @return value
	 */
	public synchronized static String get(String key) {
		Jedis jedis = getJedis();
		if (null == jedis) {
			return null;
		}
		String value = jedis.get(key);
		jedis.close();
		return value;
	}

	/**
	 * 获取byte[]值
	 * @param key
	 * @return value
	 */
	public synchronized static byte[] get(byte[] key) {
		Jedis jedis = getJedis();
		if (null == jedis) {
			return null;
		}
		byte[] value = jedis.get(key);
		jedis.close();
		return value;
	}

	/**
	 * 删除值
	 * @param key
	 */
	public synchronized static void remove(String key) {
		try {
			Jedis jedis = getJedis();
			jedis.del(key);
			jedis.close();
		} catch (Exception e) {
			LOGGER.error("Remove keyex error : " + e);
		}
	}

	/**
	 * 删除值
	 * @param key
	 */
	public synchronized static void remove(byte[] key) {
		try {
			Jedis jedis = getJedis();
			jedis.del(key);
			jedis.close();
		} catch (Exception e) {
			LOGGER.error("Remove keyex error : " + e);
		}
	}

	/**
	 * lpush
	 * @param key
	 * @param key
	 */
	public synchronized static void lpush(String key, String... strings) {
		try {
			Jedis jedis = RedisUtil.getJedis();
			jedis.lpush(key, strings);
			jedis.close();
		} catch (Exception e) {
			LOGGER.error("lpush error : " + e);
		}
	}

	/**
	 * lrem
	 * @param key
	 * @param count
	 * @param value
	 */
	public synchronized static void lrem(String key, long count, String value) {
		try {
			Jedis jedis = RedisUtil.getJedis();
			jedis.lrem(key, count, value);
			jedis.close();
		} catch (Exception e) {
			LOGGER.error("lpush error : " + e);
		}
	}

	/**
	 * sadd
	 * @param key
	 * @param value
	 * @param seconds
	 */
	public synchronized static void sadd(String key, String value, int seconds) {
		try {
			Jedis jedis = RedisUtil.getJedis();
			jedis.sadd(key, value);
			jedis.expire(key, seconds);
			jedis.close();
		} catch (Exception e) {
			LOGGER.error("sadd error : " + e);
		}
	}

	/**
	 * incr
	 * @param key
	 * @return value
	 */
	public synchronized static Long incr(String key) {
		Jedis jedis = getJedis();
		if (null == jedis) {
			return null;
		}
		long value = jedis.incr(key);
		jedis.close();
		return value;
	}

	/**
	 * decr
	 * @param key
	 * @return value
	 */
	public synchronized static Long decr(String key) {
		Jedis jedis = getJedis();
		if (null == jedis) {
			return null;
		}
		long value = jedis.decr(key);
		jedis.close();
		return value;
	}

}