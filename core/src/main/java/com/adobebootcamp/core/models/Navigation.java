package com.adobebootcamp.core.models;

import com.adobebootcamp.core.utils.ApplicationConstants;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * Created by BSijtsma on 26-04-2017.
 */

@Model(adaptables = {SlingHttpServletRequest.class})
public class Navigation {

    private static final int DEFAULT_TOP_LEVEL = ApplicationConstants.DEFAULT_TOP_LEVEL;

    private static final Logger LOGGER = LoggerFactory.getLogger(Navigation.class);

    @Inject
    private Page currentPage;

    public Navigation(SlingHttpServletRequest request) {}

    public NavigationItem getTopPage() {
        if(currentPage != null){
            return new NavigationItem(currentPage.getAbsoluteParent(DEFAULT_TOP_LEVEL), currentPage.getPath());
        } else {
            LOGGER.debug("Cant find top page, maybe this page is below the parent page. (currentpage: "+currentPage.getPath()+")");
        }
        return null;
    }

    public boolean hasTopLevelPage() {
        if(getTopPage() != null)
            return true;
        return false;
    }
}
