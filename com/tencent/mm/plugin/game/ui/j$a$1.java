package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;

class j$a$1 implements a {
    final /* synthetic */ String bAj;
    final /* synthetic */ float fCA;
    final /* synthetic */ ImageView ixr;

    j$a$1(String str, float f, ImageView imageView) {
        this.bAj = str;
        this.fCA = f;
        this.ixr = imageView;
    }

    public final void a(String str, l lVar) {
        if (this.bAj.equals(str)) {
            Bitmap b = g.b(this.bAj, 1, this.fCA);
            if (b != null) {
                this.ixr.setImageBitmap(b);
                com.tencent.mm.plugin.ac.a.bmf().d(this);
            }
        }
    }
}
