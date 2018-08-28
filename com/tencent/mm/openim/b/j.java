package com.tencent.mm.openim.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.tencent.mm.a.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.o;
import com.tencent.mm.bp.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.openim.d.c;
import com.tencent.mm.protocal.c.ayc;
import com.tencent.mm.protocal.c.ayd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Iterator;

public final class j implements b {
    private HashMap<String, b> euy = new HashMap();

    public j() {
        e.cr(Vi());
        c cVar = new c();
        cVar.field_appid = "3552365301";
        cVar.field_language = w.fD(ad.getContext());
        g.Ek();
        ((PluginOpenIM) g.n(PluginOpenIM.class)).getAppIdInfoStg().b(cVar, new String[]{"appid", "language"});
        if (cVar.sKx == -1) {
            oG("3552365301");
        }
    }

    private static String Vi() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Ek();
        return stringBuilder.append(g.Ei().dqp).append("openim/").toString();
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == 453 && i == 0 && i2 == 0) {
            c cVar = (c) lVar;
            b bVar = (b) this.euy.get(cVar.eus + cVar.aem);
            if (bVar.euB.isEmpty()) {
                this.euy.remove(cVar.eus + cVar.aem);
                return;
            }
            while (bVar.euC.size() < 10 && !bVar.euB.isEmpty()) {
                bVar.euC.add(bVar.euB.removeFirst());
            }
            g.Eh().dpP.a(new c(cVar.eus, cVar.aem, bVar.euC), 0);
        }
    }

    public final SpannableString d(Context context, String str, int i) {
        return com.tencent.mm.pluginsdk.ui.d.j.a(context, (CharSequence) str, i);
    }

    public final CharSequence a(Context context, String str, String str2, float f) {
        Bitmap oC = oC(str);
        if (oC == null) {
            return str2;
        }
        CharSequence a = com.tencent.mm.pluginsdk.ui.d.j.a(context, "  " + str2, f);
        int fromDPToPix = (int) (((float) a.fromDPToPix(context, 2)) + f);
        ImageSpan imageSpan = new ImageSpan(ad.getContext(), oC);
        imageSpan.getDrawable().setBounds(0, 0, fromDPToPix, fromDPToPix);
        a.setSpan(imageSpan, 0, 1, 33);
        return a;
    }

    public final Bitmap oC(String str) {
        a aVar = new a(this, (byte) 0);
        if (bi.oW(str)) {
            return null;
        }
        com.tencent.mm.ak.a.a.c.a aVar2 = new com.tencent.mm.ak.a.a.c.a();
        aVar2.dXy = true;
        aVar2.dXA = Vi() + com.tencent.mm.a.g.u(str.getBytes());
        o.Pj().a(str, null, aVar2.Pt(), new 1(this, aVar));
        return aVar.bitmap;
    }

    public final int oD(String str) {
        c cVar = new c();
        cVar.field_appid = str;
        g.Ek();
        ((PluginOpenIM) g.n(PluginOpenIM.class)).getAppIdInfoStg().b(cVar, new String[]{"appid"});
        if (cVar.sKx != -1) {
            return cVar.field_appRec.rde;
        }
        oG(str);
        return 0;
    }

    public final String g(String str, String str2, int i) {
        c cVar = new c();
        cVar.field_appid = str;
        g.Ek();
        ((PluginOpenIM) g.n(PluginOpenIM.class)).getAppIdInfoStg().b(cVar, new String[]{"appid"});
        if (cVar.sKx == -1) {
            oG(str);
            return null;
        }
        String c = c(cVar.field_acctTypeId, str2, i, w.fD(ad.getContext()));
        if (c == null) {
            return c(cVar.field_acctTypeId, str2, i, "en");
        }
        return c;
    }

    public final String h(String str, String str2, int i) {
        String c = c(str, str2, i, w.fD(ad.getContext()));
        if (c == null) {
            return c(str, str2, i, "en");
        }
        return c;
    }

    private static String c(String str, String str2, int i, String str3) {
        com.tencent.mm.openim.d.a aVar = new com.tencent.mm.openim.d.a();
        aVar.field_acctTypeId = str;
        aVar.field_language = str3;
        g.Ek();
        ((PluginOpenIM) g.n(PluginOpenIM.class)).getAccTypeInfoStg().b(aVar, new String[]{"acctTypeId", "language"});
        if (aVar.sKx == -1) {
            return null;
        }
        Iterator it;
        if (i == b.a.eui) {
            it = aVar.field_accTypeRec.raK.iterator();
            while (it.hasNext()) {
                ayd ayd = (ayd) it.next();
                if (str2.equals(ayd.aAL)) {
                    return ayd.bSc;
                }
            }
            return null;
        }
        it = aVar.field_accTypeRec.raL.iterator();
        while (it.hasNext()) {
            ayc ayc = (ayc) it.next();
            if (str2.equals(ayc.aAL)) {
                return ayc.url;
            }
        }
        return null;
    }

    public final String i(String str, String str2, int i) {
        String d = d(str, str2, i, w.fD(ad.getContext()));
        if (d == null) {
            return d(str, str2, i, "en");
        }
        return d;
    }

    private String d(String str, String str2, int i, String str3) {
        c cVar = new c();
        cVar.field_appid = str;
        cVar.field_language = str3;
        g.Ek();
        ((PluginOpenIM) g.n(PluginOpenIM.class)).getAppIdInfoStg().b(cVar, new String[]{"appid", "language"});
        Iterator it;
        if (cVar.sKx == -1) {
            aF(str, str3);
            return null;
        } else if (i == b.a.eui) {
            it = cVar.field_appRec.raK.iterator();
            while (it.hasNext()) {
                ayd ayd = (ayd) it.next();
                if (str2.equals(ayd.aAL)) {
                    return ayd.bSc;
                }
            }
            return null;
        } else {
            it = cVar.field_appRec.raL.iterator();
            while (it.hasNext()) {
                ayc ayc = (ayc) it.next();
                if (str2.equals(ayc.aAL)) {
                    return ayc.url;
                }
            }
            return null;
        }
    }

    public final String aE(String str, String str2) {
        String t = t(str, str2, w.fD(ad.getContext()));
        if (t == null) {
            return t(str, str2, "en");
        }
        return t;
    }

    private String t(String str, String str2, String str3) {
        com.tencent.mm.openim.d.e eVar = new com.tencent.mm.openim.d.e();
        eVar.field_appid = str;
        eVar.field_language = str3;
        eVar.field_wordingId = str2;
        g.Ek();
        ((PluginOpenIM) g.n(PluginOpenIM.class)).getWordingInfoStg().b(eVar, new String[]{"appid", "language", "wordingId"});
        if (eVar.sKx != -1) {
            return eVar.field_wording;
        }
        u(str, str3, str2);
        return null;
    }

    private void oG(String str) {
        aF(str, w.fD(ad.getContext()));
    }

    private void aF(String str, String str2) {
        u(str, str2, "");
    }

    private void u(String str, String str2, String str3) {
        if (!bi.oW(str)) {
            b bVar;
            if (!this.euy.containsKey(str + str2)) {
                bVar = new b(this, (byte) 0);
                if (!bi.oW(str3)) {
                    bVar.euC.add(str3);
                }
                this.euy.put(str + str2, bVar);
                g.Eh().dpP.a(new c(str, str2, bVar.euC), 0);
            }
            if (!bi.oW(str3)) {
                bVar = (b) this.euy.get(str + str2);
                if (!bVar.euB.contains(str3) && !bVar.euC.contains(str3)) {
                    bVar.euB.add(str3);
                }
            }
        }
    }

    public final void aD(String str, String str2) {
        Object obj;
        Object obj2 = null;
        c cVar = new c();
        cVar.field_appid = str;
        cVar.field_language = w.fD(ad.getContext());
        g.Ek();
        ((PluginOpenIM) g.n(PluginOpenIM.class)).getAppIdInfoStg().b(cVar, new String[]{"appid", "language"});
        if (cVar.sKx == -1 || bi.bG(cVar.field_updateTime) > 172800) {
            obj2 = 1;
        }
        if (obj2 == null && !bi.oW(str2)) {
            com.tencent.mm.openim.d.e eVar = new com.tencent.mm.openim.d.e();
            eVar.field_appid = str;
            eVar.field_language = w.fD(ad.getContext());
            eVar.field_wordingId = str2;
            g.Ek();
            ((PluginOpenIM) g.n(PluginOpenIM.class)).getWordingInfoStg().b(eVar, new String[]{"appid", "language", "wordingId"});
            if (eVar.sKx == -1 || bi.bG(cVar.field_updateTime) > 172800) {
                obj = 1;
                if (obj != null) {
                    u(str, w.fD(ad.getContext()), str2);
                }
            }
        }
        obj = obj2;
        if (obj != null) {
            u(str, w.fD(ad.getContext()), str2);
        }
    }
}
