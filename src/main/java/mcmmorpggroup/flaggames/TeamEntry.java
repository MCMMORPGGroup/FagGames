package mcmmorpggroup.flaggames;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

/**
 * チームの基礎です。<br>
 * extendsして使ってください
 * @author misterT2525
 */
public class TeamEntry {
    //メインスコアボード
    private Scoreboard scoreboard;
    //チーム
    private Team team;
    
    public TeamEntry(String teamname,String prefix,String suffix){
        scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        team = scoreboard.getTeam(teamname);
        if(team==null)team = scoreboard.registerNewTeam(teamname);
        team.setPrefix(prefix);
        team.setSuffix(suffix);
    }
    /**
     * チームにプレイヤーを追加します。
     * @param player 追加するプレイヤー
     */
    public void addPlayer(OfflinePlayer player){
        team.addPlayer(player);
    }
    /**
     * チームからプレイヤーを削除します。
     * @param player 削除するプレイヤー
     */
    public void removePlayer(OfflinePlayer player){
        team.removePlayer(player);
    }
    /**
     * チームのプレイヤーの人数を取得します。
     * @return 人数
     */
    public int size(){
        return team.getSize();
    }
    /**
     * 入っているプレイヤーのリストを取得します。
     * @return プレイヤーリスト
     */
    public List<OfflinePlayer> Players(){
        return (List<OfflinePlayer>) team.getPlayers();
    }
    /**
     * そのプレイヤーが入っているか確認します。
     * @param player 確認するプレイヤー
     * @return 結果
     */
    public boolean hasPlayer(OfflinePlayer player){
        return team.hasPlayer(player);
    }
}