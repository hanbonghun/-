package org.example;

import org.example.system.controller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.*;

public class App {
    public void run() {
        System.out.println("== 명언 앱 ==");

        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();

        while (true) {
            System.out.print("명령) ");
            String command = Container.getScanner().nextLine().trim();
            Rq  rq = new Rq(command);

            switch (rq.getActionCode()) {
                case "종료":
                    systemController.exit();
                    break;
                case "등록":
                    wiseSayingController.write();
                    break;
                case "목록":
                    wiseSayingController.list();
                    break;


            }
        }

    }

}
