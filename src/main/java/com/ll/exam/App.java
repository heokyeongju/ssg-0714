package com.ll.exam;

import java.util.Scanner;

public class App {
    public void run(){
        Scanner sc = new Scanner(System.in);
        String cmd;
        WiseSayingController wc = new WiseSayingController();
        System.out.println("========== 명언 앱 ==========");
        outer:
        while(true){
            System.out.print("명령 ) ");
            cmd = sc.nextLine();
            switch (cmd){
                case "등록" :
                    wc.add();
                    break;
                case "삭제" :
                    wc.remove();
                    break;
                case "목록" :
                    wc.list();
                    break;
                case "종료" :
                    break outer;
            }
        }


    }
}
