package Spring.MemberManagement.Service;

import Spring.MemberManagement.Domain.Member;
import Spring.MemberManagement.Repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {
    MemoryMemberRepository R;
    MemberService S;

    @BeforeEach
    public void beforeEach() {
        R = new MemoryMemberRepository();
        S = new MemberService(R);
    }

    @Test
    void Register() {
        Member M = new Member();
        M.setNAME("Hello");
        Long I = S.join(M);
        Member Result = S.findOne(I).get();
        assertThat(M.getNAME()).isEqualTo(Result.getNAME());
    }

    @Test
    public void Exception() {
        Member M1 = new Member();
        M1.setNAME("M1");
        R.save(M1);
        Member M2 = new Member();
        M2.setNAME("M2");
        R.save(M2);

        S.join(M1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> S.join(M2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}