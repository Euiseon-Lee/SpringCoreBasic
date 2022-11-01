package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //구현체 하나만 있는 경우 인터페이스명에 Impl라고 관례상 붙임
    /*
    * 가입을 하고 회원을 찾으려면 앞에서 만든 MemberRepository가 있어야 함
    * 하지만 인터패이스만 있으면 NullPointException이 발생 (private final MemberRepository memberRepository)
    * 따라서 구현체를 지정해 주어야 한다
    *   == new MemoryMemberRepository();
    * */


    /*
    * 이렇게 코드를 작성하는 경우 MemberServiceImpl은 의존관계에서 문제가 있음 (DIP 위반)
    * MemberRepository => 추상화에 의존함과 동시에
    * MemoryMemberRepository => 구체화에도 의존하고 있음
    * */
    //private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final MemberRepository memberRepository;

    //생성자를 통해서 MemberRepository를 가져옴 (생성자 주입)
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
