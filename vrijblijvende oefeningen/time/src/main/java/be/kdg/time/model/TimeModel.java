package be.kdg.time.model;

import java.time.Duration;
import java.time.LocalTime;

public class TimeModel {
    private LocalTime currentTime;

    // Sunrise and sunset are exaggerated (unless you're close to the North/South Pole).
    public static final LocalTime DAWN = LocalTime.of(6, 0);
    public static final LocalTime SUNRISE = LocalTime.of(8, 0);
    public static final LocalTime NOON = LocalTime.of(12, 30);
    public static final LocalTime SUNSET = LocalTime.of(17, 0);
    public static final LocalTime DUSK = LocalTime.of(19, 0);

    public TimeModel() {
        this.currentTime = LocalTime.now();
    }

    public LocalTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
    }

    /**
     * Returns a number from 0.0 to 1.0. At night 0.0 is returned, and during the day 1.0 is returned.
     * At dawn and dusk a value between 0.0 and 1.0 is returned.
     */
    public double getDaylightPercentage() {
        if (currentTime.isBefore(TimeModel.DAWN) || currentTime.isAfter(TimeModel.DUSK)) {
            return 0.0;
        }
        else if (currentTime.isBefore(TimeModel.SUNRISE)) {
            final long twilightDurationMinutes = Duration.between(TimeModel.DAWN, TimeModel.SUNRISE).toMinutes();
            final long minutesFromDawn = Duration.between(TimeModel.DAWN, currentTime).toMinutes();
            return (double)minutesFromDawn / twilightDurationMinutes;
        }
        else if (currentTime.isAfter(TimeModel.SUNSET)) {
            final long twilightDurationMinutes = Duration.between(TimeModel.SUNSET, TimeModel.DUSK).toMinutes();
            final long minutesFromSunset = Duration.between(TimeModel.SUNSET, currentTime).toMinutes();
            return 1.0 - (double)minutesFromSunset / twilightDurationMinutes;
        }
        else {
            return 1.0;
        }
    }

    /**
     * Returns a number from 0.0 to 1.0. If the sun is below the horizon (night time), 0.0 is returned.
     * At noon 1.0 is returned. At other moments in time, a value between 0.0 and 1.0 is returned.
     */
    public double getSunHeight() {
        if (currentTime.isAfter(TimeModel.SUNRISE) && currentTime.isBefore(TimeModel.SUNSET)) {
            final long differenceSunriseNoonMinutes = Duration.between(TimeModel.SUNRISE, TimeModel.NOON).toMinutes();
            final long minutesFromSunrise = Duration.between(TimeModel.SUNRISE, currentTime).toMinutes();
            final double cornerDegrees = 90.0 - (90.0 * (differenceSunriseNoonMinutes - minutesFromSunrise)) / differenceSunriseNoonMinutes;
            return Math.sin(Math.toRadians(Math.abs(cornerDegrees)));
        }
        else {
            return 0.0;
        }
    }

    /**
     * Returns a number from -1.0 to 1.0, which indicates the horizontal location of the sun (East/West).
     * If the sun is all the way in the East, 1.0 is returned. If the sun is all the way in the West, -1.0 is returned.
     */
    public double getSunPositionX() {
        final long differenceSunriseNoonMinutes = Duration.between(TimeModel.SUNRISE, TimeModel.NOON).toMinutes();
        final long minutesFromSunrise = Duration.between(TimeModel.SUNRISE, currentTime).toMinutes();
        final double cornerDegrees = 90.0 - (90.0 * (differenceSunriseNoonMinutes - minutesFromSunrise)) / differenceSunriseNoonMinutes;
        return Math.cos(Math.toRadians(cornerDegrees));
    }
}
