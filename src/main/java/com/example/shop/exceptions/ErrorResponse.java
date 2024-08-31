package com.example.shop.exceptions;

import lombok.*;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse{

    private String message;

    @Builder.Default
    private List<String> details = new ArrayList<>();

    @Builder.Default
    LocalDateTime timestamp = LocalDateTime.now();
}
