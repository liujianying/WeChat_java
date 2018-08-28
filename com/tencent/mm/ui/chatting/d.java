package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.g;
import com.tencent.mm.ab.g.a;
import com.tencent.mm.ab.g.b;
import com.tencent.mm.ab.g.c;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.model.ae;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.subapp.c.h;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.b.ao;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class d implements a, b, c, com.tencent.mm.ab.g.d, f.a, ae, com.tencent.mm.modelvoice.c, SensorController.a {
    private static SensorController hlW;
    public com.tencent.mm.ui.chatting.c.a bAG;
    private int bCK;
    private boolean bCM = false;
    public Context context;
    public boolean hlZ;
    private az hma;
    long hmb = -1;
    private boolean hmg = false;
    boolean hnA = false;
    public g iWF;
    private List<bd> tHe;
    public long tHf = -1;
    private o tHg;
    ao tHh;
    public o tHi;
    public boolean tHj;
    public boolean tHk = true;
    public boolean tHl = false;
    private long tHm = 0;
    private long tHn = 0;
    public boolean tHo = false;
    private boolean tHp = false;
    public com.tencent.mm.sdk.b.c tHq = new 1(this);
    private ag tHr = new 2(this, Looper.getMainLooper());
    private ag tHs = new 3(this, Looper.getMainLooper());

    public d(com.tencent.mm.ui.chatting.c.a aVar, ao aoVar, String str) {
        this.context = aVar.tTq.getContext();
        this.bAG = aVar;
        this.tHh = aoVar;
        if (hlW == null) {
            hlW = new SensorController(this.context.getApplicationContext());
        }
        if (this.hma == null) {
            this.hma = new az(this.context.getApplicationContext());
        }
        aai(str);
        com.tencent.mm.sdk.b.a.sFg.b(this.tHq);
        au.vv().a(this);
    }

    public final void aai(String str) {
        x.i("MicroMsg.AutoPlay", "changeTalker, isResumeFromDisableScreen: %b", new Object[]{Boolean.valueOf(this.tHl)});
        if (!this.tHl && this.context != null) {
            this.tHe = new LinkedList();
            this.hnA = false;
            this.tHf = -1;
            this.hlZ = false;
            this.hmb = -1;
            this.tHj = false;
            this.bCK = 0;
            if (s.hB(str)) {
                this.bCK = 1;
                this.iWF = new com.tencent.mm.e.a.a(this.context, 1);
                return;
            }
            this.bCK = 0;
            this.iWF = new com.tencent.mm.e.a.a(this.context, 0);
        }
    }

    public final void csL() {
        x.d("MicroMsg.AutoPlay", "clear play list, stack: %s", new Object[]{bi.cjd()});
        if (this.tHg != null) {
            this.tHg.dismiss();
        }
        this.tHe.clear();
    }

    public final void EG(int i) {
        while (this.context != null) {
            if (this.bAG == null) {
                x.e("MicroMsg.AutoPlay", "add next failed: null mChattingContext");
                return;
            }
            int count = ((com.tencent.mm.ui.chatting.b.b.g) this.bAG.O(com.tencent.mm.ui.chatting.b.b.g.class)).getCount();
            x.d("MicroMsg.AutoPlay", "position : " + i + "adapter getCount = " + count);
            if (i >= 0 && i < count) {
                bd ES = ((com.tencent.mm.ui.chatting.b.b.g) this.bAG.O(com.tencent.mm.ui.chatting.b.b.g.class)).ES(i);
                if (ES != null) {
                    if (ES.ckz() && ES.field_isSend == 0 && !q.F(ES) && !q.G(ES)) {
                        ao(ES);
                    }
                    i++;
                } else {
                    return;
                }
            }
            return;
        }
        x.e("MicroMsg.AutoPlay", "context is null");
    }

    public final void ao(bd bdVar) {
        if (bdVar != null) {
            au.HU();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                int size = this.tHe.size();
                int i = 0;
                while (i < size) {
                    if (((bd) this.tHe.get(i)).field_msgId != bdVar.field_msgId) {
                        i++;
                    } else {
                        return;
                    }
                }
                if (this.tHj || this.tHe.size() == 0) {
                    this.tHe.add(bdVar);
                }
                x.d("MicroMsg.AutoPlay", "add voice msg :" + this.tHe.size());
            } else if (this.tHe.size() > 0) {
                this.tHe.clear();
                com.tencent.mm.ui.base.s.gH(this.context);
            }
        }
    }

    public final void a(int i, bd bdVar) {
        if (bdVar != null) {
            csL();
            au.HU();
            Boolean bool = (Boolean) com.tencent.mm.model.c.DT().get(4115, null);
            if (bool == null || !bool.booleanValue()) {
                au.HU();
                com.tencent.mm.model.c.DT().set(4115, Boolean.valueOf(true));
                csR();
                this.tHi = com.tencent.mm.ui.base.s.a(this.bAG.tTq.getActivity(), this.context.getString(R.l.chatting_music_volumn_change), 4000);
            }
            if (this.iWF.isPlaying() && bdVar.field_msgId == this.tHf) {
                csQ();
                return;
            }
            ao(bdVar);
            if (bdVar.field_isSend == 0 && !q.F(bdVar)) {
                EG(i + 1);
            }
            bhU();
        }
    }

    public final void b(int i, bd bdVar) {
        if (bdVar != null) {
            csL();
            au.HU();
            Boolean bool = (Boolean) com.tencent.mm.model.c.DT().get(4115, null);
            if (bool == null || !bool.booleanValue()) {
                au.HU();
                com.tencent.mm.model.c.DT().set(4115, Boolean.valueOf(true));
                csR();
                this.tHi = com.tencent.mm.ui.base.s.a(this.bAG.tTq.getActivity(), this.context.getString(R.l.chatting_music_volumn_change), 4000);
            }
            if (this.iWF.isPlaying() && bdVar.field_msgId == this.tHf) {
                csQ();
                return;
            }
            ao(bdVar);
            if (bdVar.field_isSend == 0 && !q.F(bdVar)) {
                EG(i + 1);
            }
            bhU();
        }
    }

    public final void D(bd bdVar) {
        if ((this.tHk && this.tHe.isEmpty()) || bdVar == null || !bdVar.ckz() || bdVar.field_isSend == 1 || bdVar.field_talker == null || !bdVar.field_talker.equals(this.bAG.getTalkerUserName()) || !au.DF().foreground || !this.bAG.eaR) {
            return;
        }
        if (q.G(bdVar)) {
            x.e("MicroMsg.AutoPlay", "should not in this route");
            return;
        }
        ao(bdVar);
        if (!this.hnA && !this.iWF.isPlaying() && bi.ci(this.context)) {
            bhU();
        }
    }

    public final void csM() {
        this.hnA = false;
        bhU();
    }

    private void csN() {
        int size = this.tHe.size();
        int i = 0;
        int i2 = -1;
        while (i < size) {
            int i3;
            if (((bd) this.tHe.get(i)).field_msgId == this.tHf) {
                i3 = i;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (i2 != -1) {
            this.tHe.remove(i2);
        }
        x.d("MicroMsg.AutoPlay", "remove voice msg : size = " + this.tHe.size());
    }

    public final void bhU() {
        x.d("MicroMsg.AutoPlay", "play next: size = " + this.tHe.size());
        if (this.tHe.size() <= 0) {
            this.tHr.sendEmptyMessageDelayed(0, 1000);
            return;
        }
        if (!f.yz().yK()) {
            f.yz();
            if (f.yH()) {
                f.yz().a(this);
                int yB = f.yz().yB();
                this.bCM = true;
                if (!(yB == -1 || yB == 0)) {
                    x.i("MicroMsg.AutoPlay", "play next: ret = " + yB);
                    this.tHs.sendEmptyMessageDelayed(0, 1000);
                    return;
                }
            }
        }
        csO();
    }

    public final void csO() {
        try {
            x.d("MicroMsg.AutoPlay", "realPlayNext play next: size = " + this.tHe.size());
            if (this.tHe.size() <= 0) {
                this.tHr.sendEmptyMessageDelayed(0, 1000);
                return;
            }
            long j = ((bd) this.tHe.get(0)).field_createTime;
            int size = this.tHe.size();
            int i = 1;
            int i2 = 0;
            while (i < size) {
                long j2;
                if (j > ((bd) this.tHe.get(i)).field_createTime) {
                    j2 = ((bd) this.tHe.get(i)).field_createTime;
                    i2 = i;
                } else {
                    j2 = j;
                }
                i++;
                j = j2;
            }
            bd bdVar = (bd) this.tHe.get(i2);
            if (bdVar != null) {
                boolean z;
                if (bdVar == null || !(bdVar.ckz() || bdVar.cmp() || bdVar.cmq() || bdVar.cmr())) {
                    z = false;
                } else {
                    z = true;
                }
                Assert.assertTrue(z);
                x.i("MicroMsg.AutoPlay", "start play msg: %d", new Object[]{Long.valueOf(bdVar.field_msgId)});
                if (!hlW.sIY) {
                    hlW.a(this);
                    if (this.hma.Q(new 4(this))) {
                        this.hmb = 0;
                    } else {
                        this.hmb = -1;
                    }
                }
                au.HU();
                if (com.tencent.mm.model.c.isSDCardAvailable() || bi.oW(bdVar.field_imgPath)) {
                    au.HU();
                    if (com.tencent.mm.model.c.isSDCardAvailable() && this.tHh.hmc) {
                        if (this.tHg != null) {
                            this.tHg.dismiss();
                        }
                        x.i("MicroMsg.AutoPlay", "alvinluo isHeadsetPluged: %b, isBluetoothOn: %b", new Object[]{Boolean.valueOf(f.yz().yK()), Boolean.valueOf(f.yz().yE())});
                        if (f.yz().yK() || !r2) {
                            this.tHg = com.tencent.mm.ui.base.s.a(this.bAG.tTq.getActivity(), R.k.tipsbar_receiver_icon, this.context.getString(R.l.chatfooter_SpeakerOff_now));
                        } else {
                            this.tHg = com.tencent.mm.ui.base.s.a(this.bAG.tTq.getActivity(), R.k.tipsbar_bluetooth_icon, this.context.getString(R.l.chatfooter_SpeakerOff_bluetooth_now));
                        }
                    }
                    af.Wp("keep_app_silent");
                    q.H(bdVar);
                    this.iWF.aJ(true);
                    this.tHh.acquireWakeLock();
                    if (f.yz().yK() || f.yz().yE()) {
                        x.i("MicroMsg.AutoPlay", "headset plugged: %b, bluetoothon: %b", new Object[]{Boolean.valueOf(f.yz().yK()), Boolean.valueOf(f.yz().yE())});
                        this.hlZ = false;
                    }
                    String str = bdVar.field_imgPath;
                    String aY = this.bCK == 1 ? h.aY(str, false) : q.getFullPath(str);
                    x.i("MicroMsg.AutoPlay", "startplay");
                    boolean or = q.or(bdVar.field_imgPath);
                    if (!or) {
                        com.tencent.mm.plugin.report.service.h.mEJ.a(111, 175, 1, false);
                    }
                    if (or && this.iWF.a(aY, this.hlZ, true, -1)) {
                        this.iWF.aL(this.tHe.size() > 1);
                        this.iWF.a(this);
                        this.iWF.a(this);
                        this.iWF.a(this);
                        this.iWF.a(this);
                        this.tHf = bdVar.field_msgId;
                        this.tHn = new n(bdVar.field_content).time;
                        this.tHm = System.currentTimeMillis();
                    } else {
                        this.tHf = -1;
                        if (this.bCM) {
                            f.yz().yC();
                            this.bCM = false;
                        }
                        f.yz().b(this);
                        csL();
                        Toast.makeText(this.context, this.context.getString(R.l.chatting_play_err), 0).show();
                    }
                    avj();
                    this.tHl = false;
                    return;
                }
                this.tHe.clear();
                com.tencent.mm.ui.base.s.gH(this.context);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AutoPlay", e, "", new Object[0]);
        }
    }

    public final void csP() {
        if (this.iWF != null && this.iWF.isPlaying()) {
            x.i("MicroMsg.AutoPlay", "switchSpeaker, isSpeakerOn: %b, isPlaying: %b", new Object[]{Boolean.valueOf(this.hlZ), Boolean.valueOf(this.iWF.isPlaying())});
            this.iWF.aK(this.hlZ);
        }
    }

    public final void release() {
        x.i("MicroMsg.AutoPlay", "alvinluo AutoPlay release");
        if (this.hma != null) {
            this.hma.ciM();
        }
    }

    public final void csQ() {
        x.i("MicroMsg.AutoPlay", "stop play");
        af.Wq("keep_app_silent");
        this.iWF.stop();
    }

    private void avj() {
        ah.A(new 5(this));
    }

    public final boolean isPlaying() {
        return this.iWF.isPlaying();
    }

    public final void wd() {
        x.v("MicroMsg.AutoPlay", "voice play completion isSpeakerOn %b, %d, %d", new Object[]{Boolean.valueOf(this.hlZ), Long.valueOf(this.tHf), Long.valueOf(this.tHn)});
        com.tencent.mm.plugin.report.service.h.mEJ.h(15160, new Object[]{Long.valueOf(this.tHf), Long.valueOf(this.tHn), Long.valueOf(this.tHn), Integer.valueOf(0)});
        if (this.context != null) {
            x.i("MicroMsg.AutoPlay", "stop play complete");
            af.Wq("keep_app_silent");
            this.tHh.releaseWakeLock();
            csN();
            if (this.tHe.isEmpty() && this.bCM) {
                f.yz().yC();
                this.bCM = false;
            }
            f.yz().b(this);
            if (this.tHe.isEmpty()) {
                hlW.ciL();
                this.hma.ciM();
            }
            avj();
            this.tHf = -1;
            csR();
            this.tHh.releaseWakeLock();
            bhU();
        }
    }

    public final void onError() {
        x.e("MicroMsg.AutoPlay", "voice play error");
        csQ();
        bhU();
    }

    public final void bz(boolean z) {
        x.w("MicroMsg.AutoPlay", "voice play pause. %b", new Object[]{Boolean.valueOf(z)});
        onStop();
    }

    public final void onStop() {
        int i = 1;
        x.w("MicroMsg.AutoPlay", "voice play stop. %d, %d, %d, %b, %b, %s", new Object[]{Long.valueOf(this.tHf), Long.valueOf(this.tHn), Long.valueOf(bi.bH(this.tHm)), Boolean.valueOf(this.tHp), Boolean.valueOf(this.tHo), bi.cjd()});
        if (this.tHf > 0) {
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.mEJ;
            Object[] objArr = new Object[4];
            objArr[0] = Long.valueOf(this.tHf);
            objArr[1] = Long.valueOf(this.tHn);
            objArr[2] = Long.valueOf(bi.bH(this.tHm));
            if (this.tHp) {
                i = 3;
            } else if (!this.tHo) {
                i = 2;
            }
            objArr[3] = Integer.valueOf(i);
            hVar.h(15160, objArr);
        }
        this.tHp = false;
        this.tHo = false;
        this.tHh.releaseWakeLock();
        csN();
        if (this.bCM) {
            f.yz().yC();
            this.bCM = false;
        }
        f.yz().b(this);
        if (this.tHe.isEmpty()) {
            hlW.ciL();
            this.hma.ciM();
        }
        avj();
        this.tHf = -1;
        csR();
        this.tHl = false;
    }

    public final void dK(boolean z) {
        boolean z2 = true;
        x.i("MicroMsg.AutoPlay", "onSensorEvent, isON:" + z + "  hasSkip:" + this.hmg + " tick:" + bi.bI(this.hmb) + "  lt:" + this.hmb);
        if (this.hmg) {
            if (z) {
                z2 = false;
            }
            this.hmg = z2;
        } else if (this.context == null) {
            hlW.ciL();
        } else {
            x.i("MicroMsg.AutoPlay", "isScreenOn: %s", new Object[]{Boolean.valueOf(isScreenEnable())});
            if (z || this.hmb == -1 || bi.bI(this.hmb) <= 400) {
                this.hmg = false;
                if (!this.iWF.vZ()) {
                    if (au.HV().yE()) {
                        csR();
                        x.d("MicroMsg.AutoPlay", "onSensorEvent, connecting bluetooth, omit sensor event");
                        return;
                    } else if (this.tHh.hmc) {
                        this.hlZ = false;
                        if (this.tHf != -1) {
                            setScreenEnable(z);
                            this.tHl = z;
                        } else {
                            setScreenEnable(true);
                            this.tHl = true;
                        }
                        csP();
                        return;
                    } else {
                        if (this.tHf != -1) {
                            if (isScreenEnable() != z) {
                                setScreenEnable(z);
                                this.tHl = z;
                                new al(new 6(this, z), false).J(50, 50);
                            } else {
                                return;
                            }
                        }
                        x.i("MicroMsg.AutoPlay", "onSensorEvent, isResumeFromDisableScreen:%b", new Object[]{Boolean.valueOf(this.tHl)});
                        return;
                    }
                }
                return;
            }
            this.hmg = true;
        }
    }

    final void setScreenEnable(boolean z) {
        if (this.bAG != null) {
            this.bAG.tTq.getController().setScreenEnable(z);
        }
    }

    private boolean isScreenEnable() {
        if (this.bAG != null) {
            return this.bAG.tTq.getController().tmb;
        }
        return false;
    }

    public final void csR() {
        if (this.tHi != null) {
            this.tHi.dismiss();
        }
    }

    public final void HB() {
        x.i("MicroMsg.AutoPlay", "phone or record stop, resume and do nothing");
        this.tHp = false;
    }

    public final void HC() {
        x.i("MicroMsg.AutoPlay", "phone comming or record start, stop play");
        this.tHp = true;
        csQ();
        csL();
        try {
            if (hlW != null) {
                hlW.ciL();
            }
            if (this.hma != null) {
                this.hma.ciM();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AutoPlay", e, "reset sensor error: %s", new Object[]{e.getMessage()});
        }
    }

    public final void ew(int i) {
        x.i("MicroMsg.AutoPlay", "onBluetoothHeadsetStateChange, status: %d, isRequestStartBluetooth: %b", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.bCM)});
        switch (i) {
            case 1:
                if (this.tHs.hasMessages(0)) {
                    this.tHs.removeMessages(0);
                    this.tHs.sendEmptyMessage(0);
                    return;
                }
                return;
            case 2:
            case 4:
                if (this.tHs.hasMessages(0)) {
                    this.tHs.removeMessages(0);
                }
                if (this.bCM) {
                    f.yz().yC();
                    this.bCM = false;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
