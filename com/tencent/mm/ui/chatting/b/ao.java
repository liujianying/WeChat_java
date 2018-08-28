package com.tencent.mm.ui.chatting.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.d.b;
import com.tencent.mm.g.a.st;
import com.tencent.mm.model.am;
import com.tencent.mm.model.am.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.c;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.ag;
import com.tencent.mm.ui.chatting.b.b.h;
import com.tencent.mm.ui.chatting.b.b.m;
import com.tencent.mm.ui.chatting.b.b.o;
import com.tencent.mm.ui.w;

@a(cwo = ag.class)
public class ao extends a implements e, ag {
    public boolean hmc = false;
    private d otS = new 1(this);
    private com.tencent.mm.ui.chatting.d tJL = null;
    private View tTh = null;
    public c tTi = new 2(this);

    public final com.tencent.mm.ui.chatting.d cwl() {
        return this.tJL;
    }

    public final boolean BD() {
        boolean cur = ((com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).cur();
        boolean cus = ((com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).cus();
        int i = (s.fq(this.bAG.getTalkerUserName()) || cus) ? 1 : 0;
        if (!cur) {
            return (i != 0 && this.bAG.oLT.csI == 0) || this.bAG.oLT.BD();
        } else {
            if (cus) {
                return ((com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).cup().hu(1);
            }
            return ((com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).cuq().hu(1);
        }
    }

    public final void cwm() {
        o oVar = (o) this.bAG.O(o.class);
        if (((h) this.bAG.O(h.class)).cuS()) {
            x.d("MicroMsg.ChattingUI.VoiceComponent", "trigger title icon, in show mode");
            this.bAG.lZ(false);
            oVar.setTitlePhoneIconVisibility(8);
            oVar.setTitleMuteIconVisibility(8);
            return;
        }
        int i;
        if (BD()) {
            oVar.setTitleMuteIconVisibility(0);
        } else {
            oVar.setTitleMuteIconVisibility(8);
        }
        au.HU();
        Boolean bool = (Boolean) com.tencent.mm.model.c.DT().get(26, null);
        if (bool == null) {
            this.hmc = false;
        } else {
            this.hmc = bool.booleanValue();
        }
        if (this.hmc) {
            i = 0;
        } else {
            i = 8;
        }
        oVar.setTitlePhoneIconVisibility(i);
    }

    public final void acquireWakeLock() {
        this.bAG.setKeepScreenOn(true);
    }

    public final void releaseWakeLock() {
        this.bAG.setKeepScreenOn(false);
    }

    public final boolean cwn() {
        return this.hmc;
    }

    public final void lY(boolean z) {
        if (this.tJL == null) {
            x.e("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff error, autoPlay is null!!!");
            return;
        }
        o oVar = (o) this.bAG.O(o.class);
        if (z) {
            this.tJL.hlZ = false;
            this.hmc = true;
            au.HU();
            com.tencent.mm.model.c.DT().set(26, Boolean.valueOf(true));
            oVar.setTitlePhoneIconVisibility(0);
            Toast.makeText(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.fmt_route_phone), 0).show();
            this.tJL.csP();
            this.bAG.Fh(R.k.actionbar_ear_icon);
            return;
        }
        if (au.HV().yE()) {
            x.i("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff true but isBluetoothOn");
        } else {
            this.tJL.hlZ = true;
        }
        this.hmc = false;
        au.HU();
        com.tencent.mm.model.c.DT().set(26, Boolean.valueOf(false));
        oVar.setTitlePhoneIconVisibility(8);
        Toast.makeText(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.fmt_route_speaker), 0).show();
        this.tJL.csP();
        this.bAG.Fh(R.k.actionbar_loud_icon);
    }

    public final boolean be(bd bdVar) {
        if (!bdVar.ckz()) {
            return false;
        }
        if (bdVar.field_msgId == this.tJL.tHf) {
            this.tJL.csQ();
        }
        return true;
    }

    public final boolean bf(bd bdVar) {
        if (!bdVar.ckz()) {
            return false;
        }
        au.HU();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            if (bdVar.field_msgId == this.tJL.tHf) {
                this.tJL.csQ();
            }
            if (!this.bAG.getTalkerUserName().equals("medianote")) {
                au.HU();
                com.tencent.mm.model.c.FQ().b(new com.tencent.mm.aq.e(bdVar.field_talker, bdVar.field_msgSvrId));
            }
            ak.aH(bdVar);
            return true;
        }
        com.tencent.mm.ui.base.s.gH(this.bAG.tTq.getContext());
        return true;
    }

    @TargetApi(9)
    public final void a(com.tencent.mm.ui.x xVar, boolean z) {
        if (!xVar.getLandscapeMode()) {
            return;
        }
        if (!z) {
            xVar.setRequestedOrientation(-1);
        } else if (VERSION.SDK_INT >= 9) {
            x.i("MicroMsg.ChattingUI.VoiceComponent", "rotation %d", new Object[]{Integer.valueOf(xVar.getWindowManager().getDefaultDisplay().getOrientation())});
            switch (xVar.getWindowManager().getDefaultDisplay().getOrientation()) {
                case 0:
                    xVar.setRequestedOrientation(1);
                    return;
                case 1:
                    xVar.setRequestedOrientation(0);
                    return;
                case 2:
                    xVar.setRequestedOrientation(9);
                    return;
                case 3:
                    xVar.setRequestedOrientation(8);
                    return;
                default:
                    return;
            }
        } else if (this.bAG.tTq.getMMResources().getConfiguration().orientation == 2) {
            xVar.setRequestedOrientation(0);
        } else if (this.bAG.tTq.getMMResources().getConfiguration().orientation == 1) {
            xVar.setRequestedOrientation(1);
        }
    }

    public final void cun() {
        super.cun();
        r.b(this.tJL);
        com.tencent.mm.modelvoice.e.b(this.tJL);
        releaseWakeLock();
        if (this.tJL != null) {
            this.tJL.csL();
            com.tencent.mm.ui.chatting.d dVar = this.tJL;
            dVar.release();
            dVar.context = null;
            dVar.tHl = false;
            com.tencent.mm.sdk.b.a.sFg.c(dVar.tHq);
            au.vv().b(dVar);
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        int i2 = 0;
        if (i == 25 && this.tJL != null && this.tJL.isPlaying() && (this.hmc || !this.tJL.hlZ)) {
            if (keyEvent.getAction() == 0) {
                if (au.HV().yE() && !au.HV().yK()) {
                    i2 = au.HV().yQ();
                }
                au.HV().fE(i2);
            }
            return true;
        } else if (i != 24 || this.tJL == null || !this.tJL.isPlaying()) {
            return false;
        } else {
            if (!this.hmc && this.tJL.hlZ) {
                return false;
            }
            if (keyEvent.getAction() == 0) {
                if (au.HV().yE() && !au.HV().yK()) {
                    i2 = au.HV().yQ();
                }
                au.HV().fD(i2);
            }
            return true;
        }
    }

    public final void cpG() {
        cwm();
    }

    public final void cpH() {
        au.DF().a(127, this);
    }

    public final void cpI() {
        x.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay looper[%s]", new Object[]{Looper.myLooper()});
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.ChattingUI.VoiceComponent", "resetAutoPlay autoPlay is:%s tid:%d looper:%s", new Object[]{this.tJL, Long.valueOf(Thread.currentThread().getId()), Looper.myLooper()});
        if (this.tJL == null) {
            this.tJL = new com.tencent.mm.ui.chatting.d(this.bAG, this, this.bAG.getTalkerUserName());
            r.c(this.tJL);
            com.tencent.mm.modelvoice.e.a(this.tJL);
        } else {
            this.tJL.aai(this.bAG.getTalkerUserName());
        }
        au.HU();
        boolean a = bi.a((Boolean) com.tencent.mm.model.c.DT().get(16387, null), true);
        com.tencent.mm.ui.chatting.d dVar = this.tJL;
        if (!dVar.tHl) {
            dVar.tHj = a;
            dVar.csL();
        }
        com.tencent.mm.ac.d cuo = ((com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).cuo();
        if (cuo != null) {
            b bG = cuo.bG(false);
            if (bG != null) {
                if (bG.dKT != null) {
                    bG.dLi = bG.dKT.optInt("AudioPlayType", 0) == 1;
                }
                if (bG.dLi) {
                    this.tJL.tHk = false;
                }
            }
        }
        this.tJL.hlZ = !this.hmc;
        this.tJL.bhU();
        x.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay end take[%s]ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        if (s.hC(this.bAG.getTalkerUserName()) && am.a.dBu != null) {
            am.a.dBu.a(this.otS);
        }
        if (!com.tencent.mm.al.b.Pz()) {
            ((m) this.bAG.O(m.class)).setVoiceInputShowCallback(this.tTi);
        }
        cwm();
    }

    public final void cpJ() {
        if (s.hC(this.bAG.getTalkerUserName()) && am.a.dBu != null) {
            am.a.dBu.b(this.otS);
        }
        if (this.tTh != null && this.tTh.getVisibility() == 0) {
            x.i("MicroMsg.ChattingUI.VoiceComponent", "doPause set voiceinputMask GONE");
            this.tTh.setVisibility(8);
        }
        ((m) this.bAG.O(m.class)).setVoiceInputShowCallback(null);
        au.HU();
        com.tencent.mm.model.c.DT().set(26, Boolean.valueOf(this.hmc));
        if (!(com.tencent.mm.ui.s.cqn() || this.tJL == null)) {
            this.tJL.csL();
            this.tJL.csQ();
            this.tJL.release();
        }
        st stVar = new st();
        com.tencent.mm.sdk.b.a.sFg.m(stVar);
        if (!stVar.cdA.cdD && !com.tencent.mm.p.a.BQ()) {
            au.HV().yC();
        }
    }

    public final void cpK() {
        au.DF().b(127, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        boolean z = true;
        x.i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " sceneType:" + lVar.getType());
        this.bAG.dismissDialog();
        if (!this.bAG.eaR) {
            x.i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd fragment not foreground, return");
        } else if (bi.ci(this.bAG.tTq.getContext())) {
            Context context = this.bAG.tTq.getContext();
            if (!(w.a.a(context, i, i2, str, 7) || w.a(context, i, i2, new Intent().setClass(context, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str))) {
                z = false;
            }
            if (!z && i == 0 && i2 == 0) {
                switch (lVar.getType()) {
                    case 127:
                        p ot = q.ot(((f) lVar).fileName);
                        if (ot != null && ot.status == 99) {
                            as.I(this.bAG.tTq.getContext(), R.l.after_upload_voice);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
