package mesosphere.marathon.client.model.v2;

import java.util.Collection;
import java.util.Optional;

import mesosphere.client.common.ModelUtils;

public class Group {
	private String id;
	private Collection<App> apps;
	private Collection<Group> groups;
	private Collection<String> dependencies;
	private String version;

	public Group() {
	}

	public Optional<App> findAppByName(String name) {
		for (App app : apps) {
			final String[] split = app.getId().split("/");
			String appName = split[split.length - 1];
			if (appName.equals(name)) {
				return Optional.of(app);
			}
		}
		return Optional.empty();
	}

	public Group(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Collection<App> getApps() {
		return apps;
	}

	public void setApps(Collection<App> apps) {
		this.apps = apps;
	}
	
	public Collection<Group> getGroups() {
		return groups;
	}

	public void setGroups(Collection<Group> groups) {
		this.groups = groups;
	}

	public Collection<String> getDependencies() {
		return dependencies;
	}

	public void setDependencies(Collection<String> dependencies) {
		this.dependencies = dependencies;
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
