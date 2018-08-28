package com.tencent.mm.ui.chatting.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.e.n;
import com.tencent.mm.g.a.bu;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.br;
import com.tencent.mm.model.s;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.bbom.r;
import com.tencent.mm.plugin.setting.model.j;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bn;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.aa;
import com.tencent.mm.ui.chatting.b.b.m;
import com.tencent.mm.ui.chatting.b.b.q;
import com.tencent.mm.ui.chatting.z;
import java.util.LinkedList;
import java.util.List;

@a(cwo = aa.class)
public class af extends a implements e, aa {
    private boolean tOB = false;
    private z tRT;
    private int tRU;

    public final boolean aaq(String str) {
        return dn(str, 0);
    }

    private boolean dn(String str, final int i) {
        int i2 = 0;
        final String Xj = bi.Xj(str);
        if (Xj == null || Xj.length() == 0) {
            x.e("MicroMsg.ChattingUI.SendTextComponent", "doSendMessage null");
            return false;
        }
        z zVar = this.tRT;
        if (!ai.oW(Xj)) {
            bd bdVar = new bd();
            bdVar.setContent(Xj);
            bdVar.eX(1);
            zVar.aF(bdVar);
        }
        bu buVar = new bu();
        buVar.bJj.bJl = Xj;
        buVar.bJj.context = this.bAG.tTq.getContext();
        com.tencent.mm.sdk.b.a.sFg.m(buVar);
        if (buVar.bJk.bJm) {
            return true;
        }
        boolean z = HardCoderJNI.hcSendMsgEnable;
        int i3 = HardCoderJNI.hcSendMsgDelay;
        int i4 = HardCoderJNI.hcSendMsgCPU;
        int i5 = HardCoderJNI.hcSendMsgIO;
        if (HardCoderJNI.hcSendMsgThr) {
            i2 = g.Em().cij();
        }
        this.tRU = HardCoderJNI.startPerformance(z, i3, i4, i5, i2, HardCoderJNI.hcSendMsgTimeout, 202, HardCoderJNI.hcSendMsgAction, "MicroMsg.ChattingUI.SendTextComponent");
        com.tencent.mm.ui.chatting.c.a.cwt().post(new Runnable() {
            public final void run() {
                if (af.this.bAG == null) {
                    x.w("MicroMsg.ChattingUI.SendTextComponent", "NULL == mChattingContext");
                    return;
                }
                com.tencent.mm.plugin.report.service.g.vu(20);
                if (af.a(af.this)) {
                    af.this.bAG.cwp();
                    au.DF().a(new com.tencent.mm.ah.a(af.this.bAG.oLT.field_username, Xj), 0);
                    return;
                }
                if (((com.tencent.mm.ui.chatting.b.b.g) af.this.bAG.O(com.tencent.mm.ui.chatting.b.b.g.class)).getCount() == 0 && ab.XQ(af.this.bAG.getTalkerUserName())) {
                    br.IE().c(10076, new Object[]{Integer.valueOf(1)});
                }
                String talkerUserName = af.this.bAG.getTalkerUserName();
                int hQ = s.hQ(talkerUserName);
                String str = Xj;
                String aao = ((q) af.this.bAG.O(q.class)).aao(talkerUserName);
                if (bi.oW(aao)) {
                    x.w("MicroMsg.ChattingUI.SendTextComponent", "tempUser is null");
                    return;
                }
                m mVar = (m) af.this.bAG.O(m.class);
                ChatFooter cvb = mVar.cvb();
                int i = i;
                int i2 = cvb.qLy.qMD.containsKey(talkerUserName) ? ((LinkedList) cvb.qLy.qMD.get(talkerUserName)).size() > 0 ? 291 : i : i;
                i iVar = new i(aao, str, hQ, i2, mVar.cvb().fD(talkerUserName, str));
                ((q) af.this.bAG.O(q.class)).g(iVar);
                au.DF().a(iVar, 0);
                if (s.hM(talkerUserName)) {
                    au.DF().a(new j(com.tencent.mm.compatible.e.q.zO(), Xj + " key " + bn.cmZ() + " local key " + bn.cmY() + "NetType:" + ao.getNetTypeString(af.this.bAG.tTq.getContext().getApplicationContext()) + " hasNeon: " + n.zp() + " isArmv6: " + n.zr() + " isArmv7: " + n.zq()), 0);
                }
            }
        });
        this.bAG.lT(true);
        return true;
    }

    public final void a(com.tencent.mm.ui.chatting.c.a aVar) {
        super.a(aVar);
        this.tRT = new z(this.bAG);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 207:
                dn(intent.getStringExtra("art_smiley_slelct_data"), 4);
                return;
            default:
                return;
        }
    }

    public final void cpG() {
        r.a(this.tRT);
        this.tOB = true;
    }

    public final void cpH() {
        au.DF().a(522, this);
        List cvI = ((com.tencent.mm.ui.chatting.b.b.s) this.bAG.O(com.tencent.mm.ui.chatting.b.b.s.class)).cvI();
        if (cvI != null) {
            z zVar = this.tRT;
            if (zVar.tMr != null && zVar.bAG != null) {
                ac acVar = zVar.tMr;
                Activity context = zVar.bAG.tTq.getContext();
                acVar.huM = cvI;
                acVar.tMt = context;
                if (acVar.mHandler != null) {
                    acVar.mHandler.sendEmptyMessageDelayed(0, 300);
                }
            }
        }
    }

    public final void cpI() {
        if (!this.tOB) {
            r.a(this.tRT);
        }
        this.tOB = false;
    }

    public final void cpJ() {
        r.b(this.tRT);
    }

    public final void cpK() {
        au.DF().b(522, this);
        if (this.tRT != null) {
            z zVar = this.tRT;
            if (zVar.tMr != null) {
                ac acVar = zVar.tMr;
                acVar.mHandler.removeMessages(0);
                if (acVar.tMs != null) {
                    acVar.tMs.stop();
                }
                x.d("MicroMsg.EggMgr", "egg has been stop");
            }
        }
        HardCoderJNI.stopPerformace(HardCoderJNI.hcSendMsgEnable, this.tRU);
        this.tRU = 0;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.bAG != null) {
            this.bAG.dismissDialog();
        }
        if (522 == lVar.getType()) {
            HardCoderJNI.stopPerformace(HardCoderJNI.hcSendMsgEnable, this.tRU);
            this.tRU = 0;
        }
    }
}
