import java.util.Comparator;

public class Member implements Comparator<Member> { // TreeSet로 구현될 것이기 때문에 비교할 수 있는 Comparator 인터페이스를 implements 한다. 비교 대상은 Member 타입이기 때문에 <T>는 Member를 심어 준다.
    // 멤버 변수
    private int memberId; // 회원 아이디
    private String memberName; // 회원 이름

    /**
     * Comparator 인터페이스를 사용할 땐 기본 생성자가 필요하다.
     * MemberTreeSet 클래스에서 생성자를 만들 때 생성자 안에 TreeSet<>()의 인자로 Member가 필요하기 때문이다.
     */

    // 기본 생성자
    public Member() {}

    // 생성자
    public Member(int memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public boolean equals(Object obj) { // memberId가 논리적으로 같다면 물리적으로 다르더라도 같다고 설정
        if (obj instanceof Member) { // 인자로 받은 obj가 Member 타입이 맞는지 확인
            Member member = (Member) obj; // Member로 다운 캐스팅
            if (this.memberId == member.memberId) {
                return true;
            } else {
                return false;
            }
        }

        // 인자로 받은 obj가 Member 타입이 아니라면 false 반환.
        return false;
    }

    @Override
    public int hashCode() {
        // hashCode() 메서드는 요소의 주솟값을 반환하나 현재 주솟값의 기준은 memberId므로 memberId로 반환하도록 hashCode() 메서드를 오버라이딩한다.
        // return Objects.hash(memberId, memberName);
        return memberId;
    }

    @Override
    public String toString() { // toString 메서드 오버라이딩
        return memberName + " 회원님의 아이디는 " + memberId + "입니다.";
    }

    @Override
    public int compare(Member member1, Member member2) { // Comparator 인터페이스의 compare() 메서드를 재정의한다.
        /**
         * compare() 메서드도 Comparable 인터페이스의 compareTo() 메서드와 동일한 흐름으로 작동한다.
         * TreeSet을 구현할 때 Comparable 인터페이스나 Comparator 인터페이스 둘 중에 하나를 활용하면 된다.
         */
        return member1.memberId - member2.memberId; // (오름차순)
        // return (this.memberId - member.memberId) * (-1); (내림차순)
    }
}
