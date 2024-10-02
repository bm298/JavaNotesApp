package com.example.NotesAppJava.demo.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "notes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoteData {
    @Id
    @GeneratedValue
    public Long id;

    @Column(name = "task_description")
    public String taskDescription;

    @Column(name = "task_date")
    public String taskDate;

    @Column(name = "is_task_complete")
    public Boolean isTaskComplete;

    public NoteData(String taskDescription, String taskDate) {
        this.taskDescription = taskDescription;
        this.taskDate = taskDate;
        this.isTaskComplete = false;
    }

    public String toString() {
        return '\n'+"Note ID: " + id +
                ", Description: '" + taskDescription + '\'' +
                ", Date: '" + taskDate + '\'' +
                ", Completed: " + isTaskComplete ;
    }

}
