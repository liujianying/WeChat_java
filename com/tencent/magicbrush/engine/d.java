package com.tencent.magicbrush.engine;

import android.content.Context;
import android.util.DisplayMetrics;

public final class d {
    public MBRendererJNI bnF = new MBRendererJNI();

    public final void a(b bVar, Context context, String str) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.bnF.Created(context.getAssets(), str, displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.density, true, bVar.bnA);
    }
}
