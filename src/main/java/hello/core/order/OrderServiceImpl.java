package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // OrderServiceImple이 구체 클래스에 의존하지 않도록 코드 변경. -> 인터페이스만 의존하도록 만든다.
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

//    private DiscountPolicy discountPolicy;  // DIP는 지켰지만, 이렇게만 작성할 경우 에러 발생 (NullPointerException)

    // AppConfig 생성 후 코드 수정
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 철저하게 DIP를 지키는 코드
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);  // 회원을 조회하고,
        int discountPrice = discountPolicy.discount(member, itemPrice);  // 할인 정책에 회원 정보를 넘긴다.

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
