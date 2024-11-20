package _Exam_09December_2023.harpoonDiver.core;


import _Exam_09December_2023.harpoonDiver.models.diver.DeepWaterDiver;
import _Exam_09December_2023.harpoonDiver.models.diver.Diver;
import _Exam_09December_2023.harpoonDiver.models.diver.OpenWaterDiver;
import _Exam_09December_2023.harpoonDiver.models.diver.WreckDiver;
import _Exam_09December_2023.harpoonDiver.models.diving.Diving;
import _Exam_09December_2023.harpoonDiver.models.diving.DivingImpl;
import _Exam_09December_2023.harpoonDiver.models.divingSite.DivingSite;
import _Exam_09December_2023.harpoonDiver.models.divingSite.DivingSiteImpl;
import _Exam_09December_2023.harpoonDiver.repositories.DiverRepository;
import _Exam_09December_2023.harpoonDiver.repositories.DivingSiteRepository;
import _Exam_09December_2023.harpoonDiver.repositories.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static harpoonDiver.common.ConstantMessages.*;
import static harpoonDiver.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    private final Repository<Diver> diverRepository;
    private final DivingSiteRepository divingSiteRepository;
    private int divingCount;
    public ControllerImpl() {
        this.diverRepository = new DiverRepository();
        this.divingSiteRepository = new DivingSiteRepository();
        this.divingCount = 0;
    }
    @Override
    public String addDiver(String kind, String diverName) {
        Diver diver;
        if (kind.equals("DeepWaterDiver")){
            diver = new DeepWaterDiver(diverName);
        } else if (kind.equals("OpenWaterDiver")){
            diver = new OpenWaterDiver(diverName);
        } else if (kind.equals("WreckDiver")) {
            diver = new WreckDiver(diverName);
        } else {
            throw new IllegalArgumentException(DIVER_INVALID_KIND);
        }

        diverRepository.add(diver);

        return String.format(DIVER_ADDED, kind, diverName);
    }

    @Override
    public String addDivingSite(String siteName, String... seaCreatures) {
        DivingSite divingSite = new DivingSiteImpl(siteName);
        for (String seaCreature : seaCreatures){
            divingSite.getSeaCreatures().add(seaCreature);
        }
        divingSiteRepository.add(divingSite);

        return String.format(DIVING_SITE_ADDED, siteName);
    }

    @Override
    public String removeDiver(String diverName) {
        Diver diver = diverRepository.byName(diverName);
        if (diver == null){
            throw new IllegalArgumentException(String.format(DIVER_DOES_NOT_EXIST, diverName));
        }
        diverRepository.remove(diver);
        return String.format(DIVER_REMOVE, diverName);
    }

    @Override
    public String startDiving(String siteName) {
        List<Diver> allDivers = new ArrayList<>(diverRepository.getCollection());

        List<Diver> divers = new ArrayList<>();
        for (Diver diver : allDivers){
            if (diver.getOxygen() > 30){
                divers.add(diver);
            }
        }
        if (divers.isEmpty()){
            throw new IllegalArgumentException(SITE_DIVERS_DOES_NOT_EXISTS);
        }
        DivingSite divingSite = divingSiteRepository.byName(siteName);

        Diving diving = new DivingImpl();

        diving.searching(divingSite, divers);
        int removeDivers = 0;
        for (Diver diver : divers){
            if (!diver.canDive()){
                removeDivers++;
            }
        }
        this.divingCount++;

        return String.format(SITE_DIVING, siteName, removeDivers);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_DIVING_SITES, divingCount)).append(System.lineSeparator());
        sb.append(FINAL_DIVERS_STATISTICS).append(System.lineSeparator());
        for (Diver diver : this.diverRepository.getCollection()) {
            sb.append(String.format(FINAL_DIVER_NAME, diver.getName())).append(System.lineSeparator());
            sb.append(String.format(FINAL_DIVER_OXYGEN, diver.getOxygen())).append(System.lineSeparator());
            if (diver.getSeaCatch().getSeaCreatures().isEmpty()){
                sb.append("Diver's catch: None").append(System.lineSeparator());
            } else {
                sb.append(String.format(FINAL_DIVER_CATCH, diver.getSeaCatch().getSeaCreatures().stream()
                        .collect(Collectors.joining(FINAL_DIVER_CATCH_DELIMITER)))).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
