public class MemberTreeSetTest {
    public static void main(String[] args) {
        MemberTreeSet memberTreeSet = new MemberTreeSet();

        Member memberLee = new Member(1001, "이태성");
        Member memberPark = new Member(1002, "박주희");
        Member memberJung = new Member(1003, "정기윤");
        Member memberYoon = new Member(1004, "윤호근");

        // 회원을 추가할 때 순서를 무작위로 추가한다.
        memberTreeSet.addMember(memberJung);
        memberTreeSet.addMember(memberYoon);
        memberTreeSet.addMember(memberLee);
        memberTreeSet.addMember(memberPark);

        // TreeSet로 구현되었고 Member 클래스에서 정렬시켰기 때문에 출력을 할 때 정렬이 되어서 출력된다.
        memberTreeSet.showAllMember();
    }
}
