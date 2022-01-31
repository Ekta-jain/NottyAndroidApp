package com.hari.notty.utils

import androidx.annotation.StringRes
import com.hari.notty.R
import com.hari.notty.ui.destinations.AddNoteScreenDestination
import com.hari.notty.ui.destinations.AllNoteScreenDestination
import com.hari.notty.ui.destinations.Destination

@get:StringRes
val Destination.requireTitle
    get(): Int {
        return title ?: throw RuntimeException("Destination $this, doesn't contain title")
    }

@get:StringRes
val Destination.title
    get(): Int? {
        return when (this) {
            AllNoteScreenDestination -> R.string.search_from_notes
            AddNoteScreenDestination -> R.string.add_note
        }
    }