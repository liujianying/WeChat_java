package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.Map;

public final class a {
    public String bKg;
    public int bRt;
    public String desc;
    public long eiD;
    public long qzA;
    public int size;
    public String url;

    public static a cbF() {
        au.HU();
        String str = (String) c.DT().get(352273, "");
        if (bi.oW(str)) {
            return null;
        }
        a aVar = new a(str);
        if (aVar.isValid() && !aVar.bTJ()) {
            return aVar;
        }
        cbG();
        return null;
    }

    public a(String str) {
        Map z = bl.z(str, "msg");
        this.desc = (String) z.get(".msg.appmsg.des");
        this.bRt = bi.getInt((String) z.get(".msg.alphainfo.clientVersion"), 0);
        this.url = (String) z.get(".msg.alphainfo.url");
        this.size = bi.getInt((String) z.get(".msg.alphainfo.size"), 0);
        this.bKg = (String) z.get(".msg.alphainfo.md5");
        this.qzA = bi.getLong((String) z.get(".msg.alphainfo.maxAge"), 0);
        this.eiD = bi.getLong((String) z.get(".msg.alphainfo.expireTime"), 0);
        x.i("MicroMsg.AlphaUpdateInfo", "updateInfo, content:%s, clientVersion:%d, url:%s, size:%d, md5:%s, desc:%s, maxAge:%d, expireTime:%d", new Object[]{str, Integer.valueOf(this.bRt), this.url, Integer.valueOf(this.size), this.bKg, this.desc, Long.valueOf(this.qzA), Long.valueOf(this.eiD)});
    }

    private boolean isValid() {
        boolean z;
        if (this.bRt <= d.qVN || bi.oW(this.url) || bi.oW(this.bKg) || bi.oW(this.desc)) {
            z = false;
        } else {
            z = true;
        }
        x.i("MicroMsg.AlphaUpdateInfo", "isValid %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    private boolean bTJ() {
        boolean z;
        au.HU();
        if (System.currentTimeMillis() - ((Long) c.DT().get(352274, Long.valueOf(System.currentTimeMillis()))).longValue() > this.qzA || System.currentTimeMillis() > this.eiD) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.AlphaUpdateInfo", "isExpired: %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public static void cbG() {
        au.HU();
        c.DT().set(352273, null);
        au.HU();
        c.DT().set(352274, null);
    }

    public final void cbH() {
        bd bdVar = new bd();
        bdVar.ay(com.tencent.mm.model.bd.o("weixin", bi.VE()));
        bdVar.setType(1);
        bdVar.setContent(this.desc);
        x.d("MicroMsg.AlphaUpdateInfo", bdVar.field_content);
        bdVar.eX(0);
        bdVar.ep("weixin");
        bdVar.setStatus(3);
        com.tencent.mm.model.bd.i(bdVar);
        x.i("MicroMsg.AlphaUpdateInfo", "insertUpdateTextMsg");
        cbG();
    }

    public final void cbI() {
        x.i("MicroMsg.AlphaUpdateInfo", "downloadInSilence.");
        if (isValid() && !bTJ()) {
            int i;
            if (bi.WU(g.AT().getValue("SilentDownloadApkAtWiFi")) != 0) {
                i = 0;
            } else {
                au.HU();
                i = (!ao.isWifi(ad.getContext()) || ((((Integer) c.DT().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0 ? 1 : 0) == 0) ? 0 : 1;
                if ((e.bxm & 1) != 0) {
                    x.d("MicroMsg.AlphaUpdateInfo", "channel pack, not silence download.");
                    i = 0;
                } else {
                    x.d("MicroMsg.AlphaUpdateInfo", "not channel pack.");
                }
            }
            if (i == 0) {
                cbH();
                return;
            }
            x.i("MicroMsg.AlphaUpdateInfo", "go to download, %s, %d, %s, %s", new Object[]{this.bKg, Integer.valueOf(this.size), this.desc, this.url});
            com.tencent.mm.plugin.y.d.bfB().c(this.bKg, this.size, this.desc.replaceFirst("(\n)*<a.*</a>(\n)*", "\n"), this.url);
        }
    }
}
