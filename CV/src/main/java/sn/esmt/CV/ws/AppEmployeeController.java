package sn.esmt.CV.ws;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.*;
import sn.esmt.CV.dao.AppEmployeeRepository;
import sn.esmt.CV.entities.AppEmployeeEntity;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
@AllArgsConstructor
public class AppEmployeeController {
    private AppEmployeeRepository appEmployeeRepository;
    //insertion dans la base de donnees
    @PostMapping(path = "/save")
    public AppEmployeeEntity save(@RequestBody AppEmployeeEntity appEmployeeEntity){
        return appEmployeeRepository.save(appEmployeeEntity);
    }
    @GetMapping(path = "/all")
    public List<AppEmployeeEntity> getAll(){
        return appEmployeeRepository.findAll();
    }
    }

