package hudson.plugins.copyProjectLink;

import hudson.Extension;
import hudson.model.Action;
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
	public Collection<? extends Action> createFor(AbstractProject target){
    return Collections.singleton(new CopyAction<AbstractProject>(target));
	}

}
