package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
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
//@RequiredArgsConstructor //final�씠 遺숈� �븘�뱶濡� �깮�꽦�옄瑜� 留뚮뱾�뼱以�
public class OrderServiceImpl implements OrderService {

    //
    private final MemberRepository memberRepository;//�쉶�썝李얘린
    private final DiscountPolicy discountPolicy;//�꼸�룷�씤�듃�씡�뀎�뀡 �뼱�뼸寃�?
    
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
//�깮�꽦�옄 �뾾�뼱�룄 �릺怨�, �깮�꽦�옄 二쇱엯�씠 媛��옣 癒쇱� �샇異� �썑 �닔�젙�옄 二쇱엯 �샇異�
    // @Autowired //�쓽議닿�怨� �옄�룞 二쇱엯, �깮�꽦�옄 �븯�굹硫� �깮�왂媛��뒫

    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {

        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }




    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //�븷�씤李얘린
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //OCP �쐞諛�



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        //ctrl alt v 異붿텧

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //�뀒�뒪�듃 �슜�룄
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
