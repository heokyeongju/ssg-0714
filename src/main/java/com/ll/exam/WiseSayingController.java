package com.ll.exam;

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

    void remove(Rq rq) {
        System.out.println("삭제");
    }

    void list(Rq rq) {
        System.out.println("목록");
    }

    void modify(Rq rq) {
        System.out.println("수정");
    }

}
