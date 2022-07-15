package com.ll.exam;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private Scanner sc;
    private WiseSayingRepository wiseSayingRepository;

    WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayingRepository = new WiseSayingRepository();
    }

    void write(Rq rq) {
        System.out.print("명언 : ");
        String content = sc.nextLine().trim(); // 양끝 공백 제거
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();
        WiseSaying ws = wiseSayingRepository.write(content,author); //static 이 아니기 때문에 객체 생성해서 실행.
        System.out.printf("%d번 명언이 등록되었습니다.\n", ws.id);
    }

    public void remove(Rq rq) {
        // URL에 입력된 id 얻기
        int paramId = rq.getIntParam("id", 0);

        // URL에 입력된 id가 없다면 작업중지
        if (paramId == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        // URL에 입력된 id에 해당하는 명언객체 찾기
        WiseSaying foundWiseSaying = wiseSayingRepository.findById(paramId);

        // 찾지 못했다면 중지
        if (foundWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }

        // 입력된 id에 해당하는 명언객체를 리스트에서 삭제
        wiseSayingRepository.remove(paramId);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
    }

    void list(Rq rq) {
        System.out.println("========== 명언 목록 ==========");
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------");
        List<WiseSaying> wiseSayings = wiseSayingRepository.findAll();
        for(int i = wiseSayings.size()-1 ; i>=0; i--){
            WiseSaying ws = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", ws.id, ws.content, ws.author);
        }
    }

    void modify(Rq rq) {
        System.out.println("수정");
    }

}
