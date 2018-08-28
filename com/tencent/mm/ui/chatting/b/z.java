package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.AllRemindMsgUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.b.b.t;
import com.tencent.mm.ui.chatting.view.b;
import com.tencent.mm.ui.w;

@a(cwo = t.class)
public class z extends a implements e, t {
    static /* synthetic */ String b(z zVar, bd bdVar) {
        int iA;
        if (bdVar.isText() || bdVar.cmn()) {
            String str = bdVar.field_content;
            iA = com.tencent.mm.model.bd.iA(str);
            return iA != -1 ? str.substring(iA + 1).trim() : str;
        } else {
            Context context = zVar.bAG.tTq.getContext();
            iA = bdVar.getType();
            String str2 = bdVar.field_content;
            zVar.bAG.getTalkerUserName();
            x.i("MicroMsg.ChattingUI.MsgRemindComponent", "[getRemindTitle] msgId:%s type:%s title:%s", new Object[]{Long.valueOf(bdVar.field_msgId), Integer.valueOf(bdVar.getType()), AllRemindMsgUI.a(context, iA, str2, bdVar.field_isSend)});
            return AllRemindMsgUI.a(context, iA, str2, bdVar.field_isSend);
        }
    }

    public final void cpH() {
        au.DF().a(525, this);
    }

    public final void cpK() {
        au.DF().b(525, this);
    }

    public final void k(MenuItem menuItem) {
        bd ES = ((g) this.bAG.O(g.class)).ES(menuItem.getGroupId());
        if (ES == null) {
            x.e("MicroMsg.ChattingUI.MsgRemindComponent", "context item select failed, null msg");
            return;
        }
        switch (menuItem.getItemId()) {
            case 134:
                au.HU();
                if (((Boolean) c.DT().get(aa.a.sQl, Boolean.valueOf(true))).booleanValue()) {
                    h.a(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.remind_tip_desc), this.bAG.tTq.getMMResources().getString(R.l.remind_tip_title), new 1(this, ES));
                    au.HU();
                    c.DT().a(aa.a.sQl, Boolean.valueOf(false));
                    return;
                }
                aQ(ES);
                return;
            default:
                return;
        }
    }

    private void aQ(bd bdVar) {
        b bVar = new b(this.bAG.tTq.getContext());
        bVar.tZc = new 2(this, bVar, bdVar);
        bVar.show();
        com.tencent.mm.plugin.report.service.h.mEJ.a(795, 0, 1, false);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " sceneType:" + lVar.getType());
        this.bAG.dismissDialog();
        if (!this.bAG.eaR) {
            x.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd fragment not foreground, return");
        } else if (bi.ci(this.bAG.tTq.getContext())) {
            Context context = this.bAG.tTq.getContext();
            boolean z = w.a.a(context, i, i2, str, 7) ? true : w.a(context, i, i2, new Intent().setClass(context, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str);
            if (!z) {
                if (i == 0 && i2 == 0) {
                    switch (lVar.getType()) {
                        case 525:
                            x.i("MicroMsg.ChattingUI.MsgRemindComponent", "set msg remind!");
                            com.tencent.mm.ui.widget.snackbar.b.a(this.bAG.tTq.getContext(), this.bAG.tTq.getView(), this.bAG.tTq.getMMResources().getString(R.l.has_remind_tip), "");
                            return;
                        default:
                            return;
                    }
                } else if (lVar.getType() == 525) {
                    x.e("MicroMsg.ChattingUI.MsgRemindComponent", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[]{Integer.valueOf(525), Integer.valueOf(i2), Integer.valueOf(i), bi.oV(str)});
                    context = this.bAG.tTq.getContext();
                    if (bi.oW(str)) {
                        str = this.bAG.tTq.getMMResources().getString(R.l.remind_err_desc);
                    }
                    h.b(context, str, this.bAG.tTq.getMMResources().getString(R.l.remind_err_title), true);
                    com.tencent.mm.plugin.report.service.h.mEJ.a(795, 4, 1, false);
                }
            }
        }
    }
}
