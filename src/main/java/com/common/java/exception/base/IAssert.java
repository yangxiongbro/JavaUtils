package com.common.java.exception.base;

import java.util.Collection;

/**
 * <b><code>Assert</code></b>
 * <p/>
 * 异常断言接口
 * <p/>
 * <b>Creation Time:</b> 2022/8/24 上午11:37.
 *
 * @author yang xiong
 */
public interface IAssert {

    /**
     * @description: 断言对象为 not null，如果对象为 null，则抛出异常
     * @param obj 待判断对象
     * @return
     * @throws
     * @author yang xiong
     * @date 2022/8/24 上午11:55
     */
    void assertNotNull(Object obj) throws BaseException;

    /**
     * @description:
     * 断言对象为 not null，如果对象为 null，则抛出异常
     * 异常信息支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param obj 待判断对象
     * @param args message占位符对应的参数列表
     * @return
     * @throws
     * @author yang xiong
     * @date 2022/8/24 上午11:56
     */
    void assertNotNull(Object obj, Object... args) throws BaseException;

    /**
     * @description: 断言对象为 null，如果对象为 not null，则抛出异常
     * @param obj 待判断对象
     * @return
     * @throws
     * @author yang xiong
     * @date 2022/8/24 上午11:55
     */
    void assertNull(Object obj) throws BaseException;

    /**
     * @description:
     * 断言对象为 null，如果对象为 not null，则抛出异常
     * 异常信息支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param obj 待判断对象
     * @param args message占位符对应的参数列表
     * @return
     * @throws
     * @author yang xiong
     * @date 2022/8/24 上午11:56
     */
    void assertNull(Object obj, Object... args) throws BaseException;

    /**
     * @description: 断言对象为 false，如果对象为空或 true，则抛出异常
     * @param obj 待判断对象
     * @return
     * @throws
     * @author yang xiong
     * @date 2022/8/24 上午11:56
     */
    void assertFalse(Boolean obj) throws BaseException;

    /**
     * @description:
     * 断言对象为 false，如果对象为空或 true，则抛出异常
     * 异常信息支持传递参数方式，避免在判断之前进行字符串拼接操作
     * @param obj 待判断对象
     * @param args message占位符对应的参数列表
     * @return
     * @throws
     * @author yang xiong
     * @date 2022/8/24 上午11:59
     */
    void assertFalse(Boolean obj, Object... args) throws BaseException;

    /**
     * @description: 断言对象为 true，如果对象为空或 false，则抛出异常
     * @param obj 待判断对象
     * @return
     * @throws
     * @author yang xiong
     * @date 2022/8/24 上午11:56
     */
    void assertTrue(Boolean obj) throws BaseException;

    /**
     * @description:
     * 断言对象为 true，如果对象为空或 false，则抛出异常
     * 异常信息支持传递参数方式，避免在判断之前进行字符串拼接操作
     * @param obj 待判断对象
     * @param args message占位符对应的参数列表
     * @return
     * @throws
     * @author yang xiong
     * @date 2022/8/24 上午11:59
     */
    void assertTrue(Boolean obj, Object... args) throws BaseException;

    /**
     * @description: 断言 Collection 对象为 not null 且 not empty ，如果对象为 null 或 empty，则抛出异常
     * @param collection 待判断 Collection 对象
     * @return
     * @throws
     * @author yang xiong
     * @date 2022/8/24 上午11:56
     */
    void assertNotEmpty(Collection<?> collection) throws BaseException;

    /**
     * @description:
     * 断言 Collection 对象为 not null 且 not empty ，如果对象为 null 或 empty，则抛出异常
     * 异常信息支持传递参数方式，避免在判断之前进行字符串拼接操作
     * @param collection 待判断 Collection 对象
     * @param args message占位符对应的参数列表
     * @return
     * @throws
     * @author yang xiong
     * @date 2022/8/24 上午11:59
     */
    void assertNotEmpty(Collection<?> collection, Object... args) throws BaseException;

    /**
     * @description: 断言 Collection 对象为 null 或 empty，如果对象为 not null 且 not empty，则抛出异常
     * @param collection 待判断 Collection 对象
     * @return
     * @throws
     * @author yang xiong
     * @date 2022/8/24 上午11:56
     */
    void assertEmpty(Collection<?> collection) throws BaseException;

    /**
     * @description:
     * 断言 Collection 对象为 null 或 empty，如果对象为 not null 且 not empty，则抛出异常
     * 异常信息支持传递参数方式，避免在判断之前进行字符串拼接操作
     * @param collection 待判断 Collection 对象
     * @param args message占位符对应的参数列表
     * @return
     * @throws
     * @author yang xiong
     * @date 2022/8/24 上午11:59
     */
    void assertEmpty(Collection<?> collection, Object... args) throws BaseException;
}
