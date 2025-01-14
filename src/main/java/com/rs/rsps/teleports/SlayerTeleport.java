package com.rs.rsps.teleports;

import com.rs.game.content.bosses.godwars.GodwarsController;
import com.rs.game.content.skills.slayer.TaskMonster;
import com.rs.game.content.world.areas.dungeons.UndergroundDungeonController;
import com.rs.game.content.world.areas.dungeons.ancientcavern.KuradalDungeonController;
import com.rs.lib.game.WorldTile;

import java.util.HashMap;
import java.util.Map;

public enum SlayerTeleport {
	
	//TODO possibly wilderness locations if players request
	
	MONKEYS(TaskMonster.MONKEYS, 
			new Teleport("Karamja Jungle", WorldTile.of(2863, 3022, 0)),
			new Teleport("Ardougne Zoo Exhibit", WorldTile.of(2603, 3279, 0))),
	GOBLINS(TaskMonster.GOBLINS,
			new Teleport("Lumbridge", WorldTile.of(3251, 3241, 0)),
			new Teleport("Stronghold of Security", WorldTile.of(1912, 5236, 0))),
	SPIDERS(TaskMonster.SPIDERS,
			new Teleport("Lumbridge (level 2)", WorldTile.of(3251, 3241, 0)),
			new Teleport("Varrock Sewer (level 34)", WorldTile.of(3178, 9883, 0)),
			new Teleport("Stronghold of Security (level 50)", WorldTile.of(2126, 5272, 0))),
	BIRDS(TaskMonster.BIRDS,
			new Teleport("Chickens", WorldTile.of(3230, 3298, 0))),
	COWS(TaskMonster.COWS,
			new Teleport("Cows", WorldTile.of(3258, 3279, 0))),
	SCORPIONS(TaskMonster.SCORPIONS,
			new Teleport("Falador Mines", WorldTile.of(3047, 9765, 0)),
			new Teleport("Stronghold of Security", WorldTile.of(2171, 5283, 0))),
	BATS(TaskMonster.BATS,
			new Teleport("Coal Trucks", WorldTile.of(2585, 3478, 0)),
			new Teleport("Taverley Dungeon", WorldTile.of(2912, 9830, 0)),
			new Teleport("Rag & Bone Man", WorldTile.of(3351, 3489, 0))),
	WOLVES(TaskMonster.WOLVES,
			new Teleport("Stronghold of Security (level 11)", WorldTile.of(1891, 5223, 0)),
			new Teleport("White Wolf Mountain (level 25)", WorldTile.of(2836, 3509, 0)),
			new Teleport("Feldip Hills (level 60)", WorldTile.of(2608, 2964, 0))),
	ZOMBIES(TaskMonster.ZOMBIES,
			new Teleport("Draynor Sewer (level 13-18)", WorldTile.of(3123, 9654, 0)),
			new Teleport("Stronghold of Security (level 44)", WorldTile.of(1992, 5190, 0)),
			new Teleport("Armored Zombies (level 85)", WorldTile.of(3241, 10008, 0))),
	SKELETONS(TaskMonster.SKELETONS,
			new Teleport("Draynor Sewer (level 22-25)", WorldTile.of(3110, 9674, 0)),
			new Teleport("Edgeville Dungeon (level 25)", WorldTile.of(3131, 9913, 0)),
			new Teleport("Stronghold of Security (level 60)", WorldTile.of(2353, 5196, 0))),
	GHOSTS(TaskMonster.GHOSTS,
			new Teleport("Draynor Manor (level 18)", WorldTile.of(3099, 3359, 1)),
			new Teleport("Stronghold of Security (level 77)", WorldTile.of(2353, 5196, 0))),
	BEARS(TaskMonster.BEARS,
			new Teleport("Ardougne", WorldTile.of(2699, 3330, 0))),
	HILL_GIANTS(TaskMonster.HILL_GIANTS,
			new Teleport("Edgeville Dungeon", WorldTile.of(3115, 9836, 0)),
			new Teleport("Ourania Altar", WorldTile.of(2445, 3216, 0))),
	ICE_GIANTS(TaskMonster.ICE_GIANTS,
			new Teleport("Asgarnia Ice Dungeon", WorldTile.of(3053, 9578, 0)),
			new Teleport("Chaos Tunnels", WorldTile.of(3223, 5445, 0))),
	FIRE_GIANTS(TaskMonster.FIRE_GIANTS,
			new Teleport("Brimhaven Dungeon", WorldTile.of(2640, 9566, 2)),
			new Teleport("Waterfall Dungeon", WorldTile.of(2578, 9896, 0)),
			new Teleport("Chaos Tunnels", WorldTile.of(3229, 5495, 0))),
	MOSS_GIANTS(TaskMonster.MOSS_GIANTS,
			new Teleport("West Fishing Guild", WorldTile.of(2556, 3398, 0)),
			new Teleport("Chaos Tunnels", WorldTile.of(3204, 5491, 0)),
			new Teleport("Varrock Sewers", WorldTile.of(3170, 9885, 0))),
	TROLLS(TaskMonster.TROLLS,
			new Teleport("Death Plateau", WorldTile.of(2866, 3590, 0)),
			new Teleport("Chaos Tunnel Ice Trolls", WorldTile.of(3147, 5450, 0))),
	ICE_WARRIORS(TaskMonster.ICE_WARRIORS,
			new Teleport("Asgarnia Ice Dungeon", WorldTile.of(3053, 9578, 0)),
			new Teleport("Chaos Tunnels", WorldTile.of(3223, 5445, 0))),
	OGRES(TaskMonster.OGRES,
			new Teleport("East Castle Wars", WorldTile.of(2500, 3092, 0)),
			new Teleport("Combat Training Camp (Ranged Only)", WorldTile.of(2528, 3368, 0))),
	HOBGOBLINS(TaskMonster.HOBGOBLINS,
			new Teleport("Edgeville Dungeon", WorldTile.of(3123, 9874, 0)),
			new Teleport("Asgarnian Ice Dungeon", WorldTile.of(3022, 9580, 0))),
	DOGS(TaskMonster.DOGS,
			new Teleport("McGrubor's Wood (level 44)", WorldTile.of(2659, 3479, 0)),
			new Teleport("Brimhaven Dungeon (level 63)", WorldTile.of(2668, 9520, 0))),
	GHOULS(TaskMonster.GHOULS,
			new Teleport("South Slayer Tower", WorldTile.of(3417, 3511, 0))),
	GREEN_DRAGONS(TaskMonster.GREEN_DRAGONS,
			new Teleport("Chaos Tunnels", WorldTile.of(3305, 5449, 0)),
			new Teleport("Ancient Cavern (Brutal)", WorldTile.of(1766, 5334, 0))),
	BLUE_DRAGONS(TaskMonster.BLUE_DRAGONS,
			new Teleport("Taverley Dungeon", WorldTile.of(2905, 9801, 0)),
			new Teleport("Kuradal's Dungeon", WorldTile.of(1608, 5278, 0), p -> {
				p.getControllerManager().startController(new KuradalDungeonController());
				p.setNextWorldTile(WorldTile.of(1608, 5278, 0));
			})),
	RED_DRAGONS(TaskMonster.RED_DRAGONS,
			new Teleport("Brimhaven Dungeon", WorldTile.of(2714, 9502, 0))),
	BLACK_DRAGONS(TaskMonster.BLACK_DRAGONS,
			new Teleport("Taverley Dungeon", WorldTile.of(2832, 9826, 0)),
			new Teleport("Zanaris Chicken Lair", WorldTile.of(1567, 4365, 0))),
	LESSER_DEMONS(TaskMonster.LESSER_DEMONS,
			new Teleport("Karamja Volcano", WorldTile.of(2839, 9558, 0)),
			new Teleport("Taverley Dungeon", WorldTile.of(2935, 9793, 0))),
	GREATER_DEMONS(TaskMonster.GREATER_DEMONS,
			new Teleport("Brimhaven Dungeon", WorldTile.of(2636, 9502, 2)),
			new Teleport("Kuradal's Dungeon", WorldTile.of(1617, 5259, 0), p -> {
				p.getControllerManager().startController(new KuradalDungeonController());
				p.setNextWorldTile(WorldTile.of(1617, 5259, 0));
			})),
	BLACK_DEMONS(TaskMonster.BLACK_DEMONS,
			new Teleport("Taverley Dungeon", WorldTile.of(2862, 9777, 0)),
			new Teleport("Brimhaven Dungeon", WorldTile.of(2709, 9484, 0))),
	HELLHOUNDS(TaskMonster.HELLHOUNDS,
			new Teleport("Taverley Dungeon", WorldTile.of(2859, 9839, 0)),
			new Teleport("Kuradal's Dungeon", WorldTile.of(1645, 5256, 0), p -> {
				p.getControllerManager().startController(new KuradalDungeonController());
				p.setNextWorldTile(WorldTile.of(1645, 5256, 0));
			})),
	SHADOW_WARRIORS(TaskMonster.SHADOW_WARRIORS,
			new Teleport("Legend's Guild Basement", WorldTile.of(2700, 9774, 0))),
	WEREWOLVES(TaskMonster.WEREWOLVES,
			new Teleport("Canifis", WorldTile.of(3494, 3494, 0))),
	VAMPYRES(TaskMonster.VAMPYRES,
			new Teleport("Haunted Woods", WorldTile.of(3600, 3486, 0))),
	DAGANNOTH(TaskMonster.DAGANNOTH,
			new Teleport("Waterbirth Dungeon", WorldTile.of(2480, 10145, 0)),
			new Teleport("Lighthouse Dungeon", WorldTile.of(2520, 10020, 0))),
	TUROTH(TaskMonster.TUROTH,
			new Teleport("Rellekka Slayer Dungeon", WorldTile.of(2723, 10002, 0))),
	CAVE_CRAWLERS(TaskMonster.CAVE_CRAWLERS,
			new Teleport("Rellekka Slayer Dungeon", WorldTile.of(2790, 9998, 0)),
			new Teleport("Pollnivneach Slayer Dungeon", WorldTile.of(3313, 4384, 0), p -> p.getControllerManager().startController(new UndergroundDungeonController(true, true)))),
	BANSHEES(TaskMonster.BANSHEES,
			new Teleport("Slayer Tower", WorldTile.of(3442, 3544, 0)),
			new Teleport("Pollnivneach Slayer Dungeon", WorldTile.of(3352, 9391, 0), p -> p.getControllerManager().startController(new UndergroundDungeonController(true, true)))),
	CRAWLING_HANDS(TaskMonster.CRAWLING_HANDS,
			new Teleport("Slayer Tower", WorldTile.of(3422, 3557, 0)),
			new Teleport("Meiyerditch Laboratories", WorldTile.of(3618, 9753, 0))),
	INFERNAL_MAGES(TaskMonster.INFERNAL_MAGES,
			new Teleport("Slayer Tower", WorldTile.of(3438, 3561, 1))),
	ABERRANT_SPECTRES(TaskMonster.ABERRANT_SPECTRES,
			new Teleport("Slayer Tower", WorldTile.of(3428, 3550, 1)),
			new Teleport("Pollnivneach Slayer Dungeon", WorldTile.of(3297, 4350, 0), p -> p.getControllerManager().startController(new UndergroundDungeonController(true, true)))),
	ABYSSAL_DEMONS(TaskMonster.ABYSSAL_DEMONS,
			new Teleport("Slayer Tower", WorldTile.of(3418, 3566, 2)),
			new Teleport("Kuradal's Dungeon", WorldTile.of(1634, 5302, 0), p -> {
				p.getControllerManager().startController(new KuradalDungeonController());
				p.setNextWorldTile(WorldTile.of(1634, 5302, 0));
			})),
	BASILISKS(TaskMonster.BASILISKS,
			new Teleport("Rellekka Slayer Dungeon", WorldTile.of(2742, 10011, 0))),
	COCKATRICE(TaskMonster.COCKATRICE,
			new Teleport("Rellekka Slayer Dungeon", WorldTile.of(2794, 10035, 0))),
	KURASK(TaskMonster.KURASK,
			new Teleport("Rellekka Slayer Dungeon", WorldTile.of(2700, 9998, 0))),
	GARGOYLES(TaskMonster.GARGOYLES,
			new Teleport("Slayer Tower", WorldTile.of(3441, 3548, 2)),
			new Teleport("Kuradal's Dungeon", WorldTile.of(1613, 5300, 0), p -> {
				p.getControllerManager().startController(new KuradalDungeonController());
				p.setNextWorldTile(WorldTile.of(1613, 5300, 0));
			})),
	PYREFIENDS(TaskMonster.PYREFIENDS,
			new Teleport("Rellekka Slayer Dungeon", WorldTile.of(2760, 10003, 0))),
	BLOODVELD(TaskMonster.BLOODVELD,
			new Teleport("Slayer Tower", WorldTile.of(3421, 3562, 1)),
			new Teleport("Meiyerditch Laboratories", WorldTile.of(3597, 9742, 0))),
	DUST_DEVILS(TaskMonster.DUST_DEVILS,
			new Teleport("Pollnivneach Smoke Dungeon", WorldTile.of(3215, 9354, 0)),
			new Teleport("Chaos Tunnels", WorldTile.of(3169, 5514, 0))),
	JELLIES(TaskMonster.JELLIES,
			new Teleport("Rellekka Slayer Dungeon", WorldTile.of(2705, 10027, 0)),
			new Teleport("Chaos Tunnels", WorldTile.of(3276, 5518, 0))),
	ROCKSLUGS(TaskMonster.ROCKSLUGS,
			new Teleport("Lumbridge Swamp Dungeon", WorldTile.of(3224, 9574, 0), p -> p.getControllerManager().startController(new UndergroundDungeonController(false, true))),
			new Teleport("Rellekka Slayer Dungeon", WorldTile.of(2800, 10018, 0))),
	NECHRYAEL(TaskMonster.NECHRYAEL,
			new Teleport("Slayer Tower", WorldTile.of(3441, 3567, 2)),
			new Teleport("Chaos Tunnels", WorldTile.of(3169, 5557, 0))),
	KALPHITE(TaskMonster.KALPHITE,
			new Teleport("Workers (level 28)", WorldTile.of(3504, 9522, 2)),
			new Teleport("Guardians (level 141)", WorldTile.of(3469, 9483, 2))),
	EARTH_WARRIORS(TaskMonster.EARTH_WARRIORS,
			new Teleport("Chaos Tunnels", WorldTile.of(3149, 5514, 0))),
	OTHERWORLDLY_BEINGS(TaskMonster.OTHERWORLDLY_BEINGS,
			new Teleport("Zanaris", WorldTile.of(2387, 4427, 0))),
	ELVES(TaskMonster.ELVES,
			new Teleport("Lletya", WorldTile.of(2334, 3171, 0)),
			new Teleport("Elf Camp", WorldTile.of(2203, 3253, 0))),
	DWARVES(TaskMonster.DWARVES,
			new Teleport("Falador Mines", WorldTile.of(3023, 9824, 0))),
	BRONZE_DRAGONS(TaskMonster.BRONZE_DRAGONS,
			new Teleport("Brimhaven Dungeon", WorldTile.of(2741, 9491, 0)),
			new Teleport("Chaos Tunnels", WorldTile.of(3149, 5514, 0))),
	IRON_DRAGONS(TaskMonster.IRON_DRAGONS,
			new Teleport("Brimhaven Dungeon", WorldTile.of(2703, 9442, 0)),
			new Teleport("Kuradal's Dungeon", WorldTile.of(1652, 5271, 0), p -> {
				p.getControllerManager().startController(new KuradalDungeonController());
				p.setNextWorldTile(WorldTile.of(1652, 5271, 0));
			})),
	STEEL_DRAGONS(TaskMonster.STEEL_DRAGONS,
			new Teleport("Brimhaven Dungeon", WorldTile.of(2703, 9442, 0)),
			new Teleport("Kuradal's Dungeon", WorldTile.of(1631, 5282, 0), p -> {
				p.getControllerManager().startController(new KuradalDungeonController());
				p.setNextWorldTile(WorldTile.of(1631, 5282, 0));
			})),
	CAVE_SLIMES(TaskMonster.CAVE_SLIMES,
			new Teleport("Dorgesh-Kaan Dungeon", WorldTile.of(2697, 5231, 0)),
			new Teleport("Lumbridge Swamp Dungeon", WorldTile.of(3164, 9589, 0), p -> p.getControllerManager().startController(new UndergroundDungeonController(false, true)))),
	CAVE_BUGS(TaskMonster.CAVE_BUGS,
			new Teleport("Chaos Tunnels", WorldTile.of(3272, 5547, 0)),
			new Teleport("Lumbridge Swamp Dungeon", WorldTile.of(3152, 9574, 0), p -> p.getControllerManager().startController(new UndergroundDungeonController(false, true)))),
	SHADES(TaskMonster.SHADES,
			new Teleport("Stronghold of Security", WorldTile.of(2361, 5213, 0)),
			new Teleport("Shades of Mort'ton", WorldTile.of(3502, 3301, 0))),
	CROCODILES(TaskMonster.CROCODILES,
			new Teleport("Desert", WorldTile.of(3315, 2905, 0))),
	DARK_BEASTS(TaskMonster.DARK_BEASTS,
			new Teleport("Temple of Light", WorldTile.of(2029, 4662, 0)),
			new Teleport("Kuradal's Dungeon", WorldTile.of(1653, 5290, 0), p -> {
				p.getControllerManager().startController(new KuradalDungeonController());
				p.setNextWorldTile(WorldTile.of(1653, 5290, 0));
			})),
	DESERT_LIZARDS(TaskMonster.DESERT_LIZARDS,
			new Teleport("Desert", WorldTile.of(3419, 3036, 0))),
	FEVER_SPIDERS(TaskMonster.FEVER_SPIDERS,
			new Teleport("Braindeath Island", WorldTile.of(2149, 5097, 0))),
	HARPIE_BUG_SWARMS(TaskMonster.HARPIE_BUG_SWARMS,
			new Teleport("Karamja", WorldTile.of(2865, 3109, 0))),
	SKELETAL_WYVERNS(TaskMonster.SKELETAL_WYVERNS,
			new Teleport("Asgarnia Ice Dungeon", WorldTile.of(3051, 9552, 0))),
	KILLERWATTS(TaskMonster.KILLERWATTS,
			new Teleport("Killerwatt Plane", WorldTile.of(2664, 5224, 2))),
	ICEFIENDS(TaskMonster.ICEFIENDS,
			new Teleport("Ice Mountain", WorldTile.of(3006, 3476, 0))),
	MINOTAURS(TaskMonster.MINOTAURS,
			new Teleport("Stronghold of Security", WorldTile.of(1876, 5217, 0))),
	FLESHCRAWLERS(TaskMonster.FLESHCRAWLERS,
			new Teleport("Stronghold of Security", WorldTile.of(2042, 5189, 0))),
	CATABLEPON(TaskMonster.CATABLEPON,
			new Teleport("Stronghold of Security", WorldTile.of(2147, 5253, 0))),
	ANKOU(TaskMonster.ANKOU,
			new Teleport("Stronghold of Security", WorldTile.of(2359, 5241, 0))),
	CAVE_HORRORS(TaskMonster.CAVE_HORRORS,
			new Teleport("Mos Le'Harmless", WorldTile.of(3750, 2973, 0))),
	JUNGLE_HORRORS(TaskMonster.JUNGLE_HORRORS,
			new Teleport("Mos Le'Harmless", WorldTile.of(3675, 3022, 0))),
	GORAKS(TaskMonster.GORAKS,
			new Teleport("Gorak Plane", WorldTile.of(3038, 5348, 0))),
	SUQAHS(TaskMonster.SUQAHS,
			new Teleport("Lunar Isle", WorldTile.of(2145, 3856, 0))),
	BRINE_RATS(TaskMonster.BRINE_RATS,
			new Teleport("Olaf's Cave", WorldTile.of(2706, 10134, 0))),
	MOLANISKS(TaskMonster.MOLANISKS,
			new Teleport("Dorgesh-Kaan Dungeon", WorldTile.of(2742, 5206, 0))),
	WATERFIENDS(TaskMonster.WATERFIENDS,
			new Teleport("Ancient Cavern", WorldTile.of(1739, 5348, 0))),
	SPIRITUAL_WARRIORS(TaskMonster.SPIRITUAL_WARRIORS,
			new Teleport("God Wars (Zamorak)", WorldTile.of(2906, 5354, 2), p -> p.getControllerManager().startController(new GodwarsController())),
			new Teleport("God Wars (Saradomin)", WorldTile.of(2926, 5294, 1), p -> p.getControllerManager().startController(new GodwarsController())),
			new Teleport("God Wars (Bandos)", WorldTile.of(2840, 5329, 2), p -> p.getControllerManager().startController(new GodwarsController())),
			new Teleport("God Wars (Armadyl)", WorldTile.of(2850, 5273, 2), p -> p.getControllerManager().startController(new GodwarsController()))),
	SPIRITUAL_MAGES(TaskMonster.SPIRITUAL_MAGES,
			new Teleport("God Wars (Zamorak)", WorldTile.of(2906, 5354, 2), p -> p.getControllerManager().startController(new GodwarsController())),
			new Teleport("God Wars (Saradomin)", WorldTile.of(2926, 5294, 1), p -> p.getControllerManager().startController(new GodwarsController())),
			new Teleport("God Wars (Bandos)", WorldTile.of(2840, 5329, 2), p -> p.getControllerManager().startController(new GodwarsController())),
			new Teleport("God Wars (Armadyl)", WorldTile.of(2850, 5273, 2), p -> p.getControllerManager().startController(new GodwarsController()))),
	WARPED_TORTOISES(TaskMonster.WARPED_TORTOISES,
			new Teleport("Poison Waste Dungeon", WorldTile.of(2021, 4168, 1))),
	WARPED_TERRORBIRDS(TaskMonster.WARPED_TERRORBIRDS,
			new Teleport("Poison Waste Dungeon", WorldTile.of(2021, 4168, 1))),
	MITHRIL_DRAGONS(TaskMonster.MITHRIL_DRAGONS,
			new Teleport("Ancient Cavern", WorldTile.of(1782, 5357, 1))),
	AQUANITES(TaskMonster.AQUANITES,
			new Teleport("Rellekka Slayer Dungeon", WorldTile.of(2726, 9973, 0))),
	GANODERMIC_CREATURES(TaskMonster.GANODERMIC_CREATURES,
			new Teleport("Polypore Dungeon", WorldTile.of(4643, 5405, 0))),
	GRIFOLAPINES(TaskMonster.GRIFOLAPINES,
			new Teleport("Polypore Dungeon", WorldTile.of(4702, 5618, 1))),
	GRIFOLAROOS(TaskMonster.GRIFOLAROOS,
			new Teleport("Polypore Dungeon", WorldTile.of(4649, 5393, 3))),
	FUNGAL_MAGI(TaskMonster.FUNGAL_MAGI,
			new Teleport("Polypore Dungeon", WorldTile.of(4701, 5618, 2))),
	VOLCANIC_CREATURES(TaskMonster.VOLCANIC_CREATURES,
			new Teleport("Tzhaar", WorldTile.of(4630, 5117, 0))),
	JUNGLE_STRYKEWYRMS(TaskMonster.JUNGLE_STRYKEWYRMS,
			new Teleport("South Feldip Hills", WorldTile.of(2457, 2911, 0))),
	DESERT_STRYKEWYRMS(TaskMonster.DESERT_STRYKEWYRMS,
			new Teleport("East Al Kharid", WorldTile.of(3369, 3159, 0))),
	ICE_STRYKEWYRMS(TaskMonster.ICE_STRYKEWYRMS,
			new Teleport("Drained Muspah Cave", WorldTile.of(3423, 5660, 0))),
	LIVING_ROCK_CREATURES(TaskMonster.LIVING_ROCK_CREATURES,
			new Teleport("Living Rock Caverns", WorldTile.of(3653, 5094, 0))),
	CYCLOPES(TaskMonster.CYCLOPES,
			new Teleport("God Wars (Bandos)", WorldTile.of(2840, 5329, 2), p -> p.getControllerManager().startController(new GodwarsController()))),
	MUTATED_JADINKOS(TaskMonster.MUTATED_JADINKOS,
			new Teleport("Babies (level 90)", WorldTile.of(3019, 9257, 0)),
			new Teleport("Guards (level 145)", WorldTile.of(3044, 9264, 0)),
			new Teleport("Males (level 201)", WorldTile.of(3059, 9245, 0))),
	VYREWATCH(TaskMonster.VYREWATCH,
			new Teleport("Vyrewatch", WorldTile.of(3560, 3199, 0)),
			new Teleport("Vyrelords/ladies (requires blisterwood)", WorldTile.of(3613, 3370, 0))),
	GROTWORMS(TaskMonster.GROTWORMS,
			new Teleport("Young grotworms", WorldTile.of(1151, 6363, 0)),
			new Teleport("Grotworms", WorldTile.of(1321, 6468, 0)),
			new Teleport("Mature grotworms", WorldTile.of(1188, 6498, 0)));
	
	private static Map<TaskMonster, SlayerTeleport> MAP = new HashMap<>();
	
	static {
		for (SlayerTeleport t : SlayerTeleport.values())
			MAP.put(t.monster, t);
	}
	
	public static SlayerTeleport forMonster(TaskMonster monster) {
		return MAP.get(monster);
	}
	
	private TaskMonster monster;
	private Teleport[] teleports;
	
	SlayerTeleport(TaskMonster monster, Teleport... teleports) {
		this.monster = monster;
		this.teleports = teleports;
	}
	
	public Teleport[] getTeleports() {
		return teleports;
	}
}
