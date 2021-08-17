package pl.javastart.lista;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Task {

    private Long id;
    private String description;
    @Enumerated(EnumType.STRING)
    private Category category;
    private boolean done;


    public Task(String description, Category category, boolean done) {
        this.description = description;
        this.category = category;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
