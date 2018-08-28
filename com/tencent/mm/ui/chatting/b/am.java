package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.chatting.b.b.o;
import com.tencent.mm.ui.w;
import java.util.List;

public class am extends a implements e, a, b, u {
    public final void cpH() {
        au.DF().a(137, this);
        au.HU();
        c.FR().a(this);
    }

    public final void cpK() {
        au.DF().b(137, this);
        if (au.HX()) {
            au.HU();
            c.FR().b(this);
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        boolean z = true;
        x.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " sceneType:" + lVar.getType());
        this.bAG.dismissDialog();
        if (!this.bAG.eaR) {
            x.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
        } else if (bi.ci(this.bAG.tTq.getContext())) {
            Context context = this.bAG.tTq.getContext();
            if (!(w.a.a(context, i, i2, str, 7) || w.a(context, i, i2, new Intent().setClass(context, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str))) {
                z = false;
            }
            if (!z && i == 0 && i2 == 0) {
                switch (lVar.getType()) {
                    case 137:
                        List list = ((m) lVar).qyZ;
                        if (list == null || list.contains(this.bAG.oLT.field_username)) {
                            ab abVar = this.bAG.oLT;
                            au.HU();
                            ab Yg = c.FR().Yg(abVar.field_username);
                            if (Yg == null || ((int) Yg.dhP) == 0) {
                                au.HU();
                                if (c.FR().S(abVar)) {
                                    au.HU();
                                    Yg = c.FR().Yg(abVar.field_username);
                                } else {
                                    x.e("MicroMsg.ChattingUI.ChattingLogic", "insert contact failed, username = " + abVar.field_username);
                                    Yg = null;
                                }
                            }
                            if (Yg != null) {
                                s.p(Yg);
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (this.bAG.eaR) {
            x.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange " + i);
            au.HU();
            ab Yg = c.FR().Yg(this.bAG.getTalkerUserName());
            if (Yg != null && ((int) Yg.dhP) != 0) {
                if (bi.oW(Yg.field_nickname)) {
                    Yg.dx(this.bAG.oLT.field_nickname);
                }
                this.bAG.oLT = Yg;
                ((o) this.bAG.O(o.class)).cvn();
                ((o) this.bAG.O(o.class)).cvq();
                this.bAG.avj();
                return;
            }
            return;
        }
        x.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange fragment not foreground, return");
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        while (true) {
        }
    }
}
