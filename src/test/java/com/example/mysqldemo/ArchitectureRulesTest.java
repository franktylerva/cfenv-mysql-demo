package com.example.mysqldemo;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(packages = "com.example.mysqldemo")
public class ArchitectureRulesTest {

    @ArchTest
    static final ArchRule features_dependencies = slices()
            .matching("..usermanagement.(get*)..")
            .should().notDependOnEachOther();

}
