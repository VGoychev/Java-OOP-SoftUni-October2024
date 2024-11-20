package _Exam_09December_2023.harpoonDiver.models.diving;


import _Exam_09December_2023.harpoonDiver.models.diver.Diver;
import _Exam_09December_2023.harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;

public interface Diving {

    void searching(DivingSite divingSite, Collection<Diver> divers);
}
