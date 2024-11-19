package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberSerivce {

    private final MemberRepository memberRepository;

    public MemberSerivce(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 뢰원가입
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원은 안됨
        ValidateDuplicateMember(member); // 중복 회원 확인

        return memberRepository.save(member).getId();
    }

    private void ValidateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m ->{
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });
    }

    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long id){
        return memberRepository.findById(id);
    }
}
