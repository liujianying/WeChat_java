package com.tencent.mm.sandbox.monitor;

import android.os.Build;
import com.tencent.mm.protocal.d;

class b$a {
    public String bIr;
    public final String platform = (d.DEVICE_TYPE + "_" + d.qVN + "_" + Build.CPU_ABI);
    public boolean sCZ;
    public String tag;
    public long timestamp;
    public String username;

    public b$a(String str, String str2, long j, String str3, boolean z) {
        this.username = str;
        this.tag = str2;
        this.timestamp = j;
        this.bIr = str3;
        this.sCZ = false;
        this.sCZ = z;
    }

    public final String toString() {
        return this.username + "," + this.platform + "," + this.tag + ",time_" + this.timestamp + ",error_" + this.bIr;
    }
}
