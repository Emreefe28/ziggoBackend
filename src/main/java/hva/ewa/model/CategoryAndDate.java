package hva.ewa.model;

public class CategoryAndDate {
    public String categoryname;
    public String questionnaireDate;

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getQuestionnaireDate() {
        return questionnaireDate;
    }

    public void setQuestionnaireDate(String questionnaireDate) {
        this.questionnaireDate = questionnaireDate;
    }

    public CategoryAndDate(String categoryname, String questionnaireDate) {
        this.categoryname = categoryname;
        this.questionnaireDate = questionnaireDate;
    }
}
