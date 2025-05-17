package edu.exaple.Omni_Channel.Controller;

import edu.exaple.Omni_Channel.dto.UnifiedDashboardDTO;
import edu.exaple.Omni_Channel.Service.UnifiedDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin("*")
@RequestMapping("/dashboard")
public class UnifiedDashboardController {

    @Autowired
    private UnifiedDashboardService dashboardService;

    @GetMapping
    public UnifiedDashboardDTO getDashboard() {
        return dashboardService.getDashboardData();
    }
}
