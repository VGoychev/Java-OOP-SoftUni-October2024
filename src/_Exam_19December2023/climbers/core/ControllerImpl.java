package _Exam_19December2023.climbers.core;



import _Exam_19December2023.climbers.models.climber.Climber;
import _Exam_19December2023.climbers.models.climber.RockClimber;
import _Exam_19December2023.climbers.models.climber.WallClimber;
import _Exam_19December2023.climbers.models.climbing.Climbing;
import _Exam_19December2023.climbers.models.climbing.ClimbingImpl;
import _Exam_19December2023.climbers.models.mountain.Mountain;
import _Exam_19December2023.climbers.models.mountain.MountainImpl;
import _Exam_19December2023.climbers.repositories.ClimberRepository;
import _Exam_19December2023.climbers.repositories.MountainRepository;

import java.util.List;

import static _Exam_19December2023.climbers.common.ConstantMessages.*;
import static _Exam_19December2023.climbers.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    private ClimberRepository climberRepository;
    private MountainRepository mountainRepository;
    private int climbedMountain;
    public ControllerImpl(){
        this.climberRepository = new ClimberRepository();
        this.mountainRepository = new MountainRepository();
        this.climbedMountain = 0;
    }
    @Override
    public String addClimber(String type, String climberName) {
        Climber climber;
        if (type.equals("RockClimber")){
            climber = new RockClimber(climberName);
        } else if (type.equals("WallClimber")){
            climber = new WallClimber(climberName);
        } else {
            throw new IllegalArgumentException(CLIMBER_INVALID_TYPE);
        }
        this.climberRepository.add(climber);
        return String.format(CLIMBER_ADDED, type, climberName);
    }

    @Override
    public String addMountain(String mountainName, String... peaks) {
        Mountain mountain = new MountainImpl(mountainName);
        mountain.getPeaksList().addAll(List.of(peaks));
        this.mountainRepository.add(mountain);
        return String.format(MOUNTAIN_ADDED, mountainName);
    }

    @Override
    public String removeClimber(String climberName) {
        Climber climber = this.climberRepository.byName(climberName);
        if (climber == null){
            throw new IllegalArgumentException(String.format(CLIMBER_DOES_NOT_EXIST, climberName));
        }
        this.climberRepository.remove(climber);
        return String.format(CLIMBER_REMOVE, climberName);
    }

    @Override
    public String startClimbing(String mountainName) {
        Mountain mountain = mountainRepository.byName(mountainName);
        if (this.climberRepository.getCollection().isEmpty()){
            throw new IllegalArgumentException(THERE_ARE_NO_CLIMBERS);
        }
        Climbing climbing = new ClimbingImpl();
        int removedCount = 0;
        climbing.conqueringPeaks(mountain, this.climberRepository.getCollection());
        for (Climber climber : this.climberRepository.getCollection()){
            if (climber.getStrength() == 0){
                removedCount++;
            }
        }
        this.climbedMountain++;
        return String.format(PEAK_CLIMBING, mountainName, removedCount);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_MOUNTAIN_COUNT, this.climbedMountain)).append(System.lineSeparator());
        sb.append(FINAL_CLIMBERS_STATISTICS).append(System.lineSeparator());
        for (Climber climber : this.climberRepository.getCollection()){
            sb.append(String.format(FINAL_CLIMBER_NAME, climber.getName())).append(System.lineSeparator());
            sb.append(String.format(FINAL_CLIMBER_STRENGTH, climber.getStrength())).append(System.lineSeparator());
            if (!climber.getRoster().getPeaks().isEmpty()) {
                sb.append(String.format(FINAL_CLIMBER_PEAKS,String.join(FINAL_CLIMBER_FINDINGS_DELIMITER, climber.getRoster().getPeaks()))).append(System.lineSeparator());
            } else {
                sb.append(String.format(FINAL_CLIMBER_PEAKS, "None")).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
