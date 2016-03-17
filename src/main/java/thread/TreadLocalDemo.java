package thread;

import java.util.Random;

public class TreadLocalDemo implements Runnable {
    private final static  ThreadLocal studentLocal = new ThreadLocal();

    public static void main(String[] agrs) {
        TreadLocalDemo td = new TreadLocalDemo();
        Thread t1 = new Thread(td,"a");
        Thread t2 = new Thread(td,"b");
        t1.start();
        t2.start();
        System.out.println(0x7fffffff);
    }

    public void run() {
        accessStudent();
    }


    public  void  accessStudent() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName+" is running!");
        Random random = new Random();
        int age = random.nextInt(100);
        System.out.println("thread "+currentThreadName +" set age to:"+age);
        Student student = getStudent();
        student.setAge(age);
        System.out.println("thread "+currentThreadName+" first  read age is:"+student.getAge());
        try {
            Thread.sleep(5000);
        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("thread "+currentThreadName +" second read age is:"+student.getAge());
    }

    protected Student getStudent() {
        Student student = (Student)studentLocal.get();
        if(student == null) {
            student = new Student();
            studentLocal.set(student);
        }
        return student;
    }

    protected void setStudent(Student student) {
        studentLocal.set(student);
    }
}
