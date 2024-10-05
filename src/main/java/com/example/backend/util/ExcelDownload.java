package com.example.backend.util;

import com.example.backend.dto.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class ExcelDownload {

    private ObservedMajorTypeOfLitterGroupByCoastResponseDTO ob_majorLitterDTO;
    private MajorTypeOfLitterGroupByCoastResponseDto cl_majorLitterDTO;
    private ObservedEstimationLitterGroupByCoastResponseDTO ob_estimationDTO;
    private CleanupDataGroupByCoastResponseDto cl_estimationDTO;
    private TotalCleanupLitterGroupBySigunguResponseDto totEstimationDTO;

    public <T> byte[] makeExcelFile(List<T> dtoList, String screen) throws IOException {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(ExcelColumnEnum.getFileNameByScreeen(screen));
        List<String> korColumnList = ExcelColumnEnum.getKorColumnList(screen);
        int rowNo = 0;
        Row headerRow = sheet.createRow(rowNo++);

        // 헤더컬럼 세팅
        for (int i = 0; i < korColumnList.size(); i++) {
            headerRow.createCell(i).setCellValue(korColumnList.get(i));
        }

        // 집계 조회 결과 dto 데이터 세팅
        for (T dto : dtoList) {
            Row row = sheet.createRow(rowNo++);

                // 해안선별 주요 쓰레기 종류 및 수거예측량(조사)
                if (dto instanceof ObservedMajorTypeOfLitterGroupByCoastResponseDTO) {
                    ob_majorLitterDTO = (ObservedMajorTypeOfLitterGroupByCoastResponseDTO) dto;
                    row.createCell(0).setCellValue(ob_majorLitterDTO.getSigunguName());
                    row.createCell(1).setCellValue(ob_majorLitterDTO.getCoastName());
                    row.createCell(2).setCellValue(ob_majorLitterDTO.getObservedMajorLitterName());

                // 해안선별 주요 쓰레기 종류 및 실제수거량(청소)
                } else if (dto instanceof MajorTypeOfLitterGroupByCoastResponseDto) {
                    cl_majorLitterDTO = (MajorTypeOfLitterGroupByCoastResponseDto) dto;
                    row.createCell(0).setCellValue(cl_majorLitterDTO.getSigunguName());
                    row.createCell(1).setCellValue(cl_majorLitterDTO.getCoastName());
                    row.createCell(2).setCellValue(cl_majorLitterDTO.getLitterTypeName());
                    row.createCell(3).setCellValue(cl_majorLitterDTO.getTotalCleanupLitter());

                // 해안선별 수거예측량(조사)
                } else if (dto instanceof ObservedEstimationLitterGroupByCoastResponseDTO) {
                    ob_estimationDTO = (ObservedEstimationLitterGroupByCoastResponseDTO) dto;
                    row.createCell(0).setCellValue(ob_estimationDTO.getSigunguName());
                    row.createCell(1).setCellValue(ob_estimationDTO.getCoastName());
                    row.createCell(2).setCellValue(ob_estimationDTO.getEstimationLiterSum());

                // 해안선별 실제수거량(청소)
                } else if (dto instanceof CleanupDataGroupByCoastResponseDto) {
                    cl_estimationDTO = (CleanupDataGroupByCoastResponseDto)dto;
                    row.createCell(0).setCellValue(cl_estimationDTO.getSigunguName());
                    row.createCell(1).setCellValue(cl_estimationDTO.getCoastName());
                    row.createCell(2).setCellValue(cl_estimationDTO.getTotalCleanupLitter());

                // 시군구별 누적수거량
                } else if (dto instanceof TotalCleanupLitterGroupBySigunguResponseDto) {
                    totEstimationDTO = (TotalCleanupLitterGroupBySigunguResponseDto) dto;
                    row.createCell(0).setCellValue(totEstimationDTO.getSigunguName());
                    row.createCell(1).setCellValue(totEstimationDTO.getCoastLen());
                    row.createCell(2).setCellValue(totEstimationDTO.getTotalCleanupLitter());
                }

            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                workbook.write(outputStream);
                return outputStream.toByteArray();
            } finally {
                workbook.close();
            }
        }
        return null;
    }

}
