package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import com.tencent.mm.plugin.voip.video.CaptureView;

public interface b {
    void OH(String str);

    void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6);

    void aL(int i, String str);

    void aYv();

    void bKB();

    Context bLD();

    void bLE();

    void c(int i, int i2, int[] iArr);

    void dQ(int i, int i2);

    void setCaptureView(CaptureView captureView);

    void setConnectSec(long j);

    void setHWDecMode(int i);

    void setMute(boolean z);

    void setScreenEnable(boolean z);

    void uninit();

    void yN(int i);
}
