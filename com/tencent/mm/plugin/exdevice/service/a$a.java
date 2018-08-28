package com.tencent.mm.plugin.exdevice.service;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.exdevice.service.a.b;
import com.tencent.mm.plugin.exdevice.service.a.c;
import com.tencent.mm.plugin.exdevice.service.a.d;
import com.tencent.mm.plugin.exdevice.service.a.e;
import com.tencent.mm.plugin.exdevice.service.a.f;
import com.tencent.mm.plugin.exdevice.service.a.g;
import com.tencent.mm.sdk.platformtools.ag;

final class a$a extends ag {
    final /* synthetic */ a iyj;

    public a$a(a aVar, Looper looper) {
        this.iyj = aVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                c cVar = (c) message.obj;
                a.a(this.iyj).a(1, 0, null, cVar.hjn, cVar.fNv, cVar.fNP, cVar.hjo);
                return;
            case 2:
                a.a(this.iyj).a(2, 0, null, null, null, 0, null);
                return;
            case 3:
                e eVar = (e) message.obj;
                a.a(this.iyj).c(eVar.iyn, eVar.isM, eVar.isA, eVar.fGO);
                return;
            case 4:
                d dVar = (d) message.obj;
                a.a(this.iyj).b(dVar.hjj, dVar.iyl, dVar.iym, dVar.isA);
                return;
            case 5:
                b bVar = (b) message.obj;
                a.a(this.iyj).a(message.arg1, bVar.hjj, bVar.isH, bVar.iyk, bVar.isB);
                return;
            case 8:
                g gVar = (g) message.obj;
                a.a(this.iyj, gVar.iyn, gVar.iyo);
                return;
            case 9:
                a.cK(((Long) message.obj).longValue());
                return;
            case 10:
                f fVar = (f) message.obj;
                a.a(this.iyj, fVar.hjj, fVar.hfA);
                return;
            case 11:
                synchronized (a.b(this.iyj)) {
                    a.a(this.iyj, ((Long) message.obj).longValue());
                }
                return;
            case 12:
                synchronized (a.b(this.iyj)) {
                    a.b(this.iyj, ((Long) message.obj).longValue());
                }
                return;
            default:
                return;
        }
    }
}
