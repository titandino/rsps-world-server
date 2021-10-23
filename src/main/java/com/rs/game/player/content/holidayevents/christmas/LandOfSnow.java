package com.rs.game.player.content.holidayevents.christmas;

import com.rs.cache.loaders.ItemDefinitions;
import com.rs.lib.game.Animation;
import com.rs.lib.game.Item;
import com.rs.lib.game.WorldTile;
import com.rs.lib.util.Utils;
import com.rs.plugin.annotations.PluginEventHandler;
import com.rs.plugin.annotations.ServerStartupEvent;
import com.rs.plugin.events.ObjectClickEvent;
import com.rs.plugin.events.XPGainEvent;
import com.rs.plugin.handlers.ObjectClickHandler;
import com.rs.plugin.handlers.XPGainHandler;
import com.rs.utils.Areas;
import com.rs.utils.spawns.NPCSpawn;
import com.rs.utils.spawns.NPCSpawns;
import com.rs.utils.spawns.ObjectSpawn;
import com.rs.utils.spawns.ObjectSpawns;

@PluginEventHandler
public class LandOfSnow {
	
	private static int TRADEABLE_REWARD = 1050;
	private static boolean ACTIVE = false;
	
	@ServerStartupEvent
	public static void initObjects() {
		if (!ACTIVE)
			return;
		WorldTile center = new WorldTile(3212, 3428, 3);
		for (int x = -10; x < 10; x++) {
			for (int y = -10; y < 10; y++) {
				ObjectSpawns.add(new ObjectSpawn(3701, 10, 1, center.transform(x * 3, y * 3, 0)));
			}
		}

		ObjectSpawns.add(new ObjectSpawn(12258, 10, 0, new WorldTile(3210, 3425, 0), "Cupboard to Christmas event."));
		
		ObjectSpawns.add(new ObjectSpawn(4483, 10, 0, new WorldTile(2648, 5667, 0), "Bank chest"));
		ObjectSpawns.add(new ObjectSpawn(70761, 10, 0, new WorldTile(2650, 5666, 0), "Bonfire"));
		ObjectSpawns.add(new ObjectSpawn(4483, 10, 0, new WorldTile(2662, 5667, 0), "Bank chest"));
		ObjectSpawns.add(new ObjectSpawn(70761, 10, 0, new WorldTile(2660, 5666, 0), "Bonfire"));

		ObjectSpawns.add(new ObjectSpawn(21273, 10, 0, new WorldTile(2645, 5671, 0), "Arctic pine bottom"));
		ObjectSpawns.add(new ObjectSpawn(47759, 10, 0, new WorldTile(2644, 5671, 0), "Arctic pine presents"));
		ObjectSpawns.add(new ObjectSpawn(47761, 10, 0, new WorldTile(2647, 5671, 0), "Arctic pine presents"));
		ObjectSpawns.add(new ObjectSpawn(21273, 10, 0, new WorldTile(2640, 5665, 0), "Arctic pine bottom"));
		ObjectSpawns.add(new ObjectSpawn(47759, 10, 0, new WorldTile(2641, 5664, 0), "Arctic pine presents"));
		ObjectSpawns.add(new ObjectSpawn(47761, 10, 0, new WorldTile(2640, 5667, 0), "Arctic pine presents"));

		ObjectSpawns.add(new ObjectSpawn(46485, 10, 0, new WorldTile(2667, 5670, 0), "Ice fishing"));
		NPCSpawns.add(new NPCSpawn(324, new WorldTile(2667, 5670, 0), "Fishing spot"));
		NPCSpawns.add(new NPCSpawn(327, new WorldTile(2667, 5670, 0), "Fishing spot"));

		ObjectSpawns.add(new ObjectSpawn(46485, 10, 0, new WorldTile(2665, 5670, 0), "Ice fishing"));
		NPCSpawns.add(new NPCSpawn(334, new WorldTile(2665, 5670, 0), "Fishing spot"));
		NPCSpawns.add(new NPCSpawn(328, new WorldTile(2665, 5670, 0), "Fishing spot"));
	}

	public static XPGainHandler handleXPGain = new XPGainHandler() {
		@Override
		public void handle(XPGainEvent e) {
			if (!ACTIVE)
				return;
			if (Areas.withinArea("christmasevent", e.getPlayer().getChunkId())) {
				if (e.getPlayer().getBonusXpRate() != 0.10) {
					e.getPlayer().sendMessage("<shad=000000><col=ff0000>You've been granted a 10% experience boost for skilling within the Land of Snow!");
					e.getPlayer().setBonusXpRate(0.10);
				}
				double chance = e.getXp() / 75000.0;
				if (Math.random() < chance) {
					e.getPlayer().sendMessage("<shad=000000><col=ff0000>You found a "+ItemDefinitions.getDefs(TRADEABLE_REWARD).name+" while skilling!");
					if (e.getPlayer().getInventory().hasFreeSlots()) {
						e.getPlayer().getInventory().addItem(TRADEABLE_REWARD, 1);
					} else {
						e.getPlayer().sendMessage("<shad=000000><col=ff0000>as you did not have room in your inventory, it has been added to your bank.");
						e.getPlayer().getBank().addItem(new Item(TRADEABLE_REWARD, 1), true);
					}
				}
			} else {
				e.getPlayer().setBonusXpRate(0);
			}
		}
	};
	
	public static ObjectClickHandler handleCupboard = new ObjectClickHandler(new Object[] { 12258, 47766 }) {
		@Override
		public void handle(ObjectClickEvent e) {
			e.getPlayer().fadeScreen(() -> {
				e.getPlayer().setNextWorldTile(e.getObjectId() == 12258 ? new WorldTile(2646, 5659, 0) : new WorldTile(3211, 3424, 0));
			});
		}
	};
	
	public static ObjectClickHandler handleSnowCollect = new ObjectClickHandler(new Object[] { 28296 }) {
		@Override
		public void handle(ObjectClickEvent e) {
			if (!ACTIVE)
				return;
			if (e.getPlayer().getInventory().addItem(11951, e.getPlayer().getInventory().getFreeSlots()))
				e.getPlayer().setNextAnimation(new Animation(2282));
		}
	};
	
	private static int getRandomFood() {
		return 15428 + Utils.random(4);
	}

	public static ObjectClickHandler handleFoodTable = new ObjectClickHandler(new Object[] { 47777, 47778 }) {
		@Override
		public void handle(ObjectClickEvent e) {
			if (!ACTIVE)
				return;
			int food = getRandomFood();
			if (e.getPlayer().getInventory().addItem(food, 1))
				e.getPlayer().sendMessage("You take " + Utils.addArticle(ItemDefinitions.getDefs(food).name.toLowerCase()) + ".");
		}
	};
}