package com.damu.dao;

import com.damu.entity.Users;
import com.damu.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UsersDAO {
    private SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
    public List<Users> list;
    public Users Users;

    private SqlSession getSqlSession() {
        sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        return sqlSession;
    }
    //findAll users form dataset
    public List<Users> findAll(){
        try {
            list = getSqlSession().selectList("usersList");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return list;
    }
    //find single user from database
    public Users findById(Integer id){
        try {
            Users = getSqlSession().selectOne("findById",id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return Users;
    }
}
