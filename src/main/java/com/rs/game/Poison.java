package com.rs.game;

import com.rs.game.Hit.HitLook;
import com.rs.game.player.Player;
import com.rs.game.player.content.Effect;
import com.rs.game.player.managers.AuraManager.Aura;
import com.rs.lib.util.Utils;

public final class Poison {

	private transient Entity entity;
	private int poisonDamage;
	private int poisonCount;

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public Entity getEntity() {
		return entity;
	}

	public void makePoisoned(int startDamage) {
		if (poisonDamage > startDamage)
			return;
		if (entity instanceof Player) {
			Player player = ((Player) entity);
			if (player.hasEffect(Effect.ANTIPOISON))
				return;
			if (poisonDamage == 0)
				player.sendMessage("You are poisoned.");
		}
		poisonDamage = startDamage;
		refresh();
	}

	public void processPoison() {
		if (!entity.isDead() && isPoisoned()) {
			if (poisonCount > 0) {
				poisonCount--;
				return;
			}
			boolean heal = false;
			if (entity instanceof Player) {
				Player player = ((Player) entity);
				if (player.getInterfaceManager().containsScreenInter())
					return;
				if (player.getAuraManager().isActivated(Aura.POISON_PURGE, Aura.GREATER_POISON_PURGE, Aura.MASTER_POISON_PURGE, Aura.SUPREME_POISON_PURGE))
					heal = true;
			}
			if (!heal && entity instanceof Player) {
				((Player)entity).incrementCount("Poison damage taken", poisonDamage);
			}
			entity.applyHit(new Hit(entity, poisonDamage, heal ? HitLook.HEALED_DAMAGE : HitLook.POISON_DAMAGE));
			poisonDamage -= 2;
			if (isPoisoned()) {
				poisonCount = 30;
				return;
			}
			reset();
		}
	}

	public void reset() {
		poisonDamage = 0;
		poisonCount = 0;
		refresh();
	}

	public void refresh() {
		if (entity instanceof Player) {
			Player player = ((Player) entity);
			player.getVars().setVar(102, isPoisoned() ? 1 : 0);
		}
	}

	public boolean isPoisoned() {
		return poisonDamage >= 1;
	}
	
	public void lowerPoisonDamage(int reduction) {
		poisonDamage = Utils.clampI(poisonDamage - reduction, 0, poisonDamage);
	}
}