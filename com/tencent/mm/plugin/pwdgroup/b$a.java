package com.tencent.mm.plugin.pwdgroup;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mm.pluginsdk.ui.i.a;

public class b$a {
    static a lZs;

    public static void a(ImageView imageView, String str) {
        b bVar;
        Drawable drawable = imageView.getDrawable();
        if (drawable == null || !(drawable instanceof b)) {
            bVar = new b(str, (byte) 0);
        } else {
            bVar = (b) drawable;
        }
        bVar.Tw(str);
        imageView.setImageDrawable(bVar);
    }
}
