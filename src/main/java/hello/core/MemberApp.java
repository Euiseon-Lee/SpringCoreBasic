package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.AppConfig;

public class MemberApp {

    public static void main(String[] args) {
        //순수 자바코드로 만든 테스트 => 실제로는 JUnit을 사용
        //내가 직접 MemberServiceImpl을 호출하는 형태
        //MemberService memberService = new MemberServiceImpl();

        //의존관계를 주입하는 코드
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = "+member.getName());
        System.out.println("find member = "+findMember.getName());
    }
}
