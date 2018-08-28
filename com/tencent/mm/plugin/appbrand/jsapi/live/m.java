package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.ui.TXCloudVideoView;

public final class m implements ITXLivePushListener {
    boolean dni = false;
    private boolean fRE = false;
    TXCloudVideoView fRV;
    private boolean fSA = false;
    private boolean fSB = false;
    private String fSc = "vertical";
    private boolean fSi = false;
    private TXLivePushConfig fSj;
    TXLivePusher fSk;
    ITXLivePushListener fSl;
    String fSm;
    private boolean fSn = false;
    private boolean fSo = false;
    ITXSnapshotListener fSp;
    boolean fSq = false;
    private int fSr = 2;
    private int fSs = -1;
    private int fSt = -1;
    private int fSu = 0;
    boolean fSv = true;
    private String fSw = "high";
    private int fSx = 5;
    private int fSy = 3;
    private String fSz = "";
    private Context mContext;
    private boolean mEnableZoom = true;
    private boolean mFrontCamera = true;
    private int mMode = 1;
    private boolean mMute = false;

    public m(Context context) {
        this.mContext = context;
        this.fSj = new TXLivePushConfig();
        this.fSk = new TXLivePusher(context);
        this.fSk.setConfig(this.fSj);
        this.fSk.setPushListener(this);
    }

    public final j tD(String str) {
        boolean z = true;
        int i = 0;
        if (str == null) {
            return new j(-1, "invalid params");
        }
        x.i("TXLivePusherJSAdapter", "operateLivePusher: " + str);
        if (str.equalsIgnoreCase("switchCamera")) {
            this.mFrontCamera = !this.mFrontCamera;
            this.fSj.setFrontCamera(this.mFrontCamera);
        }
        if (!this.dni) {
            return new j(-3, "uninited livePusher");
        }
        if (str.equalsIgnoreCase("start")) {
            if (!(this.fSm == null || this.fSm.isEmpty() || this.fSk.isPushing())) {
                this.fRV.setVisibility(0);
                if (this.fSv) {
                    this.fSk.startCameraPreview(this.fRV);
                }
                this.fSk.startPusher(this.fSm);
            }
        } else if (str.equalsIgnoreCase("stop")) {
            this.fSB = false;
            this.fSk.stopCameraPreview(true);
            this.fSk.stopPusher();
        } else if (str.equalsIgnoreCase("pause")) {
            if (this.fSB && this.fSk.isPushing()) {
                this.fSk.turnOnFlashLight(false);
            }
            this.fSk.pausePusher();
        } else if (str.equalsIgnoreCase("resume")) {
            this.fSk.resumePusher();
        } else if (str.equalsIgnoreCase("switchCamera")) {
            this.fSB = false;
            this.fSk.switchCamera();
        } else if (str.equalsIgnoreCase("snapshot")) {
            ITXSnapshotListener iTXSnapshotListener = this.fSp;
            if (this.fSk != null && this.fSk.isPushing()) {
                this.fSk.snapshot(iTXSnapshotListener);
            }
        } else if (!str.equalsIgnoreCase("toggleTorch")) {
            return new j(-4, "invalid operate command");
        } else {
            if (!this.fSk.isPushing()) {
                return new j(-1, "fail");
            }
            String str2;
            if (this.fSB) {
                z = false;
            }
            boolean turnOnFlashLight = this.fSk.turnOnFlashLight(z);
            if (!turnOnFlashLight) {
                z = this.fSB;
            }
            this.fSB = z;
            if (!turnOnFlashLight) {
                i = -1;
            }
            if (turnOnFlashLight) {
                str2 = "Success";
            } else {
                str2 = "Failed";
            }
            return new j(i, str2);
        }
        return new j();
    }

    public final j cQ(boolean z) {
        this.fSn = this.fSk.isPushing();
        if (!this.fSn) {
            return new j();
        }
        if (!z) {
            return tD("pause");
        }
        this.fSo = z;
        if (this.fRE && this.fSl != null) {
            this.fSl.onPushEvent(5000, new Bundle());
        }
        return tD("stop");
    }

    public final j ajf() {
        if (!this.fSn) {
            return new j();
        }
        if (this.fSo) {
            return tD("start");
        }
        return tD("resume");
    }

    public final void onPushEvent(int i, Bundle bundle) {
        if (i == -1307) {
            tD("stop");
        } else if (i == 1003 && this.fSB) {
            this.fSk.turnOnFlashLight(this.fSB);
        }
        if (this.fRE && this.fSl != null) {
            this.fSl.onPushEvent(i, bundle);
        }
    }

