package com.apipas.spacex.util

import android.content.Intent
import android.net.Uri


object IntentUtil {

    fun openWebIntent(url: String): Intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

    fun openYouTube(url: String) =
        Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=$url§"))
}