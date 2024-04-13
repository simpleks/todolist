package com.example.hello;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "todo")
class Todo {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private Integer id;
    private String taskTODO;
    private boolean done;

    /**
     * Hibernate (JPA) needs it
     */
    @SuppressWarnings("unused")
    Todo() {

    }


    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Integer getId() {
        return id;
    }

    public String getTaskTODO() {
        return taskTODO;
    }

    public void setTaskTODO(String taskTODO) {
        this.taskTODO = taskTODO;
    }


}
