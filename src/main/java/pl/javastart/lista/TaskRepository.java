package pl.javastart.lista;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByCategory(Category category);

    List<Task> findByDone(String isDone);
}
