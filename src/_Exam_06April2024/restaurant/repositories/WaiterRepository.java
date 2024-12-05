package _Exam_06April2024.restaurant.repositories;

import _Exam_06April2024.restaurant.models.waiter.Waiter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class WaiterRepository implements Repository<Waiter>{
    private Collection<Waiter> waiters;

    public WaiterRepository(){
        this.waiters = new ArrayList<>();
    }
    @Override
    public Collection<Waiter> getCollection() {
        return Collections.unmodifiableCollection(this.waiters);
    }

    @Override
    public void add(Waiter waiter) {
        this.waiters.add(waiter);
    }

    @Override
    public boolean remove(Waiter waiter) {
        if (this.waiters.contains(waiter)){
            this.waiters.remove(waiter);
            return true;
        }
        return false;
    }

    @Override
    public Waiter byName(String name) {
        return this.waiters.stream()
                .filter(waiter -> waiter.getName().equals(name))
                .findFirst().orElse(null);
    }
}
