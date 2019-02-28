package com.huang.pims.demo.design.modes;

import java.util.Objects;

public class SingletonPattern {

    public static void main(String[] args) {
        // 定义单例对象
        ObjectInstance objectInstance = null;
        /**
         * 方式一：恶汉模式
         */
        objectInstance = SimpleSingleton.getInstance();
        /**
         * 方式二：懒汉模式
         * 缺点：线程不安全
          */
        objectInstance = LazySingleton.getInstance();
        /**
         * 方式三：线程安全的“懒汉模式”
         * 改进点：解决懒汉模式线程不安全的问题
         * 缺点：多线程环境下性能相对较差
         */
        objectInstance = SafeSingleton01.getInstance();
        /**
         * 方式四：基于“双重校验”的“懒汉模式”
         * 改进点：多线程环境下提升性能
         * 缺点：指令重排序
         */
        objectInstance = SafeSingleton02.getInstance();
        /**
         * 解决方式4指令重排序导致的问题方式一
         * 使用volatile关键字禁止指令重排序
         * 缺点：通过java反射能构造出新的实例对象
         */
        objectInstance = SafeSingleton03.getInstance();
        /**
         * 解决方式4指令重排序导致的问题方式二
         * 基于类初始化的单例模式
         * 缺点：通过java反射能构造出新的实例对象
         */
        objectInstance = SafeSingleton04.getInstance();
        /**
         * 基于枚举的单例模式
         * 优点：枚举类无法通过Java反射类创建对象
         */
        objectInstance = EnumSingleton.OBJECTINSTANCE.getInstance();

    }


}

class ObjectInstance {

}

class SimpleSingleton {

    private SimpleSingleton() {}

    private static ObjectInstance objectInstance = new ObjectInstance();

    public static ObjectInstance getInstance() {
        return objectInstance;
    }

}

class LazySingleton {

    private LazySingleton() {}

    private static ObjectInstance objectInstance = null;

    public static ObjectInstance getInstance() {
        if (Objects.isNull(objectInstance)) {
            objectInstance = new ObjectInstance();
        }
        return objectInstance;
    }

}

class SafeSingleton01 {

    private SafeSingleton01() {}

    private static ObjectInstance objectInstance = null;

    public synchronized static ObjectInstance getInstance() {
        if (Objects.isNull(objectInstance)) {
            objectInstance = new ObjectInstance();
        }
        return objectInstance;
    }

}

class SafeSingleton02 {

    private SafeSingleton02() {}

    private static ObjectInstance objectInstance = null;

    public static ObjectInstance getInstance() {
        if (Objects.isNull(objectInstance)) {
            synchronized (SafeSingleton02.class) {
                if (Objects.isNull(objectInstance)) {
                    objectInstance = new ObjectInstance();
                }
            }
        }
        return objectInstance;
    }

}

class SafeSingleton03 {

    private SafeSingleton03() {}

    private static volatile ObjectInstance objectInstance = null;

    public static ObjectInstance getInstance() {
        if (Objects.isNull(objectInstance)) {
            synchronized (SafeSingleton02.class) {
                if (Objects.isNull(objectInstance)) {
                    objectInstance = new ObjectInstance();
                }
            }
        }
        return objectInstance;
    }

}

class SafeSingleton04 {

    private SafeSingleton04() {}

    private static ObjectInstance objectInstance = null;

    public static ObjectInstance getInstance() {
        return InitStanceClass.objectInstance;
    }

    private static class InitStanceClass {
        private static ObjectInstance objectInstance = new ObjectInstance();
    }

}

enum EnumSingleton {

    OBJECTINSTANCE;

    private ObjectInstance objectInstance;

    private EnumSingleton () {
        objectInstance = new ObjectInstance();
    }

    public ObjectInstance getInstance() {
        return objectInstance;
    }

}


