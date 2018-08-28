package com.tencent.mm.plugin.fav.ui.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.plugin.fav.ui.m.c;
import com.tencent.mm.protocal.c.wn;

public final class h extends a {
    private static int jeu;

    public static class a extends b {
        View jeA;
        View jeB;
        View jeC;
        View jeD;
        ImageView jeE;
        ImageView jeF;
        View jeG;
        TextView jeH;
        TextView jeI;
        TextView jeJ;
        ImageView jeK;
        TextView jeL;
        TextView jeM;
        TextView jeN;
    }

    public h(k kVar) {
        super(kVar);
        jeu = com.tencent.mm.bp.a.ad(kVar.context, c.FavImageSize);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View a(android.view.View r17, android.view.ViewGroup r18, com.tencent.mm.plugin.fav.a.g r19) {
        /*
        r16 = this;
        r2 = r18.getContext();
        if (r17 != 0) goto L_0x00dc;
    L_0x0006:
        r3 = new com.tencent.mm.plugin.fav.ui.d.h$a;
        r3.<init>();
        r4 = com.tencent.mm.plugin.fav.ui.m.f.fav_listitem_wenote;
        r5 = 0;
        r2 = android.view.View.inflate(r2, r4, r5);
        r0 = r16;
        r1 = r19;
        r17 = r0.a(r2, r3, r1);
        r2 = com.tencent.mm.plugin.fav.ui.m.e.record_layout;
        r0 = r17;
        r2 = r0.findViewById(r2);
        r3.jeA = r2;
        r2 = com.tencent.mm.plugin.fav.ui.m.e.common_card_layout;
        r0 = r17;
        r2 = r0.findViewById(r2);
        r3.jeB = r2;
        r2 = com.tencent.mm.plugin.fav.ui.m.e.voice_layout;
        r0 = r17;
        r2 = r0.findViewById(r2);
        r3.jeC = r2;
        r2 = com.tencent.mm.plugin.fav.ui.m.e.fav_record_icon_ll;
        r0 = r17;
        r2 = r0.findViewById(r2);
        r3.jeD = r2;
        r2 = com.tencent.mm.plugin.fav.ui.m.e.fav_record_card_icon;
        r0 = r17;
        r2 = r0.findViewById(r2);
        r2 = (android.widget.ImageView) r2;
        r3.jeE = r2;
        r2 = com.tencent.mm.plugin.fav.ui.m.e.fav_icon_info_bg;
        r0 = r17;
        r2 = r0.findViewById(r2);
        r3.jeG = r2;
        r2 = com.tencent.mm.plugin.fav.ui.m.e.fav_icon_video_mask;
        r0 = r17;
        r2 = r0.findViewById(r2);
        r2 = (android.widget.ImageView) r2;
        r3.jeF = r2;
        r2 = com.tencent.mm.plugin.fav.ui.m.e.fav_icon_info_tv;
        r0 = r17;
        r2 = r0.findViewById(r2);
        r2 = (android.widget.TextView) r2;
        r3.jeH = r2;
        r2 = com.tencent.mm.plugin.fav.ui.m.e.fav_record_title;
        r0 = r17;
        r2 = r0.findViewById(r2);
        r2 = (android.widget.TextView) r2;
        r3.jeI = r2;
        r2 = com.tencent.mm.plugin.fav.ui.m.e.fav_record_desc;
        r0 = r17;
        r2 = r0.findViewById(r2);
        r2 = (android.widget.TextView) r2;
        r3.jeJ = r2;
        r2 = com.tencent.mm.plugin.fav.ui.m.e.fav_common_card_icon;
        r0 = r17;
        r2 = r0.findViewById(r2);
        r2 = (android.widget.ImageView) r2;
        r3.jeK = r2;
        r2 = com.tencent.mm.plugin.fav.ui.m.e.fav_card_title;
        r0 = r17;
        r2 = r0.findViewById(r2);
        r2 = (android.widget.TextView) r2;
        r3.jeL = r2;
        r2 = com.tencent.mm.plugin.fav.ui.m.e.fav_card_desc;
        r0 = r17;
        r2 = r0.findViewById(r2);
        r2 = (android.widget.TextView) r2;
        r3.jeM = r2;
        r2 = com.tencent.mm.plugin.fav.ui.m.e.fav_voice_title;
        r0 = r17;
        r2 = r0.findViewById(r2);
        r2 = (android.widget.TextView) r2;
        r3.jeN = r2;
        r0 = r17;
        r0.setTag(r3);
        r10 = r3;
    L_0x00be:
        r0 = r16;
        r1 = r19;
        r0.a(r10, r1);
        r0 = r19;
        r2 = r0.field_favProto;
        r12 = r2.rBI;
        r2 = r12.size();
        r3 = 2;
        if (r2 >= r3) goto L_0x00e4;
    L_0x00d2:
        r2 = "MicroMsg.Fav.FavNoteListItem";
        r3 = "no other item";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
    L_0x00db:
        return r17;
    L_0x00dc:
        r2 = r17.getTag();
        r2 = (com.tencent.mm.plugin.fav.ui.d.h.a) r2;
        r10 = r2;
        goto L_0x00be;
    L_0x00e4:
        r9 = -1;
        r8 = 0;
        r7 = r12.size();
        r6 = 0;
        r5 = -1;
        r4 = 1;
        r2 = 0;
        r3 = r2;
        r11 = r8;
    L_0x00f0:
        r2 = r12.size();
        if (r3 >= r2) goto L_0x017b;
    L_0x00f6:
        r2 = r12.get(r3);
        r2 = (com.tencent.mm.protocal.c.vx) r2;
        if (r3 != 0) goto L_0x0142;
    L_0x00fe:
        r8 = new com.tencent.mm.vfs.b;
        r13 = com.tencent.mm.plugin.fav.a.b.b(r2);
        r8.<init>(r13);
        r13 = r8.exists();
        if (r13 != 0) goto L_0x0118;
    L_0x010d:
        r0 = r19;
        com.tencent.mm.plugin.fav.ui.k.b(r0, r2);
        r8 = r11;
    L_0x0113:
        r2 = r3 + 1;
        r3 = r2;
        r11 = r8;
        goto L_0x00f0;
    L_0x0118:
        r2 = r2.rAq;
        if (r2 != 0) goto L_0x0140;
    L_0x011c:
        r2 = new com.tencent.mm.g.a.kp;
        r2.<init>();
        r13 = r2.bUP;
        r14 = 10;
        r13.type = r14;
        r13 = r2.bUP;
        r0 = r19;
        r14 = r0.field_localId;
        r13.field_localId = r14;
        r13 = r2.bUP;
        r8 = r8.cBX();
        r8 = r8.toString();
        r13.path = r8;
        r8 = com.tencent.mm.sdk.b.a.sFg;
        r8.m(r2);
    L_0x0140:
        r8 = r11;
        goto L_0x0113;
    L_0x0142:
        r8 = r2.bjS;
        r13 = 2;
        if (r8 == r13) goto L_0x0152;
    L_0x0147:
        r8 = r2.bjS;
        r13 = 4;
        if (r8 == r13) goto L_0x0152;
    L_0x014c:
        r8 = r2.bjS;
        r13 = 15;
        if (r8 != r13) goto L_0x0159;
    L_0x0152:
        r11 = r11 + 1;
        r6 = 1;
        r8 = -1;
        if (r9 != r8) goto L_0x0159;
    L_0x0158:
        r9 = r3;
    L_0x0159:
        r8 = r2.bjS;
        switch(r8) {
            case 1: goto L_0x0164;
            case 2: goto L_0x015e;
            case 3: goto L_0x0161;
            case 4: goto L_0x015e;
            case 5: goto L_0x0161;
            case 6: goto L_0x0161;
            case 7: goto L_0x0161;
            case 8: goto L_0x0161;
            case 9: goto L_0x015e;
            case 10: goto L_0x0161;
            case 11: goto L_0x0161;
            case 12: goto L_0x015e;
            case 13: goto L_0x015e;
            case 14: goto L_0x0161;
            case 15: goto L_0x015e;
            case 16: goto L_0x0161;
            default: goto L_0x015e;
        };
    L_0x015e:
        r4 = 0;
        r8 = r11;
        goto L_0x0113;
    L_0x0161:
        r5 = r3;
        r8 = r11;
        goto L_0x0113;
    L_0x0164:
        r2 = r2.desc;
        r8 = "";
        r2 = com.tencent.mm.sdk.platformtools.bi.aG(r2, r8);
        r2 = r2.trim();
        r2 = r2.length();
        if (r2 > 0) goto L_0x015e;
    L_0x0177:
        r7 = r7 + -1;
        r8 = r11;
        goto L_0x0113;
    L_0x017b:
        if (r4 == 0) goto L_0x01b7;
    L_0x017d:
        r2 = 2;
        if (r7 != r2) goto L_0x01b7;
    L_0x0180:
        r2 = 1;
    L_0x0181:
        if (r2 == 0) goto L_0x023f;
    L_0x0183:
        if (r5 <= 0) goto L_0x023f;
    L_0x0185:
        r2 = r12.get(r5);
        r2 = (com.tencent.mm.protocal.c.vx) r2;
        r3 = r2.bjS;
        r4 = 3;
        if (r3 != r4) goto L_0x01b9;
    L_0x0190:
        r3 = r10.jeA;
        r4 = 8;
        r3.setVisibility(r4);
        r3 = r10.jeB;
        r4 = 8;
        r3.setVisibility(r4);
        r3 = r10.jeC;
        r4 = 0;
        r3.setVisibility(r4);
        r3 = r10.jeN;
        r0 = r16;
        r4 = r0.iYh;
        r4 = r4.context;
        r2 = r2.duration;
        r2 = com.tencent.mm.plugin.fav.ui.j.C(r4, r2);
        r3.setText(r2);
        goto L_0x00db;
    L_0x01b7:
        r2 = 0;
        goto L_0x0181;
    L_0x01b9:
        r4 = 0;
        r3 = r2.bjS;
        r5 = 6;
        if (r3 != r5) goto L_0x021d;
    L_0x01bf:
        r3 = com.tencent.mm.plugin.fav.ui.m.h.app_attach_file_icon_location;
        r5 = r2.rAi;
        r5 = r5.rAL;
        r2 = r2.rAi;
        r2 = r2.fky;
        r6 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r6 == 0) goto L_0x0211;
    L_0x01cf:
        r2 = r5.bWB;
        r2 = com.tencent.mm.plugin.fav.ui.j.BC(r2);
        if (r2 == 0) goto L_0x020d;
    L_0x01d7:
        r2 = r5.bWB;
    L_0x01d9:
        r4 = r5.label;
        r5 = r2;
    L_0x01dc:
        r2 = r10.jeC;
        r6 = 8;
        r2.setVisibility(r6);
        r2 = r10.jeA;
        r6 = 8;
        r2.setVisibility(r6);
        r2 = r10.jeB;
        r6 = 0;
        r2.setVisibility(r6);
        r2 = r10.jeK;
        r2.setImageResource(r3);
        r2 = r10.jeL;
        r2.setText(r5);
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r2 != 0) goto L_0x0236;
    L_0x0200:
        r2 = r10.jeM;
        r2.setText(r4);
        r2 = r10.jeM;
        r3 = 0;
        r2.setVisibility(r3);
        goto L_0x00db;
    L_0x020d:
        r2 = r5.label;
        r5 = r2;
        goto L_0x01dc;
    L_0x0211:
        r4 = r5.bWB;
        r4 = com.tencent.mm.plugin.fav.ui.j.BC(r4);
        if (r4 == 0) goto L_0x01d9;
    L_0x0219:
        r4 = r5.bWB;
        r5 = r2;
        goto L_0x01dc;
    L_0x021d:
        r3 = r2.rzD;
        r3 = com.tencent.mm.plugin.fav.ui.c.Bx(r3);
        r5 = r2.title;
        r4 = r2.desc;
        r6 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r6 == 0) goto L_0x01dc;
    L_0x022d:
        r6 = r2.rzJ;
        r2 = (float) r6;
        r2 = com.tencent.mm.plugin.fav.a.b.aj(r2);
        r4 = r2;
        goto L_0x01dc;
    L_0x0236:
        r2 = r10.jeM;
        r3 = 8;
        r2.setVisibility(r3);
        goto L_0x00db;
    L_0x023f:
        r2 = r10.jeA;
        r3 = 0;
        r2.setVisibility(r3);
        r2 = r10.jeB;
        r3 = 8;
        r2.setVisibility(r3);
        r2 = r10.jeC;
        r3 = 8;
        r2.setVisibility(r3);
        r13 = new java.util.ArrayList;
        r13.<init>();
        r3 = 0;
        r2 = 1;
        r5 = r2;
    L_0x025b:
        r2 = r12.size();
        if (r5 >= r2) goto L_0x0454;
    L_0x0261:
        r2 = r12.get(r5);
        r2 = (com.tencent.mm.protocal.c.vx) r2;
        r4 = r2.bjS;
        r7 = 1;
        if (r4 != r7) goto L_0x0332;
    L_0x026c:
        r2 = r2.desc;
        r4 = 0;
        r7 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r7 != 0) goto L_0x0578;
    L_0x0275:
        r4 = r2.length();
        r7 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r4 <= r7) goto L_0x0284;
    L_0x027d:
        r4 = 0;
        r7 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r2.substring(r4, r7);
    L_0x0284:
        r4 = "&lt;";
        r7 = "<";
        r2 = r2.replaceAll(r4, r7);
        r4 = "&gt;";
        r7 = ">";
        r2 = r2.replaceAll(r4, r7);
        r4 = "&amp;";
        r7 = "&";
        r2 = r2.replaceAll(r4, r7);
        r4 = " ";
        r7 = " ";
        r2 = r2.replace(r4, r7);
        r4 = "\n";
        r2 = r2.split(r4);
        r8 = r2;
    L_0x02b4:
        if (r8 == 0) goto L_0x0348;
    L_0x02b6:
        r2 = r8.length;
        if (r2 <= 0) goto L_0x0348;
    L_0x02b9:
        r14 = new java.util.ArrayList;
        r14.<init>();
        r4 = 0;
        r2 = 0;
    L_0x02c0:
        r7 = r8.length;
        if (r2 >= r7) goto L_0x0575;
    L_0x02c3:
        r7 = r8[r2];
        r7 = r7.trim();
        r7 = com.tencent.mm.sdk.platformtools.bi.oW(r7);
        if (r7 != 0) goto L_0x02fb;
    L_0x02cf:
        r4 = r8[r2];
        r14.add(r4);
    L_0x02d4:
        r4 = "";
        r7 = r2 + 1;
        r2 = r4;
    L_0x02da:
        r4 = r8.length;
        if (r7 >= r4) goto L_0x02fe;
    L_0x02dd:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r2 = r4.append(r2);
        r4 = r8[r7];
        r2 = r2.append(r4);
        r4 = " ";
        r2 = r2.append(r4);
        r2 = r2.toString();
        r4 = r7 + 1;
        r7 = r4;
        goto L_0x02da;
    L_0x02fb:
        r2 = r2 + 1;
        goto L_0x02c0;
    L_0x02fe:
        r2 = r2.trim();
        r4 = r2.length();
        if (r4 <= 0) goto L_0x030b;
    L_0x0308:
        r14.add(r2);
    L_0x030b:
        r4 = 0;
        r2 = r14.size();
        if (r2 <= 0) goto L_0x0572;
    L_0x0312:
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r3);
        if (r2 == 0) goto L_0x0572;
    L_0x0318:
        r2 = 0;
        r2 = r14.get(r2);
        r2 = (java.lang.String) r2;
        r3 = 1;
        r4 = r3;
    L_0x0321:
        r3 = r14.size();
        if (r4 >= r3) goto L_0x057b;
    L_0x0327:
        r3 = r14.get(r4);
        r13.add(r3);
        r3 = r4 + 1;
        r4 = r3;
        goto L_0x0321;
    L_0x0332:
        r7 = r17.getContext();
        r4 = "";
        r8 = r2.bjS;
        switch(r8) {
            case 3: goto L_0x034d;
            case 4: goto L_0x033e;
            case 5: goto L_0x0372;
            case 6: goto L_0x03b4;
            case 7: goto L_0x0393;
            case 8: goto L_0x0404;
            case 9: goto L_0x033e;
            case 10: goto L_0x0426;
            case 11: goto L_0x033e;
            case 12: goto L_0x033e;
            case 13: goto L_0x033e;
            case 14: goto L_0x033e;
            case 15: goto L_0x033e;
            case 16: goto L_0x044c;
            default: goto L_0x033e;
        };
    L_0x033e:
        r2 = r4;
    L_0x033f:
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r4 != 0) goto L_0x0348;
    L_0x0345:
        r13.add(r2);
    L_0x0348:
        r2 = r5 + 1;
        r5 = r2;
        goto L_0x025b;
    L_0x034d:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r8 = com.tencent.mm.plugin.fav.ui.m.i.favorite_sub_title_voice;
        r8 = com.tencent.mm.plugin.fav.ui.j.D(r7, r8);
        r4 = r4.append(r8);
        r8 = " ";
        r4 = r4.append(r8);
        r2 = r2.duration;
        r2 = com.tencent.mm.plugin.fav.ui.j.C(r7, r2);
        r2 = r4.append(r2);
        r2 = r2.toString();
        goto L_0x033f;
    L_0x0372:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r8 = com.tencent.mm.plugin.fav.ui.m.i.favorite_sub_title_url;
        r7 = com.tencent.mm.plugin.fav.ui.j.D(r7, r8);
        r4 = r4.append(r7);
        r7 = " ";
        r4 = r4.append(r7);
        r2 = r2.title;
        r2 = r4.append(r2);
        r2 = r2.toString();
        goto L_0x033f;
    L_0x0393:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r8 = com.tencent.mm.plugin.fav.ui.m.i.favorite_sub_title_music;
        r7 = com.tencent.mm.plugin.fav.ui.j.D(r7, r8);
        r4 = r4.append(r7);
        r7 = " ";
        r4 = r4.append(r7);
        r2 = r2.title;
        r2 = r4.append(r2);
        r2 = r2.toString();
        goto L_0x033f;
    L_0x03b4:
        r2 = r2.rAi;
        r2 = r2.rAL;
        r4 = r2.bWB;
        r4 = com.tencent.mm.plugin.fav.ui.j.BC(r4);
        if (r4 == 0) goto L_0x03e2;
    L_0x03c0:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r8 = com.tencent.mm.plugin.fav.ui.m.i.favorite_sub_title_location;
        r7 = com.tencent.mm.plugin.fav.ui.j.D(r7, r8);
        r4 = r4.append(r7);
        r7 = " ";
        r4 = r4.append(r7);
        r2 = r2.bWB;
        r2 = r4.append(r2);
        r2 = r2.toString();
        goto L_0x033f;
    L_0x03e2:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r8 = com.tencent.mm.plugin.fav.ui.m.i.favorite_sub_title_location;
        r7 = com.tencent.mm.plugin.fav.ui.j.D(r7, r8);
        r4 = r4.append(r7);
        r7 = " ";
        r4 = r4.append(r7);
        r2 = r2.label;
        r2 = r4.append(r2);
        r2 = r2.toString();
        goto L_0x033f;
    L_0x0404:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r8 = com.tencent.mm.plugin.fav.ui.m.i.favorite_sub_title_file;
        r7 = com.tencent.mm.plugin.fav.ui.j.D(r7, r8);
        r4 = r4.append(r7);
        r7 = " ";
        r4 = r4.append(r7);
        r2 = r2.title;
        r2 = r4.append(r2);
        r2 = r2.toString();
        goto L_0x033f;
    L_0x0426:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r8 = com.tencent.mm.plugin.fav.ui.m.i.favorite_mall_product;
        r7 = com.tencent.mm.plugin.fav.ui.j.D(r7, r8);
        r4 = r4.append(r7);
        r7 = " ";
        r4 = r4.append(r7);
        r2 = r2.rAi;
        r2 = r2.rAP;
        r2 = r2.title;
        r2 = r4.append(r2);
        r2 = r2.toString();
        goto L_0x033f;
    L_0x044c:
        r2 = com.tencent.mm.plugin.fav.ui.m.i.favorite_friend_card;
        r2 = com.tencent.mm.plugin.fav.ui.j.D(r7, r2);
        goto L_0x033f;
    L_0x0454:
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r3);
        if (r2 != 0) goto L_0x04ab;
    L_0x045a:
        r2 = r10.jeI;
        r4 = r10.jeI;
        r4 = r4.getContext();
        r5 = r10.jeI;
        r5 = r5.getTextSize();
        r3 = com.tencent.mm.pluginsdk.ui.d.j.a(r4, r3, r5);
        r2.setText(r3);
        r2 = r10.jeI;
        r3 = 0;
        r2.setVisibility(r3);
        r2 = r13.size();
        if (r2 <= 0) goto L_0x04a4;
    L_0x047b:
        r2 = r10.jeI;
        r3 = 1;
        r2.setMaxLines(r3);
    L_0x0481:
        r4 = new java.lang.StringBuffer;
        r4.<init>();
        r2 = 0;
        r3 = r2;
    L_0x0488:
        r2 = r13.size();
        if (r3 >= r2) goto L_0x04b3;
    L_0x048e:
        r2 = 2;
        if (r3 >= r2) goto L_0x04b3;
    L_0x0491:
        r2 = r13.get(r3);
        r2 = (java.lang.String) r2;
        r4.append(r2);
        r2 = "\n";
        r4.append(r2);
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x0488;
    L_0x04a4:
        r2 = r10.jeI;
        r3 = 3;
        r2.setMaxLines(r3);
        goto L_0x0481;
    L_0x04ab:
        r2 = r10.jeI;
        r3 = 8;
        r2.setVisibility(r3);
        goto L_0x0481;
    L_0x04b3:
        r2 = r4.length();
        if (r2 == 0) goto L_0x0537;
    L_0x04b9:
        r2 = 0;
        r3 = r4.length();
        r3 = r3 + -1;
        r2 = r4.substring(r2, r3);
        r3 = r10.jeJ;
        r4 = r10.jeJ;
        r4 = r4.getContext();
        r5 = r10.jeJ;
        r5 = r5.getTextSize();
        r2 = com.tencent.mm.pluginsdk.ui.d.j.a(r4, r2, r5);
        r3.setText(r2);
        r2 = r10.jeJ;
        r3 = 0;
        r2.setVisibility(r3);
    L_0x04df:
        if (r6 == 0) goto L_0x0569;
    L_0x04e1:
        r2 = r10.jeD;
        r3 = 0;
        r2.setVisibility(r3);
        r4 = r12.get(r9);
        r4 = (com.tencent.mm.protocal.c.vx) r4;
        r2 = r12.get(r9);
        r2 = (com.tencent.mm.protocal.c.vx) r2;
        r2 = r2.bjS;
        r3 = 2;
        if (r2 != r3) goto L_0x053f;
    L_0x04f8:
        r2 = r10.jeE;
        r3 = com.tencent.mm.plugin.fav.ui.m.h.fav_list_img_default;
        r6 = 1;
        r7 = jeu;
        r8 = jeu;
        r5 = r19;
        com.tencent.mm.plugin.fav.ui.k.a(r2, r3, r4, r5, r6, r7, r8);
        r2 = r10.jeF;
        r3 = 8;
        r2.setVisibility(r3);
    L_0x050d:
        r2 = 1;
        if (r11 <= r2) goto L_0x0559;
    L_0x0510:
        r2 = r10.jeH;
        r3 = r17.getContext();
        r4 = com.tencent.mm.plugin.fav.ui.m.i.favorite_img_count;
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = java.lang.Integer.valueOf(r11);
        r5[r6] = r7;
        r3 = r3.getString(r4, r5);
        r2.setText(r3);
        r2 = r10.jeH;
        r3 = 0;
        r2.setVisibility(r3);
        r2 = r10.jeG;
        r3 = 0;
        r2.setVisibility(r3);
        goto L_0x00db;
    L_0x0537:
        r2 = r10.jeJ;
        r3 = 8;
        r2.setVisibility(r3);
        goto L_0x04df;
    L_0x053f:
        r2 = r10.jeF;
        r3 = 0;
        r2.setVisibility(r3);
        r0 = r16;
        r2 = r0.iYh;
        r3 = r10.jeE;
        r6 = r4.bJv;
        r7 = com.tencent.mm.plugin.fav.ui.m.h.app_attach_file_icon_video;
        r8 = jeu;
        r9 = jeu;
        r5 = r19;
        r2.a(r3, r4, r5, r6, r7, r8, r9);
        goto L_0x050d;
    L_0x0559:
        r2 = r10.jeH;
        r3 = 8;
        r2.setVisibility(r3);
        r2 = r10.jeG;
        r3 = 8;
        r2.setVisibility(r3);
        goto L_0x00db;
    L_0x0569:
        r2 = r10.jeD;
        r3 = 8;
        r2.setVisibility(r3);
        goto L_0x00db;
    L_0x0572:
        r2 = r3;
        goto L_0x0321;
    L_0x0575:
        r2 = r4;
        goto L_0x02d4;
    L_0x0578:
        r8 = r4;
        goto L_0x02b4;
    L_0x057b:
        r3 = r2;
        goto L_0x0348;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fav.ui.d.h.a(android.view.View, android.view.ViewGroup, com.tencent.mm.plugin.fav.a.g):android.view.View");
    }

    public final void a(View view, wn wnVar) {
        a aVar = (a) view.getTag();
        ((y) g.l(y.class)).a(view.getContext(), aVar.iWQ, wnVar);
    }
}
