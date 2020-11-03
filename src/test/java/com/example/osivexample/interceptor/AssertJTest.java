package com.example.osivexample.interceptor;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AssertJTest {
    Chicken chicken;
    Chicken chicken2;
    TestChicken testChicken;
    TestChicken testChicken2;
    TestChicken testChicken3;
    TestChicken testChicken4;
    List<ChickenName> chickenNames;

    @BeforeEach
    void setUp() {
        chicken = new Chicken(1L, "HI", BigDecimal.valueOf(1000L));
        chicken2 = new Chicken(1L, "HI", BigDecimal.valueOf(1000L));

        testChicken = new TestChicken(1L, new ChickenName("HI"), BigDecimal.valueOf(1000L));
        testChicken2 = new TestChicken(1L, new ChickenName("HI"), BigDecimal.valueOf(1000L));
        testChicken3 = new TestChicken(1L, new ChickenName("HI"), BigDecimal.valueOf(1000L));
        testChicken4 = new TestChicken(1L, new ChickenName("HI"), BigDecimal.valueOf(1000L));

        chickenNames = Arrays.asList(new ChickenName("HI"), new ChickenName("HI"),
            new ChickenName("HI"), new ChickenName("HI"));
    }

    @Test
    void various() {
        List<TestChicken> testChickens = Arrays.asList(testChicken, testChicken2);
        List<TestChicken> testChickens2 = Arrays.asList(testChicken3, testChicken4);

        assertThat(chicken)
            .usingRecursiveComparison()
            .isEqualTo(chicken2);

        assertThat(testChickens)
            .usingRecursiveComparison()
            .isEqualTo(testChickens2);
    }

    @Test
    void extracting() {
        assertThat(testChicken)
            .extracting(TestChicken::getName)
            .usingRecursiveComparison()
            .isEqualTo(testChicken2.getName());

        List<TestChicken> chickens = Arrays.asList(testChicken, testChicken2, testChicken3, testChicken4);

        assertThat(chickens).extracting(TestChicken::getName)
            .usingFieldByFieldElementComparator()
            .isEqualTo(chickenNames);
    }

    @Test
    void filteredOn() {
        testChicken = new TestChicken(1L, new ChickenName("HI"), BigDecimal.valueOf(1000L));
        testChicken2 = new TestChicken(1L, new ChickenName("HHI"), BigDecimal.valueOf(1000L));
        testChicken3 = new TestChicken(1L, new ChickenName("HHHI"), BigDecimal.valueOf(1000L));
        testChicken4 = new TestChicken(1L, new ChickenName("HEE"), BigDecimal.valueOf(1000L));

        List<ChickenName> chickenNames = Arrays.asList(new ChickenName("HI"), new ChickenName("HHI"),
            new ChickenName("HHHI"), new ChickenName("HEE"));

        assertThat(chickenNames)
            .filteredOn((chickenName) -> chickenName.getName().contains("HHI"))
            .usingRecursiveComparison()
            .isEqualTo(Arrays.asList(new ChickenName("HHI"), new ChickenName("HHHI")));
    }

    @Test
    void percentage() {
        assertThat(BigDecimal.valueOf(10000L))
            .isCloseTo(BigDecimal.valueOf(9999L), Percentage.withPercentage(90));
    }

    @Test
    void date() {

    }
}
