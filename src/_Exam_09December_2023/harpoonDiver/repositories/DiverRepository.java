package _Exam_09December_2023.harpoonDiver.repositories;


import _Exam_09December_2023.harpoonDiver.models.diver.Diver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DiverRepository implements Repository<Diver>{
    private List<Diver> divers;

    public DiverRepository(){
        this.divers = new ArrayList<>();
    }

    @Override
    public Collection getCollection() {
        return Collections.unmodifiableCollection(this.divers);
    }

    @Override
    public void add(Diver diver) {
        this.divers.add(diver);
    }

    @Override
    public boolean remove(Diver diver) {
        if (this.divers.contains(diver)){
            this.divers.remove(diver);
            return true;
        }
        return false;
    }

    @Override
    public Diver byName(String name) {
        for (Diver diver : this.divers){
            if (diver.getName().equals(name)){
                return diver;
            }
        }
        return null;
    }
}
