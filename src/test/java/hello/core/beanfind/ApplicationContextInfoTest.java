package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //iter + tab: 리스트나 배열이 있으면 for문 자동완성
        for (String beanDefinitionName : beanDefinitionNames) {

            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " Object = " + bean); //sout + v: 변수명 찍어주는 단축키
            //sout + m: 메소드명 찍어주는 단축키
        }
    }

    //ctrl + d: 밑에복사
    @Test
    @DisplayName("모든 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //iter + tab: 리스트나 배열이 있으면 for문 자동완성
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            //내가 직접 등록한 빈 조회: ROLE_APPLICATION
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) { //ROLE_INFRASTRUCTURE: 스프링 내부사용 빈
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + " Object = " + bean); //sout + v: 변수명 찍어주는 단축키


            }

            //sout + m: 메소드명 찍어주는 단축키
        }
    }
}
