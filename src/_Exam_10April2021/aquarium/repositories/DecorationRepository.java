package _Exam_10April2021.aquarium.repositories;


import _Exam_10April2021.aquarium.entities.decorations.Decoration;

import java.util.ArrayList;
import java.util.Collection;

public class DecorationRepository implements Repository{
    private Collection<Decoration> decorations;

    public DecorationRepository() {
        this.decorations = new ArrayList<>();
    }

    @Override
    public void add(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public boolean remove(Decoration decoration) {

        if (this.decorations.contains(decoration)){
            this.decorations.remove(decoration);
            return true;
        }
        return false;
    }

    @Override
    public Decoration findByType(String type) {

        return this.decorations.stream().filter(decoration -> decoration.getClass().getSimpleName().equals(type))
                .findFirst().orElse(null);
    }
}
