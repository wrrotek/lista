package pl.javastart.lista;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public class TaskController {

    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) boolean isDone) {
        List<Task> taskList = null;
        if (isDone) {
            taskList = taskRepository.displayDoneTasks(true);
        }
        model.addAttribute("taskList", taskList);
        return "home";
    }

    @GetMapping("/archive")
    public String archive(Model model, @RequestParam(required = false) boolean isDone) {
        List<Task> taskList = null;
        if (isDone != true) {
            taskList = taskRepository.displayDoneTasks(false);
        }
        model.addAttribute("taskList", taskList);
        return "home";
    }

    @GetMapping("/task/{id}")
    public String showMovie(@PathVariable Long id, Model model) {
        Optional<Task> taskOptional = taskRepository.findById(id);

        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            model.addAttribute("task", task);
            return "task";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/film/{id}/edit")
    public String showMovieEditForm(@PathVariable Long id, Model model) {
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
    public String editMovie(@PathVariable Long id, Task task) {
        Task task1 = taskRepository.findById(id).orElseThrow();

        task1.setDescription(task.getDescription());
        task1.setDone(task.isDone());
        task1.setCategory(task.getCategory());
        taskRepository.save(task1);
        return "redirect:/task/" + task.getId();
    }

}
