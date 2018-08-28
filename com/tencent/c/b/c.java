package com.tencent.c.b;

import android.content.Context;
import android.os.Build;
import com.tencent.c.e.a.a.a;
import com.tencent.c.f.b;
import com.tencent.c.f.d;
import com.tencent.c.f.i;
import com.tencent.c.f.l;

public final class c {
    private Context mContext;
    private String mVersionName = null;
    private int vhU = -1;
    private com.tencent.c.c.a.c vhW = null;

    public c(Context context) {
        this.mContext = context;
        a bL = i.bL(context, context.getPackageName());
        this.mVersionName = bL.versionName;
        this.vhU = bL.versionCode;
    }

    public final byte[] c(String str, String str2, com.tencent.c.e.a.b.a aVar) {
        try {
            l lVar = new l();
            lVar.cFy();
            lVar.acw(str);
            lVar.acx(str2);
            lVar.acv("UTF-8");
            lVar.put("userInfo", a(aVar));
            lVar.put("req", aVar);
            byte[] r = b.r(lVar.uu());
            if (r != null) {
                return com.tencent.c.f.c.j(r, com.tencent.c.f.c.k());
            }
            throw new RuntimeException("compress data fail");
        } catch (Exception e) {
            return null;
        }
    }

    private com.tencent.c.c.a.c a(com.tencent.c.e.a.b.a aVar) {
        if (this.vhW == null) {
            this.vhW = new com.tencent.c.c.a.c();
            this.vhW.vii = 82;
            this.vhW.vin = this.vhU;
            this.vhW.vif = aVar.bVU;
            this.vhW.vie = aVar.vie;
            try {
                int i;
                int i2;
                int i3;
                String[] split = this.mVersionName.trim().split("[\\.]");
                if (split == null || split.length < 3) {
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                } else {
                    i3 = Integer.parseInt(split[0]);
                    i2 = Integer.parseInt(split[1]);
                    i = Integer.parseInt(split[2]);
                }
                this.vhW.vij = new com.tencent.c.c.a.b();
                this.vhW.vij.vib = i3;
                this.vhW.vij.vic = i2;
                this.vhW.vij.vid = i;
            } catch (Exception e) {
            }
            this.vhW.vik = 0;
            this.vhW.vim = d.cFv();
            this.vhW.imei = acn(aVar.imei);
            this.vhW.imsi = acn(aVar.imsi);
            this.vhW.vig = acn(Build.MODEL);
            this.vhW.nyk = acn(d.hv(this.mContext));
            this.vhW.vit = acn(d.mP(true));
            this.vhW.viu = acn(d.mP(false));
            this.vhW.vil = 0;
        }
        this.vhW.vih = getNetworkType();
        this.vhW.guid = acn(d.hx(this.mContext));
        return this.vhW;
    }

    private int getNetworkType() {
        try {
            return d.hw(this.mContext) == d.a.vkG ? 2 : 1;
        } catch (Throwable th) {
            return 2;
        }
    }

    private static String acn(String str) {
        return str == null ? "" : str;
    }
}
