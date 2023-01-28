package co.com.ias.projectBird.domain.usecase;

import co.com.ias.projectBird.domain.model.bird.Bird;
import co.com.ias.projectBird.domain.model.bird.dto.BirdDTO;
import co.com.ias.projectBird.domain.model.gateaway.IBirdRepository;
import co.com.ias.projectBird.domain.model.gateaway.ICountryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BirdUseCase {

    private final IBirdRepository iBirdRepository;
    private final ICountryRepository iCountryRepository;

    public BirdUseCase(IBirdRepository iBirdRepository, ICountryRepository iCountryRepository) {
        this.iBirdRepository = iBirdRepository;
        this.iCountryRepository = iCountryRepository;
    }


    public BirdDTO saveBird(BirdDTO birdDTO) {
        Bird bird = birdDTO.toDomain(birdDTO);
        return BirdDTO.fromDomain(this.iBirdRepository.saveBird(bird));
    }

    public BirdDTO findBirdById(Long id) {
        Bird bird = this.iBirdRepository.findBirdById(id);
        if (bird != null) {
            return BirdDTO.fromDomain(bird);
        }
        return null;
    }


    public ArrayList<BirdDTO> findAllBirds() {
        List<Bird> bird = this.iBirdRepository.findAllBirds();
        return (ArrayList<BirdDTO>) bird.stream().map(BirdDTO::fromDomain).collect(Collectors.toList());
    }


    public Boolean deleteBird(Long id){
        return iBirdRepository.deleteBird(id);
    }

    public BirdDTO updateBird(BirdDTO birdDTO){
        Bird bird = birdDTO.toDomain(birdDTO);
        return BirdDTO.fromDomain(iBirdRepository.updateBird(bird));
    }
}
