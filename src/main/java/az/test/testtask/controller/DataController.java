package az.test.testtask.controller;

import az.test.testtask.entity.Data;
import az.test.testtask.dto.UserDataRequest;
import az.test.testtask.service.DataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DataController {

    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @PutMapping("/set-info")
    public ResponseEntity<List<Data>> addInfo(@RequestBody UserDataRequest request) {
        return ResponseEntity.ok(dataService.addData(request));
    }

    @GetMapping("/level-info/{id}")
    public ResponseEntity<List<Data>> levelInfo(@PathVariable Long id) {
        return ResponseEntity.ok(dataService.getLevelData(id));
    }

    @GetMapping("/user-info/{id}")
    public ResponseEntity<List<Data>> userInfo(@PathVariable Long id) {
        return ResponseEntity.ok(dataService.getUserData(id));
    }
}
