package br.com.security.resource;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Log4j2
@Controller
public class DashBoardController {
    Logger logger = Logger.getLogger(DashBoardController.class.getName());

    @GetMapping("/admin/dashboard")
    public String dashboardPage(){
        logger.info(" ::: >>>  DashboardController ::: Passando pela Url do dashboard");
        return "success/dashboard";
    }

    @GetMapping("/error")
    public String ErrorPage(){
        logger.info(" ::: >>>  DashboardController ::: Passando pela Url do error");
        return "error";
    }

    @GetMapping("/unauthorized")
    public String anauthorizedPage(){
        logger.info(" ::: >>> DashboardController ::: Passando pela Url do Unauthorized");
        return "unauthorized";
    }
}
