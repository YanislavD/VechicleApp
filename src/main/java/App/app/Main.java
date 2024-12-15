package App.app;

import App.core.Controller;
import App.core.ControllerImpl;
import App.core.Engine;
import App.core.EngineImpl;
import App.service.FleetManager;
import App.service.FleetManagerImpl;

public class Main {


    public static void main(String[] args) {

        FleetManager fleetManager = new FleetManagerImpl();
        ControllerImpl controller = new ControllerImpl(fleetManager);
        Engine engine = new EngineImpl(controller);

        engine.run();
    }
}
