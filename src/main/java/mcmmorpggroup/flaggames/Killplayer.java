package mcmmorpggroup.flaggames;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * 対象プレイヤーをkillするコマンド
 * @author kojima1021 and misterT2525
 */
public class Killplayer implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(cmd.getName().equalsIgnoreCase("KillPlayer")){
            if(!sender.hasPermission("FlagGame.admin.kill")){
                sender.sendMessage(ChatColor.AQUA + "[FlagGames]"
                + ChatColor.RED + "あなたは、このコマンドを実行する権限を所有していません。(FlagGame.admin.kill)");
                return true;
            }
            if (args.length > 0) {
                Player target = sender.getServer().getPlayer(args[0]);
                // 対象プレイヤーがオンラインかどうかを確認します。
                if (target == null) {
                    sender.sendMessage(ChatColor.AQUA + "[FlagGames]" + ChatColor.RESET
                   + args[0] + " というプレイヤーは見つかりません！");
                    return true;
                }
                target.setHealth(0);
            }
            return true;
        }
        return false;
    }
}
