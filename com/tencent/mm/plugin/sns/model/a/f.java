package com.tencent.mm.plugin.sns.model.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.compatible.e.n;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.k.g;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public abstract class f extends c {
    protected boolean ntm = false;
    protected boolean ntn = false;
    protected boolean nto = false;
    protected boolean ntp = false;

    public f(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    public final String MJ(String str) {
        Exception e;
        int i = 2;
        Object obj = null;
        String str2;
        try {
            int i2;
            Object obj2;
            Object obj3;
            int obj4;
            String value = g.AT().getValue("SnsCloseDownloadWebp");
            if (bi.oW(value)) {
                i2 = 0;
            } else {
                i2 = bi.WU(value);
            }
            if (i2 != 0) {
                obj2 = null;
            } else if (VERSION.SDK_INT < 14) {
                obj2 = null;
            } else if (q.deW.der == 2) {
                obj2 = null;
            } else if (bi.oW(af.exZ)) {
                int obj22 = 1;
            } else {
                obj22 = null;
            }
            if (!n.zq()) {
                obj3 = null;
            } else if (!com.tencent.mm.plugin.sns.model.af.byz()) {
                obj3 = null;
            } else if (bi.oW(af.exZ)) {
                i2 = 1;
            } else {
                obj3 = null;
            }
            if (n.zq() && com.tencent.mm.plugin.sns.model.af.byy() && bi.oW(af.exZ)) {
                obj4 = 1;
            }
            if (!bi.oW(af.exY) || !bi.oW(af.exZ)) {
                if (!bi.oW(af.exY)) {
                    String[] split = str.split("(//?)");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(split[0]).append("//").append(af.exY);
                    while (i < split.length) {
                        stringBuilder.append("/").append(split[i]);
                        i++;
                    }
                    str = stringBuilder.toString();
                    x.i("MicroMsg.SnsDownloadImageBase", "new url  " + str);
                }
                if (!bi.oW(af.exZ)) {
                    str = k(str, "tp=" + af.exZ);
                    x.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  " + str);
                }
            } else if (obj3 != null) {
                str = k(str, "tp=wxpc");
                x.i("MicroMsg.SnsDownloadImageBase", "new url  " + str);
            } else if (obj4 != null) {
                str = k(str, "tp=hevc");
                x.i("MicroMsg.SnsDownloadImageBase", "new url  " + str);
            } else if (obj22 != null) {
                str = k(str, "tp=webp");
                x.i("MicroMsg.SnsDownloadImageBase", "new url  " + str);
            }
            if (!(this.nsN == null || this.nsN.noc.rVQ == 0)) {
                str = k(str, "enc=1");
                x.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + this.nsN.noc.rVR + " " + this.nsN.noc.rVQ + " " + str);
                b.kB(136);
                this.ntp = true;
            }
            str2 = str;
            try {
                if (this.nsN == null || this.nsN.noc == null) {
                    return str2;
                }
                Object obj5;
                ate ate = this.nsN.noc;
                if (this.nsN.nsG) {
                    obj5 = ate.rVW;
                } else {
                    String obj52 = ate.rVT;
                }
                obj4 = this.nsN.nsG ? ate.rVX : ate.rVU;
                if (TextUtils.isEmpty(obj52)) {
                    return str2;
                }
                return k(str2, "token=" + obj52, "idx=" + obj4);
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + e.getMessage());
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = str;
        }
    }

    private static String k(String str, String... strArr) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append(str.contains("?") ? "&" : "?");
        Object obj = 1;
        for (String str2 : strArr) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append("&");
            }
            stringBuilder.append(str2);
        }
        return stringBuilder.toString();
    }
}
