package hudson.plugins.copyProjectLink;

import hudson.model.Action;
import hudson.model.Item;
import hudson.model.ItemGroup;
import hudson.model.AbstractItem;
import hudson.model.Hudson;
import hudson.security.AccessControlled;

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

	public String getIconFileName() {
		if (hasPermission()) {
			return "/plugin/copy-project-link/img/edit-copy.png";
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
    ItemGroup parent = item.getParent();
    if (parent instanceof AccessControlled) {
      AccessControlled accessControlled = (AccessControlled)parent;
      return accessControlled.hasPermission(Item.CREATE);
    }
    return Hudson.getInstance().hasPermission(Item.CREATE);
	}
	
}
