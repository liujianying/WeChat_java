package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.sight.draft.ui.b.e;
import com.tencent.mm.sdk.platformtools.bi;

class b$1 extends c {
    final /* synthetic */ b neG;

    b$1(b bVar) {
        this.neG = bVar;
    }

    public final void r(String str, Bitmap bitmap) {
        for (e eVar : b.a(this.neG)) {
            if (eVar.neN != null && bi.aG(str, "").equals(eVar.neN.field_fileName)) {
                eVar.neL.setThumbBmp(bitmap);
                return;
            }
        }
    }
}
