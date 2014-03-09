package mcmmorpggroup.flaggames;

import java.util.HashSet;

public final class TeamManager {

	private HashSet<Team> teams = new HashSet<>();

	public TeamManager() {
	}

	/**
	 * チームを追加します。
	 * @param team 追加するチーム
	 * @return 既にチームが存在する場合はfalse
	 */
	public boolean addTeam(Team team) {
		return teams.add(team);
	}

	/**
	 * チームを削除します。
	 * @param team 削除するチーム
	 * @return 削除できたらtrue
	 */
	public boolean removeTeam(Team team) {
		return teams.remove(team);
	}

}
