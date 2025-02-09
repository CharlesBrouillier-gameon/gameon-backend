package fr.gameon.service;

import fr.gameon.entity.MechanismEntity;
import fr.gameon.repository.MechanismRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MechanismService implements IMechanismService {
    private final MechanismRepository mechanismRepository;

    public MechanismService(MechanismRepository mechanismRepository) {
        this.mechanismRepository = mechanismRepository;
    }

    @Override
    public List<MechanismEntity> getMechanisms() {
        return mechanismRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
