package Spring.MemberManagement.Repository;

import Spring.MemberManagement.Domain.Member;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository R = new MemoryMemberRepository();

    @Test
    public void save(){
        Member M = new Member();
        M.setNAME("Spring");

        R.save(M);

        Member Result = R.findByID(M.getID()).get();

        assertThat(M).isEqualTo(Result);
    }

    @Test
    public void findByName() {
        Member M1 = new Member();
        M1.setNAME("M1");
        R.save(M1);
        Member M2 = new Member();
        M2.setNAME("M2");
        R.save(M2);
        Member Result = R.findByNAME("M1").get();
        assertThat(Result).isEqualTo(M1);
    }

    @Test
    public void findAll() {
        Member M1 = new Member();
        M1.setNAME("M1");
        R.save(M1);
        Member M2 = new Member();
        M2.setNAME("M2");
        R.save(M2);

        List<Member> Result = R.findAll();

        assertThat(Result.size()).isEqualTo(2);
    }
}