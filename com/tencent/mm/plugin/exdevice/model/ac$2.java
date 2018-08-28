package com.tencent.mm.plugin.exdevice.model;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.ak.a.c.g;
import com.tencent.mm.ak.a.d.b;
import com.tencent.mm.plugin.exdevice.model.ac.a;
import com.tencent.mm.sdk.platformtools.ah;

class ac$2 implements g {
    final /* synthetic */ ac iwd;
    final /* synthetic */ a iwe;

    ac$2(ac acVar, a aVar) {
        this.iwd = acVar;
        this.iwe = aVar;
    }

    public final void me(String str) {
    }

    public final Bitmap a(String str, b bVar) {
        return null;
    }

    public final void a(String str, View view, b bVar) {
        if (this.iwd.dJO) {
            this.iwd.iwb = false;
            return;
        }
        ah.A(new 1(this));
        this.iwe.zZ(this.iwd.y(bVar.bitmap));
        this.iwd.iwb = false;
    }
}
