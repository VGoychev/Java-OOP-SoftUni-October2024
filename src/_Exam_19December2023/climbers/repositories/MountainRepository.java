package _Exam_19December2023.climbers.repositories;



import _Exam_19December2023.climbers.models.mountain.Mountain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MountainRepository implements Repository<Mountain>{
    private Collection<Mountain> mountains;

    public MountainRepository(){
        this.mountains = new ArrayList<>();
    }
    @Override
    public Collection<Mountain> getCollection() {
        return Collections.unmodifiableCollection(this.mountains);
    }

    @Override
    public void add(Mountain mountain) {
        this.mountains.add(mountain);
    }

    @Override
    public boolean remove(Mountain mountain) {
        if (this.mountains.contains(mountain)){
            this.mountains.remove(mountain);
            return true;
        }
        return false;
    }

    @Override
    public Mountain byName(String name) {
        return this.mountains.stream().filter(mountain -> mountain.getName().equals(name))
                .findFirst().orElse(null);
    }
}
