package mcmmorpggroup.flaggames;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Block;

/**
 * フラグ関連を処理をするクラス
 * @author misterT2525
 */
public class FlagManager {
    //フラグブロックリスト
    private final List<Block> flags;
    
    public FlagManager(){
        flags = new ArrayList<Block>();
    }
    /**
     * フラグを登録します
     * @param flag 登録するフラグ
     */
    public void addFlag(Block flag){
        flags.add(flag);
    }
    /**
     * ビーコンブロックから赤羊毛に変更します<br>
     * フラグとして登録されて無い場合は実行されません
     * @param flag 変更するブロック
     */
    public void BeaconToRed(Block flag){
        //フラグ登録されてない場合は処理しない
        if(!flags.contains(flag)){
            return;
        }
        //元がビーコンじゃない場合に処理しない
        if(!flag.getType().equals(Material.BEACON)){
            return;
        }
        flag.setType(Material.WOOL);
        flag.setData(DyeColor.RED.getData());
    }
    /**
     * ビーコンブロックから青羊毛に変更します<br>
     * フラグとして登録されて無い場合は実行されません
     * @param flag 変更するブロック
     */
    public void BeaconToBlue(Block flag){
        //フラグ登録されてない場合は処理しない
        if(!flags.contains(flag)){
            return;
        }
        //元がビーコンじゃない場合に処理しない
        if(!flag.getType().equals(Material.BEACON)){
            return;
        }
        flag.setType(Material.WOOL);
        flag.setData(DyeColor.BLUE.getData());
    }
    /**
     * 赤羊毛からビーコンに変更します<br>
     * フラグとして登録されて無い場合は実行されません
     * @param flag 
     */
    public void RedToBeacon(Block flag){
        //フラグ登録されてない場合は処理しない
        if(!flags.contains(flag)){
            return;
        }
        //元が赤羊毛じゃない場合に処理しない
        if(!flag.getType().equals(Material.WOOL)||flag.getData()!=DyeColor.RED.getData()){
            return;
        }
        flag.setType(Material.BEACON);
    }
    /**
     * 青羊毛からビーコンに変更します<br>
     * フラグとして登録されて無い場合は実行されません
     * @param flag 
     */
    public void BlueToBeacon(Block flag){
        //フラグ登録されてない場合は処理しない
        if(!flags.contains(flag)){
            return;
        }
        //元が赤羊毛じゃない場合に処理しない
        if(!flag.getType().equals(Material.WOOL)||flag.getData()!=DyeColor.BLUE.getData()){
            return;
        }
        flag.setType(Material.BEACON);
    }
    /**
     * ブロックがフラグかどうかを判断します
     * @param block 確認したいブロック
     * @return 結果
     */
    public boolean isFlag(Block block){
        return flags.contains(block);
    }
}