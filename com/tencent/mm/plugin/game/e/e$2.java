package com.tencent.mm.plugin.game.e;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.ak.a.c.g;
import com.tencent.mm.plugin.game.e.e.a;
import com.tencent.mm.plugin.game.e.e.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

class e$2 implements g {
    final /* synthetic */ ImageView joW;
    final /* synthetic */ e kdq;
    final /* synthetic */ b kdr;
    final /* synthetic */ a kds;

    e$2(e eVar, b bVar, a aVar, ImageView imageView) {
        this.kdq = eVar;
        this.kdr = bVar;
        this.kds = aVar;
        this.joW = imageView;
    }

    public final void me(String str) {
        x.d("MicroMsg.GameImageUtil", "onImageLoadStart, url: " + str);
    }

    public final Bitmap a(String str, com.tencent.mm.ak.a.d.b bVar) {
        return null;
    }

    public final void a(String str, View view, com.tencent.mm.ak.a.d.b bVar) {
        x.d("MicroMsg.GameImageUtil", "onImageLoadFinish, url: " + str);
        if (bVar != null && bVar.bitmap != null) {
            Bitmap bitmap = bVar.bitmap;
            if (this.kds.kdA) {
                bitmap = e.A(bitmap);
            }
            if (this.kds.kdE != 0) {
                bitmap = c.a(bitmap, true, (float) this.kds.kdE);
            }
            if (this.kds.dXw) {
                e.b(this.kdq).m(str, bitmap);
            }
            ah.A(new 1(this, bitmap));
            if (this.kdr != null) {
                this.kdr.a(view, bitmap);
            }
        }
    }
}
