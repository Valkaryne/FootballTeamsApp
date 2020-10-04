package com.epam.valkaryne.footballteamsapp.utils

import android.graphics.drawable.PictureDrawable
import android.widget.ImageView
import com.epam.valkaryne.footballteamsapp.GlideApp
import com.epam.valkaryne.footballteamsapp.R

fun ImageView.loadImageFromUrl(imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        GlideApp.with(context)
            .`as`(PictureDrawable::class.java)
            .load(imageUrl)
            .error(R.drawable.ic_launcher_foreground)
            .into(this)
    }
}
