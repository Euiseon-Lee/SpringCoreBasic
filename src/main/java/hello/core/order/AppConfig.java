package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;

public class AppConfig {
    
    //new MemoryMemberRepository 중복 제거 + 역할과 구현클래스를 구분

    //MemberService 역할
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    //MemberRepository 역할
    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    //OrderService 역할
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //DiscountPolicy 역할 -> FixDiscountPolicy를 지정
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
