public class ObjectCode {
    //Date class use
    void dateUse() {
        java.util.Date date = new java.util.Date();
        System.out.println("The elapsed time since Jan 1, 1970 is " + date.getTime() + " milliseconds");

        System.out.println(date.toString());

    }

    void useRandom() {
        java.util.Random random = new java.util.Random(3);
        for (int i = 0; i < 50; i++) {
            System.out.print(random.nextInt(100) + " ");
        }
        /*
        +Random()
        +Random(seed: long)
        +nextInt(): int
        +nextInt(n: int): int
        +nextLong(): long
        +nextDouble(): double
        +nextFloat(): float
        +nextBoolean(): boolean
        Constructs a Random object with the current time as its seed.
        Constructs a Random object with a specified seed.
        Returns a random int value.
        Returns a random int value between 0 and n (exclusive).
        Returns a random long value.
        Returns a random double value between 0.0 and 1.0 (exclusive).
        Returns a random float value between 0.0F and 1.0F (exclusive).
        Returns a random boolean value
        */
    }

    public void useString() {
        String s1 = "Welcome to Java";
        String s2 = new String("Welcome to Java");
        String s3 = "Welcome to Java";
        System.out.println("s1 == s2 is " + (s1 == s2));
        System.out.println("s1 == s3 is " + (s1 == s3));
        // s1 == s3 is true
        // s1 == s2 is false

        //字符串比较
        //字符串是对象，==比较的是对象的引用，equals比较的是对象的内容
        if (s1.equals(s2)) {
            System.out.println("s1 equals s2");
        }

        //还有其他比较方法 看一下ppt吧
        //检索字符串中的单个字符
        System.out.println(s1.charAt(0));

        //提取子串
        System.out.println(s1.substring(0, 11));

        //查找字符串中的字符或子字符串
        System.out.println(s1.indexOf("to"));   //返回to的位置
        System.out.println(s1.indexOf("to", 3));//从第三个字符开始查找
        System.out.println(s1.lastIndexOf('a'));    //返回最后一个a的位置
        System.out.println(s1.lastIndexOf("a", 5)); //返回前五个字符中最后一个a的位置

        //还有转换等替他操作 直接调用就行了
        s1.toLowerCase();//类似这样直接调用

        //分割字符串
        String[] tokens = "Java#HTML#Perl".split("#");
        for(int i = 0; i < tokens.length; i++)
            System.out.println(tokens[i]);

        //按模式匹配、替换和拆分 正则表达式看ppt Lecture2.1 P41
        //匹配
        System.out.println("Welcome to Java".matches("Welcome.*"));
        //替换
        System.out.println("Welcome to Java".replace('o', 'T'));
        //拆分
        String[] tokens1 = "Java#HTML#Perl".split("#");


        //StringBuilder and StringBuffer
        //StringBuilder是线程不安全的，效率高，StringBuffer是线程安全的，效率低
        StringBuilder builder = new StringBuilder("Welcome");
        builder.append(" to Java");
        builder.insert(11, "HTML and ");
        builder.delete(8, 11);
        builder.reverse();
        System.out.println(builder.toString());

        //字符类
        //Character类的方法
        System.out.println(Character.isLetter('a'));
        System.out.println(Character.isDigit('9'));
        System.out.println(Character.isLetterOrDigit('a'));
        System.out.println(Character.isLowerCase('a'));
        System.out.println(Character.isUpperCase('A'));
        System.out.println(Character.toUpperCase('a'));
        System.out.println(Character.toLowerCase('A'));
        System.out.println(Character.toString('a'));
        //比较
        System.out.println(Character.compare('a', 'c'));
        Character charObject = new Character('b');
        charObject.equals(new Character('b'));

        charObject.equals(new Character('d'));

        charObject.compareTo(new Character('a'));

        charObject.compareTo(new Character('b'));

        charObject.compareTo(new Character('c'));

        charObject.compareTo(new Character('d'); //Charater已经被弃用了 所以会报错


    }

    public static void main(String[] args) {
        Circle myCircle = new Circle(5.0);
        Circle yourCircle = new Circle();
        yourCircle.setRadius(100.0);

    }
}
