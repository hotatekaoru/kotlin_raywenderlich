package com.example.createmonster.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

// TODO: View配下に書くべきでは？と思ったけど、いったんサンプルコードに従ってapp配下に書く
// TODO: なんでXというクラス名なんだろ。ViewGroupExtensionとかの方が好き

// @LayoutResは、ただのInt型ではなく、layoutのIntであることを示す
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}
