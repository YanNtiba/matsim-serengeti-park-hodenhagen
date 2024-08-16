package org.matsim.analysis;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.LinkLeaveEvent;
import org.matsim.api.core.v01.events.handler.LinkLeaveEventHandler;
import org.matsim.api.core.v01.network.Link;

import java.util.HashMap;
import java.util.Map;

public class LinkEventHandler implements LinkLeaveEventHandler {

    private static final Id<Link> linkOfInterest = Id.createLinkId("2344590910000f");

    private final Map<String, Integer> volumes = new HashMap<>();

    public LinkEventHandler() {
        // Initialize the volumes map for all 24 hours with zero counts
        for (int i = 0; i < 24; i++) {
            volumes.put(Integer.toString(i), 0);
        }
    }

    public Map<String, Integer> getVolumes() {
        return volumes;
    }

    @Override
    public void handleEvent(LinkLeaveEvent event) {
        if (event.getLinkId().equals(linkOfInterest)) {
            String key = getKey(event.getTime());
            volumes.merge(key, 1, Integer::sum);
        }
    }

    private String getKey(double time) {
        return Integer.toString((int) (time / 3600));
    }
}
