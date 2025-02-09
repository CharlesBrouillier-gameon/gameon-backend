package fr.gameon.controller;

import fr.gameon.entity.GameEntity;
import fr.gameon.entity.MechanismEntity;
import fr.gameon.service.GameService;
import fr.gameon.service.MechanismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mechanisms")
public class MechanismController  {

    @Autowired
    MechanismService mechanismService;

    @GetMapping
    public List<MechanismEntity> getMechanisms() {
        return mechanismService.getMechanisms();
    }
}
