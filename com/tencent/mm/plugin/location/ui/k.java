package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.os.Looper;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.mm.ab.e;
import com.tencent.mm.ax.c;
import com.tencent.mm.ax.d;
import com.tencent.mm.ax.g;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.model.am;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.ui.VolumeMeter.1;
import com.tencent.mm.plugin.map.a;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class k implements e, d {
    private Activity activity;
    private List<String> bTR = new LinkedList();
    long kGA = 0;
    al kGB = new al(new 1(this), false);
    al kGC = new al(new 2(this), false);
    private al kGD = new al(new 3(this), false);
    public c kGE;
    public a kGF;
    final al kGG = new al(new 5(this), true);
    private boolean kGH = true;
    Button kGq;
    public VolumeMeter kGr;
    RelativeLayout kGs;
    private boolean kGt = true;
    private String kGu;
    String kGv;
    private String kGw;
    boolean kGx = false;
    int kGy = 0;
    private long kGz = 500;

    static /* synthetic */ void a(k kVar) {
        if (kVar.kGy == 5) {
            kVar.kGy = 3;
            kVar.kGE.Sn();
            kVar.kGG.J(100, 100);
        }
    }

    public k(Activity activity, Button button) {
        this.activity = activity;
        this.kGq = button;
        this.kGs = (RelativeLayout) this.activity.findViewById(a.e.volume_layout);
        this.kGs.setVisibility(8);
        this.kGr = (VolumeMeter) this.kGs.findViewById(a.e.volume_meter);
        this.kGr.setArchView(this.kGq);
        VolumeMeter volumeMeter = this.kGr;
        if (volumeMeter.kHo == null) {
            com.tencent.mm.sdk.f.e.d(new 1(volumeMeter), "VolumeMeter_handler", 1).start();
        }
        this.kGE = g.elg;
        if (this.kGE == null) {
            x.e("MicroMsg.TalkMgr", "cannot get talkroom server");
        }
    }

    public final void aZI() {
        this.kGw = this.activity.getIntent().getStringExtra("map_talker_name");
        this.kGE.a(this);
        x.d("MicroMsg.TalkMgr", "talkRoomName %s ", new Object[]{this.kGw});
        String str = this.kGw;
        this.kGu = str;
        if (!bi.oW(this.kGu)) {
            if (s.fq(str)) {
                List gI = m.gI(str);
                if (gI == null) {
                    am.a.dBr.R(str, "");
                } else {
                    this.bTR = gI;
                }
            } else {
                this.bTR.clear();
                this.bTR.add(str);
                this.bTR.add(q.GF());
            }
            new ag(Looper.getMainLooper()).post(new 6(this, str));
            this.kGq.setOnTouchListener(new 7(this));
        }
    }

    final void aZJ() {
        if (this.kGy == 5) {
            this.kGB.SO();
            aZK();
            as.b(ad.getContext(), h.talkroom_begin, new as.a() {
                public final void wd() {
                    k.this.kGC.SO();
                    k.a(k.this);
                }
            });
            this.kGC.J(1000, 1000);
        }
    }

    final void aZK() {
        if (!this.kGt) {
            if (g.elg.Ss()) {
                x.d("MicroMsg.TalkMgr", "talkRoomServer pausing");
                if (this.kGF != null) {
                    this.kGF.FU(null);
                    this.kGF.aZG();
                }
            }
            switch (this.kGy) {
                case 0:
                    x.d("MicroMsg.TalkMgr", "seize, state_idle, curUsername = %s", new Object[]{this.kGv});
                    if (this.kGF == null) {
                        return;
                    }
                    if (bi.oW(this.kGv)) {
                        this.kGF.FU(null);
                        return;
                    } else {
                        this.kGF.FU(this.kGv);
                        return;
                    }
                case 1:
                    x.d("MicroMsg.TalkMgr", "seize, state seizing");
                    if (this.kGF != null) {
                        this.kGF.aZH();
                        return;
                    }
                    return;
                case 2:
                    x.d("MicroMsg.TalkMgr", "seize error, curUsername = %s", new Object[]{this.kGv});
                    if (this.kGF != null && !bi.oW(this.kGv)) {
                        this.kGF.FV(this.kGv);
                        return;
                    }
                    return;
                case 3:
                case 5:
                    x.d("MicroMsg.TalkMgr", "seize, state success or prepare");
                    if (this.kGF != null) {
                        this.kGF.aZF();
                        return;
                    }
                    return;
                case 4:
                    x.d("MicroMsg.TalkMgr", "seize time out");
                    return;
                default:
                    return;
            }
        }
    }

    public static void aZL() {
        rn rnVar = new rn();
        rnVar.ccn.ccq = true;
        com.tencent.mm.sdk.b.a.sFg.m(rnVar);
        f.yz().setMode(0);
    }

    public final void St() {
        this.kGt = false;
        this.kGq.setEnabled(true);
        aZK();
    }

    public final void i(String str, int i, int i2) {
        x.f("MicroMsg.TalkMgr", "onInitFailed %s", new Object[]{str});
        l.aZi().rP(3);
        this.activity.finish();
    }

    public final void Su() {
        if (this.kGy == 1) {
            this.kGy = 5;
            if (bi.bI(this.kGA) < this.kGz) {
                x.i("MicroMsg.TalkMgr", "onSeizeMicSuccess waiting to execute");
                long bI = this.kGz - bi.bI(this.kGA);
                this.kGB.J(bI, bI);
                return;
            }
            aZJ();
        }
    }

    public final void iA(int i) {
        x.i("MicroMsg.TalkMgr", "onSeizeMicFailed");
        if (i == 340) {
            if (this.kGy == 3) {
                this.kGy = 4;
            } else {
                return;
            }
        } else if (this.kGy == 1) {
            this.kGy = 2;
        } else {
            return;
        }
        aZK();
        as.a(ad.getContext(), h.talkroom_sasasa, null);
    }

    public final void nr(String str) {
        x.d("MicroMsg.TalkMgr", "onCurMember change %s", new Object[]{str});
        this.kGv = str;
        aZK();
        if (bi.oW(str)) {
            this.kGG.SO();
            return;
        }
        as.I(ad.getContext(), h.talkroom_othersbegin);
        this.kGG.J(100, 100);
    }

    public final void ay(String str, String str2) {
        x.i("MicroMsg.TalkMgr", "add %s,  del %s", new Object[]{str, str2});
        if (!this.kGt) {
        }
    }

    public final void b(int i, int i2, String str) {
    }

    public final void Sv() {
    }

    public final void Sw() {
        aZK();
    }

    public final void Sx() {
        aZK();
    }

    public final void Sy() {
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
    }
}
