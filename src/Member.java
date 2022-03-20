public class Member implements Comparable<Member> { // TreeSet로 구현될 것이기 때문에 비교할 수 있는 Comparable 인터페이스를 implements 한다. 비교 대상은 Member 타입이기 때문에 <T>는 Member를 심어 준다.
    // 멤버 변수
    private int memberId; // 회원 아이디
    private String memberName; // 회원 이름

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
    public int compareTo(Member member) { // Comparable 인터페이스의 compareTo() 메서드를 재정의한다.
        /**
         * compareTo() 메서드는 TreeSet으로 선언된 변수에 속해 있는 값을 내부적으로 비교한다.
         * compareTo() 메서드의 반환값은 int다.
         * 넘어온 매개 변숫값과 this의 값을 비교하여 this의 값이 더 높으면 양수를 서로 같은 값이면 0을 this의 값이 더 낮으면 음수를 설정하도록 한다.
         * 위와 같이 설정을 하면 오름차순이 될 것이고 반대로 this의 값이 더 높으면 음수를 서로 같은 값이면 0을 this의 값이 더 낮으면 양수를 설정하면 내림차순으로 설정된다.
         */
        if (this.memberId > member.memberId) {
            return 1;
        } else if (this.memberId < member.memberId) {
            return -1;
        } else {
            return 0;
        }
        // 반환값을 위와 같이 설정해도 가능하고 아래와 같이 설정해도 가능하다. 중요한 건 양수이냐 0이냐 음수이냐를 반환하면 된다.
        // return this.memberId - member.memberId; (오름차순)
        // return (this.memberId - member.memberId) * (-1); (내림차순)
    }
}
