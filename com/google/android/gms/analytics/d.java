package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.analytics.a.a;
import com.google.android.gms.analytics.a.b;
import com.google.android.gms.analytics.a.c;
import com.google.android.gms.analytics.internal.k;
import com.google.android.gms.analytics.internal.n;
import com.google.android.gms.analytics.internal.p;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.analytics.internal.s;
import com.google.android.gms.c.ae;
import com.google.android.gms.c.ai;
import com.google.android.gms.c.aj;
import com.google.android.gms.c.ak;
import com.google.android.gms.c.al;
import com.google.android.gms.c.am;
import com.google.android.gms.c.an;
import com.google.android.gms.c.ao;
import com.google.android.gms.c.ap;
import com.google.android.gms.c.aq;
import com.google.android.gms.c.ar;
import com.google.android.gms.c.e;
import com.google.android.gms.c.f;
import com.google.android.gms.c.g;
import com.google.android.gms.c.h;
import com.google.android.gms.common.internal.w;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class d extends n implements ai {
    private static DecimalFormat aIn;
    private final q aHe;
    private final String aIo;
    private final Uri aIp;
    private final boolean aIq;
    private final boolean aIr;

    public d(q qVar, String str) {
        this(qVar, str, (byte) 0);
    }

    private d(q qVar, String str, byte b) {
        super(qVar);
        w.bg(str);
        this.aHe = qVar;
        this.aIo = str;
        this.aIq = true;
        this.aIr = false;
        this.aIp = ba(this.aIo);
    }

    private static void a(Map<String, String> map, String str, double d) {
        if (d != 0.0d) {
            map.put(str, n(d));
        }
    }

    private static void a(Map<String, String> map, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            map.put(str, i + "x" + i2);
        }
    }

    private static void a(Map<String, String> map, String str, boolean z) {
        if (z) {
            map.put(str, "1");
        }
    }

    private static void b(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    public static Uri ba(String str) {
        w.bg(str);
        Builder builder = new Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    private static Map<String, String> c(ae aeVar) {
        CharSequence l;
        Map hashMap = new HashMap();
        g gVar = (g) aeVar.d(g.class);
        if (gVar != null) {
            for (Entry entry : Collections.unmodifiableMap(gVar.aFa).entrySet()) {
                Object obj;
                Boolean value = entry.getValue();
                if (value == null) {
                    obj = null;
                } else if (value instanceof String) {
                    String obj2 = (String) value;
                    if (TextUtils.isEmpty(obj2)) {
                        obj2 = null;
                    }
                } else if (value instanceof Double) {
                    Double d = (Double) value;
                    obj2 = d.doubleValue() != 0.0d ? n(d.doubleValue()) : null;
                } else {
                    obj2 = value instanceof Boolean ? value != Boolean.FALSE ? "1" : null : String.valueOf(value);
                }
                if (obj2 != null) {
                    hashMap.put(entry.getKey(), obj2);
                }
            }
        }
        h hVar = (h) aeVar.d(h.class);
        if (hVar != null) {
            b(hashMap, "t", hVar.aWn);
            b(hashMap, "cid", hVar.aGl);
            b(hashMap, "uid", hVar.aWo);
            b(hashMap, "sc", hVar.aWr);
            a(hashMap, "sf", hVar.aWt);
            a(hashMap, "ni", hVar.aWs);
            b(hashMap, "adid", hVar.aWp);
            a(hashMap, "ate", hVar.aWq);
        }
        ap apVar = (ap) aeVar.d(ap.class);
        if (apVar != null) {
            b(hashMap, "cd", apVar.aYS);
            a(hashMap, "a", (double) apVar.aYT);
            b(hashMap, "dr", apVar.aYW);
        }
        an anVar = (an) aeVar.d(an.class);
        if (anVar != null) {
            b(hashMap, "ec", anVar.pM);
            b(hashMap, "ea", anVar.aOA);
            b(hashMap, "el", anVar.aYO);
            a(hashMap, "ev", (double) anVar.aYP);
        }
        ak akVar = (ak) aeVar.d(ak.class);
        if (akVar != null) {
            b(hashMap, "cn", akVar.mName);
            b(hashMap, "cs", akVar.aYw);
            b(hashMap, "cm", akVar.aYx);
            b(hashMap, "ck", akVar.aYy);
            b(hashMap, "cc", akVar.aYz);
            b(hashMap, "ci", akVar.aEN);
            b(hashMap, "anid", akVar.aYA);
            b(hashMap, "gclid", akVar.aYB);
            b(hashMap, "dclid", akVar.aYC);
            b(hashMap, "aclid", akVar.aYD);
        }
        ao aoVar = (ao) aeVar.d(ao.class);
        if (aoVar != null) {
            b(hashMap, "exd", aoVar.aYQ);
            a(hashMap, "exf", aoVar.aYR);
        }
        aq aqVar = (aq) aeVar.d(aq.class);
        if (aqVar != null) {
            b(hashMap, "sn", aqVar.aZa);
            b(hashMap, "sa", aqVar.aOA);
            b(hashMap, "st", aqVar.aZb);
        }
        ar arVar = (ar) aeVar.d(ar.class);
        if (arVar != null) {
            b(hashMap, "utv", arVar.aZc);
            a(hashMap, "utt", (double) arVar.aZd);
            b(hashMap, "utc", arVar.pM);
            b(hashMap, "utl", arVar.aYO);
        }
        e eVar = (e) aeVar.d(e.class);
        if (eVar != null) {
            for (Entry entry2 : Collections.unmodifiableMap(eVar.aWl).entrySet()) {
                l = e.l("cd", ((Integer) entry2.getKey()).intValue());
                if (!TextUtils.isEmpty(l)) {
                    hashMap.put(l, entry2.getValue());
                }
            }
        }
        f fVar = (f) aeVar.d(f.class);
        if (fVar != null) {
            for (Entry entry22 : Collections.unmodifiableMap(fVar.aWm).entrySet()) {
                l = e.l("cm", ((Integer) entry22.getKey()).intValue());
                if (!TextUtils.isEmpty(l)) {
                    hashMap.put(l, n(((Double) entry22.getValue()).doubleValue()));
                }
            }
        }
        am amVar = (am) aeVar.d(am.class);
        if (amVar != null) {
            b bVar = amVar.aYN;
            if (bVar != null) {
                for (Entry entry3 : new HashMap(bVar.aEM).entrySet()) {
                    if (((String) entry3.getKey()).startsWith("&")) {
                        hashMap.put(((String) entry3.getKey()).substring(1), entry3.getValue());
                    } else {
                        hashMap.put(entry3.getKey(), entry3.getValue());
                    }
                }
            }
            int i = 1;
            for (c aH : Collections.unmodifiableList(amVar.aYL)) {
                hashMap.putAll(aH.aH(e.l("promo", i)));
                i++;
            }
            i = 1;
            for (a aH2 : Collections.unmodifiableList(amVar.aYK)) {
                hashMap.putAll(aH2.aH(e.l("pr", i)));
                i++;
            }
            int i2 = 1;
            for (Entry entry32 : amVar.aYM.entrySet()) {
                List<a> list = (List) entry32.getValue();
                String l2 = e.l("il", i2);
                i = 1;
                for (a aH3 : list) {
                    hashMap.putAll(aH3.aH(l2 + e.l("pi", i)));
                    i++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry32.getKey())) {
                    hashMap.put(l2 + "nm", entry32.getKey());
                }
                i2++;
            }
        }
        al alVar = (al) aeVar.d(al.class);
        if (alVar != null) {
            b(hashMap, "ul", alVar.aYE);
            a(hashMap, "sd", (double) alVar.aYF);
            a(hashMap, "sr", alVar.aYG, alVar.aYH);
            a(hashMap, "vp", alVar.aYI, alVar.aYJ);
        }
        aj ajVar = (aj) aeVar.d(aj.class);
        if (ajVar != null) {
            b(hashMap, "an", ajVar.aEV);
            b(hashMap, "aid", ajVar.aYu);
            b(hashMap, "aiid", ajVar.aYv);
            b(hashMap, "av", ajVar.aEW);
        }
        return hashMap;
    }

    private static String n(double d) {
        if (aIn == null) {
            aIn = new DecimalFormat("0.######");
        }
        return aIn.format(d);
    }

    public final void b(ae aeVar) {
        w.ah(aeVar);
        w.e(aeVar.aXZ, "Can't deliver not submitted measurement");
        w.bi("deliver should be called on worker thread");
        ae ql = aeVar.ql();
        h hVar = (h) ql.e(h.class);
        if (TextUtils.isEmpty(hVar.aWn)) {
            this.aFn.nr().b(c(ql), "Ignoring measurement without type");
        } else if (TextUtils.isEmpty(hVar.aGl)) {
            this.aFn.nr().b(c(ql), "Ignoring measurement without client id");
        } else if (!this.aHe.nu().aEL) {
            double d = hVar.aWt;
            if (k.b(d, hVar.aGl)) {
                e("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(d));
                return;
            }
            Map c = c(ql);
            c.put("v", "1");
            c.put("_v", p.aFS);
            c.put("tid", this.aIo);
            if (this.aHe.nu().aEK) {
                StringBuilder stringBuilder = new StringBuilder();
                for (Entry entry : c.entrySet()) {
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append((String) entry.getKey());
                    stringBuilder.append("=");
                    stringBuilder.append((String) entry.getValue());
                }
                a(4, "Dry run is enabled. GoogleAnalytics would have sent", stringBuilder.toString(), null, null);
                return;
            }
            Map hashMap = new HashMap();
            k.a(hashMap, "uid", hVar.aWo);
            aj ajVar = (aj) aeVar.d(aj.class);
            if (ajVar != null) {
                k.a(hashMap, "an", ajVar.aEV);
                k.a(hashMap, "aid", ajVar.aYu);
                k.a(hashMap, "av", ajVar.aEW);
                k.a(hashMap, "aiid", ajVar.aYv);
            }
            c.put("_s", String.valueOf(this.aFn.nt().a(new s(hVar.aGl, this.aIo, !TextUtils.isEmpty(hVar.aWp), 0, hashMap))));
            this.aFn.nt().c(new com.google.android.gms.analytics.internal.c(this.aFn.nr(), c, aeVar.aYa));
        }
    }

    public final Uri ok() {
        return this.aIp;
    }
}
