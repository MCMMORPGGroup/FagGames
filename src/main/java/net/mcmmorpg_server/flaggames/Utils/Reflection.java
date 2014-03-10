package net.mcmmorpg_server.flaggames.Utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import net.mcmmorpg_server.flaggames.FlagGames;
import net.mcmmorpg_server.flaggames.Utils.Enum.PacketType;
import net.mcmmorpg_server.flaggames.Utils.Enum.VersionType;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Reflection {

	FlagGames plugin;

	public Reflection (FlagGames plugin) {
		this.plugin = plugin;
	}

	/**
	 * プレイヤーにパケットを送信するメソッド
	 * Reflectionを使用します
	 * @param Player
	 * @param Packet
	 * @throws Exception
	 */
	public void sendPacket(Player p, Object packet) throws Exception{
		Object eplayer = getEntityPlayer(p);
		Field playerConnectionField = eplayer.getClass().getField("playerConnection");
		Object playerConnection = playerConnectionField.get(eplayer);
		for (Method m : playerConnection.getClass().getMethods()) {
			if (m.getName().equalsIgnoreCase("sendPacket")) {
				m.invoke(playerConnection, packet);
				return;
			}
		}
	}

	/**
	 * プレイヤーにパケットを送信するメソッド
	 * Reflectionを使用します
	 * @param Packet
	 * @throws Exception
	 */
	public void sendAllPacket(Object packet) throws Exception{
		for (Player player : Bukkit.getOnlinePlayers()) {
			sendPacket(player, packet);
		}
	}

	/**
	 * プレイヤーのHandleを取得
	 * @param Player
	 * @return PlayerHandle
	 * @throws Exception
	 */
	public Object getEntityPlayer(Player p) throws Exception{
		Method getHandle = p.getClass().getMethod("getHandle");
		return getHandle.invoke(p);
	}

	/**
	 * パッケージ名を返す
	 * @return PackageName
	 */
	public String getPackageName(){
		String packagename = "net.minecraft.server."+getCraftBukkitVersion();
		return packagename;
	}

	/**
	 * CraftBukkitバージョンを返す
	 * 例: v1_6_R2
	 * @return CraftBukkitVersion
	 */
	public String getCraftBukkitVersion(){
		String version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
		return version;
	}

	/**
	 * VersionTypeを返します
	 * 例: VersionType.v1_6
	 * 用例: パケットなどバージョン依存なものの判定
	 * @return
	 */
	public VersionType getVersion(){
		String ver = getCraftBukkitVersion();
		ver = ver.substring(0, 4);
		for (VersionType type : VersionType.values()) {
			if(type.getName().equalsIgnoreCase(ver)){
				return type;
			}
		}
		return VersionType.UNKNOWN;
	}

	/**
	 * 指定されたフィールドをセットします
	 * @param Instance
	 * @param FieldName
	 * @param Value
	 * @throws Exception
	 */
	public void setValue(Object instance, String fieldName, Object value) throws Exception {
		Field field = instance.getClass().getDeclaredField(fieldName);
		field.setAccessible(true);
		field.set(instance, value);
	}

	/**
	 * 指定されたフィールドを取得します
	 * @param Instance
	 * @param FieldName
	 * @return FieldData
	 * @throws Exception
	 */
	public Object getValue(Object instance, String fieldName) throws Exception {
		Field field = instance.getClass().getDeclaredField(fieldName);
		field.setAccessible(true);
		return field.get(instance);
	}

	/**
	 * パケットを取得します
	 * @param PacketType(PacketName)
	 * @return Instance
	 * @throws Exception
	 */
	public Object getPacket(PacketType pt) throws Exception {
		Class<?> packet = Class.forName(getPackageName()+"."+pt.getPacketName());
		return packet.getConstructors()[0].newInstance();
	}

	/**
	 * CraftClassを取得します
	 * @param String
	 * @return CraftClass
	 * @throws Exception
	 */
	public Class<?> getCraftClass(String s) throws Exception {
		Class<?> craftclass = Class.forName(getPackageName()+"."+s);
		return craftclass;
	}

	/**
	 * プレイヤーの言語を取得する
	 * @param Player
	 * @return Locale
	 */
	public String getPlayerLanguage(Player p){
		try {
			Object o = getEntityPlayer(p);
			String s = (String) getValue(o, "locale");
			return s;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * メソッドを取得する
	 * @param Class
	 * @param Method
	 * @param Args
	 * @return Method
	 */
	public Method getMethod(Class<?> cl, String method, Class<?>[] args) {
		for (Method m : cl.getMethods()) {
			if (m.getName().equals(method) && ClassListEqual(args, m.getParameterTypes())) {
				return m;
			}
		}
		return null;
	}

	/**
	 * Class
	 * @param Class
	 * @param Class
	 * @return boolean
	 */
	public boolean ClassListEqual(Class<?>[] l1, Class<?>[] l2) {
		boolean equal = true;
		if (l1.length != l2.length)
			return false;
		for (int i = 0; i < l1.length; i++) {
			if (l1[i] != l2[i]) {
				equal = false;
				break;
			}
		}
		return equal;
	}
}
