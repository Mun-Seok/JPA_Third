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


//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            em.persist(member);
//
//            em.flush();
//            em.clear();

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
//            List<MemberDTO> result = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class) // 생성자 통해 호출됨
//                    .getResultList();
//
//            MemberDTO memberDTO = result.get(0);
//            System.out.println("memberDTO = " + memberDTO.getUsername());
//            System.out.println("memberDTO = " + memberDTO.getAge());

            // 페이징
//            for(int i =0; i< 100; i++) {
//                Member member = new Member();
//                member.setUsername("member"+i);
//                member.setAge(i);
//                em.persist(member);
//            }
//
//            em.flush();
//            em.clear();
//
//            List<Member> result = em.createQuery("select m from Member m order by m.age desc", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();
//
//            System.out.println("result.size = " + result.size());
//            for (Member member1 : result) {
//                System.out.println("member1 = " + member1);
//            }

//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();

            // 조인
            // 1. 내부 조인
//            String query = "select m from Member m inner join m.team t"; // inner 생략 가능
//            List<Member> result = em.createQuery(query, Member.class)
//                            .setFirstResult(1)
//                            .setMaxResults(10)
//                            .getResultList();

            // 2. 외부 조인
//            String query = "select m from Member m left outer join m.team t"; // outer 생략 가능
//            List<Member> result = em.createQuery(query, Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();

//            // 3. 세타 조인
//            String query = "select m from Member m, Team t where m.username = t.name";
//            List<Member> result = em.createQuery(query, Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();

            // 조인 - ON절
            // 1. 조인 대상 필터링
//            String query = "select m from Member m inner join m.team t on t.name = 'A'"; // 회원과 팀 조인하면서 팀 이름이 A인 팀만 조인
//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();

            // 2. 연관관계 없는 엔티티 외부 조인
//            String query = "select m from Member m left join Team t on m.username = t.name";
//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();
//
//            System.out.println("result = " + result.size());


            // 서브 쿼리
            // 하이버네이트에서 지원해 SELECT 절도 서브 쿼리 가능
//            String query = "select (select avg(m1.age) from Member m1)  join Team t on m.username = t.name";
//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();

            // FROM절에 서브 쿼리는 불가능
//            String query = "select mm from (select m.age from Member m) as mm"; // 불가능 -> 조인으로 풀 수 있으면 풀어서 해결
//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();

//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("관리자");
//            member.setAge(10);
//            member.setType(MemberType.ADMIN);
//
//            member.setTeam(team);
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();

            // JPQL 타입 표현
//            String query = "select m.username, 'HELLO', TRUE From Member m" +
//                            "where m.type = :userType";
//            List<Object[]> result = em.createQuery(query)
//                    .setParameter("userType", MemberType.ADMIN)
//                    .getResultList();
//
//            for (Object[] objects : result) {
//                System.out.println("objects = " + objects[0]);
//                System.out.println("objects = " + objects[1]);
//                System.out.println("objects = " + objects[2]);
//            }

            // 조건식 - CASE식
            // 기본 CASE식
//            String query =
//                    "select " +
//                            "case when m.age <= 10 then '학생요금'" +
//                            "     when m.age >= 60 then '경로요금'" +
//                            "     else '일반요금' " +
//                            "end " +
//                    "from Member m";
//            List<String> result = em.createQuery(query, String.class)
//                    .getResultList();

            // COALESCE
//            String query =
//                    "select coalesce(m.username, '이름 없는 회원') from Member m";
//            List<String> result = em.createQuery(query, String.class)
//                    .getResultList();
//
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }

            // NULLIF
//            String query =
//                    "select nullif(m.username, '관리자') from Member m";
//            List<String> result = em.createQuery(query, String.class)
//                    .getResultList();
//
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }

            // JPQL 함수
//            String query = "select concat('a', 'b') From Member m";  // concat
//            String query = "select substring(m.username, 2, 3) From Member m";  // substring
//            List<String> result = em.createQuery(query, String.class)
//                    .getResultList();
//
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }

            // fetch 조인
            Team teamA = new Team();
            teamA.setName("팀A");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("팀B");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setTeam(teamB);
            em.persist(member3);

            em.flush();
            em.clear();

//            String query = "select m From Member m"; // fetch join X
//            String query = "select m From Member m join fetch m.team"; // 엔티티 fetch join

//            String query = "select distinct t From Team t join fetch t.members"; // 컬렉션 fetch join

//            String query = "select t From Team t";


//            String query = "select m from Member m where m = :member"; // 엔티티 직접 사용 - 기본 키 값

//            String query = "select m from Member m where m.team = :team"; // 엔티티 직접 사용 - 외래 키 값


//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();

//            List<Team> result = em.createQuery(query, Team.class)
//                    .getResultList();
//
//            List<Team> result = em.createQuery(query, Team.class) // 컬렉션 페치 조인 불가능 -> Team에 BatchSize 설정
//                    .setFirstResult(0)
//                    .setMaxResults(2)
//                    .getResultList();

//            Member findMember = em.createQuery(query, Member.class)
//                    .setParameter("member", member1)
//                    .getSingleResult();

//            List<Member> members = em.createQuery(query, Member.class)
//                    .setParameter("team", teamA)
//                    .getResultList();

//            for (Member member : result) {
//                System.out.println("member = " + member.getUsername() + ", " + member.getTeam().getName()); // 지연로딩으로 proxy였지만 fetch join으로 지연 로딩 X
//                // 회원1, 팀A(SQL)
//                // 회원2, 팀A(1차캐시)
//                // 회원3, 팀B(SQL)
//
//                // -> 쿼리가 3번 if 회원 100명? -> N + 1
//                // fetch join 사용해 쿼리 한번
//            }

//            for (Team team : result) {
//                System.out.println("team = " + team.getName() + "| members = " + team.getMembers().size());
//                for (Member member : team.getMembers()) {
//                    System.out.println("-> member = " + member);
//                }
//            }

//            System.out.println("findMember = " + findMember);

//            for (Member member : members) {
//                System.out.println("member = " + member);
//            }

//            List<Member> resultList = em.createNamedQuery("Member.findByUsername", Member.class)
//                    .setParameter("username", " 회원1")
//                    .getResultList();

//            for (Member member : resultList) {
//                System.out.println("member = " + member);
//            }


            // FLUSH
            int resultCount = em.createQuery("update Member m set m.age = 20")
                    .executeUpdate(); // 벌크 연산

            Member findMember = em.find(Member.class, member2.getId());

            System.out.println("findMember = " + findMember.getAge());

            tx.commit();

        }catch(Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
