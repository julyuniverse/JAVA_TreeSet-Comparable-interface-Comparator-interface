# 정렬을 위해 Comparable과 Comparator 인터페이스 구현하기

## TreeSet 클래스 활용하기

- 객체의 정렬에 사용하는 클래스
- Set 인터페이스를 구현하여 중복을 허용하지 않고, 오름차순이나 내림차순으로 객체를 정렬할 수 있음.
- 내부적으로 이진검색트리(binary search tree)로 구현됨.
- 이진검색트리에 저장하기 위해 각 객체를 비교해야 함.
- 비교 대상이 되는 객체에 Comparable이나 Comparator 인터페이스를 구현해야 TreeSet에 추가될 수 있음.
- String, Integer 등 JDK의 많은 클래스들이 이미 Comparable을 구현했음.

## Comparable 인터페이스의 compareTo() 메서드

- compareTo() 메서드는 TreeSet으로 선언된 변수에 속해 있는 값을 내부적으로 비교한다.
  compareTo() 메서드의 반환값은 int다.
  넘어온 매개 변숫값과 this의 값을 비교하여 this의 값이 더 높으면 양수를 서로 같은 값이면 0을 this의 값이 더 낮으면 음수를 설정하도록 한다.
  위와 같이 설정을 하면 오름차순이 될 것이고 반대로 this의 값이 더 높으면 음수를 서로 같은 값이면 0을 this의 값이 더 낮으면 양수를 설정하면 내림차순으로 설정된다.

## Comparator 인터페이스의 compare() 메서드

- compare() 메서드도 Comparable 인터페이스의 compareTo() 메서드와 동일한 흐름으로 작동한다.
  TreeSet을 구현할 때 Comparable 인터페이스나 Comparator 인터페이스 둘 중에 하나를 활용하면 된다.

## Comparator의 활용

- 이미 Comparable이 구현된 경우 Comparator로 비교하는 방식을 다시 구현할 수 있음.
  ex) String 클래스는 이미 내부적으로 comparable이 구현되어 있음. 이 같은 경우를 Comparator를 통해서 다시 정렬을 함.