package com.adobebootcamp.core.models;

import com.adobebootcamp.core.utils.ApplicationConstants;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by BSijtsma on 26-04-2017.
 */

@Model(adaptables = {SlingHttpServletRequest.class})
public class NavigationItem {

    private String currentPagePath;
    private Page page;
    private static final int DEFAULT_TOP_LEVEL = ApplicationConstants.DEFAULT_TOP_LEVEL;
    private static final Logger LOGGER = LoggerFactory.getLogger(NavigationItem.class);

    public NavigationItem(Page page, String currentPagePath ) {
        this.page = page;
        this.currentPagePath = currentPagePath;
    }

    /**
     * Gets the title of this page.
     * @return the title.
     */
    public String getTitle() {
        if(page.getNavigationTitle() != null) {
            return page.getNavigationTitle();
        }
        return page.getTitle();
    }

    public String getPageName() {
        if(page != null)
            return page.getName();
        return "";
    }

    /**
     * Get the path of this page.
     * @return this page path.
     */
    public String getPath() {
        if (page != null) {
            return page.getPath();
        }
        return "";
    }

    /**
     * Checks if the page is active.
     * @return true if the page is active.
     */
    public boolean isActive() {
        if(page.getDepth() <= (DEFAULT_TOP_LEVEL+1)) {
            return currentPagePath.equals(page.getPath());
        } else {
            return currentPagePath.contains(page.getPath());
        }
    }

    /**
     * Exception for the top submenu item, as the isActive class will always
     * return true for it.
     * @return true if the exact pagepath is active
     */
    public boolean isActiveSubItem() {
        if (page != null) {
            return currentPagePath.equals(page.getPath());
        }
        return false;
    }

    /**
     * returns the page inside this Navigation item.
     * @return the page inside this Navigation item.
     */
    public Page getPage() {
        return page;
    }

    /**
     * Creates a list of this pages children.
     * @return a list with {@link NavigationItem}s that contains the child pages.
     */
    public List<NavigationItem> getChildPages() {
        List<NavigationItem> children = new ArrayList<NavigationItem>();
        if(page != null) {
            Iterator<Page> childPages = page.listChildren();
            while(childPages.hasNext()) {
                Page child = childPages.next();
                if(!child.isHideInNav()) {
                    children.add(new NavigationItem(child, currentPagePath));
                }
            }
        }
        return children;
    }

    /**
     * Check if the navigation item has children.
     * @return true if this item has children.
     */
    public boolean hasChildren() {
        if(getChildPages().size() > 0)
            return  true;
        return false;
    }

}
