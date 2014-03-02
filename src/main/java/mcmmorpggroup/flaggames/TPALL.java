package mcmmorpggroup.flaggames;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * 全員をtpするコマンド
 * @author kojima1021 and misterT2525
 */
public class TPALL implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String lavel, String[] args){
        if(cmd.getName().equalsIgnoreCase("tpall")) {
            if(!(sender instanceof Player)){
                //プレイヤー以外の排除
                sender.sendMessage(ChatColor.RED + "このコマンドはプレイヤーのみ実行出来ます。");
                return true;
            }
            if(!(sender.hasPermission("FlagGame.admin.tpall"))){
                //権限非所有者を排除
                sender.sendMessage(ChatColor.RED + "あなたは、このコマンドを実行する権限を所有していません。(FlagGame.admin.tpall)");
                return true;
            }
            Player SenderPlayer = (Player)sender;
            for(Player p : Bukkit.getServer().getOnlinePlayers()) {
                p.teleport(SenderPlayer.getLocation());
            }
            sender.sendMessage(ChatColor.AQUA + "全プレイヤーをtpしました。");
            return true;
        }
        return false;
    }
}
