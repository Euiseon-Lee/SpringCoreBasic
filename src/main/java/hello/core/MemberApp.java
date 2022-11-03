package hello.core;

import hello.core.member.*;
import hello.core.order.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        //순수 자바코드로 만든 테스트 => 실제로는 JUnit을 사용
        //내가 직접 MemberServiceImpl을 호출하는 형태
        //MemberService memberService = new MemberServiceImpl();

        //의존관계를 주입하는 코드 (순수 자바코드)
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //AppConfig에 있는 환경설정 정보를 토대로 @Bean이 붙은 객체를 생성하여 관리
        // == AppConfig 정보를 스프링에 등록하는 코드
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = "+member.getName());
        System.out.println("find member = "+findMember.getName());
    }
}
