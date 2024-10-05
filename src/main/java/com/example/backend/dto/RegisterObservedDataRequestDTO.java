package com.example.backend.dto;

import com.example.backend.handler.ImageHandler;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterObservedDataRequestDTO {

    private String observedDataId;
    private String memberId;
    private Integer coastCode;
    private Integer estimationLiter;
    MultipartFile observedPicture;
    private String observedPicturePath;
    private LocalDateTime observedDt;
    private String litterTypeCode;

    public RegisterObservedDataRequestDTO(String userId, RegisterObservedDataRequestDTO dto) throws IOException {

        this.observedDataId = generateObservedDataId(dto);
        this.memberId = userId;
        this.coastCode = dto.getCoastCode();
        this.estimationLiter = dto.getEstimationLiter();
        this.observedPicture = dto.getObservedPicture();
        this.observedDt = dto.getObservedDt();
        this.litterTypeCode = dto.getLitterTypeCode();
    }

    private String generateObservedDataId(RegisterObservedDataRequestDTO dto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        return dto.getObservedDt().format(formatter) + String.format("%04d", dto.getCoastCode());   // 연 + 월 + 일 + 시 + 분 + 해안코드  => 조사데이터 일련번호 생성
    }

    public void setObservedDt(String observedDt) {
        this.observedDt = LocalDateTime.parse(observedDt, DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
    }

}
