package com.tencent.mm.ui;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.ad;

public final class ah {
    private static float scale = 0.0f;

    public static float fe(Context context) {
        float f = context.getSharedPreferences(ad.chY(), 0).getFloat("text_size_scale_key", 1.0f);
        scale = f;
        return f;
    }

    public static void g(Context context, float f) {
        Editor edit = context.getSharedPreferences(ad.chY(), 0).edit();
        edit.putFloat("text_size_scale_key", f);
        edit.commit();
        scale = f;
    }
}
