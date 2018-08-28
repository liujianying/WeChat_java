package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.view.View;
import b.c.b.e;
import com.tencent.mm.plugin.radar.a.c;
import com.tencent.mm.plugin.radar.a.d;
import com.tencent.mm.plugin.radar.ui.RadarViewController.a;
import com.tencent.mm.protocal.c.beq;
import java.util.HashMap;

public final class RadarViewController$c extends a {
    private final Context context;
    final /* synthetic */ RadarViewController mmN;
    beq[] mmP = new beq[12];
    HashMap<String, String> mmQ = new HashMap();
    HashMap<String, Integer> mmR = new HashMap();
    final a mmS;
    private int mmT;
    HashMap<String, View> mmU = new HashMap();
    private boolean mmV;

    public RadarViewController$c(RadarViewController radarViewController, RadarSpecialGridView radarSpecialGridView, Context context) {
        e.i((Object) radarSpecialGridView, "radarGridView");
        e.i((Object) context, "context");
        this.mmN = radarViewController;
        super(radarSpecialGridView, context);
        this.context = context;
        this.mmS = new a(radarViewController);
    }

    public final int getCount() {
        if (this.mmV) {
            return 0;
        }
        return ((Object[]) this.mmP).length;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aa(java.util.LinkedList<com.tencent.mm.protocal.c.beq> r11) {
        /*
        r10 = this;
        r3 = 1;
        r2 = 0;
        if (r11 == 0) goto L_0x000a;
    L_0x0004:
        r0 = r11.size();
        if (r0 == 0) goto L_0x000c;
    L_0x000a:
        if (r11 != 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = r10;
        r0 = (com.tencent.mm.plugin.radar.ui.RadarViewController$c) r0;
        r1 = r0.mmP;
        r1 = (java.lang.Object[]) r1;
        r5 = r1.length;
        r4 = r2;
    L_0x0016:
        if (r4 >= r5) goto L_0x0045;
    L_0x0018:
        r6 = r11.iterator();
    L_0x001c:
        r1 = r6.hasNext();
        if (r1 == 0) goto L_0x0041;
    L_0x0022:
        r1 = r6.next();
        r1 = (com.tencent.mm.protocal.c.beq) r1;
        r7 = com.tencent.mm.plugin.radar.ui.g.mmr;
        r7 = com.tencent.mm.plugin.radar.ui.g.c(r1);
        r8 = com.tencent.mm.plugin.radar.ui.g.mmr;
        r8 = r0.mmP;
        r8 = r8[r4];
        r8 = com.tencent.mm.plugin.radar.ui.g.c(r8);
        r7 = b.c.b.e.i(r7, r8);
        if (r7 == 0) goto L_0x001c;
    L_0x003e:
        r11.remove(r1);
    L_0x0041:
        r1 = r4 + 1;
        r4 = r1;
        goto L_0x0016;
    L_0x0045:
        r5 = r11.iterator();
    L_0x0049:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x00bb;
    L_0x004f:
        r0 = r5.next();
        r0 = (com.tencent.mm.protocal.c.beq) r0;
        r6 = java.lang.System.currentTimeMillis();
        r1 = (int) r6;
        r1 = r1 % 6;
        r6 = java.lang.Math.abs(r1);
        r1 = r10.mmP;
        r7 = r1.length;
        r4 = r2;
    L_0x0064:
        if (r4 >= r7) goto L_0x0049;
    L_0x0066:
        r1 = r4 + r6;
        r8 = r1 % 12;
        r1 = 4;
        if (r8 == r1) goto L_0x0070;
    L_0x006d:
        r1 = 7;
        if (r8 != r1) goto L_0x0074;
    L_0x0070:
        r1 = r4 + 1;
        r4 = r1;
        goto L_0x0064;
    L_0x0074:
        r1 = r10.mmP;
        r9 = r1[r8];
        if (r9 == 0) goto L_0x0098;
    L_0x007a:
        r1 = r9.hbL;
        r1 = (java.lang.CharSequence) r1;
        if (r1 == 0) goto L_0x0086;
    L_0x0080:
        r1 = b.f.a.U(r1);
        if (r1 == 0) goto L_0x00b5;
    L_0x0086:
        r1 = r3;
    L_0x0087:
        if (r1 == 0) goto L_0x00b9;
    L_0x0089:
        r1 = r9.ryZ;
        r1 = (java.lang.CharSequence) r1;
        if (r1 == 0) goto L_0x0095;
    L_0x008f:
        r1 = b.f.a.U(r1);
        if (r1 == 0) goto L_0x00b7;
    L_0x0095:
        r1 = r3;
    L_0x0096:
        if (r1 == 0) goto L_0x00b9;
    L_0x0098:
        r1 = r3;
    L_0x0099:
        if (r1 == 0) goto L_0x0070;
    L_0x009b:
        r1 = r10.mmP;
        r1[r8] = r0;
        r1 = r10.mmR;
        r4 = com.tencent.mm.plugin.radar.ui.g.mmr;
        r4 = "member";
        b.c.b.e.h(r0, r4);
        r0 = com.tencent.mm.plugin.radar.ui.g.b(r0);
        r4 = java.lang.Integer.valueOf(r2);
        r1.put(r0, r4);
        goto L_0x0049;
    L_0x00b5:
        r1 = r2;
        goto L_0x0087;
    L_0x00b7:
        r1 = r2;
        goto L_0x0096;
    L_0x00b9:
        r1 = r2;
        goto L_0x0099;
    L_0x00bb:
        r0 = r11.size();
        if (r0 <= 0) goto L_0x000c;
    L_0x00c1:
        r10.bpx();
        r0 = com.tencent.mm.plugin.radar.b.d.mjV;
        r0 = r11.size();
        r1 = com.tencent.mm.plugin.radar.b.d.bSU;
        if (r1 != 0) goto L_0x0110;
    L_0x00ce:
        if (r0 <= 0) goto L_0x0110;
    L_0x00d0:
        r4 = com.tencent.mm.plugin.radar.b.d.bpr();
        r6 = com.tencent.mm.plugin.radar.b.d.mjR;
        r4 = r4 - r6;
        r1 = (float) r4;
        r4 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r1 = r1 * r4;
        r4 = 1148846080; // 0x447a0000 float:1000.0 double:5.676053805E-315;
        r1 = r1 / r4;
        r4 = com.tencent.mm.plugin.radar.b.d.TAG;
        r5 = "FoundFirstFriendTimeSpent %s";
        r6 = new java.lang.Object[r3];
        r7 = java.lang.Float.valueOf(r1);
        r6[r2] = r7;
        com.tencent.mm.sdk.platformtools.x.d(r4, r5, r6);
        r4 = com.tencent.mm.plugin.report.service.h.mEJ;
        r5 = b.c.b.l.vGJ;
        r5 = "%s";
        r6 = new java.lang.Object[r3];
        r1 = java.lang.Float.valueOf(r1);
        r6[r2] = r1;
        r1 = java.util.Arrays.copyOf(r6, r3);
        r1 = java.lang.String.format(r5, r1);
        r2 = "java.lang.String.format(format, *args)";
        b.c.b.e.h(r1, r2);
        r2 = 10682; // 0x29ba float:1.4969E-41 double:5.2776E-320;
        r4.k(r2, r1);
    L_0x0110:
        r1 = com.tencent.mm.plugin.radar.b.d.bSU;
        r1 = r1 + r0;
        com.tencent.mm.plugin.radar.b.d.bSU = r1;
        r1 = com.tencent.mm.plugin.radar.b.d.mjS;
        r0 = r0 + r1;
        com.tencent.mm.plugin.radar.b.d.mjS = r0;
        goto L_0x000c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.radar.ui.RadarViewController$c.aa(java.util.LinkedList):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View B(android.view.View r11, int r12) {
        /*
        r10 = this;
        r0 = com.tencent.mm.plugin.radar.ui.RadarViewController.mmJ;
        r0 = com.tencent.mm.plugin.radar.ui.RadarViewController.access$getTAG$cp();
        r1 = "getview RadarStatus%s";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r10.mmN;
        r4 = r4.getRadarStatus();
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.d(r0, r1, r2);
        r0 = r10.mmP;
        r0 = r0[r12];
        r7 = r0;
        r7 = (com.tencent.mm.protocal.c.beq) r7;
        if (r7 == 0) goto L_0x03ca;
    L_0x0021:
        r0 = r7.hbL;
        r0 = (java.lang.CharSequence) r0;
        if (r0 == 0) goto L_0x002d;
    L_0x0027:
        r0 = b.f.a.U(r0);
        if (r0 == 0) goto L_0x0092;
    L_0x002d:
        r0 = 1;
    L_0x002e:
        if (r0 == 0) goto L_0x0096;
    L_0x0030:
        r0 = r7.ryZ;
        r0 = (java.lang.CharSequence) r0;
        if (r0 == 0) goto L_0x003c;
    L_0x0036:
        r0 = b.f.a.U(r0);
        if (r0 == 0) goto L_0x0094;
    L_0x003c:
        r0 = 1;
    L_0x003d:
        if (r0 == 0) goto L_0x0096;
    L_0x003f:
        r0 = 1;
    L_0x0040:
        if (r0 != 0) goto L_0x03ca;
    L_0x0042:
        r0 = com.tencent.mm.plugin.radar.ui.g.mmr;
        r9 = com.tencent.mm.plugin.radar.ui.g.b(r7);
        r0 = r10.mmN;
        r1 = r0.getRadarStatus();
        if (r11 != 0) goto L_0x03d0;
    L_0x0050:
        r0 = r10.context;
        r2 = com.tencent.mm.plugin.radar.a.d.radar_result_item;
        r3 = 0;
        r0 = android.view.View.inflate(r0, r2, r3);
        if (r0 != 0) goto L_0x005e;
    L_0x005b:
        b.c.b.e.cJM();
    L_0x005e:
        r2 = r10.mmN;
        r2 = com.tencent.mm.plugin.radar.ui.RadarViewController.a(r2);
        r3 = r10.mmS;
        r3 = r3.bpN();
        r3 = java.lang.Integer.valueOf(r3);
        r0.setTag(r2, r3);
        r2 = r10.mmN;
        r2 = com.tencent.mm.plugin.radar.ui.RadarViewController.b(r2);
        r3 = r10.mmS;
        r3 = r3.getInAnimation();
        r0.setTag(r2, r3);
        r8 = r0;
    L_0x0081:
        r0 = com.tencent.mm.plugin.radar.a.c.radar_result_item_avatar_iv;
        r3 = r8.findViewById(r0);
        if (r3 != 0) goto L_0x0098;
    L_0x0089:
        r0 = new b.i;
        r1 = "null cannot be cast to non-null type android.widget.ImageView";
        r0.<init>(r1);
        throw r0;
    L_0x0092:
        r0 = 0;
        goto L_0x002e;
    L_0x0094:
        r0 = 0;
        goto L_0x003d;
    L_0x0096:
        r0 = 0;
        goto L_0x0040;
    L_0x0098:
        r3 = (android.widget.ImageView) r3;
        r0 = com.tencent.mm.plugin.radar.a.c.radar_member_state_view;
        r4 = r8.findViewById(r0);
        if (r4 != 0) goto L_0x00ab;
    L_0x00a2:
        r0 = new b.i;
        r1 = "null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateView";
        r0.<init>(r1);
        throw r0;
    L_0x00ab:
        r4 = (com.tencent.mm.plugin.radar.ui.RadarStateView) r4;
        r0 = com.tencent.mm.plugin.radar.a.c.radar_result_item_username_tv;
        r2 = r8.findViewById(r0);
        if (r2 != 0) goto L_0x00be;
    L_0x00b5:
        r0 = new b.i;
        r1 = "null cannot be cast to non-null type android.widget.TextView";
        r0.<init>(r1);
        throw r0;
    L_0x00be:
        r2 = (android.widget.TextView) r2;
        r0 = com.tencent.mm.plugin.radar.a.c.radar_result_item_avatar_mask_iv;
        r6 = r8.findViewById(r0);
        if (r6 != 0) goto L_0x00d1;
    L_0x00c8:
        r0 = new b.i;
        r1 = "null cannot be cast to non-null type android.widget.ImageView";
        r0.<init>(r1);
        throw r0;
    L_0x00d1:
        r6 = (android.widget.ImageView) r6;
        r0 = com.tencent.mm.plugin.radar.a.c.radar_member_state_choose_view;
        r5 = r8.findViewById(r0);
        if (r5 != 0) goto L_0x00e4;
    L_0x00db:
        r0 = new b.i;
        r1 = "null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateChooseView";
        r0.<init>(r1);
        throw r0;
    L_0x00e4:
        r5 = (com.tencent.mm.plugin.radar.ui.RadarStateChooseView) r5;
        r0 = 0;
        r3.setVisibility(r0);
        r0 = 0;
        r4.setVisibility(r0);
        r0 = 0;
        r2.setVisibility(r0);
        r0 = 0;
        r6.setVisibility(r0);
        r0 = com.tencent.mm.plugin.radar.b.e.e.mkr;
        if (r1 == r0) goto L_0x00fe;
    L_0x00fa:
        r0 = com.tencent.mm.plugin.radar.b.e.e.mks;
        if (r1 != r0) goto L_0x0151;
    L_0x00fe:
        r0 = 0;
        r4.setVisibility(r0);
        r0 = 8;
        r5.setVisibility(r0);
    L_0x0107:
        r0 = new com.tencent.mm.plugin.radar.ui.RadarViewController$c$a;
        r1 = r10;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        r8.setTag(r0);
        r0 = 7;
        if (r12 == r0) goto L_0x0118;
    L_0x0113:
        r0 = r12 % 3;
        r1 = 1;
        if (r0 != r1) goto L_0x015b;
    L_0x0118:
        r0 = com.tencent.mm.plugin.radar.a.c.bottom_stub;
        r0 = r8.findViewById(r0);
        r1 = "anotherConvertView.findV…d<View>(R.id.bottom_stub)";
        b.c.b.e.h(r0, r1);
        r1 = 0;
        r0.setVisibility(r1);
        r0 = com.tencent.mm.plugin.radar.a.c.top_stub;
        r0 = r8.findViewById(r0);
        r1 = "anotherConvertView.findV…ById<View>(R.id.top_stub)";
        b.c.b.e.h(r0, r1);
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0139:
        if (r11 == 0) goto L_0x013d;
    L_0x013b:
        if (r8 == r11) goto L_0x0142;
    L_0x013d:
        r0 = r10.mmU;
        r0.put(r9, r8);
    L_0x0142:
        r0 = r8.getTag();
        if (r0 != 0) goto L_0x017d;
    L_0x0148:
        r0 = new b.i;
        r1 = "null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder";
        r0.<init>(r1);
        throw r0;
    L_0x0151:
        r0 = 8;
        r4.setVisibility(r0);
        r0 = 0;
        r5.setVisibility(r0);
        goto L_0x0107;
    L_0x015b:
        r0 = com.tencent.mm.plugin.radar.a.c.top_stub;
        r0 = r8.findViewById(r0);
        r1 = "anotherConvertView.findV…ById<View>(R.id.top_stub)";
        b.c.b.e.h(r0, r1);
        r1 = 0;
        r0.setVisibility(r1);
        r0 = com.tencent.mm.plugin.radar.a.c.bottom_stub;
        r0 = r8.findViewById(r0);
        r1 = "anotherConvertView.findV…d<View>(R.id.bottom_stub)";
        b.c.b.e.h(r0, r1);
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x0139;
    L_0x017d:
        r0 = (com.tencent.mm.plugin.radar.ui.RadarViewController$c.a) r0;
        r2 = r0.mmW;
        r1 = r10.mmN;
        r3 = r1.getContext();
        r1 = r7.hcS;
        r1 = (java.lang.CharSequence) r1;
        r4 = r0.mmW;
        r4 = r4.getTextSize();
        r1 = com.tencent.mm.pluginsdk.ui.d.j.a(r3, r1, r4);
        r1 = (java.lang.CharSequence) r1;
        r2.setText(r1);
        r1 = com.tencent.mm.plugin.radar.ui.b.a.mkK;
        r1 = r0.mmX;
        com.tencent.mm.plugin.radar.ui.b.a.a(r1, r9);
        r1 = com.tencent.mm.plugin.radar.a.c.radar_avatar_container;
        r1 = r8.findViewById(r1);
        r2 = "view.findViewById(R.id.radar_avatar_container)";
        b.c.b.e.h(r1, r2);
        r2 = new com.tencent.mm.plugin.radar.ui.RadarViewController$d;
        r3 = r10.mmN;
        r2.<init>(r3, r7);
        r1.setTag(r2);
        r1 = r10.mmN;
        r1 = r1.getRadarStatus();
        r2 = com.tencent.mm.plugin.radar.b.e.e.mkr;
        if (r1 == r2) goto L_0x01cb;
    L_0x01c1:
        r1 = r10.mmN;
        r1 = r1.getRadarStatus();
        r2 = com.tencent.mm.plugin.radar.b.e.e.mks;
        if (r1 != r2) goto L_0x0306;
    L_0x01cb:
        r1 = r0.mna;
        r2 = com.tencent.mm.plugin.radar.a.b.selector_radar_avatar;
        r1.setBackgroundResource(r2);
        r1 = r0.mmY;
        r2 = 1;
        r1.mlI = r2;
        r1.bpE();
        r1 = r0.mmZ;
        r2 = 0;
        r1.mlC = r2;
        r2 = 8;
        r1.setVisibility(r2);
        r1 = r10.mmN;
        r1 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r1);
        r1 = r1.a(r7, false);
        if (r1 != 0) goto L_0x0222;
    L_0x01f0:
        r1 = r10.mmN;
        r1 = com.tencent.mm.plugin.radar.ui.RadarViewController.e(r1);
        r1 = r1.Ki(r9);
        r2 = r10.mmN;
        r2 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r2);
        r3 = "member";
        b.c.b.e.i(r7, r3);
        r3 = "state";
        b.c.b.e.i(r1, r3);
        r3 = r7.hbL;
        r4 = "member.UserName";
        b.c.b.e.h(r3, r4);
        r2.b(r3, r1);
        r3 = r7.ryZ;
        r4 = "member.EncodeUserName";
        b.c.b.e.h(r3, r4);
        r2.b(r3, r1);
    L_0x0222:
        r2 = r10.mmN;
        r2 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r2);
        r3 = 1;
        r2 = r2.a(r7, r3);
        r3 = r0.mmY;
        if (r2 != 0) goto L_0x0233;
    L_0x0231:
        r2 = com.tencent.mm.plugin.radar.b.c.e.mjz;
    L_0x0233:
        r4 = "state";
        b.c.b.e.i(r2, r4);
        r3.init();
        r4 = r3.mlJ;
        r5 = 0;
        r4.removeMessages(r5);
        r3.clearAnimation();
        r3.mkq = r2;
        r2 = 0;
        r3.mlz = r2;
        r3.bpE();
        r3 = r0.mmY;
        r0 = "state";
        b.c.b.e.i(r1, r0);
        r3.init();
        r0 = com.tencent.mm.plugin.radar.ui.RadarStateView.mlM;
        r0 = com.tencent.mm.plugin.radar.ui.RadarStateView.access$getTAG$cp();
        r2 = new java.lang.StringBuilder;
        r4 = " turnToState : ";
        r2.<init>(r4);
        r2 = r2.append(r1);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r2);
        r0 = 0;
        r2 = r3.mkq;
        if (r2 != r1) goto L_0x02be;
    L_0x0276:
        r3.bpE();
    L_0x0279:
        r0 = r10.mmN;
        r0 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r0);
        r1 = "member";
        b.c.b.e.i(r7, r1);
        r1 = r7.hbL;
        r2 = "member.UserName";
        b.c.b.e.h(r1, r2);
        r2 = 0;
        r0.a(r1, r2);
        r1 = r7.ryZ;
        r2 = "member.EncodeUserName";
        b.c.b.e.h(r1, r2);
        r2 = 0;
        r0.a(r1, r2);
        if (r12 != 0) goto L_0x02a7;
    L_0x029f:
        r0 = r10.mmR;
        r0 = r0.size();
        r10.mmT = r0;
    L_0x02a7:
        r0 = r10.mmR;
        r0 = r0.remove(r9);
        if (r0 == 0) goto L_0x02bd;
    L_0x02af:
        r0 = r10.mmS;
        r1 = r10.mmT;
        r2 = r10.mmR;
        r2 = r2.size();
        r1 = r1 - r2;
        r0.g(r1, r8);
    L_0x02bd:
        return r8;
    L_0x02be:
        r2 = r3.getVisibility();
        if (r2 != 0) goto L_0x02f5;
    L_0x02c4:
        r2 = 1;
    L_0x02c5:
        if (r2 == 0) goto L_0x02cb;
    L_0x02c7:
        r3.bpG();
        r0 = 1;
    L_0x02cb:
        r2 = com.tencent.mm.plugin.radar.ui.RadarStateView.mlM;
        r2 = com.tencent.mm.plugin.radar.ui.RadarStateView.access$getTAG$cp();
        r4 = new java.lang.StringBuilder;
        r5 = " delay : ";
        r4.<init>(r5);
        r4 = r4.append(r0);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.x.d(r2, r4);
        r3.mkq = r1;
        r1 = r3.mkq;
        r2 = com.tencent.mm.plugin.radar.b.c.e.mjz;
        if (r1 == r2) goto L_0x0279;
    L_0x02ec:
        if (r0 != 0) goto L_0x02f7;
    L_0x02ee:
        r0 = r3.mlJ;
        r1 = 0;
        r0.sendEmptyMessage(r1);
        goto L_0x0279;
    L_0x02f5:
        r2 = 0;
        goto L_0x02c5;
    L_0x02f7:
        r0 = r3.mlJ;
        r1 = 0;
        r2 = com.tencent.mm.plugin.radar.ui.RadarStateView.bpH();
        r2 = r2 + 20;
        r2 = (long) r2;
        r0.sendEmptyMessageDelayed(r1, r2);
        goto L_0x0279;
    L_0x0306:
        r1 = r10.mmN;
        r1 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r1);
        r1 = r1.mka;
        r2 = com.tencent.mm.plugin.radar.ui.g.mmr;
        r2 = com.tencent.mm.plugin.radar.ui.g.c(r7);
        r1 = r1.get(r2);
        r1 = (java.lang.String) r1;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 != 0) goto L_0x03c4;
    L_0x0320:
        r1 = r0.mmY;
        r2 = 0;
        r1.mlI = r2;
        r2 = 8;
        r1.setVisibility(r2);
        r1 = r0.mmZ;
        r2 = 1;
        r1.mlC = r2;
        r1.bpE();
        r1 = r10.mmN;
        r1 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r1);
        if (r7 == 0) goto L_0x034e;
    L_0x033a:
        r2 = com.tencent.mm.plugin.radar.ui.g.mmr;
        r2 = com.tencent.mm.plugin.radar.ui.g.b(r7);
        r1 = r1.mke;
        r1 = r1.get(r2);
        r1 = (com.tencent.mm.plugin.radar.b.e.a) r1;
        if (r1 != 0) goto L_0x034c;
    L_0x034a:
        r1 = com.tencent.mm.plugin.radar.b.e.a.mkn;
    L_0x034c:
        if (r1 != 0) goto L_0x0350;
    L_0x034e:
        r1 = com.tencent.mm.plugin.radar.b.e.a.mkn;
    L_0x0350:
        r2 = com.tencent.mm.plugin.radar.b.e.a.mkn;
        if (r1 == r2) goto L_0x035a;
    L_0x0354:
        r2 = r0.mna;
        r3 = 0;
        r2.setBackgroundDrawable(r3);
    L_0x035a:
        r0 = r0.mmZ;
        r2 = "status";
        b.c.b.e.i(r1, r2);
        r2 = r0.mlD;
        r2 = b.c.b.e.i(r2, r1);
        r2 = r2 ^ 1;
        if (r2 == 0) goto L_0x037b;
    L_0x036c:
        r0.mlD = r1;
        r1 = r0.mlD;
        r2 = com.tencent.mm.plugin.radar.ui.e.mlF;
        r1 = r1.ordinal();
        r1 = r2[r1];
        switch(r1) {
            case 1: goto L_0x03a3;
            case 2: goto L_0x03b5;
            default: goto L_0x037b;
        };
    L_0x037b:
        if (r12 != 0) goto L_0x0385;
    L_0x037d:
        r0 = r10.mmR;
        r0 = r0.size();
        r10.mmT = r0;
    L_0x0385:
        r0 = r10.mmR;
        r1 = com.tencent.mm.plugin.radar.ui.g.mmr;
        r1 = com.tencent.mm.plugin.radar.ui.g.c(r7);
        r0 = r0.remove(r1);
        if (r0 == 0) goto L_0x02bd;
    L_0x0393:
        r0 = r10.mmS;
        r1 = r10.mmT;
        r2 = r10.mmR;
        r2 = r2.size();
        r1 = r1 - r2;
        r0.g(r1, r8);
        goto L_0x02bd;
    L_0x03a3:
        r1 = r0.mlC;
        if (r1 == 0) goto L_0x037b;
    L_0x03a7:
        r0.bpE();
        r1 = 1;
        r0.mlz = r1;
        r1 = r0.getSlideOutAnim();
        r0.startAnimation(r1);
        goto L_0x037b;
    L_0x03b5:
        r1 = r0.mlC;
        if (r1 == 0) goto L_0x037b;
    L_0x03b9:
        r0.bpE();
        r1 = r0.getSlideInAnim();
        r0.startAnimation(r1);
        goto L_0x037b;
    L_0x03c4:
        r8 = r10.C(r11, r12);
        goto L_0x02bd;
    L_0x03ca:
        r8 = r10.C(r11, r12);
        goto L_0x02bd;
    L_0x03d0:
        r8 = r11;
        goto L_0x0081;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.radar.ui.RadarViewController$c.B(android.view.View, int):android.view.View");
    }

    private final View C(View view, int i) {
        if (view == null) {
            view = View.inflate(this.context, d.radar_result_item, null);
            if (view == null) {
                e.cJM();
            }
            view.setTag(RadarViewController.a(this.mmN), Integer.valueOf(this.mmS.bpN()));
            view.setTag(RadarViewController.b(this.mmN), this.mmS.getInAnimation());
        }
        View findViewById = view.findViewById(c.radar_result_item_avatar_iv);
        e.h(findViewById, "anotherConvertView.findV…ar_result_item_avatar_iv)");
        findViewById.setVisibility(8);
        findViewById = view.findViewById(c.radar_result_item_avatar_mask_iv);
        e.h(findViewById, "anotherConvertView.findV…sult_item_avatar_mask_iv)");
        findViewById.setVisibility(8);
        findViewById = view.findViewById(c.radar_result_item_username_tv);
        e.h(findViewById, "anotherConvertView.findV…_result_item_username_tv)");
        findViewById.setVisibility(4);
        findViewById = view.findViewById(c.radar_member_state_view);
        e.h(findViewById, "anotherConvertView.findV….radar_member_state_view)");
        findViewById.setVisibility(4);
        findViewById = view.findViewById(c.radar_member_state_choose_view);
        e.h(findViewById, "anotherConvertView.findV…member_state_choose_view)");
        findViewById.setVisibility(4);
        if (i == 7 || i % 3 == 1) {
            findViewById = view.findViewById(c.bottom_stub);
            e.h(findViewById, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
            findViewById.setVisibility(0);
            findViewById = view.findViewById(c.top_stub);
            e.h(findViewById, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
            findViewById.setVisibility(8);
        } else {
            findViewById = view.findViewById(c.top_stub);
            e.h(findViewById, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
            findViewById.setVisibility(0);
            findViewById = view.findViewById(c.bottom_stub);
            e.h(findViewById, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
            findViewById.setVisibility(8);
        }
        return view;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(com.tencent.mm.protocal.c.beq r4) {
        /*
        r3 = this;
        r2 = 1;
        r1 = 0;
        if (r4 == 0) goto L_0x0022;
    L_0x0004:
        r0 = r4.hbL;
        r0 = (java.lang.CharSequence) r0;
        if (r0 == 0) goto L_0x0010;
    L_0x000a:
        r0 = b.f.a.U(r0);
        if (r0 == 0) goto L_0x0026;
    L_0x0010:
        r0 = r2;
    L_0x0011:
        if (r0 == 0) goto L_0x002a;
    L_0x0013:
        r0 = r4.ryZ;
        r0 = (java.lang.CharSequence) r0;
        if (r0 == 0) goto L_0x001f;
    L_0x0019:
        r0 = b.f.a.U(r0);
        if (r0 == 0) goto L_0x0028;
    L_0x001f:
        r0 = r2;
    L_0x0020:
        if (r0 == 0) goto L_0x002a;
    L_0x0022:
        r0 = r2;
    L_0x0023:
        if (r0 == 0) goto L_0x002c;
    L_0x0025:
        return;
    L_0x0026:
        r0 = r1;
        goto L_0x0011;
    L_0x0028:
        r0 = r1;
        goto L_0x0020;
    L_0x002a:
        r0 = r1;
        goto L_0x0023;
    L_0x002c:
        r0 = com.tencent.mm.plugin.radar.ui.g.mmr;
        if (r4 != 0) goto L_0x0033;
    L_0x0030:
        b.c.b.e.cJM();
    L_0x0033:
        r0 = com.tencent.mm.plugin.radar.ui.g.b(r4);
        r1 = r3.mmN;
        r1 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r1);
        r1 = r1.mka;
        r1 = r1.containsKey(r0);
        if (r1 == 0) goto L_0x005e;
    L_0x0045:
        r1 = r3.mmN;
        r1 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r1);
        r1 = r1.mka;
        r0 = r1.get(r0);
        if (r0 != 0) goto L_0x005c;
    L_0x0053:
        r0 = new b.i;
        r1 = "null cannot be cast to non-null type kotlin.String";
        r0.<init>(r1);
        throw r0;
    L_0x005c:
        r0 = (java.lang.String) r0;
    L_0x005e:
        r1 = r3.mmQ;
        r1.put(r0, r0);
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.radar.ui.RadarViewController$c.d(com.tencent.mm.protocal.c.beq):void");
    }
}
