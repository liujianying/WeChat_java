package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.c.c;

public final class i {
    public int jIm;
    public int mHeight;
    public int mWidth;
    public int vzl;
    public int vzm;
    public int vzn;
    public int vzo;
    public int vzp;
    public int vzq;
    public int vzr;
    public int vzs;
    public int vzt;

    public i(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        this.vzl = i;
        this.mWidth = i2;
        this.mHeight = i3;
        this.vzm = i4;
        this.vzn = i5;
        this.vzo = i6;
        this.vzp = i7;
        this.jIm = i8;
        this.vzq = i9;
        this.vzr = i10;
        this.vzs = i11;
        this.vzt = i12;
        c.d("VoiceEngineConf", new Object[]{"mDisableVideo: ", Integer.valueOf(i), " mWidth: ", Integer.valueOf(i2), " mHeight: ", Integer.valueOf(i3), " mInFPS: ", Integer.valueOf(i4), " mOutFmt: ", Integer.valueOf(i5), " mOSType: ", Integer.valueOf(i6), " mNetKbps: ", Integer.valueOf(i7), " mNetType: ", Integer.valueOf(i8), " mMTUSize: ", Integer.valueOf(i9), " mCPUFlag: ", Integer.valueOf(i10), " mDispRate: ", Integer.valueOf(i11), " mVCodecType: ", Integer.valueOf(i12)});
    }
}
