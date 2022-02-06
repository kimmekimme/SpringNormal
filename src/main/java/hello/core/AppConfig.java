package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.dnd.DragSourceMotionListener;
//ctrl + E: 최근 파일
//기획자: 역할과 구현 분리
//IOC컨테이너(DI컨테이너)
//GO to Class via Ctrl + N

@Configuration //설정구성정보 어노테이션
public class AppConfig {
//마우스 커서 갖다대고 f4: 소스 편집
//ctrl + art + m: 메소드 추출

    @Bean//(name = "이름") 지정가능
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
        return null;

    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //System.out.println("call AppConfig.discountPolicy");
        return new RateDiscountPolicy();
        //return new FixDiscountPolicy();
    }
}
