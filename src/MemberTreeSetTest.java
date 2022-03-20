import java.util.Comparator;
import java.util.TreeSet;

class MyCompare implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        // 이미 String 클래스 내부에서 비교 로직이 구현되어 있기 때문에 compareTo() 메서드를 호출한다.
        // return s1.compareTo(s2); // 오름차순
        return s1.compareTo(s2) * (-1); // 내림차순
    }
}

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

        // 결과
        // 이태성 회원님의 아이디는 1001입니다.
        // 박주희 회원님의 아이디는 1002입니다.
        // 정기윤 회원님의 아이디는 1003입니다.
        // 윤호근 회원님의 아이디는 1004입니다.


        /**
         * 이미 Comparable이 구현된 경우 Comparator로 비교하는 방식을 다시 구현할 수 있음.
         * ex) String 클래스는 이미 내부적으로 comparable이 구현되어 있음. 이 같은 경우를 Comparator를 통해서 다시 재정렬을 함.
         */

        // 비교 방식을 역순으로 재정렬한 new MyCompare()를 통해서 set에 값을 추가한다.
        TreeSet<String> set = new TreeSet<>(new MyCompare());
        set.add("Park");
        set.add("Kim");
        set.add("Lee");

        System.out.println(set);

        // 결과
        // [Park, Lee, Kim]
    }
}
