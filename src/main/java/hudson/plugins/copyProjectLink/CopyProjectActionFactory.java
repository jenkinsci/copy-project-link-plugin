package hudson.plugins.copyProjectLink;

import hudson.Extension;
import hudson.model.TransientProjectActionFactory;
import hudson.model.AbstractProject;

import java.util.Collection;
import java.util.Collections;

@Extension
public class CopyProjectActionFactory extends TransientProjectActionFactory{
	
	/**
	 * {@inheritDoc}}
	 */
	@Override
	public Collection<CopyProjectAction> createFor(AbstractProject target){
    return Collections.singleton(new CopyProjectAction(target));
	}

}
