package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.WindowManager;

@TargetApi(16)
public final class d {
    final a aDJ;
    final boolean aDK;
    final long aDL;
    final long aDM;
    long aDN;
    long aDO;
    long aDP;
    boolean aDQ;
    long aDR;
    long aDS;
    long aDT;

    public d() {
        this(-1.0d);
    }

    public d(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this(windowManager.getDefaultDisplay() != null ? (double) windowManager.getDefaultDisplay().getRefreshRate() : -1.0d);
    }

    private d(double d) {
        this.aDK = d != -1.0d;
        if (this.aDK) {
            this.aDJ = a.my();
            this.aDL = (long) (1.0E9d / d);
            this.aDM = (this.aDL * 80) / 100;
            return;
        }
        this.aDJ = null;
        this.aDL = -1;
        this.aDM = -1;
    }

    final boolean e(long j, long j2) {
        return Math.abs((j2 - this.aDR) - (j - this.aDS)) > 20000000;
    }
}
