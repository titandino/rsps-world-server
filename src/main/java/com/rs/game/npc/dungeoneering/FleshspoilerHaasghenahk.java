package com.rs.game.npc.dungeoneering;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.rs.game.Entity;
import com.rs.game.Hit;
import com.rs.game.Hit.HitLook;
import com.rs.game.World;
import com.rs.game.player.content.skills.dungeoneering.DungeonManager;
import com.rs.game.player.content.skills.dungeoneering.DungeonUtils;
import com.rs.game.player.content.skills.dungeoneering.RoomReference;
import com.rs.game.tasks.WorldTask;
import com.rs.game.tasks.WorldTasksManager;
import com.rs.lib.game.Animation;
import com.rs.lib.game.SpotAnim;
import com.rs.lib.game.WorldTile;
import com.rs.lib.util.Utils;

public class FleshspoilerHaasghenahk extends DungeonBoss {

	private List<FleshspoilerSpawn> creatures = new CopyOnWriteArrayList<FleshspoilerSpawn>();

	private Entity cachedTarget;
	private boolean secondStage, useMagicOnly;
	private int fleshTicks;

	public FleshspoilerHaasghenahk(WorldTile tile, DungeonManager manager, RoomReference reference) {
		super(DungeonUtils.getClosestToCombatLevel(Utils.range(11925, 11939), manager.getBossLevel()), tile, manager, reference);
		useMagicOnly = true;
		setHitpoints(getMaxHitpoints());
	}

	@Override
	public void processNPC() {
		fleshTicks++;
		if (fleshTicks % 25 == 0) {
			if (secondStage)
				setNextAnimation(new Animation(14469));
			for (Entity t : getPossibleTargets()) {
				t.setNextSpotAnim(new SpotAnim(2775));
				t.applyHit(new Hit(this, (int) Utils.random(Utils.random(getMaxHit() * .01, getMaxHit() * .1), getMaxHit()), HitLook.TRUE_DAMAGE));
			}
		}
		if (secondStage && cachedTarget != null && (cachedTarget.isDead() || cachedTarget.hasFinished())) {
			calculateNextTarget();
			for (DungeonNPC npc : creatures) {
				npc.resetCombat();
				if (cachedTarget != null)
					npc.getCombat().setTarget(cachedTarget);
			}
		}
		super.processNPC();
	}

	private void addFleshCreatures() {
		final WorldTile centerTile = getManager().getTile(getReference(), 8, 7);
		final List<WorldTile> tiles = new LinkedList<WorldTile>();
		for (int i = 0; i < 5; i++) {
			WorldTile tile = World.getFreeTile(centerTile, 6);
			World.sendProjectile(this, tile, 2765, 150, 0, 30, 1, 40, 0);
			tiles.add(tile);
		}
		final FleshspoilerHaasghenahk boss = this;
		WorldTasksManager.schedule(new WorldTask() {

			@Override
			public void run() {
				for (int index = 0; index < 5; index++)
					creatures.add(new FleshspoilerSpawn(boss, tiles.get(index), getManager()));
			}
		}, 3);
	}

	public void removeFleshCreature(FleshspoilerSpawn spoiler_spawn) {
		creatures.remove(spoiler_spawn);
	}

	@Override
	public void sendDeath(Entity source) {
		if (!secondStage) {
			secondStage = true;
			calculateNextTarget();
			setNextAnimation(new Animation(14467));
			setNextSpotAnim(new SpotAnim(2765, 240, 0));
			WorldTasksManager.schedule(new WorldTask() {

				@Override
				public void run() {
					setNextAnimation(new Animation(-1));
					addFleshCreatures();
					setNextNPCTransformation(getId() - 30);
					setHitpoints(getMaxHitpoints());
					setLureDelay(Integer.MAX_VALUE);
					setCantFollowUnderCombat(true);
					resetBonuses();
				}
			}, 5);
			return;
		}
		for (DungeonNPC npc : creatures)
			npc.sendDeath(this);
		creatures.clear();
		super.sendDeath(source);
	}

	public boolean isSecondStage() {
		return secondStage;
	}

	public boolean canUseMagicOnly() {
		return useMagicOnly;
	}

	public void setUseMagicOnly(boolean useMagicOnly) {
		this.useMagicOnly = useMagicOnly;
	}

	public Entity getCachedTarget() {
		return cachedTarget;
	}

	public void calculateNextTarget() {
		cachedTarget = null;
		List<Entity> targets = getPossibleTargets();
		if (targets.isEmpty())
			return;
		cachedTarget = targets.get(Utils.random(targets.size()));
	}
}