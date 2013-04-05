package hudson.plugins.copyProjectLink;

import hudson.model.Action;
import hudson.model.Item;
import hudson.model.ItemGroup;
import hudson.model.AbstractProject;
import hudson.model.Hudson;
import hudson.security.AccessControlled;

public class CopyProjectAction implements Action {

	final private AbstractProject<?, ?> project;

	public CopyProjectAction(AbstractProject project) {
		this.project = project;
	}

	public String getCloneName() {
		return project.getDisplayName() + "-clone";
	}

	public String getProjectName() {
		return project.getDisplayName();
	}

	public String getIconFileName() {
		if (hasPermission()) {
			return "/plugin/copy-project-link/img/edit-copy.png";
		}
		return null;
	}

	public String getDisplayName() {
		if (hasPermission()) {
			return "Copy project";
		}
		return null;
	}

	public String getUrlName() {
		if(hasPermission()) {
			return "copy-project";
		}
		return null;
	}

	private boolean hasPermission(){
    ItemGroup parent = project.getParent();
    if (parent instanceof AccessControlled) {
      AccessControlled accessControlled = (AccessControlled)parent;
      return accessControlled.hasPermission(Item.CREATE);
    }
    return Hudson.getInstance().hasPermission(Item.CREATE);
	}
	
}
