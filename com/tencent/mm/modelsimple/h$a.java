package com.tencent.mm.modelsimple;

import android.net.Uri;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.h.1;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.yo;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class h$a {
    static b a(a aVar) {
        a aVar2 = new a();
        aVar2.dIG = new yo();
        aVar2.dIH = new yp();
        switch (1.efc[aVar.ordinal()]) {
            case 1:
                aVar2.uri = "/cgi-bin/micromsg-bin/geta8key";
                aVar2.dIF = 233;
                aVar2.dII = 155;
                aVar2.dIJ = 1000000155;
                break;
            case 2:
                aVar2.uri = "/cgi-bin/micromsg-bin/mp-geta8key";
                aVar2.dIF = 238;
                aVar2.dII = 345;
                aVar2.dIJ = 1000000345;
                break;
            case 3:
                aVar2.uri = "/cgi-bin/micromsg-bin/pay-geta8key";
                aVar2.dIF = 835;
                aVar2.dII = 346;
                aVar2.dIJ = 1000000346;
                break;
            case 4:
                aVar2.uri = "/cgi-bin/micromsg-bin/minor-geta8key";
                aVar2.dIF = 812;
                aVar2.dII = 387;
                aVar2.dIJ = 1000000387;
                break;
            case 5:
                aVar2.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
                aVar2.dIF = 226;
                aVar2.dII = 388;
                aVar2.dIJ = 1000000388;
                break;
            default:
                aVar2.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
                aVar2.dIF = 226;
                aVar2.dII = 388;
                aVar2.dIJ = 1000000388;
                break;
        }
        return aVar2.KT();
    }

    static a R(String str, int i) {
        if (i == 5) {
            return a.efh;
        }
        if (bi.oW(str)) {
            x.i("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl reqUrl is null, getA8Key");
            return a.efe;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return a.efi;
            }
            String toLowerCase = bi.oV(parse.getHost()).toLowerCase();
            x.d("MicroMsg.NetSceneGetA8Key", "get TypeFromUrl domain:%s, fragment:%s", new Object[]{toLowerCase, bi.oW(parse.getFragment()) ? "" : "#" + parse.getFragment()});
            if (toLowerCase.equals("open.weixin.qq.com") || toLowerCase.equals("mp.weixin.qq.com") || toLowerCase.equals("mp.weixinbridge.com")) {
                return a.eff;
            }
            if (r0.contains("wechat_pay")) {
                return a.efg;
            }
            if (toLowerCase.contains(".qq.com") || toLowerCase.equals("qq.com") || toLowerCase.contains(".wechat.com") || toLowerCase.equals("wechat.com") || toLowerCase.contains(".tenpay.com") || toLowerCase.equals("tenpay.com") || toLowerCase.contains(".url.cn") || toLowerCase.equals("url.com") || (!str.startsWith("http://") && !str.startsWith("https://"))) {
                return a.efe;
            }
            return a.efi;
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl parse uri fail %s", new Object[]{e.getMessage()});
            return a.efe;
        }
    }

    static b c(b bVar) {
        yo yoVar = (yo) bVar.dID.dIL;
        g.Ek();
        String oV = bi.oV((String) g.Ei().DT().get(46, null));
        yoVar.reB = new bhy().bq(bi.WP(oV));
        g.Ek();
        String oV2 = bi.oV((String) g.Ei().DT().get(72, null));
        yoVar.rEu = new bhy().bq(bi.WP(oV2));
        x.d("MicroMsg.NetSceneGetA8Key", "dkwt get a2=" + oV + " newa2=" + oV2);
        return bVar;
    }
}
