package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// 기존의 JDBCTemplate 클래스의 역할을 해 줄 MyBatis 용 클래스
// 다만, 직접 모든 코드를 다 구현하는 것이 아니라 MyBatis 방식으로 알아서 영속성 작업을 할 수 있게끔 작성
// -> SqlSession 객체를 생성하고, Connection 객체를 생성하고, 트랜잭션 처리를 하고, 자원 반납 등을 알아서 처리
public class Template {

    /*
    *   기존 JDBC
    *   public static Connection getConnection() {
    *      ... // driver. properties 파일을 읽어들여
    *       //해당 DB와 접속된 Connection 객체를 만들어서 반환
    *  }
    * 
    * public static void close(Connection conn) {
    *  ... // conn.close(); // 자원 반납 구문
    * }
    * 
    * public static void commit(Connection conn) { 
    * ... // conn.commit(); //트랜잭션 처리 구문
    * }
    *
    *  public static void rollback(Connection conn) {
    * 
    * ... // conn.rollback(); //트랜잭션 처리 구문
    * }
    */

    // MyBatis
    // SqlSession 객체를 생성하고, Connection 객체를 생성하고, 트랜잭션 처리를 하고, 자원 반납 등을 알아서 처리
    // 기존의 Connection 객체의 역할을 SqlSession 객체가 대신하게 됨
    public static SqlSession getSqlSession() {

        // mybatis-config.xml 파일을 읽어들여서
        // 해당 DB 와 접속된 SqlSession 객체를 생성해서 반환
        SqlSession sqlSession = null;

        // SqlSession 객체 얻어내는 순서
        // 1. mybatis-config.xml 파일 작성
        String resource = "/mybatis-config.xml"; // '/' 는 최상위 폴더를 의미한다
        
        try {
			InputStream stream = Resources.getResourceAsStream(resource);
            // InputStream 객체를 통해 mybatis-config.xml 파일을 읽어들이는 작업

			
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            // 2. mybatis-config.xml 파일을 읽어들이면서 SqlSessionFactoryBuilder 객체를 생성
            
			SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(stream);
            // 3. SqlSessionFactoryBuilder 객체를 통해 SqlSessionFactory 객체를 생성
			
			sqlSession = sqlSessionFactory.openSession(false);
            // 4. SqlSessionFactory 객체를 통해 SqlSession 객체를 생성  
            // openSession : 기본값은 false, true로 설정하면 자동 커밋을 수행한다.
            // => false : 수동 커밋을 수행한다.
            // => true : 자동 커밋을 수행한다. (마이바티스가 대신 commit()을 호출한다.)

            // 5. SqlSession 객체를 통해 DB와 접속을 하고, 해당 DB와 접속된 Connection 객체를 생성해서 반환          
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        //만들어진 sqlSession 반환
        return sqlSession; // 기존의 Connection, Statement, ResultSet 객체를 반환 역할 다 해줌
    }
}
