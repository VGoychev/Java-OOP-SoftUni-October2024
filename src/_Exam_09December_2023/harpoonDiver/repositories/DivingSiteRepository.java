package _Exam_09December_2023.harpoonDiver.repositories;


import _Exam_09December_2023.harpoonDiver.models.divingSite.DivingSite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DivingSiteRepository implements Repository<DivingSite>{
    private Collection<DivingSite> divingSites;

    public DivingSiteRepository(){
        this.divingSites = new ArrayList<>();
    }
    @Override
    public Collection getCollection() {
        return Collections.unmodifiableCollection(this.divingSites);
    }

    @Override
    public void add(DivingSite divingSite) {
        this.divingSites.add(divingSite);
    }

    @Override
    public boolean remove(DivingSite divingSite) {
        if (this.divingSites.contains(divingSite)){
            this.divingSites.remove(divingSite);
            return true;
        }
        return false;
    }

    @Override
    public DivingSite byName(String name) {
        for (DivingSite divingSite : this.divingSites){
            if (divingSite.getName().equals(name)){
                return divingSite;
            }
        }
        return null;
    }
}
