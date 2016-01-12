package hudson.plugins.copyProjectLink;

import hudson.Extension;
import hudson.model.Action;
import hudson.model.TopLevelItem;
import hudson.model.TransientProjectActionFactory;
import hudson.model.AbstractProject;

import java.util.Collection;
import java.util.Collections;

@Extension
public class CopyProjectActionFactory extends TransientProjectActionFactory{
    @Override
    public Collection<? extends Action> createFor(@SuppressWarnings("rawtypes") AbstractProject target){
        return target instanceof TopLevelItem
                ? Collections.singleton(new CopyAction<AbstractProject<?, ?>>(target))
                : Collections.<Action>emptyList()
        ;
    }
}
