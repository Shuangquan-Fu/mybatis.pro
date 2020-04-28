package com.damu.dao;

import com.damu.entity.Users;
import com.damu.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UsersDAO {
    private SqlSession sqlSession;
    public List<Users> list;
    public Users Users;

    private SqlSession getSqlSession() {
        sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        return sqlSession;
    }
    //findAll users form dataset
    public List<Users> findAll(){
        try {
            list = getSqlSession().selectList("findUsers");
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
            Users = getSqlSession().selectOne("findUsers",new Users(id));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return Users;
    }
    public Users addUser(Users user){
        try {
            // 返回值 是insert 执行过程中影响的行数
            getSqlSession().insert("addUser",user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return Users;
    }
}
