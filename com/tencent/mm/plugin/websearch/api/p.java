package com.tencent.mm.plugin.websearch.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mm.a.e;
import com.tencent.mm.a.o;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import org.json.JSONObject;

public final class p {
    private static Map<Integer, ae> pLp = new HashMap();
    private static Map<Integer, g> pLq = new HashMap();

    public static Properties A(File file) {
        Throwable e;
        Properties properties = new Properties();
        if (file != null && file.isFile()) {
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    e.f(fileInputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e, "", new Object[0]);
                        e.f(fileInputStream);
                        return properties;
                    } catch (Throwable th) {
                        e = th;
                        e.f(fileInputStream);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
                x.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e, "", new Object[0]);
                e.f(fileInputStream);
                return properties;
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                e.f(fileInputStream);
                throw e;
            }
        }
        return properties;
    }

    public static final String zK(int i) {
        StringBuilder append = new StringBuilder().append(i).append("_");
        g.Eg();
        return append.append(o.getString(a.Df())).append("_").append(System.currentTimeMillis()).toString();
    }

    static {
        pLp.put(Integer.valueOf(1), new ae("fts_browse/res", "wrd_template.zip", "browse"));
        pLp.put(Integer.valueOf(0), new ae("fts/res", "fts_template.zip", ""));
        Map map = pLq;
        Integer valueOf = Integer.valueOf(0);
        zM(0);
        map.put(valueOf, v.bTa());
        map = pLq;
        valueOf = Integer.valueOf(1);
        zM(1);
        map.put(valueOf, v.bTa());
    }

    public static ae zL(int i) {
        return (ae) pLp.get(Integer.valueOf(i));
    }

    private static String zM(int i) {
        return ((ae) pLp.get(Integer.valueOf(i))).adP() + File.separator + "app.html";
    }

    public static String bSL() {
        pLp.get(Integer.valueOf(1));
        return "app.html";
    }

    public static String bSM() {
        pLp.get(Integer.valueOf(1));
        return "config.conf";
    }

    public static void bSN() {
        Iterator it = pLq.values().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public static int zN(int i) {
        ae aeVar = (ae) pLp.get(Integer.valueOf(i));
        String str = TextUtils.isEmpty(aeVar.pMx) ? "config.conf" : aeVar.pMx + File.separator + "config.conf";
        AssetManager assets = ad.getContext().getAssets();
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = assets.open(str);
            properties.load(inputStream);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e, e.getMessage(), new Object[0]);
        } finally {
            e.f(inputStream);
        }
        return Integer.valueOf(properties.getProperty("version", "1")).intValue();
    }

    public static boolean zO(int i) {
        x.i("MicroMsg.WebSearch.WebSearchApiLogic", "isFTSH5TemplateAvail exportType:%d, use search default.", new Object[]{Integer.valueOf(i)});
        return ((ae) pLp.get(Integer.valueOf(i))).Oe() > 1;
    }

    public static int zP(int i) {
        return ((ae) pLp.get(Integer.valueOf(i))).Oe();
    }

    public static boolean zQ(int i) {
        OutputStream outputStream = null;
        AssetManager assets = ad.getContext().getAssets();
        String bTp = ((ae) pLp.get(Integer.valueOf(i))).bTp();
        ae aeVar = (ae) pLp.get(Integer.valueOf(i));
        String str = TextUtils.isEmpty(aeVar.pMx) ? aeVar.pMw : aeVar.pMx + File.separator + aeVar.pMw;
        if (bi.oW(bTp) || bi.oW(str)) {
            x.w("MicroMsg.WebSearch.WebSearchApiLogic", "copyTemplateFromAsset no dstPath or template path!");
            return false;
        }
        InputStream open;
        try {
            open = assets.open(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e, "", new Object[0]);
            open = null;
        }
        if (open == null) {
            x.e("MicroMsg.WebSearch.WebSearchApiLogic", "file inputStream not found");
            return false;
        }
        File file = new File(bTp);
        if (file.exists()) {
            file.delete();
        }
        file.getParentFile().mkdirs();
        try {
            outputStream = new FileOutputStream(file);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e2, "", new Object[0]);
        }
        if (outputStream != null) {
            try {
                e(open, outputStream);
                return true;
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e22, "", new Object[0]);
                return false;
            } finally {
                e.f(open);
                e.closeOutputStream(outputStream);
            }
        } else {
            e.f(open);
            return false;
        }
    }

    private static void e(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static String zR(int i) {
        return ((ae) pLp.get(Integer.valueOf(i))).bTp();
    }

    public static int zS(int i) {
        return ((ae) pLp.get(Integer.valueOf(i))).bTn();
    }

    public static String zT(int i) {
        return ((ae) pLp.get(Integer.valueOf(i))).adP();
    }

    public static String zU(int i) {
        return ((ae) pLp.get(Integer.valueOf(zX(i)))).adP();
    }

    public static String zV(int i) {
        return ((ae) pLp.get(Integer.valueOf(zX(i)))).pMw;
    }

    public static int zW(int i) {
        return ((ae) pLp.get(Integer.valueOf(zX(i)))).Oe();
    }

    private static int zX(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 1;
            default:
                return -1;
        }
    }

    public static String zY(int i) {
        return A(new File(((ae) pLp.get(Integer.valueOf(i))).adP(), "config_data.conf")).getProperty("kv_set", "");
    }

    public static String bjC() {
        if (ao.isWifi(ad.getContext())) {
            return TencentExtraKeys.LOCATION_SOURCE_WIFI;
        }
        if (ao.is4G(ad.getContext())) {
            return "4g";
        }
        if (ao.is3G(ad.getContext())) {
            return "3g";
        }
        if (ao.is2G(ad.getContext())) {
            return "2g";
        }
        if (ao.isConnected(ad.getContext())) {
            return "";
        }
        return "fail";
    }

    public static aqs JU() {
        try {
            String str = (String) g.Ei().DT().get(67591, null);
            if (str != null) {
                aqs aqs = new aqs();
                String[] split = str.split(",");
                aqs.ryV = Integer.valueOf(split[0]).intValue();
                aqs.ryY = Integer.valueOf(split[1]).intValue();
                aqs.rms = ((float) Integer.valueOf(split[2]).intValue()) / 1000000.0f;
                aqs.rmr = ((float) Integer.valueOf(split[3]).intValue()) / 1000000.0f;
                x.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is not null, %f, %f", new Object[]{Float.valueOf(aqs.rms), Float.valueOf(aqs.rmr)});
                return aqs;
            }
            x.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, lbsContent is null!");
            return null;
        } catch (Exception e) {
            x.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, reason %s", new Object[]{e.getMessage()});
            return null;
        }
    }

    private static Intent ag(Intent intent) {
        if (intent == null) {
            return null;
        }
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
        intent.putExtra("neverGetA8Key", true);
        return intent;
    }

    public static Intent adR() {
        return ag(new Intent());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> a(int r10, boolean r11, int r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
        r4 = new java.util.HashMap;
        r4.<init>();
        r1 = android.text.TextUtils.isEmpty(r14);
        if (r1 != 0) goto L_0x0011;
    L_0x000b:
        r1 = "searchId";
        r4.put(r1, r14);
    L_0x0011:
        r1 = android.text.TextUtils.isEmpty(r15);
        if (r1 != 0) goto L_0x001d;
    L_0x0017:
        r1 = "sessionId";
        r4.put(r1, r15);
    L_0x001d:
        r1 = android.text.TextUtils.isEmpty(r18);
        if (r1 != 0) goto L_0x002b;
    L_0x0023:
        r1 = "subSessionId";
        r0 = r18;
        r4.put(r1, r0);
    L_0x002b:
        r1 = android.text.TextUtils.isEmpty(r16);
        if (r1 != 0) goto L_0x0039;
    L_0x0031:
        r1 = "query";
        r0 = r16;
        r4.put(r1, r0);
    L_0x0039:
        r1 = android.text.TextUtils.isEmpty(r17);
        if (r1 != 0) goto L_0x0047;
    L_0x003f:
        r1 = "sceneActionType";
        r0 = r17;
        r4.put(r1, r0);
    L_0x0047:
        r1 = android.text.TextUtils.isEmpty(r20);
        if (r1 != 0) goto L_0x0055;
    L_0x004d:
        r1 = "pRequestId";
        r0 = r20;
        r4.put(r1, r0);
    L_0x0055:
        r1 = "scene";
        r2 = java.lang.String.valueOf(r10);
        r4.put(r1, r2);
        r1 = "type";
        r2 = java.lang.String.valueOf(r12);
        r4.put(r1, r2);
        r1 = "lang";
        r2 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r2 = com.tencent.mm.sdk.platformtools.w.fD(r2);
        r4.put(r1, r2);
        r1 = "platform";
        r2 = "android";
        r4.put(r1, r2);
        r1 = android.text.TextUtils.isEmpty(r19);
        if (r1 != 0) goto L_0x008e;
    L_0x0086:
        r1 = "poiInfo";
        r0 = r19;
        r4.put(r1, r0);
    L_0x008e:
        r1 = android.text.TextUtils.isEmpty(r13);
        if (r1 != 0) goto L_0x009a;
    L_0x0094:
        r1 = "extParams";
        r4.put(r1, r13);
    L_0x009a:
        switch(r10) {
            case 21: goto L_0x0178;
            default: goto L_0x009d;
        };
    L_0x009d:
        r1 = 0;
        r1 = zP(r1);
        r1 = java.lang.String.valueOf(r1);
    L_0x00a6:
        r2 = "version";
        r4.put(r2, r1);
        r1 = 0;
        r3 = 0;
        r2 = 0;
        switch(r10) {
            case 3: goto L_0x01f1;
            case 6: goto L_0x02cc;
            case 9: goto L_0x02cc;
            case 11: goto L_0x02df;
            case 14: goto L_0x01f1;
            case 20: goto L_0x01f1;
            case 22: goto L_0x01f1;
            case 24: goto L_0x02f2;
            case 33: goto L_0x0197;
            case 300: goto L_0x0183;
            default: goto L_0x00b2;
        };
    L_0x00b2:
        r5 = "MicroMsg.WebSearch.WebSearchApiLogic";
        r6 = "genFTSParams scene=%d isHomePage=%b type=%d %b %b %b";
        r7 = 6;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = java.lang.Integer.valueOf(r10);
        r7[r8] = r9;
        r8 = 1;
        r9 = java.lang.Boolean.valueOf(r11);
        r7[r8] = r9;
        r8 = 2;
        r9 = java.lang.Integer.valueOf(r12);
        r7[r8] = r9;
        r8 = 3;
        r9 = java.lang.Boolean.valueOf(r1);
        r7[r8] = r9;
        r8 = 4;
        r9 = java.lang.Boolean.valueOf(r3);
        r7[r8] = r9;
        r8 = 5;
        r9 = java.lang.Boolean.valueOf(r2);
        r7[r8] = r9;
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);
        if (r1 == 0) goto L_0x00f3;
    L_0x00ea:
        r1 = "isSug";
        r5 = "1";
        r4.put(r1, r5);
    L_0x00f3:
        if (r3 == 0) goto L_0x00fe;
    L_0x00f5:
        r1 = "isLocalSug";
        r3 = "1";
        r4.put(r1, r3);
    L_0x00fe:
        if (r2 == 0) goto L_0x0109;
    L_0x0100:
        r1 = "isMostSearchBiz";
        r2 = "1";
        r4.put(r1, r2);
    L_0x0109:
        if (r11 != 0) goto L_0x030b;
    L_0x010b:
        r1 = "isHomePage";
        r2 = "0";
        r4.put(r1, r2);
    L_0x0114:
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.bp.a.fe(r1);
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x014f;
    L_0x0122:
        r2 = 1063256064; // 0x3f600000 float:0.875 double:5.25318294E-315;
        r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x014f;
    L_0x0128:
        r2 = 1066401792; // 0x3f900000 float:1.125 double:5.2687249E-315;
        r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x014f;
    L_0x012e:
        r2 = 1067450368; // 0x3fa00000 float:1.25 double:5.273905555E-315;
        r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x014f;
    L_0x0134:
        r2 = 1068498944; // 0x3fb00000 float:1.375 double:5.27908621E-315;
        r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x014f;
    L_0x013a:
        r2 = 1070596096; // 0x3fd00000 float:1.625 double:5.289447516E-315;
        r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x014f;
    L_0x0140:
        r2 = 1072693248; // 0x3ff00000 float:1.875 double:5.299808824E-315;
        r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x014f;
    L_0x0146:
        r2 = 1073846682; // 0x4001999a float:2.025 double:5.305507545E-315;
        r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x014f;
    L_0x014d:
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
    L_0x014f:
        r2 = "fontRatio";
        r1 = java.lang.String.valueOf(r1);
        r4.put(r2, r1);
        r1 = "netType";
        r2 = bjC();
        r4.put(r1, r2);
        r1 = com.tencent.mm.an.b.PY();
        if (r1 == 0) goto L_0x0177;
    L_0x0169:
        r1 = com.tencent.mm.an.b.Qa();
        if (r1 == 0) goto L_0x0177;
    L_0x016f:
        r2 = "musicSnsId";
        r1 = r1.rsp;
        r4.put(r2, r1);
    L_0x0177:
        return r4;
    L_0x0178:
        r1 = 1;
        r1 = zP(r1);
        r1 = java.lang.String.valueOf(r1);
        goto L_0x00a6;
    L_0x0183:
        r5 = "mixGlobal";
        r5 = com.tencent.mm.plugin.websearch.api.r.PX(r5);
        if (r11 == 0) goto L_0x019a;
    L_0x018c:
        r6 = "mixSugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x00b2;
    L_0x0197:
        r1 = 1;
        goto L_0x00b2;
    L_0x019a:
        r6 = 1;
        if (r12 != r6) goto L_0x01a9;
    L_0x019d:
        r6 = "bizSugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x00b2;
    L_0x01a8:
        goto L_0x0197;
    L_0x01a9:
        r6 = 8;
        if (r12 != r6) goto L_0x01b9;
    L_0x01ad:
        r6 = "snsSugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x00b2;
    L_0x01b8:
        goto L_0x0197;
    L_0x01b9:
        r6 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        if (r12 != r6) goto L_0x01c9;
    L_0x01bd:
        r6 = "novelSugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x00b2;
    L_0x01c8:
        goto L_0x0197;
    L_0x01c9:
        r6 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        if (r12 != r6) goto L_0x01d9;
    L_0x01cd:
        r6 = "musicSugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x00b2;
    L_0x01d8:
        goto L_0x0197;
    L_0x01d9:
        r6 = 384; // 0x180 float:5.38E-43 double:1.897E-321;
        if (r12 == r6) goto L_0x01e5;
    L_0x01dd:
        r6 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        if (r12 == r6) goto L_0x01e5;
    L_0x01e1:
        r6 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r12 != r6) goto L_0x00b2;
    L_0x01e5:
        r6 = "emotionSugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x00b2;
    L_0x01f0:
        goto L_0x0197;
    L_0x01f1:
        r5 = 1;
        if (r12 != r5) goto L_0x0207;
    L_0x01f4:
        r5 = "bizTab";
        r5 = com.tencent.mm.plugin.websearch.api.r.PX(r5);
        r6 = "bizSugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x0207;
    L_0x0206:
        r1 = 1;
    L_0x0207:
        r5 = 2;
        if (r12 != r5) goto L_0x021d;
    L_0x020a:
        r5 = "articleTab";
        r5 = com.tencent.mm.plugin.websearch.api.r.PX(r5);
        r6 = "sugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x021d;
    L_0x021c:
        r1 = 1;
    L_0x021d:
        r5 = 8;
        if (r12 != r5) goto L_0x0240;
    L_0x0221:
        r5 = "snsTab";
        r5 = com.tencent.mm.plugin.websearch.api.r.PX(r5);
        r6 = "sugSwitch";
        r7 = 0;
        r6 = r5.optInt(r6, r7);
        r7 = 1;
        if (r6 != r7) goto L_0x0234;
    L_0x0233:
        r1 = 1;
    L_0x0234:
        r6 = "localSugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x0240;
    L_0x023f:
        r3 = 1;
    L_0x0240:
        if (r11 != 0) goto L_0x0258;
    L_0x0242:
        r5 = 4;
        if (r12 != r5) goto L_0x0258;
    L_0x0245:
        r5 = "bizTab";
        r5 = com.tencent.mm.plugin.websearch.api.r.PX(r5);
        r6 = "bizServiceSugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x0258;
    L_0x0257:
        r1 = 1;
    L_0x0258:
        r5 = 1;
        if (r12 != r5) goto L_0x026e;
    L_0x025b:
        r5 = "bizTab";
        r5 = com.tencent.mm.plugin.websearch.api.r.PX(r5);
        r6 = "mfsBizSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x026e;
    L_0x026d:
        r2 = 1;
    L_0x026e:
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        if (r12 != r5) goto L_0x0285;
    L_0x0272:
        r5 = "novelTab";
        r5 = com.tencent.mm.plugin.websearch.api.r.PX(r5);
        r6 = "sugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x0285;
    L_0x0284:
        r1 = 1;
    L_0x0285:
        r5 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        if (r12 != r5) goto L_0x029c;
    L_0x0289:
        r5 = "musicTab";
        r5 = com.tencent.mm.plugin.websearch.api.r.PX(r5);
        r6 = "sugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x029c;
    L_0x029b:
        r1 = 1;
    L_0x029c:
        r5 = 384; // 0x180 float:5.38E-43 double:1.897E-321;
        if (r12 != r5) goto L_0x02b3;
    L_0x02a0:
        r5 = "emotionTab";
        r5 = com.tencent.mm.plugin.websearch.api.r.PX(r5);
        r6 = "sugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x02b3;
    L_0x02b2:
        r1 = 1;
    L_0x02b3:
        if (r12 != 0) goto L_0x00b2;
    L_0x02b5:
        if (r11 == 0) goto L_0x00b2;
    L_0x02b7:
        r5 = "mixGlobal";
        r5 = com.tencent.mm.plugin.websearch.api.r.PX(r5);
        r6 = "mixSugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x00b2;
    L_0x02c9:
        r1 = 1;
        goto L_0x00b2;
    L_0x02cc:
        r5 = "bizEntry";
        r5 = com.tencent.mm.plugin.websearch.api.r.PX(r5);
        r6 = "sugSwitch";
        r5 = r5.optInt(r6);
        r6 = 1;
        if (r5 != r6) goto L_0x00b2;
    L_0x02dd:
        goto L_0x0197;
    L_0x02df:
        r5 = "bizUnionTopEntry";
        r5 = com.tencent.mm.plugin.websearch.api.r.PX(r5);
        r6 = "sugSwitch";
        r5 = r5.optInt(r6);
        r6 = 1;
        if (r5 != r6) goto L_0x00b2;
    L_0x02f0:
        goto L_0x0197;
    L_0x02f2:
        r5 = 384; // 0x180 float:5.38E-43 double:1.897E-321;
        if (r12 != r5) goto L_0x00b2;
    L_0x02f6:
        r5 = "emoticonMall";
        r5 = com.tencent.mm.plugin.websearch.api.r.PX(r5);
        r6 = "sugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x00b2;
    L_0x0308:
        r1 = 1;
        goto L_0x00b2;
    L_0x030b:
        r1 = "isHomePage";
        r2 = "1";
        r4.put(r1, r2);
        goto L_0x0114;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.websearch.api.p.a(int, boolean, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.util.Map<java.lang.String, java.lang.String>");
    }

    public static Map<String, String> b(int i, boolean z, int i2) {
        return a(i, z, i2, "");
    }

    public static Map<String, String> a(int i, boolean z, int i2, String str) {
        return a(i, z, i2, str, "", "", "", "", "", "", "");
    }

    public static boolean j(Activity activity, int i) {
        try {
            if (android.support.v4.content.a.f(activity, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                h.mEJ.h(15104, new Object[]{Integer.valueOf(i), Integer.valueOf(2)});
                return true;
            }
            h.mEJ.h(15104, new Object[]{Integer.valueOf(i), Integer.valueOf(1)});
            if (android.support.v4.app.a.a(activity, "android.permission.ACCESS_COARSE_LOCATION")) {
                x.w("MicroMsg.WebSearch.WebSearchApiLogic", "has shown request permission and user denied, do not show agagin");
                return true;
            }
            x.w("MicroMsg.WebSearch.WebSearchApiLogic", "showing request permission dialog");
            android.support.v4.app.a.a(activity, new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 73);
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e, "", new Object[0]);
            return true;
        }
    }

    public static void a(Context context, String str, Intent intent, String str2, String str3, String str4, String str5, String str6) {
        String str7 = "";
        String str8 = "";
        if (context == null) {
            x.e("MicroMsg.WebSearch.WebSearchApiLogic", "openNews intent is null, or context is null");
            return;
        }
        Intent ag = ag(intent);
        ag.putExtra("ftsbizscene", 21);
        ag.putExtra("ftsQuery", str);
        if (str2 != null) {
            ag.putExtra("title", str2);
        }
        ag.putExtra("isWebwx", str);
        ag.putExtra("ftscaneditable", false);
        ag.putExtra("key_load_js_without_delay", true);
        String zK = TextUtils.isEmpty(str5) ? zK(21) : str5;
        ag.putExtra("rawUrl", a(str3, str4, zK, str, "2", false, TextUtils.isEmpty(str6) ? zK(21) : str6, str7, str8));
        ag.putExtra("sessionId", zK);
        ag.putExtra("customize_status_bar_color", Color.parseColor("#F2F2F2"));
        ag.putExtra("status_bar_style", "black");
        d.b(context, "webview", ".ui.tools.fts.FTSWebViewUI", ag);
    }

    public static String bSO() {
        String optString = r.PX("discoverRecommendEntry").optString("wording");
        if (bi.oW(optString)) {
            x.e("MicroMsg.WebSearch.WebSearchApiLogic", "empty query");
            return "";
        }
        return a(null, null, zK(21), optString, null, true, zK(21), "", "");
    }

    private static String a(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, String str8) {
        Map a = a(21, false, 2, str, str2, str3, str4, str5, str6, "", str7);
        if (z) {
            a.put("isPreload", "1");
        }
        if (!bi.oW(str8)) {
            a.put("redPointMsgId", str8);
        }
        return c(a, 1);
    }

    public static void bSP() {
        g.Em().H(new Runnable() {
            public final void run() {
                Object bSO = p.bSO();
                if (!TextUtils.isEmpty(bSO)) {
                    z.bTc().cu(bSO, 2);
                }
            }
        });
    }

    public static void bSQ() {
        fz(0);
    }

    public static void fz(long j) {
        g.Em().h(new 2(), j);
    }

    public static void bSR() {
        fA(0);
    }

    public static void fA(long j) {
        g.Em().h(new 3(), j);
    }

    public static String bSS() {
        return aP(-1, zK(-1));
    }

    public static String aP(int i, String str) {
        Map b = b(i, true, 0);
        b.put("sessionId", str);
        b.put("inputMarginTop", "32");
        b.put("inputMarginLeftRight", "24");
        b.put("inputHeight", "48");
        b.put("isPreload", "1");
        return c(b, 0);
    }

    public static String v(Map<String, String> map) {
        return c(map, 0);
    }

    public static String c(Map<String, String> map, int i) {
        int i2 = 1;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file://");
        String adP = zL(i).adP();
        String str = "isOpenPreload";
        StringBuilder stringBuilder = new StringBuilder();
        z bTc = z.bTc();
        int i3 = i == 1 ? 2 : 1;
        if (ad.cic()) {
            boolean bTd;
            switch (i3) {
                case 1:
                    bTd = bTc.bTd();
                    break;
                default:
                    bTd = bTc.bTe();
                    break;
            }
            if (!bTd) {
                i2 = 0;
            }
            map.put(str, stringBuilder.append(i2).toString());
            stringBuffer.append(adP);
            StringBuffer append;
            if (map.size() > 0) {
                append = stringBuffer.append("/");
                zL(i);
                append.append("app.html?");
                for (Entry entry : map.entrySet()) {
                    stringBuffer.append((String) entry.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append((String) entry.getValue());
                    stringBuffer.append("&");
                }
                String str2 = (String) map.get("sessionId");
                if (!map.containsKey("sessionId")) {
                    str2 = zK(bi.WU((String) map.get("scene")));
                    stringBuffer.append("sessionId");
                    stringBuffer.append("=");
                    stringBuffer.append(str2);
                    stringBuffer.append("&");
                }
                if (!map.containsKey("subSessionId")) {
                    stringBuffer.append("subSessionId");
                    stringBuffer.append("=");
                    stringBuffer.append(str2);
                    stringBuffer.append("&");
                }
                stringBuffer.append("wechatVersion");
                stringBuffer.append("=");
                stringBuffer.append(com.tencent.mm.protocal.d.qVN);
                stringBuffer.append("&");
                return stringBuffer.substring(0, stringBuffer.length() - 1);
            }
            append = stringBuffer.append("/");
            zL(i);
            append.append("app.html");
            return stringBuffer.toString();
        }
        throw new IllegalStateException("please call from main process");
    }

    public static void ah(Intent intent) {
        intent.putExtra("ftsbizscene", 24);
        Map b = b(24, false, 384);
        String zK = zK(bi.WU((String) b.get("scene")));
        b.put("sessionId", zK);
        intent.putExtra("sessionId", zK);
        intent.putExtra("rawUrl", c(b, 0));
        intent.putExtra("ftsType", 384);
    }

    public static long LP(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        x.i("MicroMsg.WebSearch.WebSearchApiLogic", "seq %s to snsId %d ", new Object[]{str, Long.valueOf(new BigInteger(str).longValue())});
        return new BigInteger(str).longValue();
    }

    public static boolean fB(long j) {
        x.i("MicroMsg.WebSearch.WebSearchApiLogic", "rec updateRedDotTimestamp %d", new Object[]{Long.valueOf(j)});
        g.Ei().DT().a(aa.a.sZQ, Long.valueOf(j));
        return false;
    }

    public static boolean bST() {
        JSONObject PX = r.PX("snsContactMatch");
        if (PX == null) {
            return false;
        }
        if (PX.optInt("matchSwitch") == 1) {
            return true;
        }
        return false;
    }

    public static void a(String str, String str2, String str3, String str4, int i) {
        ly lyVar = new ly();
        lyVar.bWq.bWm = str4;
        lyVar.bWq.bJK = str2;
        lyVar.bWq.bWr = str3;
        lyVar.bWq.scene = i;
        lyVar.bWq.bWs = str;
        com.tencent.mm.sdk.b.a.sFg.m(lyVar);
    }

    public static int bSU() {
        JSONObject PX = r.PX("snsContactMatch");
        if (PX != null) {
            return PX.optInt("queryUtfLenLimit");
        }
        return 0;
    }

    public static String U(Map<String, ? extends Object> map) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Entry entry : map.entrySet()) {
            stringBuffer.append((String) entry.getKey());
            stringBuffer.append("=");
            if (entry.getValue() != null) {
                stringBuffer.append(entry.getValue().toString());
            }
            stringBuffer.append("&");
        }
        return stringBuffer.substring(0, stringBuffer.length() - 1).toString();
    }

    public static String t(Map<String, Object> map, String str) {
        if (map.containsKey(str)) {
            return map.get(str) != null ? map.get(str).toString() : "";
        } else {
            return "";
        }
    }

    public static boolean u(Map<String, Object> map, String str) {
        String t = t(map, str);
        if (bi.oW(t)) {
            return false;
        }
        try {
            if ("1".equals(t)) {
                return true;
            }
            if ("0".equals(t)) {
                return false;
            }
            return Boolean.valueOf(t).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    public static int c(Map<String, Object> map, String str, int i) {
        String t = t(map, str);
        if (bi.oW(t)) {
            return i;
        }
        try {
            return Integer.valueOf(t).intValue();
        } catch (Exception e) {
            return i;
        }
    }

    public static long a(Map<String, Object> map, String str, long j) {
        String t = t(map, str);
        if (bi.oW(t)) {
            return j;
        }
        try {
            return Long.valueOf(t).longValue();
        } catch (Exception e) {
            return j;
        }
    }

    public static void c(Context context, String str, Intent intent) {
        try {
            String str2 = ad.chX() + ".plugin.topstory";
            if (str.startsWith(".")) {
                str = str2 + str;
            }
            intent.setClassName(ad.getPackageName(), str);
            Class.forName(str, false, context.getClassLoader());
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            x.e("MicroMsg.WebSearch.WebSearchApiLogic", "Class Not Found when startActivity %s", new Object[]{e});
        }
    }

    public static void d(Context context, String str, Intent intent) {
        try {
            String str2 = ad.chX() + ".plugin.topstory";
            if (str.startsWith(".")) {
                str = str2 + str;
            }
            intent.setClassName(ad.getPackageName(), str);
            Class.forName(str, false, context.getClassLoader());
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, 10001);
            }
        } catch (Exception e) {
            x.e("MicroMsg.WebSearch.WebSearchApiLogic", "Class Not Found when startActivity %s", new Object[]{e});
        }
    }

    public static boolean bSV() {
        return com.tencent.mm.sdk.platformtools.d.CLIENT_VERSION.endsWith("0F");
    }
}
