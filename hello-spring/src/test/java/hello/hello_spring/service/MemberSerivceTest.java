package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberSerivceTest {

    MemberSerivce memberSerivce;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberSerivce = new MemberSerivce(memberRepository);
    }

    @AfterEach
    public void afterEachTest() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long savedId = memberSerivce.join(member);

        //then
        Member member1 = memberSerivce.findOne(savedId).get();
        Assertions.assertThat(member.getName()).isEqualTo(member1.getName());
    }

    @Test
    public void 중복_회원_예외(){
        // given
        Member member1 = new Member();
        member1.setName("Spring");

        Member member2 = new Member();
        member2.setName("Spring");

        //when
        memberSerivce.join(member1);
        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> memberSerivce.join(member2));// 뒤 로직을 할때 이 오류가 발생해야함
        Assertions.assertThat(illegalStateException.getMessage()).isEqualTo("이미 존재하는 회원입니다");
//        try {
//            memberSerivce.join(member2);
//            fail("예외가 발생해야합ㄴ디ㅏ.");
//        } catch (IllegalStateException e) {
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
//        }

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}