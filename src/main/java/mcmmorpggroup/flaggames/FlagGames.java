package mcmmorpggroup.flaggames;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlagGames implements CommandExecutor
{	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		String prefix = ChatColor.AQUA + "[FlagGames]"+ChatColor.RESET;
		 if(cmd.getName().equalsIgnoreCase("flaggames"))
	           if (args.length < 1){
	               sender.sendMessage(prefix + ChatColor.WHITE + "コマンド一覧は "+ ChatColor.YELLOW +" /flaggames help"+ChatColor.WHITE + "でヘルプを参照して下さい");
	               return true;
	           } else if (args[0].equalsIgnoreCase("help")){
	               if(!sender.hasPermission("FlagGame.admin.help")){
	                   sender.sendMessage(ChatColor.AQUA + "[FlagGames]"
	                   + ChatColor.RED + "あなたは、このコマンドを実行する権限を所有していません。(FlagGame.admin.help)");
	                   return true;
	               }
	               sender.sendMessage(prefix + ChatColor.AQUA + "- - - - - - - - " + ChatColor.WHITE +"FlagGames Help"+ ChatColor.AQUA+ " - - - - - - - -");
	               sender.sendMessage(prefix + ChatColor.YELLOW + "/flggames heal <player>");
	               sender.sendMessage(prefix + ChatColor.WHITE + "指定したプレーヤーを回復させます");
	               sender.sendMessage(prefix + ChatColor.YELLOW + "/flaggames kill <player>");
	               sender.sendMessage(prefix + ChatColor.WHITE + "指定したプレーヤーを殺すことができます。");
	               sender.sendMessage(prefix + ChatColor.YELLOW + "/flaggames tpall");
	               sender.sendMessage(prefix + ChatColor.WHITE + "全員を自分の場所へ呼ぶことができます。");
	               return true;
	           }
	        if (args[0].equalsIgnoreCase("heal")){
	            if(!sender.hasPermission("FlagGame.admin.heal")){
	                sender.sendMessage(ChatColor.AQUA + "[FlagGames]"
	                + ChatColor.RED + "あなたは、このコマンドを実行する権限を所有していません。(FlagGame.admin.heal)");
	                return true;
	            }
	            if (args.length < 1){//引数なしの場合
	            sender.sendMessage(ChatColor.AQUA + "[FlagGames]"
	            	+ ChatColor.RED + "プレーヤー名を指定してください。 /heal <player>" );
	            return true;
	            } else if (args.length > 1) {
	                Player target = sender.getServer().getPlayer(args[1]);
	                // 対象プレイヤーがオンラインかどうかを確認します。
	                if (target == null) {
	                    sender.sendMessage(ChatColor.AQUA + "[FlagGames]" + ChatColor.RESET
	                   + args[1] + " というプレイヤーは見つかりません！");
	                    return true;
	                }
	                target.setHealth(20);
	                target.setFoodLevel(20);
	                sender.sendMessage(ChatColor.AQUA + "[FlagGames]" + ChatColor.RESET
	                + args[1] + " のプレーヤーのHPを全回復させました。");
	                return true;
	    }
		        if (args[0].equalsIgnoreCase("kill")){
		            if(!sender.hasPermission("FlagGame.admin.kill")){
		                sender.sendMessage(ChatColor.AQUA + "[FlagGames]"
		                + ChatColor.RED + "あなたは、このコマンドを実行する権限を所有していません。(FlagGame.admin.kill)");
		                return true;
		            }
		            if (args.length < 1){//引数なしの場合
		            sender.sendMessage(ChatColor.AQUA + "[FlagGames]"
		            	+ ChatColor.RED + "プレーヤー名を指定してください。 /flaggames kill <player>" );
		            return true;
		            } else if (args.length > 1) {
		                Player target = sender.getServer().getPlayer(args[1]);
		                // 対象プレイヤーがオンラインかどうかを確認します。
		                if (target == null) {
		                    sender.sendMessage(ChatColor.AQUA + "[FlagGames]" + ChatColor.RESET
		                   + args[1] + " というプレイヤーは見つかりません！");
		                    return true;
		                }
		                target.setHealth(20);
		                target.setFoodLevel(20);
		                sender.sendMessage(ChatColor.AQUA + "[FlagGames]" + ChatColor.RESET
		                + args[1] + " を殺しました。");
		                return true;
		    }
			    }
		    }
			return false;
    }
}