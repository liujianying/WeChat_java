package com.tencent.mm.plugin.masssend.ui;

import android.media.ToneGenerator;
import android.os.Vibrator;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.i.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.masssend.a.f;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import java.util.List;

public final class b implements com.tencent.mm.pluginsdk.ui.chat.b {
    final al erD = new al(new 1(this), true);
    private final a hnC = new 2(this);
    ToneGenerator hnf;
    long hng = -1;
    Toast hnh;
    private Vibrator hni;
    final al hnz = new al(new 4(this), true);
    ChatFooter laA;
    a laB;
    private String laC;
    private List<String> laD;
    private boolean laE;
    private final com.tencent.mm.ab.i.b laF = new 3(this);
    MassSendMsgUI laz;
    p tipDialog = null;

    public b(MassSendMsgUI massSendMsgUI, ChatFooter chatFooter, String str, List<String> list, boolean z) {
        this.laz = massSendMsgUI;
        this.laA = chatFooter;
        this.laC = str;
        this.laD = list;
        this.laE = z;
        this.laB = new a(this, massSendMsgUI);
        this.laB.a(this.hnC);
        this.laB.a(this.laF);
        this.hnf = new ToneGenerator(1, 60);
        this.hni = (Vibrator) massSendMsgUI.getSystemService("vibrator");
    }

    public final boolean bcq() {
        this.erD.SO();
        this.hnz.SO();
        this.hng = -1;
        if (this.laB.wk()) {
            bcr();
            this.laA.aMo();
        } else {
            this.laA.cen();
        }
        au.vv().xu();
        return false;
    }

    final void bcr() {
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.laj = this.laC;
        aVar.lak = this.laD.size();
        aVar.filename = this.laB.fileName;
        aVar.msgType = 34;
        aVar.lal = this.laB.bER;
        f fVar = new f(aVar, this.laE);
        au.DF().a(fVar, 0);
        MassSendMsgUI massSendMsgUI = this.laz;
        this.laz.getString(R.l.app_tip);
        this.tipDialog = h.a(massSendMsgUI, this.laz.getString(R.l.sendrequest_sending), true, new 5(this, fVar));
    }

    public final boolean bcs() {
        this.erD.SO();
        this.hnz.SO();
        this.hng = -1;
        this.laA.aMo();
        a aVar = this.laB;
        aVar.wk();
        q.oq(aVar.fileName);
        au.vv().xu();
        return false;
    }

    public final boolean bct() {
        au.HU();
        if (c.isSDCardAvailable()) {
            this.hnf.startTone(24);
            new ag().postDelayed(new 6(this), 200);
            this.hni.vibrate(50);
            this.erD.J(100, 100);
            this.hnz.J(200, 200);
            this.laA.Ci(this.laz.getResources().getDisplayMetrics().heightPixels - this.laA.getHeight());
            this.laB.dd("_USER_FOR_THROWBOTTLE_");
            this.laB.a(this.laF);
            this.laB.a(this.hnC);
            au.vv().xv();
        } else {
            s.gH(this.laz);
        }
        return false;
    }

    public final boolean Gk(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        MassSendMsgUI.Go(str);
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.laj = this.laC;
        aVar.lak = this.laD.size();
        aVar.filename = str;
        aVar.msgType = 1;
        f fVar = new f(aVar, this.laE);
        au.DF().a(fVar, 0);
        MassSendMsgUI massSendMsgUI = this.laz;
        this.laz.getString(R.l.app_tip);
        this.tipDialog = h.a(massSendMsgUI, this.laz.getString(R.l.sendrequest_sending), true, new 7(this, fVar));
        return true;
    }

    public final void bcu() {
    }

    public final void bcv() {
    }

    public final void bcw() {
    }

    public final void release() {
        this.hnf.release();
    }

    public final void onPause() {
        this.erD.SO();
        this.hnz.SO();
        this.hng = -1;
        this.laB.wk();
        au.vv().xu();
    }

    public final void gq(boolean z) {
    }
}
