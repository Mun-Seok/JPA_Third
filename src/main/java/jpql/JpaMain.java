package jpql;

import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            em.persist(member);

//            TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class); // 타입 정보 명확
//            TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class); // 타입 정보 명확
//            Query query3 = em.createQuery("select m.username, m.age from Member m"); // 타입 정보 명확하지 X

//            TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
//
//            List<Member> resultList = query.getResultList(); // 값이 여러개일 때
//            for (Member member1 : resultList) {
//                System.out.println("member1 = " + member1);
//            }
//
//            Member result = query.getSingleResult(); // 값이 하나일 때
//            System.out.println("result = " + result);

//            TypedQuery<Member> query = em.createQuery("select m from Member m.id = 10", Member.class);

//            try{
//                Member result = query.getSingleResult(); // Exception 발생
//            } catch(NoResultException e){
//                return null;
//                return Optional.ofNullable();
//            }
            // Spring Data JPA -> 결과 없으면 null 또는 Optional
//            System.out.println("result = " + result);

//            Member result = em.createQuery("select m from Member m.username = :username", Member.class)
//                .setParameter("username", "member1") // 파라미터 바인딩
//                .getSingleResult();
//
//            System.out.println("result = " + result.getUsername());


            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

            em.flush();
            em.clear();

//            List<Member> result = em.createQuery("select m from Member m", Member.class) // 엔티티 프로젝션 -> 엔티티의 데이터 모두 영속성 컨텍스트에 관리됨
//                    .getResultList();
//            Member findMember = result.get(0);
//            findMember.setAge(20);

//            List<Team> result = em.createQuery("select t from Member m join m.team t", Team.class) // 엔티티 프로젝션
//                    .getResultList(); // 조인하는 쿼리 나감 -> 예측하기 위해서는 SQL이랑 비슷해야함

//              em.createQuery("select o.address from Order o", Address.class) // 임베디드 타입 프로젝션
//                    .getResultList();


//                em.createQuery("select distinct m.username, m.age from Member m") // 스칼라 타입 프로젝션
//                    .getResultList();

            // 프로 젝션 - 여러 값 조회
            // 1. Query 타입으로 조회
//            List resultList = em.createQuery("select distinct m.username, m.age from Member m")
//                    .getResultList();
//
//            Object o = resultList.get(0);
//            Object[] result = (Object[]) o;
//            System.out.println("username = " + result[0]);
//            System.out.println("age = " + result[1]);

            // 2. Object[] 타입으로 조회
//            List<Object[]> resultList = em.createQuery("select distinct m.username, m.age from Member m")
//                    .getResultList();
//
//            Object[] result = resultList.get(0);
//            System.out.println("username = " + result[0]);
//            System.out.println("age = " + result[1]);

            // 3. new 명령어로 조회
            List<MemberDTO> result = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class) // 생성자 통해 호출됨
                    .getResultList();

            MemberDTO memberDTO = result.get(0);
            System.out.println("memberDTO = " + memberDTO.getUsername());
            System.out.println("memberDTO = " + memberDTO.getAge());

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
