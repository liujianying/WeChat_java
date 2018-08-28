package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.g.h;
import com.google.android.exoplayer2.i.b;
import com.google.android.exoplayer2.q.a;
import java.util.Iterator;

class h$1 extends Handler {
    final /* synthetic */ h add;

    h$1(h hVar, Looper looper) {
        this.add = hVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        h hVar = this.add;
        Iterator it;
        Iterator it2;
        Iterator it3;
        switch (message.what) {
            case 0:
                hVar.acS--;
                return;
            case 1:
                hVar.acQ = message.arg1;
                it = hVar.acL.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).b(hVar.acP, hVar.acQ);
                }
                return;
            case 2:
                hVar.acT = message.arg1 != 0;
                it = hVar.acL.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).ai(hVar.acT);
                }
                return;
            case 3:
                if (hVar.acS == 0) {
                    h hVar2 = (h) message.obj;
                    hVar.acO = true;
                    hVar.acW = hVar2.aAw;
                    hVar.acX = hVar2.aAx;
                    hVar.acH.X(hVar2.aAy);
                    it2 = hVar.acL.iterator();
                    while (it2.hasNext()) {
                        it2.next();
                    }
                    return;
                }
                return;
            case 4:
                int i = hVar.acR - 1;
                hVar.acR = i;
                if (i == 0) {
                    hVar.acZ = (b) message.obj;
                    if (hVar.acU.isEmpty()) {
                        hVar.adb = 0;
                        hVar.ada = 0;
                        hVar.adc = 0;
                    }
                    if (message.arg1 != 0) {
                        it = hVar.acL.iterator();
                        while (it.hasNext()) {
                            ((a) it.next()).iS();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (hVar.acR == 0) {
                    hVar.acZ = (b) message.obj;
                    it = hVar.acL.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).iS();
                    }
                    return;
                }
                return;
            case 6:
                i$d i_d = (i$d) message.obj;
                hVar.acR -= i_d.adQ;
                if (hVar.acS == 0) {
                    hVar.acU = i_d.acU;
                    hVar.acV = i_d.acV;
                    hVar.acZ = i_d.acZ;
                    if (hVar.acR == 0 && hVar.acU.isEmpty()) {
                        hVar.adb = 0;
                        hVar.ada = 0;
                        hVar.adc = 0;
                    }
                    it2 = hVar.acL.iterator();
                    while (it2.hasNext()) {
                        it2.next();
                    }
                    return;
                }
                return;
            case 7:
                p pVar = (p) message.obj;
                if (!hVar.acY.equals(pVar)) {
                    hVar.acY = pVar;
                    it3 = hVar.acL.iterator();
                    while (it3.hasNext()) {
                        ((a) it3.next()).a(pVar);
                    }
                    return;
                }
                return;
            case 8:
                e eVar = (e) message.obj;
                it3 = hVar.acL.iterator();
                while (it3.hasNext()) {
                    ((a) it3.next()).a(eVar);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