    public final void onNetStatus(Bundle bundle) {
        if (this.fSl != null) {
            this.fSl.onNetStatus(bundle);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void c(android.os.Bundle r18, boolean r19) {
        /*
        r17 = this;
        if (r19 != 0) goto L_0x000d;
    L_0x0002:
        r1 = r18.keySet();
        r1 = r1.size();
        if (r1 != 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r1 = "mode";
        r0 = r17;
        r2 = r0.mMode;
        r0 = r18;
        r6 = r0.getInt(r1, r2);
        if (r19 != 0) goto L_0x0022;
    L_0x001c:
        r0 = r17;
        r1 = r0.mMode;
        if (r6 == r1) goto L_0x0025;
    L_0x0022:
        switch(r6) {
            case 1: goto L_0x02b8;
            case 2: goto L_0x02cc;
            case 3: goto L_0x02e0;
            case 4: goto L_0x02f4;
            case 5: goto L_0x0300;
            case 6: goto L_0x030c;
            default: goto L_0x0025;
        };
    L_0x0025:
        r0 = r17;
        r4 = r0.fSs;
        r0 = r17;
        r2 = r0.fSt;
        r1 = "minBitrate";
        r3 = -1;
        r0 = r18;
        r3 = r0.getInt(r1, r3);
        r1 = "maxBitrate";
        r5 = -1;
        r0 = r18;
        r1 = r0.getInt(r1, r5);
        r5 = -1;
        if (r3 == r5) goto L_0x0390;
    L_0x0044:
        r5 = -1;
        if (r1 == r5) goto L_0x0390;
    L_0x0047:
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r3 >= r5) goto L_0x004d;
    L_0x004b:
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
    L_0x004d:
        r5 = 1800; // 0x708 float:2.522E-42 double:8.893E-321;
        if (r1 <= r5) goto L_0x0053;
    L_0x0051:
        r1 = 1800; // 0x708 float:2.522E-42 double:8.893E-321;
    L_0x0053:
        if (r3 > r1) goto L_0x0390;
    L_0x0055:
        r2 = "aspect";
        r0 = r17;
        r4 = r0.fSr;
        r0 = r18;
        r7 = r0.getInt(r2, r4);
        r2 = "audioQuality";
        r0 = r17;
        r4 = r0.fSw;
        r0 = r18;
        r8 = r0.getString(r2, r4);
        r2 = 6;
        if (r6 != r2) goto L_0x00a6;
    L_0x0072:
        r2 = 1;
        if (r7 != r2) goto L_0x0318;
    L_0x0075:
        r0 = r17;
        r2 = r0.fSj;
        r4 = 13;
        r2.setVideoResolution(r4);
    L_0x007e:
        r2 = -1;
        if (r3 == r2) goto L_0x0094;
    L_0x0081:
        r2 = -1;
        if (r1 == r2) goto L_0x0094;
    L_0x0084:
        if (r3 > r1) goto L_0x0094;
    L_0x0086:
        r0 = r17;
        r2 = r0.fSj;
        r2.setMinVideoBitrate(r3);
        r0 = r17;
        r2 = r0.fSj;
        r2.setMaxVideoBitrate(r1);
    L_0x0094:
        r2 = "low";
        r2 = r8.equalsIgnoreCase(r2);
        if (r2 == 0) goto L_0x0325;
    L_0x009d:
        r0 = r17;
        r2 = r0.fSj;
        r4 = 16000; // 0x3e80 float:2.2421E-41 double:7.905E-320;
        r2.setAudioSampleRate(r4);
    L_0x00a6:
        r2 = "focusMode";
        r0 = r17;
        r4 = r0.fSu;
        r0 = r18;
        r9 = r0.getInt(r2, r4);
        r0 = r17;
        r4 = r0.fSj;
        if (r9 == 0) goto L_0x033a;
    L_0x00b9:
        r2 = 1;
    L_0x00ba:
        r4.setTouchFocus(r2);
        r2 = "enableCamera";
        r0 = r17;
        r4 = r0.fSv;
        r0 = r18;
        r4 = r0.getBoolean(r2, r4);
        r0 = r17;
        r5 = r0.fSj;
        if (r4 != 0) goto L_0x033d;
    L_0x00d0:
        r2 = 1;
    L_0x00d1:
        r5.enablePureAudioPush(r2);
        r2 = 6;
        if (r6 == r2) goto L_0x038d;
    L_0x00d7:
        r2 = 1;
    L_0x00d8:
        r4 = "orientation";
        r0 = r17;
        r5 = r0.fSc;
        r0 = r18;
        r10 = r0.getString(r4, r5);
        r4 = 0;
        r5 = "horizontal";
        r5 = r10.equalsIgnoreCase(r5);
        if (r5 == 0) goto L_0x0340;
    L_0x00ef:
        r0 = r17;
        r4 = r0.fSj;
        r5 = 0;
        r4.setHomeOrientation(r5);
        r4 = 90;
    L_0x00f9:
        r5 = "beauty";
        r0 = r17;
        r11 = r0.fSx;
        r0 = r18;
        r11 = r0.getInt(r5, r11);
        r5 = "whiteness";
        r0 = r17;
        r12 = r0.fSy;
        r0 = r18;
        r12 = r0.getInt(r5, r12);
        r0 = r17;
        r5 = r0.fSj;
        r13 = 5;
        r5.setBeautyFilter(r11, r12, r13);
        r5 = "backgroundImage";
        r0 = r17;
        r13 = r0.fSz;
        r0 = r18;
        r13 = r0.getString(r5, r13);
        r5 = android.graphics.BitmapFactory.decodeFile(r13);
        if (r5 == 0) goto L_0x0135;
    L_0x012e:
        r0 = r17;
        r14 = r0.fSj;
        r14.setPauseImg(r5);
    L_0x0135:
        r5 = "backgroundMute";
        r0 = r17;
        r14 = r0.fSA;
        r0 = r18;
        r14 = r0.getBoolean(r5, r14);
        if (r14 == 0) goto L_0x0354;
    L_0x0144:
        r0 = r17;
        r5 = r0.fSj;
        r15 = 3;
        r5.setPauseFlag(r15);
    L_0x014c:
        r5 = "zoom";
        r0 = r17;
        r15 = r0.mEnableZoom;
        r0 = r18;
        r15 = r0.getBoolean(r5, r15);
        r0 = r17;
        r5 = r0.fSj;
        r5.setEnableZoom(r15);
        r5 = 0;
        r0 = r17;
        r0 = r0.fSr;
        r16 = r0;
        r0 = r16;
        if (r7 != r0) goto L_0x01e5;
    L_0x016b:
        r0 = r17;
        r0 = r0.fSs;
        r16 = r0;
        r0 = r16;
        if (r3 != r0) goto L_0x01e5;
    L_0x0175:
        r0 = r17;
        r0 = r0.fSt;
        r16 = r0;
        r0 = r16;
        if (r1 != r0) goto L_0x01e5;
    L_0x017f:
        r0 = r17;
        r0 = r0.fSu;
        r16 = r0;
        r0 = r16;
        if (r9 != r0) goto L_0x01e5;
    L_0x0189:
        r0 = r17;
        r0 = r0.fSv;
        r16 = r0;
        r0 = r16;
        if (r2 != r0) goto L_0x01e5;
    L_0x0193:
        r0 = r17;
        r0 = r0.fSx;
        r16 = r0;
        r0 = r16;
        if (r11 != r0) goto L_0x01e5;
    L_0x019d:
        r0 = r17;
        r0 = r0.fSy;
        r16 = r0;
        r0 = r16;
        if (r12 != r0) goto L_0x01e5;
    L_0x01a7:
        r0 = r17;
        r0 = r0.fSA;
        r16 = r0;
        r0 = r16;
        if (r14 != r0) goto L_0x01e5;
    L_0x01b1:
        r0 = r17;
        r0 = r0.mEnableZoom;
        r16 = r0;
        r0 = r16;
        if (r15 != r0) goto L_0x01e5;
    L_0x01bb:
        r0 = r17;
        r0 = r0.fSz;
        r16 = r0;
        r0 = r16;
        r16 = r13.equalsIgnoreCase(r0);
        if (r16 == 0) goto L_0x01e5;
    L_0x01c9:
        r0 = r17;
        r0 = r0.fSc;
        r16 = r0;
        r0 = r16;
        r16 = r10.equalsIgnoreCase(r0);
        if (r16 == 0) goto L_0x01e5;
    L_0x01d7:
        r0 = r17;
        r0 = r0.fSw;
        r16 = r0;
        r0 = r16;
        r16 = r8.equalsIgnoreCase(r0);
        if (r16 != 0) goto L_0x01e6;
    L_0x01e5:
        r5 = 1;
    L_0x01e6:
        if (r19 != 0) goto L_0x01ea;
    L_0x01e8:
        if (r5 == 0) goto L_0x020c;
    L_0x01ea:
        r0 = r17;
        r5 = r0.fSk;
        r0 = r17;
        r0 = r0.fSj;
        r16 = r0;
        r0 = r16;
        r5.setConfig(r0);
        r0 = r17;
        r5 = r0.fSk;
        r5.setRenderRotation(r4);
        r0 = r17;
        r4 = r0.fSk;
        r5 = 0;
        r16 = 2;
        r0 = r16;
        r4.setBeautyFilter(r5, r11, r12, r0);
    L_0x020c:
        r0 = r17;
        r4 = r0.fSk;
        r4 = r4.isPushing();
        if (r4 == 0) goto L_0x0231;
    L_0x0216:
        r0 = r17;
        r4 = r0.fSv;
        if (r2 == r4) goto L_0x0368;
    L_0x021c:
        if (r2 == 0) goto L_0x035e;
    L_0x021e:
        r0 = r17;
        r4 = r0.fSk;
        r5 = 1;
        r4.stopCameraPreview(r5);
        r0 = r17;
        r4 = r0.fSk;
        r0 = r17;
        r5 = r0.fRV;
        r4.startCameraPreview(r5);
    L_0x0231:
        r0 = r17;
        r0.mMode = r6;
        r0 = r17;
        r0.fSr = r7;
        r0 = r17;
        r0.fSu = r9;
        r0 = r17;
        r0.fSv = r2;
        r0 = r17;
        r0.fSc = r10;
        r0 = r17;
        r0.fSx = r11;
        r0 = r17;
        r0.fSy = r12;
        r0 = r17;
        r0.fSA = r14;
        r0 = r17;
        r0.fSz = r13;
        r0 = r17;
        r0.fSs = r3;
        r0 = r17;
        r0.fSt = r1;
        r0 = r17;
        r0.fSw = r8;
        r0 = r17;
        r0.mEnableZoom = r15;
        r1 = "needEvent";
        r0 = r17;
        r2 = r0.fRE;
        r0 = r18;
        r1 = r0.getBoolean(r1, r2);
        r0 = r17;
        r0.fRE = r1;
        r1 = "muted";
        r0 = r17;
        r2 = r0.mMute;
        r0 = r18;
        r1 = r0.getBoolean(r1, r2);
        if (r19 != 0) goto L_0x028b;
    L_0x0285:
        r0 = r17;
        r2 = r0.mMute;
        if (r1 == r2) goto L_0x0292;
    L_0x028b:
        r0 = r17;
        r2 = r0.fSk;
        r2.setMute(r1);
    L_0x0292:
        r0 = r17;
        r0.mMute = r1;
        r1 = "debug";
        r0 = r17;
        r2 = r0.fSi;
        r0 = r18;
        r1 = r0.getBoolean(r1, r2);
        if (r19 != 0) goto L_0x02ab;
    L_0x02a5:
        r0 = r17;
        r2 = r0.fSi;
        if (r1 == r2) goto L_0x02b2;
    L_0x02ab:
        r0 = r17;
        r2 = r0.fRV;
        r2.showLog(r1);
    L_0x02b2:
        r0 = r17;
        r0.fSi = r1;
        goto L_0x000c;
    L_0x02b8:
        r0 = r17;
        r1 = r0.fSk;
        r2 = 1;
        r3 = 0;
        r4 = 0;
        r1.setVideoQuality(r2, r3, r4);
        r0 = r17;
        r1 = r0.fSj;
        r2 = 5;
        r1.setVideoEncodeGop(r2);
        goto L_0x0025;
    L_0x02cc:
        r0 = r17;
        r1 = r0.fSk;
        r2 = 2;
        r3 = 1;
        r4 = 0;
        r1.setVideoQuality(r2, r3, r4);
        r0 = r17;
        r1 = r0.fSj;
        r2 = 5;
        r1.setVideoEncodeGop(r2);
        goto L_0x0025;
    L_0x02e0:
        r0 = r17;
        r1 = r0.fSk;
        r2 = 3;
        r3 = 1;
        r4 = 0;
        r1.setVideoQuality(r2, r3, r4);
        r0 = r17;
        r1 = r0.fSj;
        r2 = 5;
        r1.setVideoEncodeGop(r2);
        goto L_0x0025;
    L_0x02f4:
        r0 = r17;
        r1 = r0.fSk;
        r2 = 4;
        r3 = 1;
        r4 = 0;
        r1.setVideoQuality(r2, r3, r4);
        goto L_0x0025;
    L_0x0300:
        r0 = r17;
        r1 = r0.fSk;
        r2 = 5;
        r3 = 1;
        r4 = 0;
        r1.setVideoQuality(r2, r3, r4);
        goto L_0x0025;
    L_0x030c:
        r0 = r17;
        r1 = r0.fSk;
        r2 = 6;
        r3 = 0;
        r4 = 0;
        r1.setVideoQuality(r2, r3, r4);
        goto L_0x0025;
    L_0x0318:
        r2 = 2;
        if (r7 != r2) goto L_0x007e;
    L_0x031b:
        r0 = r17;
        r2 = r0.fSj;
        r4 = 0;
        r2.setVideoResolution(r4);
        goto L_0x007e;
    L_0x0325:
        r2 = "high";
        r2 = r8.equalsIgnoreCase(r2);
        if (r2 == 0) goto L_0x00a6;
    L_0x032e:
        r0 = r17;
        r2 = r0.fSj;
        r4 = 48000; // 0xbb80 float:6.7262E-41 double:2.3715E-319;
        r2.setAudioSampleRate(r4);
        goto L_0x00a6;
    L_0x033a:
        r2 = 0;
        goto L_0x00ba;
    L_0x033d:
        r2 = 0;
        goto L_0x00d1;
    L_0x0340:
        r5 = "vertical";
        r5 = r10.equalsIgnoreCase(r5);
        if (r5 == 0) goto L_0x00f9;
    L_0x0349:
        r0 = r17;
        r4 = r0.fSj;
        r5 = 1;
        r4.setHomeOrientation(r5);
        r4 = 0;
        goto L_0x00f9;
    L_0x0354:
        r0 = r17;
        r5 = r0.fSj;
        r15 = 1;
        r5.setPauseFlag(r15);
        goto L_0x014c;
    L_0x035e:
        r0 = r17;
        r4 = r0.fSk;
        r5 = 1;
        r4.stopCameraPreview(r5);
        goto L_0x0231;
    L_0x0368:
        r0 = r17;
        r4 = r0.fSv;
        if (r4 == 0) goto L_0x0231;
    L_0x036e:
        r0 = r17;
        r4 = r0.fSc;
        r4 = r10.equalsIgnoreCase(r4);
        if (r4 != 0) goto L_0x0231;
    L_0x0378:
        r0 = r17;
        r4 = r0.fSk;
        r5 = 1;
        r4.stopCameraPreview(r5);
        r0 = r17;
        r4 = r0.fSk;
        r0 = r17;
        r5 = r0.fRV;
        r4.startCameraPreview(r5);
        goto L_0x0231;
    L_0x038d:
        r2 = r4;
        goto L_0x00d8;
    L_0x0390:
        r1 = r2;
        r3 = r4;
        goto L_0x0055;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.live.m.c(android.os.Bundle, boolean):void");
    }

    static void d(String str, Bundle bundle) {
        for (String str2 : bundle.keySet()) {
            if (str2.equalsIgnoreCase("pushUrl") || str2.equalsIgnoreCase("orientation") || str2.equalsIgnoreCase("backgroundImage") || str2.equalsIgnoreCase("audioQuality")) {
                str = str + "\n" + str2 + " = " + bundle.getString(str2);
            } else if (str2.equalsIgnoreCase("mode") || str2.equalsIgnoreCase("focusMode") || str2.equalsIgnoreCase("beauty") || str2.equalsIgnoreCase("whiteness") || str2.equalsIgnoreCase("aspect") || str2.equalsIgnoreCase("minBitrate") || str2.equalsIgnoreCase("maxBitrate")) {
                str = str + "\n" + str2 + " = " + bundle.getInt(str2);
            } else if (str2.equalsIgnoreCase("hide") || str2.equalsIgnoreCase("autopush") || str2.equalsIgnoreCase("muted") || str2.equalsIgnoreCase("enableCamera") || str2.equalsIgnoreCase("backgroundMute") || str2.equalsIgnoreCase("zoom") || str2.equalsIgnoreCase("needEvent") || str2.equalsIgnoreCase("debug")) {
                str = str + "\n" + str2 + " = " + bundle.getBoolean(str2);
            }
        }
        x.i("TXLivePusherJSAdapter", str);
    }
}
