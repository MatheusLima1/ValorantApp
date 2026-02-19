package com.matheuslima.valorantcompose.konsist

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.architecture.KoArchitectureCreator.assertArchitecture
import com.lemonappdev.konsist.api.architecture.Layer
import org.junit.Test

class ArchitectureTest {
    @Test
    fun `clean architecture layers have correct dependencies`(){
        Konsist.scopeFromProject().assertArchitecture {
            val domain = Layer("Domain", "com.matheuslima.valorantcompose.domain..")
            val presentation = Layer("Presentation", "com.matheuslima.valorantcompose.ui..")
            val data = Layer("Data", "com.matheuslima.valorantcompose.data..")
//            domain.dependsOnNothing()
            presentation.dependsOn(data)
            data.dependsOnNothing()
        }
    }


}