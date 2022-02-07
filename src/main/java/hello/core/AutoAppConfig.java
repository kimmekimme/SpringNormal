package hello.core;


import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration //설정정보
@ComponentScan(//디폴트는 컴포넌트 스캔 붙은 이 위치인 hello.core 패키지 하위를 등록
        basePackages = "hello.core.member", //멤버만 컴포넌트 스캔
        basePackageClasses = AutoAppConfig.class, //AutoAppConfig가 속한 패키지인 hello.core에서도 찾음
        excludeFilters= @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //빈 등록에서 빼 줄 것

)

//설정정보 클래스

public class AutoAppConfig {
    //기존 AppConfig 처럼 등록한거 1도 없음

//
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }


}
