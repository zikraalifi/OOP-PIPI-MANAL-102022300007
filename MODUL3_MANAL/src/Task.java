import java.time.LocalDate;

public class Task {
    // TO DO: Lengkapi atribut-atribut private kelas Task
    private final String title;
    private final String priority;
    private String status;
    private final LocalDate dueDate;
    // TO DO: Buat constructor untuk kelas Task
    public Task(String title, String priority, String status, LocalDate dueDate) {
        this.title = title;
        this.priority = priority;
        this.status = status;
        this.dueDate = dueDate;
    }
    
    // TO DO: Buat getter untuk title
    public String gettitle(){
        return title;
    }

    // TO DO: Buat getter untuk priority
    public String getpriority(){
        return priority;
    }

    // TO DO: Buat getter untuk dueDate
    public LocalDate getdueDate(){
        return dueDate;
    }

    // TO DO: Buat getter untuk status
    public String getstatus(){
        return status;
    }
    
    // TO DO: Buat setter untuk status
    public String setstatus(String status){
        this.status = status;
    }
    
}
