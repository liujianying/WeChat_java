package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.ab.i$b;
import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

public final class i implements com.tencent.mm.ab.i, a {
    private static int bFx = 100;
    private k bAY = null;
    private String fileName = "";
    private int hjR = 0;
    private long iZe = 0;
    private al orA = new al(new 1(this), true);
    protected i$b oru;
    protected com.tencent.mm.ab.i.a orv = null;
    private boolean orw = false;
    private a orx;
    private long ory = 0;
    private int orz = 0;

    public final void ew(int i) {
        x.d("MicroMsg.VoiceRemindRecorder", " Recorder onBluetoothHeadsetStateChange :" + i);
        if (!this.orw) {
            this.orw = true;
            au.HV().b(this);
            this.bAY = new k();
            2 2 = new 2(this);
            this.orx = new a(this);
            e.post(this.orx, "VoiceRemindRecorder_record");
            this.orz = 1;
            this.orA.J(3000, 3000);
            x.d("MicroMsg.VoiceRemindRecorder", "start end time:" + bi.bI(this.ory));
        }
    }

    public final int getMaxAmplitude() {
        if (this.bAY == null) {
            return 0;
        }
        int maxAmplitude = this.bAY.getMaxAmplitude();
        if (maxAmplitude > bFx) {
            bFx = maxAmplitude;
        }
        x.d("getMaxAmplitude", " map: " + maxAmplitude + " max:" + bFx + " per:" + ((maxAmplitude * 100) / bFx));
        return (maxAmplitude * 100) / bFx;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final boolean isRecording() {
        if (this.bAY != null && this.bAY.mStatus == 1) {
            return true;
        }
        return false;
    }

    public final boolean dd(String str) {
        String nJ = k.nJ(q.GF());
        g gVar = new g();
        gVar.field_filename = nJ;
        gVar.field_user = str;
        gVar.field_createtime = System.currentTimeMillis() / 1000;
        gVar.field_clientid = nJ;
        gVar.field_lastmodifytime = System.currentTimeMillis() / 1000;
        gVar.field_status = 1;
        gVar.field_human = q.GF();
        gVar.bWA = -1;
        k bGt = d.bGt();
        x.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert");
        int insert = (int) bGt.diF.insert("VoiceRemindInfo", "", gVar.wH());
        x.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert result" + insert);
        if (insert == -1) {
            nJ = null;
        }
        this.fileName = nJ;
        au.HV().a(this);
        int yB = au.HV().yB();
        this.orw = false;
        if (yB != 0) {
            ew(100);
        } else {
            new 3(this).sendEmptyMessageDelayed(0, 50);
        }
        return false;
    }

    public final boolean cancel() {
        x.d("MicroMsg.VoiceRemindRecorder", "cancel Record :" + this.fileName);
        synchronized (this) {
            x.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
            if (this.bAY != null) {
                this.bAY.we();
            }
        }
        String str = this.fileName;
        if (str != null) {
            x.d("MicroMsg.VoiceRemindLogic", "Mark Canceled fileName[" + str + "]");
            g Ok = h.Ok(str);
            if (Ok != null) {
                Ok.field_status = 8;
                Ok.field_totallen = c.nM(h.aY(str, false));
                Ok.bWA = 64;
                h.a(Ok);
            }
        }
        d.bGu().run();
        this.fileName = "";
        return true;
    }

    public final boolean wk() {
        boolean z = true;
        boolean z2 = false;
        au.HV().yC();
        x.d("MicroMsg.VoiceRemindRecorder", "stop Record :" + this.fileName);
        synchronized (this) {
            x.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
            if (this.bAY != null) {
                this.bAY.we();
            }
        }
        if (this.orz != 2) {
            h.op(this.fileName);
            this.fileName = null;
            x.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by not onPart: " + bi.bI(this.ory));
        } else {
            this.hjR = (int) wu();
            if (((long) this.hjR) < 800 || ((long) this.hjR) < 1000) {
                x.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by voiceLen: " + this.hjR);
                h.op(this.fileName);
                this.fileName = "";
                z = false;
            } else {
                String str = this.fileName;
                int i = this.hjR;
                if (str != null) {
                    x.d("MicroMsg.VoiceRemindLogic", "StopRecord fileName[" + str + "]");
                    g Ok = h.Ok(str);
                    if (Ok != null) {
                        if (!(Ok.field_status == 97 || Ok.field_status == 98)) {
                            Ok.field_status = 3;
                        }
                        Ok.field_totallen = c.nM(h.aY(str, false));
                        if (Ok.field_totallen <= 0) {
                            h.nP(str);
                        } else {
                            Ok.field_lastmodifytime = System.currentTimeMillis() / 1000;
                            Ok.field_voicelenght = i;
                            Ok.bWA = 3424;
                            bd bdVar = new bd();
                            bdVar.ep(Ok.field_user);
                            bdVar.setType(34);
                            bdVar.eX(1);
                            bdVar.eq(str);
                            if (Ok.field_status == 97) {
                                bdVar.setStatus(2);
                                bdVar.setContent(f.b(Ok.field_human, (long) Ok.field_voicelenght, false));
                            } else if (Ok.field_status == 98) {
                                bdVar.setStatus(5);
                                bdVar.setContent(f.b(Ok.field_human, -1, true));
                            } else {
                                bdVar.setStatus(1);
                            }
                            bdVar.ay(com.tencent.mm.model.bd.iD(Ok.field_user));
                            Ok.field_msglocalid = (int) com.tencent.mm.model.bd.i(bdVar);
                            h.a(Ok);
                        }
                    }
                }
                d.bGu().run();
                x.d("MicroMsg.VoiceRemindRecorder", "Stop file success: " + this.fileName);
            }
            this.fileName = "";
            z2 = z;
        }
        this.orz = -1;
        return z2;
    }

    public final long wu() {
        if (this.iZe <= 0) {
            return 0;
        }
        return bi.bI(this.iZe);
    }

    public final void reset() {
        if (this.bAY != null) {
            this.bAY.we();
            x.e("MicroMsg.VoiceRemindRecorder", "Reset recorder.stopReocrd");
        }
        this.fileName = "";
        this.ory = 0;
        this.orx = null;
        this.orz = 0;
        this.iZe = 0;
    }

    public final int wt() {
        return this.hjR;
    }

    public final void a(com.tencent.mm.ab.i.a aVar) {
        this.orv = aVar;
    }

    public final void a(i$b i_b) {
        this.oru = i_b;
    }

    public final int ww() {
        return 0;
    }
}
