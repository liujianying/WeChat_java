package com.tencent.mm.plugin.sns.ui.b;

import android.view.View;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.ui.ak;

class b$29 implements e {
    final /* synthetic */ b olf;

    b$29(b bVar) {
        this.olf = bVar;
    }

    public final void d(b bVar, int i) {
        if (bVar != null && i == 0) {
            View view = bVar.ncu != null ? (View) bVar.ncu.get() : null;
            if (view != null && (view instanceof a)) {
                a aVar = (a) view;
                aVar.getVideoPath();
                if (aVar.getTagObject() != null && (aVar.getTagObject() instanceof ak)) {
                    aVar.getTagObject();
                }
            }
        }
    }
}
