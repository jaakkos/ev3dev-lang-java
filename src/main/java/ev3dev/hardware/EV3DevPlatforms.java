package ev3dev.hardware;

import ev3dev.utils.Sysfs;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import org.slf4j.Logger;

public abstract class EV3DevPlatforms extends EV3DevFileSystem {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(EV3DevPlatforms.class);

    /**
     * This method returns the platform
     *
     * @return Platform used
     * @throws RuntimeException Exception
     */
    protected EV3DevPlatform getPlatform() {

        //TODO Duplicated code
        final String BATTERY =  "/power_supply";
        final String BATTERY_PATH = ROOT_PATH + BATTERY;
        final String BATTERY_EV3 =  "legoev3-battery";
        final String BATTERY_PISTORMS =  "pistorms-battery";
        final String BATTERY_BRICKPI =  "brickpi-battery";
        final String BATTERY_BRICKPI3 =  "brickpi3-battery";
        final String EV3BRICK_DISCOVERY_PATTERN_PATH = BATTERY_PATH + "/" + BATTERY_EV3;
        final String PISTORMS_DISCOVERY_PATTERN_PATH = BATTERY_PATH + "/" + BATTERY_PISTORMS;
        final String BRICKPI_DISCOVERY_PATTERN_PATH = BATTERY_PATH + "/" + BATTERY_BRICKPI;
        final String BRICKPI3_DISCOVERY_PATTERN_PATH = BATTERY_PATH + "/" + BATTERY_BRICKPI3;


        if(log.isTraceEnabled())
            log.trace(BRICKPI3_DISCOVERY_PATTERN_PATH);
            log.trace("Detected platform: " + EV3DevPlatform.BRICKPI3);
        return EV3DevPlatform.BRICKPI3;
    }

    protected String getMotorPort(final Port port) {

        if (port.equals(MotorPort.A)) {
            return "spi0.1:MA";
        } else if (port.equals(MotorPort.B)) {
            return "spi0.1:MB";
        } else if (port.equals(MotorPort.C)) {
            return "spi0.1:MC";
        } else if (port.equals(MotorPort.D)) {
            return "spi0.1:MD";
        }


        //TODO Improve
        return null;
    }

    protected String getSensorPort(final Port port) {

        if (port.equals(SensorPort.S1)) {
            return "spi0.1:S1";
        } else if (port.equals(SensorPort.S2)) {
            return "spi0.1:S2";
        } else if (port.equals(SensorPort.S3)) {
            return "spi0.1:S3";
        } else if (port.equals(SensorPort.S4)) {
            return "spi0.1:S4";
        }


        //TODO Improve
        return null;
    }

}
