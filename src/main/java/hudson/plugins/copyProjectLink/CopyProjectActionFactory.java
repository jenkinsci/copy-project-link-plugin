package hudson.plugins.copyProjectLink;

import hudson.Extension;
import hudson.model.TransientProjectActionFactory;
import hudson.model.AbstractProject;

import java.util.ArrayList;
import java.util.Collection;

@Extension
public class CopyProjectActionFactory extends TransientProjectActionFactory{
	
	/**
	 * {@inheritDoc}}
	 */
	@Override
	public Collection<CopyProjectAction> createFor(AbstractProject target){
		ArrayList<CopyProjectAction> ta = new ArrayList<CopyProjectAction>();
		ta.add(new CopyProjectAction(target));
		return ta;
	}

}
