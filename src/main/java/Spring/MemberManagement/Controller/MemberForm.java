package Spring.MemberManagement.Controller;

public class MemberForm {
    private String NAME;

    public MemberForm(String NAME) {
        this.NAME = NAME;
    }

    public String getNAME() {
        return NAME;
    }
}