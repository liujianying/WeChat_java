package com.tencent.mm.plugin.profile.ui.newbizinfo;

import com.tencent.mm.pluginsdk.ui.applet.a$a;

class b$7 implements a$a {
    final /* synthetic */ b lYu;

    b$7(b bVar) {
        this.lYu = bVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r9, boolean r10, java.lang.String r11, java.lang.String r12) {
        /*
        r8 = this;
        r1 = 0;
        r3 = 0;
        r2 = 1;
        if (r9 == 0) goto L_0x0117;
    L_0x0005:
        r0 = r8.lYu;
        r0 = r0.lYs;
        r4 = r8.lYu;
        r4 = r4.lYs;
        r5 = com.tencent.mm.R.l.contact_info_biz_new_add_ok;
        r4 = r4.getString(r5);
        com.tencent.mm.ui.base.h.bA(r0, r4);
        r0 = r8.lYu;
        r0 = r0.eOE;
        r4 = "contact_info_time_expired";
        r0.bw(r4, r2);
        r0 = r8.lYu;
        r4 = r0.guS;
        if (r4 == 0) goto L_0x002c;
    L_0x0026:
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r11);
        if (r0 == 0) goto L_0x0118;
    L_0x002c:
        r0 = "MicroMsg.ContactWidgetNewBizInfo";
        r5 = new java.lang.StringBuilder;
        r6 = "respUsername == ";
        r5.<init>(r6);
        r5 = r5.append(r11);
        r6 = ", contact = ";
        r5 = r5.append(r6);
        r4 = r5.append(r4);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.x.e(r0, r4);
    L_0x004d:
        r0 = r8.lYu;
        r0 = r0.lVR;
        if (r0 == 0) goto L_0x006c;
    L_0x0053:
        r0 = new com.tencent.mm.g.a.ng;
        r0.<init>();
        r4 = r8.lYu;
        r4 = r4.lVR;
        r5 = 4;
        r4.egJ = r5;
        r4 = r0.bYk;
        r5 = r8.lYu;
        r5 = r5.lVR;
        r4.bYl = r5;
        r4 = com.tencent.mm.sdk.b.a.sFg;
        r4.m(r0);
    L_0x006c:
        r0 = com.tencent.mm.ac.z.MY();
        r4 = r8.lYu;
        r4 = r4.guS;
        r4 = r4.field_username;
        r0 = r0.kA(r4);
        r0.field_status = r2;
        r4 = r0.field_extInfo;
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r4 == 0) goto L_0x01da;
    L_0x0084:
        r4 = r0.field_username;
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r4 != 0) goto L_0x01da;
    L_0x008c:
        r4 = r8.lYu;
        r4 = r4.lUs;
        if (r4 == 0) goto L_0x01da;
    L_0x0092:
        r4 = r0.field_username;
        r5 = r8.lYu;
        r5 = r5.lUs;
        r5 = r5.field_username;
        r5 = com.tencent.mm.sdk.platformtools.bi.oV(r5);
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x01da;
    L_0x00a4:
        r4 = com.tencent.mm.ac.z.MY();
        r5 = r8.lYu;
        r5 = r5.lUs;
        r4.e(r5);
    L_0x00af:
        r4 = r8.lYu;
        r4 = r4.lYs;
        r4 = r4.getIntent();
        r5 = "key_biz_profile_stay_after_follow_op";
        r4 = r4.getBooleanExtra(r5, r3);
        r5 = r8.lYu;
        r5 = r5.lYs;
        r5 = r5.getIntent();
        r6 = "key_start_biz_profile_from_app_brand_profile";
        r3 = r5.getBooleanExtra(r6, r3);
        r0 = r0.LY();
        if (r0 == 0) goto L_0x01e3;
    L_0x00d3:
        r0 = new android.content.Intent;
        r0.<init>();
        r2 = "enterprise_biz_name";
        r3 = r8.lYu;
        r3 = r3.guS;
        r3 = r3.field_username;
        r0.putExtra(r2, r3);
        r2 = "enterprise_biz_display_name";
        r3 = r8.lYu;
        r3 = r3.guS;
        r3 = r3.field_username;
        r3 = com.tencent.mm.model.r.gT(r3);
        r0.putExtra(r2, r3);
        r2 = "enterprise_from_scene";
        r3 = 7;
        r0.putExtra(r2, r3);
        r2 = 67108864; // 0x4000000 float:1.5046328E-36 double:3.31561842E-316;
        r0.addFlags(r2);
        r2 = r8.lYu;
        r2 = r2.lYs;
        r3 = ".ui.conversation.EnterpriseConversationUI";
        com.tencent.mm.bg.d.e(r2, r3, r0);
    L_0x010a:
        r0 = r8.lYu;
        r0 = r0.lYs;
        r0.finish();
    L_0x0111:
        r0 = r8.lYu;
        r2 = 3;
        r0.ay(r2, r1);
    L_0x0117:
        return;
    L_0x0118:
        r0 = r4.field_username;
        r0 = com.tencent.mm.model.s.hd(r0);
        if (r0 == 0) goto L_0x0216;
    L_0x0120:
        r0 = r4.field_username;
        r5 = com.tencent.mm.sdk.platformtools.bi.oV(r0);
        r0 = com.tencent.mm.ac.f.kH(r5);
        if (r0 == 0) goto L_0x012e;
    L_0x012c:
        r0.field_username = r11;
    L_0x012e:
        r6 = com.tencent.mm.ac.z.MY();
        r6.delete(r5);
        r4.dD(r5);
    L_0x0138:
        r4.setUsername(r11);
        r6 = r4.dhP;
        r5 = (int) r6;
        if (r5 != 0) goto L_0x014a;
    L_0x0140:
        com.tencent.mm.model.au.HU();
        r5 = com.tencent.mm.model.c.FR();
        r5.U(r4);
    L_0x014a:
        r6 = r4.dhP;
        r5 = (int) r6;
        if (r5 > 0) goto L_0x015a;
    L_0x014f:
        r0 = "MicroMsg.ContactWidgetNewBizInfo";
        r4 = "addContact : insert contact failed";
        com.tencent.mm.sdk.platformtools.x.e(r0, r4);
        goto L_0x004d;
    L_0x015a:
        com.tencent.mm.model.s.p(r4);
        com.tencent.mm.model.au.HU();
        r5 = com.tencent.mm.model.c.FR();
        r4 = r4.field_username;
        r4 = r5.Yg(r4);
        if (r0 == 0) goto L_0x0175;
    L_0x016c:
        r4 = com.tencent.mm.ac.z.MY();
        r4.d(r0);
        goto L_0x004d;
    L_0x0175:
        r0 = r4.field_username;
        r5 = com.tencent.mm.ac.f.kH(r0);
        r0 = r4.ckW();
        if (r0 == 0) goto L_0x01ac;
    L_0x0181:
        r0 = com.tencent.mm.ac.a.LP();
        if (r0 == 0) goto L_0x01ac;
    L_0x0187:
        r0 = r2;
    L_0x0188:
        if (r5 == 0) goto L_0x0192;
    L_0x018a:
        r5 = r5.LS();
        if (r5 == 0) goto L_0x01ae;
    L_0x0190:
        if (r0 != 0) goto L_0x01ae;
    L_0x0192:
        r0 = "MicroMsg.ContactWidgetNewBizInfo";
        r5 = "shouldUpdate";
        com.tencent.mm.sdk.platformtools.x.d(r0, r5);
        r0 = com.tencent.mm.model.am.a.dBr;
        r5 = r4.field_username;
        r6 = "";
        r0.R(r5, r6);
        r0 = r4.field_username;
        com.tencent.mm.aa.c.jN(r0);
        goto L_0x004d;
    L_0x01ac:
        r0 = r3;
        goto L_0x0188;
    L_0x01ae:
        r5 = r4.ckZ();
        if (r5 == 0) goto L_0x004d;
    L_0x01b4:
        if (r0 != 0) goto L_0x004d;
    L_0x01b6:
        r0 = "MicroMsg.ContactWidgetNewBizInfo";
        r5 = "update contact, last check time=%d";
        r6 = new java.lang.Object[r2];
        r7 = r4.csR;
        r7 = java.lang.Integer.valueOf(r7);
        r6[r3] = r7;
        com.tencent.mm.sdk.platformtools.x.d(r0, r5, r6);
        r0 = com.tencent.mm.model.am.a.dBr;
        r5 = r4.field_username;
        r6 = "";
        r0.R(r5, r6);
        r0 = r4.field_username;
        com.tencent.mm.aa.c.jN(r0);
        goto L_0x004d;
    L_0x01da:
        r4 = com.tencent.mm.ac.z.MY();
        r4.e(r0);
        goto L_0x00af;
    L_0x01e3:
        r0 = new android.content.Intent;
        r0.<init>();
        r5 = "Chat_User";
        r6 = r8.lYu;
        r6 = r6.guS;
        r6 = r6.field_username;
        r0.putExtra(r5, r6);
        r5 = "key_has_add_contact";
        r0.putExtra(r5, r2);
        r5 = "finish_direct";
        r0.putExtra(r5, r2);
        if (r3 == 0) goto L_0x0207;
    L_0x0202:
        r2 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r0.addFlags(r2);
    L_0x0207:
        r2 = com.tencent.mm.plugin.profile.a.ezn;
        r5 = r8.lYu;
        r5 = r5.lYs;
        r2.e(r0, r5);
        if (r4 != 0) goto L_0x010a;
    L_0x0212:
        if (r3 == 0) goto L_0x0111;
    L_0x0214:
        goto L_0x010a;
    L_0x0216:
        r0 = r1;
        goto L_0x0138;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.newbizinfo.b$7.a(boolean, boolean, java.lang.String, java.lang.String):void");
    }
}
