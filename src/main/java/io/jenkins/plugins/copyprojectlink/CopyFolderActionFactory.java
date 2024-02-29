package io.jenkins.plugins.copyprojectlink;

import com.cloudbees.hudson.plugins.folder.Folder;
import hudson.Extension;
import hudson.model.Action;
import java.util.Collection;
import java.util.Collections;
import jenkins.model.TransientActionFactory;

@Extension(optional = true)
public class CopyFolderActionFactory extends TransientActionFactory<Folder> {
    @Override
    public Class<Folder> type() {
        return Folder.class;
    }

    @Override
    public Collection<? extends Action> createFor(Folder target) {
        return Collections.singleton(new CopyAction<Folder>(target));
    }
}
