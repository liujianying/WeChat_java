package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.c.a;
import java.util.List;

public final class n {
    public static boolean a(a aVar, List<bd> list, ab abVar) {
        if (aVar == null) {
            x.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, context is null");
            return false;
        } else if (list == null || list.isEmpty()) {
            x.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, select item empty");
            return false;
        } else if (abVar != null && ((int) abVar.dhP) > 0) {
            return b(aVar, list, abVar);
        } else {
            x.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, contact error");
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b(com.tencent.mm.ui.chatting.c.a r10, java.util.List<com.tencent.mm.storage.bd> r11, com.tencent.mm.storage.ab r12) {
        /*
        r9 = 0;
        r8 = 2;
        r5 = 1;
        r6 = 0;
        r0 = r12.field_username;
        r1 = "@chatroom";
        r0 = r0.endsWith(r1);
        if (r0 != 0) goto L_0x00b2;
    L_0x000f:
        r0 = r10.tTq;
        r0 = r0.getMMResources();
        r1 = com.tencent.mm.R.l.send_mail_subject;
        r0 = r0.getString(r1);
        r1 = new java.lang.Object[r8];
        r2 = r12.BK();
        r1[r6] = r2;
        com.tencent.mm.model.au.HU();
        r2 = com.tencent.mm.model.c.DT();
        r3 = 4;
        r2 = r2.get(r3, r9);
        r1[r5] = r2;
        r0 = java.lang.String.format(r0, r1);
        r4 = r0;
    L_0x0036:
        r0 = com.tencent.mm.plugin.report.service.h.mEJ;
        r1 = 10811; // 0x2a3b float:1.515E-41 double:5.3413E-320;
        r2 = new java.lang.Object[r8];
        r3 = 7;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r6] = r3;
        r3 = r11.size();
        r3 = java.lang.Integer.valueOf(r3);
        r2[r5] = r3;
        r0.h(r1, r2);
        r0 = com.tencent.mm.model.q.GQ();
        r0 = r0 & 1;
        if (r0 != 0) goto L_0x01a6;
    L_0x0058:
        r0 = "MicroMsg.ChattingEditModeSendToMail";
        r1 = "use qq mail plugin to send mail";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = new java.util.ArrayList;
        r2.<init>();
        r3 = r11.iterator();
    L_0x006f:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0154;
    L_0x0075:
        r0 = r3.next();
        r0 = (com.tencent.mm.storage.bd) r0;
        r7 = r0.cmj();
        if (r7 == 0) goto L_0x0118;
    L_0x0081:
        com.tencent.mm.modelvideo.o.Ta();
        r0 = r0.field_imgPath;
        r0 = com.tencent.mm.modelvideo.s.nK(r0);
        r1.add(r0);
        r2.add(r9);
    L_0x0090:
        r0 = "MicroMsg.ChattingEditModeSendToMail";
        r7 = new java.lang.StringBuilder;
        r8 = "file path = ";
        r7.<init>(r8);
        r7 = r7.append(r1);
        r8 = "file name = ";
        r7 = r7.append(r8);
        r7 = r7.append(r2);
        r7 = r7.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r7);
        goto L_0x006f;
    L_0x00b2:
        r0 = r12.field_nickname;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 == 0) goto L_0x0113;
    L_0x00ba:
        r0 = r12.field_username;
        r1 = com.tencent.mm.model.m.gI(r0);
        r0 = "";
        r2 = r1.iterator();
        r1 = r0;
    L_0x00c8:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x00f2;
    L_0x00ce:
        r0 = r2.next();
        r0 = (java.lang.String) r0;
        r0 = com.tencent.mm.model.r.gT(r0);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r1 = r3.append(r1);
        r0 = r1.append(r0);
        r1 = ", ";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r1 = r0;
        goto L_0x00c8;
    L_0x00f2:
        r0 = r1.length();
        r0 = r0 + -2;
        r0 = r1.substring(r6, r0);
    L_0x00fc:
        r1 = r10.tTq;
        r1 = r1.getMMResources();
        r2 = com.tencent.mm.R.l.send_mail_suject_room;
        r1 = r1.getString(r2);
        r2 = new java.lang.Object[r5];
        r2[r6] = r0;
        r0 = java.lang.String.format(r1, r2);
        r4 = r0;
        goto L_0x0036;
    L_0x0113:
        r0 = r12.BK();
        goto L_0x00fc;
    L_0x0118:
        r7 = r0.aQm();
        if (r7 == 0) goto L_0x0090;
    L_0x011e:
        r0 = r0.field_content;
        r0 = com.tencent.mm.y.g.a.gp(r0);
        if (r0 == 0) goto L_0x006f;
    L_0x0126:
        r7 = r0.type;
        switch(r7) {
            case 4: goto L_0x012d;
            case 5: goto L_0x012b;
            case 6: goto L_0x012d;
            default: goto L_0x012b;
        };
    L_0x012b:
        goto L_0x0090;
    L_0x012d:
        r7 = com.tencent.mm.pluginsdk.model.app.ao.asF();
        r8 = r0.bGP;
        r7 = r7.SR(r8);
        if (r7 == 0) goto L_0x006f;
    L_0x0139:
        r8 = new java.io.File;
        r7 = r7.field_fileFullPath;
        r8.<init>(r7);
        r7 = r8.exists();
        if (r7 == 0) goto L_0x0090;
    L_0x0146:
        r7 = r8.getAbsolutePath();
        r1.add(r7);
        r0 = r0.title;
        r2.add(r0);
        goto L_0x0090;
    L_0x0154:
        r0 = new com.tencent.mm.ui.chatting.QQMailHistoryExporter;
        r3 = r10.tTq;
        r3 = r3.getContext();
        r0.<init>(r3, r11, r12);
        r0 = r0.cuj();
        r3 = new android.content.Intent;
        r3.<init>();
        r7 = "mail_mode";
        r8 = 6;
        r3.putExtra(r7, r8);
        r7 = "mail_content";
        r3.putExtra(r7, r0);
        r0 = "subject";
        r3.putExtra(r0, r4);
        r0 = "show_qqmail";
        r3.putExtra(r0, r5);
        r4 = "mail_attach";
        r0 = r1;
        r0 = (java.util.ArrayList) r0;
        r3.putStringArrayListExtra(r4, r0);
        r1 = "mail_attach_title";
        r0 = r2;
        r0 = (java.util.ArrayList) r0;
        r3.putStringArrayListExtra(r1, r0);
        r0 = r10.tTo;
        r1 = "qqmail";
        r2 = ".ui.ComposeUI";
        r4 = 220; // 0xdc float:3.08E-43 double:1.087E-321;
        r5 = new com.tencent.mm.ui.chatting.n$1;
        r5.<init>(r10);
        com.tencent.mm.bg.d.a(r0, r1, r2, r3, r4, r5);
    L_0x01a5:
        return r6;
    L_0x01a6:
        r0 = "MicroMsg.ChattingEditModeSendToMail";
        r1 = "use order mail app to send mail";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        r1 = new com.tencent.mm.ui.chatting.aj;
        r0 = r10.tTq;
        r0 = r0.getContext();
        r1.<init>(r0, r11, r12);
        r0 = r1.cuj();
        r2 = new android.content.Intent;
        r3 = "android.intent.action.SEND_MULTIPLE";
        r2.<init>(r3);
        r3 = "message/rfc822";
        r2.setType(r3);
        r3 = "android.intent.extra.SUBJECT";
        r2.putExtra(r3, r4);
        r3 = "android.intent.extra.TEXT";
        r2.putExtra(r3, r0);
        r3 = "android.intent.extra.STREAM";
        r4 = "MicroMsg.OtherMailHistoryExporter";
        r7 = "get image attach: history is null? %B, selectItems.size = %d";
        r8 = new java.lang.Object[r8];
        r0 = r1.juM;
        if (r0 != 0) goto L_0x021d;
    L_0x01e7:
        r0 = r5;
    L_0x01e8:
        r0 = java.lang.Boolean.valueOf(r0);
        r8[r6] = r0;
        r0 = r1.tIM;
        r0 = r0.size();
        r0 = java.lang.Integer.valueOf(r0);
        r8[r5] = r0;
        com.tencent.mm.sdk.platformtools.x.d(r4, r7, r8);
        r0 = r1.juM;
        if (r0 == 0) goto L_0x021f;
    L_0x0201:
        r0 = r1.tMF;
    L_0x0203:
        r2.putParcelableArrayListExtra(r3, r0);
        r0 = r10.tTq;	 Catch:{ ActivityNotFoundException -> 0x022e }
        r1 = r10.tTq;	 Catch:{ ActivityNotFoundException -> 0x022e }
        r1 = r1.getContext();	 Catch:{ ActivityNotFoundException -> 0x022e }
        r3 = com.tencent.mm.R.l.send_mail_selector;	 Catch:{ ActivityNotFoundException -> 0x022e }
        r1 = r1.getString(r3);	 Catch:{ ActivityNotFoundException -> 0x022e }
        r1 = android.content.Intent.createChooser(r2, r1);	 Catch:{ ActivityNotFoundException -> 0x022e }
        r0.startActivity(r1);	 Catch:{ ActivityNotFoundException -> 0x022e }
    L_0x021b:
        r6 = r5;
        goto L_0x01a5;
    L_0x021d:
        r0 = r6;
        goto L_0x01e8;
    L_0x021f:
        r0 = "MicroMsg.OtherMailHistoryExporter";
        r4 = "had not exported, do export first";
        com.tencent.mm.sdk.platformtools.x.w(r0, r4);
        r1.cuj();
        r0 = r1.tMF;
        goto L_0x0203;
    L_0x022e:
        r0 = move-exception;
        r0 = r10.tTq;
        r0 = r0.getContext();
        r1 = com.tencent.mm.R.l.send_no_email_app;
        r0 = android.widget.Toast.makeText(r0, r1, r6);
        r0.show();
        goto L_0x021b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.n.b(com.tencent.mm.ui.chatting.c.a, java.util.List, com.tencent.mm.storage.ab):boolean");
    }
}
