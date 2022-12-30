package Spring.MemberManagement.Service;
import Spring.MemberManagement.Domain.Member;
import Spring.MemberManagement.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join (Member M) {
        validateName(M);
        memberRepository.save(M);

        return M.getID();
    }

    private void validateName(Member M) {
        memberRepository.findByNAME(M.getNAME()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberID) {
        return memberRepository.findByID(memberID);
    }
}

