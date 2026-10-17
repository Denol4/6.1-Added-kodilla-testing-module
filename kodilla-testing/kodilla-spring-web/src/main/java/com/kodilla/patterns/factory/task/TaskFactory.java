package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("Zakupy spożywcze", "Chleb", 2.0);
            case PAINTING:
                return new PaintingTask("Malowanie pokoju", "Biały", "Ściana w salonie");
            case DRIVING:
                return new DrivingTask("Wyjazd służbowy", "Warszawa", "Samochód");
            default:
                return null;
        }
    }
}