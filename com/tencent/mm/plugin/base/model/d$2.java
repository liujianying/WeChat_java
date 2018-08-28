package com.tencent.mm.plugin.base.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mm.aa.f.c;
import com.tencent.mm.aa.q;
import com.tencent.mm.plugin.base.model.d.a;
import com.tencent.mm.sdk.platformtools.x;

class d$2 implements c {
    final /* synthetic */ String dhF;
    final /* synthetic */ String fFV;
    final /* synthetic */ a hdx;
    final /* synthetic */ String hdy;
    final /* synthetic */ Context val$context;

    d$2(String str, Context context, a aVar, String str2, String str3) {
        this.dhF = str;
        this.val$context = context;
        this.hdx = aVar;
        this.fFV = str2;
        this.hdy = str3;
    }

    public final void jX(String str) {
        if (this.dhF.equals(str)) {
            x.i("MicroMsg.WebviewShrotcutManager", "notifyChanged avatar(%s).", new Object[]{str});
            d.KC().remove(this);
            q.Kp().b(this);
            Bitmap Y = d.Y(this.val$context, this.dhF);
            if (Y != null && !Y.isRecycled()) {
                Intent a = d.a(this.val$context, this.dhF, this.fFV, this.hdy, Y, true);
                if (a == null) {
                    x.e("MicroMsg.WebviewShrotcutManager", "intent is null");
                    if (this.hdx != null) {
                        this.hdx.dF(false);
                        return;
                    }
                    return;
                }
                b.o(this.val$context, a);
                if (this.hdx != null) {
                    this.hdx.dF(true);
                }
            } else if (this.hdx != null) {
                this.hdx.dF(false);
            }
        }
    }
}
