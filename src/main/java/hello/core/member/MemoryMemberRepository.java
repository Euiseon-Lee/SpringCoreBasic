package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    /*
        실제로는 ConcurrentHashMap을 사용해야 한다
        HashMap은 동시성 이슈가 있을 수 있기 때문 (여러 곳에서 동시 접속 시 처리가 어려움)
    */
    private static Map<Long, Member> store = new HashMap<>();


    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
