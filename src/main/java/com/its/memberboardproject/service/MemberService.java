package com.its.memberboardproject.service;

import com.its.memberboardproject.dto.MemberDTO;
import com.its.memberboardproject.entity.MemberEntity;
import com.its.memberboardproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;


    public void save(MemberDTO memberDTO)throws IOException {
        MultipartFile memberProfile = memberDTO.getMemberProfile();
        String memberFileName = memberProfile.getOriginalFilename();
        memberFileName = System.currentTimeMillis() + "_" + memberFileName;
        String savePath = "C:\\springboot_img\\" + memberFileName;
        if (!memberProfile.isEmpty()) {
            memberProfile.transferTo(new File(savePath));
        }
        memberDTO.setMemberFileName(memberFileName);

        Optional<MemberEntity> optionalMemberEntity =
                memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        if(optionalMemberEntity.isPresent()) {
            Mem
        }
    }
}
