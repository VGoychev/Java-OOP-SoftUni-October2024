package _Exam_19December2023.climbers.models.mountain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static _Exam_19December2023.climbers.common.ExceptionMessages.MOUNTAIN_NAME_NULL_OR_EMPTY;

public class MountainImpl implements Mountain{
    private String name;
    private Collection<String> peaks;

    public MountainImpl(String name){
        setName(name);
        this.peaks = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(MOUNTAIN_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getPeaksList() {
        return this.peaks;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
