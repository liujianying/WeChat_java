package com.tencent.mm.plugin.radar.ui;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import b.c.b.e;
import com.tencent.mm.pluginsdk.ui.i.a;

public final class b$a {
    private static a mkJ;
    public static final b$a mkK = new b$a();

    private b$a() {
    }

    public static a bpy() {
        return mkJ;
    }

    public static void a(a aVar) {
        e.i(aVar, "loader");
        mkJ = aVar;
    }

    public static void a(ImageView imageView, String str) {
        b bVar;
        e.i(imageView, "iv");
        e.i(str, "tag");
        Drawable drawable = imageView.getDrawable();
        if (drawable == null || !(drawable instanceof b)) {
            bVar = new b(str, (byte) 0);
        } else {
            bVar = (b) drawable;
        }
        bVar.Tw(str);
        imageView.setImageDrawable((Drawable) bVar);
    }
}
