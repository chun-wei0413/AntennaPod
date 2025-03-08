package de.danoeh.antennapod.model.feed;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;

import tw.teddysoft.ezspec.EzFeature;
import tw.teddysoft.ezspec.extension.junit5.EzScenario;
import tw.teddysoft.ezspec.keyword.Feature;

@EzFeature
public class Test {
    static String featureName = "test";
    static Feature feature = Feature.New(featureName);

    @BeforeAll
    static void beforeAll() {
        feature.initialize();
    }

    @EzScenario
    public void testFunc() {
        feature.newScenario()
                .Given("a char s", env -> {
                    String a = new String("s");

                    env.put("a", a);
                })
                .When("s concat with a o", env -> {
                    String a1 = env.gets("a");
                    a1.concat("o");

                    env.put("a1", a1);
                })
                .Then("the result shold be so", env -> {
                    assertEquals("so", env.gets("a1"));
                })
                .Execute();
    }
}
