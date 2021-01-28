package com.qfedu.many2many;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Demo {
    public static SqlSessionFactory factory = null;
    static {
        Reader resourceAsReader = null;
        try {
            resourceAsReader =  Resources.getResourceAsReader("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory = new SqlSessionFactoryBuilder().build(resourceAsReader);
    }
     public static void findBySid() {
         SqlSession session = factory.openSession();
         CourseDao mapper = session.getMapper(CourseDao.class);
         Student bySid = mapper.findBySid(1);
         System.out.println(bySid);
         session.commit();
         session.close();
     }
     public static void findByCid(){
         SqlSession session = factory.openSession();
         StudentDao mapper = session.getMapper(StudentDao.class);
         Course byCid = mapper.findByCid(2);
         System.out.println(byCid);
         session.commit();
         session.close();
     }
    public static void main(String[] args) {

        findByCid();
    }
}
