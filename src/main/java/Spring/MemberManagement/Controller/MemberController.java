package Spring.MemberManagement.Controller;

import Spring.MemberManagement.Domain.Member;
import Spring.MemberManagement.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class MemberController {
    private final MemberService S;

    @Autowired
    public MemberController(MemberService S){
        this.S = S;
    }

    @GetMapping(value = "/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm F) {
        Member M = new Member();
        M.setNAME(F.getNAME());

        S.join(M);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model MD){
        List<Member> members = S.findMembers();
        MD.addAttribute("members", members);
        return "members/memberList";
    }
}