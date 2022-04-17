package hudson.plugins.copyProjectLink;

import hudson.model.Action;
import hudson.model.Item;
import hudson.model.ItemGroup;
import hudson.model.AbstractItem;
import hudson.security.AccessControlled;
import jenkins.model.Jenkins;

public class CopyAction<T extends AbstractItem> implements Action {

    final private T item;

    public CopyAction(T item) {
        this.item = item;
    }

    public String getCloneName() {
        return item.getName() + "-clone";
    }

    public T getItem() {
        return item;
    }

    public String getItemName() {
        return item.getName();
    }

    @Override
    public String getIconFileName() {
        return null;
    }

    public String getIconClassName() {
        if (hasPermission()) {
            return "icon-clipboard";
        }
        return null;
    }

    public String getDisplayName() {
        if (hasPermission()) {
            return "Copy " + item.getPronoun();
        }
        return null;
    }

    public String getUrlName() {
        if(hasPermission()) {
            return "copy";
        }
        return null;
    }

    private boolean hasPermission(){
        ItemGroup<?> parent = item.getParent();
        if (parent instanceof AccessControlled) {
            AccessControlled accessControlled = (AccessControlled)parent;
            return accessControlled.hasPermission(Item.CREATE);
        }
        return Jenkins.get().hasPermission(Item.CREATE);
    }
}
