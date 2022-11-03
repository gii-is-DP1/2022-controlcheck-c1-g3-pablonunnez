package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecoveryRoomService {

    RecoveryRoomRepository repo;

    @Autowired
    public RecoveryRoomService(RecoveryRoomRepository repo) {
        this.repo=repo;
    }

    public List<RecoveryRoom> getAll(){
        return repo.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return null;
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return repo.findTypeByname(typeName);
    }

    public RecoveryRoom save(RecoveryRoom rr) throws DuplicatedRoomNameException {
        return repo.save(rr);       
    }
    

    
}
