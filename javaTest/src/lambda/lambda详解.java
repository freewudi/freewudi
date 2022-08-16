package lambda;

public class lambda详解 {

    /**
     * @author: Mercury
     * Date: 2022/4/27
     * Time: 10:31
     * Description:lambda构造方法的引用
     * Version:1.0
     */
    private static class Dog {
        String name;
        int age;

        //无参构造
        public Dog() {
            System.out.println("一个Dog对象通过无参构造被实例化了");
        }

        //有参构造
        public Dog(String name, int age) {
            System.out.println("一个Dog对象通过有参构造被实例化了");
            this.name = name;
            this.age = age;
        }
    }

    //定义一个函数式接口,用以获取无参的对象
    @FunctionalInterface
    private interface GetDog {
        //若此方法仅仅是为了获得一个Dog对象，而且通过无参构造去获取一个Dog对象作为返回值
        Dog test();
    }

    //定义一个函数式接口,用以获取有参的对象
    @FunctionalInterface
    private interface GetDogWithParameter {
        //若此方法仅仅是为了获得一个Dog对象，而且通过有参构造去获取一个Dog对象作为返回值
        Dog test(String name, int age);
    }

    // 测试
    public static void main(String[] args) {
        //lambda表达式实现接口
        GetDog lm = Dog::new; //引用到Dog类中的无参构造方法，获取到一个Dog对象
        Dog dog = lm.test();
        System.out.println("修狗的名字：" + dog.name + " 修狗的年龄：" + dog.age); //修狗的名字：null 修狗的年龄：0
        GetDogWithParameter lm2 = Dog::new;//引用到Dog类中的有参构造，来获取一个Dog对象
        Dog dog1 = lm2.test("萨摩耶", 2);
        System.out.println("修狗的名字：" + dog1.name + " 修狗的年龄：" + dog1.age);//修狗的名字：萨摩耶 修狗的年龄：2

    }
}
