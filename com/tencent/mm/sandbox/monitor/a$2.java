package com.tencent.mm.sandbox.monitor;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements Runnable {
    final /* synthetic */ String bpP;
    final /* synthetic */ String dhF;
    final /* synthetic */ int oDp;
    final /* synthetic */ String oDq;
    final /* synthetic */ PByteArray oDr;

    a$2(int i, String str, String str2, String str3, PByteArray pByteArray) {
        this.oDp = i;
        this.oDq = str;
        this.bpP = str2;
        this.dhF = str3;
        this.oDr = pByteArray;
    }

    public final void run() {
        StringBuilder append = new StringBuilder().append("http://" + ad.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com")).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(d.qVN)).append("&devicetype=").append(d.DEVICE_TYPE).append("&filelength=").append(this.oDp).append("&sum=").append(this.oDq).append("&reporttype=1&NewReportType=").append(bi.f((Integer) a.dhS.get(this.bpP)));
        if (!(this.dhF == null || this.dhF.equals(""))) {
            append.append("&username=").append(this.dhF);
        }
        x.d("MicroMsg.CrashUpload", "dkcrash sb:" + append.toString());
        a.w(append.toString(), this.oDr.value);
    }
}
