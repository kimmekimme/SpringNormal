package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
//@("mainDiscountPolicy")
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {


    private int discountPercent = 10;
    @Override //ctrl shift t: create test
    public int discount(Member member, int pr) {
        if (member.getGrade()== Grade.VIP){
            return pr * discountPercent / 100;
        }else {
            return 0;
        }
    }
}
