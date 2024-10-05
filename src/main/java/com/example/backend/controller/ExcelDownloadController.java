package com.example.backend.controller;

import com.example.backend.dto.CleanupStatsDataRequestDto;
import com.example.backend.service.CleanupDataService;
import com.example.backend.service.ObservedDataService;
import com.example.backend.util.ExcelColumnEnum;
import com.example.backend.util.ExcelDownload;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/excel")
public class ExcelDownloadController {

    private final CleanupDataService cleanupDataService;
    private final ObservedDataService observedDataService;

    @Autowired
    private ExcelDownload excelDownload;

    @GetMapping("/download/{screen}/{startDate}/{endDate}")
    public ResponseEntity<?> downloadExcelFile(
            @PathVariable String screen
            , @PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate startDate
            , @PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate endDate
    ) throws IOException {

        byte[] excelFile = null;
        if ("observedMajorLitter".equals(screen)) {
            excelFile = excelDownload.makeExcelFile(observedDataService.searchObservedMajorLitterByCoast(startDate, endDate), screen);
        } else if ("cleanupMajorLitter".equals(screen)) {
            excelFile = excelDownload.makeExcelFile(cleanupDataService.MajorTypeOfLitterGroupByCoast(new CleanupStatsDataRequestDto(startDate, endDate)), screen);
        } else if ("observedEstimation".equals(screen)) {
            excelFile = excelDownload.makeExcelFile(observedDataService.searchObservedEstimationLitterByCoast(startDate, endDate), screen);
        } else if ("cleanupEstimation".equals(screen)) {
            excelFile = excelDownload.makeExcelFile(cleanupDataService.cleanupDataGroupBySigungu(startDate, endDate),screen);
        } else if ("totEstimation".equals(screen)) {
            excelFile = excelDownload.makeExcelFile(cleanupDataService.totalCollectedLitterByCoast(new CleanupStatsDataRequestDto(startDate, endDate)), screen);
        }

        // 한글 파일명을 URL 인코딩
        // String fileName = ExcelColumnEnum.getFileNameByScreeen(screen); 한글이 인코딩이나 변환과정을 고쳐도 인식이 안됨.

        // HTTP 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + screen + ".xlsx");

        return ResponseEntity.ok().headers(headers).body(excelFile);
    }
}
