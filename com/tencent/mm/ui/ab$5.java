package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.ak.a.c.g;
import com.tencent.mm.ak.a.d.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.preference.IconPreference;

class ab$5 implements g {
    final /* synthetic */ ab toE;
    final /* synthetic */ IconPreference toI;

    ab$5(ab abVar, IconPreference iconPreference) {
        this.toE = abVar;
        this.toI = iconPreference;
    }

    public final void me(String str) {
    }

    public final Bitmap a(String str, b bVar) {
        return null;
    }

    public final void a(String str, View view, b bVar) {
        if (bVar.status != 0 || bVar.bitmap == null) {
            ah.A(new 2(this));
        } else {
            ah.A(new 1(this, bVar.bitmap));
        }
    }
}
