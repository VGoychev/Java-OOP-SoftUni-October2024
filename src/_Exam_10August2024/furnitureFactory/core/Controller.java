package _Exam_10August2024.furnitureFactory.core;

import _Exam_10August2024.furnitureFactory.entities.factories.Factory;

public interface Controller {

    String buildFactory(String factoryType, String factoryName);

    Factory getFactoryByName(String factoryName);
    String buildWorkshop(String workshopType, int woodCapacity);
    String addWorkshopToFactory(String factoryName, String workshopType);
    String buyWoodForFactory(String woodType);
    String addWoodToWorkshop(String factoryName, String workshopType, String woodType);
    String produceFurniture(String factoryName);
    String getReport();
}
