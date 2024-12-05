package _Exam_19December2023.climbers.models.climbing;



import _Exam_19December2023.climbers.models.climber.Climber;
import _Exam_19December2023.climbers.models.mountain.Mountain;

import java.util.Collection;
import java.util.Iterator;

public class ClimbingImpl implements Climbing{

    @Override
    public void conqueringPeaks(Mountain mountain, Collection<Climber> climbers) {
        Iterator<Climber> climberIterator = climbers.iterator();
        Iterator<String> peakIterator = mountain.getPeaksList().iterator();

        while (climberIterator.hasNext() && peakIterator.hasNext()){
            Climber climber = climberIterator.next();

            while (climber.canClimb() && peakIterator.hasNext()){
                String peak = peakIterator.next();
                climber.climb();
                climber.getRoster().getPeaks().add(peak);
                peakIterator.remove();
            }
        }
    }
}
