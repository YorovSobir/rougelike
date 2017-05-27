package ru.spbau.mit.factory;

import org.junit.Test;
import ru.spbau.mit.mob.Mob;
import ru.spbau.mit.mob.Orc;
import ru.spbau.mit.world.World;
import ru.spbau.mit.world.WorldBuilder;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MobFactoryTest {
    private World world;
    private ArrayList<String> message;
    private ArrayList<String> mobTypes = new ArrayList<>(Arrays.asList("orc", "troll", "zombie", "vampire"));

    @Test
    public void getMobTest() throws Exception {
        createWorld();
        MobFactory factory = new MobFactory(world);
        Mob mob = factory.getMob("orc", message);
        assertTrue(mob instanceof Orc);
    }

    @Test
    public void getMobTypesTest() throws Exception {
        createWorld();
        MobFactory factory = new MobFactory(world);
        assertEquals(factory.getMobTypes(), mobTypes);
    }

    private void createWorld() {
        world = new WorldBuilder(90, 32)
                .makeCaves()
                .build();
    }

}