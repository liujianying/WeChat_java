package com.tencent.mm.ui.e.a;

import android.widget.ImageView;

public final class a {
    private static b uta = null;

    public static void a(b bVar) {
        uta = bVar;
    }

    public static void a(ImageView imageView, String str) {
        if (uta != null) {
            uta.a(imageView, str);
        }
    }
}
