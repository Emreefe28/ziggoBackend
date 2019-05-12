package hva.ewa.model;

public class CategoryAndDate {
    public String categoryname;
    public Long questionnaireDate;

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public Long getQuestionnaireDate() {
        return questionnaireDate;
    }

    public void setQuestionnaireDate(Long questionnaireDate) {
        this.questionnaireDate = questionnaireDate;
    }

    public CategoryAndDate(String categoryname, Long questionnaireDate) {
        this.categoryname = categoryname;
        this.questionnaireDate = questionnaireDate;
    }
}
