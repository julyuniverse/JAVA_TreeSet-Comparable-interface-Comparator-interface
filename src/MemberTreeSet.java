import java.util.Iterator;
import java.util.TreeSet;

public class MemberTreeSet {
    private TreeSet<Member> treeSet; // TreeSet 클래스는 제네릭 클래스라는 걸 알 수 있다.

    // 생성자
    public MemberTreeSet() {
        /**
         * Comparator 인터페이스를 사용할 경우 TreeSet<>()의 인자는 comparable이 구현이 된 인스턴스를 지정해 주어야 한다.
         */

        treeSet = new TreeSet<>(new Member());
    }

    // 회원 추가
    public void addMember(Member member) {
        treeSet.add(member);
    }

    // 회원 삭제
    public boolean removeMember(int memberId) {
        Iterator<Member> ir = treeSet.iterator();
        while(ir.hasNext()){
            Member member = ir.next();
            if(member.getMemberId() == memberId) {
                treeSet.remove(member);
                return true;
            }
        }

        // for 문에서 순회를 다 하고 나서도 memberId와 매핑되는 id가 없다면 제어가 여기로 오게 된다. 제어 처리를 해준다.
        System.out.println(memberId + "가 존재하지 않습니다.");
        return false;
    }

    // 모든 회원 출력
    public void showAllMember() {
        // 향상된 for 문
        for (Member member : treeSet) {
            System.out.println(member);
        }

        System.out.println();
    }
}
