package com.tencent.mm.plugin.appbrand.media.record;

import android.media.AudioRecord;
import android.os.Looper;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.media.record.a.c;
import com.tencent.mm.plugin.appbrand.media.record.a.d;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class e {
    private static Object dMd = new Object();
    private static e giG;
    private int giA = 0;
    private long giB = 0;
    private int giC = 0;
    private ag giD;
    private a giE = new 1(this);
    private c.a giF = new 4(this);
    private al gia = null;
    public com.tencent.mm.plugin.appbrand.media.record.record_imp.a giu = null;
    private Object giv = new Object();
    public RecordParam giw;
    int gix = a.giJ;
    private c giy = null;
    private boolean giz = false;
    private long mDuration = 0;
    private String mFilePath;
    public boolean mIsRecording = false;
    private long mStartTime = 0;

    static /* synthetic */ void g(e eVar) {
        try {
            x.i("MicroMsg.Record.AudioRecordMgr", "_start in runnable");
            if (eVar.alh()) {
                eVar.giz = false;
                eVar.giA = 0;
                if (eVar.alg()) {
                    int i;
                    c cVar = eVar.giy;
                    com.tencent.mm.plugin.appbrand.media.record.record_imp.a aVar = eVar.giu;
                    if (aVar.bDp != null) {
                        com.tencent.mm.e.b.c cVar2 = aVar.bDp;
                        if (cVar2.bEh > 0) {
                            i = cVar2.bEh;
                        } else {
                            int minBufferSize = AudioRecord.getMinBufferSize(cVar2.mSampleRate, cVar2.bEf, 2);
                            x.i("MicroMsg.MMPcmRecorder", "getDefaultMinBufferSize minBufSize:%d", new Object[]{Integer.valueOf(minBufferSize)});
                            if (minBufferSize == -2 || minBufferSize == -1) {
                                i = 0;
                            } else {
                                cVar2.bEh = minBufferSize * cVar2.bDO;
                                i = cVar2.bEh;
                            }
                        }
                    } else {
                        i = 0;
                    }
                    cVar.lj(i);
                    eVar.giy.lk(eVar.giw.aft);
                    eVar.giC = 0;
                    eVar.mDuration = (long) eVar.giw.duration;
                    eVar.mStartTime = System.currentTimeMillis();
                    eVar.giB = eVar.mDuration;
                    x.i("MicroMsg.Record.AudioRecordMgr", "mDuration:%d, mCurrentTime:%d", new Object[]{Long.valueOf(eVar.mDuration), Long.valueOf(eVar.mStartTime)});
                    eVar.alk().post(new 10(eVar));
                    x.i("MicroMsg.Record.AudioRecordMgr", "onStart");
                    eVar.gix = a.giK;
                    eVar.mIsRecording = true;
                    lk lkVar = new lk();
                    lkVar.bVK.action = 0;
                    lkVar.bVK.state = "start";
                    if (eVar.giw != null) {
                        lkVar.bVK.appId = eVar.giw.appId;
                    }
                    com.tencent.mm.sdk.b.a.sFg.a(lkVar, Looper.getMainLooper());
                    x.i("MicroMsg.Record.AudioRecordMgr", "start record success");
                    return;
                }
                eVar.onError(6);
                x.e("MicroMsg.Record.AudioRecordMgr", "start record fail");
                return;
            }
            eVar.onError(2);
            x.e("MicroMsg.Record.AudioRecordMgr", "init encoder fail");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e, "_start", new Object[0]);
            eVar.onError(4);
        }
    }

    static /* synthetic */ void h(e eVar) {
        try {
            x.i("MicroMsg.Record.AudioRecordMgr", "_resume in runnable");
            if (eVar.giy == null) {
                eVar.onError(3);
                x.e("MicroMsg.Record.AudioRecordMgr", "resume record fail");
            } else if (eVar.giB <= 0) {
                eVar.alj();
                x.e("MicroMsg.Record.AudioRecordMgr", "resume record fail, record time reach max time, to stop record");
            } else if (eVar.alg()) {
                eVar.mStartTime = System.currentTimeMillis();
                x.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, currentTime:%d", new Object[]{Long.valueOf(eVar.giB), Long.valueOf(eVar.mStartTime)});
                eVar.alk().post(new 11(eVar));
                x.i("MicroMsg.Record.AudioRecordMgr", "onResume");
                eVar.gix = a.giL;
                eVar.mIsRecording = true;
                lk lkVar = new lk();
                lkVar.bVK.action = 1;
                lkVar.bVK.state = "resume";
                if (eVar.giw != null) {
                    lkVar.bVK.appId = eVar.giw.appId;
                }
                com.tencent.mm.sdk.b.a.sFg.a(lkVar, Looper.getMainLooper());
                x.i("MicroMsg.Record.AudioRecordMgr", "resume record success");
            } else {
                eVar.onError(7);
                x.e("MicroMsg.Record.AudioRecordMgr", "resume record fail");
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e, "_resume", new Object[0]);
            eVar.onError(5);
        }
    }

    private void SO() {
        x.i("MicroMsg.Record.AudioRecordMgr", "stopTimer");
        if (this.gia != null) {
            this.gia.SO();
        }
        this.gia = null;
    }

    private e() {
    }

    public static e ale() {
        e eVar;
        synchronized (dMd) {
            if (giG == null) {
                giG = new e();
            }
            eVar = giG;
        }
        return eVar;
    }

    public final boolean wc() {
        return this.gix == a.giM;
    }

    public final boolean alf() {
        return this.gix == a.giN;
    }

    public final boolean we() {
        x.i("MicroMsg.Record.AudioRecordMgr", "stopRecord");
        if (this.giu == null && this.giy == null) {
            x.e("MicroMsg.Record.AudioRecordMgr", "mRecord is null and mAudioEncoder is null, stop fail");
            return false;
        }
        com.tencent.mm.sdk.f.e.post(new 9(this), "app_brand_stop_record");
        return true;
    }

    private boolean alg() {
        x.i("MicroMsg.Record.AudioRecordMgr", "startRecordInternal");
        if (this.giu != null) {
            this.giu.we();
            this.giu = null;
            x.i("MicroMsg.Record.AudioRecordMgr", "mRecorder is not null, stop it, and not callback stop event");
        }
        if (this.giu == null) {
            this.giu = new com.tencent.mm.plugin.appbrand.media.record.record_imp.a(this.giw);
            this.giu.gjf = this.giE;
        }
        com.tencent.mm.plugin.appbrand.media.record.record_imp.a aVar = this.giu;
        x.i("MicroMsg.Record.AppBrandRecorder", JsApiStartRecordVoice.NAME);
        if (aVar.bDp != null) {
            aVar.bDp.we();
            aVar.bDp = null;
        }
        aVar.gje = System.currentTimeMillis();
        x.i("MicroMsg.Record.AppBrandRecorder", "start time ticket:%d", new Object[]{Long.valueOf(aVar.gje)});
        aVar.bDp = new com.tencent.mm.e.b.c(aVar.sampleRate, aVar.aeg, aVar.bDP);
        if ("mp3".equalsIgnoreCase(aVar.gjd.fIJ)) {
            aVar.bDp.ey(40);
        } else {
            aVar.bDp.ey(20);
        }
        aVar.bDp.aM(false);
        aVar.bDp.bEb = aVar.gjg;
        com.tencent.mm.e.b.c cVar = aVar.bDp;
        int i = aVar.gjd.gjk.gih;
        cVar.bDJ = i;
        x.i("MicroMsg.MMPcmRecorder", "mAudioSource: " + i);
        x.i("MicroMsg.Record.AudioRecordMgr", "record start:%b", new Object[]{Boolean.valueOf(aVar.bDp.wn())});
        return aVar.bDp.wn();
    }

    private boolean alh() {
        c cVar = null;
        x.i("MicroMsg.Record.AudioRecordMgr", "initEncode");
        if (this.giy != null) {
            this.giy.close();
            this.giy = null;
        }
        this.mFilePath = f.bF(this.giw.fIJ, this.giw.dfX);
        x.i("MicroMsg.Record.AudioRecordMgr", "mFilePath:%s", new Object[]{this.mFilePath});
        String str = this.giw.fIJ;
        x.i("MicroMsg.Record.AudioEncodeFactory", "createEncodeByType:%s", new Object[]{str});
        if (f.uy(str)) {
            if ("aac".equalsIgnoreCase(str)) {
                cVar = new com.tencent.mm.plugin.appbrand.media.record.a.a();
            } else if ("mp3".equalsIgnoreCase(str)) {
                cVar = new d();
            } else if ("wav".equalsIgnoreCase(str)) {
                cVar = new com.tencent.mm.plugin.appbrand.media.record.a.e();
            }
        }
        this.giy = cVar;
        if (this.giy == null) {
            return false;
        }
        boolean uz = f.uz(this.mFilePath);
        if (uz) {
            try {
                uz = this.giy.e(this.mFilePath, this.giw.sampleRate, this.giw.gji, this.giw.gjj);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e, "init encoder fail", new Object[0]);
                uz = false;
            }
            this.giy.a(this.giF);
            return uz;
        }
        x.e("MicroMsg.Record.AudioRecordMgr", "prepare cache file fail");
        return uz;
    }

    final void ali() {
        x.i("MicroMsg.Record.AudioRecordMgr", "pause record in runnable");
        boolean we;
        try {
            if (wc()) {
                x.e("MicroMsg.Record.AudioRecordMgr", "is paused, don't pause again");
                return;
            }
            if (this.giu != null) {
                we = this.giu.we();
                this.giu = null;
            } else {
                we = false;
            }
            alk().post(new Runnable() {
                public final void run() {
                    e.this.SO();
                }
            });
            x.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", new Object[]{Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis() - this.mStartTime), Integer.valueOf(this.giC)});
            this.giC = (int) (((long) this.giC) + r4);
            this.giB = this.mDuration - ((long) this.giC);
            x.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", new Object[]{Long.valueOf(this.giB), Integer.valueOf(this.giC)});
            x.i("MicroMsg.Record.AudioRecordMgr", "stop:%b", new Object[]{Boolean.valueOf(we)});
            if (we) {
                x.i("MicroMsg.Record.AudioRecordMgr", "onPause");
                this.gix = a.giM;
                this.mIsRecording = false;
                lk lkVar = new lk();
                lkVar.bVK.action = 3;
                lkVar.bVK.state = "pause";
                if (this.giw != null) {
                    lkVar.bVK.appId = this.giw.appId;
                }
                com.tencent.mm.sdk.b.a.sFg.a(lkVar, Looper.getMainLooper());
                x.i("MicroMsg.Record.AudioRecordMgr", "pause record success");
                return;
            }
            onError(8);
            x.e("MicroMsg.Record.AudioRecordMgr", "pause record fail");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e, "_pause", new Object[0]);
            we = false;
        }
    }

    private void alj() {
        x.i("MicroMsg.Record.AudioRecordMgr", "stop record in runnable");
        boolean we;
        try {
            if (alf()) {
                x.e("MicroMsg.Record.AudioRecordMgr", "is stopped, don't stop again");
                return;
            }
            if (this.giu != null) {
                we = this.giu.we();
                this.giu = null;
            } else {
                x.e("MicroMsg.Record.AudioRecordMgr", "mRecorder is null, has stop record!");
                we = true;
            }
            this.giz = true;
            x.i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d", new Object[]{Integer.valueOf(this.giA)});
            if (this.giy != null) {
                this.giy.flush();
                this.giy.close();
                this.giy = null;
            }
            alk().post(new 3(this));
            long currentTimeMillis = System.currentTimeMillis();
            x.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", new Object[]{Long.valueOf(currentTimeMillis), Long.valueOf(System.currentTimeMillis() - this.mStartTime), Integer.valueOf(this.giC)});
            this.giC = (int) (((long) this.giC) + r6);
            this.giB = this.mDuration - ((long) this.giC);
            x.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", new Object[]{Long.valueOf(this.giB), Integer.valueOf(this.giC)});
            x.i("MicroMsg.Record.AudioRecordMgr", "stop:%b", new Object[]{Boolean.valueOf(we)});
            if (we) {
                x.i("MicroMsg.Record.AudioRecordMgr", "onStop");
                this.gix = a.giN;
                this.mIsRecording = false;
                lk lkVar = new lk();
                lkVar.bVK.action = 2;
                lkVar.bVK.state = "stop";
                if (this.giw != null) {
                    lkVar.bVK.appId = this.giw.appId;
                }
                lkVar.bVK.duration = this.giC;
                lkVar.bVK.filePath = this.mFilePath;
                lkVar.bVK.fileSize = (int) f.uA(this.mFilePath);
                com.tencent.mm.sdk.b.a.sFg.a(lkVar, Looper.getMainLooper());
                x.i("MicroMsg.Record.AudioRecordMgr", "stop record success");
            } else {
                onError(9);
                x.e("MicroMsg.Record.AudioRecordMgr", "stop record fail");
            }
            this.giw = null;
            d.ald();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e, "_stop", new Object[0]);
            we = false;
        }
    }

    private ag alk() {
        if (this.giD == null) {
            this.giD = new ag(Looper.getMainLooper());
        }
        return this.giD;
    }

    protected final void onError(int i) {
        x.i("MicroMsg.Record.AudioRecordMgr", "onError errType:%d", new Object[]{Integer.valueOf(i)});
        if (this.gix != a.giO) {
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(689);
            iDKey.SetKey(1);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(689);
            iDKey2.SetKey(g.lh(i));
            iDKey2.SetValue(1);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            h.mEJ.b(arrayList, true);
        }
        this.gix = a.giO;
        this.mIsRecording = false;
        lk lkVar = new lk();
        lkVar.bVK.action = 4;
        lkVar.bVK.state = "error";
        if (this.giw != null) {
            lkVar.bVK.appId = this.giw.appId;
        }
        lkVar.bVK.errCode = i;
        lk.a aVar = lkVar.bVK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("errType:" + i + ", err:");
        switch (i) {
            case 1:
                stringBuilder.append("error PCM record callback");
                break;
            case 2:
                stringBuilder.append("init encoder fail, occur exception");
                break;
            case 3:
                stringBuilder.append("encoder un initial occur exception");
                break;
            case 4:
                stringBuilder.append("start record occur exception");
                break;
            case 5:
                stringBuilder.append("resume record occur exception");
                break;
            case 6:
                stringBuilder.append("fail to start record");
                break;
            case 7:
                stringBuilder.append("fail to resume record");
                break;
            case 8:
                stringBuilder.append("fail to pause record");
                break;
            case 9:
                stringBuilder.append("fail to stop record");
                break;
            case 15:
                stringBuilder.append("check param invalid");
                break;
            case 16:
                stringBuilder.append("not support format type");
                break;
            case 17:
                stringBuilder.append("fail to init mp3 encoder");
                break;
            case 18:
                stringBuilder.append("mp3 file not found exception");
                break;
            case 19:
                stringBuilder.append("mp3 encode exception");
                break;
            case 20:
                stringBuilder.append("mp3 write buffer exception");
                break;
            case 21:
                stringBuilder.append("fail to init aac encoder");
                break;
            case 22:
                stringBuilder.append("fail to create mp4 file");
                break;
            case 23:
                stringBuilder.append("aac encode exception");
                break;
            case 24:
                stringBuilder.append("create cache file fail");
                break;
            case 25:
                stringBuilder.append("init encoder fail");
                break;
            case 26:
                stringBuilder.append("not support sample rate");
                break;
            default:
                stringBuilder.append("unknow error");
                break;
        }
        aVar.Yy = stringBuilder.toString();
        com.tencent.mm.sdk.b.a.sFg.a(lkVar, Looper.getMainLooper());
    }
}
