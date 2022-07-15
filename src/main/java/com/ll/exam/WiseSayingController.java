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
        int paramId = rq.getIntParam("id",0); // id를 키로 검색, 값이 없으면 0리턴
     
        if (paramId == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }
        WiseSaying ws = wiseSayingRepository.findById(paramId);

        if (ws == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }
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
