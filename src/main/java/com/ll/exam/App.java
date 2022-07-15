package com.ll.exam;

import java.util.Scanner;

public class App {
    public void run(){
        Scanner sc = new Scanner(System.in);

        WiseSayingController wc = new WiseSayingController(sc);
        System.out.println("========== 명언 앱 ==========");

        outer:
        while(true){
            System.out.print("명령 ) ");
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);

            switch (cmd){
                case "등록" :
                    wc.write(rq);
                    break;
                case "삭제" :
                    wc.remove(rq);
                    break;
                case "수정":
                    wc.modify(rq);
                    break;
                case "목록" :
                    wc.list(rq);
                    break;
                case "종료" :
                    break outer;
            }
        }
        sc.close();
    }
}
