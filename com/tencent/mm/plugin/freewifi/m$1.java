package com.tencent.mm.plugin.freewifi;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.freewifi.m.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$d;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.b;
import com.tencent.mm.protocal.c.ep;
import com.tencent.mm.sdk.platformtools.x;

class m$1 implements a {
    final /* synthetic */ String jiT;
    final /* synthetic */ FreeWifiFrontPageUI jiU;
    final /* synthetic */ int jij;

    m$1(String str, FreeWifiFrontPageUI freeWifiFrontPageUI, int i) {
        this.jiT = str;
        this.jiU = freeWifiFrontPageUI;
        this.jij = i;
    }

    public final void j(int i, int i2, String str, l lVar) {
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        FreeWifiFrontPageUI$d freeWifiFrontPageUI$d;
        FreeWifiFrontPageUI$a freeWifiFrontPageUI$a;
        if (i == 0 && i2 == 0) {
            if (lVar instanceof com.tencent.mm.plugin.freewifi.d.a) {
                ep aOY = ((com.tencent.mm.plugin.freewifi.d.a) lVar).aOY();
                if (aOY != null) {
                    x.i(this.jiT, "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[]{aOY.rbW, aOY.hcS, aOY.hbL, Integer.valueOf(aOY.rfa), aOY.rfb, aOY.eJK, aOY.rfc});
                    FreeWifiFrontPageUI freeWifiFrontPageUI2 = this.jiU;
                    FreeWifiFrontPageUI$d freeWifiFrontPageUI$d2 = FreeWifiFrontPageUI$d.SUCCESS;
                    b bVar = new b();
                    bVar.jng = aOY;
                    freeWifiFrontPageUI2.a(freeWifiFrontPageUI$d2, bVar);
                    return;
                }
                x.i(this.jiT, "backPageInfo is null");
                freeWifiFrontPageUI = this.jiU;
                freeWifiFrontPageUI$d = FreeWifiFrontPageUI$d.FAIL;
                freeWifiFrontPageUI$a = new FreeWifiFrontPageUI$a();
                freeWifiFrontPageUI$a.jmI = m.a(this.jij, k.b.jis, 21);
                freeWifiFrontPageUI.a(freeWifiFrontPageUI$d, freeWifiFrontPageUI$a);
            }
        } else if (!m.cD(i, i2) || m.isEmpty(str)) {
            freeWifiFrontPageUI = this.jiU;
            freeWifiFrontPageUI$d = FreeWifiFrontPageUI$d.FAIL;
            freeWifiFrontPageUI$a = new FreeWifiFrontPageUI$a();
            freeWifiFrontPageUI$a.jmI = m.a(this.jij, k.b.jis, i2);
            freeWifiFrontPageUI.a(freeWifiFrontPageUI$d, freeWifiFrontPageUI$a);
        } else {
            freeWifiFrontPageUI = this.jiU;
            freeWifiFrontPageUI$d = FreeWifiFrontPageUI$d.FAIL;
            freeWifiFrontPageUI$a = new FreeWifiFrontPageUI$a();
            freeWifiFrontPageUI$a.text = str;
            freeWifiFrontPageUI$a.jmI = m.a(this.jij, k.b.jis, i2);
            freeWifiFrontPageUI.a(freeWifiFrontPageUI$d, freeWifiFrontPageUI$a);
        }
    }
}
