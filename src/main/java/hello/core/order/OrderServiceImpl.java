package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;

@Component
@RequiredArgsConstructor //final이 붙은 필드로 생성자를 만들어줌
public class OrderServiceImpl implements OrderService {

    //
    private final MemberRepository memberRepository;//회원찾기
    private final DiscountPolicy discountPolicy;//널포인트익셉션 어떻게?

//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        //System.out.println("discountPolicy = " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }
//
//    @Autowired//(required = false)
//    public void setMemberRepository(MemberRepository memberRepository) {
//        //System.out.println("memberRepository = " + memberRepository);
//        this.memberRepository = memberRepository;
//    }
//생성자 없어도 되고, 생성자 주입이 가장 먼저 호출 후 수정자 주입 호출
    // @Autowired //의존관계 자동 주입, 생성자 하나면 생략가능

//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }




    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //할인찾기
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //OCP 위반



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        //ctrl alt v 추출

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
