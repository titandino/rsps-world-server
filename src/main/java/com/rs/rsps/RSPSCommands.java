package com.rs.rsps;

import com.rs.Settings;
import com.rs.game.content.skills.magic.Magic;
import com.rs.game.engine.command.Commands;
import com.rs.lib.game.Rights;
import com.rs.lib.game.WorldTile;
import com.rs.plugin.annotations.PluginEventHandler;
import com.rs.plugin.annotations.ServerStartupEvent;

@PluginEventHandler
public class RSPSCommands {
	
	@ServerStartupEvent
	public static void init() {
		Commands.add(Rights.PLAYER, "home", "Teleports the player home.", (p, args) -> {
			Magic.sendNormalTeleportSpell(p, Settings.getConfig().getPlayerStartTile());
		});
		
		Commands.add(Rights.PLAYER, "clanwars", "Teleports the player to clan wars.", (p, args) -> {
			Magic.sendNormalTeleportSpell(p, WorldTile.of(2997, 9680, 0));
		});
	}

}
