package com.example.createmonster.view.avatars

import com.example.createmonster.R
import com.example.createmonster.model.Avatar

object AvatarStore {
    val AVATARS: List<Avatar> by lazy {
        val avatars = mutableListOf<Avatar>()

        avatars.add(Avatar(R.drawable.creature_cat_derp))

        avatars
    }
}
