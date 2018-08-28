package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.b.b;
import com.tencent.mm.plugin.ipcall.a.b.b.a;
import com.tencent.mm.plugin.ipcall.a.b.d;
import com.tencent.mm.plugin.ipcall.a.b.d.1;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.c;
import com.tencent.mm.plugin.ipcall.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public final class j implements a, e {
    ImageView eBM;
    TextView eBR;
    String eWQ;
    DialPad ksT;
    String kvn;
    String kvo;
    String kvp;
    String kvq;
    int kvr;
    int kvs;
    EditText kzB;
    TextView kzC;
    ImageView kzD;
    IPCallFuncButton kzE;
    IPCallFuncButton kzF;
    IPCallFuncButton kzG;
    ImageButton kzH;
    public TextView kzI;
    public View kzJ;
    ImageButton kzK;
    int kzL = -1;
    String kzM;
    IPCallTalkUI kzN;
    c kzO;
    a kzP;
    private long kzQ;
    long kzR = -1;
    boolean kzS = false;
    boolean kzT = false;
    private AudioManager kzU = null;
    boolean kzV = false;
    private boolean kzW = true;
    boolean kzX = false;
    Bitmap kzs;

    static /* synthetic */ void b(j jVar) {
        jVar.kzO.cK(0, 0);
        au.getNotification().cancel(42);
        jVar.kzN.finish();
    }

    public j(IPCallTalkUI iPCallTalkUI) {
        this.kzN = iPCallTalkUI;
        this.kzO = i.aXu();
        this.kzO.knQ = this;
    }

    private void f(String str, String str2, int i, String str3) {
        String str4;
        aYv();
        if (!bi.oW(str)) {
            str4 = str;
        } else if (bi.oW(str3)) {
            str4 = this.kzN.getString(R.l.ip_call_alter_tip);
        } else {
            str4 = str3;
        }
        if (2 == i && str2 != null) {
            this.eBR.setText(str2);
        } else if (1 == i && str2 != null) {
            h.a(this.kzN, str2, str4, this.kzN.getString(R.l.ip_call_alter_tip_ok), false, new 7(this));
        }
    }

    final void aYt() {
        i.aXs().bGc = this.kzN;
        b aXs = i.aXs();
        aXs.kqd.kqu = aXs;
        d dVar = aXs.kqd;
        if (!dVar.hlW.sIY) {
            dVar.hlW.a(dVar);
            if (dVar.hma.Q(new 1(dVar))) {
                dVar.hmb = 0;
            } else {
                dVar.hmb = -1;
            }
        }
        i.aXs().kqh = this;
        i.aXs().a(this);
    }

    final void aYu() {
        this.kzB.setKeyListener(null);
        this.kzB.setHorizontallyScrolling(true);
        this.ksT.setVisibility(4);
        this.ksT.setTalkUIMode(true);
        if (!bi.oW(this.kzM)) {
            Fj(this.kzM);
        }
        if (com.tencent.mm.compatible.util.d.fR(16)) {
            this.kzB.setTypeface(Typeface.create("sans-serif-light", 0));
            this.kzC.setTypeface(Typeface.create("sans-serif-light", 0));
        }
        if (!bi.oW(this.kvo)) {
            this.kzs = com.tencent.mm.plugin.ipcall.b.a.f(this.kzN, this.kvo, true);
        }
        if (this.kzs == null && !bi.oW(this.kvn) && com.tencent.mm.plugin.ipcall.b.a.XF()) {
            this.kzs = com.tencent.mm.plugin.ipcall.b.a.az(this.kzN, this.kvn);
        }
        if (this.kzs == null && !bi.oW(this.kvq)) {
            this.kzs = com.tencent.mm.aa.c.c(this.kvq, 480, 480, 4);
        }
        if (this.kzs == null) {
            this.kzD.setVisibility(0);
            this.eBM.setVisibility(8);
        }
        if (this.kzs != null) {
            this.kzD.setVisibility(8);
            this.eBM.setVisibility(0);
            this.eBM.setImageBitmap(this.kzs);
        }
        this.kzK.setOnClickListener(new 8(this));
        this.kzG.setClickCallback(new 9(this));
        this.kzE.setClickCallback(new 10(this));
        this.kzF.setClickCallback(new 11(this));
        this.kzH.setOnClickListener(new 12(this));
        this.ksT.setDialButtonClickListener(new DialPad.a() {
            public final void EU(String str) {
                String obj = j.this.kzB.getText().toString();
                if (bi.oW(obj)) {
                    j.this.kzR = System.currentTimeMillis();
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - j.this.kzR >= 3000) {
                    obj = obj + " ";
                }
                obj = obj + str;
                j.this.kzR = currentTimeMillis;
                j.this.dt(obj, "");
                c.EL(str);
                com.tencent.mm.plugin.report.service.h.mEJ.h(12057, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
            }

            public final void EV(String str) {
            }
        });
    }

    final void Fj(String str) {
        if (bi.oW(this.eWQ)) {
            dt(com.tencent.mm.plugin.ipcall.b.a.Ft(str), "");
        } else {
            dt(this.eWQ, com.tencent.mm.plugin.ipcall.b.a.Ft(str));
        }
    }

    final void dt(String str, String str2) {
        this.kzB.setText(str);
        if (!bi.oW(str)) {
            this.kzB.setSelection(this.kzB.getText().length() - 1);
        }
        this.kzC.setText(str2);
    }

    public final void rJ(int i) {
        switch (i) {
            case 3:
                int i2 = i.aXp().koG.kpE;
                Context context = ad.getContext();
                r0 = ((i2 & 1) <= 0 || (i2 & 2) > 0) ? (i2 & 8) > 0 ? context.getString(R.l.ipcall_talk_in_package) + " " : "" : context.getString(R.l.ipcall_talk_free) + " ";
                if (this.kzL != -1) {
                    String rK = com.tencent.mm.plugin.ipcall.b.a.rK(this.kzL);
                    this.eBR.setText(r0 + this.kzN.getString(R.l.ip_call_status_calling_format, new Object[]{rK}));
                    return;
                }
                this.eBR.setText(r0 + this.kzN.getString(R.l.ip_call_status_calling));
                return;
            case 5:
                this.eBR.setText(String.format("%02d:%02d", new Object[]{Long.valueOf(this.kzQ / 60), Long.valueOf(this.kzQ % 60)}));
                return;
            case 10:
                this.eBR.setText(R.l.ip_call_status_other_side_shutdown);
                return;
            default:
                return;
        }
    }

    public final void aWH() {
        int i = 0;
        x.i("MicroMsg.TalkUIController", "onInviteSuccess");
        String str = i.aXp().koG.kpQ;
        String str2 = i.aXp().koG.kpR;
        if (!(bi.oW(str) || bi.oW(str2) || str.equals(str2))) {
            x.i("MicroMsg.TalkUIController", "toPhoneNumber:%s,serverRetPhoneNumber:%s", new Object[]{str, str2});
            Fj(str2);
        }
        x.i("MicroMsg.TalkUIController", "callFlag:" + i.aXp().koG.kpE);
        int i2 = i.aXp().koG.kpE;
        if ((i2 & 1) > 0 && (i2 & 2) > 0 && (i2 & 8) <= 0) {
            i = 1;
        }
        if (i != 0) {
            x.i("MicroMsg.TalkUIController", "isNotFree");
            h.a(this.kzN, R.l.ipcall_actitivy_out_of_area_desc, R.l.ipcall_actitivy_out_of_area_title, R.l.ipcall_actitivy_out_of_area_continue, R.l.ipcall_actitivy_out_of_area_cancel, true, null, new 3(this));
        }
        rJ(3);
    }

    public final void aWI() {
        x.d("MicroMsg.TalkUIController", "onStartRing");
        if (i.aXt().aXk()) {
            this.kzS = this.kzG.isChecked();
            this.kzT = this.kzG.isChecked();
            i.aXs().fT(this.kzG.isChecked());
        }
    }

    public final void aWW() {
        x.d("MicroMsg.TalkUIController", "onUserAccept");
        if (i.aXt().aXk()) {
            this.kzS = this.kzG.isChecked();
            this.kzT = this.kzG.isChecked();
            i.aXs().fT(this.kzG.isChecked());
        }
        if (i.aXt().aXl()) {
            i.aXs().kqc.setMute(this.kzE.isChecked());
        }
    }

    public final void aWX() {
        x.d("MicroMsg.TalkUIController", "onOthersideShutdown");
        aYv();
        rJ(10);
        au.getNotification().cancel(42);
        if (this.kzP != null) {
            this.kzP.gc(true);
        }
    }

    public final void d(int i, String str, String str2, int i2) {
        x.d("MicroMsg.TalkUIController", "onError, error: %d", new Object[]{Integer.valueOf(i)});
        if (i2 == 1) {
            this.kzW = false;
        }
        if (i != 8) {
            f(str, str2, i2, null);
        } else if (i2 == 1) {
            String string;
            if (bi.oW(str)) {
                string = this.kzN.getString(R.l.ip_call_alter_tip);
            } else {
                string = str;
            }
            h.a(this.kzN, str2, string, this.kzN.getString(R.l.ip_call_alter_tip_ok), false, new 4(this));
        } else {
            f(str, str2, i2, this.kzN.getString(R.l.ip_call_alter_account_overdue_tip));
        }
        au.getNotification().cancel(42);
        if (this.kzP != null && !this.kzX) {
            this.kzP.gc(this.kzW);
        }
    }

    public final void fW(boolean z) {
        x.d("MicroMsg.TalkUIController", "onHeadsetPlugStateChange, isPlugged: %b", new Object[]{Boolean.valueOf(z)});
        if (!i.aXt().aXk()) {
            return;
        }
        if (z) {
            i.aXs();
            this.kzS = com.tencent.mm.plugin.ipcall.a.b.a.yJ();
            i.aXs().fT(false);
            this.kzG.setEnable(false);
            return;
        }
        i.aXs().fT(this.kzS);
        this.kzG.setEnable(true);
        this.kzG.setChecked(this.kzS);
    }

    public final void fX(boolean z) {
        x.d("MicroMsg.TalkUIController", "onBluetoothPlugStateChange, isPlugged: %b", new Object[]{Boolean.valueOf(z)});
        if (!i.aXt().aXk()) {
            return;
        }
        if (z) {
            i.aXs();
            this.kzT = com.tencent.mm.plugin.ipcall.a.b.a.yJ();
            i.aXs().fT(false);
            this.kzG.setEnable(false);
            return;
        }
        i.aXs().fT(this.kzT);
        this.kzG.setEnable(true);
        this.kzG.setChecked(this.kzT);
    }

    public final void aWZ() {
        this.kzQ = (long) i.aXu().aWT();
        rJ(5);
    }

    public final void aWY() {
        this.kzN.finish();
    }

    public final void aYv() {
        if (this.kzI != null) {
            this.kzI.setVisibility(4);
        }
        if (this.kzJ != null) {
            this.kzJ.setVisibility(4);
        }
    }
}
