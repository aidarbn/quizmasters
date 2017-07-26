package kz.codemasters.quizmasters.controller;

import kz.codemasters.quizmasters.model.Quiz;
import kz.codemasters.quizmasters.repository.interfaces.QuizRepository;
import org.primefaces.context.RequestContext;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean(name = "MQC")
@ViewScoped
public class ManageQuizController {

    private String addTitle;
    private String updateTitle;
    private Quiz selectedQuiz;

    @ManagedProperty("#{UC}")
    private UserController userController;

    @EJB
    private QuizRepository quizRepository;

    public boolean addQuiz(){
        Quiz quiz = new Quiz();
        quiz.setName(addTitle);
        addTitle = null;
        quiz.setUserId(userController.getUser().getId());
        return quizRepository.insertQuiz(quiz);
    }

    public boolean updateQuiz(){
        selectedQuiz.setName(updateTitle);
        updateTitle = null;
        return quizRepository.insertQuiz(selectedQuiz);
    }

    public Quiz getSelectedQuiz() {
        return selectedQuiz;
    }

    public void setSelectedQuiz(Quiz selectedQuiz) {
        this.selectedQuiz = selectedQuiz;
    }

    public QuizRepository getQuizRepository() {
        return quizRepository;
    }

    public void setQuizRepository(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    public String getAddTitle() {
        return addTitle;
    }

    public void setAddTitle(String title) {
        this.addTitle = title;
    }
    public String getUpdateTitle() {
        return updateTitle;
    }

    public void setUpdateTitle(String title) {
        this.addTitle = updateTitle;
    }



}