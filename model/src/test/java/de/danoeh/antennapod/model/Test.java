package de.danoeh.antennapod.model;

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
    public void testStringCaseConversion() {
        feature.newScenario()
                .Given("a string 'Java'", env -> {
                    String str = "Java";
                    env.put("str", str);
                })
                .When("converting to uppercase", env -> {
                    String str = env.gets("str").toUpperCase();
                    env.put("str", str);
                })
                .Then("the result should be 'JAVA'", env -> {
                    assertEquals("JAVA", env.gets("str"));
                })
                .Execute();
    }

    @EzScenario
    public void testStringReversal() {
        feature.newScenario()
                .Given("a string 'ABCDE'", env -> {
                    String str = "ABCDE";
                    env.put("str", str);
                })
                .When("reversing the string", env -> {
                    String str = new StringBuilder(env.gets("str")).reverse().toString();
                    env.put("str", str);
                })
                .Then("the result should be 'EDCBA'", env -> {
                    assertEquals("EDCBA", env.gets("str"));
                })
                .Execute();
    }

    @EzScenario
    public void testSubstringExtraction() {
        feature.newScenario()
                .Given("a string 'HelloWorld'", env -> {
                    String str = "HelloWorld";
                    env.put("str", str);
                })
                .When("extracting 'World'", env -> {
                    String str = env.gets("str").substring(5);
                    env.put("str", str);
                })
                .Then("the result should be 'World'", env -> {
                    assertEquals("World", env.gets("str"));
                })
                .Execute();
    }
}
