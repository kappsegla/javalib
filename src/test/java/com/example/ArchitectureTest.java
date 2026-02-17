package com.example;

import com.example.filters.Filter;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

class ArchitectureTest {

    @Test
    void some_architecture_rule() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.example");

        ArchRule rule = ArchRuleDefinition.classes()
                .that().implement(Filter.class)
                .should().resideInAPackage("com.example.filters");
        rule.check(importedClasses);
    }

    @Test
    void filterNaming() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.example");

        ArchRule rule = ArchRuleDefinition.classes()
                .that().resideInAPackage("com.example.filters")
                .should().haveSimpleNameEndingWith("Filter");
        rule.check(importedClasses);
    }

}
