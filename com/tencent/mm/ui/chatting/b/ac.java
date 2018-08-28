package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.protocal.c.bhv;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.al;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.v;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.w$a;

@a(cwo = v.class)
public class ac extends a implements e, v {
    private final c cYt = new al(al.a.tMM, null);
    private com.tencent.mm.ui.widget.a.c tRm = null;

    public final void cpH() {
        au.DF().a(594, this);
    }

    public final void cpI() {
        if (!com.tencent.mm.sdk.b.a.sFg.d(this.cYt)) {
            com.tencent.mm.sdk.b.a.sFg.b(this.cYt);
        }
    }

    public final void cpJ() {
        com.tencent.mm.sdk.b.a.sFg.c(this.cYt);
    }

    public final void cpK() {
        au.DF().b(594, this);
    }

    public final void ba(bd bdVar) {
        t tVar = new t(bdVar, this.bAG.tTq.getMMResources().getString(R.l.chatting_revoke_msg_tips));
        this.bAG.d(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.chatting_revoke_msg_loading), new 1(this, bdVar, tVar));
        au.DF().a(tVar, 0);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " sceneType:" + lVar.getType());
        this.bAG.dismissDialog();
        if (this.tRm != null) {
            this.tRm.dismiss();
            this.tRm = null;
        }
        if (!this.bAG.eaR) {
            x.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
        } else if (bi.ci(this.bAG.tTq.getContext())) {
            Context context = this.bAG.tTq.getContext();
            boolean z = w$a.a(context, i, i2, str, 7) ? true : w.a(context, i, i2, new Intent().setClass(context, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str);
            if (!z) {
                if (i == 0 && i2 == 0) {
                    switch (lVar.getType()) {
                        case 594:
                            bhv Rs = ((t) lVar).Rs();
                            if (!bi.oW(Rs.siF)) {
                                h.a(this.bAG.tTq.getContext(), Rs.siF, "", this.bAG.tTq.getMMResources().getString(R.l.chatting_revoke_msg_dialog_confirm), new 2(this));
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } else if (lVar.getType() == 594) {
                    int i3;
                    bhv Rs2 = ((t) lVar).Rs();
                    x.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsgTimeout] sysWording:%s", new Object[]{Rs2.siG});
                    if (i2 == 0 || bi.oW(Rs2.siG)) {
                        z = true;
                    } else {
                        i3 = 0;
                    }
                    if (i3 == 0) {
                        x.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] sysWording:%s", new Object[]{Rs2.siG});
                        this.tRm = h.a(this.bAG.tTq.getContext(), Rs2.siG, "", this.bAG.tTq.getMMResources().getString(R.l.chatting_revoke_msg_dialog_confirm), new 3(this));
                        return;
                    }
                    x.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] errorCode:%s,sysWording:%s", new Object[]{Integer.valueOf(i2), Rs2.siG});
                    this.tRm = h.a(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.chatting_revoke_msg_dialog_failure), "", this.bAG.tTq.getMMResources().getString(R.l.chatting_revoke_msg_dialog_confirm), new 4(this));
                }
            }
        }
    }
}
