package _Exam_19December2023.climbers.models.climbing;

import _Exam_19December2023.climbers.models.climber.Climber;
import _Exam_19December2023.climbers.models.mountain.Mountain;


import java.util.Collection;

public interface Climbing {
    void conqueringPeaks(Mountain mountain, Collection<Climber> climbers);

}
