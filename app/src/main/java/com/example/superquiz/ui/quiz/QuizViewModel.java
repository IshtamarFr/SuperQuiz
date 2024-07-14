package com.example.superquiz.ui.quiz;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.superquiz.data.Question;
import com.example.superquiz.data.QuestionRepository;

public class QuizViewModel extends ViewModel {
    private final QuestionRepository questionRepository;
    MutableLiveData<Integer> score = new MutableLiveData<>(0);
    MutableLiveData<Integer> questionIndex = new MutableLiveData<>(0);
    MutableLiveData<Question> currentQuestion= new MutableLiveData<>();

    public QuizViewModel(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void startQuiz() {
        currentQuestion.postValue(questionRepository.getQuestions().get(0));
    }

    public void isAnswerValid(Integer answerIndex) {
        if (currentQuestion.getValue().getAnswerIndex() == answerIndex) {
            score.postValue(score.getValue() + 1);
        }
    }

    public void nextQuestion() {
        if (questionIndex.getValue() < questionRepository.getQuestions().size() - 1) {
            questionIndex.postValue(questionIndex.getValue() + 1);
            currentQuestion.postValue(questionRepository.getQuestions().get(questionIndex.getValue()));
        }
    }
}
