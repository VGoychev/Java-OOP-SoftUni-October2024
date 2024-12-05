package _Exam_19December2023.climbers.repositories;



import _Exam_19December2023.climbers.models.climber.Climber;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ClimberRepository implements Repository<Climber>{
    private Collection<Climber> climbers;

    public ClimberRepository(){
        this.climbers = new ArrayList<>();
    }
    @Override
    public Collection<Climber> getCollection() {
        return Collections.unmodifiableCollection(this.climbers);
    }

    @Override
    public void add(Climber climber) {
        this.climbers.add(climber);
    }

    @Override
    public boolean remove(Climber climber) {
        if (this.climbers.contains(climber)){
            this.climbers.remove(climber);
            return true;
        }
        return false;
    }

    @Override
    public Climber byName(String name) {
        return this.climbers.stream().filter(climber -> climber.getName().equals(name))
                .findFirst().orElse(null);
    }
}
