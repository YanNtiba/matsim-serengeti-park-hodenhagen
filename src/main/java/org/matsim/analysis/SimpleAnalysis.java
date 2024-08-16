package org.matsim.analysis;

import org.matsim.analysis.LinkEventHandler;
import org.matsim.core.events.EventsUtils;

public class SimpleAnalysis {

    public static void main(String[] args) {

        // Create instances of both handlers
        var personHandler = new SimplePersonEventHandler();
        var linkHandler = new LinkEventHandler();

        // Create an instance of the EventsManager
        var manager = EventsUtils.createEventsManager();

        // Add both handlers to the EventsManager
        manager.addHandler(personHandler);
        manager.addHandler(linkHandler);

        // Read the events file and process it
        EventsUtils.readEvents(manager, "C:\\Users\\yanni\\OneDrive - Simon Fraser University (1sfu)\\Simon Fraser University (1sfu)\\Yan\\ABM\\Examples\\scenarios\\serengeti-park-v1.0\\output\\output-serengeti-park-v1.0-run1\\serengeti-park-v1.0-run1.output_events.xml.gz");

        // Process and print results from SimplePersonEventHandler
        System.out.println("SimplePersonEventHandler Results:");
        // (You could add any specific processing or analysis you'd like here)

        // Process and print results from LinkEventHandler
        System.out.println("LinkEventHandler Results:");
        var volumes = linkHandler.getVolumes();
        volumes.forEach((hour, count) -> System.out.println("Hour: " + hour + ", Volume: " + count));
    }
}
