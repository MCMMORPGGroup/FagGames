package mcmmorpggroup.flaggames;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Killplayer implements CommandExecutor{
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(cmd.getName().equalsIgnoreCase("KillPlayer")){
            if (args.length > 0) {
                Player target = sender.getServer().getPlayer(args[0]);
                // 対象プレイヤーがオンラインかどうかを確認します。
                if (target == null) {
                    sender.sendMessage(args[0] + " というプレイヤーは見つかりません！");
                    return true;
                }
                target.setHealth(0);
            }
            return true;
        }
        return true;
    }
}

