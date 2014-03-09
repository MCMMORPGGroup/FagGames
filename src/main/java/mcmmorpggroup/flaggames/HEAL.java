package mcmmorpggroup.flaggames;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * 対象プレイヤーを全回復させるコマンド
 * @author kojima1021 and misterT2525
 */
public class HEAL implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(cmd.getName().equalsIgnoreCase("heal")){
            if(!sender.hasPermission("FlagGame.admin.heal")){
                sender.sendMessage(ChatColor.AQUA + "[FlagGames]"
                + ChatColor.RED + "あなたは、このコマンドを実行する権限を所有していません。(FlagGame.admin.heal)");
                return true;
            }
            if (args.length < 1){//引数なしの場合
            sender.sendMessage(ChatColor.AQUA + "[FlagGames]"
            	+ ChatColor.RED + "プレーヤー名を指定してください。 /heal <player>" );
            return true;
            } else if (args.length > 0) {
                Player target = sender.getServer().getPlayer(args[0]);
                // 対象プレイヤーがオンラインかどうかを確認します。
                if (target == null) {
                    sender.sendMessage(ChatColor.AQUA + "[FlagGames]" + ChatColor.RESET
                   + args[0] + " というプレイヤーは見つかりません！");
                    return true;
                }
                target.setHealth(20);
                target.setFoodLevel(20);
                sender.sendMessage(ChatColor.AQUA + "[FlagGames]" + ChatColor.RESET
                + args[0] + " のプレーヤーのHPを全回復させました。");
    }
            return true;
        }
        return false;
    }
}
