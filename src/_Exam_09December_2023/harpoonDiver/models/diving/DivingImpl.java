package _Exam_09December_2023.harpoonDiver.models.diving;

import _Exam_09December_2023.harpoonDiver.models.diver.Diver;
import _Exam_09December_2023.harpoonDiver.models.divingSite.DivingSite;


import java.util.Collection;

public class DivingImpl implements Diving{
    @Override
    public void searching(DivingSite divingSite, Collection<Diver> divers) {
        Collection<String> divingSites = divingSite.getSeaCreatures();
        for (Diver diver : divers){
            while (diver.canDive() && divingSites.iterator().hasNext()){
                diver.shoot();
                String currentDivingSites = divingSites.iterator().next();
                diver.getSeaCatch().getSeaCreatures().add(currentDivingSites);
                divingSites.remove(currentDivingSites);
            }
        }
    }
}
