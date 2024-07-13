package com.example.superquiz.data;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Question {
    @NotNull
    private String question;
    @NotNull
    private List<String> choiceList;

    private int answerIndex;
}
