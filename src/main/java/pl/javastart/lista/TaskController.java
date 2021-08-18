package pl.javastart.lista;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {

    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) Category category) {
        List<Task> taskList;
        if (category != null) {
            taskList = taskRepository.findByCategory(category);
        } else {
            taskList = taskRepository.findAll();
        }
        model.addAttribute("taskList", taskList);
        return "home";
    }

    @GetMapping("/archive")
    public String archive(Model model, @RequestParam(required = false) Task isDone) {
        List<Task> taskList = null;
        if (isDone.equals("false")) {
            taskList = taskRepository.findByDone(isDone.getDone());
        }
        model.addAttribute("taskList", taskList);
        return "home";
    }

    @GetMapping("/task/{id}")
    public String showTask(@PathVariable Long id, Model model) {
        Optional<Task> taskOptional = taskRepository.findById(id);

        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            model.addAttribute("task", task);
            return "task";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/task/{id}/edit")
    public String showTaskEditForm(@PathVariable Long id, Model model) {
        Optional<Task> taskOptional = taskRepository.findById(id);

        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            model.addAttribute("taskToEdit", task);
            return "taskEdit";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/task/{id}/edit")
    public String editTask(@PathVariable Long id, Task task) {
        Task task1 = taskRepository.findById(id).orElseThrow();
        task1.setDescription(task.getDescription());
        task1.setCategory(task.getCategory());
        task1.setDone(task.getDone());
        taskRepository.save(task1);
        return "redirect:/task/" + task.getId();
    }

}
