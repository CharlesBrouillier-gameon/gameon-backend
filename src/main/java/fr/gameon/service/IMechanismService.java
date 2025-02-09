package fr.gameon.service;

import fr.gameon.entity.GameEntity;
import fr.gameon.entity.MechanismEntity;

import java.util.List;

public interface IMechanismService {
    public List<MechanismEntity> getMechanisms();
}
