package Spring.MemberManagement.Domain;

public class Member {
    private Long ID;
    private String NAME;

    public Long getID() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setID (Long ID){ this.ID = ID; }

    public void setNAME (String NAME){ this.NAME = NAME; }
}