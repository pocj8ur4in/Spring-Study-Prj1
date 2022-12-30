package Spring.MemberManagement.Repository;
import Spring.MemberManagement.Domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {
    private Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member M) {
        M.setID(++sequence);
        store.put(M.getID(), M);
        return M;
    }

    @Override
    public Optional<Member> findByID(Long ID) {
        return Optional.ofNullable(store.get(ID));
    }

    @Override
    public Optional<Member> findByNAME(String NAME) {
        return store.values().stream().filter(M -> M.getNAME().equals(NAME)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}