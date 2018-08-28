package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.r;

@a(cwo = r.class)
public class x extends a implements r {
    public final boolean aS(bd bdVar) {
        if (!bdVar.aQo()) {
            return false;
        }
        ak.aM(bdVar);
        this.bAG.lT(true);
        return true;
    }

    public final void cvF() {
        int i;
        int i2 = ab.XR(this.bAG.getTalkerUserName()) ? (((b) g.l(b.class)).oD(this.bAG.oLT.field_openImAppid) & 4096) == 0 ? 1 : 0 : 0;
        if (this.bAG.oLT.ckW() || s.hL(this.bAG.getTalkerUserName()) || ab.XO(this.bAG.getTalkerUserName()) || ab.XQ(this.bAG.getTalkerUserName()) || ab.gY(this.bAG.getTalkerUserName()) || this.bAG.getTalkerUserName().equals(q.GF())) {
            i = 0;
        } else {
            i = 1;
        }
        String[] strArr = (i == 0 || i2 != 0) ? new String[]{this.bAG.tTq.getMMResources().getString(R.l.location_send_poi)} : new String[]{this.bAG.tTq.getMMResources().getString(R.l.location_send_poi), this.bAG.tTq.getMMResources().getString(R.l.location_send_share)};
        h.a(this.bAG.tTq.getContext(), null, strArr, null, new 1(this));
    }

    public final void cvG() {
        Intent intent = new Intent();
        com.tencent.mm.plugin.report.service.h.mEJ.h(12809, new Object[]{Integer.valueOf(1), ""});
        intent.putExtra("map_view_type", 0);
        intent.putExtra("map_sender_name", this.bAG.cwp());
        intent.putExtra("map_talker_name", this.bAG.getTalkerUserName());
        d.b(this.bAG.tTq.getContext(), "location", ".ui.RedirectUI", intent);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cvH() {
        /*
        r5 = this;
        r1 = 1;
        r0 = r5.bAG;
        r0 = r0.tTq;
        r0 = r0.getContext();
        r0 = com.tencent.mm.p.a.by(r0);
        if (r0 != 0) goto L_0x0043;
    L_0x000f:
        r0 = r5.bAG;
        r0 = r0.tTq;
        r0 = r0.getContext();
        r0 = com.tencent.mm.p.a.bw(r0);
        if (r0 != 0) goto L_0x0043;
    L_0x001d:
        r0 = com.tencent.mm.pluginsdk.o.a.qyi;
        r2 = r5.bAG;
        r2 = r2.getTalkerUserName();
        r0 = r0.HC(r2);
        if (r0 == 0) goto L_0x0044;
    L_0x002b:
        r0 = "MicroMsg.ChattingUI.LocationComponent";
        r1 = "click share location, but now is in multitalk!";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r5.bAG;
        r0 = r0.tTq;
        r0 = r0.getContext();
        r1 = com.tencent.mm.R.l.multitalk_exit_tip;
        r2 = com.tencent.mm.R.l.app_tip;
        com.tencent.mm.ui.base.h.i(r0, r1, r2);
    L_0x0043:
        return;
    L_0x0044:
        r0 = 0;
        r2 = new com.tencent.mm.g.a.rn;
        r2.<init>();
        r3 = com.tencent.mm.ax.g.elf;
        if (r3 == 0) goto L_0x006f;
    L_0x004e:
        r3 = r2.ccn;
        r3.ccp = r1;
        r3 = com.tencent.mm.sdk.b.a.sFg;
        r3.m(r2);
        r2 = r2.cco;
        r2 = r2.ccr;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 != 0) goto L_0x00cb;
    L_0x0061:
        r0 = r5.bAG;
        r0 = r0.tTq;
        r0 = r0.getMMResources();
        r2 = com.tencent.mm.R.l.enter_track_myself_talking_err;
        r0 = r0.getString(r2);
    L_0x006f:
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r2 != 0) goto L_0x00e8;
    L_0x0075:
        r2 = 0;
        r3 = com.tencent.mm.ay.d.elh;
        if (r3 == 0) goto L_0x00fa;
    L_0x007a:
        r3 = com.tencent.mm.ay.d.elh;
        r4 = r5.bAG;
        r4 = r4.oLT;
        r4 = r4.field_username;
        r3 = r3.nt(r4);
        if (r3 == 0) goto L_0x00fa;
    L_0x0088:
        r3 = com.tencent.mm.ay.d.elh;
        r4 = r5.bAG;
        r4 = r4.oLT;
        r4 = r4.field_username;
        r3 = r3.ns(r4);
        if (r3 == 0) goto L_0x00fa;
    L_0x0096:
        r4 = r5.bAG;
        r4 = r4.cwp();
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x00fa;
    L_0x00a2:
        if (r1 != 0) goto L_0x00e8;
    L_0x00a4:
        r1 = new com.tencent.mm.ui.widget.a.c$a;
        r2 = r5.bAG;
        r2 = r2.tTq;
        r2 = r2.getContext();
        r1.<init>(r2);
        r1.abu(r0);
        r0 = com.tencent.mm.R.l.i_know_it;
        r0 = r1.Gt(r0);
        r2 = new com.tencent.mm.ui.chatting.b.x$2;
        r2.<init>(r5);
        r0.a(r2);
        r0 = r1.anj();
        r0.show();
        goto L_0x0043;
    L_0x00cb:
        r2 = com.tencent.mm.ax.g.elf;
        r3 = r5.bAG;
        r3 = r3.getTalkerUserName();
        r2 = r2.nq(r3);
        if (r2 == 0) goto L_0x006f;
    L_0x00d9:
        r0 = r5.bAG;
        r0 = r0.tTq;
        r0 = r0.getMMResources();
        r2 = com.tencent.mm.R.l.enter_track_other_talking_err;
        r0 = r0.getString(r2);
        goto L_0x006f;
    L_0x00e8:
        r0 = r5.bAG;
        r1 = com.tencent.mm.ui.chatting.b.b.ac.class;
        r0 = r0.O(r1);
        r0 = (com.tencent.mm.ui.chatting.b.b.ac) r0;
        r1 = "fromPluginLocation";
        r0.aar(r1);
        goto L_0x0043;
    L_0x00fa:
        r1 = r2;
        goto L_0x00a2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.b.x.cvH():void");
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case i$l.AppCompatTheme_textColorSearchUrl /*67*/:
            case i$l.AppCompatTheme_searchViewStyle /*68*/:
                if (iArr[0] != 0) {
                    h.a(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.permission_location_request_again_msg), this.bAG.tTq.getMMResources().getString(R.l.permission_tips_title), this.bAG.tTq.getMMResources().getString(R.l.jump_to_settings), this.bAG.tTq.getMMResources().getString(R.l.cancel), false, new 3(this), null);
                    return;
                } else if (i == 67) {
                    cvG();
                    return;
                } else {
                    cvH();
                    return;
                }
            default:
                return;
        }
    }

    public final void cun() {
        super.cun();
        iy iyVar = new iy();
        iyVar.bSB.bSv = 2;
        com.tencent.mm.sdk.b.a.sFg.m(iyVar);
    }

    public final void cpG() {
        iy iyVar = new iy();
        iyVar.bSB.bSv = 0;
        iyVar.bSB.aem = w.chP();
        if (s.fq(this.bAG.oLT.field_username)) {
            iyVar.bSB.bSD = true;
        } else {
            iyVar.bSB.bSD = false;
        }
        com.tencent.mm.sdk.b.a.sFg.m(iyVar);
    }

    public final void cpK() {
        com.tencent.mm.sdk.b.a.sFg.m(new bk());
    }
}
