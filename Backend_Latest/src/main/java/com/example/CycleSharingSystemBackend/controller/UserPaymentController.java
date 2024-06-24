package com.example.CycleSharingSystemBackend.controller;

import com.example.CycleSharingSystemBackend.dto.TotalEstimatedAmountDTO;
import com.example.CycleSharingSystemBackend.service.UserPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/payment")
@CrossOrigin("http://localhost:3000")
public class UserPaymentController {

    private final UserPaymentService userPaymentService;

    @Autowired
    public UserPaymentController(UserPaymentService userPaymentService) {
        this.userPaymentService = userPaymentService;
    }

    @GetMapping("/total")
    public TotalEstimatedAmountDTO getTotalEstimatedAmount(@RequestParam("date") String date) {
        LocalDate paymentDate = LocalDate.parse(date);
        Double totalAmount = userPaymentService.getTotalEstimatedAmountForDate(paymentDate);

        TotalEstimatedAmountDTO response = new TotalEstimatedAmountDTO();
        response.setPaymentDate(paymentDate);
        response.setTotalEstimatedAmount(totalAmount);

        return response;
    }

    @GetMapping("/dailySum")
    public Double getDailySum(@RequestParam("date") String date) {
        LocalDate localDate = LocalDate.parse(date);
        return userPaymentService.getDailySum(localDate);
    }

    @GetMapping("/monthlySum")
    public Double getMonthlySum(@RequestParam("year") int year, @RequestParam("month") int month) {
        return userPaymentService.getMonthlySum(year, month);
    }
}
