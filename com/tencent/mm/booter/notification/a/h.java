package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.mm.R;
import com.tencent.mm.br.b;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ab;
import java.lang.ref.WeakReference;

public final class h {
    private static WeakReference<TextPaint> cZJ;
    private static int cZK = 0;
    private static int cZL = 0;
    public String cZG = "";
    public String cZH = "";
    public String cZI = "";

    public static String a(Context context, String str, String str2, int i) {
        return j.TT(b.cjC().Xw(a(0, str2, str, i, context)));
    }

    public static String i(Context context, String str, String str2) {
        String iB;
        if (s.fq(str)) {
            iB = bd.iB(str2);
            if (iB != null) {
                iB = r.gT(iB.trim());
            } else {
                iB = r.gT(str);
            }
        } else {
            iB = r.gT(str);
        }
        if (str.contains("@bottle")) {
            return context.getResources().getQuantityString(R.j.notification_fmt_multi_bottle, 1, new Object[]{Integer.valueOf(1)});
        }
        if (bi.oW(iB) && s.fq(str)) {
            iB = context.getString(R.l.chatting_roominfo_noname);
        }
        return b.cjC().Xw(iB);
    }

    public static String b(ab abVar) {
        Context context = ad.getContext();
        if (abVar == null) {
            return context.getString(R.l.bottle_unknowed_city);
        }
        String city;
        if (RegionCodeDecoder.Zh(abVar.getCountryCode())) {
            city = abVar.getCity();
            if (!bi.oW(city)) {
                return city;
            }
            city = r.gV(abVar.getProvince());
            if (!bi.oW(city)) {
                return city;
            }
            RegionCodeDecoder.cmS();
            return RegionCodeDecoder.getLocName(abVar.getCountryCode());
        }
        city = r.gV(abVar.getProvince());
        return bi.oW(city) ? context.getString(R.l.bottle_unknowed_city) : city;
    }

    public static String b(com.tencent.mm.storage.bd bdVar, PString pString, PString pString2, PInt pInt, boolean z) {
        return bi.oV(a(bdVar.field_imgPath, bdVar.field_isSend, bdVar.field_talker, j.TT(bdVar.cmh() ? bdVar.cmH() : bdVar.field_content), bdVar.getType(), ad.getContext(), pString, pString2, pInt, true, z));
    }

