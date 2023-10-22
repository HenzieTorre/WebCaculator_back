package pojo;

public class Record {
    private Integer id;
    private String equation;
    private String result;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquation() {
        return equation;
    }
    public void setEquation(String equation) {
        this.equation = equation == null ? null : equation.trim();
    }

    public String getAnswer() {
        return result;
    }
    public void setAnswer(String result) {
        this.result = result == null ? null : result.trim();
    }

    @Override
    public String toString() {
        return "Record{" + "id=" + id + ", equation='" + equation + '\'' + ", result='" + result + '\'' + '}';
    }
}
