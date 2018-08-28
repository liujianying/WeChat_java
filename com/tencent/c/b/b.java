package com.tencent.c.b;

import android.content.Context;
import android.os.Build;
import com.tencent.c.c.a.a;
import com.tencent.c.c.a.c;
import com.tencent.c.f.d;
import com.tencent.c.f.l;

public final class b {
    private String mChannelId = null;
    private Context mContext = null;
    private String mVersionName = null;
    private int vhT = -1;
    private int vhU = -1;
    private String vhV = null;
    private c vhW = null;
    private a vhX = null;

    public b(Context context) {
        this.mContext = context;
        com.tencent.c.a.a bK = com.tencent.c.f.a.bK(context, context.getPackageName());
        this.mVersionName = bK.versionName;
        this.vhU = bK.versionCode;
        this.vhT = 82;
        this.mChannelId = "105901";
        this.vhV = "7AD75E27CD5842F6";
    }

    public final byte[] a(com.tencent.c.c.b.a aVar) {
        try {
            l lVar = new l();
            lVar.cFy();
            lVar.acw("viruscheck");
            lVar.acx("RiskCheck");
            lVar.acv("UTF-8");
            String str = "phonetype";
            if (this.vhX == null) {
                this.vhX = new a();
                this.vhX.vhY = 2;
                this.vhX.vhZ = 201;
            }
            lVar.put(str, this.vhX);
            lVar.put("userinfo", cFd());
            lVar.put("req", aVar);
            byte[] r = com.tencent.c.f.b.r(lVar.uu());
            if (r != null) {
                return com.tencent.c.f.c.j(r, com.tencent.c.f.c.k());
            }
            throw new RuntimeException("compress data fail");
        } catch (Exception e) {
            return null;
        }
    }

    private c cFd() {
        int i = 2;
        if (this.vhW == null) {
            this.vhW = new c();
            this.vhW.vii = this.vhT;
            this.vhW.vin = this.vhU;
            this.vhW.vif = this.mChannelId;
            this.vhW.vie = this.vhV;
            try {
                int i2;
                int i3;
                int i4;
                String[] split = this.mVersionName.trim().split("[\\.]");
                if (split == null || split.length < 3) {
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                } else {
                    i4 = Integer.parseInt(split[0]);
                    i3 = Integer.parseInt(split[1]);
                    i2 = Integer.parseInt(split[2]);
                }
                this.vhW.vij = new com.tencent.c.c.a.b();
                this.vhW.vij.vib = i4;
                this.vhW.vij.vic = i3;
                this.vhW.vij.vid = i2;
            } catch (Exception e) {
            }
            this.vhW.vik = 0;
            this.vhW.vim = d.cFv();
            this.vhW.imei = acn(d.ht(this.mContext));
            this.vhW.imsi = acn(d.hu(this.mContext));
            this.vhW.vig = acn(Build.MODEL);
            this.vhW.nyk = acn(d.hv(this.mContext));
            this.vhW.vit = acn(d.mP(true));
            this.vhW.viu = acn(d.mP(false));
            this.vhW.guid = null;
            this.vhW.vil = 0;
        }
        c cVar = this.vhW;
        if (d.hw(this.mContext) != d.a.vkG) {
            i = 1;
        }
        cVar.vih = i;
        return this.vhW;
    }

    private static String acn(String str) {
        return str == null ? "" : str;
    }
}
