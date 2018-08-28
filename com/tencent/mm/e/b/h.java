package com.tencent.mm.e.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.ab.i;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.t;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class h implements i, a {
    a bEK = null;
    b bEL;
    private a bEM = null;
    private String bEN;
    private boolean bEO = false;
    private boolean bEP = false;
    long bEQ;
    public int bER = 0;
    boolean bES = false;
    boolean bET = false;
    int bEU = 0;
    private com.tencent.mm.compatible.b.b.a bEV = com.tencent.mm.compatible.b.b.a.daP;
    protected i.b bEW;
    protected i.a bEX = null;
    private boolean bEY = false;
    private al bEZ = new al(new 1(this), true);
    String mFileName = "";
    long mRecordStartTime = 0;

    public h(Context context, boolean z) {
        this.bEL = new b(context);
        this.bET = z;
        x.i("MicroMsg.SceneVoice.Recorder", "new SceneVoiceRecorder, useSpeex: %s", new Object[]{Boolean.valueOf(z)});
    }

    public final void reset() {
        if (this.bEK != null) {
            this.bEK.we();
            this.bEL.zY();
            x.e("MicroMsg.SceneVoice.Recorder", "Reset recorder.stopReocrd");
        }
        this.mFileName = "";
        this.bEQ = 0;
        this.bEM = null;
        this.bEV = com.tencent.mm.compatible.b.b.a.daP;
        this.bEU = 0;
        this.mRecordStartTime = 0;
    }

    public final int wt() {
        return this.bER;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public final boolean isRecording() {
        if (this.bEK != null && this.bEK.getStatus() == 1) {
            return true;
        }
        return false;
    }

    public final int getMaxAmplitude() {
        if (this.bEK == null) {
            return 0;
        }
        return this.bEK.getMaxAmplitude();
    }

    public final boolean dd(String str) {
        x.i("MicroMsg.SceneVoice.Recorder", "Start Record to  " + str);
        reset();
        this.bEN = str;
        this.bEQ = bi.VG();
        if (str == null) {
            x.e("MicroMsg.SceneVoice.Recorder", "Start Record toUser null");
            return false;
        }
        this.bEO = str.equals("_USER_FOR_THROWBOTTLE_");
        if (str.equals("medianote")) {
            if ((q.GJ() & 16384) == 0) {
                this.bEP = true;
            } else {
                this.bEP = false;
            }
        }
        if (!this.bET) {
            if (this.bEO) {
                this.mFileName = u.ov(q.GF());
            } else if (this.bEP) {
                this.mFileName = u.ov("medianote");
            }
            if (this.mFileName != null || this.mFileName.length() <= 0) {
                x.e("MicroMsg.SceneVoice.Recorder", "Start Record DBError fileName:%s", new Object[]{this.mFileName});
                return false;
            }
            f.yz().a(this);
            this.bES = false;
            this.bEY = false;
            if (!f.yH() || f.yz().yE()) {
                wv();
            } else {
                this.bEY = true;
                f.yz().yB();
                ah.i(new 2(this), 1000);
            }
            return true;
        }
        this.mFileName = com.tencent.mm.modelvoice.q.om(str);
        if (this.mFileName != null) {
        }
        x.e("MicroMsg.SceneVoice.Recorder", "Start Record DBError fileName:%s", new Object[]{this.mFileName});
        return false;
    }

    public final boolean cancel() {
        x.d("MicroMsg.SceneVoice.Recorder", "cancel Record :" + this.mFileName);
        synchronized (this) {
            x.d("MicroMsg.SceneVoice.Recorder", "stop synchronized Record :" + this.mFileName);
            if (this.bEK != null) {
                this.bEK.we();
                this.bEL.zY();
            }
        }
        f.yz().b(this);
        if (this.bEY) {
            f.yz().yC();
            this.bEY = false;
        }
        com.tencent.mm.modelvoice.q.on(this.mFileName);
        m.TK().run();
        if (!(this.bEK == null || bi.oW(this.mFileName) || this.bET)) {
            com.tencent.mm.compatible.h.a aVar = new com.tencent.mm.compatible.h.a();
            aVar.dfX = this.mFileName;
            aVar.dfY = wu();
            aVar.dfZ = 1;
            aVar.bJL = this.bEK.wf();
            com.tencent.mm.plugin.report.service.h.mEJ.k(10513, aVar.zW());
        }
        this.mFileName = "";
        return true;
    }

    public boolean wk() {
        boolean z = true;
        boolean z2 = false;
        if (this.bEZ != null) {
            this.bEZ.SO();
            this.bEZ.removeCallbacksAndMessages(null);
        }
        f.yz().b(this);
        if (this.bEY) {
            f.yz().yC();
            this.bEY = false;
        }
        this.bER = (int) wu();
        x.i("MicroMsg.SceneVoice.Recorder", "stop Record : %s, len: %s", new Object[]{this.mFileName, Integer.valueOf(this.bER)});
        if (!(this.bEK == null || bi.oW(this.mFileName) || this.bET)) {
            com.tencent.mm.compatible.h.a aVar = new com.tencent.mm.compatible.h.a();
            aVar.dfX = this.mFileName;
            aVar.dfY = (long) this.bER;
            aVar.dfZ = 2;
            aVar.bJL = this.bEK.wf();
            com.tencent.mm.plugin.report.service.h.mEJ.k(10513, aVar.zW());
        }
        synchronized (this) {
            x.i("MicroMsg.SceneVoice.Recorder", "stop synchronized Record:%s, recorder:%s", new Object[]{this.mFileName, this.bEK});
            if (this.bEK != null) {
                this.bEK.we();
                this.bEL.zY();
            }
        }
        if (this.bEU != 2) {
            com.tencent.mm.modelvoice.q.op(this.mFileName);
            this.mFileName = null;
            x.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by not onPart: " + bi.bI(this.bEQ));
        } else {
            if (((long) this.bER) < 800 || (this.bEO && ((long) this.bER) < 1000)) {
                x.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by voiceLen: " + this.bER);
                com.tencent.mm.modelvoice.q.op(this.mFileName);
                this.mFileName = "";
                z = false;
            } else {
                com.tencent.mm.modelvoice.q.X(this.mFileName, this.bER);
                m.TK().run();
                x.i("MicroMsg.SceneVoice.Recorder", "Stop file success: " + this.mFileName);
            }
            this.mFileName = "";
            z2 = z;
        }
        this.bEU = -1;
        return z2;
    }

    public final long wu() {
        if (this.mRecordStartTime == 0) {
            return 0;
        }
        return bi.bI(this.mRecordStartTime);
    }

    public final void ew(int i) {
        x.d("MicroMsg.SceneVoice.Recorder", "dkbt Recorder onBluetoothHeadsetStateChange :" + i);
        if (i == 1) {
            wv();
        }
    }

    final void wv() {
        if (!this.bES) {
            this.bES = true;
            if (this.bET) {
                this.bEV = com.tencent.mm.compatible.b.b.a.daO;
                this.bEK = new k();
            } else {
                boolean z;
                SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences(ad.chY(), 0);
                if (com.tencent.mm.compatible.e.q.deN.dbG == 1) {
                    z = false;
                } else {
                    z = true;
                }
                if (!sharedPreferences.contains("settings_voicerecorder_mode")) {
                    sharedPreferences.edit().putBoolean("settings_voicerecorder_mode", z).commit();
                }
                x.i("AudioConfig", "getModeByConfig mVoiceRecordMode:%d defValue:%b settings_voicerecorder_mode:%b", new Object[]{Integer.valueOf(com.tencent.mm.compatible.e.q.deN.dbG), Boolean.valueOf(z), Boolean.valueOf(sharedPreferences.getBoolean("settings_voicerecorder_mode", z))});
                this.bEV = sharedPreferences.getBoolean("settings_voicerecorder_mode", z) ? com.tencent.mm.compatible.b.b.a.daL : com.tencent.mm.compatible.b.b.a.daM;
                String value = ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("VoiceFormat");
                String value2 = ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("VoiceFormatToQQ");
                if (this.bEV == com.tencent.mm.compatible.b.b.a.daL) {
                    if (4 == bi.getInt(value, 4) && g$b.ws()) {
                        this.bEV = com.tencent.mm.compatible.b.b.a.daN;
                    }
                    if (this.bEN != null && this.bEN.endsWith("@qqim")) {
                        this.bEV = com.tencent.mm.compatible.b.b.a.daM;
                    }
                }
                if (this.bEV == com.tencent.mm.compatible.b.b.a.daL) {
                    x.i("MicroMsg.SceneVoice.Recorder", "refreshRecordMode, still in pcm mode, force to amr mode");
                    this.bEV = com.tencent.mm.compatible.b.b.a.daM;
                }
                x.i("MicroMsg.SceneVoice.Recorder", "refreshRecordMode dynamicFormat:%s dynamicFormatQQ:%s recdMode:%s isSilkSoLoadSuccess:%b", new Object[]{value, value2, this.bEV, Boolean.valueOf(g$b.ws())});
                this.bEK = new t(this.bEV);
            }
            3 3 = new 3(this);
            if (this.bEK != null) {
                this.bEK.a(3);
            }
            this.bEM = new a(this);
            e.post(this.bEM, "SceneVoiceRecorder_record");
            this.bEU = 1;
            this.bEZ.J(3000, 3000);
            x.d("MicroMsg.SceneVoice.Recorder", "start end time:" + bi.bI(this.bEQ));
        }
    }

    public final void a(i.a aVar) {
        this.bEX = aVar;
    }

    public final void a(i.b bVar) {
        this.bEW = bVar;
    }

    public final int ww() {
        if (this.bET) {
            return 1;
        }
        if (this.bEV == com.tencent.mm.compatible.b.b.a.daL || this.bEV == com.tencent.mm.compatible.b.b.a.daM) {
            return 0;
        }
        if (this.bEV == com.tencent.mm.compatible.b.b.a.daN) {
            return 2;
        }
        return -1;
    }
}
