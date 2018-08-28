package com.tencent.mm.plugin.game.e;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import java.lang.ref.WeakReference;

class e$5 implements a {
    final /* synthetic */ String bAj;
    final /* synthetic */ float fCA;
    final /* synthetic */ e kdq;
    final /* synthetic */ WeakReference kdz;

    e$5(e eVar, String str, float f, WeakReference weakReference) {
        this.kdq = eVar;
        this.bAj = str;
        this.fCA = f;
        this.kdz = weakReference;
    }

    public final void a(String str, l lVar) {
        if (this.bAj.equals(str)) {
            Bitmap b = g.b(this.bAj, 1, this.fCA);
            if (b != null) {
                if (!(this.kdz == null || this.kdz.get() == null)) {
                    ((ImageView) this.kdz.get()).setImageBitmap(b);
                }
                e.a(this.kdq).put(this.bAj, b);
                com.tencent.mm.plugin.ac.a.bmf().d(this);
            }
        }
    }
}
