package Spring.MemberManagement.Repository;
import Spring.MemberManagement.Domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member M);
    Optional<Member> findByID(Long ID);
    Optional<Member> findByNAME(String NAME);
    List<Member> findAll();
}