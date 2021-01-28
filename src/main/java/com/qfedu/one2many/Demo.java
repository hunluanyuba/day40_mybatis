package com.qfedu.one2many;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Demo {
    public static SqlSessionFactory factory = null;
    static {
        Reader departmentMapper = null;
        try {
            departmentMapper = Resources.getResourceAsReader("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory = new SqlSessionFactoryBuilder().build(departmentMapper);
    }
    public static void findByEid(){
        SqlSession session = factory.openSession();
        DepartmentDao mapper = session.getMapper(DepartmentDao.class);
        Department byDid = mapper.findByDid(1);
        System.out.println(byDid);
        session.commit();
        session.close();
    }
    public static void findByEid_new(){
        SqlSession session = factory.openSession();
        DepartmentDao mapper = session.getMapper(DepartmentDao.class);
        Department byDid = mapper.findByDid_new(1);
        System.out.println(byDid);
        session.commit();
        session.close();
    }
    public static void findByDid(){
        SqlSession session = factory.openSession();
        DepartmentDao mapper = session.getMapper(DepartmentDao.class);
        Department byDeptId = mapper.findByDeptId(1);
        System.out.println(byDeptId);
        session.commit();
        session.close();
    }
    public static void findByDeptId(){
        SqlSession session = factory.openSession();
        DepartmentDao mapper = session.getMapper(DepartmentDao.class);
        Department byDeptId = mapper.findByDeptId(1);
        System.out.println(byDeptId);
        session.commit();
        session.close();
    }


    public static void main(String[] args) {
        findByDeptId();
    }
}
