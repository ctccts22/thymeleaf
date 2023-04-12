package ksmart.thymeleaf.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private String memberId;
    private String memberPw;
    private String memberLevel;
    private String memberName;
    private String memberMobile;

}
