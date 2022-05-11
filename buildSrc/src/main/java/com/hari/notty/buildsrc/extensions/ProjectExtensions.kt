
package com.hari.notty.buildsrc.extensions

import org.gradle.api.Project
import com.hari.notty.buildsrc.utils.getLocalProperty

/**
 * Obtain property declared on `$projectRoot/local.properties` file.
 *
 * @param propertyName the name of declared property
 */
fun Project.getLocalProperty(propertyName: String): String {
    return getLocalProperty(propertyName, this)
}
