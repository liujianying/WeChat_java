package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.platformtools.y.a;
import com.tencent.mm.pluginsdk.ui.tools.g.d;
import com.tencent.mm.sdk.platformtools.x;

class g$6 implements a {
    final /* synthetic */ g qSF;

    g$6(g gVar) {
        this.qSF = gVar;
    }

    public final void m(String str, final Bitmap bitmap) {
        boolean z = false;
        String str2 = "MicroMsg.ImageEngine";
        String str3 = "on get picture finish, notifyKey[%s], bitmap is null[%B]";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (bitmap == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        x.v(str2, str3, objArr);
        if (bitmap != null) {
            this.qSF.qSz.put(str, bitmap);
            final ImageView imageView = (ImageView) this.qSF.qSx.get(str);
            if (imageView != null) {
                this.qSF.qSy.remove(imageView);
                this.qSF.dvh.post(new Runnable() {
                    public final void run() {
                        d.b(imageView, bitmap);
                    }
                });
            }
            this.qSF.qSx.remove(str);
        }
    }
}
