package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조히")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //System.out.println("memberService = " + memberService);
        //System.out.println("memberService.getClass() = " + memberService.getClass());
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); //검증
    }

    @Test
    @DisplayName("이름없이 타입으로만 조히")
    void findBeanByType() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //System.out.println("memberService = " + memberService);
        //System.out.println("memberService.getClass() = " + memberService.getClass());
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); //검증

    }

    @Test
    @DisplayName("이름없이 타입으로만 조히")
    void findBeanByType2() {
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        //System.out.println("memberService = " + memberService);
        //System.out.println("memberService.getClass() = " + memberService.getClass());
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); //검증

    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX() {
        //ac.getBean("xxxxx", MemberService.class);
        //MemberService xxxxx = ac.getBean("xxxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("xxxxx", MemberService.class));
        //람다: 오른쪽 로직 ac.getBean("xxxxx", MemberService.class)를 실행 했을 때,
        //왼쪽 NoSuchBeanDefinitionException.class 예외가 터져야 테스트가 통과
        //
    }
}



