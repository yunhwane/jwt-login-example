package com.Rcommunity.Revos.domain.member.api;


import com.Rcommunity.Revos.domain.member.application.MemberService;
import com.Rcommunity.Revos.domain.member.dto.MemberDto;
import com.Rcommunity.Revos.domain.member.dto.UserSignResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/revos")
public class MemberController {

    private final MemberService memberService;

   // 등록
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void InsertUsers(@RequestBody MemberDto memberDto) throws Exception{
        memberService.register(memberDto);
    }
    @PostMapping(value = "/login")
    public ResponseEntity<UserSignResponse> signin(@RequestBody MemberDto request) throws Exception {
        return new ResponseEntity<>(memberService.login(request), HttpStatus.OK);
    }

}
