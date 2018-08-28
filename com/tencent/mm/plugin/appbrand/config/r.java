package com.tencent.mm.plugin.appbrand.config;

import android.os.Looper;
import android.util.Pair;
import com.tencent.mm.ab.a.a;
import com.tencent.mm.ab.w;
import com.tencent.mm.bk.b;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.cgy;
import com.tencent.mm.protocal.c.cgz;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.i;
import java.util.Iterator;
import java.util.List;

public final class r {

    /* renamed from: com.tencent.mm.plugin.appbrand.config.r$2 */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ List frG;

        public AnonymousClass2(List list) {
            this.frG = list;
        }

        public final void run() {
            for (String R : this.frG) {
                r.R(R, true);
            }
        }
    }

    static boolean sb(String str) {
        if (e.aba() == null) {
            x.w("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, storage NULL");
            return false;
        }
        long VE = bi.VE();
        WxaAttributes e = e.aba().e(str, new String[]{"syncTimeSecond"});
        x.v("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, username(%s), currentMS(%d), lastUpdateTime(%d), freq(%d).", new Object[]{str, Long.valueOf(VE), Long.valueOf(e == null ? 0 : e.field_syncTimeSecond), Integer.valueOf(g.AT().getInt("MMBizAttrSyncFreq", 3600))});
        if (VE - (e == null ? 0 : e.field_syncTimeSecond) >= ((long) g.AT().getInt("MMBizAttrSyncFreq", 3600))) {
            return true;
        }
        return false;
    }

    private static boolean sc(String str) {
        if (bi.oW(str) || i.gr(str)) {
            return false;
        }
        x.e("MicroMsg.WxaAttrSyncHelper", "checkLogIfInvalidUsername %s, %s", new Object[]{str, aj.i(new Throwable())});
        f.mDy.a(648, 1, 1, false);
        return true;
    }

    static b sd(String str) {
        WxaAttributes e = e.aba().e(str, new String[]{"syncVersion"});
        return new b(e == null ? new byte[0] : bi.WP(bi.oV(e.field_syncVersion)));
    }

    public static void se(final String str) {
        if (!sc(str)) {
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    r.sf(str);
                }
            }, "WxaAttrSync");
        }
    }

    public static Pair<WxaAttributes, a> R(final String str, boolean z) {
        return a(str, z, new a<WxaAttributes>() {
            public final /* synthetic */ boolean bh(Object obj) {
                return bi.oW(((WxaAttributes) obj).field_versionInfo);
            }

            public final /* synthetic */ Object sh(String str) {
                return e.aba().f(str, new String[0]);
            }

            public final String getUsername() {
                return q.rY(str);
            }

            public final l sg(String str) {
                return new l(null, str);
            }
        });
    }

    static <T> Pair<T, a> a(String str, boolean z, a<T> aVar) {
        int i = -1;
        Object obj = null;
        if (bi.oW(str)) {
            return Pair.create(null, null);
        }
        Object obj2;
        if (z) {
            obj2 = null;
        } else {
            obj2 = aVar.sh(str);
            if (!(obj2 == null || aVar.bh(obj2))) {
                x.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, no need cgi sync, query record %s", new Object[]{Boolean.valueOf(z), obj2});
                return Pair.create(obj2, obj);
            }
        }
        a b = w.b(aVar.sg(str).diG);
        if (b == null || (b instanceof w.a) || b.errType != 0 || b.errCode != 0) {
            String str2 = "MicroMsg.WxaAttrSyncHelper";
            String str3 = "loadOrSync, ignoreLocal %b, errType = %d, errCode = %d, errMsg = %s";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(b == null ? -1 : b.errType);
            if (b != null) {
                i = b.errCode;
            }
            objArr[2] = Integer.valueOf(i);
            objArr[3] = b == null ? "null resp" : b.Yy;
            x.e(str2, str3, objArr);
            if (obj2 == null) {
                obj2 = aVar.sh(str);
                if (obj2 == null) {
                    return Pair.create(null, b);
                }
            }
            return Pair.create(obj2, b);
        }
        String str4;
        String str5;
        Iterator it = ((cgz) b.dIv).riC.iterator();
        while (it.hasNext()) {
            cgy cgy = (cgy) it.next();
            if ("UserName".equalsIgnoreCase(cgy.riD)) {
                str4 = cgy.mEl;
                if (!str4.endsWith("@app")) {
                    str4 = str4 + "@app";
                }
                if (bi.oW(str4)) {
                    str4 = aVar.getUsername();
                    if (bi.oW(str4)) {
                        x.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, key %s, cgi sync fail username invalid", new Object[]{Boolean.valueOf(z), str});
                        return Pair.create(null, null);
                    }
                }
                str5 = str4;
                if (e.aba().a(str5, ((cgz) b.dIv).riB, ((cgz) b.dIv).riC)) {
                    q.aei().b("single", 3, str5);
                }
                obj2 = aVar.sh(str);
                x.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, cgi sync result %s", new Object[]{Boolean.valueOf(z), obj2});
                obj = b;
                return Pair.create(obj2, obj);
            }
        }
        str4 = null;
        if (bi.oW(str4)) {
            str4 = aVar.getUsername();
            if (bi.oW(str4)) {
                x.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, key %s, cgi sync fail username invalid", new Object[]{Boolean.valueOf(z), str});
                return Pair.create(null, null);
            }
        }
        str5 = str4;
        if (e.aba().a(str5, ((cgz) b.dIv).riB, ((cgz) b.dIv).riC)) {
            q.aei().b("single", 3, str5);
        }
        obj2 = aVar.sh(str);
        x.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, cgi sync result %s", new Object[]{Boolean.valueOf(z), obj2});
        obj = b;
        return Pair.create(obj2, obj);
    }

    public static Pair<WxaAttributes, a> S(final String str, boolean z) {
        if (sc(str)) {
            return new Pair(null, null);
        }
        return a(str, z, new a<WxaAttributes>() {
            public final /* synthetic */ boolean bh(Object obj) {
                return bi.oW(((WxaAttributes) obj).field_versionInfo);
            }

            public final /* synthetic */ Object sh(String str) {
                return e.aba().e(str, new String[0]);
            }

            public final String getUsername() {
                return str;
            }

            public final l sg(String str) {
                return new l(str, null);
            }
        });
    }

    public static void a(String str, boolean z, b<WxaAttributes> bVar) {
        if (!sc(str)) {
            Looper looper;
            boolean z2;
            if (ah.isMainThread() || Looper.myLooper() == null) {
                looper = new ah().lnJ.getLooper();
                z2 = true;
            } else {
                looper = Looper.myLooper();
                z2 = false;
            }
            new ag(looper).post(new 5(str, z, bVar, z2));
        }
    }

    public static void sf(String str) {
        if (!sc(str) && sb(str)) {
            S(str, true);
        }
    }

    public static void a(List<String> list, k.a aVar) {
        int i = 0;
        if (!bi.cX(list)) {
            if (ah.isMainThread()) {
                c.Em().H(new 6(list));
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (!sb((String) it.next())) {
                    it.remove();
                }
            }
            if (!bi.cX(list)) {
                int i2;
                x.i("MicroMsg.WxaAttrSyncHelper", "batchSync, list_size %d, scene %s(%d)", new Object[]{Integer.valueOf(list.size()), aVar.name(), Integer.valueOf(aVar.ordinal())});
                int i3 = 0;
                while (true) {
                    i2 = i;
                    if (i3 >= list.size() / 20) {
                        break;
                    }
                    i2 = i3 * 20;
                    i = i2 + 20;
                    b(list.subList(i2, i), aVar);
                    i3++;
                }
                if (i2 < list.size()) {
                    b(list.subList(i2, list.size()), aVar);
                }
            }
        }
    }

    private static void b(List<String> list, k.a aVar) {
        if (!bi.cX(list)) {
            new k(list, aVar).KM().e(new 7());
        }
    }
}
