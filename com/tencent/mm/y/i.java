package com.tencent.mm.y;

import android.content.Context;
import android.util.Base64;
import com.tencent.mm.aa.j;
import com.tencent.mm.aa.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public final class i {
    public static boolean gr(String str) {
        return str != null && str.endsWith("@app");
    }

    public static String gs(String str) {
        Map WA = ay.WA(str);
        if (WA == null) {
            l gt = gt(str);
            StringBuilder stringBuilder = new StringBuilder("");
            Iterator it = gt.dzs.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                if (!bi.oW(mVar.title)) {
                    stringBuilder.append(mVar.title);
                    break;
                }
            }
            return stringBuilder.toString();
        }
        String str2 = (String) WA.get(".msg.appmsg.mmreader.category.item.title");
        return str2 == null ? "" : str2;
    }

    public static l gt(String str) {
        try {
            return (l) new l().aG(Base64.decode(str, 0));
        } catch (Exception e) {
            try {
                return (l) new l().aG(bi.WP(str));
            } catch (Exception e2) {
                return new l();
            }
        }
    }

    public static String gR(int i) {
        if (i <= 0 || ((long) i) >= 86400) {
            return null;
        }
        String str;
        if (((long) i) < 3600) {
            str = "mm:ss";
        } else {
            str = "HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        return simpleDateFormat.format(Long.valueOf(((long) i) * 1000));
    }

    public static boolean gu(String str) {
        if (str == null) {
            return false;
        }
        l wS = ((a) g.l(a.class)).wS(str);
        if (wS == null) {
            x.w("MicroMsg.AppMsgBizHelper", "isBizMsgForbidForward reader is null");
            return false;
        } else if (wS.dzt == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static String a(Context context, int i, String str, String str2) {
        if (context == null) {
            x.w("MicroMsg.AppMsgBizHelper", "getReaderAppMsgContent: context is null");
            return null;
        } else if (str == null || str2 == null) {
            x.w("MicroMsg.AppMsgBizHelper", "getReaderAppMsgContent: msg is null");
            return null;
        } else {
            g.Ek();
            if (g.Ei().isSDCardAvailable()) {
                try {
                    l wS = ((a) g.l(a.class)).wS(str);
                    List list = wS.dzs;
                    if (list != null && list.size() > 0 && i < list.size()) {
                        m mVar = (m) list.get(i);
                        g.a aVar = new g.a();
                        aVar.title = mVar.title;
                        aVar.description = mVar.dzA;
                        aVar.action = "view";
                        aVar.type = 5;
                        aVar.url = mVar.url;
                        aVar.bZG = wS.bZG;
                        aVar.bZH = wS.bZH;
                        aVar.cGB = wS.cGB;
                        aVar.thumburl = mVar.dzy;
                        if (bi.oW(aVar.thumburl)) {
                            j kc = q.KH().kc(str2);
                            if (kc != null) {
                                aVar.thumburl = kc.Kx();
                            }
                        }
                        return g.a.a(aVar, null, null);
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppMsgBizHelper", e, "", new Object[0]);
                    x.e("MicroMsg.AppMsgBizHelper", "retransmit app msg error : %s", new Object[]{e.getLocalizedMessage()});
                }
                return null;
            }
            s.gH(context);
            return null;
        }
    }
}
