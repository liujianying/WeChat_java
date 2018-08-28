package com.tencent.mm.plugin.record.ui.b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.ui.a.a;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h.a.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;

class a$3 implements Runnable {
    final /* synthetic */ ImageView mtA;
    final /* synthetic */ a mtv;
    final /* synthetic */ b mtz;

    a$3(a aVar, b bVar, ImageView imageView) {
        this.mtv = aVar;
        this.mtz = bVar;
        this.mtA = imageView;
    }

    public final void run() {
        int i;
        int i2;
        Bitmap a;
        a aVar = (a) this.mtz;
        if (aVar.bjS == 0) {
            if (h.g(aVar.bOz, aVar.bJC)) {
                i = R.k.record_errpicture_icon;
            }
            i = -1;
        } else {
            if (aVar.bjS == 1 && bi.oW(aVar.bOz.rzo)) {
                i = R.k.record_errpicture_icon;
            }
            i = -1;
        }
        if (i == -1) {
            i2 = R.k.fav_list_img_default;
        } else {
            i2 = i;
        }
        aVar = (a) this.mtz;
        com.tencent.mm.plugin.record.ui.h.a aVar2 = this.mtv.msR;
        int i3 = this.mtv.mtu;
        com.tencent.mm.plugin.record.ui.h.a.b bVar = new com.tencent.mm.plugin.record.ui.h.a.b();
        bVar.bOz = aVar.bOz;
        bVar.bOC = false;
        bVar.maxWidth = i3;
        c cVar = new c();
        cVar.bOz = aVar.bOz;
        Bitmap a2;
        if (aVar.bjS == 0) {
            if (!h.g(aVar.bOz, aVar.bJC)) {
                bVar.msT = aVar.bJC;
                a2 = aVar2.a(bVar);
                if (a2 == null) {
                    cVar.msT = aVar.bJC;
                    a = aVar2.a(cVar);
                }
                a = a2;
            }
            a = null;
        } else {
            if (aVar.bjS == 1) {
                bVar.msT = aVar.msw.field_localId;
                bVar.bOD = false;
                a2 = aVar2.a(bVar);
                if (a2 == null) {
                    cVar.msT = aVar.msw.field_localId;
                    a = aVar2.a(cVar);
                }
                a = a2;
            }
            a = null;
        }
        ah.A(new Runnable() {
            public final void run() {
                a$3.this.mtv.a(a$3.this.mtA, a, i2, a$3.this.mtz.bOz.jdM);
            }
        });
    }

    public final String toString() {
        return super.toString() + "|fillView";
    }
}
