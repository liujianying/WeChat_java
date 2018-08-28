package com.tencent.mm.plugin.fav.ui.b;

import android.content.Context;
import android.os.Looper;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import java.util.List;
import java.util.regex.Pattern;

public final class a extends com.tencent.mm.plugin.fts.a.d.a.a {
    private static final ag handler = new ag(Looper.getMainLooper());
    private static final String jdY = ad.getContext().getString(i.fts_message_location_tag);
    private static final Pattern jdZ = Pattern.compile("['\r\n' | '\n']+");
    public String eTp;
    public l fyJ;
    public CharSequence jea;
    public CharSequence jeb;
    public CharSequence jec;
    public String jed;
    public int jee;
    private b jef = new b(this);
    a jeg = new a(this);

    public static void a(TextView textView, TextView textView2, CharSequence charSequence, CharSequence charSequence2) {
        if (m.a(charSequence, textView)) {
            if (m.a(charSequence2, textView2)) {
                textView.setMaxLines(1);
                textView2.setMaxLines(1);
                return;
            }
            textView.setMaxLines(2);
        } else if (m.a(charSequence2, textView2)) {
            textView2.setMaxLines(2);
        }
    }

    public a(int i) {
        super(7, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r13, com.tencent.mm.plugin.fts.a.d.a.a.a r14, java.lang.Object... r15) {
        /*
        r12 = this;
        r2 = 0;
        r11 = 2;
        r6 = -1;
        r5 = 0;
        r4 = 1;
        r0 = r12.fyJ;
        r0 = r0.jsA;
        r3 = new com.tencent.mm.g.a.fz;
        r3.<init>();
        r7 = r3.bOL;
        r8 = 9;
        r7.type = r8;
        r7 = r3.bOL;
        r7.bJA = r0;
        r0 = com.tencent.mm.sdk.b.a.sFg;
        r0.m(r3);
        r0 = r3.bOM;
        r8 = r0.bOY;
        r0 = r12.fyJ;
        r0 = r0.jsA;
        r3 = new com.tencent.mm.g.a.fz;
        r3.<init>();
        r7 = r3.bOL;
        r9 = 11;
        r7.type = r9;
        r7 = r3.bOL;
        r7.bJA = r0;
        r0 = r3.bOL;
        r1 = handler;
        r0.handler = r1;
        r0 = com.tencent.mm.sdk.b.a.sFg;
        r0.m(r3);
        r0 = r3.bOM;
        r0 = r0.bOX;
        r1 = "";
        r0 = com.tencent.mm.sdk.platformtools.bi.aG(r0, r1);
        r12.jed = r0;
        r0 = r3.bOM;
        r0 = r0.thumbUrl;
        r1 = "";
        r0 = com.tencent.mm.sdk.platformtools.bi.aG(r0, r1);
        r12.eTp = r0;
        r1 = r12.fyJ;
        r0 = com.tencent.mm.plugin.fts.ui.b.a.jvq;
        r0 = r0 * 2;
        r3 = (float) r0;
        r7 = r8.bXO;
        r0 = "";
        r9 = r8.type;
        switch(r9) {
            case 1: goto L_0x00d0;
            case 2: goto L_0x00e0;
            case 3: goto L_0x0115;
            case 4: goto L_0x0109;
            case 5: goto L_0x006a;
            case 6: goto L_0x00eb;
            case 7: goto L_0x0179;
            case 8: goto L_0x006a;
            case 9: goto L_0x006a;
            case 10: goto L_0x0121;
            case 11: goto L_0x0121;
            case 12: goto L_0x006a;
            case 13: goto L_0x006a;
            case 14: goto L_0x012b;
            case 15: goto L_0x006a;
            case 16: goto L_0x019f;
            default: goto L_0x006a;
        };
    L_0x006a:
        r0 = r8.title;
    L_0x006c:
        r1 = r1.jru;
        switch(r1) {
            case 1: goto L_0x01ab;
            case 2: goto L_0x01ab;
            case 3: goto L_0x01ab;
            case 4: goto L_0x01ab;
            case 5: goto L_0x01ab;
            case 6: goto L_0x01ab;
            default: goto L_0x0071;
        };
    L_0x0071:
        r12.jea = r0;
        r1 = r12.fyJ;
        r3 = r8.bXO;
        r0 = "";
        r7 = r8.type;
        switch(r7) {
            case 2: goto L_0x01cd;
            case 3: goto L_0x007f;
            case 4: goto L_0x007f;
            case 5: goto L_0x01bb;
            case 6: goto L_0x01d1;
            case 7: goto L_0x01bb;
            case 8: goto L_0x007f;
            case 9: goto L_0x007f;
            case 10: goto L_0x01ef;
            case 11: goto L_0x01ef;
            case 12: goto L_0x01bb;
            case 13: goto L_0x007f;
            case 14: goto L_0x01f9;
            case 15: goto L_0x01bb;
            default: goto L_0x007f;
        };
    L_0x007f:
        r0 = "";
    L_0x0082:
        r1 = r1.jru;
        switch(r1) {
            case 6: goto L_0x0226;
            case 7: goto L_0x020f;
            case 8: goto L_0x020f;
            case 23: goto L_0x01fe;
            default: goto L_0x0087;
        };
    L_0x0087:
        r1 = "";
        r3 = r6;
        r7 = r0;
    L_0x008c:
        if (r3 == r6) goto L_0x03c9;
    L_0x008e:
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r7);
        if (r0 != 0) goto L_0x03c9;
    L_0x0094:
        r0 = new java.lang.CharSequence[r11];
        r6 = r13.getResources();
        r3 = r6.getString(r3);
        r0[r5] = r3;
        r0[r4] = r1;
        r0 = android.text.TextUtils.concat(r0);
    L_0x00a6:
        r12.jeb = r0;
        r6 = r12.fyJ;
        r3 = r8.bSS;
        r0 = r8.rBs;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r3);
        if (r1 == 0) goto L_0x03c6;
    L_0x00b4:
        r1 = r2;
        r3 = r0;
    L_0x00b6:
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r3);
        if (r0 == 0) goto L_0x0236;
    L_0x00bc:
        r0 = new android.text.SpannableString;
        r1 = "";
        r0.<init>(r1);
    L_0x00c4:
        r12.jec = r0;
        r0 = r8.type;
        switch(r0) {
            case 3: goto L_0x03a4;
            case 4: goto L_0x03a8;
            case 5: goto L_0x03a0;
            case 6: goto L_0x03ac;
            case 7: goto L_0x00cb;
            case 8: goto L_0x037e;
            default: goto L_0x00cb;
        };
    L_0x00cb:
        r0 = com.tencent.mm.plugin.fav.ui.m.h.fts_default_img;
    L_0x00cd:
        r12.jee = r0;
        return;
    L_0x00d0:
        r0 = jdZ;
        r7 = r8.desc;
        r0 = r0.matcher(r7);
        r7 = " ";
        r0 = r0.replaceAll(r7);
        goto L_0x006c;
    L_0x00e0:
        r0 = r13.getResources();
        r7 = com.tencent.mm.plugin.fav.ui.m.i.search_favorite_img_tips;
        r0 = r0.getString(r7);
        goto L_0x006c;
    L_0x00eb:
        r0 = r8.bXO;
        r0 = r0.rAL;
        r7 = jdY;
        r9 = r0.bWB;
        r7 = r7.equals(r9);
        if (r7 != 0) goto L_0x0101;
    L_0x00f9:
        r7 = r0.bWB;
        r7 = com.tencent.mm.sdk.platformtools.bi.oW(r7);
        if (r7 == 0) goto L_0x0105;
    L_0x0101:
        r0 = r0.label;
        goto L_0x006c;
    L_0x0105:
        r0 = r0.bWB;
        goto L_0x006c;
    L_0x0109:
        r0 = r13.getResources();
        r7 = com.tencent.mm.plugin.fav.ui.m.i.search_favorite_video_tips;
        r0 = r0.getString(r7);
        goto L_0x006c;
    L_0x0115:
        r0 = r13.getResources();
        r7 = com.tencent.mm.plugin.fav.ui.m.i.search_favorite_voice_tips;
        r0 = r0.getString(r7);
        goto L_0x006c;
    L_0x0121:
        r9 = r7.rAP;
        if (r9 == 0) goto L_0x006c;
    L_0x0125:
        r0 = r7.rAP;
        r0 = r0.title;
        goto L_0x006c;
    L_0x012b:
        r9 = new java.lang.StringBuffer;
        r9.<init>();
        r0 = r7.rBI;
        r7 = r0.iterator();
    L_0x0136:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x0156;
    L_0x013c:
        r0 = r7.next();
        r0 = (com.tencent.mm.protocal.c.vx) r0;
        r0 = com.tencent.mm.plugin.fav.a.b.a(r0);
        r10 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r10 != 0) goto L_0x0136;
    L_0x014c:
        r9.append(r0);
        r0 = " ";
        r9.append(r0);
        goto L_0x0136;
    L_0x0156:
        r0 = jdZ;
        r7 = r9.toString();
        r0 = r0.matcher(r7);
        r7 = " ";
        r0 = r0.replaceAll(r7);
        r7 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r7 == 0) goto L_0x006c;
    L_0x016d:
        r0 = r13.getResources();
        r7 = com.tencent.mm.plugin.fav.ui.m.i.search_favorite_record_tips;
        r0 = r0.getString(r7);
        goto L_0x006c;
    L_0x0179:
        r0 = r8.title;
        r7 = r8.desc;
        r7 = com.tencent.mm.sdk.platformtools.bi.oW(r7);
        if (r7 != 0) goto L_0x006c;
    L_0x0183:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r0 = r7.append(r0);
        r7 = "-";
        r0 = r0.append(r7);
        r7 = r8.desc;
        r0 = r0.append(r7);
        r0 = r0.toString();
        goto L_0x006c;
    L_0x019f:
        r0 = r13.getResources();
        r7 = com.tencent.mm.plugin.fav.ui.m.i.search_favorite_sight_tips;
        r0 = r0.getString(r7);
        goto L_0x006c;
    L_0x01ab:
        r1 = r12.jrx;
        r7 = com.tencent.mm.plugin.fts.ui.b$c.jvz;
        r0 = com.tencent.mm.plugin.fts.a.a.d.a(r0, r1, r3, r7);
        r0 = com.tencent.mm.plugin.fts.a.f.a(r0);
        r0 = r0.jrO;
        goto L_0x0071;
    L_0x01bb:
        r3 = r8.appId;
        r3 = com.tencent.mm.sdk.platformtools.bi.oW(r3);
        if (r3 != 0) goto L_0x0082;
    L_0x01c3:
        r0 = com.tencent.mm.model.ac.a.dBp;
        r3 = r8.appId;
        r0 = r0.q(r13, r3);
        goto L_0x0082;
    L_0x01cd:
        r0 = r8.title;
        goto L_0x0082;
    L_0x01d1:
        r0 = r8.bXO;
        r0 = r0.rAL;
        r3 = jdY;
        r7 = r0.bWB;
        r3 = r3.equals(r7);
        if (r3 != 0) goto L_0x01e7;
    L_0x01df:
        r3 = r0.bWB;
        r3 = com.tencent.mm.sdk.platformtools.bi.oW(r3);
        if (r3 == 0) goto L_0x01eb;
    L_0x01e7:
        r0 = r0.label;
        goto L_0x0082;
    L_0x01eb:
        r0 = r0.bWB;
        goto L_0x0082;
    L_0x01ef:
        r7 = r3.rAP;
        if (r7 == 0) goto L_0x0082;
    L_0x01f3:
        r0 = r3.rAP;
        r0 = r0.desc;
        goto L_0x0082;
    L_0x01f9:
        r0 = "";
        goto L_0x0082;
    L_0x01fe:
        r3 = com.tencent.mm.plugin.fav.ui.m.i.search_favorite_img_orc_tips;
        r1 = r12.jrx;
        r1 = com.tencent.mm.plugin.fts.a.a.d.a(r0, r1);
        r1 = com.tencent.mm.plugin.fts.a.f.a(r1);
        r1 = r1.jrO;
        r7 = r0;
        goto L_0x008c;
    L_0x020f:
        r0 = com.tencent.mm.plugin.fav.ui.m.i.search_favorite_label_tips;
        r1 = r8.rBt;
        r7 = r12.bg(r1);
        r1 = r12.jrx;
        r1 = com.tencent.mm.plugin.fts.a.a.d.a(r7, r1);
        r1 = com.tencent.mm.plugin.fts.a.f.a(r1);
        r1 = r1.jrO;
        r3 = r0;
        goto L_0x008c;
    L_0x0226:
        r1 = r12.jrx;
        r1 = com.tencent.mm.plugin.fts.a.a.d.a(r0, r1);
        r1 = com.tencent.mm.plugin.fts.a.f.a(r1);
        r1 = r1.jrO;
        r3 = r6;
        r7 = r0;
        goto L_0x008c;
    L_0x0236:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
        r0 = r0.FR();
        r9 = r0.Yg(r3);
        r9.setUsername(r3);
        r0 = com.tencent.mm.model.s.fq(r3);
        if (r0 == 0) goto L_0x0268;
    L_0x024f:
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r0 != 0) goto L_0x0268;
    L_0x0255:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
        r0 = r0.FR();
        r2 = r0.Yg(r1);
        r2.setUsername(r1);
    L_0x0268:
        r0 = r6.jru;
        switch(r0) {
            case 9: goto L_0x03bb;
            case 10: goto L_0x03b9;
            case 11: goto L_0x0360;
            case 12: goto L_0x03c2;
            case 13: goto L_0x03b3;
            case 14: goto L_0x02c2;
            case 15: goto L_0x026d;
            case 16: goto L_0x03bb;
            case 17: goto L_0x03b9;
            case 18: goto L_0x0360;
            case 19: goto L_0x026d;
            case 20: goto L_0x03be;
            case 21: goto L_0x03b6;
            case 22: goto L_0x02f3;
            default: goto L_0x026d;
        };
    L_0x026d:
        r1 = r5;
        r3 = r5;
        r7 = r5;
    L_0x0270:
        if (r2 == 0) goto L_0x0366;
    L_0x0272:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = a(r2, r4);
        r0 = r0.append(r2);
        r2 = "-";
        r0 = r0.append(r2);
        r2 = c(r13, r9);
        r0 = r0.append(r2);
        r2 = r0.toString();
        r0 = r1;
        r6 = r3;
    L_0x0294:
        r1 = com.tencent.mm.plugin.fav.ui.m.c.HintTextSize;
        r1 = com.tencent.mm.bp.a.ad(r13, r1);
        r1 = com.tencent.mm.pluginsdk.ui.d.j.a(r13, r2, r1);
        if (r7 == 0) goto L_0x03b0;
    L_0x02a0:
        r2 = r12.jrx;
        r0 = com.tencent.mm.plugin.fts.a.a.d.a(r1, r2, r0, r6);
        r0 = com.tencent.mm.plugin.fts.a.f.a(r0);
        r0 = r0.jrO;
    L_0x02ac:
        r1 = new java.lang.CharSequence[r11];
        r2 = r13.getResources();
        r3 = com.tencent.mm.plugin.fav.ui.m.i.search_contact_favorite_status;
        r2 = r2.getString(r3);
        r1[r5] = r2;
        r1[r4] = r0;
        r0 = android.text.TextUtils.concat(r1);
        goto L_0x00c4;
    L_0x02c2:
        r0 = r4;
    L_0x02c3:
        r1 = r4;
        r3 = r0;
    L_0x02c5:
        if (r2 == 0) goto L_0x02eb;
    L_0x02c7:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = a(r2, r5);
        r0 = r0.append(r2);
        r2 = "-";
        r0 = r0.append(r2);
        r2 = c(r13, r9);
        r0 = r0.append(r2);
        r2 = r0.toString();
        r0 = r1;
        r6 = r3;
        r7 = r4;
        goto L_0x0294;
    L_0x02eb:
        r2 = a(r9, r5);
        r0 = r1;
        r6 = r3;
        r7 = r4;
        goto L_0x0294;
    L_0x02f3:
        r0 = r4;
    L_0x02f4:
        r3 = r4;
        r6 = r0;
    L_0x02f6:
        if (r2 == 0) goto L_0x034c;
    L_0x02f8:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = a(r2, r4);
        r0 = r0.append(r1);
        r1 = "-";
        r0 = r0.append(r1);
        r1 = c(r13, r9);
        r0 = r0.append(r1);
        r0 = r0.toString();
        r1 = r0;
    L_0x0319:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
        r0 = r0.FR();
        r2 = r8.bGy;
        r0 = r0.Yg(r2);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r1 = r2.append(r1);
        r2 = "-";
        r1 = r1.append(r2);
        r0 = a(r0, r4);
        r0 = r1.append(r0);
        r1 = r0.toString();
        r0 = r3;
        r2 = r1;
        r7 = r4;
        goto L_0x0294;
    L_0x034c:
        r0 = r9.field_username;
        r0 = com.tencent.mm.model.s.fq(r0);
        if (r0 == 0) goto L_0x035a;
    L_0x0354:
        r0 = c(r13, r9);
        r1 = r0;
        goto L_0x0319;
    L_0x035a:
        r0 = a(r9, r4);
        r1 = r0;
        goto L_0x0319;
    L_0x0360:
        r0 = r4;
    L_0x0361:
        r1 = r4;
    L_0x0362:
        r3 = r0;
        r7 = r4;
        goto L_0x0270;
    L_0x0366:
        r0 = r9.field_username;
        r0 = com.tencent.mm.model.s.fq(r0);
        if (r0 == 0) goto L_0x0376;
    L_0x036e:
        r2 = c(r13, r9);
        r0 = r1;
        r6 = r3;
        goto L_0x0294;
    L_0x0376:
        r2 = a(r9, r4);
        r0 = r1;
        r6 = r3;
        goto L_0x0294;
    L_0x037e:
        r0 = r8.bXO;
        r0 = r0.rBI;
        if (r0 == 0) goto L_0x00cb;
    L_0x0384:
        r0 = r8.bXO;
        r0 = r0.rBI;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x00cb;
    L_0x038e:
        r0 = r8.bXO;
        r0 = r0.rBI;
        r0 = r0.get(r5);
        r0 = (com.tencent.mm.protocal.c.vx) r0;
        r0 = r0.rzD;
        r0 = com.tencent.mm.pluginsdk.c.Sz(r0);
        goto L_0x00cd;
    L_0x03a0:
        r0 = com.tencent.mm.plugin.fav.ui.m.h.app_attach_file_icon_webpage;
        goto L_0x00cd;
    L_0x03a4:
        r0 = com.tencent.mm.plugin.fav.ui.m.h.app_attach_file_icon_voice;
        goto L_0x00cd;
    L_0x03a8:
        r0 = com.tencent.mm.plugin.fav.ui.m.h.app_attach_file_icon_video;
        goto L_0x00cd;
    L_0x03ac:
        r0 = com.tencent.mm.plugin.fav.ui.m.h.app_attach_file_icon_location;
        goto L_0x00cd;
    L_0x03b0:
        r0 = r1;
        goto L_0x02ac;
    L_0x03b3:
        r0 = r5;
        goto L_0x02c3;
    L_0x03b6:
        r0 = r5;
        goto L_0x02f4;
    L_0x03b9:
        r0 = r5;
        goto L_0x0361;
    L_0x03bb:
        r1 = r5;
        r0 = r5;
        goto L_0x0362;
    L_0x03be:
        r3 = r5;
        r6 = r5;
        goto L_0x02f6;
    L_0x03c2:
        r1 = r5;
        r3 = r5;
        goto L_0x02c5;
    L_0x03c6:
        r1 = r0;
        goto L_0x00b6;
    L_0x03c9:
        r0 = r1;
        goto L_0x00a6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fav.ui.b.a.a(android.content.Context, com.tencent.mm.plugin.fts.a.d.a.a$a, java.lang.Object[]):void");
    }

    public final b BV() {
        return this.jef;
    }

    protected final com.tencent.mm.plugin.fts.a.d.a.a.a afD() {
        return this.jeg;
    }

    private static String a(ab abVar, boolean z) {
        String str;
        if (!z || bi.oW(abVar.field_conRemark)) {
            str = abVar.field_nickname;
        } else {
            str = abVar.field_conRemark;
        }
        if (bi.oW(str)) {
            return abVar.field_username;
        }
        return str;
    }

    private static String c(Context context, ab abVar) {
        String str = abVar.field_conRemark;
        if (bi.oW(str)) {
            str = abVar.field_nickname;
        }
        if (bi.oW(str)) {
            return context.getString(i.fts_header_chatroom);
        }
        return str;
    }

    private String bg(List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (CharSequence charSequence : this.jrx.jrX) {
            for (String str : list) {
                if (d.Cv(str).contains(charSequence)) {
                    stringBuffer.append(str);
                    stringBuffer.append(",");
                }
            }
        }
        stringBuffer.trimToSize();
        if (stringBuffer.length() == 0) {
            return "";
        }
        return stringBuffer.substring(0, stringBuffer.length() - 1);
    }

    public final int afF() {
        return this.fyJ.jsJ;
    }
}