    public static String a(int i, String str, String str2, int i2, Context context) {
        return bi.oV(a(null, i, str, str2, i2, context, new PString(), new PString(), new PInt(), false, false));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r18, int r19, java.lang.String r20, java.lang.String r21, int r22, android.content.Context r23, com.tencent.mm.pointers.PString r24, com.tencent.mm.pointers.PString r25, com.tencent.mm.pointers.PInt r26, boolean r27, boolean r28) {
        /*
        r5 = "context is null";
        if (r23 == 0) goto L_0x0032;
    L_0x0005:
        r4 = 1;
    L_0x0006:
        junit.framework.Assert.assertTrue(r5, r4);
        r5 = "username is null";
        if (r20 == 0) goto L_0x0034;
    L_0x000e:
        r4 = r20.length();
        if (r4 <= 0) goto L_0x0034;
    L_0x0014:
        r4 = 1;
    L_0x0015:
        junit.framework.Assert.assertTrue(r5, r4);
        if (r27 != 0) goto L_0x005b;
    L_0x001a:
        r4 = com.tencent.mm.model.s.hk(r20);
        if (r4 == 0) goto L_0x0036;
    L_0x0020:
        r4 = com.tencent.mm.model.q.GX();
        if (r4 != 0) goto L_0x0036;
    L_0x0026:
        r4 = 1;
    L_0x0027:
        if (r4 == 0) goto L_0x005b;
    L_0x0029:
        r4 = com.tencent.mm.R.l.settings_plugins_disable;
        r0 = r23;
        r18 = r0.getString(r4);
    L_0x0031:
        return r18;
    L_0x0032:
        r4 = 0;
        goto L_0x0006;
    L_0x0034:
        r4 = 0;
        goto L_0x0015;
    L_0x0036:
        r4 = com.tencent.mm.model.s.hm(r20);
        if (r4 == 0) goto L_0x004b;
    L_0x003c:
        r4 = com.tencent.mm.model.q.GJ();
        r4 = r4 & 64;
        if (r4 == 0) goto L_0x0049;
    L_0x0044:
        r4 = 1;
    L_0x0045:
        if (r4 != 0) goto L_0x004b;
    L_0x0047:
        r4 = 1;
        goto L_0x0027;
    L_0x0049:
        r4 = 0;
        goto L_0x0045;
    L_0x004b:
        r4 = com.tencent.mm.model.s.hq(r20);
        if (r4 == 0) goto L_0x0059;
    L_0x0051:
        r4 = com.tencent.mm.model.q.Ha();
        if (r4 != 0) goto L_0x0059;
    L_0x0057:
        r4 = 1;
        goto L_0x0027;
    L_0x0059:
        r4 = 0;
        goto L_0x0027;
    L_0x005b:
        r16 = 0;
        r15 = 0;
        r4 = com.tencent.mm.model.s.hq(r20);
        if (r4 == 0) goto L_0x00d1;
    L_0x0064:
        if (r27 == 0) goto L_0x006a;
    L_0x0066:
        r18 = "";
        goto L_0x0031;
    L_0x006a:
        r5 = com.tencent.mm.model.q.Ha();
        com.tencent.mm.model.au.HU();
        r4 = com.tencent.mm.model.c.DT();
        r6 = 65793; // 0x10101 float:9.2196E-41 double:3.2506E-319;
        r7 = 0;
        r4 = r4.get(r6, r7);
        r4 = (java.lang.Long) r4;
        r6 = 0;
        r6 = com.tencent.mm.sdk.platformtools.bi.a(r4, r6);
        if (r5 != 0) goto L_0x0090;
    L_0x0087:
        r4 = com.tencent.mm.R.l.settings_plugins_disable;
        r0 = r23;
        r18 = r0.getString(r4);
        goto L_0x0031;
    L_0x0090:
        r4 = 0;
        r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r4 != 0) goto L_0x009f;
    L_0x0096:
        r4 = com.tencent.mm.R.l.fmt_qqsynchelper_brief_new;
        r0 = r23;
        r18 = r0.getString(r4);
        goto L_0x0031;
    L_0x009f:
        r4 = com.tencent.mm.sdk.platformtools.bi.bG(r6);
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 * r8;
        r8 = 1209600000; // 0x48190800 float:156704.0 double:5.97621805E-315;
        r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r4 <= 0) goto L_0x00cc;
    L_0x00ad:
        r4 = com.tencent.mm.R.l.fmt_qqsynchelper_brief_alert;
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r8 = 0;
        r6 = com.tencent.mm.sdk.platformtools.bi.bG(r6);
        r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 * r10;
        r10 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r6 = r6 / r10;
        r6 = java.lang.Long.valueOf(r6);
        r5[r8] = r6;
        r0 = r23;
        r18 = r0.getString(r4, r5);
        goto L_0x0031;
    L_0x00cc:
        r18 = "";
        goto L_0x0031;
    L_0x00d1:
        r14 = "";
        r6 = "";
        r5 = "";
        r4 = 0;
        if (r21 == 0) goto L_0x13fd;
    L_0x00dd:
        if (r27 == 0) goto L_0x13fd;
    L_0x00df:
        r4 = 1;
        r21 = eS(r21);
        r11 = r4;
    L_0x00e5:
        r0 = r21;
        r1 = r24;
        r1.value = r0;
        if (r19 != 0) goto L_0x13f7;
    L_0x00ed:
        r4 = com.tencent.mm.model.s.fq(r20);
        if (r4 == 0) goto L_0x13f7;
    L_0x00f3:
        r4 = com.tencent.mm.model.bd.iA(r21);
        if (r4 <= 0) goto L_0x13f7;
    L_0x00f9:
        r5 = 0;
        r0 = r21;
        r5 = r0.substring(r5, r4);
        r6 = r5.trim();
        r0 = r20;
        r5 = com.tencent.mm.model.r.getDisplayName(r6, r0);
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r0 = r21;
        r7 = r7.append(r0);
        r8 = " ";
        r7 = r7.append(r8);
        r7 = r7.toString();
        r4 = r4 + 1;
        r4 = r7.substring(r4);
        r12 = r5;
        r13 = r6;
    L_0x0128:
        r5 = 0;
        r6 = com.tencent.mm.model.s.hE(r20);
        if (r6 != 0) goto L_0x0135;
    L_0x012f:
        r6 = com.tencent.mm.model.s.hN(r20);
        if (r6 == 0) goto L_0x017a;
    L_0x0135:
        r6 = ":";
        r0 = r21;
        r6 = r0.indexOf(r6);
        r7 = -1;
        if (r6 == r7) goto L_0x0154;
    L_0x0141:
        r7 = 0;
        r0 = r21;
        r7 = r0.substring(r7, r6);
        r0 = r25;
        r0.value = r7;
        r6 = r6 + 1;
        r0 = r21;
        r21 = r0.substring(r6);
    L_0x0154:
        r17 = r5;
        r7 = r21;
    L_0x0158:
        switch(r22) {
            case -1879048191: goto L_0x0389;
            case -1879048190: goto L_0x0389;
            case -1879048189: goto L_0x0389;
            case -1879048188: goto L_0x03e5;
            case -1879048186: goto L_0x09cf;
            case -1879048185: goto L_0x0a3e;
            case -1879048183: goto L_0x0a3e;
            case -1879048176: goto L_0x0a3e;
            case 3: goto L_0x01b8;
            case 11: goto L_0x0253;
            case 13: goto L_0x0235;
            case 23: goto L_0x01b8;
            case 33: goto L_0x01b8;
            case 34: goto L_0x026a;
            case 35: goto L_0x04bb;
            case 36: goto L_0x0253;
            case 37: goto L_0x03f8;
            case 39: goto L_0x0235;
            case 40: goto L_0x0485;
            case 42: goto L_0x04f1;
            case 43: goto L_0x02f0;
            case 47: goto L_0x01f5;
            case 48: goto L_0x05b4;
            case 49: goto L_0x0a87;
            case 50: goto L_0x039c;
            case 52: goto L_0x03d2;
            case 53: goto L_0x039c;
            case 55: goto L_0x10b2;
            case 57: goto L_0x10b2;
            case 62: goto L_0x02f0;
            case 66: goto L_0x04f1;
            case 1048625: goto L_0x01f5;
            case 12299999: goto L_0x0376;
            case 16777265: goto L_0x0a87;
            case 268435505: goto L_0x0a87;
            case 285212721: goto L_0x1058;
            case 318767153: goto L_0x107a;
            case 335544369: goto L_0x0611;
            case 369098801: goto L_0x0835;
            case 402653233: goto L_0x0665;
            case 419430449: goto L_0x06a6;
            case 436207665: goto L_0x072f;
            case 452984881: goto L_0x0895;
            case 469762097: goto L_0x072f;
            case 503316529: goto L_0x10c6;
            case 520093745: goto L_0x0936;
            case 536870961: goto L_0x07dc;
            case 553648177: goto L_0x0a87;
            case 570425393: goto L_0x10fe;
            case 587202609: goto L_0x0a87;
            case 603979825: goto L_0x1120;
            default: goto L_0x015b;
        };
    L_0x015b:
        r18 = r14;
        r6 = r15;
        r8 = r16;
        r9 = r7;
    L_0x0161:
        r4 = com.tencent.mm.model.s.hl(r20);
        if (r4 == 0) goto L_0x1230;
    L_0x0167:
        r4 = 1;
        r0 = r19;
        if (r4 != r0) goto L_0x115d;
    L_0x016c:
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r18);
        if (r4 != 0) goto L_0x113b;
    L_0x0172:
        r0 = r18;
        r1 = r24;
        r1.value = r0;
        goto L_0x0031;
    L_0x017a:
        com.tencent.mm.model.au.HU();
        r6 = com.tencent.mm.model.c.FW();
        r0 = r20;
        r6 = r6.Yq(r0);
        if (r6 == 0) goto L_0x0191;
    L_0x0189:
        r7 = 2097152; // 0x200000 float:2.938736E-39 double:1.0361308E-317;
        r6 = r6.gh(r7);
        if (r6 != 0) goto L_0x0193;
    L_0x0191:
        if (r28 == 0) goto L_0x13f1;
    L_0x0193:
        r5 = 1;
        r6 = ":";
        r0 = r21;
        r6 = r0.indexOf(r6);
        r7 = -1;
        if (r6 == r7) goto L_0x13f1;
    L_0x01a0:
        r7 = 0;
        r0 = r21;
        r7 = r0.substring(r7, r6);
        r0 = r25;
        r0.value = r7;
        r6 = r6 + 1;
        r0 = r21;
        r21 = r0.substring(r6);
        r17 = r5;
        r7 = r21;
        goto L_0x0158;
    L_0x01b8:
        r4 = com.tencent.mm.R.l.app_pic;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x01ed;
    L_0x01c6:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x01da:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x01f1;
    L_0x01e0:
        r5 = "%s: ";
    L_0x01e3:
        r0 = r24;
        r0.value = r5;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x01ed:
        r4 = "";
        goto L_0x01da;
    L_0x01f1:
        r5 = "";
        goto L_0x01e3;
    L_0x01f5:
        r5 = com.tencent.mm.storage.an.YJ(r7);
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = r5.enF;
        r4 = r4.append(r6);
        r6 = ": ";
        r4 = r4.append(r6);
        r4 = r4.toString();
        if (r18 == 0) goto L_0x022c;
    L_0x0211:
        r6 = r18.length();
        r7 = 32;
        if (r6 != r7) goto L_0x022c;
    L_0x0219:
        r6 = "";
        r0 = r24;
        r0.value = r6;
        r5 = r5.enF;
        r0 = r25;
        r0.value = r5;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x022c:
        r6 = com.tencent.mm.R.l.app_emoji;
        r0 = r23;
        r18 = r0.getString(r6);
        goto L_0x0219;
    L_0x0235:
        r4 = com.tencent.mm.R.l.app_pic;
        r0 = r23;
        r8 = r0.getString(r4);
        r4 = r23;
        r5 = r19;
        r6 = r20;
        r9 = r24;
        r10 = r25;
        r4 = a(r4, r5, r6, r7, r8, r9, r10);
        r18 = r14;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x0253:
        r8 = 0;
        r4 = r23;
        r5 = r19;
        r6 = r20;
        r9 = r24;
        r10 = r25;
        r4 = a(r4, r5, r6, r7, r8, r9, r10);
        r18 = r14;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x026a:
        r4 = com.tencent.mm.storage.ab.XO(r20);
        if (r4 != 0) goto L_0x0282;
    L_0x0270:
        r4 = com.tencent.mm.storage.ab.XQ(r20);
        if (r4 != 0) goto L_0x0282;
    L_0x0276:
        r4 = com.tencent.mm.model.s.hk(r20);
        if (r4 != 0) goto L_0x0282;
    L_0x027c:
        r4 = com.tencent.mm.model.s.hm(r20);
        if (r4 == 0) goto L_0x02a0;
    L_0x0282:
        r4 = com.tencent.mm.R.l.app_voice;
        r0 = r23;
        r8 = r0.getString(r4);
        r4 = r23;
        r5 = r19;
        r6 = r20;
        r9 = r24;
        r10 = r25;
        r4 = a(r4, r5, r6, r7, r8, r9, r10);
        r18 = r14;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x02a0:
        if (r7 == 0) goto L_0x02dc;
    L_0x02a2:
        r4 = r7.length();
        if (r4 <= 0) goto L_0x02dc;
    L_0x02a8:
        r4 = com.tencent.mm.model.s.hl(r20);
        if (r4 != 0) goto L_0x02dc;
    L_0x02ae:
        r4 = com.tencent.mm.model.s.fq(r20);
        if (r4 == 0) goto L_0x02ec;
    L_0x02b4:
        r4 = new com.tencent.mm.modelvoice.n;
        r4.<init>(r7);
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = r4.enF;
        r5 = r5.append(r6);
        r6 = ": ";
        r5 = r5.append(r6);
        r7 = r5.toString();
        r5 = "%s:";
        r0 = r24;
        r0.value = r5;
        r4 = r4.enF;
        r0 = r25;
        r0.value = r4;
    L_0x02dc:
        r4 = com.tencent.mm.R.l.app_voice;
        r0 = r23;
        r4 = r0.getString(r4);
        r18 = r4;
        r6 = r15;
        r8 = r16;
        r9 = r7;
        goto L_0x0161;
    L_0x02ec:
        r7 = "";
        goto L_0x02dc;
    L_0x02f0:
        r4 = com.tencent.mm.storage.ab.XO(r20);
        if (r4 != 0) goto L_0x0308;
    L_0x02f6:
        r4 = com.tencent.mm.storage.ab.XQ(r20);
        if (r4 != 0) goto L_0x0308;
    L_0x02fc:
        r4 = com.tencent.mm.model.s.hk(r20);
        if (r4 != 0) goto L_0x0308;
    L_0x0302:
        r4 = com.tencent.mm.model.s.hm(r20);
        if (r4 == 0) goto L_0x0326;
    L_0x0308:
        r4 = com.tencent.mm.R.l.app_video;
        r0 = r23;
        r8 = r0.getString(r4);
        r4 = r23;
        r5 = r19;
        r6 = r20;
        r9 = r24;
        r10 = r25;
        r4 = a(r4, r5, r6, r7, r8, r9, r10);
        r18 = r14;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x0326:
        if (r7 == 0) goto L_0x0362;
    L_0x0328:
        r4 = r7.length();
        if (r4 <= 0) goto L_0x0362;
    L_0x032e:
        r4 = com.tencent.mm.model.s.hl(r20);
        if (r4 != 0) goto L_0x0362;
    L_0x0334:
        r4 = com.tencent.mm.model.s.fq(r20);
        if (r4 == 0) goto L_0x0372;
    L_0x033a:
        r4 = new com.tencent.mm.modelvideo.p;
        r4.<init>(r7);
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = r4.enF;
        r5 = r5.append(r6);
        r6 = ": ";
        r5 = r5.append(r6);
        r7 = r5.toString();
        r5 = "%s:";
        r0 = r24;
        r0.value = r5;
        r4 = r4.enF;
        r0 = r25;
        r0.value = r4;
    L_0x0362:
        r4 = com.tencent.mm.R.l.app_video;
        r0 = r23;
        r4 = r0.getString(r4);
        r18 = r4;
        r6 = r15;
        r8 = r16;
        r9 = r7;
        goto L_0x0161;
    L_0x0372:
        r7 = "";
        goto L_0x0362;
    L_0x0376:
        r7 = "";
        r4 = com.tencent.mm.R.l.app_voip;
        r0 = r23;
        r4 = r0.getString(r4);
        r18 = r4;
        r6 = r15;
        r8 = r16;
        r9 = r7;
        goto L_0x0161;
    L_0x0389:
        r7 = "";
        r4 = com.tencent.mm.R.l.app_voice_remind;
        r0 = r23;
        r4 = r0.getString(r4);
        r18 = r4;
        r6 = r15;
        r8 = r16;
        r9 = r7;
        goto L_0x0161;
    L_0x039c:
        r4 = com.tencent.mm.storage.bd.tby;
        r4 = r7.equals(r4);
        if (r4 == 0) goto L_0x03b7;
    L_0x03a4:
        r7 = "";
        r4 = com.tencent.mm.R.l.app_voip;
        r0 = r23;
        r4 = r0.getString(r4);
        r18 = r4;
        r6 = r15;
        r8 = r16;
        r9 = r7;
        goto L_0x0161;
    L_0x03b7:
        r4 = com.tencent.mm.storage.bd.tbx;
        r4 = r7.equals(r4);
        if (r4 == 0) goto L_0x015b;
    L_0x03bf:
        r7 = "";
        r4 = com.tencent.mm.R.l.app_voip_voice;
        r0 = r23;
        r4 = r0.getString(r4);
        r18 = r4;
        r6 = r15;
        r8 = r16;
        r9 = r7;
        goto L_0x0161;
    L_0x03d2:
        r7 = "";
        r4 = com.tencent.mm.R.l.app_voip;
        r0 = r23;
        r4 = r0.getString(r4);
        r18 = r4;
        r6 = r15;
        r8 = r16;
        r9 = r7;
        goto L_0x0161;
    L_0x03e5:
        r7 = "";
        r4 = com.tencent.mm.R.l.app_voip_voice;
        r0 = r23;
        r4 = r0.getString(r4);
        r18 = r4;
        r6 = r15;
        r8 = r16;
        r9 = r7;
        goto L_0x0161;
    L_0x03f8:
        if (r7 == 0) goto L_0x015b;
    L_0x03fa:
        r4 = r7.length();
        if (r4 <= 0) goto L_0x015b;
    L_0x0400:
        r4 = com.tencent.mm.storage.bd.d.YY(r7);
        r5 = r4.otZ;
        if (r5 == 0) goto L_0x042b;
    L_0x0408:
        r5 = r4.otZ;
        r5 = r5.length();
        if (r5 <= 0) goto L_0x042b;
    L_0x0410:
        r5 = r4.scene;
        switch(r5) {
            case 18: goto L_0x0433;
            case 19: goto L_0x0415;
            case 20: goto L_0x0415;
            case 21: goto L_0x0415;
            case 22: goto L_0x044d;
            case 23: goto L_0x044d;
            case 24: goto L_0x044d;
            case 25: goto L_0x0467;
            case 26: goto L_0x044d;
            case 27: goto L_0x044d;
            case 28: goto L_0x044d;
            case 29: goto L_0x044d;
            default: goto L_0x0415;
        };
    L_0x0415:
        r5 = com.tencent.mm.R.l.fmt_want_to_be_your_friend;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.getDisplayName();
        r6[r7] = r4;
        r0 = r23;
        r7 = r0.getString(r5, r6);
        r0 = r24;
        r0.value = r7;
    L_0x042b:
        r18 = r14;
        r6 = r15;
        r8 = r16;
        r9 = r7;
        goto L_0x0161;
    L_0x0433:
        r5 = com.tencent.mm.R.l.fmt_say_hello_to_you;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.getDisplayName();
        r6[r7] = r4;
        r0 = r23;
        r4 = r0.getString(r5, r6);
        r18 = r14;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x044d:
        r5 = com.tencent.mm.R.l.fmt_shake_say_hello_to_you;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.getDisplayName();
        r6[r7] = r4;
        r0 = r23;
        r4 = r0.getString(r5, r6);
        r18 = r14;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x0467:
        r5 = com.tencent.mm.R.l.fmt_bottle_say_hello_to_you;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.getDisplayName();
        r6[r7] = r4;
        r0 = r23;
        r4 = r0.getString(r5, r6);
        r0 = r24;
        r0.value = r4;
        r18 = r14;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x0485:
        if (r7 == 0) goto L_0x015b;
    L_0x0487:
        r4 = r7.length();
        if (r4 <= 0) goto L_0x015b;
    L_0x048d:
        r4 = com.tencent.mm.storage.bd.a.YV(r7);
        r5 = r4.otZ;
        if (r5 == 0) goto L_0x04b3;
    L_0x0495:
        r5 = r4.otZ;
        r5 = r5.length();
        if (r5 <= 0) goto L_0x04b3;
    L_0x049d:
        r5 = com.tencent.mm.R.l.fmt_just_reg_micromsg;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.getDisplayName();
        r6[r7] = r4;
        r0 = r23;
        r7 = r0.getString(r5, r6);
        r0 = r24;
        r0.value = r7;
    L_0x04b3:
        r18 = r14;
        r6 = r15;
        r8 = r16;
        r9 = r7;
        goto L_0x0161;
    L_0x04bb:
        r4 = com.tencent.mm.sdk.platformtools.bi.oV(r7);
        r4 = r4.length();
        if (r4 <= 0) goto L_0x015b;
    L_0x04c5:
        com.tencent.mm.model.au.HU();
        r4 = com.tencent.mm.model.c.FT();
        r4 = r4.GP(r7);
        r5 = com.tencent.mm.R.l.fmt_qqmailhelper_brief;
        r6 = 2;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = r4.eeZ;
        r6[r7] = r8;
        r7 = 1;
        r4 = r4.title;
        r6[r7] = r4;
        r0 = r23;
        r4 = r0.getString(r5, r6);
        r0 = r24;
        r0.value = r4;
        r18 = r14;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x04f1:
        r4 = com.tencent.mm.sdk.platformtools.bi.oV(r7);
        r4 = r4.length();
        if (r4 <= 0) goto L_0x015b;
    L_0x04fb:
        r4 = com.tencent.mm.model.s.fq(r20);
        if (r4 == 0) goto L_0x050b;
    L_0x0501:
        r4 = com.tencent.mm.model.bd.iB(r7);
        r5 = android.text.TextUtils.isEmpty(r4);
        if (r5 == 0) goto L_0x050d;
    L_0x050b:
        r4 = r20;
    L_0x050d:
        com.tencent.mm.model.au.HU();
        r5 = com.tencent.mm.model.c.FT();
        r6 = r5.GR(r7);
        com.tencent.mm.model.au.HU();
        r5 = com.tencent.mm.model.c.FR();
        r5 = r5.Yg(r4);
        r5 = r5.BL();
        r7 = com.tencent.mm.model.s.fq(r5);
        if (r7 == 0) goto L_0x0535;
    L_0x052d:
        r5 = com.tencent.mm.model.m.gL(r5);
        r5 = com.tencent.mm.model.m.F(r5);
    L_0x0535:
        r7 = 1;
        r0 = r19;
        if (r0 != r7) goto L_0x0577;
    L_0x053a:
        r7 = com.tencent.mm.R.l.fmt_card_from;
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r8[r9] = r5;
        r5 = 1;
        r9 = r6.getDisplayName();
        r8[r5] = r9;
        r0 = r23;
        r7 = r0.getString(r7, r8);
        r5 = com.tencent.mm.R.l.fmt_card_from;
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = "%s";
        r8[r9] = r10;
        r9 = 1;
        r6 = r6.getDisplayName();
        r8[r9] = r6;
        r0 = r23;
        r5 = r0.getString(r5, r8);
        r0 = r24;
        r0.value = r5;
        r0 = r25;
        r0.value = r4;
        r18 = r14;
        r6 = r15;
        r8 = r16;
        r9 = r7;
        goto L_0x0161;
    L_0x0577:
        r7 = com.tencent.mm.R.l.fmt_card_to;
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r8[r9] = r5;
        r5 = 1;
        r9 = r6.getDisplayName();
        r8[r5] = r9;
        r0 = r23;
        r7 = r0.getString(r7, r8);
        r5 = com.tencent.mm.R.l.fmt_card_to;
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = "%s";
        r8[r9] = r10;
        r9 = 1;
        r6 = r6.getDisplayName();
        r8[r9] = r6;
        r0 = r23;
        r5 = r0.getString(r5, r8);
        r0 = r24;
        r0.value = r5;
        r0 = r25;
        r0.value = r4;
        r18 = r14;
        r6 = r15;
        r8 = r16;
        r9 = r7;
        goto L_0x0161;
    L_0x05b4:
        r4 = com.tencent.mm.sdk.platformtools.bi.oV(r7);
        r4 = r4.length();
        if (r4 <= 0) goto L_0x015b;
    L_0x05be:
        r4 = com.tencent.mm.model.s.fq(r20);
        if (r4 == 0) goto L_0x13ed;
    L_0x05c4:
        r4 = com.tencent.mm.model.bd.iA(r7);
        r5 = -1;
        if (r4 == r5) goto L_0x13e9;
    L_0x05cb:
        r5 = 0;
        r4 = r7.substring(r5, r4);
        r4 = r4.trim();
    L_0x05d4:
        com.tencent.mm.model.bd.iC(r7);
        r5 = r4;
    L_0x05d8:
        r4 = 1;
        r0 = r19;
        if (r0 != r4) goto L_0x05f1;
    L_0x05dd:
        r4 = com.tencent.mm.R.l.location_conversation;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        r18 = r14;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x05f1:
        r4 = com.tencent.mm.R.l.location_conversation;
        r0 = r23;
        r4 = r0.getString(r4);
        r6 = com.tencent.mm.R.l.location_conversation;
        r0 = r23;
        r6 = r0.getString(r6);
        r0 = r24;
        r0.value = r6;
        r0 = r25;
        r0.value = r5;
        r18 = r14;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x0611:
        r4 = com.tencent.mm.sdk.platformtools.bi.WT(r4);
        r4 = com.tencent.mm.y.g.a.gp(r4);
        r5 = r4.dwR;
        if (r5 == 0) goto L_0x065c;
    L_0x061d:
        r5 = r4.dwR;
        r6 = 1;
        if (r5 != r6) goto L_0x0640;
    L_0x0622:
        r4 = com.tencent.mm.R.l.scan_product_type_conversation_book;
        r0 = r23;
        r4 = r0.getString(r4);
    L_0x062a:
        r7 = "";
        r0 = r25;
        r0.value = r13;
        r5 = "";
        r0 = r24;
        r0.value = r5;
        r18 = r4;
        r6 = r15;
        r8 = r16;
        r9 = r7;
        goto L_0x0161;
    L_0x0640:
        r5 = r4.dwR;
        r6 = 2;
        if (r5 != r6) goto L_0x064e;
    L_0x0645:
        r4 = com.tencent.mm.R.l.scan_product_type_conversation_movie;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x062a;
    L_0x064e:
        r4 = r4.dwR;
        r5 = 3;
        if (r4 != r5) goto L_0x065c;
    L_0x0653:
        r4 = com.tencent.mm.R.l.scan_product_type_conversation_cd;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x062a;
    L_0x065c:
        r4 = com.tencent.mm.R.l.scan_product_type_conversation_unknown;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x062a;
    L_0x0665:
        r5 = com.tencent.mm.sdk.platformtools.bi.WT(r4);
        r18 = "";
        r4 = "";
        r5 = com.tencent.mm.y.g.a.gp(r5);
        if (r5 == 0) goto L_0x069c;
    L_0x0675:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = com.tencent.mm.R.l.scan_type_conversation_tv;
        r0 = r23;
        r6 = r0.getString(r6);
        r4 = r4.append(r6);
        r5 = r5.title;
        r5 = com.tencent.mm.sdk.platformtools.bi.oV(r5);
        r4 = r4.append(r5);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
        r0 = r24;
        r4 = r0.value;
    L_0x069c:
        r0 = r25;
        r0.value = r13;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x06a6:
        r5 = com.tencent.mm.sdk.platformtools.bi.WT(r4);
        r18 = "";
        r4 = "";
        r5 = com.tencent.mm.y.g.a.gp(r5);
        if (r5 == 0) goto L_0x06cf;
    L_0x06b6:
        r4 = 1;
        r0 = r19;
        if (r0 != r4) goto L_0x06d9;
    L_0x06bb:
        r4 = 1;
    L_0x06bc:
        r6 = r5.dxy;
        switch(r6) {
            case 1: goto L_0x06db;
            case 2: goto L_0x06c1;
            case 3: goto L_0x06f7;
            case 4: goto L_0x0713;
            default: goto L_0x06c1;
        };
    L_0x06c1:
        r4 = r5.title;
        r4 = com.tencent.mm.sdk.platformtools.bi.oV(r4);
        r0 = r24;
        r0.value = r4;
    L_0x06cb:
        r0 = r24;
        r4 = r0.value;
    L_0x06cf:
        r0 = r25;
        r0.value = r13;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x06d9:
        r4 = 0;
        goto L_0x06bc;
    L_0x06db:
        if (r4 == 0) goto L_0x06ea;
    L_0x06dd:
        r4 = com.tencent.mm.R.l.appmsg_remittance_digest_payer_wait;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06cb;
    L_0x06ea:
        r4 = com.tencent.mm.R.l.appmsg_remittance_digest_receiver_wait;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06cb;
    L_0x06f7:
        if (r4 == 0) goto L_0x0706;
    L_0x06f9:
        r4 = com.tencent.mm.R.l.appmsg_remittance_digest_receiver_collected;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06cb;
    L_0x0706:
        r4 = com.tencent.mm.R.l.appmsg_remittance_digest_payer_collected;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06cb;
    L_0x0713:
        if (r4 == 0) goto L_0x0722;
    L_0x0715:
        r4 = com.tencent.mm.R.l.appmsg_remittance_digest_receiver_refused;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06cb;
    L_0x0722:
        r4 = com.tencent.mm.R.l.appmsg_remittance_digest_payer_refused;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06cb;
    L_0x072f:
        r5 = com.tencent.mm.sdk.platformtools.bi.WT(r4);
        r18 = "";
        r4 = "";
        r5 = com.tencent.mm.y.g.a.gp(r5);
        if (r5 == 0) goto L_0x076e;
    L_0x073f:
        r4 = 1;
        r0 = r19;
        if (r0 != r4) goto L_0x0780;
    L_0x0744:
        r4 = 1;
    L_0x0745:
        if (r4 == 0) goto L_0x0782;
    L_0x0747:
        r4 = new java.lang.StringBuilder;
        r6 = "[";
        r4.<init>(r6);
        r6 = r5.dxZ;
        r4 = r4.append(r6);
        r6 = "]";
        r4 = r4.append(r6);
        r5 = r5.dxW;
        r4 = r4.append(r5);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
    L_0x076a:
        r0 = r24;
        r4 = r0.value;
    L_0x076e:
        r5 = com.tencent.mm.model.s.hE(r20);
        if (r5 != 0) goto L_0x13e3;
    L_0x0774:
        if (r17 != 0) goto L_0x13e3;
    L_0x0776:
        r0 = r25;
        r0.value = r13;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x0780:
        r4 = 0;
        goto L_0x0745;
    L_0x0782:
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r12);
        if (r4 != 0) goto L_0x07b8;
    L_0x0788:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = com.tencent.mm.sdk.platformtools.bi.oV(r12);
        r4 = r4.append(r6);
        r6 = ": [";
        r4 = r4.append(r6);
        r6 = r5.dxZ;
        r4 = r4.append(r6);
        r6 = "]";
        r4 = r4.append(r6);
        r5 = r5.dxV;
        r4 = r4.append(r5);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
        goto L_0x076a;
    L_0x07b8:
        r4 = new java.lang.StringBuilder;
        r6 = "[";
        r4.<init>(r6);
        r6 = r5.dxZ;
        r4 = r4.append(r6);
        r6 = "]";
        r4 = r4.append(r6);
        r5 = r5.dxV;
        r4 = r4.append(r5);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
        goto L_0x076a;
    L_0x07dc:
        r5 = com.tencent.mm.sdk.platformtools.bi.WT(r4);
        r18 = "";
        r4 = "";
        r5 = com.tencent.mm.y.g.a.gp(r5);
        if (r5 == 0) goto L_0x13e3;
    L_0x07ec:
        r4 = com.tencent.mm.y.b.class;
        r4 = r5.u(r4);
        r4 = (com.tencent.mm.y.b) r4;
        r5 = 1;
        r0 = r19;
        if (r0 != r5) goto L_0x081e;
    L_0x07f9:
        r5 = 1;
    L_0x07fa:
        if (r5 == 0) goto L_0x0820;
    L_0x07fc:
        r5 = com.tencent.mm.R.l.honey_pay_prefix;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.dwc;
        r6[r7] = r4;
        r0 = r23;
        r4 = r0.getString(r5, r6);
        r0 = r24;
        r0.value = r4;
    L_0x0810:
        r0 = r24;
        r4 = r0.value;
        r0 = r25;
        r0.value = r13;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x081e:
        r5 = 0;
        goto L_0x07fa;
    L_0x0820:
        r5 = com.tencent.mm.R.l.honey_pay_prefix;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.dwd;
        r6[r7] = r4;
        r0 = r23;
        r4 = r0.getString(r5, r6);
        r0 = r24;
        r0.value = r4;
        goto L_0x0810;
    L_0x0835:
        r4 = com.tencent.mm.sdk.platformtools.bi.WT(r4);
        r4 = com.tencent.mm.y.g.a.gp(r4);
        r4 = r4.dwR;
        switch(r4) {
            case 10000: goto L_0x087f;
            case 20000: goto L_0x0888;
            default: goto L_0x0842;
        };
    L_0x0842:
        r4 = com.tencent.mm.R.l.app_product;
        r0 = r23;
        r4 = r0.getString(r4);
    L_0x084a:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0891;
    L_0x0850:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r5 = r5.append(r13);
        r6 = ": ";
        r5 = r5.append(r6);
        r5 = r5.toString();
    L_0x0864:
        r6 = com.tencent.mm.model.s.hE(r20);
        if (r6 != 0) goto L_0x0870;
    L_0x086a:
        if (r17 != 0) goto L_0x0870;
    L_0x086c:
        r0 = r25;
        r0.value = r13;
    L_0x0870:
        r6 = "";
        r0 = r24;
        r0.value = r6;
        r18 = r4;
        r6 = r15;
        r8 = r16;
        r9 = r5;
        goto L_0x0161;
    L_0x087f:
        r4 = com.tencent.mm.R.l.app_product_card;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x084a;
    L_0x0888:
        r4 = com.tencent.mm.R.l.app_product_ticket;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x084a;
    L_0x0891:
        r5 = "";
        goto L_0x0864;
    L_0x0895:
        r4 = com.tencent.mm.sdk.platformtools.bi.WT(r4);
        r5 = com.tencent.mm.y.g.a.gp(r4);
        if (r5 != 0) goto L_0x08ad;
    L_0x089f:
        r4 = "MicroMsg.Notification.Wording";
        r5 = "decode msg content failed";
        com.tencent.mm.sdk.platformtools.x.e(r4, r5);
        r18 = "";
        goto L_0x0031;
    L_0x08ad:
        r18 = "";
        r4 = com.tencent.mm.R.l.card_msg_item_digest;
        r0 = r23;
        r6 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x090e;
    L_0x08be:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r7 = ": ";
        r4 = r4.append(r7);
        r4 = r4.append(r6);
        r7 = r5.title;
        r4 = r4.append(r7);
        r4 = r4.toString();
    L_0x08dc:
        r7 = com.tencent.mm.model.s.hE(r20);
        if (r7 != 0) goto L_0x08e8;
    L_0x08e2:
        if (r17 != 0) goto L_0x08e8;
    L_0x08e4:
        r0 = r25;
        r0.value = r13;
    L_0x08e8:
        r7 = r13.length();
        if (r7 <= 0) goto L_0x0922;
    L_0x08ee:
        r7 = new java.lang.StringBuilder;
        r8 = "%s: ";
        r7.<init>(r8);
        r6 = r7.append(r6);
        r5 = r5.title;
        r5 = r6.append(r5);
        r5 = r5.toString();
    L_0x0904:
        r0 = r24;
        r0.value = r5;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x090e:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r6);
        r7 = r5.title;
        r4 = r4.append(r7);
        r4 = r4.toString();
        goto L_0x08dc;
    L_0x0922:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r6 = r7.append(r6);
        r5 = r5.title;
        r5 = r6.append(r5);
        r5 = r5.toString();
        goto L_0x0904;
    L_0x0936:
        r4 = com.tencent.mm.sdk.platformtools.bi.WT(r4);
        r4 = com.tencent.mm.y.g.a.gp(r4);
        if (r4 != 0) goto L_0x094e;
    L_0x0940:
        r4 = "MicroMsg.Notification.Wording";
        r5 = "decode msg content failed";
        com.tencent.mm.sdk.platformtools.x.e(r4, r5);
        r18 = "";
        goto L_0x0031;
    L_0x094e:
        r18 = "";
        r5 = com.tencent.mm.R.l.card_msg_item_digest;
        r0 = r23;
        r5 = r0.getString(r5);
        r6 = 1;
        r0 = r19;
        if (r0 != r6) goto L_0x099f;
    L_0x095e:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r4 = r4.dxM;
        r4 = r5.append(r4);
        r5 = r4.toString();
        r4 = r13.length();
        if (r4 <= 0) goto L_0x099d;
    L_0x0977:
        r4 = new java.lang.StringBuilder;
        r6 = "%s: ";
        r4.<init>(r6);
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0987:
        r0 = r24;
        r0.value = r4;
    L_0x098b:
        r4 = com.tencent.mm.model.s.hE(r20);
        if (r4 != 0) goto L_0x13dd;
    L_0x0991:
        if (r17 != 0) goto L_0x13dd;
    L_0x0993:
        r0 = r25;
        r0.value = r13;
        r6 = r15;
        r8 = r16;
        r9 = r5;
        goto L_0x0161;
    L_0x099d:
        r4 = r5;
        goto L_0x0987;
    L_0x099f:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r4 = r4.dxL;
        r4 = r5.append(r4);
        r5 = r4.toString();
        r4 = r13.length();
        if (r4 <= 0) goto L_0x09cd;
    L_0x09b8:
        r4 = new java.lang.StringBuilder;
        r6 = "%s: ";
        r4.<init>(r6);
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x09c8:
        r0 = r24;
        r0.value = r4;
        goto L_0x098b;
    L_0x09cd:
        r4 = r5;
        goto L_0x09c8;
    L_0x09cf:
        r4 = com.tencent.mm.sdk.platformtools.bi.WT(r4);
        r5 = com.tencent.mm.y.g.a.gp(r4);
        if (r5 != 0) goto L_0x09e7;
    L_0x09d9:
        r4 = "MicroMsg.Notification.Wording";
        r5 = "decode msg content failed";
        com.tencent.mm.sdk.platformtools.x.e(r4, r5);
        r18 = "";
        goto L_0x0031;
    L_0x09e7:
        r18 = "";
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0a38;
    L_0x09f0:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r6 = ": ";
        r4 = r4.append(r6);
        r6 = r5.title;
        r4 = r4.append(r6);
        r4 = r4.toString();
    L_0x0a0a:
        r6 = com.tencent.mm.model.s.hE(r20);
        if (r6 != 0) goto L_0x0a16;
    L_0x0a10:
        if (r17 != 0) goto L_0x0a16;
    L_0x0a12:
        r0 = r25;
        r0.value = r13;
    L_0x0a16:
        r6 = r13.length();
        if (r6 <= 0) goto L_0x0a3b;
    L_0x0a1c:
        r6 = new java.lang.StringBuilder;
        r7 = "%s: ";
        r6.<init>(r7);
        r5 = r5.title;
        r5 = r6.append(r5);
        r5 = r5.toString();
    L_0x0a2e:
        r0 = r24;
        r0.value = r5;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x0a38:
        r4 = r5.title;
        goto L_0x0a0a;
    L_0x0a3b:
        r5 = r5.title;
        goto L_0x0a2e;
    L_0x0a3e:
        r4 = com.tencent.mm.R.l.app_app;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0a7f;
    L_0x0a4c:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0a60:
        r5 = com.tencent.mm.model.s.hE(r20);
        if (r5 != 0) goto L_0x0a6c;
    L_0x0a66:
        if (r17 != 0) goto L_0x0a6c;
    L_0x0a68:
        r0 = r25;
        r0.value = r13;
    L_0x0a6c:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0a83;
    L_0x0a72:
        r5 = "%s: ";
    L_0x0a75:
        r0 = r24;
        r0.value = r5;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x0a7f:
        r4 = "";
        goto L_0x0a60;
    L_0x0a83:
        r5 = "";
        goto L_0x0a75;
    L_0x0a87:
        r4 = com.tencent.mm.sdk.platformtools.bi.WT(r4);
        r6 = com.tencent.mm.y.g.a.gp(r4);
        if (r6 != 0) goto L_0x0a9f;
    L_0x0a91:
        r4 = "MicroMsg.Notification.Wording";
        r5 = "decode msg content failed";
        com.tencent.mm.sdk.platformtools.x.e(r4, r5);
        r18 = "";
        goto L_0x0031;
    L_0x0a9f:
        r5 = r6.type;
        switch(r5) {
            case 1: goto L_0x0ab7;
            case 2: goto L_0x0b0e;
            case 3: goto L_0x0b57;
            case 4: goto L_0x0ba2;
            case 5: goto L_0x0c81;
            case 6: goto L_0x0bed;
            case 7: goto L_0x0c38;
            case 8: goto L_0x0d63;
            case 9: goto L_0x0aa4;
            case 10: goto L_0x0aa4;
            case 11: goto L_0x0aa4;
            case 12: goto L_0x0aa4;
            case 13: goto L_0x0aa4;
            case 14: goto L_0x0aa4;
            case 15: goto L_0x0da2;
            case 16: goto L_0x0f3e;
            case 17: goto L_0x0e20;
            case 18: goto L_0x0aa4;
            case 19: goto L_0x0e77;
            case 20: goto L_0x0aa4;
            case 21: goto L_0x0aa4;
            case 22: goto L_0x0aa4;
            case 23: goto L_0x0aa4;
            case 24: goto L_0x0ec0;
            case 25: goto L_0x0de1;
            case 26: goto L_0x0da2;
            case 27: goto L_0x0da2;
            case 28: goto L_0x0aa4;
            case 29: goto L_0x0aa4;
            case 30: goto L_0x0aa4;
            case 31: goto L_0x0aa4;
            case 32: goto L_0x0aa4;
            case 33: goto L_0x0cd4;
            case 34: goto L_0x0fad;
            case 35: goto L_0x0aa4;
            case 36: goto L_0x0cd4;
            case 37: goto L_0x0aa4;
            case 38: goto L_0x0aa4;
            case 39: goto L_0x0aa4;
            case 40: goto L_0x102e;
            default: goto L_0x0aa4;
        };
    L_0x0aa4:
        r4 = com.tencent.mm.R.l.app_app;
        r0 = r23;
        r4 = r0.getString(r4);
        r7 = "";
        r18 = r4;
        r6 = r15;
        r8 = r16;
        r9 = r7;
        goto L_0x0161;
    L_0x0ab7:
        r18 = "";
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0b08;
    L_0x0ac0:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r5 = r6.title;
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0ada:
        r5 = com.tencent.mm.model.s.hE(r20);
        if (r5 != 0) goto L_0x0ae6;
    L_0x0ae0:
        if (r17 != 0) goto L_0x0ae6;
    L_0x0ae2:
        r0 = r25;
        r0.value = r13;
    L_0x0ae6:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0b0b;
    L_0x0aec:
        r5 = new java.lang.StringBuilder;
        r7 = "%s: ";
        r5.<init>(r7);
        r6 = r6.title;
        r5 = r5.append(r6);
        r5 = r5.toString();
    L_0x0afe:
        r0 = r24;
        r0.value = r5;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x0b08:
        r4 = r6.title;
        goto L_0x0ada;
    L_0x0b0b:
        r5 = r6.title;
        goto L_0x0afe;
    L_0x0b0e:
        r4 = com.tencent.mm.R.l.app_pic;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0b4f;
    L_0x0b1c:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0b30:
        r5 = com.tencent.mm.model.s.hE(r20);
        if (r5 != 0) goto L_0x0b3c;
    L_0x0b36:
        if (r17 != 0) goto L_0x0b3c;
    L_0x0b38:
        r0 = r25;
        r0.value = r13;
    L_0x0b3c:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0b53;
    L_0x0b42:
        r5 = "%s: ";
    L_0x0b45:
        r0 = r24;
        r0.value = r5;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x0b4f:
        r4 = "";
        goto L_0x0b30;
    L_0x0b53:
        r5 = "";
        goto L_0x0b45;
    L_0x0b57:
        r4 = com.tencent.mm.R.l.app_music;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0b9a;
    L_0x0b65:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0b79:
        r5 = com.tencent.mm.model.s.hE(r20);
        if (r5 != 0) goto L_0x0b85;
    L_0x0b7f:
        if (r17 != 0) goto L_0x0b85;
    L_0x0b81:
        r0 = r25;
        r0.value = r13;
    L_0x0b85:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0b9e;
    L_0x0b8b:
        r5 = "%s: ";
    L_0x0b8e:
        r0 = r24;
        r0.value = r5;
        r7 = 1;
        r5 = r6.title;
        r6 = r5;
        r8 = r7;
        r9 = r4;
        goto L_0x0161;
    L_0x0b9a:
        r4 = "";
        goto L_0x0b79;
    L_0x0b9e:
        r5 = "";
        goto L_0x0b8e;
    L_0x0ba2:
        r4 = com.tencent.mm.R.l.app_video;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0be5;
    L_0x0bb0:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0bc4:
        r5 = com.tencent.mm.model.s.hE(r20);
        if (r5 != 0) goto L_0x0bd0;
    L_0x0bca:
        if (r17 != 0) goto L_0x0bd0;
    L_0x0bcc:
        r0 = r25;
        r0.value = r13;
    L_0x0bd0:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0be9;
    L_0x0bd6:
        r5 = "%s: ";
    L_0x0bd9:
        r0 = r24;
        r0.value = r5;
        r7 = 1;
        r5 = r6.title;
        r6 = r5;
        r8 = r7;
        r9 = r4;
        goto L_0x0161;
    L_0x0be5:
        r4 = "";
        goto L_0x0bc4;
    L_0x0be9:
        r5 = "";
        goto L_0x0bd9;
    L_0x0bed:
        r4 = com.tencent.mm.R.l.app_file;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0c30;
    L_0x0bfb:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0c0f:
        r5 = com.tencent.mm.model.s.hE(r20);
        if (r5 != 0) goto L_0x0c1b;
    L_0x0c15:
        if (r17 != 0) goto L_0x0c1b;
    L_0x0c17:
        r0 = r25;
        r0.value = r13;
    L_0x0c1b:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0c34;
    L_0x0c21:
        r5 = "%s: ";
    L_0x0c24:
        r0 = r24;
        r0.value = r5;
        r7 = 1;
        r5 = r6.title;
        r6 = r5;
        r8 = r7;
        r9 = r4;
        goto L_0x0161;
    L_0x0c30:
        r4 = "";
        goto L_0x0c0f;
    L_0x0c34:
        r5 = "";
        goto L_0x0c24;
    L_0x0c38:
        r4 = com.tencent.mm.R.l.app_app;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0c79;
    L_0x0c46:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0c5a:
        r5 = com.tencent.mm.model.s.hE(r20);
        if (r5 != 0) goto L_0x0c66;
    L_0x0c60:
        if (r17 != 0) goto L_0x0c66;
    L_0x0c62:
        r0 = r25;
        r0.value = r13;
    L_0x0c66:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0c7d;
    L_0x0c6c:
        r5 = "%s: ";
    L_0x0c6f:
        r0 = r24;
        r0.value = r5;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x0c79:
        r4 = "";
        goto L_0x0c5a;
    L_0x0c7d:
        r5 = "";
        goto L_0x0c6f;
    L_0x0c81:
        r4 = com.tencent.mm.R.l.app_url;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0ccc;
    L_0x0c8f:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0ca3:
        r5 = com.tencent.mm.model.s.hE(r20);
        if (r5 != 0) goto L_0x0cb5;
    L_0x0ca9:
        if (r17 != 0) goto L_0x0cb5;
    L_0x0cab:
        r5 = com.tencent.mm.model.s.hN(r20);
        if (r5 != 0) goto L_0x0cb5;
    L_0x0cb1:
        r0 = r25;
        r0.value = r13;
    L_0x0cb5:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0cd0;
    L_0x0cbb:
        r5 = "%s: ";
    L_0x0cbe:
        r0 = r24;
        r0.value = r5;
        r7 = 1;
        r5 = r6.getTitle();
        r6 = r5;
        r8 = r7;
        r9 = r4;
        goto L_0x0161;
    L_0x0ccc:
        r4 = "";
        goto L_0x0ca3;
    L_0x0cd0:
        r5 = "";
        goto L_0x0cbe;
    L_0x0cd4:
        r18 = "";
        r4 = com.tencent.mm.R.l.app_brand_default_name_with_brackets;
        r0 = r23;
        r5 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0d3b;
    L_0x0ce5:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r7 = ": ";
        r4 = r4.append(r7);
        r4 = r4.append(r5);
        r7 = r6.title;
        r4 = r4.append(r7);
        r4 = r4.toString();
    L_0x0d03:
        r7 = com.tencent.mm.model.s.hE(r20);
        if (r7 != 0) goto L_0x0d15;
    L_0x0d09:
        if (r17 != 0) goto L_0x0d15;
    L_0x0d0b:
        r7 = com.tencent.mm.model.s.hN(r20);
        if (r7 != 0) goto L_0x0d15;
    L_0x0d11:
        r0 = r25;
        r0.value = r13;
    L_0x0d15:
        r7 = r13.length();
        if (r7 <= 0) goto L_0x0d4f;
    L_0x0d1b:
        r7 = new java.lang.StringBuilder;
        r8 = "%s: ";
        r7.<init>(r8);
        r5 = r7.append(r5);
        r6 = r6.title;
        r5 = r5.append(r6);
        r5 = r5.toString();
    L_0x0d31:
        r0 = r24;
        r0.value = r5;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x0d3b:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r5);
        r7 = r6.title;
        r4 = r4.append(r7);
        r4 = r4.toString();
        goto L_0x0d03;
    L_0x0d4f:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r5 = r7.append(r5);
        r6 = r6.title;
        r5 = r5.append(r6);
        r5 = r5.toString();
        goto L_0x0d31;
    L_0x0d63:
        r4 = com.tencent.mm.R.l.app_emoji2;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0d9e;
    L_0x0d71:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0d85:
        r5 = com.tencent.mm.model.s.hE(r20);
        if (r5 != 0) goto L_0x0d91;
    L_0x0d8b:
        if (r17 != 0) goto L_0x0d91;
    L_0x0d8d:
        r0 = r25;
        r0.value = r13;
    L_0x0d91:
        r5 = "";
        r0 = r24;
        r0.value = r5;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x0d9e:
        r4 = "";
        goto L_0x0d85;
    L_0x0da2:
        r4 = com.tencent.mm.R.l.app_emoji_share;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0ddd;
    L_0x0db0:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0dc4:
        r5 = com.tencent.mm.model.s.hE(r20);
        if (r5 != 0) goto L_0x0dd0;
    L_0x0dca:
        if (r17 != 0) goto L_0x0dd0;
    L_0x0dcc:
        r0 = r25;
        r0.value = r13;
    L_0x0dd0:
        r5 = "";
        r0 = r24;
        r0.value = r5;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x0ddd:
        r4 = "";
        goto L_0x0dc4;
    L_0x0de1:
        r4 = com.tencent.mm.R.l.app_designer_share;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0e1c;
    L_0x0def:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0e03:
        r5 = com.tencent.mm.model.s.hE(r20);
        if (r5 != 0) goto L_0x0e0f;
    L_0x0e09:
        if (r17 != 0) goto L_0x0e0f;
    L_0x0e0b:
        r0 = r25;
        r0.value = r13;
    L_0x0e0f:
        r5 = "";
        r0 = r24;
        r0.value = r5;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x0e1c:
        r4 = "";
        goto L_0x0e03;
    L_0x0e20:
        r18 = "";
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0e71;
    L_0x0e29:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r5 = r6.title;
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0e43:
        r5 = com.tencent.mm.model.s.hE(r20);
        if (r5 != 0) goto L_0x0e4f;
    L_0x0e49:
        if (r17 != 0) goto L_0x0e4f;
    L_0x0e4b:
        r0 = r25;
        r0.value = r13;
    L_0x0e4f:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0e74;
    L_0x0e55:
        r5 = new java.lang.StringBuilder;
        r7 = "%s: ";
        r5.<init>(r7);
        r6 = r6.title;
        r5 = r5.append(r6);
        r5 = r5.toString();
    L_0x0e67:
        r0 = r24;
        r0.value = r5;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x0e71:
        r4 = r6.title;
        goto L_0x0e43;
    L_0x0e74:
        r5 = r6.title;
        goto L_0x0e67;
    L_0x0e77:
        r4 = com.tencent.mm.R.l.app_record;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0eb8;
    L_0x0e85:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0e99:
        r5 = com.tencent.mm.model.s.hE(r20);
        if (r5 != 0) goto L_0x0ea5;
    L_0x0e9f:
        if (r17 != 0) goto L_0x0ea5;
    L_0x0ea1:
        r0 = r25;
        r0.value = r13;
    L_0x0ea5:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0ebc;
    L_0x0eab:
        r5 = "%s: ";
    L_0x0eae:
        r0 = r24;
        r0.value = r5;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x0eb8:
        r4 = "";
        goto L_0x0e99;
    L_0x0ebc:
        r5 = "";
        goto L_0x0eae;
    L_0x0ec0:
        r4 = "";
        r5 = r6.description;
        r5 = com.tencent.mm.sdk.platformtools.bi.oW(r5);
        if (r5 != 0) goto L_0x0edd;
    L_0x0ecb:
        r4 = r6.description;
        r5 = "\n";
        r4 = r4.indexOf(r5);
        r5 = r6.description;
        r7 = 0;
        if (r4 <= 0) goto L_0x0f2f;
    L_0x0ed9:
        r4 = r5.substring(r7, r4);
    L_0x0edd:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = com.tencent.mm.R.l.favorite_wenote_msg;
        r0 = r23;
        r6 = r0.getString(r6);
        r5 = r5.append(r6);
        r4 = r5.append(r4);
        r18 = r4.toString();
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0f36;
    L_0x0efc:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0f10:
        r5 = com.tencent.mm.model.s.hE(r20);
        if (r5 != 0) goto L_0x0f1c;
    L_0x0f16:
        if (r17 != 0) goto L_0x0f1c;
    L_0x0f18:
        r0 = r25;
        r0.value = r13;
    L_0x0f1c:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0f3a;
    L_0x0f22:
        r5 = "%s: ";
    L_0x0f25:
        r0 = r24;
        r0.value = r5;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x0f2f:
        r4 = r6.description;
        r4 = r4.length();
        goto L_0x0ed9;
    L_0x0f36:
        r4 = "";
        goto L_0x0f10;
    L_0x0f3a:
        r5 = "";
        goto L_0x0f25;
    L_0x0f3e:
        r18 = "";
        r4 = com.tencent.mm.R.l.card_msg_item_digest;
        r0 = r23;
        r5 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0f99;
    L_0x0f4f:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r7 = ": ";
        r4 = r4.append(r7);
        r4 = r4.append(r5);
        r6 = r6.title;
        r4 = r4.append(r6);
        r4 = r4.toString();
    L_0x0f6d:
        r6 = com.tencent.mm.model.s.hE(r20);
        if (r6 != 0) goto L_0x0f79;
    L_0x0f73:
        if (r17 != 0) goto L_0x0f79;
    L_0x0f75:
        r0 = r25;
        r0.value = r13;
    L_0x0f79:
        r6 = r13.length();
        if (r6 <= 0) goto L_0x0f8f;
    L_0x0f7f:
        r6 = new java.lang.StringBuilder;
        r7 = "%s: ";
        r6.<init>(r7);
        r5 = r6.append(r5);
        r5 = r5.toString();
    L_0x0f8f:
        r0 = r24;
        r0.value = r5;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x0f99:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r5);
        r6 = r6.title;
        r4 = r4.append(r6);
        r4 = r4.toString();
        goto L_0x0f6d;
    L_0x0fad:
        r18 = "";
        r4 = com.tencent.mm.R.l.card_msg_item_digest;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = 1;
        r0 = r19;
        if (r0 != r5) goto L_0x0ffe;
    L_0x0fbd:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r4 = r5.append(r4);
        r5 = r6.dxM;
        r4 = r4.append(r5);
        r5 = r4.toString();
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0ffc;
    L_0x0fd6:
        r4 = new java.lang.StringBuilder;
        r6 = "%s: ";
        r4.<init>(r6);
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0fe6:
        r0 = r24;
        r0.value = r4;
    L_0x0fea:
        r4 = com.tencent.mm.model.s.hE(r20);
        if (r4 != 0) goto L_0x13dd;
    L_0x0ff0:
        if (r17 != 0) goto L_0x13dd;
    L_0x0ff2:
        r0 = r25;
        r0.value = r13;
        r6 = r15;
        r8 = r16;
        r9 = r5;
        goto L_0x0161;
    L_0x0ffc:
        r4 = r5;
        goto L_0x0fe6;
    L_0x0ffe:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r4 = r5.append(r4);
        r5 = r6.dxL;
        r4 = r4.append(r5);
        r5 = r4.toString();
        r4 = r13.length();
        if (r4 <= 0) goto L_0x102c;
    L_0x1017:
        r4 = new java.lang.StringBuilder;
        r6 = "%s: ";
        r4.<init>(r6);
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x1027:
        r0 = r24;
        r0.value = r4;
        goto L_0x0fea;
    L_0x102c:
        r4 = r5;
        goto L_0x1027;
    L_0x102e:
        r4 = com.tencent.mm.y.k.gv(r4);
        r4 = r4.dzv;
        r5 = 19;
        if (r4 != r5) goto L_0x1048;
    L_0x1038:
        r4 = com.tencent.mm.R.l.app_record;
        r0 = r23;
        r4 = r0.getString(r4);
        r18 = r4;
        r6 = r15;
        r8 = r16;
        r9 = r7;
        goto L_0x0161;
    L_0x1048:
        r4 = com.tencent.mm.R.l.app_app;
        r0 = r23;
        r4 = r0.getString(r4);
        r18 = r4;
        r6 = r15;
        r8 = r16;
        r9 = r7;
        goto L_0x0161;
    L_0x1058:
        if (r11 == 0) goto L_0x105e;
    L_0x105a:
        r7 = eT(r7);
    L_0x105e:
        r4 = com.tencent.mm.plugin.biz.a.a.class;
        r4 = com.tencent.mm.kernel.g.l(r4);
        r4 = (com.tencent.mm.plugin.biz.a.a) r4;
        r4 = r4.gs(r7);
        r4 = eS(r4);
        r0 = r24;
        r0.value = r4;
        r18 = r14;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x107a:
        r4 = com.tencent.mm.plugin.biz.a.a.class;
        r4 = com.tencent.mm.kernel.g.l(r4);
        r4 = (com.tencent.mm.plugin.biz.a.a) r4;
        r4 = r4.wR(r7);
        r0 = r24;
        r0.value = r4;
        r0 = r24;
        r4 = r0.value;
        r5 = "MicroMsg.Notification.Wording";
        r6 = "[parseMsgContentToShow] type:%s suffix:%s";
        r7 = 2;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = 318767153; // 0x13000031 float:1.6155966E-27 double:1.574918993E-315;
        r9 = java.lang.Integer.valueOf(r9);
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);
        r7 = "";
        r18 = r4;
        r6 = r15;
        r8 = r16;
        r9 = r7;
        goto L_0x0161;
    L_0x10b2:
        r4 = com.tencent.mm.ad.a.a.ln(r7);
        r4 = com.tencent.mm.ad.a.b(r4);
        r0 = r24;
        r0.value = r4;
        r18 = r14;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x10c6:
        r7 = "";
        r4 = com.tencent.mm.y.g.a.gp(r4);
        if (r4 == 0) goto L_0x015b;
    L_0x10cf:
        r4 = r4.content;	 Catch:{ Exception -> 0x10e8 }
        r5 = "UTF-8";
        r7 = java.net.URLDecoder.decode(r4, r5);	 Catch:{ Exception -> 0x10e8 }
        r4 = com.tencent.mm.pluginsdk.ui.d.j.TT(r7);	 Catch:{ Exception -> 0x10e8 }
        r0 = r24;
        r0.value = r4;	 Catch:{ Exception -> 0x13d8 }
        r18 = r14;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x10e8:
        r5 = move-exception;
        r4 = r7;
    L_0x10ea:
        r6 = "MicroMsg.Notification.Wording";
        r7 = "";
        r8 = 0;
        r8 = new java.lang.Object[r8];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r6, r5, r7, r8);
        r18 = r14;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x10fe:
        r4 = com.tencent.mm.plugin.messenger.a.e.class;
        r4 = com.tencent.mm.kernel.g.l(r4);
        r4 = (com.tencent.mm.plugin.messenger.a.e) r4;
        r4 = r4.Gu(r7);
        if (r4 == 0) goto L_0x111c;
    L_0x110c:
        r4 = r4.toString();
    L_0x1110:
        r0 = r24;
        r0.value = r4;
        r18 = r14;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x111c:
        r4 = "";
        goto L_0x1110;
    L_0x1120:
        r4 = com.tencent.mm.y.a.a.gw(r7);
        r4 = r4.content;
        r5 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r5 == 0) goto L_0x112f;
    L_0x112c:
        r4 = "";
    L_0x112f:
        r0 = r24;
        r0.value = r4;
        r18 = r14;
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x113b:
        r4 = "@bottle:";
        r4 = r9.split(r4);
        r5 = r4.length;
        r6 = 1;
        if (r5 <= r6) goto L_0x1152;
    L_0x1146:
        r5 = 1;
        r5 = r4[r5];
        r0 = r24;
        r0.value = r5;
        r5 = 1;
        r18 = r4[r5];
        goto L_0x0031;
    L_0x1152:
        r4 = "";
        r0 = r24;
        r0.value = r4;
        r18 = 0;
        goto L_0x0031;
    L_0x115d:
        r4 = 0;
        r5 = ":";
        r5 = r9.split(r5);
        if (r5 == 0) goto L_0x116a;
    L_0x1167:
        r6 = r5.length;
        if (r6 > 0) goto L_0x1175;
    L_0x116a:
        r4 = "";
        r0 = r24;
        r0.value = r4;
        r18 = 0;
        goto L_0x0031;
    L_0x1175:
        r6 = 0;
        r5 = r5[r6];
        r6 = com.tencent.mm.sdk.platformtools.bi.oW(r5);
        if (r6 != 0) goto L_0x11a1;
    L_0x117e:
        com.tencent.mm.model.au.HU();
        r6 = com.tencent.mm.model.c.FR();
        r5 = r6.Yg(r5);
        if (r5 == 0) goto L_0x1195;
    L_0x118b:
        r6 = r5.getCity();
        if (r6 == 0) goto L_0x1195;
    L_0x1191:
        r4 = r5.getCity();
    L_0x1195:
        if (r4 == 0) goto L_0x119d;
    L_0x1197:
        r6 = r4.length();
        if (r6 > 0) goto L_0x11a1;
    L_0x119d:
        r4 = r5.getProvince();
    L_0x11a1:
        r5 = com.tencent.mm.sdk.platformtools.bi.oW(r18);
        if (r5 != 0) goto L_0x11e1;
    L_0x11a7:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r5 = r5.append(r4);
        r6 = ": ";
        r5 = r5.append(r6);
        r0 = r18;
        r5 = r5.append(r0);
        r5 = r5.toString();
        r0 = r24;
        r0.value = r5;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r4 = r5.append(r4);
        r5 = ": ";
        r4 = r4.append(r5);
        r0 = r18;
        r4 = r4.append(r0);
        r18 = r4.toString();
        goto L_0x0031;
    L_0x11e1:
        r5 = "@bottle:";
        r5 = r9.split(r5);
        r6 = r5.length;
        r7 = 1;
        if (r6 <= r7) goto L_0x1228;
    L_0x11ec:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r6 = r6.append(r4);
        r7 = ": ";
        r6 = r6.append(r7);
        r7 = 1;
        r7 = r5[r7];
        r6 = r6.append(r7);
        r6 = r6.toString();
        r0 = r24;
        r0.value = r6;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r4 = r6.append(r4);
        r6 = ": ";
        r4 = r4.append(r6);
        r6 = 1;
        r5 = r5[r6];
        r4 = r4.append(r5);
        r18 = r4.toString();
        goto L_0x0031;
    L_0x1228:
        r0 = r24;
        r0.value = r4;
        r18 = r4;
        goto L_0x0031;
    L_0x1230:
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r9);
        if (r4 == 0) goto L_0x123d;
    L_0x1236:
        r4 = "";
        r0 = r24;
        r0.value = r4;
    L_0x123d:
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r13);
        if (r4 != 0) goto L_0x12f9;
    L_0x1243:
        if (r12 == 0) goto L_0x124f;
    L_0x1245:
        r4 = r12.length();
        if (r4 <= 0) goto L_0x124f;
    L_0x124b:
        r9 = j(r9, r13, r12);
    L_0x124f:
        r0 = r25;
        r4 = r0.value;
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r4 == 0) goto L_0x126c;
    L_0x1259:
        r0 = r24;
        r4 = r0.value;
        r5 = "%s";
        r4 = j(r4, r13, r5);
        r0 = r24;
        r0.value = r4;
        r0 = r25;
        r0.value = r13;
    L_0x126c:
        r4 = com.tencent.mm.compatible.util.n.fi(r9);
        r0 = r24;
        r5 = r0.value;
        r5 = com.tencent.mm.compatible.util.n.fi(r5);
        r0 = r24;
        r0.value = r5;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r4 = r5.append(r4);
        r0 = r18;
        r4 = r4.append(r0);
        r4 = r4.toString();
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r0 = r24;
        r7 = r0.value;
        r5 = r5.append(r7);
        r0 = r18;
        r5 = r5.append(r0);
        r5 = r5.toString();
        r0 = r24;
        r0.value = r5;
        if (r27 == 0) goto L_0x12d7;
    L_0x12ac:
        r0 = r24;
        r5 = r0.value;
        r5 = r5.length();
        r7 = 32;
        if (r5 != r7) goto L_0x12f7;
    L_0x12b8:
        r5 = 47;
        r0 = r22;
        if (r0 == r5) goto L_0x12c5;
    L_0x12be:
        r5 = 1048625; // 0x100031 float:1.469437E-39 double:5.180896E-318;
        r0 = r22;
        if (r0 != r5) goto L_0x12f7;
    L_0x12c5:
        r0 = r24;
        r0.value = r4;
        r5 = 1;
    L_0x12ca:
        if (r5 != 0) goto L_0x12d7;
    L_0x12cc:
        r0 = r22;
        r1 = r24;
        r2 = r25;
        r3 = r26;
        a(r0, r1, r2, r3);
    L_0x12d7:
        if (r8 == 0) goto L_0x12f1;
    L_0x12d9:
        r5 = new java.lang.StringBuilder;
        r7 = " ";
        r5.<init>(r7);
        r6 = com.tencent.mm.sdk.platformtools.bi.oV(r6);
        r5 = r5.append(r6);
        r5 = r5.toString();
        r4 = r4.concat(r5);
    L_0x12f1:
        r18 = com.tencent.mm.sdk.platformtools.bi.oV(r4);
        goto L_0x0031;
    L_0x12f7:
        r5 = 0;
        goto L_0x12ca;
    L_0x12f9:
        r4 = com.tencent.mm.model.s.hE(r20);
        if (r4 != 0) goto L_0x1307;
    L_0x12ff:
        if (r17 != 0) goto L_0x1307;
    L_0x1301:
        r4 = com.tencent.mm.model.s.hN(r20);
        if (r4 == 0) goto L_0x13b9;
    L_0x1307:
        if (r18 == 0) goto L_0x1311;
    L_0x1309:
        r4 = r18.length();
        if (r4 <= 0) goto L_0x1311;
    L_0x130f:
        r9 = r18;
    L_0x1311:
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r9);
        if (r4 == 0) goto L_0x132a;
    L_0x1317:
        r4 = "";
        r0 = r24;
        r0.value = r4;
        r4 = "";
        r0 = r25;
        r0.value = r4;
        r18 = "";
        goto L_0x0031;
    L_0x132a:
        if (r19 != 0) goto L_0x1372;
    L_0x132c:
        r4 = new java.lang.StringBuilder;
        r5 = "%s:";
        r4.<init>(r5);
        r4 = r4.append(r9);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
    L_0x1340:
        if (r27 == 0) goto L_0x1397;
    L_0x1342:
        r0 = r22;
        r1 = r24;
        r2 = r25;
        r3 = r26;
        a(r0, r1, r2, r3);
        r4 = r9;
    L_0x134e:
        if (r8 == 0) goto L_0x1366;
    L_0x1350:
        if (r6 == 0) goto L_0x1366;
    L_0x1352:
        r5 = new java.lang.StringBuilder;
        r7 = " ";
        r5.<init>(r7);
        r5 = r5.append(r6);
        r5 = r5.toString();
        r4 = r4.concat(r5);
    L_0x1366:
        if (r11 == 0) goto L_0x136c;
    L_0x1368:
        r4 = eT(r4);
    L_0x136c:
        r18 = com.tencent.mm.sdk.platformtools.bi.oV(r4);
        goto L_0x0031;
    L_0x1372:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = com.tencent.mm.R.l.app_me;
        r0 = r23;
        r5 = r0.getString(r5);
        r4 = r4.append(r5);
        r5 = ":";
        r4 = r4.append(r5);
        r4 = r4.append(r9);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
        goto L_0x1340;
    L_0x1397:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = r25;
        r5 = r0.value;
        r5 = com.tencent.mm.model.r.gT(r5);
        r4 = r4.append(r5);
        r5 = ":";
        r4 = r4.append(r5);
        r4 = r4.append(r9);
        r18 = r4.toString();
        goto L_0x0031;
    L_0x13b9:
        if (r18 == 0) goto L_0x13db;
    L_0x13bb:
        r4 = r18.length();
        if (r4 <= 0) goto L_0x13db;
    L_0x13c1:
        r0 = r18;
        r1 = r24;
        r1.value = r0;
        r4 = r18;
    L_0x13c9:
        if (r27 == 0) goto L_0x134e;
    L_0x13cb:
        r0 = r22;
        r1 = r24;
        r2 = r25;
        r3 = r26;
        a(r0, r1, r2, r3);
        goto L_0x134e;
    L_0x13d8:
        r5 = move-exception;
        goto L_0x10ea;
    L_0x13db:
        r4 = r9;
        goto L_0x13c9;
    L_0x13dd:
        r6 = r15;
        r8 = r16;
        r9 = r5;
        goto L_0x0161;
    L_0x13e3:
        r6 = r15;
        r8 = r16;
        r9 = r4;
        goto L_0x0161;
    L_0x13e9:
        r4 = r20;
        goto L_0x05d4;
    L_0x13ed:
        r5 = r20;
        goto L_0x05d8;
    L_0x13f1:
        r17 = r5;
        r7 = r21;
        goto L_0x0158;
    L_0x13f7:
        r4 = r21;
        r12 = r5;
        r13 = r6;
        goto L_0x0128;
    L_0x13fd:
        r11 = r4;
        goto L_0x00e5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.booter.notification.a.h.a(java.lang.String, int, java.lang.String, java.lang.String, int, android.content.Context, com.tencent.mm.pointers.PString, com.tencent.mm.pointers.PString, com.tencent.mm.pointers.PInt, boolean, boolean):java.lang.String");
    }

    private static String a(Context context, int i, String str, String str2, String str3, PString pString, PString pString2) {
        StringBuilder append;
        String str4 = "";
        if (s.hk(str) || s.hm(str)) {
            if (str2 != null) {
                int indexOf = str2.indexOf(":");
                if (indexOf >= 0 && indexOf < str2.length()) {
                    String substring = str2.substring(0, indexOf);
                    if (ab.XO(substring) || ab.XQ(substring)) {
                        str4 = r.gT(substring);
                        pString2.value = substring;
                        str2 = str2.substring(indexOf + 1);
                    }
                }
            }
        } else if (ab.XO(str) || ab.XQ(str)) {
            r.gT(str);
            pString2.value = str;
            if (i == 1) {
                append = new StringBuilder().append(context.getString(R.l.fmt_response_to, new Object[]{""}));
                if (str3 != null) {
                    str2 = str3;
                }
                pString.value = append.append(str2).toString();
                pString2.value = "";
                return pString.value;
            }
            if (str3 != null) {
                str2 = str3;
            }
            pString.value = str2;
            pString2.value = "";
            return pString.value;
        }
        if (bi.oV(str4).length() <= 0) {
            if (str3 != null) {
                str2 = str3;
            }
            pString.value = str2;
            return pString.value;
        }
        pString.value = context.getString(i == 1 ? R.l.fmt_response_to : R.l.fmt_send_from) + (str3 == null ? str2 : str3);
        append = new StringBuilder().append(context.getString(i == 1 ? R.l.fmt_response_to : R.l.fmt_send_from, new Object[]{str4}));
        if (str3 != null) {
            str2 = str3;
        }
        return append.append(str2).toString();
    }

    private static String eS(String str) {
        if (str != null) {
            return str.replaceAll("%", "%%");
        }
        return str;
    }

    private static String j(String str, String str2, String str3) {
        if (bi.oW(str) || bi.oW(str2) || bi.oW(str3)) {
            return str;
        }
        int indexOf = str.indexOf(str2);
        return indexOf >= 0 ? str.substring(0, indexOf) + str3 + str.substring(indexOf + str2.length()) : str;
    }

    private static String eT(String str) {
        if (str != null) {
            return str.replaceAll("%%", "%");
        }
        return str;
    }

    public static String eU(String str) {
        if (str == null) {
            return "";
        }
        return str.length() >= 150 ? str.substring(0, 150) + "..." : str;
    }

    private static void a(int i, PString pString, PString pString2, PInt pInt) {
        int i2 = 150;
        if (pString.value.length() != 32 || (i != 47 && i != 1048625)) {
            if (pString.value.length() >= 150) {
                String str = pString.value;
                String str2 = pString.value;
                while (i2 < str2.length()) {
                    if (str2.charAt(i2) != '%') {
                        break;
                    }
                    i2++;
                }
                i2 = str2.length();
                pString.value = str.substring(0, i2);
            }
            TextPaint textPaint = cZJ == null ? null : (TextPaint) cZJ.get();
            if (pString.value.replace("%%", "").contains("%s") || textPaint == null) {
                pInt.value = 0;
                return;
            }
            CharSequence format;
            try {
                format = String.format(pString.value, new Object[]{pString2.value});
            } catch (Exception e) {
                format = pString.value;
            }
            pString.value = TextUtils.ellipsize(format, textPaint, (float) (cZK > 0 ? cZK : BackwardSupportUtil.b.b(ad.getContext(), 200.0f)), TruncateAt.END).toString();
            pInt.value = 1;
        }
    }

    public static void fz(int i) {
        cZK = i;
    }

    public static void fA(int i) {
        cZL = i;
    }

    public static void a(TextPaint textPaint) {
        if (cZJ == null || cZJ.get() == null) {
            cZJ = new WeakReference(textPaint);
        }
    }

    public static String c(Context context, String str, boolean z) {
        return z ? b.cjC().Xw(str) : context.getString(R.l.intro_title);
    }

    public static String a(Context context, String str, int i, int i2, int i3, boolean z) {
        if (z) {
            String Xw = b.cjC().Xw(str);
            if (i3 <= 1) {
                return Xw;
            }
            return context.getResources().getQuantityString(R.j.notification_fmt_multi_msg_and_one_talker_pre, i3, new Object[]{Integer.valueOf(i3)}) + Xw;
        }
        return context.getResources().getQuantityString(R.j.notification_fmt_multi_msg_and_talker, i, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public static String d(Context context, String str, boolean z) {
        if (z) {
            return b.cjC().Xw(str);
        }
        return context.getString(R.l.notification_sample_ticker);
    }
}
