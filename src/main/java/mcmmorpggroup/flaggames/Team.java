package mcmmorpggroup.flaggames;

import org.bukkit.Color;

public class Team {

	/**
	 * チームの色
	 */
	protected Color teamColor;

	/**
	 * チーム名
	 */
	protected String name;

	public Team(Color color, String name) {
		this.teamColor = color;
		this.name = name;
	}

	public Color getTeamColor() {
		return teamColor;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
