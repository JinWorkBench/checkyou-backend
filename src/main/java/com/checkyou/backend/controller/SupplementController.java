package com.checkyou.backend.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * SupplementController 클래스는 영양제 조합 분석을 위한 API를 제공합니다.
 * 클라이언트가 영양제 목록을 POST로 보내면, 그 조합에 대한 기본 분석 결과를 응답합니다.
 */
@RestController // 이 클래스가 REST API의 컨트롤러임을 나타냄 (JSON 으로 응답)
@RequestMapping("/api") // 이 컨트롤러의 공통 URI prefix → /api/...
public class SupplementController {

    /**
     * POST /api/combo-check
     *
     * 사용자가 전송한 영양제 이름 목록을 분석하여 결과를 반환하는 API
     * 현재는 단순히 받은 리스트를 그대로 응답에 포함시킵니다.
     *
     * @param supplements 사용자가 보내는 영양제 이름 리스트
     * @return Map<String, String> 형태의 JSON 응답
     */
    @PostMapping("/combo-check")
    public Map<String, String> checkCombination(@RequestBody List<String> supplements) {
        // 요청 본문(@RequestBody)에서 영양제 리스트를 받는다

        // 실제 분석 로직은 아직 없으므로, 간단히 받은 리스트만 문자열로 출력
        String inputList = String.join(", ", supplements); // 리스트를 문자열로 변환

        // 응답으로 간단한 결과 맵 반환
        return Map.of(
                "status", "success",                          // 응답 상태
                "message", "조합 분석 결과를 반환합니다",     // 설명 메시지
                "input", inputList                            // 사용자가 입력한 영양제 리스트
        );
    }
}
