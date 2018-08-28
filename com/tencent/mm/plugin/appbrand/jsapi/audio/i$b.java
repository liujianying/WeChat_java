package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.e$b;
import com.tencent.mm.plugin.appbrand.jsapi.audio.i.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.media.record.b;
import com.tencent.mm.plugin.appbrand.media.record.e;
import com.tencent.mm.plugin.appbrand.media.record.e.6;
import com.tencent.mm.plugin.appbrand.media.record.e.8;
import com.tencent.mm.plugin.appbrand.media.record.f;
import com.tencent.mm.plugin.appbrand.media.record.h;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class i$b extends a {
    public int action;
    public String appId;
    private byte[] bVL;
    private boolean bVM;
    private int duration = 0;
    public l fFa;
    public int fFd;
    public String fHW = "";
    public boolean fHX = false;
    private i fIH;
    public String fII;
    private String fIJ = "";
    private String fIK;
    private int fIL;
    private final c<lk> fIM = new 1(this);
    e$b fIs;
    public String fIt;
    private String filePath = "";
    private int fileSize = 0;
    public String processName = "";
    private String state = "";

    public i$b(i iVar, l lVar, int i) {
        this.fIH = iVar;
        this.fFa = lVar;
        this.fFd = i;
        this.fIK = AppBrandLocalMediaObjectManager.genMediaFilePath(lVar.mAppId, "frameBuffer");
    }

    public final void ahW() {
        boolean z = false;
        try {
            JSONObject jSONObject = new JSONObject(this.fII);
            String optString = jSONObject.optString("operationType");
            if (TextUtils.isEmpty(optString)) {
                x.e("MicroMsg.Record.JsApiOperateRecorder", "operationType is null");
                this.fHX = true;
                this.action = -1;
                this.fHW = "operationType is null";
                En();
                return;
            }
            x.i("MicroMsg.Record.JsApiOperateRecorder", "operationType;%s", new Object[]{optString});
            this.fHX = false;
            this.action = -1;
            boolean z2;
            e ale;
            if (optString.equals("start")) {
                int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 60000);
                int optInt2 = jSONObject.optInt("sampleRate", 44100);
                int optInt3 = jSONObject.optInt("numberOfChannels", 2);
                int optInt4 = jSONObject.optInt("encodeBitRate", 128000);
                String optString2 = jSONObject.optString("format");
                int optInt5 = jSONObject.optInt("frameSize", 0);
                b a = b.a(jSONObject.optString("audioSource").toUpperCase(), b.MIC);
                com.tencent.mm.plugin.appbrand.media.record.c.b(this.appId, this.fIM);
                RecordParam recordParam = new RecordParam();
                recordParam.duration = optInt;
                recordParam.sampleRate = optInt2;
                recordParam.gji = optInt3;
                recordParam.gjj = optInt4;
                recordParam.fIJ = optString2;
                recordParam.scene = 8;
                recordParam.aft = optInt5;
                recordParam.dfX = System.currentTimeMillis();
                recordParam.processName = this.processName;
                recordParam.appId = this.appId;
                recordParam.gjk = a;
                this.fIJ = optString2;
                com.tencent.mm.plugin.appbrand.media.record.c.alb();
                e ale2 = e.ale();
                x.i("MicroMsg.Record.AudioRecordMgr", JsApiStartRecordVoice.NAME);
                if (ale2.giw == null || recordParam.appId == null || recordParam.appId.equalsIgnoreCase(ale2.giw.appId)) {
                    if (ale2.mIsRecording) {
                        x.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, is recording");
                    } else if (ale2.wc()) {
                        x.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, is pause");
                    }
                    if (z) {
                        x.i("MicroMsg.Record.JsApiOperateRecorder", "star record ok");
                        this.action = -1;
                    } else if (e.ale().mIsRecording) {
                        this.fHX = true;
                        this.fHW = "audio is recording, don't start record again";
                    } else {
                        this.fHX = true;
                        this.fHW = "start record fail";
                    }
                } else {
                    x.e("MicroMsg.Record.AudioRecordMgr", "appId is diff, must stop record first");
                    ale2.we();
                }
                z2 = !TextUtils.isEmpty(recordParam.fIJ) && recordParam.duration >= 0 && recordParam.gjj > 0 && recordParam.sampleRate > 0 && recordParam.gji > 0;
                if (!z2) {
                    x.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, param is invalid");
                    h.li(15);
                } else if (f.uy(recordParam.fIJ)) {
                    if (TextUtils.isEmpty(recordParam.dfX)) {
                        recordParam.dfX = System.currentTimeMillis();
                    }
                    h.all();
                    x.i("MicroMsg.Record.RecordParamCompatibility", "recordParam duration:%d, numberOfChannels:%d, sampleRate:%d, encodeBitRate:%d", new Object[]{Integer.valueOf(recordParam.duration), Integer.valueOf(recordParam.gji), Integer.valueOf(recordParam.sampleRate), Integer.valueOf(recordParam.gjj)});
                    if (recordParam.duration <= 0) {
                        recordParam.duration = 60000;
                    } else if (recordParam.duration >= 600000) {
                        recordParam.duration = 600000;
                    }
                    if (recordParam.gji <= 0 && recordParam.gji > 2) {
                        recordParam.gji = 2;
                    }
                    if (recordParam.sampleRate > 48000) {
                        recordParam.sampleRate = 48000;
                    } else if (recordParam.sampleRate < 8000) {
                        recordParam.sampleRate = 8000;
                    }
                    if (recordParam.gjj > 320000) {
                        recordParam.gjj = 320000;
                    } else if (recordParam.gjj < 16000) {
                        recordParam.gjj = 16000;
                    }
                    com.tencent.mm.sdk.f.e.post(new 6(ale2, recordParam), "app_brand_start_record");
                    z = true;
                } else {
                    x.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, encode format %s is not support!", new Object[]{recordParam.fIJ});
                    h.li(16);
                }
                if (z) {
                    x.i("MicroMsg.Record.JsApiOperateRecorder", "star record ok");
                    this.action = -1;
                } else if (e.ale().mIsRecording) {
                    this.fHX = true;
                    this.fHW = "audio is recording, don't start record again";
                } else {
                    this.fHX = true;
                    this.fHW = "start record fail";
                }
            } else if (optString.equals("resume")) {
                ale = e.ale();
                if (ale.mIsRecording) {
                    x.e("MicroMsg.Record.AudioRecordMgr", "resumeRecord fail, is recording");
                } else if (ale.giw == null) {
                    x.e("MicroMsg.Record.AudioRecordMgr", "resumeRecord fail, mRecordParam is null");
                } else {
                    h.all();
                    com.tencent.mm.sdk.f.e.post(new Runnable() {
                        public final void run() {
                            synchronized (e.this.giv) {
                                e.h(e.this);
                            }
                        }
                    }, "app_brand_resume_record");
                    z = true;
                }
                if (z) {
                    this.action = -1;
                    x.i("MicroMsg.Record.JsApiOperateRecorder", "resume record ok");
                } else if (e.ale().mIsRecording) {
                    this.fHX = true;
                    this.fHW = "audio is recording, don't resume record again";
                } else {
                    this.fHX = true;
                    this.fHW = "resume record fail";
                }
            } else if (optString.equals("pause")) {
                ale = e.ale();
                x.i("MicroMsg.Record.AudioRecordMgr", "pauseRecord");
                if (ale.giu == null) {
                    x.e("MicroMsg.Record.AudioRecordMgr", "mRecord is null");
                    z2 = false;
                } else if (ale.wc()) {
                    x.e("MicroMsg.Record.AudioRecordMgr", "is paused, don't pause again");
                    z2 = true;
                } else {
                    com.tencent.mm.sdk.f.e.post(new 8(ale), "app_brand_pause_record");
                    z2 = true;
                }
                if (z2) {
                    this.action = -1;
                    x.i("MicroMsg.Record.JsApiOperateRecorder", "pause record ok");
                } else if (e.ale().wc()) {
                    this.fHX = true;
                    this.fHW = "audio is pause, don't pause record again";
                } else {
                    this.fHX = true;
                    this.fHW = "pause record fail";
                }
            } else if (!optString.equals("stop")) {
                x.e("MicroMsg.Record.JsApiOperateRecorder", "operationType is invalid");
                this.fHX = true;
                this.fHW = "operationType is invalid";
            } else if (e.ale().we()) {
                this.action = -1;
                x.i("MicroMsg.Record.JsApiOperateRecorder", "stop record ok");
            } else if (e.ale().alf()) {
                this.fHX = true;
                this.fHW = "audio is stop, don't stop record again";
            } else {
                this.fHX = true;
                this.fHW = "stop record fail";
            }
            if (this.fHX) {
                x.e("MicroMsg.Record.JsApiOperateRecorder", this.fHW);
            }
            En();
        } catch (JSONException e) {
            x.e("MicroMsg.Record.JsApiOperateRecorder", "new json exists exception, data is invalid, dataStr:%s", new Object[]{this.fII});
            this.fHX = true;
            this.action = -1;
            this.fHW = "parser data fail, data is invalid";
            x.e("MicroMsg.Record.JsApiOperateRecorder", "exception:%s" + e.getMessage());
            En();
        }
    }

    public final void En() {
        Throwable e;
        com.tencent.mm.plugin.appbrand.jsapi.h a;
        super.En();
        if (this.fFa == null) {
            x.e("MicroMsg.Record.JsApiOperateRecorder", "service is null, don't callback");
        } else if (this.action != -1) {
            a aVar = new a();
            switch (this.action) {
                case 0:
                case 1:
                    i.a(this.fIH, true);
                    if (!i.ahY().contains(this.appId)) {
                        com.tencent.mm.plugin.appbrand.e.a(this.appId, this.fIs);
                        i.ahY().add(this.appId);
                        break;
                    }
                    break;
                case 2:
                case 3:
                case 4:
                    i.a(this.fIH, false);
                    if (this.action == 2 || this.action == 4) {
                        com.tencent.mm.plugin.appbrand.e.b(this.appId, this.fIs);
                        i.ahY().remove(this.appId);
                        break;
                    }
            }
            if (this.action == 2) {
                Map hashMap = new HashMap();
                hashMap.put("state", this.state);
                x.i("MicroMsg.Record.JsApiOperateRecorder", "filePath:%s, encodeFormat:%s", new Object[]{this.filePath, this.fIJ});
                AppBrandLocalMediaObject attach = AppBrandLocalMediaObjectManager.attach(this.fFa.mAppId, this.filePath, f.ux(this.fIJ), false);
                if (attach != null) {
                    hashMap.put("tempFilePath", attach.bNH);
                } else {
                    x.e("MicroMsg.Record.JsApiOperateRecorder", "AppBrandLocalMediaObject obj is null");
                    hashMap.put("tempFilePath", "");
                }
                hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(this.duration));
                hashMap.put("fileSize", Integer.valueOf(this.fileSize));
                this.fIt = new JSONObject(hashMap).toString();
            }
            if (this.action == 5) {
                Map hashMap2 = new HashMap();
                hashMap2.put("state", this.state);
                hashMap2.put("isLastFrame", Boolean.valueOf(this.bVM));
                if (this.fIL > 819200) {
                    long nanoTime = System.nanoTime();
                    File file;
                    FileInputStream fileInputStream;
                    try {
                        file = new File(this.fIK);
                        try {
                            if (file.exists()) {
                                fileInputStream = new FileInputStream(file);
                                try {
                                    this.bVL = new byte[this.fIL];
                                    fileInputStream.read(this.bVL);
                                    fileInputStream.close();
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable e2) {
                                        x.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e2, "", new Object[0]);
                                    }
                                    if (file.exists()) {
                                        file.delete();
                                    } else {
                                        x.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                    }
                                } catch (FileNotFoundException e3) {
                                    e2 = e3;
                                    try {
                                        x.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e2, "", new Object[0]);
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (Throwable e22) {
                                                x.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e22, "", new Object[0]);
                                            }
                                        }
                                        if (file == null) {
                                        }
                                        x.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                        x.d("MicroMsg.Record.JsApiOperateRecorder", "time:%d", new Object[]{Long.valueOf(System.nanoTime() - nanoTime)});
                                        if (this.bVL != null) {
                                            x.e("MicroMsg.Record.JsApiOperateRecorder", "framBuffer is null, error");
                                        } else {
                                            hashMap2.put("frameBuffer", ByteBuffer.wrap(this.bVL));
                                        }
                                        if (m.a(this.fFa, hashMap2, aVar)) {
                                            this.fIt = new JSONObject(hashMap2).toString();
                                        }
                                        x.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", new Object[]{Integer.valueOf(this.action), this.fIt});
                                        a = aVar.a(this.fFa);
                                        a.mData = this.fIt;
                                        a.ahM();
                                    } catch (Throwable th) {
                                        e22 = th;
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (Throwable e4) {
                                                x.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e4, "", new Object[0]);
                                            }
                                        }
                                        if (file == null) {
                                        }
                                        x.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                        throw e22;
                                    }
                                } catch (IOException e5) {
                                    e22 = e5;
                                    x.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e22, "", new Object[0]);
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Throwable e222) {
                                            x.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e222, "", new Object[0]);
                                        }
                                    }
                                    if (file == null) {
                                    }
                                    x.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                    x.d("MicroMsg.Record.JsApiOperateRecorder", "time:%d", new Object[]{Long.valueOf(System.nanoTime() - nanoTime)});
                                    if (this.bVL != null) {
                                        hashMap2.put("frameBuffer", ByteBuffer.wrap(this.bVL));
                                    } else {
                                        x.e("MicroMsg.Record.JsApiOperateRecorder", "framBuffer is null, error");
                                    }
                                    if (m.a(this.fFa, hashMap2, aVar)) {
                                        this.fIt = new JSONObject(hashMap2).toString();
                                    }
                                    x.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", new Object[]{Integer.valueOf(this.action), this.fIt});
                                    a = aVar.a(this.fFa);
                                    a.mData = this.fIt;
                                    a.ahM();
                                }
                                x.d("MicroMsg.Record.JsApiOperateRecorder", "time:%d", new Object[]{Long.valueOf(System.nanoTime() - nanoTime)});
                            } else {
                                x.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, return");
                                if (file.exists()) {
                                    file.delete();
                                } else {
                                    x.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                }
                            }
                        } catch (FileNotFoundException e6) {
                            e222 = e6;
                            fileInputStream = null;
                            x.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e222, "", new Object[0]);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable e2222) {
                                    x.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e2222, "", new Object[0]);
                                }
                            }
                            if (file == null && file.exists()) {
                                file.delete();
                            } else {
                                x.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                            }
                            x.d("MicroMsg.Record.JsApiOperateRecorder", "time:%d", new Object[]{Long.valueOf(System.nanoTime() - nanoTime)});
                            if (this.bVL != null) {
                                x.e("MicroMsg.Record.JsApiOperateRecorder", "framBuffer is null, error");
                            } else {
                                hashMap2.put("frameBuffer", ByteBuffer.wrap(this.bVL));
                            }
                            if (m.a(this.fFa, hashMap2, aVar)) {
                                this.fIt = new JSONObject(hashMap2).toString();
                            }
                            x.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", new Object[]{Integer.valueOf(this.action), this.fIt});
                            a = aVar.a(this.fFa);
                            a.mData = this.fIt;
                            a.ahM();
                        } catch (IOException e7) {
                            e2222 = e7;
                            fileInputStream = null;
                            x.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e2222, "", new Object[0]);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable e22222) {
                                    x.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e22222, "", new Object[0]);
                                }
                            }
                            if (file == null && file.exists()) {
                                file.delete();
                            } else {
                                x.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                            }
                            x.d("MicroMsg.Record.JsApiOperateRecorder", "time:%d", new Object[]{Long.valueOf(System.nanoTime() - nanoTime)});
                            if (this.bVL != null) {
                                hashMap2.put("frameBuffer", ByteBuffer.wrap(this.bVL));
                            } else {
                                x.e("MicroMsg.Record.JsApiOperateRecorder", "framBuffer is null, error");
                            }
                            if (m.a(this.fFa, hashMap2, aVar)) {
                                this.fIt = new JSONObject(hashMap2).toString();
                            }
                            x.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", new Object[]{Integer.valueOf(this.action), this.fIt});
                            a = aVar.a(this.fFa);
                            a.mData = this.fIt;
                            a.ahM();
                        } catch (Throwable th2) {
                            e22222 = th2;
                            fileInputStream = null;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable e42) {
                                    x.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e42, "", new Object[0]);
                                }
                            }
                            if (file == null && file.exists()) {
                                file.delete();
                            } else {
                                x.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                            }
                            throw e22222;
                        }
                    } catch (FileNotFoundException e8) {
                        e22222 = e8;
                        fileInputStream = null;
                        file = null;
                        x.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e22222, "", new Object[0]);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e222222) {
                                x.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e222222, "", new Object[0]);
                            }
                        }
                        if (file == null) {
                        }
                        x.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                        x.d("MicroMsg.Record.JsApiOperateRecorder", "time:%d", new Object[]{Long.valueOf(System.nanoTime() - nanoTime)});
                        if (this.bVL != null) {
                            x.e("MicroMsg.Record.JsApiOperateRecorder", "framBuffer is null, error");
                        } else {
                            hashMap2.put("frameBuffer", ByteBuffer.wrap(this.bVL));
                        }
                        if (m.a(this.fFa, hashMap2, aVar)) {
                            this.fIt = new JSONObject(hashMap2).toString();
                        }
                        x.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", new Object[]{Integer.valueOf(this.action), this.fIt});
                        a = aVar.a(this.fFa);
                        a.mData = this.fIt;
                        a.ahM();
                    } catch (IOException e9) {
                        e222222 = e9;
                        fileInputStream = null;
                        file = null;
                        x.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e222222, "", new Object[0]);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e2222222) {
                                x.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e2222222, "", new Object[0]);
                            }
                        }
                        if (file == null) {
                        }
                        x.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                        x.d("MicroMsg.Record.JsApiOperateRecorder", "time:%d", new Object[]{Long.valueOf(System.nanoTime() - nanoTime)});
                        if (this.bVL != null) {
                            hashMap2.put("frameBuffer", ByteBuffer.wrap(this.bVL));
                        } else {
                            x.e("MicroMsg.Record.JsApiOperateRecorder", "framBuffer is null, error");
                        }
                        if (m.a(this.fFa, hashMap2, aVar)) {
                            this.fIt = new JSONObject(hashMap2).toString();
                        }
                        x.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", new Object[]{Integer.valueOf(this.action), this.fIt});
                        a = aVar.a(this.fFa);
                        a.mData = this.fIt;
                        a.ahM();
                    } catch (Throwable th3) {
                        e2222222 = th3;
                        fileInputStream = null;
                        file = null;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e422) {
                                x.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e422, "", new Object[0]);
                            }
                        }
                        if (file == null) {
                        }
                        x.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                        throw e2222222;
                    }
                }
                if (this.bVL != null) {
                    hashMap2.put("frameBuffer", ByteBuffer.wrap(this.bVL));
                } else {
                    x.e("MicroMsg.Record.JsApiOperateRecorder", "framBuffer is null, error");
                }
                if (m.a(this.fFa, hashMap2, aVar)) {
                    this.fIt = new JSONObject(hashMap2).toString();
                }
            }
            x.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", new Object[]{Integer.valueOf(this.action), this.fIt});
            a = aVar.a(this.fFa);
            a.mData = this.fIt;
            a.ahM();
        } else if (this.fHX) {
            x.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder fail:%s", new Object[]{this.fHW});
            this.fFa.E(this.fFd, this.fIH.f("fail:" + this.fHW, null));
        } else {
            x.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder ok");
            this.fFa.E(this.fFd, this.fIH.f("ok", null));
        }
    }
}
