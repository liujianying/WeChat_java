package com.tencent.d.b.f;

import android.annotation.SuppressLint;
import com.tencent.d.a.c.c;
import com.tencent.d.a.c.f;
import com.tencent.d.b.b.a;
import com.tencent.d.b.d.b;
import com.tencent.d.b.e.e;

public final class k extends c {
    private int fdx = -1;
    String vlV = null;
    private boolean vna = false;
    e vnd = null;
    private e vne = null;
    private boolean vnf = false;

    public k(int i, e eVar, e eVar2, boolean z) {
        this.fdx = i;
        this.vnd = eVar;
        this.vna = z;
        this.vnf = true;
        this.vne = eVar2;
    }

    @SuppressLint({"DefaultLocale"})
    final boolean cFX() {
        if (!a.cFO().isInit()) {
            c.w("Soter.TaskPrepareAuthKey", "soter: not initialized yet", new Object[0]);
            b(new com.tencent.d.b.a.c(14));
            return true;
        } else if (a.cFO().cFN()) {
            this.vlV = (String) a.cFO().cFQ().get(this.fdx, "");
            if (f.oW(this.vlV)) {
                c.w("Soter.TaskPrepareAuthKey", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
                b(new com.tencent.d.b.a.c(15, String.format("auth scene %d not initialized in map", new Object[]{Integer.valueOf(this.fdx)})));
                return true;
            }
            boolean cFD = com.tencent.d.a.a.cFD();
            if (!cFD && com.tencent.d.a.a.acz(this.vlV)) {
                c.w("Soter.TaskPrepareAuthKey", "soter: no ask but has auth key. delete the auth key as well", new Object[0]);
                com.tencent.d.a.a.bD(this.vlV, false);
            }
            if (!cFD && !this.vnf) {
                c.w("Soter.TaskPrepareAuthKey", "soter: has not generate app secure key yet and not require to generate it", new Object[0]);
                b(new com.tencent.d.b.a.c(3));
                return true;
            } else if (com.tencent.d.a.a.acz(this.vlV) && !com.tencent.d.a.a.acA(this.vlV)) {
                c.w("Soter.TaskPrepareAuthKey", "soter: already has auth key but not valid. delete it already and re-generate", new Object[0]);
                return false;
            } else if (!com.tencent.d.a.a.acz(this.vlV) || this.vna) {
                if (this.vnd == null) {
                    c.w("Soter.TaskPrepareAuthKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload AuthKey validation from server! Please make sure you upload it later", new Object[0]);
                }
                return false;
            } else {
                c.i("Soter.TaskPrepareAuthKey", "soter: already has key. do not need generate again", new Object[0]);
                b(new com.tencent.d.b.a.c(com.tencent.d.a.a.acB(this.vlV)));
                return true;
            }
        } else {
            c.w("Soter.TaskPrepareAuthKey", "soter: not support soter", new Object[0]);
            b(new com.tencent.d.b.a.c(2));
            return true;
        }
    }

    final void cFY() {
        c.w("Soter.TaskPrepareAuthKey", "soter: cancelled prepare authkey: %s", new Object[]{this.vlV});
        com.tencent.d.a.a.bD(this.vlV, false);
    }

    final void execute() {
        if (com.tencent.d.a.a.cFD() || !this.vnf) {
            cGe();
            return;
        }
        c.d("Soter.TaskPrepareAuthKey", "soter: ask not found, but required to generate it. start generate", new Object[0]);
        com.tencent.d.b.a.a(new 1(this), false, this.vne);
    }

    private void cGe() {
        dC(this.vlV, 1);
        b.a aVar = new b.a();
        String str = this.vlV;
        boolean z = this.vna;
        aVar.vlV = str;
        aVar.vlX = z;
        aVar.vlU |= 2;
        aVar.vlY = new 2(this);
        aVar.cFV().cFU();
    }
}
