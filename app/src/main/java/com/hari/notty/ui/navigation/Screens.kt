package com.hari.notty.ui.navigation

sealed class Screens(val route: String) {
    object AllNotes : Screens("all_notes_screen")
    object AddNote : Screens("add_notes_screen")
    object Reminders : Screens("reminders_screen")
    object Labels : Screens("labels_screen")
    object Archives : Screens("archives_screen")
    object Trash : Screens("trash_screen")
    object Settings : Screens("settings_screen")
    object HelpCenter : Screens("help_center_screen")
}
