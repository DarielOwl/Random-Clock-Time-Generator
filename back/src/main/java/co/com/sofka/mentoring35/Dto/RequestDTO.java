package co.com.sofka.mentoring35.Dto;

public class RequestDTO {
    private String list;

    public RequestDTO(String list) {
        this.list = list;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "RequestDTO{" +
                "list='" + list + '\'' +
                '}';
    }


}
