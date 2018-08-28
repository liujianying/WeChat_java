package com.tencent.smtt.sdk;

import android.util.Log;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.smtt.utils.TbsLog;

public class TbsLogReport$TbsLogInfo implements Cloneable {
    int a;
    private long b;
    private String c;
    private String d;
    private int e;
    private int f;
    private int g;
    private int h;
    private String i;
    private int j;
    private int k;
    private long l;
    private long m;
    private int n;
    private String o;
    private String p;
    private long q;

    private TbsLogReport$TbsLogInfo() {
        resetArgs();
    }

    /* synthetic */ TbsLogReport$TbsLogInfo(ax axVar) {
        this();
    }

    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return this;
        }
    }

    public int getDownFinalFlag() {
        return this.k;
    }

    public void resetArgs() {
        this.b = 0;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 2;
        this.i = "unknown";
        this.j = 0;
        this.k = 2;
        this.l = 0;
        this.m = 0;
        this.n = 1;
        this.a = 0;
        this.o = null;
        this.p = null;
        this.q = 0;
    }

    public void setApn(String str) {
        this.i = str;
    }

    public void setCheckErrorDetail(String str) {
        setErrorCode(s$l.AppCompatTheme_ratingBarStyleSmall);
        this.o = str;
    }

    public void setDownConsumeTime(long j) {
        this.m += j;
    }

    public void setDownFinalFlag(int i) {
        this.k = i;
    }

    public void setDownloadCancel(int i) {
        this.g = i;
    }

    public void setDownloadSize(long j) {
        this.q += j;
    }

    public void setDownloadUrl(String str) {
        if (this.c == null) {
            this.c = str;
        } else {
            this.c += ";" + str;
        }
    }

    public void setErrorCode(int i) {
        if (!(i == 100 || i == s$l.AppCompatTheme_spinnerStyle || i == 120 || i == s$l.AppCompatTheme_switchStyle || i >= SystemUtil.SMALL_SCREEN_THRESHOLD)) {
            TbsLog.i("TbsDownload", "error occured, errorCode:" + i, true);
        }
        if (i == s$l.AppCompatTheme_switchStyle) {
            TbsLog.i("TbsDownload", "you are not in wifi, downloading stoped", true);
        }
        this.a = i;
    }

    public void setEventTime(long j) {
        this.b = j;
    }

    public void setFailDetail(String str) {
        if (str != null) {
            if (str.length() > 1024) {
                str = str.substring(0, 1024);
            }
            this.p = str;
        }
    }

    public void setFailDetail(Throwable th) {
        if (th == null) {
            this.p = "";
            return;
        }
        String stackTraceString = Log.getStackTraceString(th);
        if (stackTraceString.length() > 1024) {
            stackTraceString = stackTraceString.substring(0, 1024);
        }
        this.p = stackTraceString;
    }

    public void setHttpCode(int i) {
        this.e = i;
    }

    public void setNetworkChange(int i) {
        this.n = i;
    }

    public void setNetworkType(int i) {
        this.j = i;
    }

    public void setPatchUpdateFlag(int i) {
        this.f = i;
    }

    public void setPkgSize(long j) {
        this.l = j;
    }

    public void setResolveIp(String str) {
        this.d = str;
    }

    public void setUnpkgFlag(int i) {
        this.h = i;
    }
}
