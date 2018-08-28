package com.tencent.mm.plugin.music.ui;

import com.tencent.mm.g.a.jt;
import com.tencent.mm.plugin.music.b.e;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;

class MusicMainUI$2 extends c<jt> {
    final /* synthetic */ MusicMainUI lBe;

    MusicMainUI$2(MusicMainUI musicMainUI) {
        this.lBe = musicMainUI;
        this.sFo = jt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        jt jtVar = (jt) bVar;
        switch (jtVar.bTE.action) {
            case 0:
            case 1:
                MusicMainUI.b(this.lBe).setChecked(false);
                ah.A(new 1(this, jtVar));
                break;
            case 2:
            case 3:
            case 4:
                MusicMainUI.b(this.lBe).setChecked(true);
                break;
            case 5:
                as.I(this.lBe.mController.tml, e.shake_match);
                ah.A(new 3(this));
                break;
            case 6:
                ah.A(new 4(this, jtVar));
                break;
            case 7:
                if (h.bic().mode == 2) {
                    ah.A(new 2(this));
                    break;
                }
                break;
            case 13:
                if (h.bic().mode == 2) {
                    ah.A(new 5(this));
                    break;
                }
                break;
            case 14:
                if (h.bic().mode == 2) {
                    ah.A(new 6(this));
                    break;
                }
                break;
        }
        return false;
    }
}
