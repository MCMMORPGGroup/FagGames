package mcmmorpggroup.flaggames;

import java.util.HashSet;

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

	/**
	 * このチームのフラグのリスト
	 */
	protected HashSet<Flag> flags;

	public Team(Color color, String name) {
		this.teamColor = color;
		this.name = name;
	}

	/**
	 * チームの色を取得します。
	 * @return チームの色
	 */
	public Color getTeamColor() {
		return teamColor;
	}

	/**
	 * チーム名を返します。
	 * @return チーム名
	 */
	public String getName() {
		return name;
	}

	/**
	 * フラグを追加します。
	 * @return 既にフラグか追加されている場合はfalse
	 */
	public boolean addFlag(Flag flag) {
		return flags.add(flag);
	}

	/**
	 * フラグを削除します。
	 * @param flag 削除するフラグ
	 * @return フラグが削除できた場合はtrue
	 */
	public boolean removeFlag(Flag flag) {
		return flags.remove(flag);
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
