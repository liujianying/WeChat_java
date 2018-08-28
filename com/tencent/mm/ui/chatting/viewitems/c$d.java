package com.tencent.mm.ui.chatting.viewitems;

import android.support.design.a$i;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.model.bf;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.t.h;
import com.tencent.mm.ui.chatting.t.i;
import com.tencent.mm.ui.chatting.t.k;
import com.tencent.mm.y.g;

public class c$d extends b {
    private boolean qpi;
    private a tKy;
    private c tXU;
    protected i uaA;
    protected h uay;
    protected k uaz;

    public final boolean bba() {
        return false;
    }

    public c$d() {
        c.a aVar = new c.a();
        aVar.dXN = R.k.app_brand_app_default_icon_for_tail;
        aVar.bg(com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 20), com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 20)).dXw = true;
        this.tXU = aVar.Pt();
    }

    public final boolean aq(int i, boolean z) {
        if ((!z && i == 49) || i == 335544369 || i == 402653233 || i == 369098801) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new r(layoutInflater, R.i.chatting_item_from_appmsg);
        view.setTag(new c.c().p(view, true));
        return view;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.ui.chatting.viewitems.b.a r26, int r27, com.tencent.mm.ui.chatting.c.a r28, com.tencent.mm.storage.bd r29, java.lang.String r30) {
        /*
        r25 = this;
        r20 = r26;
        r20 = (com.tencent.mm.ui.chatting.viewitems.c.c) r20;
        r0 = r28;
        r1 = r25;
        r1.tKy = r0;
        r20.reset();
        r0 = r29;
        r7 = r0.field_content;
        r6 = com.tencent.mm.ui.chatting.b.b.i.class;
        r0 = r28;
        r6 = r0.O(r6);
        r6 = (com.tencent.mm.ui.chatting.b.b.i) r6;
        r0 = r29;
        r6.aV(r0);
        r0 = r29;
        r6.aW(r0);
        r0 = r29;
        r6.aX(r0);
        r0 = r25;
        r6 = r0.qpi;
        if (r6 == 0) goto L_0x143f;
    L_0x0030:
        r0 = r29;
        r6 = r0.field_content;
        r8 = 58;
        r6 = r6.indexOf(r8);
        r8 = -1;
        if (r6 == r8) goto L_0x143f;
    L_0x003d:
        r0 = r29;
        r7 = r0.field_content;
        r6 = r6 + 1;
        r6 = r7.substring(r6);
        r16 = r6;
    L_0x0049:
        r7 = 0;
        r6 = 0;
        if (r16 == 0) goto L_0x0437;
    L_0x004d:
        r0 = r29;
        r6 = r0.field_reserved;
        r0 = r16;
        r7 = com.tencent.mm.y.g.a.J(r0, r6);
        r6 = com.tencent.mm.y.k.gv(r16);
        r14 = r6;
        r21 = r7;
    L_0x005e:
        r6 = new com.tencent.mm.ui.chatting.viewitems.au;
        r8 = r28.cwr();
        r10 = 0;
        r11 = 0;
        r7 = r29;
        r9 = r27;
        r6.<init>(r7, r8, r9, r10, r11);
        r15 = 0;
        if (r21 == 0) goto L_0x03f4;
    L_0x0070:
        r0 = r20;
        r7 = r0.eCm;
        r8 = r21.getTitle();
        r7.setText(r8);
        r0 = r20;
        r7 = r0.eCn;
        r8 = r21.getDescription();
        r7.setText(r8);
        r0 = r20;
        r7 = r0.tZN;
        r8 = 1;
        r7.setMaxLines(r8);
        r0 = r20;
        r7 = r0.eCm;
        r0 = r28;
        r8 = r0.tTq;
        r8 = r8.getContext();
        r8 = r8.getResources();
        r9 = com.tencent.mm.R.e.normal_text_color;
        r8 = r8.getColor(r9);
        r7.setTextColor(r8);
        r0 = r20;
        r7 = r0.eCn;
        r0 = r28;
        r8 = r0.tTq;
        r8 = r8.getContext();
        r8 = r8.getResources();
        r9 = com.tencent.mm.R.e.hint_text_color;
        r8 = r8.getColor(r9);
        r7.setTextColor(r8);
        r0 = r20;
        r7 = r0.uad;
        r8 = com.tencent.mm.R.g.chat_from_content_bg_mask;
        r7.setBackgroundResource(r8);
        r0 = r20;
        r7 = r0.uad;
        r8 = 0;
        r0 = r28;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = r9.getResources();
        r10 = com.tencent.mm.R.f.MiddlePadding;
        r9 = r9.getDimensionPixelSize(r10);
        r10 = 0;
        r11 = 0;
        r7.setPadding(r8, r9, r10, r11);
        r0 = r20;
        r7 = r0.tZI;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.uab;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.eCn;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZP;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZS;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZR;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.uaf;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.uag;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZK;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZL;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.uaq;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.uaj;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.uad;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.uac;
        r0 = r20;
        r8 = r0.uau;
        com.tencent.mm.ui.chatting.viewitems.c.c.P(r7, r8);
        r7 = com.tencent.mm.y.e.class;
        r0 = r21;
        r7 = r0.u(r7);
        r7 = (com.tencent.mm.y.e) r7;
        r0 = r20;
        r8 = r0.tZV;
        if (r7 != 0) goto L_0x0456;
    L_0x0171:
        r7 = 0;
    L_0x0172:
        r0 = r29;
        r9 = r0.field_talker;
        r7 = r8.l(r7, r9);
        if (r7 == 0) goto L_0x045a;
    L_0x017c:
        r0 = r20;
        r7 = r0.uac;
        r8 = com.tencent.mm.R.g.chatfrom_bg_apptop;
        r7.setBackgroundResource(r8);
    L_0x0185:
        r0 = r21;
        r7 = r0.appId;
        r0 = r21;
        r8 = r0.cbu;
        r24 = com.tencent.mm.pluginsdk.model.app.g.cP(r7, r8);
        if (r24 == 0) goto L_0x01a2;
    L_0x0193:
        r7 = r24.aaq();
        if (r7 == 0) goto L_0x01a2;
    L_0x0199:
        r0 = r28;
        r1 = r21;
        r2 = r29;
        b(r0, r1, r2);
    L_0x01a2:
        if (r24 == 0) goto L_0x01b8;
    L_0x01a4:
        r0 = r24;
        r7 = r0.field_appName;
        if (r7 == 0) goto L_0x01b8;
    L_0x01aa:
        r0 = r24;
        r7 = r0.field_appName;
        r7 = r7.trim();
        r7 = r7.length();
        if (r7 > 0) goto L_0x0465;
    L_0x01b8:
        r0 = r21;
        r7 = r0.appName;
    L_0x01bc:
        r8 = 1;
        r0 = r28;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r10 = 12;
        com.tencent.mm.bp.a.fromDPToPix(r9, r10);
        r0 = r21;
        r9 = r0.type;
        r10 = 20;
        if (r9 == r10) goto L_0x01df;
    L_0x01d2:
        r9 = "wxaf060266bfa9a35c";
        r0 = r21;
        r10 = r0.appId;
        r9 = r9.equals(r10);
        if (r9 == 0) goto L_0x01e7;
    L_0x01df:
        r8 = com.tencent.mm.pluginsdk.o.a.cbj();
        r8 = r8.buA();
    L_0x01e7:
        if (r8 == 0) goto L_0x047a;
    L_0x01e9:
        r0 = r21;
        r8 = r0.appId;
        if (r8 == 0) goto L_0x047a;
    L_0x01ef:
        r0 = r21;
        r8 = r0.appId;
        r8 = r8.length();
        if (r8 <= 0) goto L_0x047a;
    L_0x01f9:
        r8 = com.tencent.mm.pluginsdk.model.app.g.cT(r7);
        if (r8 == 0) goto L_0x047a;
    L_0x01ff:
        r0 = r20;
        r8 = r0.jet;
        r0 = r28;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r0 = r24;
        r7 = com.tencent.mm.pluginsdk.model.app.g.b(r9, r0, r7);
        r8.setText(r7);
        r0 = r20;
        r7 = r0.jet;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.jet;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r11 = 0;
        r7.setCompoundDrawables(r8, r9, r10, r11);
        r0 = r20;
        r7 = r0.tZM;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZJ;
        r8 = 0;
        r7.setVisibility(r8);
        if (r24 == 0) goto L_0x046b;
    L_0x0239:
        r7 = r24.aaq();
        if (r7 == 0) goto L_0x046b;
    L_0x023f:
        r0 = r20;
        r8 = r0.jet;
        r0 = r24;
        r11 = r0.field_packageName;
        r0 = r29;
        r12 = r0.field_msgSvrId;
        r7 = r28;
        r9 = r29;
        r10 = r21;
        a(r7, r8, r9, r10, r11, r12);
    L_0x0254:
        r0 = r20;
        r7 = r0.tZJ;
        r0 = r21;
        r8 = r0.appId;
        r0 = r28;
        a(r0, r7, r8);
    L_0x0261:
        r0 = r21;
        r7 = r0.dwl;
        if (r7 == 0) goto L_0x050f;
    L_0x0267:
        r0 = r21;
        r7 = r0.dwl;
        r7 = r7.dzn;
        if (r7 == 0) goto L_0x050f;
    L_0x026f:
        r7 = 1;
    L_0x0270:
        if (r7 == 0) goto L_0x027b;
    L_0x0272:
        r0 = r20;
        r7 = r0.tZM;
        r8 = 8;
        r7.setVisibility(r8);
    L_0x027b:
        r7 = 0;
        r0 = r20;
        r8 = r0.tZI;
        r9 = 0;
        r8.setVisibility(r9);
        r0 = r21;
        r8 = r0.dwl;
        if (r8 == 0) goto L_0x0512;
    L_0x028a:
        r0 = r21;
        r8 = r0.dwl;
        r8 = r8.dzk;
        r9 = 1;
        if (r8 != r9) goto L_0x0512;
    L_0x0293:
        r8 = 1;
    L_0x0294:
        if (r8 != 0) goto L_0x0518;
    L_0x0296:
        r0 = r25;
        r8 = r0.qUB;
        if (r8 == 0) goto L_0x0518;
    L_0x029c:
        r8 = 0;
        r0 = r21;
        r9 = r0.type;
        r10 = 33;
        if (r9 == r10) goto L_0x02c6;
    L_0x02a5:
        r0 = r21;
        r9 = r0.type;
        r10 = 36;
        if (r9 == r10) goto L_0x02c6;
    L_0x02ad:
        r8 = com.tencent.mm.ak.o.Pf();
        r0 = r29;
        r9 = r0.field_imgPath;
        r0 = r28;
        r10 = r0.tTq;
        r10 = r10.getContext();
        r10 = com.tencent.mm.bp.a.getDensity(r10);
        r11 = 0;
        r8 = r8.a(r9, r10, r11);
    L_0x02c6:
        if (r8 == 0) goto L_0x0515;
    L_0x02c8:
        r9 = r8.isRecycled();
        if (r9 != 0) goto L_0x0515;
    L_0x02ce:
        r0 = r20;
        r9 = r0.tZI;
        r9.setImageBitmap(r8);
    L_0x02d5:
        r0 = r21;
        r9 = r0.type;
        r10 = 3;
        if (r9 != r10) goto L_0x02f2;
    L_0x02dc:
        r0 = r20;
        r9 = r0.uad;
        r9 = r9.getViewTreeObserver();
        r10 = new com.tencent.mm.ui.chatting.viewitems.c$d$1;
        r0 = r25;
        r1 = r20;
        r2 = r28;
        r10.<init>(r1, r2, r8);
        r9.addOnPreDrawListener(r10);
    L_0x02f2:
        r22 = r7;
    L_0x02f4:
        r0 = r21;
        r7 = r0.cGB;
        if (r7 == 0) goto L_0x0304;
    L_0x02fa:
        r0 = r21;
        r7 = r0.cGB;
        r7 = r7.length();
        if (r7 != 0) goto L_0x0531;
    L_0x0304:
        r0 = r20;
        r7 = r0.tZU;
        r8 = 8;
        r7.setVisibility(r8);
    L_0x030d:
        r0 = r20;
        r7 = r0.tZT;
        r8 = 0;
        r7.setOnClickListener(r8);
        r0 = r20;
        r7 = r0.tZX;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZO;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.uaa;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZY;
        r8 = 8;
        r7.setVisibility(r8);
        r23 = 0;
        r0 = r21;
        r7 = r0.type;
        switch(r7) {
            case 0: goto L_0x0d28;
            case 1: goto L_0x0340;
            case 2: goto L_0x0340;
            case 3: goto L_0x054e;
            case 4: goto L_0x0713;
            case 5: goto L_0x07a5;
            case 6: goto L_0x0662;
            case 7: goto L_0x0ae1;
            case 8: goto L_0x0340;
            case 9: goto L_0x0340;
            case 10: goto L_0x0b6d;
            case 11: goto L_0x0340;
            case 12: goto L_0x0340;
            case 13: goto L_0x0c2c;
            case 14: goto L_0x0340;
            case 15: goto L_0x0dad;
            case 16: goto L_0x109e;
            case 17: goto L_0x0340;
            case 18: goto L_0x0340;
            case 19: goto L_0x11e2;
            case 20: goto L_0x0ca6;
            case 21: goto L_0x0340;
            case 22: goto L_0x0340;
            case 23: goto L_0x0340;
            case 24: goto L_0x1139;
            case 25: goto L_0x0e78;
            case 26: goto L_0x0f52;
            case 27: goto L_0x0f52;
            case 28: goto L_0x0340;
            case 29: goto L_0x0340;
            case 30: goto L_0x0340;
            case 31: goto L_0x0340;
            case 32: goto L_0x0340;
            case 33: goto L_0x095d;
            case 34: goto L_0x11f2;
            case 35: goto L_0x0340;
            case 36: goto L_0x087c;
            case 37: goto L_0x0340;
            case 38: goto L_0x0340;
            case 39: goto L_0x0340;
            case 40: goto L_0x13a8;
            default: goto L_0x0340;
        };
    L_0x0340:
        r7 = 1;
        r12 = r6;
    L_0x0342:
        if (r7 == 0) goto L_0x03ce;
    L_0x0344:
        r0 = r21;
        r6 = r0.title;
        if (r6 == 0) goto L_0x13be;
    L_0x034a:
        r0 = r21;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x13be;
    L_0x0354:
        r0 = r20;
        r6 = r0.tZN;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.tZN;
        r7 = 2;
        r6.setMaxLines(r7);
        r0 = r20;
        r6 = r0.tZN;
        r0 = r21;
        r7 = r0.title;
        r6.setText(r7);
    L_0x036f:
        r0 = r20;
        r6 = r0.eCm;
        r7 = 8;
        r6.setVisibility(r7);
        if (r22 == 0) goto L_0x03ce;
    L_0x037a:
        r0 = r21;
        r6 = r0.type;
        r7 = 33;
        if (r6 == r7) goto L_0x038a;
    L_0x0382:
        r0 = r21;
        r6 = r0.type;
        r7 = 36;
        if (r6 != r7) goto L_0x13c9;
    L_0x038a:
        r6 = com.tencent.mm.ak.o.Pf();
        r0 = r29;
        r7 = r0.field_imgPath;
        r8 = 0;
        r9 = 1;
        r8 = r6.d(r7, r8, r9);
        r0 = r20;
        r6 = r0.tZI;
        r7 = com.tencent.mm.R.k.app_attach_file_icon_webpage;
        r6.setImageResource(r7);
        r6 = com.tencent.mm.modelappbrand.b.b.Ka();
        r0 = r20;
        r7 = r0.tZI;
        r9 = new java.lang.StringBuilder;
        r10 = "file://";
        r9.<init>(r10);
        r8 = r9.append(r8);
        r8 = r8.toString();
        r9 = 0;
        r10 = 0;
        r11 = com.tencent.mm.modelappbrand.g.class;
        r11 = com.tencent.mm.kernel.g.l(r11);
        r11 = (com.tencent.mm.modelappbrand.g) r11;
        r13 = 50;
        r14 = 50;
        r11 = r11.bc(r13, r14);
        r6.a(r7, r8, r9, r10, r11);
    L_0x03ce:
        r6 = r28.cwr();
        if (r6 != 0) goto L_0x142b;
    L_0x03d4:
        r6 = com.tencent.mm.pluginsdk.model.app.g.g(r24);
        if (r6 == 0) goto L_0x141f;
    L_0x03da:
        r0 = r20;
        r6 = r0.tZW;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.tZW;
        r0 = r21;
        r1 = r29;
        r7 = com.tencent.mm.ui.chatting.viewitems.au.a(r0, r1);
        r0 = r28;
        c(r0, r6, r7);
        r6 = r12;
    L_0x03f4:
        if (r15 != 0) goto L_0x040c;
    L_0x03f6:
        r0 = r20;
        r7 = r0.uac;
        r7.setTag(r6);
        r0 = r20;
        r6 = r0.uac;
        r0 = r25;
        r1 = r28;
        r7 = r0.d(r1);
        r6.setOnClickListener(r7);
    L_0x040c:
        r0 = r25;
        r6 = r0.qUB;
        if (r6 == 0) goto L_0x0436;
    L_0x0412:
        r0 = r20;
        r6 = r0.uac;
        r0 = r25;
        r1 = r28;
        r7 = r0.c(r1);
        r6.setOnLongClickListener(r7);
        r0 = r20;
        r7 = r0.uac;
        r6 = com.tencent.mm.ui.chatting.b.b.g.class;
        r0 = r28;
        r6 = r0.O(r6);
        r6 = (com.tencent.mm.ui.chatting.b.b.g) r6;
        r6 = r6.ctw();
        r7.setOnTouchListener(r6);
    L_0x0436:
        return;
    L_0x0437:
        r8 = "MicroMsg.ChattingItemAppMsgFrom";
        r9 = "amessage, msgid:%s, user:%s";
        r10 = 2;
        r10 = new java.lang.Object[r10];
        r11 = 0;
        r0 = r29;
        r12 = r0.field_msgId;
        r12 = java.lang.Long.valueOf(r12);
        r10[r11] = r12;
        r11 = 1;
        r10[r11] = r30;
        com.tencent.mm.sdk.platformtools.x.e(r8, r9, r10);
        r14 = r6;
        r21 = r7;
        goto L_0x005e;
    L_0x0456:
        r7 = r7.dwk;
        goto L_0x0172;
    L_0x045a:
        r0 = r20;
        r7 = r0.uac;
        r8 = com.tencent.mm.R.g.chatfrom_bg_app;
        r7.setBackgroundResource(r8);
        goto L_0x0185;
    L_0x0465:
        r0 = r24;
        r7 = r0.field_appName;
        goto L_0x01bc;
    L_0x046b:
        r0 = r20;
        r7 = r0.jet;
        r0 = r21;
        r8 = r0.appId;
        r0 = r28;
        a(r0, r7, r8);
        goto L_0x0254;
    L_0x047a:
        r0 = r21;
        r7 = r0.type;
        r8 = 24;
        if (r7 != r8) goto L_0x04ae;
    L_0x0482:
        r0 = r20;
        r7 = r0.jet;
        r8 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r9 = com.tencent.mm.R.l.favorite;
        r8 = r8.getString(r9);
        r7.setText(r8);
        r0 = r20;
        r7 = r0.tZM;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.jet;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZJ;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x0261;
    L_0x04ae:
        r0 = r21;
        r7 = r0.type;
        r8 = 19;
        if (r7 == r8) goto L_0x04bc;
    L_0x04b6:
        r7 = r14.dzv;
        r8 = 19;
        if (r7 != r8) goto L_0x04e8;
    L_0x04bc:
        r0 = r20;
        r7 = r0.jet;
        r8 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r9 = com.tencent.mm.R.l.chatting_item_record;
        r8 = r8.getString(r9);
        r7.setText(r8);
        r0 = r20;
        r7 = r0.tZM;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.jet;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZJ;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x0261;
    L_0x04e8:
        r0 = r21;
        r1 = r20;
        r7 = com.tencent.mm.ui.chatting.viewitems.c.a(r0, r1);
        if (r7 != 0) goto L_0x0261;
    L_0x04f2:
        r0 = r20;
        r7 = r0.tZM;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.jet;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZJ;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x0261;
    L_0x050f:
        r7 = 0;
        goto L_0x0270;
    L_0x0512:
        r8 = 0;
        goto L_0x0294;
    L_0x0515:
        r7 = 1;
        goto L_0x02d5;
    L_0x0518:
        r0 = r20;
        r8 = r0.tZI;
        r0 = r28;
        r9 = r0.tTq;
        r9 = r9.getMMResources();
        r10 = com.tencent.mm.R.g.nosdcard_app;
        r9 = android.graphics.BitmapFactory.decodeResource(r9, r10);
        r8.setImageBitmap(r9);
        r22 = r7;
        goto L_0x02f4;
    L_0x0531:
        r0 = r20;
        r7 = r0.tZU;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZU;
        r0 = r21;
        r8 = r0.cGB;
        r8 = com.tencent.mm.ui.chatting.viewitems.au.aaI(r8);
        r0 = r25;
        r1 = r28;
        r0.b(r1, r7, r8);
        goto L_0x030d;
    L_0x054e:
        r0 = r21;
        r7 = r0.title;
        if (r7 == 0) goto L_0x0645;
    L_0x0554:
        r0 = r21;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x0645;
    L_0x055e:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.eCm;
        r0 = r28;
        r8 = r0.tTq;
        r8 = r8.getContext();
        r8 = r8.getResources();
        r9 = com.tencent.mm.R.e.white;
        r8 = r8.getColor(r9);
        r7.setTextColor(r8);
    L_0x057f:
        r0 = r20;
        r7 = r0.eCn;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.eCn;
        r0 = r28;
        r8 = r0.tTq;
        r8 = r8.getContext();
        r8 = r8.getResources();
        r9 = com.tencent.mm.R.e.white;
        r8 = r8.getColor(r9);
        r7.setTextColor(r8);
        r0 = r20;
        r7 = r0.tZN;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZO;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZT;
        r8 = 0;
        r7.setVisibility(r8);
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r0 = r29;
        r8 = r0.field_msgId;
        r7 = r7.append(r8);
        r7 = r7.toString();
        r0 = r26;
        r8 = r0.tZw;
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x0650;
    L_0x05d4:
        r0 = r20;
        r7 = r0.tZT;
        r8 = com.tencent.mm.R.g.music_pauseicon;
        r7.setImageResource(r8);
    L_0x05dd:
        r0 = r20;
        r7 = r0.eCn;
        r8 = 2;
        r7.setMaxLines(r8);
        if (r22 == 0) goto L_0x060d;
    L_0x05e7:
        r0 = r21;
        r7 = r0.appId;
        r8 = 1;
        r0 = r28;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = com.tencent.mm.bp.a.getDensity(r9);
        r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
        if (r7 == 0) goto L_0x0604;
    L_0x05fe:
        r8 = r7.isRecycled();
        if (r8 == 0) goto L_0x065a;
    L_0x0604:
        r0 = r20;
        r7 = r0.tZI;
        r8 = com.tencent.mm.R.k.app_attach_file_icon_music;
        r7.setImageResource(r8);
    L_0x060d:
        r7 = new com.tencent.mm.ui.chatting.viewitems.c$f;
        r7.<init>();
        r0 = r29;
        r8 = r0.field_msgId;
        r7.bJC = r8;
        r0 = r29;
        r8 = r0.field_content;
        r7.bVv = r8;
        r0 = r29;
        r8 = r0.field_imgPath;
        r7.bSw = r8;
        r0 = r20;
        r8 = r0.tZT;
        r8.setTag(r7);
        r0 = r20;
        r8 = r0.tZT;
        r7 = com.tencent.mm.ui.chatting.b.b.g.class;
        r0 = r28;
        r7 = r0.O(r7);
        r7 = (com.tencent.mm.ui.chatting.b.b.g) r7;
        r7 = r7.ctx();
        r8.setOnClickListener(r7);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x0645:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x057f;
    L_0x0650:
        r0 = r20;
        r7 = r0.tZT;
        r8 = com.tencent.mm.R.g.music_playicon;
        r7.setImageResource(r8);
        goto L_0x05dd;
    L_0x065a:
        r0 = r20;
        r8 = r0.tZI;
        r8.setImageBitmap(r7);
        goto L_0x060d;
    L_0x0662:
        r0 = r21;
        r7 = r0.title;
        if (r7 == 0) goto L_0x06f5;
    L_0x0668:
        r0 = r21;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x06f5;
    L_0x0672:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.eCm;
        r8 = 2;
        r7.setMaxLines(r8);
    L_0x0682:
        r0 = r20;
        r7 = r0.eCn;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZN;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZT;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZO;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.eCn;
        r8 = 2;
        r7.setMaxLines(r8);
        r0 = r20;
        r7 = r0.eCn;
        r0 = r21;
        r8 = r0.dwo;
        r8 = (long) r8;
        r8 = com.tencent.mm.sdk.platformtools.bi.bF(r8);
        r7.setText(r8);
        r0 = r21;
        r7 = r0.dwo;
        r0 = r20;
        r1 = r16;
        com.tencent.mm.ui.chatting.viewitems.c.c.a(r0, r1, r7);
        r7 = 1;
        r7 = java.lang.Boolean.valueOf(r7);
        r0 = r21;
        r8 = r0.bGP;
        r0 = r21;
        r9 = r0.title;
        r0 = r20;
        r1 = r29;
        com.tencent.mm.ui.chatting.viewitems.c.c.a(r0, r7, r1, r8, r9);
        if (r22 == 0) goto L_0x1437;
    L_0x06dd:
        r0 = r21;
        r7 = r0.dwp;
        r7 = com.tencent.mm.sdk.platformtools.bi.Xi(r7);
        if (r7 == 0) goto L_0x06ff;
    L_0x06e7:
        r0 = r20;
        r7 = r0.tZI;
        r8 = com.tencent.mm.R.g.appshareimage_icon;
        r7.setImageResource(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x06f5:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x0682;
    L_0x06ff:
        r0 = r20;
        r7 = r0.tZI;
        r0 = r21;
        r8 = r0.dwp;
        r8 = com.tencent.mm.pluginsdk.model.o.SQ(r8);
        r7.setImageResource(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x0713:
        r0 = r21;
        r7 = r0.title;
        if (r7 == 0) goto L_0x0793;
    L_0x0719:
        r0 = r21;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x0793;
    L_0x0723:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 0;
        r7.setVisibility(r8);
    L_0x072b:
        r0 = r20;
        r7 = r0.eCn;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZN;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZT;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZT;
        r8 = com.tencent.mm.R.g.video_download_btn;
        r7.setImageResource(r8);
        r0 = r20;
        r7 = r0.tZO;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.eCn;
        r8 = 2;
        r7.setMaxLines(r8);
        if (r22 == 0) goto L_0x1437;
    L_0x075f:
        r0 = r21;
        r7 = r0.appId;
        r8 = 1;
        r0 = r28;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = com.tencent.mm.bp.a.getDensity(r9);
        r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
        if (r7 == 0) goto L_0x077c;
    L_0x0776:
        r8 = r7.isRecycled();
        if (r8 == 0) goto L_0x079d;
    L_0x077c:
        r0 = r20;
        r7 = r0.tZI;
        r8 = com.tencent.mm.R.k.app_attach_file_icon_video;
        r7.setImageResource(r8);
    L_0x0785:
        r0 = r20;
        r7 = r0.tZT;
        r8 = 8;
        r7.setVisibility(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x0793:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x072b;
    L_0x079d:
        r0 = r20;
        r8 = r0.tZI;
        r8.setImageBitmap(r7);
        goto L_0x0785;
    L_0x07a5:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.title;
        if (r7 == 0) goto L_0x085b;
    L_0x07b4:
        r0 = r21;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x085b;
    L_0x07be:
        r0 = r20;
        r7 = r0.tZN;
        r8 = 2;
        r7.setMaxLines(r8);
        r0 = r20;
        r7 = r0.tZN;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZN;
        r8 = r21.getTitle();
        r7.setText(r8);
    L_0x07d9:
        r0 = r20;
        r7 = r0.eCn;
        r8 = 3;
        r7.setMaxLines(r8);
        r7 = com.tencent.mm.ui.chatting.viewitems.c.h(r21);
        if (r7 == 0) goto L_0x0866;
    L_0x07e7:
        r0 = r20;
        r7 = r0.tZT;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZT;
        r8 = com.tencent.mm.R.g.video_download_btn;
        r7.setImageResource(r8);
    L_0x07f8:
        r0 = r20;
        r7 = r0.tZO;
        r8 = 4;
        r7.setVisibility(r8);
        if (r22 == 0) goto L_0x1437;
    L_0x0802:
        r0 = r21;
        r7 = r0.appId;
        r8 = 1;
        r0 = r28;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = com.tencent.mm.bp.a.getDensity(r9);
        r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
        if (r7 == 0) goto L_0x081f;
    L_0x0819:
        r8 = r7.isRecycled();
        if (r8 == 0) goto L_0x0870;
    L_0x081f:
        r7 = new com.tencent.mm.ak.a.a.c$a;
        r7.<init>();
        r8 = com.tencent.mm.R.k.app_attach_file_icon_webpage;
        r7.dXN = r8;
        r8 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r9 = 50;
        r8 = com.tencent.mm.bp.a.fromDPToPix(r8, r9);
        r9 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r10 = 50;
        r9 = com.tencent.mm.bp.a.fromDPToPix(r9, r10);
        r8 = r7.bg(r8, r9);
        r9 = 1;
        r8.dXw = r9;
        r8 = com.tencent.mm.ak.o.Pj();
        r0 = r21;
        r9 = r0.thumburl;
        r0 = r20;
        r10 = r0.tZI;
        r7 = r7.Pt();
        r8.a(r9, r10, r7);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x085b:
        r0 = r20;
        r7 = r0.tZN;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x07d9;
    L_0x0866:
        r0 = r20;
        r7 = r0.tZT;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x07f8;
    L_0x0870:
        r0 = r20;
        r8 = r0.tZI;
        r8.setImageBitmap(r7);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x087c:
        r7 = com.tencent.mm.plugin.appbrand.n.c.class;
        r7 = com.tencent.mm.kernel.g.l(r7);
        r7 = (com.tencent.mm.plugin.appbrand.n.c) r7;
        r0 = r21;
        r8 = r0.dyS;
        r9 = r7.rR(r8);
        if (r9 == 0) goto L_0x093c;
    L_0x088e:
        r7 = r9.field_nickname;
        r8 = r7;
    L_0x0891:
        if (r9 == 0) goto L_0x0943;
    L_0x0893:
        r7 = r9.field_brandIconURL;
    L_0x0895:
        r0 = r20;
        r9 = r0.uad;
        r10 = 8;
        r9.setVisibility(r10);
        r0 = r20;
        r9 = r0.uaq;
        r10 = 0;
        r9.setVisibility(r10);
        r0 = r20;
        r9 = r0.uaj;
        r10 = 8;
        r9.setVisibility(r10);
        r0 = r20;
        r9 = r0.uam;
        r10 = 8;
        r9.setVisibility(r10);
        r0 = r20;
        r9 = r0.uat;
        r0 = r21;
        r10 = r0.title;
        r9.setText(r10);
        r0 = r20;
        r9 = r0.uam;
        r0 = r21;
        r10 = r0.description;
        r9.setText(r10);
        r0 = r20;
        r9 = r0.uao;
        r9.setText(r8);
        r0 = r21;
        r8 = r0.dyZ;
        switch(r8) {
            case 1: goto L_0x0949;
            case 2: goto L_0x0953;
            default: goto L_0x08dc;
        };
    L_0x08dc:
        r0 = r20;
        r8 = r0.uap;
        r9 = com.tencent.mm.R.l.app_brand_entrance;
        r8.setText(r9);
    L_0x08e5:
        r8 = com.tencent.mm.ak.o.Pj();
        r0 = r20;
        r9 = r0.uan;
        r0 = r25;
        r10 = r0.tXU;
        r8.a(r7, r9, r10);
        r7 = com.tencent.mm.ak.o.Pf();
        r0 = r29;
        r8 = r0.field_imgPath;
        r9 = 0;
        r10 = 1;
        r9 = r7.d(r8, r9, r10);
        r0 = r20;
        r7 = r0.uar;
        r8 = 0;
        r7.setImageBitmap(r8);
        r7 = com.tencent.mm.modelappbrand.b.b.Ka();
        r0 = r20;
        r8 = r0.uar;
        r10 = new java.lang.StringBuilder;
        r11 = "file://";
        r10.<init>(r11);
        r9 = r10.append(r9);
        r9 = r9.toString();
        r10 = 0;
        r11 = 0;
        r12 = com.tencent.mm.modelappbrand.g.class;
        r12 = com.tencent.mm.kernel.g.l(r12);
        r12 = (com.tencent.mm.modelappbrand.g) r12;
        r13 = 240; // 0xf0 float:3.36E-43 double:1.186E-321;
        r14 = 192; // 0xc0 float:2.69E-43 double:9.5E-322;
        r12 = r12.bc(r13, r14);
        r7.a(r8, r9, r10, r11, r12);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x093c:
        r0 = r21;
        r7 = r0.bZH;
        r8 = r7;
        goto L_0x0891;
    L_0x0943:
        r0 = r21;
        r7 = r0.dzb;
        goto L_0x0895;
    L_0x0949:
        r0 = r20;
        r8 = r0.uap;
        r9 = com.tencent.mm.R.l.app_brand_share_wxa_testing_tag;
        r8.setText(r9);
        goto L_0x08e5;
    L_0x0953:
        r0 = r20;
        r8 = r0.uap;
        r9 = com.tencent.mm.R.l.app_brand_share_wxa_preview_tag;
        r8.setText(r9);
        goto L_0x08e5;
    L_0x095d:
        r7 = com.tencent.mm.plugin.appbrand.n.c.class;
        r7 = com.tencent.mm.kernel.g.l(r7);
        r7 = (com.tencent.mm.plugin.appbrand.n.c) r7;
        r0 = r21;
        r8 = r0.dyS;
        r9 = r7.rR(r8);
        r0 = r21;
        r7 = r0.dyU;
        switch(r7) {
            case 1: goto L_0x0a5f;
            case 2: goto L_0x0978;
            case 3: goto L_0x0978;
            default: goto L_0x0974;
        };
    L_0x0974:
        r7 = 1;
        r12 = r6;
        goto L_0x0342;
    L_0x0978:
        if (r9 == 0) goto L_0x0a3c;
    L_0x097a:
        r7 = r9.field_nickname;
        r8 = r7;
    L_0x097d:
        if (r9 == 0) goto L_0x0a43;
    L_0x097f:
        r7 = r9.field_brandIconURL;
    L_0x0981:
        r0 = r20;
        r9 = r0.uad;
        r10 = 8;
        r9.setVisibility(r10);
        r0 = r20;
        r9 = r0.uaq;
        r10 = 0;
        r9.setVisibility(r10);
        r0 = r20;
        r9 = r0.uaj;
        r10 = 8;
        r9.setVisibility(r10);
        r0 = r20;
        r9 = r0.uam;
        r10 = 8;
        r9.setVisibility(r10);
        r0 = r20;
        r9 = r0.uat;
        r0 = r21;
        r10 = r0.title;
        r9.setText(r10);
        r0 = r20;
        r9 = r0.uam;
        r0 = r21;
        r10 = r0.description;
        r9.setText(r10);
        r0 = r20;
        r9 = r0.uao;
        r9.setText(r8);
        r0 = r21;
        r8 = r0.dyZ;
        switch(r8) {
            case 1: goto L_0x0a49;
            case 2: goto L_0x0a54;
            default: goto L_0x09c8;
        };
    L_0x09c8:
        r0 = r20;
        r8 = r0.uap;
        r9 = com.tencent.mm.R.l.app_brand_entrance;
        r8.setText(r9);
    L_0x09d1:
        r8 = com.tencent.mm.ak.o.Pj();
        r0 = r20;
        r9 = r0.uan;
        r0 = r25;
        r10 = r0.tXU;
        r8.a(r7, r9, r10);
        r7 = com.tencent.mm.ak.o.Pf();
        r0 = r29;
        r8 = r0.field_imgPath;
        r9 = 0;
        r10 = 1;
        r7 = r7.d(r8, r9, r10);
        r0 = r20;
        r8 = r0.uar;
        r9 = 0;
        r8.setImageBitmap(r9);
        r0 = r20;
        r8 = r0.uar;
        r9 = 4;
        r8.setVisibility(r9);
        r0 = r20;
        r8 = r0.uas;
        r9 = 0;
        r8.setVisibility(r9);
        r8 = com.tencent.mm.modelappbrand.b.b.Ka();
        r9 = new com.tencent.mm.ui.chatting.viewitems.c$d$2;
        r0 = r25;
        r1 = r20;
        r9.<init>(r0, r1);
        r10 = new java.lang.StringBuilder;
        r11 = "file://";
        r10.<init>(r11);
        r7 = r10.append(r7);
        r10 = r7.toString();
        r11 = 0;
        r7 = com.tencent.mm.modelappbrand.g.class;
        r7 = com.tencent.mm.kernel.g.l(r7);
        r7 = (com.tencent.mm.modelappbrand.g) r7;
        r12 = 240; // 0xf0 float:3.36E-43 double:1.186E-321;
        r13 = 192; // 0xc0 float:2.69E-43 double:9.5E-322;
        r7 = r7.bc(r12, r13);
        r8.a(r9, r10, r11, r7);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x0a3c:
        r0 = r21;
        r7 = r0.bZH;
        r8 = r7;
        goto L_0x097d;
    L_0x0a43:
        r0 = r21;
        r7 = r0.dzb;
        goto L_0x0981;
    L_0x0a49:
        r0 = r20;
        r8 = r0.uap;
        r9 = com.tencent.mm.R.l.app_brand_share_wxa_testing_tag;
        r8.setText(r9);
        goto L_0x09d1;
    L_0x0a54:
        r0 = r20;
        r8 = r0.uap;
        r9 = com.tencent.mm.R.l.app_brand_share_wxa_preview_tag;
        r8.setText(r9);
        goto L_0x09d1;
    L_0x0a5f:
        if (r9 == 0) goto L_0x0ac3;
    L_0x0a61:
        r7 = r9.field_nickname;
        r8 = r7;
    L_0x0a64:
        if (r9 == 0) goto L_0x0ac9;
    L_0x0a66:
        r7 = r9.field_brandIconURL;
    L_0x0a68:
        r0 = r20;
        r9 = r0.uad;
        r10 = 8;
        r9.setVisibility(r10);
        r0 = r20;
        r9 = r0.uaq;
        r10 = 8;
        r9.setVisibility(r10);
        r0 = r20;
        r9 = r0.uaj;
        r10 = 0;
        r9.setVisibility(r10);
        r0 = r20;
        r9 = r0.ual;
        r9.setText(r8);
        r8 = com.tencent.mm.sdk.platformtools.bi.oW(r7);
        if (r8 == 0) goto L_0x0acb;
    L_0x0a8f:
        r7 = com.tencent.mm.ak.o.Pf();
        r0 = r29;
        r8 = r0.field_imgPath;
        r9 = 0;
        r10 = 1;
        r7 = r7.d(r8, r9, r10);
        r8 = com.tencent.mm.modelappbrand.b.b.Ka();
        r0 = r20;
        r9 = r0.uak;
        r10 = new java.lang.StringBuilder;
        r11 = "file://";
        r10.<init>(r11);
        r7 = r10.append(r7);
        r7 = r7.toString();
        r10 = com.tencent.mm.modelappbrand.b.a.JZ();
        r11 = com.tencent.mm.modelappbrand.b.f.dGr;
        r8.a(r9, r7, r10, r11);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x0ac3:
        r0 = r21;
        r7 = r0.title;
        r8 = r7;
        goto L_0x0a64;
    L_0x0ac9:
        r7 = 0;
        goto L_0x0a68;
    L_0x0acb:
        r8 = com.tencent.mm.modelappbrand.b.b.Ka();
        r0 = r20;
        r9 = r0.uak;
        r10 = com.tencent.mm.modelappbrand.b.a.JZ();
        r11 = com.tencent.mm.modelappbrand.b.f.dGr;
        r8.a(r9, r7, r10, r11);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x0ae1:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.title;
        if (r7 == 0) goto L_0x0b57;
    L_0x0af0:
        r0 = r21;
        r7 = r0.title;
        r7 = r7.trim();
        r7 = r7.length();
        if (r7 <= 0) goto L_0x0b57;
    L_0x0afe:
        r0 = r20;
        r7 = r0.tZN;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZN;
        r8 = r21.getTitle();
        r7.setText(r8);
    L_0x0b11:
        r0 = r20;
        r7 = r0.eCn;
        r8 = 3;
        r7.setMaxLines(r8);
        r0 = r20;
        r7 = r0.tZT;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZO;
        r8 = 0;
        r7.setVisibility(r8);
        if (r22 == 0) goto L_0x1437;
    L_0x0b2c:
        r0 = r21;
        r7 = r0.appId;
        r8 = 1;
        r0 = r28;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = com.tencent.mm.bp.a.getDensity(r9);
        r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
        if (r7 == 0) goto L_0x0b49;
    L_0x0b43:
        r8 = r7.isRecycled();
        if (r8 == 0) goto L_0x0b61;
    L_0x0b49:
        r0 = r20;
        r7 = r0.tZI;
        r8 = com.tencent.mm.R.k.app_attach_file_icon_webpage;
        r7.setImageResource(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x0b57:
        r0 = r20;
        r7 = r0.tZN;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x0b11;
    L_0x0b61:
        r0 = r20;
        r8 = r0.tZI;
        r8.setImageBitmap(r7);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x0b6d:
        r0 = r20;
        r7 = r0.tZN;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.dwR;
        r8 = 1;
        if (r7 != r8) goto L_0x0bf0;
    L_0x0b7c:
        r0 = r20;
        r7 = r0.tZN;
        r8 = com.tencent.mm.R.l.scan_product_appmsg_top_title_book;
        r7.setText(r8);
    L_0x0b85:
        r0 = r21;
        r7 = r0.title;
        if (r7 == 0) goto L_0x0ba8;
    L_0x0b8b:
        r0 = r21;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x0ba8;
    L_0x0b95:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.eCm;
        r8 = r21.getTitle();
        r7.setText(r8);
    L_0x0ba8:
        r0 = r20;
        r7 = r0.eCn;
        r8 = 4;
        r7.setMaxLines(r8);
        r0 = r20;
        r7 = r0.tZO;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZT;
        r8 = 8;
        r7.setVisibility(r8);
        if (r22 == 0) goto L_0x1437;
    L_0x0bc3:
        r7 = com.tencent.mm.ak.o.Pf();
        r0 = r29;
        r8 = r0.field_imgPath;
        r0 = r28;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = com.tencent.mm.bp.a.getDensity(r9);
        r10 = 0;
        r7 = r7.b(r8, r9, r10);
        if (r7 == 0) goto L_0x0c1e;
    L_0x0bde:
        r8 = r7.isRecycled();
        if (r8 != 0) goto L_0x0c1e;
    L_0x0be4:
        r0 = r20;
        r8 = r0.tZI;
        r8.setImageBitmap(r7);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x0bf0:
        r0 = r21;
        r7 = r0.dwR;
        r8 = 2;
        if (r7 != r8) goto L_0x0c01;
    L_0x0bf7:
        r0 = r20;
        r7 = r0.tZN;
        r8 = com.tencent.mm.R.l.scan_product_appmsg_top_title_movie;
        r7.setText(r8);
        goto L_0x0b85;
    L_0x0c01:
        r0 = r21;
        r7 = r0.dwR;
        r8 = 3;
        if (r7 != r8) goto L_0x0c13;
    L_0x0c08:
        r0 = r20;
        r7 = r0.tZN;
        r8 = com.tencent.mm.R.l.scan_product_appmsg_top_title_cd;
        r7.setText(r8);
        goto L_0x0b85;
    L_0x0c13:
        r0 = r20;
        r7 = r0.tZN;
        r8 = com.tencent.mm.R.l.scan_product_appmsg_top_title_product;
        r7.setText(r8);
        goto L_0x0b85;
    L_0x0c1e:
        r0 = r20;
        r7 = r0.tZI;
        r8 = com.tencent.mm.R.k.app_attach_file_icon_webpage;
        r7.setImageResource(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x0c2c:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.eCm;
        r8 = r21.getTitle();
        r7.setText(r8);
        r0 = r20;
        r7 = r0.tZN;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZN;
        r8 = com.tencent.mm.R.l.chatting_mall_product_msg_title;
        r7.setText(r8);
        r0 = r20;
        r7 = r0.eCn;
        r8 = 4;
        r7.setMaxLines(r8);
        r0 = r20;
        r7 = r0.tZO;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZT;
        r8 = 8;
        r7.setVisibility(r8);
        if (r22 == 0) goto L_0x1437;
    L_0x0c6b:
        r7 = com.tencent.mm.ak.o.Pf();
        r0 = r29;
        r8 = r0.field_imgPath;
        r0 = r28;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = com.tencent.mm.bp.a.getDensity(r9);
        r10 = 0;
        r7 = r7.b(r8, r9, r10);
        if (r7 == 0) goto L_0x0c98;
    L_0x0c86:
        r8 = r7.isRecycled();
        if (r8 != 0) goto L_0x0c98;
    L_0x0c8c:
        r0 = r20;
        r8 = r0.tZI;
        r8.setImageBitmap(r7);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x0c98:
        r0 = r20;
        r7 = r0.tZI;
        r8 = com.tencent.mm.R.k.app_attach_file_icon_webpage;
        r7.setImageResource(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x0ca6:
        r0 = r21;
        r7 = r0.title;
        if (r7 == 0) goto L_0x0cd2;
    L_0x0cac:
        r0 = r21;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x0cd2;
    L_0x0cb6:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.eCm;
        r8 = r21.getTitle();
        r7.setText(r8);
        r0 = r20;
        r7 = r0.tZN;
        r8 = 8;
        r7.setVisibility(r8);
    L_0x0cd2:
        r0 = r20;
        r7 = r0.eCn;
        r8 = 4;
        r7.setMaxLines(r8);
        r0 = r20;
        r7 = r0.tZO;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZT;
        r8 = 8;
        r7.setVisibility(r8);
        if (r22 == 0) goto L_0x1437;
    L_0x0ced:
        r7 = com.tencent.mm.ak.o.Pf();
        r0 = r29;
        r8 = r0.field_imgPath;
        r0 = r28;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = com.tencent.mm.bp.a.getDensity(r9);
        r10 = 0;
        r7 = r7.b(r8, r9, r10);
        if (r7 == 0) goto L_0x0d1a;
    L_0x0d08:
        r8 = r7.isRecycled();
        if (r8 != 0) goto L_0x0d1a;
    L_0x0d0e:
        r0 = r20;
        r8 = r0.tZI;
        r8.setImageBitmap(r7);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x0d1a:
        r0 = r20;
        r7 = r0.tZI;
        r8 = com.tencent.mm.R.k.app_attach_file_icon_webpage;
        r7.setImageResource(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x0d28:
        r0 = r21;
        r7 = r0.title;
        if (r7 == 0) goto L_0x0d97;
    L_0x0d2e:
        r0 = r21;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x0d97;
    L_0x0d38:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 0;
        r7.setVisibility(r8);
    L_0x0d40:
        r0 = r20;
        r7 = r0.eCn;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZN;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZT;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZO;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.eCn;
        r8 = 2;
        r7.setMaxLines(r8);
        if (r22 == 0) goto L_0x1437;
    L_0x0d6c:
        r0 = r21;
        r7 = r0.appId;
        r8 = 1;
        r0 = r28;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = com.tencent.mm.bp.a.getDensity(r9);
        r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
        if (r7 == 0) goto L_0x0d89;
    L_0x0d83:
        r8 = r7.isRecycled();
        if (r8 == 0) goto L_0x0da1;
    L_0x0d89:
        r0 = r20;
        r7 = r0.tZI;
        r8 = com.tencent.mm.R.k.app_attach_file_icon_webpage;
        r7.setImageResource(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x0d97:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x0d40;
    L_0x0da1:
        r0 = r20;
        r8 = r0.tZI;
        r8.setImageBitmap(r7);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x0dad:
        r0 = r21;
        r6 = r0.title;
        if (r6 == 0) goto L_0x0e65;
    L_0x0db3:
        r0 = r21;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0e65;
    L_0x0dbd:
        r0 = r20;
        r6 = r0.eCm;
        r7 = 0;
        r6.setVisibility(r7);
    L_0x0dc5:
        r0 = r20;
        r6 = r0.eCn;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.tZN;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.tZT;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.tZO;
        r7 = 4;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.eCn;
        r7 = 2;
        r6.setMaxLines(r7);
        if (r22 == 0) goto L_0x0e1b;
    L_0x0df1:
        r6 = com.tencent.mm.ak.o.Pf();
        r0 = r29;
        r7 = r0.field_imgPath;
        r0 = r28;
        r8 = r0.tTq;
        r8 = r8.getContext();
        r8 = com.tencent.mm.bp.a.getDensity(r8);
        r9 = 0;
        r6 = r6.b(r7, r8, r9);
        if (r6 == 0) goto L_0x0e12;
    L_0x0e0c:
        r7 = r6.isRecycled();
        if (r7 == 0) goto L_0x0e70;
    L_0x0e12:
        r0 = r20;
        r6 = r0.tZI;
        r7 = com.tencent.mm.R.k.app_attach_file_icon_webpage;
        r6.setImageResource(r7);
    L_0x0e1b:
        r6 = new com.tencent.mm.ui.chatting.viewitems.au;
        r8 = 0;
        r10 = "";
        r11 = 0;
        r0 = r21;
        r12 = r0.title;
        r0 = r21;
        r13 = r0.bZG;
        r0 = r21;
        r14 = r0.bZH;
        r0 = r21;
        r15 = r0.title;
        r0 = r21;
        r0 = r0.dwZ;
        r16 = r0;
        r0 = r21;
        r0 = r0.url;
        r17 = r0;
        r18 = 0;
        r19 = 0;
        r7 = r29;
        r9 = r27;
        r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
        r0 = r20;
        r7 = r0.uac;
        r7.setTag(r6);
        r0 = r20;
        r7 = r0.uac;
        r0 = r25;
        r1 = r28;
        r8 = r0.h(r1);
        r7.setOnClickListener(r8);
        r15 = 1;
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x0e65:
        r0 = r20;
        r6 = r0.eCm;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0dc5;
    L_0x0e70:
        r0 = r20;
        r7 = r0.tZI;
        r7.setImageBitmap(r6);
        goto L_0x0e1b;
    L_0x0e78:
        r0 = r21;
        r6 = r0.title;
        if (r6 == 0) goto L_0x0f3f;
    L_0x0e7e:
        r0 = r21;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0f3f;
    L_0x0e88:
        r0 = r20;
        r6 = r0.eCm;
        r7 = 0;
        r6.setVisibility(r7);
    L_0x0e90:
        r0 = r20;
        r6 = r0.eCn;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.tZN;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.tZT;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.tZO;
        r7 = 4;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.eCn;
        r7 = 2;
        r6.setMaxLines(r7);
        if (r22 == 0) goto L_0x0ee6;
    L_0x0ebc:
        r6 = com.tencent.mm.ak.o.Pf();
        r0 = r29;
        r7 = r0.field_imgPath;
        r0 = r28;
        r8 = r0.tTq;
        r8 = r8.getContext();
        r8 = com.tencent.mm.bp.a.getDensity(r8);
        r9 = 0;
        r6 = r6.b(r7, r8, r9);
        if (r6 == 0) goto L_0x0edd;
    L_0x0ed7:
        r7 = r6.isRecycled();
        if (r7 == 0) goto L_0x0f4a;
    L_0x0edd:
        r0 = r20;
        r6 = r0.tZI;
        r7 = com.tencent.mm.R.k.app_attach_file_icon_webpage;
        r6.setImageResource(r7);
    L_0x0ee6:
        r6 = new com.tencent.mm.ui.chatting.viewitems.au;
        r9 = "";
        r10 = r28.cuz();
        r0 = r21;
        r11 = r0.bZG;
        r0 = r21;
        r12 = r0.bZH;
        r0 = r21;
        r13 = r0.title;
        r0 = r21;
        r14 = r0.dyG;
        r0 = r21;
        r15 = r0.designerName;
        r0 = r21;
        r0 = r0.designerRediretctUrl;
        r16 = r0;
        r0 = r21;
        r0 = r0.url;
        r17 = r0;
        r7 = r29;
        r8 = r27;
        r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
        r0 = r20;
        r7 = r0.uac;
        r7.setTag(r6);
        r0 = r20;
        r7 = r0.uac;
        r0 = r25;
        r8 = r0.uay;
        if (r8 != 0) goto L_0x0f32;
    L_0x0f27:
        r8 = new com.tencent.mm.ui.chatting.t$h;
        r0 = r28;
        r8.<init>(r0);
        r0 = r25;
        r0.uay = r8;
    L_0x0f32:
        r0 = r25;
        r8 = r0.uay;
        r7.setOnClickListener(r8);
        r15 = 1;
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x0f3f:
        r0 = r20;
        r6 = r0.eCm;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0e90;
    L_0x0f4a:
        r0 = r20;
        r7 = r0.tZI;
        r7.setImageBitmap(r6);
        goto L_0x0ee6;
    L_0x0f52:
        r0 = r21;
        r6 = r0.title;
        if (r6 == 0) goto L_0x1040;
    L_0x0f58:
        r0 = r21;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x1040;
    L_0x0f62:
        r0 = r20;
        r6 = r0.eCm;
        r7 = 0;
        r6.setVisibility(r7);
    L_0x0f6a:
        r0 = r20;
        r6 = r0.eCn;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.tZN;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.tZT;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.tZO;
        r7 = 4;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.eCn;
        r7 = 2;
        r6.setMaxLines(r7);
        if (r22 == 0) goto L_0x0fc0;
    L_0x0f96:
        r6 = com.tencent.mm.ak.o.Pf();
        r0 = r29;
        r7 = r0.field_imgPath;
        r0 = r28;
        r8 = r0.tTq;
        r8 = r8.getContext();
        r8 = com.tencent.mm.bp.a.getDensity(r8);
        r9 = 0;
        r6 = r6.b(r7, r8, r9);
        if (r6 == 0) goto L_0x0fb7;
    L_0x0fb1:
        r7 = r6.isRecycled();
        if (r7 == 0) goto L_0x104b;
    L_0x0fb7:
        r0 = r20;
        r6 = r0.tZI;
        r7 = com.tencent.mm.R.k.app_attach_file_icon_webpage;
        r6.setImageResource(r7);
    L_0x0fc0:
        r12 = new com.tencent.mm.ui.chatting.viewitems.au;
        r12.<init>();
        r0 = r29;
        r12.bXQ = r0;
        r6 = 0;
        r12.tGg = r6;
        r0 = r27;
        r12.position = r0;
        r6 = 0;
        r12.ufx = r6;
        r6 = r28.cuz();
        r12.title = r6;
        r0 = r21;
        r6 = r0.bZG;
        r12.bZG = r6;
        r0 = r21;
        r6 = r0.bZH;
        r12.bZH = r6;
        r0 = r21;
        r6 = r0.title;
        r12.ufy = r6;
        r0 = r21;
        r6 = r0.type;
        r7 = 26;
        if (r6 != r7) goto L_0x1054;
    L_0x0ff3:
        r0 = r21;
        r6 = r0.tid;
        r12.tid = r6;
        r0 = r21;
        r6 = r0.dyH;
        r12.dyH = r6;
        r0 = r21;
        r6 = r0.desc;
        r12.desc = r6;
        r0 = r21;
        r6 = r0.iconUrl;
        r12.iconUrl = r6;
        r0 = r21;
        r6 = r0.secondUrl;
        r12.secondUrl = r6;
        r0 = r21;
        r6 = r0.pageType;
        r12.pageType = r6;
        r0 = r20;
        r6 = r0.uac;
        r0 = r25;
        r7 = r0.uaz;
        if (r7 != 0) goto L_0x102c;
    L_0x1021:
        r7 = new com.tencent.mm.ui.chatting.t$k;
        r0 = r28;
        r7.<init>(r0);
        r0 = r25;
        r0.uaz = r7;
    L_0x102c:
        r0 = r25;
        r7 = r0.uaz;
        r6.setOnClickListener(r7);
        r6 = 1;
    L_0x1034:
        r0 = r20;
        r7 = r0.uac;
        r7.setTag(r12);
        r7 = r23;
        r15 = r6;
        goto L_0x0342;
    L_0x1040:
        r0 = r20;
        r6 = r0.eCm;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0f6a;
    L_0x104b:
        r0 = r20;
        r7 = r0.tZI;
        r7.setImageBitmap(r6);
        goto L_0x0fc0;
    L_0x1054:
        r0 = r21;
        r6 = r0.type;
        r7 = 27;
        if (r6 != r7) goto L_0x143c;
    L_0x105c:
        r0 = r21;
        r6 = r0.tid;
        r12.tid = r6;
        r0 = r21;
        r6 = r0.dyH;
        r12.dyH = r6;
        r0 = r21;
        r6 = r0.desc;
        r12.desc = r6;
        r0 = r21;
        r6 = r0.iconUrl;
        r12.iconUrl = r6;
        r0 = r21;
        r6 = r0.secondUrl;
        r12.secondUrl = r6;
        r0 = r21;
        r6 = r0.pageType;
        r12.pageType = r6;
        r0 = r20;
        r6 = r0.uac;
        r0 = r25;
        r7 = r0.uaA;
        if (r7 != 0) goto L_0x1095;
    L_0x108a:
        r7 = new com.tencent.mm.ui.chatting.t$i;
        r0 = r28;
        r7.<init>(r0);
        r0 = r25;
        r0.uaA = r7;
    L_0x1095:
        r0 = r25;
        r7 = r0.uaA;
        r6.setOnClickListener(r7);
        r6 = 1;
        goto L_0x1034;
    L_0x109e:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.eCm;
        r0 = r21;
        r8 = r0.description;
        r7.setText(r8);
        r0 = r20;
        r7 = r0.eCn;
        r0 = r21;
        r8 = r0.dxF;
        r7.setText(r8);
        r0 = r21;
        r7 = r0.title;
        if (r7 == 0) goto L_0x1121;
    L_0x10c2:
        r0 = r21;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x1121;
    L_0x10cc:
        r0 = r20;
        r7 = r0.tZN;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZN;
        r0 = r21;
        r8 = r0.title;
        r7.setText(r8);
    L_0x10df:
        r0 = r20;
        r7 = r0.eCn;
        r8 = 4;
        r7.setMaxLines(r8);
        r0 = r20;
        r7 = r0.tZO;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZT;
        r8 = 8;
        r7.setVisibility(r8);
        if (r22 == 0) goto L_0x1437;
    L_0x10fa:
        r7 = com.tencent.mm.ak.o.Pf();
        r0 = r29;
        r8 = r0.field_imgPath;
        r0 = r28;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = com.tencent.mm.bp.a.getDensity(r9);
        r10 = 0;
        r7 = r7.b(r8, r9, r10);
        if (r7 == 0) goto L_0x112b;
    L_0x1115:
        r0 = r20;
        r8 = r0.tZI;
        r8.setImageBitmap(r7);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x1121:
        r0 = r20;
        r7 = r0.tZN;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x10df;
    L_0x112b:
        r0 = r20;
        r7 = r0.tZI;
        r8 = com.tencent.mm.R.k.app_attach_file_icon_webpage;
        r7.setImageResource(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x1139:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZN;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.title;
        if (r7 == 0) goto L_0x11bc;
    L_0x1150:
        r0 = r21;
        r7 = r0.title;
        r7 = r7.trim();
        r7 = r7.length();
        if (r7 <= 0) goto L_0x11bc;
    L_0x115e:
        r0 = r20;
        r7 = r0.tZN;
        r0 = r20;
        r8 = r0.tZN;
        r8 = r8.getContext();
        r0 = r21;
        r9 = r0.title;
        r0 = r20;
        r10 = r0.tZN;
        r10 = r10.getTextSize();
        r8 = com.tencent.mm.pluginsdk.ui.d.j.a(r8, r9, r10);
        r7.setText(r8);
    L_0x117d:
        r0 = r20;
        r7 = r0.eCn;
        r8 = 3;
        r7.setMaxLines(r8);
        r0 = r20;
        r7 = r0.tZT;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZO;
        r8 = 4;
        r7.setVisibility(r8);
        if (r22 == 0) goto L_0x11aa;
    L_0x1198:
        r0 = r20;
        r7 = r0.tZI;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.uab;
        r8 = 8;
        r7.setVisibility(r8);
    L_0x11aa:
        r0 = r28;
        r1 = r20;
        r2 = r21;
        r3 = r29;
        r4 = r22;
        com.tencent.mm.ui.chatting.viewitems.c.c.a(r0, r1, r2, r3, r4);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x11bc:
        r0 = r20;
        r7 = r0.tZN;
        r0 = r20;
        r8 = r0.tZN;
        r8 = r8.getContext();
        r9 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r10 = com.tencent.mm.R.l.favorite_wenote;
        r9 = r9.getString(r10);
        r0 = r20;
        r10 = r0.tZN;
        r10 = r10.getTextSize();
        r8 = com.tencent.mm.pluginsdk.ui.d.j.a(r8, r9, r10);
        r7.setText(r8);
        goto L_0x117d;
    L_0x11e2:
        r0 = r28;
        r1 = r20;
        r2 = r21;
        r3 = r22;
        com.tencent.mm.ui.chatting.viewitems.c.c.a(r0, r1, r2, r3);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x11f2:
        r0 = r21;
        r7 = r0.title;
        if (r7 == 0) goto L_0x1342;
    L_0x11f8:
        r0 = r21;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x1342;
    L_0x1202:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.dxO;
        r7 = com.tencent.mm.sdk.platformtools.bi.oW(r7);
        if (r7 != 0) goto L_0x1327;
    L_0x1214:
        r0 = r20;
        r7 = r0.eCm;
        r0 = r21;
        r8 = r0.dxO;
        r0 = r28;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = r9.getResources();
        r10 = com.tencent.mm.R.e.black;
        r9 = r9.getColor(r10);
        r8 = com.tencent.mm.sdk.platformtools.bi.bc(r8, r9);
        r7.setTextColor(r8);
    L_0x1235:
        r0 = r20;
        r7 = r0.eCn;
        r8 = 2;
        r7.setMaxLines(r8);
        r0 = r20;
        r7 = r0.eCn;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.dxP;
        r7 = com.tencent.mm.sdk.platformtools.bi.oW(r7);
        if (r7 != 0) goto L_0x134d;
    L_0x124f:
        r0 = r20;
        r7 = r0.eCn;
        r0 = r21;
        r8 = r0.dxP;
        r0 = r28;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = r9.getResources();
        r10 = com.tencent.mm.R.e.grey_background_text_color;
        r9 = r9.getColor(r10);
        r8 = com.tencent.mm.sdk.platformtools.bi.bc(r8, r9);
        r7.setTextColor(r8);
    L_0x1270:
        r0 = r20;
        r7 = r0.tZN;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZO;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZT;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZM;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.jet;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.dxK;
        r7 = com.tencent.mm.sdk.platformtools.bi.oW(r7);
        if (r7 != 0) goto L_0x1368;
    L_0x12a4:
        r0 = r20;
        r7 = r0.jet;
        r0 = r21;
        r8 = r0.dxK;
        r7.setText(r8);
    L_0x12af:
        r0 = r25;
        r7 = r0.qUB;
        if (r7 == 0) goto L_0x138e;
    L_0x12b5:
        r7 = com.tencent.mm.ak.o.Pf();
        r0 = r29;
        r8 = r0.field_imgPath;
        r0 = r28;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = com.tencent.mm.bp.a.getDensity(r9);
        r10 = 0;
        r7 = r7.a(r8, r9, r10);
        if (r7 == 0) goto L_0x12e9;
    L_0x12d0:
        r8 = r7.isRecycled();
        if (r8 != 0) goto L_0x12e9;
    L_0x12d6:
        r8 = 0;
        r9 = r7.getWidth();
        r9 = r9 / 2;
        r9 = (float) r9;
        r8 = com.tencent.mm.sdk.platformtools.c.a(r7, r8, r9);
        r0 = r20;
        r9 = r0.tZI;
        r9.setImageBitmap(r8);
    L_0x12e9:
        r0 = r21;
        r8 = r0.dxN;
        r8 = com.tencent.mm.sdk.platformtools.bi.oW(r8);
        if (r8 != 0) goto L_0x1373;
    L_0x12f3:
        r7 = com.tencent.mm.ak.o.Pj();
        r0 = r21;
        r8 = r0.dxN;
        r9 = new android.widget.ImageView;
        r0 = r28;
        r10 = r0.tTq;
        r10 = r10.getContext();
        r9.<init>(r10);
        r10 = new com.tencent.mm.ak.a.a.c$a;
        r10.<init>();
        r11 = 1;
        r10.dXy = r11;
        r10 = r10.Pt();
        r11 = new com.tencent.mm.ui.chatting.viewitems.c$d$3;
        r0 = r25;
        r1 = r20;
        r2 = r28;
        r11.<init>(r0, r1, r2);
        r7.a(r8, r9, r10, r11);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x1327:
        r0 = r20;
        r7 = r0.eCm;
        r0 = r28;
        r8 = r0.tTq;
        r8 = r8.getContext();
        r8 = r8.getResources();
        r9 = com.tencent.mm.R.e.black;
        r8 = r8.getColor(r9);
        r7.setTextColor(r8);
        goto L_0x1235;
    L_0x1342:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x1235;
    L_0x134d:
        r0 = r20;
        r7 = r0.eCn;
        r0 = r28;
        r8 = r0.tTq;
        r8 = r8.getContext();
        r8 = r8.getResources();
        r9 = com.tencent.mm.R.e.grey_background_text_color;
        r8 = r8.getColor(r9);
        r7.setTextColor(r8);
        goto L_0x1270;
    L_0x1368:
        r0 = r20;
        r7 = r0.jet;
        r8 = com.tencent.mm.R.l.chatting_item_coupon_card;
        r7.setText(r8);
        goto L_0x12af;
    L_0x1373:
        r0 = r20;
        r8 = r0.uad;
        r8 = r8.getViewTreeObserver();
        r9 = new com.tencent.mm.ui.chatting.viewitems.c$d$4;
        r0 = r25;
        r1 = r20;
        r2 = r28;
        r9.<init>(r0, r1, r2, r7);
        r8.addOnPreDrawListener(r9);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x138e:
        r0 = r20;
        r7 = r0.tZI;
        r0 = r28;
        r8 = r0.tTq;
        r8 = r8.getMMResources();
        r9 = com.tencent.mm.R.g.nosdcard_app;
        r8 = android.graphics.BitmapFactory.decodeResource(r8, r9);
        r7.setImageBitmap(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x13a8:
        r7 = r14.dzv;
        r8 = 19;
        if (r7 != r8) goto L_0x1437;
    L_0x13ae:
        r0 = r28;
        r1 = r20;
        r2 = r21;
        r3 = r22;
        com.tencent.mm.ui.chatting.viewitems.c.c.a(r0, r1, r2, r3);
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x13be:
        r0 = r20;
        r6 = r0.tZN;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x036f;
    L_0x13c9:
        r6 = com.tencent.mm.ak.o.Pf();
        r0 = r29;
        r7 = r0.field_imgPath;
        r0 = r28;
        r8 = r0.tTq;
        r8 = r8.getContext();
        r8 = com.tencent.mm.bp.a.getDensity(r8);
        r9 = 0;
        r6 = r6.b(r7, r8, r9);
        if (r6 == 0) goto L_0x13ea;
    L_0x13e4:
        r7 = r6.isRecycled();
        if (r7 == 0) goto L_0x1403;
    L_0x13ea:
        r6 = com.tencent.mm.ak.o.Pf();
        r0 = r29;
        r7 = r0.field_imgPath;
        r0 = r28;
        r8 = r0.tTq;
        r8 = r8.getContext();
        r8 = com.tencent.mm.bp.a.getDensity(r8);
        r9 = 0;
        r6 = r6.a(r7, r8, r9);
    L_0x1403:
        if (r6 == 0) goto L_0x1414;
    L_0x1405:
        r7 = r6.isRecycled();
        if (r7 != 0) goto L_0x1414;
    L_0x140b:
        r0 = r20;
        r7 = r0.tZI;
        r7.setImageBitmap(r6);
        goto L_0x03ce;
    L_0x1414:
        r0 = r20;
        r6 = r0.tZI;
        r7 = com.tencent.mm.R.g.appshareimage_icon;
        r6.setImageResource(r7);
        goto L_0x03ce;
    L_0x141f:
        r0 = r20;
        r6 = r0.tZW;
        r7 = 8;
        r6.setVisibility(r7);
        r6 = r12;
        goto L_0x03f4;
    L_0x142b:
        r0 = r20;
        r6 = r0.tZW;
        r7 = 8;
        r6.setVisibility(r7);
        r6 = r12;
        goto L_0x03f4;
    L_0x1437:
        r7 = r23;
        r12 = r6;
        goto L_0x0342;
    L_0x143c:
        r6 = r15;
        goto L_0x1034;
    L_0x143f:
        r16 = r7;
        goto L_0x0049;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.c$d.a(com.tencent.mm.ui.chatting.viewitems.b$a, int, com.tencent.mm.ui.chatting.c.a, com.tencent.mm.storage.bd, java.lang.String):void");
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        int i = ((au) view.getTag()).position;
        int SY = l.SY(com.tencent.mm.model.bd.b(this.tKy.cwr(), bdVar.field_content, bdVar.field_isSend));
        g.a gp = g.a.gp(com.tencent.mm.model.bd.b(this.tKy.cwr(), bdVar.field_content, bdVar.field_isSend));
        f bl = com.tencent.mm.pluginsdk.model.app.g.bl(gp.appId, false);
        if (com.tencent.mm.pluginsdk.model.app.g.h(bl) && !j.au(bdVar)) {
            if (gp.type == 6) {
                b SZ = l.SZ(gp.bGP);
                if ((SZ == null || !c.b.e(bdVar, SZ.field_fileFullPath)) && !bdVar.cmu()) {
                    contextMenu.add(i, 111, 0, this.tKy.tTq.getMMResources().getString(R.l.retransmit));
                }
            } else {
                contextMenu.add(i, 111, 0, this.tKy.tTq.getMMResources().getString(R.l.retransmit));
            }
        }
        if (gp.dwo <= 0 || (gp.dwo > 0 && SY >= 100)) {
            boolean MH;
            switch (gp.type) {
                case 1:
                    MH = com.tencent.mm.ac.f.MH();
                    break;
                case 2:
                    MH = com.tencent.mm.ac.f.MI();
                    break;
                case 3:
                    MH = com.tencent.mm.ac.f.MP();
                    break;
                case 4:
                    MH = com.tencent.mm.ac.f.MJ();
                    break;
                case 5:
                    MH = com.tencent.mm.ac.f.MN();
                    break;
                case 6:
                    MH = com.tencent.mm.ac.f.MO();
                    break;
                case 8:
                    MH = com.tencent.mm.ac.f.ML();
                    break;
                case 16:
                    if (gp.dxG != 5 && gp.dxG != 6 && gp.dxG != 2) {
                        MH = false;
                        break;
                    }
                    if (gp.dxG != 2 || bf.l(bdVar)) {
                        contextMenu.clear();
                    }
                    contextMenu.add(i, 100, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
                    return false;
                    break;
                case a$i.AppCompatTheme_actionModePasteDrawable /*34*/:
                    contextMenu.clear();
                    contextMenu.add(i, 100, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
                    return false;
                default:
                    MH = false;
                    break;
            }
            if (MH && !this.tKy.cws()) {
                contextMenu.add(i, 114, 0, view.getContext().getString(R.l.chatting_long_click_brand_service));
            }
        }
        if (d.QS("favorite") && (bl == null || !bl.aaq())) {
            switch (gp.type) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 10:
                case 13:
                case 19:
                case 20:
                case 24:
                    contextMenu.add(i, 116, 0, view.getContext().getString(R.l.plugin_favorite_opt));
                    break;
            }
        }
        dj djVar = new dj();
        djVar.bLf.bJC = bdVar.field_msgId;
        com.tencent.mm.sdk.b.a.sFg.m(djVar);
        if (djVar.bLg.bKE || c.b.a(this.tKy.tTq.getContext(), gp)) {
            contextMenu.add(i, 129, 0, view.getContext().getString(R.l.chatting_long_click_menu_open));
        }
        if (bf.l(bdVar)) {
            contextMenu.clear();
        }
        if (!this.tKy.cws()) {
            contextMenu.add(i, 100, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        g.a aVar2;
        switch (menuItem.getItemId()) {
            case a$i.AppCompatTheme_buttonStyle /*100*/:
                String str = bdVar.field_content;
                aVar2 = null;
                if (str != null) {
                    aVar2 = g.a.gp(str);
                }
                if (aVar2 != null) {
                    l.fJ(bdVar.field_msgId);
                    if (19 == aVar2.type) {
                        mw mwVar = new mw();
                        mwVar.bXL.type = 3;
                        mwVar.bXL.bJC = bdVar.field_msgId;
                        com.tencent.mm.sdk.b.a.sFg.m(mwVar);
                    }
                    com.tencent.mm.model.bd.aU(bdVar.field_msgId);
                    f bl = com.tencent.mm.pluginsdk.model.app.g.bl(aVar2.appId, false);
                    if (bl != null && bl.aaq()) {
                        a(aVar, aVar2, bdVar, bl);
                    }
                    if (aVar2.type == 3) {
                        c.f(bdVar, aVar.getTalkerUserName());
                        break;
                    }
                }
                break;
            case 111:
                c.b.a(aVar, bdVar, b(aVar, bdVar));
                break;
            case 114:
                String str2 = bdVar.field_content;
                if (str2 != null) {
                    aVar2 = g.a.gp(str2);
                    if (aVar2 != null) {
                        switch (aVar2.type) {
                            case 1:
                                am.l(com.tencent.mm.model.bd.b(aVar.cwr(), bdVar.field_content, bdVar.field_isSend), aVar.tTq.getContext());
                                break;
                            case 2:
                                am.a(bdVar, aVar.tTq.getContext(), b(aVar, bdVar), aVar.cwr());
                                break;
                            case 3:
                                am.a(bdVar, com.tencent.mm.model.bd.b(aVar.cwr(), bdVar.field_content, bdVar.field_isSend), aVar.tTq.getContext());
                                break;
                            case 4:
                                am.c(bdVar, aVar.tTq.getContext());
                                break;
                            case 5:
                                am.c(bdVar, com.tencent.mm.model.bd.b(aVar.cwr(), bdVar.field_content, bdVar.field_isSend), aVar.tTq.getContext());
                                break;
                            case 6:
                                am.b(bdVar, com.tencent.mm.model.bd.b(aVar.cwr(), bdVar.field_content, bdVar.field_isSend), aVar.tTq.getContext());
                                break;
                            case 8:
                                am.d(bdVar, aVar.tTq.getContext());
                                break;
                        }
                    }
                }
                break;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(android.view.View r16, com.tencent.mm.ui.chatting.c.a r17, com.tencent.mm.storage.bd r18) {
        /*
        r15 = this;
        r2 = com.tencent.mm.modelstat.a.a.ehI;
        r0 = r18;
        com.tencent.mm.modelstat.a.a(r0, r2);
        r0 = r18;
        r4 = r0.field_content;
        r2 = 0;
        r2 = java.lang.Boolean.valueOf(r2);
        if (r4 != 0) goto L_0x0014;
    L_0x0012:
        r2 = 0;
    L_0x0013:
        return r2;
    L_0x0014:
        r3 = r17.cwr();
        r0 = r18;
        r5 = r0.field_content;
        r0 = r18;
        r6 = r0.field_isSend;
        r3 = com.tencent.mm.model.bd.b(r3, r5, r6);
        r3 = com.tencent.mm.y.g.a.gp(r3);
        r4 = com.tencent.mm.y.k.gv(r4);
        if (r3 != 0) goto L_0x0030;
    L_0x002e:
        r2 = 0;
        goto L_0x0013;
    L_0x0030:
        r5 = r4.dzv;
        if (r5 == 0) goto L_0x003d;
    L_0x0034:
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);
        r4 = r4.dzv;
        r3.type = r4;
    L_0x003d:
        r8 = r2;
        r2 = r3.appId;
        r4 = 0;
        r5 = com.tencent.mm.pluginsdk.model.app.g.bl(r2, r4);
        if (r5 == 0) goto L_0x005a;
    L_0x0047:
        r2 = r5.aaq();
        if (r2 == 0) goto L_0x005a;
    L_0x004d:
        r4 = d(r17, r18);
        r0 = r18;
        r6 = r0.field_msgSvrId;
        r2 = r17;
        a(r2, r3, r4, r5, r6);
    L_0x005a:
        r7 = 0;
        r2 = r3.type;
        switch(r2) {
            case 3: goto L_0x00b8;
            case 4: goto L_0x00d4;
            case 6: goto L_0x014b;
            case 7: goto L_0x0182;
            case 10: goto L_0x01ec;
            case 13: goto L_0x027c;
            case 16: goto L_0x02ec;
            case 19: goto L_0x02b4;
            case 20: goto L_0x0234;
            case 24: goto L_0x0546;
            case 33: goto L_0x0325;
            case 34: goto L_0x057a;
            case 36: goto L_0x0475;
            default: goto L_0x0060;
        };
    L_0x0060:
        r2 = r3.url;
        if (r2 == 0) goto L_0x082c;
    L_0x0064:
        r2 = r3.url;
        r4 = "";
        r2 = r2.equals(r4);
        if (r2 != 0) goto L_0x082c;
    L_0x006f:
        r2 = r3.canvasPageXml;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 != 0) goto L_0x05db;
    L_0x0077:
        r2 = new android.content.Intent;
        r2.<init>();
        r4 = "sns_landig_pages_from_source";
        r5 = 5;
        r2.putExtra(r4, r5);
        r4 = "msg_id";
        r0 = r18;
        r6 = r0.field_msgId;
        r2.putExtra(r4, r6);
        r4 = "sns_landing_pages_xml";
        r3 = r3.canvasPageXml;
        r2.putExtra(r4, r3);
        r3 = "sns_landing_pages_share_thumb_url";
        r0 = r18;
        r4 = r0.field_imgPath;
        r2.putExtra(r3, r4);
        r3 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r2.addFlags(r3);
        r0 = r17;
        r3 = r0.tTq;
        r3 = r3.getContext();
        r4 = "sns";
        r5 = ".ui.SnsAdNativeLandingPagesPreviewUI";
        com.tencent.mm.bg.d.b(r3, r4, r5, r2);
        r2 = 1;
        goto L_0x0013;
    L_0x00b8:
        r2 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 13043; // 0x32f3 float:1.8277E-41 double:6.444E-320;
        r5 = 3;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = 2;
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        r6 = 1;
        r7 = r3.description;
        r5[r6] = r7;
        r6 = 2;
        r7 = r3.appId;
        r5[r6] = r7;
        r2.h(r4, r5);
    L_0x00d4:
        r0 = r17;
        r2 = r0.tTq;
        r2 = r2.getContext();
        r2 = com.tencent.mm.p.a.by(r2);
        if (r2 != 0) goto L_0x00f0;
    L_0x00e2:
        r0 = r17;
        r2 = r0.tTq;
        r2 = r2.getContext();
        r2 = com.tencent.mm.p.a.bw(r2);
        if (r2 == 0) goto L_0x00fc;
    L_0x00f0:
        r2 = "MicroMsg.ChattingItemAppMsgFrom";
        r3 = "Voip is running, can't do this";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r2 = 1;
        goto L_0x0013;
    L_0x00fc:
        r0 = r17;
        r1 = r18;
        r2 = r15.a(r0, r3, r1);
        if (r2 == 0) goto L_0x0109;
    L_0x0106:
        r2 = 1;
        goto L_0x0013;
    L_0x0109:
        r2 = r3.url;
        r4 = "message";
        r4 = com.tencent.mm.pluginsdk.model.app.p.B(r2, r4);
        r2 = r3.dwn;
        r5 = "message";
        r5 = com.tencent.mm.pluginsdk.model.app.p.B(r2, r5);
        r0 = r17;
        r2 = r0.tTq;
        r2 = r2.getContext();
        r6 = r3.appId;
        r2 = getPackageInfo(r2, r6);
        if (r2 != 0) goto L_0x0145;
    L_0x012b:
        r6 = 0;
    L_0x012c:
        if (r2 != 0) goto L_0x0148;
    L_0x012e:
        r7 = 0;
    L_0x012f:
        r8 = r3.appId;
        r9 = 1;
        r0 = r18;
        r10 = r0.field_msgId;
        r0 = r18;
        r12 = r0.field_msgSvrId;
        r2 = r15;
        r3 = r17;
        r14 = r18;
        r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r12, r14);
        r2 = 1;
        goto L_0x0013;
    L_0x0145:
        r6 = r2.versionName;
        goto L_0x012c;
    L_0x0148:
        r7 = r2.versionCode;
        goto L_0x012f;
    L_0x014b:
        r2 = r15.qUB;
        if (r2 != 0) goto L_0x015d;
    L_0x014f:
        r0 = r17;
        r2 = r0.tTq;
        r2 = r2.getContext();
        com.tencent.mm.ui.base.s.gH(r2);
        r2 = 1;
        goto L_0x0013;
    L_0x015d:
        r2 = new android.content.Intent;
        r2.<init>();
        r0 = r17;
        r3 = r0.tTq;
        r3 = r3.getContext();
        r4 = "com.tencent.mm.ui.chatting.AppAttachDownloadUI";
        r2.setClassName(r3, r4);
        r3 = "app_msg_id";
        r0 = r18;
        r4 = r0.field_msgId;
        r2.putExtra(r3, r4);
        r0 = r17;
        r0.startActivity(r2);
        r2 = 1;
        goto L_0x0013;
    L_0x0182:
        if (r5 == 0) goto L_0x0195;
    L_0x0184:
        r2 = r5.aaq();
        if (r2 == 0) goto L_0x0195;
    L_0x018a:
        r0 = r17;
        r2 = a(r0, r5);
        if (r2 == 0) goto L_0x0195;
    L_0x0192:
        r2 = 1;
        goto L_0x0013;
    L_0x0195:
        r2 = r3.bGP;
        if (r2 == 0) goto L_0x01a1;
    L_0x0199:
        r2 = r3.bGP;
        r2 = r2.length();
        if (r2 != 0) goto L_0x01b3;
    L_0x01a1:
        r2 = com.tencent.mm.ui.chatting.b.b.a.class;
        r0 = r17;
        r2 = r0.O(r2);
        r2 = (com.tencent.mm.ui.chatting.b.b.a) r2;
        r0 = r18;
        r2.aR(r0);
    L_0x01b0:
        r2 = 1;
        goto L_0x0013;
    L_0x01b3:
        r2 = r15.qUB;
        if (r2 != 0) goto L_0x01c5;
    L_0x01b7:
        r0 = r17;
        r2 = r0.tTq;
        r2 = r2.getContext();
        com.tencent.mm.ui.base.s.gH(r2);
        r2 = 1;
        goto L_0x0013;
    L_0x01c5:
        r2 = new android.content.Intent;
        r2.<init>();
        r0 = r17;
        r3 = r0.tTq;
        r3 = r3.getContext();
        r4 = "com.tencent.mm.ui.chatting.AppAttachDownloadUI";
        r2.setClassName(r3, r4);
        r3 = "app_msg_id";
        r0 = r18;
        r4 = r0.field_msgId;
        r2.putExtra(r3, r4);
        r0 = r17;
        r3 = r0.tTq;
        r4 = 210; // 0xd2 float:2.94E-43 double:1.04E-321;
        r3.startActivityForResult(r2, r4);
        goto L_0x01b0;
    L_0x01ec:
        r2 = r3.dwS;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 == 0) goto L_0x01f7;
    L_0x01f4:
        r2 = 0;
        goto L_0x0013;
    L_0x01f7:
        r2 = new android.content.Intent;
        r2.<init>();
        r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r2.setFlags(r4);
        r4 = "key_Product_xml";
        r3 = r3.dwS;
        r2.putExtra(r4, r3);
        r3 = "key_ProductUI_getProductInfoScene";
        r4 = 1;
        r2.putExtra(r3, r4);
        r0 = r18;
        r3 = r0.field_imgPath;
        if (r3 != 0) goto L_0x0220;
    L_0x0216:
        r3 = "key_ProductUI_chatting_msgId";
        r0 = r18;
        r4 = r0.field_msgId;
        r2.putExtra(r3, r4);
    L_0x0220:
        r0 = r17;
        r3 = r0.tTq;
        r3 = r3.getContext();
        r4 = "scanner";
        r5 = ".ui.ProductUI";
        com.tencent.mm.bg.d.b(r3, r4, r5, r2);
        r2 = 1;
        goto L_0x0013;
    L_0x0234:
        r2 = r3.dwV;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 == 0) goto L_0x023f;
    L_0x023c:
        r2 = 0;
        goto L_0x0013;
    L_0x023f:
        r2 = new android.content.Intent;
        r2.<init>();
        r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r2.setFlags(r4);
        r4 = "key_TV_xml";
        r3 = r3.dwV;
        r2.putExtra(r4, r3);
        r3 = "key_TV_getProductInfoScene";
        r4 = 1;
        r2.putExtra(r3, r4);
        r0 = r18;
        r3 = r0.field_imgPath;
        if (r3 != 0) goto L_0x0268;
    L_0x025e:
        r3 = "key_TVInfoUI_chatting_msgId";
        r0 = r18;
        r4 = r0.field_msgId;
        r2.putExtra(r3, r4);
    L_0x0268:
        r0 = r17;
        r3 = r0.tTq;
        r3 = r3.getContext();
        r4 = "shake";
        r5 = ".ui.TVInfoUI";
        com.tencent.mm.bg.d.b(r3, r4, r5, r2);
        r2 = 1;
        goto L_0x0013;
    L_0x027c:
        r2 = r3.dwY;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 == 0) goto L_0x0287;
    L_0x0284:
        r2 = 0;
        goto L_0x0013;
    L_0x0287:
        r2 = new android.content.Intent;
        r2.<init>();
        r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r2.setFlags(r4);
        r4 = "key_product_info";
        r3 = r3.dwY;
        r2.putExtra(r4, r3);
        r3 = "key_product_scene";
        r4 = 1;
        r2.putExtra(r3, r4);
        r0 = r17;
        r3 = r0.tTq;
        r3 = r3.getContext();
        r4 = "product";
        r5 = ".ui.MallProductUI";
        com.tencent.mm.bg.d.b(r3, r4, r5, r2);
        r2 = 1;
        goto L_0x0013;
    L_0x02b4:
        r2 = new android.content.Intent;
        r2.<init>();
        r4 = "message_id";
        r0 = r18;
        r6 = r0.field_msgId;
        r2.putExtra(r4, r6);
        r4 = "record_xml";
        r3 = r3.dwW;
        r2.putExtra(r4, r3);
        r3 = "big_appmsg";
        r2.putExtra(r3, r8);
        r0 = r17;
        r1 = r18;
        com.tencent.mm.ui.chatting.viewitems.c$a.a(r2, r0, r1, r15);
        r0 = r17;
        r3 = r0.tTq;
        r3 = r3.getContext();
        r4 = "record";
        r5 = ".ui.RecordMsgDetailUI";
        com.tencent.mm.bg.d.b(r3, r4, r5, r2);
        r2 = 1;
        goto L_0x0013;
    L_0x02ec:
        r2 = r3.bRw;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 == 0) goto L_0x02f7;
    L_0x02f4:
        r2 = 0;
        goto L_0x0013;
    L_0x02f7:
        r2 = new android.content.Intent;
        r2.<init>();
        r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r2.setFlags(r4);
        r4 = "key_card_app_msg";
        r5 = r3.bRw;
        r2.putExtra(r4, r5);
        r4 = "key_from_scene";
        r3 = r3.dxG;
        r2.putExtra(r4, r3);
        r0 = r17;
        r3 = r0.tTq;
        r3 = r3.getContext();
        r4 = "card";
        r5 = ".ui.CardDetailUI";
        com.tencent.mm.bg.d.b(r3, r4, r5, r2);
        r2 = 1;
        goto L_0x0013;
    L_0x0325:
        r2 = "MicroMsg.ChattingItemAppMsgFrom";
        r4 = "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s";
        r5 = 6;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r8 = r3.dyS;
        r5[r6] = r8;
        r6 = 1;
        r8 = r3.dyR;
        r5[r6] = r8;
        r6 = 2;
        r8 = r3.dyT;
        r5[r6] = r8;
        r6 = 3;
        r8 = r3.url;
        r5[r6] = r8;
        r6 = 4;
        r8 = r3.dyZ;
        r8 = java.lang.Integer.valueOf(r8);
        r5[r6] = r8;
        r6 = 5;
        r8 = r3.dyV;
        r5[r6] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r2, r4, r5);
        r8 = r17.getTalkerUserName();
        r0 = r17;
        r1 = r18;
        r9 = r15.b(r0, r1);
        r6 = new android.os.Bundle;
        r6.<init>();
        r0 = r17;
        r2 = r0.tTq;
        r2 = r2 instanceof com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;
        if (r2 == 0) goto L_0x03aa;
    L_0x036c:
        r4 = "stat_scene";
        r2 = 10;
        r5 = r6;
    L_0x0372:
        r5.putInt(r4, r2);
        r2 = "stat_msg_id";
        r4 = new java.lang.StringBuilder;
        r5 = "msg_";
        r4.<init>(r5);
        r0 = r18;
        r10 = r0.field_msgSvrId;
        r5 = java.lang.Long.toString(r10);
        r4 = r4.append(r5);
        r4 = r4.toString();
        r6.putString(r2, r4);
        r2 = "stat_chat_talker_username";
        r6.putString(r2, r8);
        r2 = "stat_send_msg_user";
        r6.putString(r2, r9);
        r2 = r3.dyU;
        switch(r2) {
            case 1: goto L_0x03c5;
            case 2: goto L_0x0443;
            case 3: goto L_0x046b;
            default: goto L_0x03a4;
        };
    L_0x03a4:
        r2 = 1;
    L_0x03a5:
        if (r2 != 0) goto L_0x0060;
    L_0x03a7:
        r2 = 1;
        goto L_0x0013;
    L_0x03aa:
        r2 = r17.cwr();
        if (r2 == 0) goto L_0x03b6;
    L_0x03b0:
        r4 = "stat_scene";
        r2 = 2;
        r5 = r6;
        goto L_0x0372;
    L_0x03b6:
        r4 = "stat_scene";
        r2 = com.tencent.mm.model.s.hf(r8);
        if (r2 == 0) goto L_0x03c2;
    L_0x03bf:
        r2 = 7;
        r5 = r6;
        goto L_0x0372;
    L_0x03c2:
        r2 = 1;
        r5 = r6;
        goto L_0x0372;
    L_0x03c5:
        r2 = new android.content.Intent;
        r2.<init>();
        r4 = "key_username";
        r5 = r3.dyS;
        r2.putExtra(r4, r5);
        r4 = r17.cwr();
        if (r4 == 0) goto L_0x0435;
    L_0x03d8:
        r4 = "key_from_scene";
        r5 = 1;
        r2.putExtra(r4, r5);
        r4 = "key_scene_note";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r5 = r5.append(r8);
        r8 = ":";
        r5 = r5.append(r8);
        r5 = r5.append(r9);
        r5 = r5.toString();
        r2.putExtra(r4, r5);
    L_0x03fd:
        r4 = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams$a;
        r4.<init>();
        r5 = r3.dyT;
        r4.appId = r5;
        r5 = 6;
        r4.bJu = r5;
        r5 = r3.dyZ;
        r4.fih = r5;
        r5 = r3.dyW;
        r4.fii = r5;
        r5 = "key_scene_exposed_params";
        r4 = r4.aeo();
        r2.putExtra(r5, r4);
        r4 = "_stat_obj";
        r2.putExtra(r4, r6);
        r0 = r17;
        r4 = r0.tTq;
        r4 = r4.getContext();
        r5 = "appbrand";
        r6 = ".ui.AppBrandProfileUI";
        com.tencent.mm.bg.d.b(r4, r5, r6, r2);
        r2 = r7;
        goto L_0x03a5;
    L_0x0435:
        r4 = "key_from_scene";
        r5 = 2;
        r2.putExtra(r4, r5);
        r4 = "key_scene_note";
        r2.putExtra(r4, r8);
        goto L_0x03fd;
    L_0x0443:
        r0 = r17;
        r2 = r0.tTq;
        r2 = r2 instanceof com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;
        if (r2 == 0) goto L_0x0453;
    L_0x044b:
        r2 = 1073; // 0x431 float:1.504E-42 double:5.3E-321;
        com.tencent.mm.modelappbrand.a.a(r8, r2, r3, r6);
        r2 = r7;
        goto L_0x03a5;
    L_0x0453:
        r2 = com.tencent.mm.model.s.hf(r8);
        if (r2 == 0) goto L_0x0461;
    L_0x0459:
        r2 = 1074; // 0x432 float:1.505E-42 double:5.306E-321;
        com.tencent.mm.modelappbrand.a.a(r8, r2, r3, r6);
        r2 = r7;
        goto L_0x03a5;
    L_0x0461:
        r2 = r17.cwr();
        com.tencent.mm.modelappbrand.a.a(r8, r9, r2, r3, r6);
        r2 = r7;
        goto L_0x03a5;
    L_0x046b:
        r2 = r17.cwr();
        com.tencent.mm.modelappbrand.a.b(r8, r9, r2, r3, r6);
        r2 = r7;
        goto L_0x03a5;
    L_0x0475:
        r2 = r3.dyT;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 == 0) goto L_0x04c7;
    L_0x047d:
        r2 = r3.dyS;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 == 0) goto L_0x04c7;
    L_0x0485:
        r4 = r3.url;
        r2 = r17.cwr();
        if (r2 == 0) goto L_0x04c3;
    L_0x048d:
        r2 = "groupmessage";
    L_0x0490:
        r2 = com.tencent.mm.pluginsdk.model.app.p.B(r4, r2);
        r4 = new android.content.Intent;
        r4.<init>();
        r5 = "rawUrl";
        r4.putExtra(r5, r2);
        r2 = "webpageTitle";
        r5 = r3.title;
        r4.putExtra(r2, r5);
        r2 = "shortUrl";
        r3 = r3.url;
        r4.putExtra(r2, r3);
        r0 = r17;
        r2 = r0.tTq;
        r2 = r2.getContext();
        r3 = "webview";
        r5 = ".ui.tools.WebViewUI";
        com.tencent.mm.bg.d.b(r2, r3, r5, r4);
        r2 = 1;
        goto L_0x0013;
    L_0x04c3:
        r2 = "singlemessage";
        goto L_0x0490;
    L_0x04c7:
        r7 = r17.getTalkerUserName();
        r0 = r17;
        r1 = r18;
        r8 = r15.b(r0, r1);
        r6 = new android.os.Bundle;
        r6.<init>();
        r2 = r17.cwr();
        if (r2 == 0) goto L_0x0537;
    L_0x04de:
        r4 = "stat_scene";
        r2 = 2;
        r5 = r6;
    L_0x04e3:
        r5.putInt(r4, r2);
        r2 = "stat_msg_id";
        r4 = new java.lang.StringBuilder;
        r5 = "msg_";
        r4.<init>(r5);
        r0 = r18;
        r10 = r0.field_msgSvrId;
        r5 = java.lang.Long.toString(r10);
        r4 = r4.append(r5);
        r4 = r4.toString();
        r6.putString(r2, r4);
        r2 = "stat_chat_talker_username";
        r6.putString(r2, r7);
        r2 = "stat_send_msg_user";
        r6.putString(r2, r8);
        r2 = com.tencent.mm.plugin.appbrand.n.d.class;
        r4 = com.tencent.mm.kernel.g.l(r2);
        r4 = (com.tencent.mm.plugin.appbrand.n.d) r4;
        r0 = r17;
        r2 = r0.tTq;
        r5 = r2.getContext();
        r6 = r17.getTalkerUserName();
        r0 = r17;
        r1 = r18;
        r7 = r15.b(r0, r1);
        r8 = r17.cwr();
        r9 = r3;
        r4.a(r5, r6, r7, r8, r9);
        r2 = 1;
        goto L_0x0013;
    L_0x0537:
        r4 = "stat_scene";
        r2 = com.tencent.mm.model.s.hf(r7);
        if (r2 == 0) goto L_0x0543;
    L_0x0540:
        r2 = 7;
        r5 = r6;
        goto L_0x04e3;
    L_0x0543:
        r2 = 1;
        r5 = r6;
        goto L_0x04e3;
    L_0x0546:
        r2 = new com.tencent.mm.g.a.lj;
        r2.<init>();
        r4 = r2.bVI;
        r0 = r17;
        r5 = r0.tTq;
        r5 = r5.getContext();
        r4.context = r5;
        r4 = r2.bVI;
        r0 = r18;
        r6 = r0.field_msgId;
        r4.bJC = r6;
        r4 = r2.bVI;
        r5 = r17.cwr();
        r4.bUY = r5;
        r4 = r2.bVI;
        r3 = r3.dwW;
        r4.bVJ = r3;
        r3 = r2.bVI;
        r4 = 6;
        r3.scene = r4;
        r3 = com.tencent.mm.sdk.b.a.sFg;
        r3.m(r2);
        r2 = 1;
        goto L_0x0013;
    L_0x057a:
        r2 = new android.content.Intent;
        r2.<init>();
        r4 = "key_from_user_name";
        r0 = r17;
        r1 = r18;
        r5 = r15.b(r0, r1);
        r2.putExtra(r4, r5);
        r4 = "key_biz_uin";
        r5 = r3.dxI;
        r2.putExtra(r4, r5);
        r4 = "key_order_id";
        r3 = r3.dxJ;
        r2.putExtra(r4, r3);
        r0 = r18;
        r3 = r0.field_talker;
        if (r3 == 0) goto L_0x05c7;
    L_0x05a3:
        r0 = r18;
        r3 = r0.field_talker;
        r4 = "";
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x05c7;
    L_0x05b0:
        r0 = r18;
        r3 = r0.field_talker;
        r4 = "@chatroom";
        r3 = r3.endsWith(r4);
        if (r3 == 0) goto L_0x05c7;
    L_0x05bd:
        r3 = "key_chatroom_name";
        r0 = r18;
        r4 = r0.field_talker;
        r2.putExtra(r3, r4);
    L_0x05c7:
        r0 = r17;
        r3 = r0.tTq;
        r3 = r3.getContext();
        r4 = "card";
        r5 = ".ui.CardGiftAcceptUI";
        com.tencent.mm.bg.d.b(r3, r4, r5, r2);
        r2 = 1;
        goto L_0x0013;
    L_0x05db:
        r2 = com.tencent.mm.plugin.websearch.api.q.class;
        r2 = r3.u(r2);
        r2 = (com.tencent.mm.plugin.websearch.api.q) r2;
        if (r2 == 0) goto L_0x066b;
    L_0x05e5:
        r4 = r2.pLr;
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r4 != 0) goto L_0x066b;
    L_0x05ed:
        r3 = new android.content.Intent;
        r3.<init>();
        r4 = new com.tencent.mm.protocal.c.cfn;
        r4.<init>();
        r5 = r2.pLr;
        r4.pLr = r5;
        r5 = r2.pLs;
        r4.pLs = r5;
        r5 = r2.pLt;
        r4.pLt = r5;
        r5 = r2.pLu;
        r4.pLu = r5;
        r6 = r2.pLv;
        r4.pLv = r6;
        r5 = r2.pLz;
        r4.pLz = r5;
        r5 = r2.ixy;
        r4.ixy = r5;
        r5 = r2.ixz;
        r4.ixz = r5;
        r5 = r2.nzH;
        r4.nzH = r5;
        r5 = r2.pLw;
        r4.pLw = r5;
        r5 = r2.pLx;
        r4.pLx = r5;
        r5 = r2.pLy;
        r4.pLy = r5;
        r5 = r2.bhd;
        r4.bhd = r5;
        r5 = r2.lRt;
        r4.lRt = r5;
        r5 = r2.pLA;
        r4.pLA = r5;
        r2 = r2.pLC;
        r4.pLC = r2;
        r2 = 32;
        r0 = r17;
        r5 = r0.tTq;
        r5 = r5.getContext();
        r6 = com.tencent.mm.R.l.fts_recommend_search_keyword;
        r5 = r5.getString(r6);
        r2 = com.tencent.mm.plugin.topstory.a.g.a(r4, r2, r5);
        r5 = "key_context";
        r2 = r2.toByteArray();	 Catch:{ IOException -> 0x082f }
        r3.putExtra(r5, r2);	 Catch:{ IOException -> 0x082f }
    L_0x0655:
        r0 = r18;
        com.tencent.mm.plugin.topstory.a.h.a(r4, r0);
        r0 = r17;
        r2 = r0.tTq;
        r2 = r2.getContext();
        r4 = ".ui.video.TopStoryVideoStreamUI";
        com.tencent.mm.plugin.websearch.api.p.c(r2, r4, r3);
        r2 = 1;
        goto L_0x0013;
    L_0x066b:
        r4 = r3.url;
        r2 = r17.cwr();
        if (r2 == 0) goto L_0x080f;
    L_0x0673:
        r2 = "groupmessage";
    L_0x0676:
        r2 = com.tencent.mm.pluginsdk.model.app.p.B(r4, r2);
        r4 = r3.url;
        r0 = r17;
        r5 = r0.tTq;
        r5 = r5.getContext();
        r6 = r3.appId;
        r5 = getPackageInfo(r5, r6);
        r6 = new android.content.Intent;
        r6.<init>();
        r7 = "rawUrl";
        r6.putExtra(r7, r2);
        r2 = "webpageTitle";
        r7 = r3.title;
        r6.putExtra(r2, r7);
        r2 = r3.appId;
        if (r2 == 0) goto L_0x06d5;
    L_0x06a1:
        r2 = "wx751a1acca5688ba3";
        r7 = r3.appId;
        r2 = r2.equals(r7);
        if (r2 != 0) goto L_0x06c2;
    L_0x06ac:
        r2 = "wxfbc915ff7c30e335";
        r7 = r3.appId;
        r2 = r2.equals(r7);
        if (r2 != 0) goto L_0x06c2;
    L_0x06b7:
        r2 = "wx482a4001c37e2b74";
        r7 = r3.appId;
        r2 = r2.equals(r7);
        if (r2 == 0) goto L_0x06d5;
    L_0x06c2:
        r2 = new android.os.Bundle;
        r2.<init>();
        r7 = "jsapi_args_appid";
        r8 = r3.appId;
        r2.putString(r7, r8);
        r7 = "jsapiargs";
        r6.putExtra(r7, r2);
    L_0x06d5:
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r2 != 0) goto L_0x0814;
    L_0x06db:
        r2 = "shortUrl";
        r6.putExtra(r2, r4);
    L_0x06e1:
        r4 = "version_name";
        if (r5 != 0) goto L_0x081e;
    L_0x06e6:
        r2 = 0;
    L_0x06e7:
        r6.putExtra(r4, r2);
        r4 = "version_code";
        if (r5 != 0) goto L_0x0822;
    L_0x06ef:
        r2 = 0;
    L_0x06f0:
        r6.putExtra(r4, r2);
        r2 = r3.bZG;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 != 0) goto L_0x070b;
    L_0x06fb:
        r2 = "srcUsername";
        r4 = r3.bZG;
        r6.putExtra(r2, r4);
        r2 = "srcDisplayname";
        r4 = r3.bZH;
        r6.putExtra(r2, r4);
    L_0x070b:
        r2 = "msg_id";
        r0 = r18;
        r4 = r0.field_msgId;
        r6.putExtra(r2, r4);
        r2 = "KPublisherId";
        r4 = new java.lang.StringBuilder;
        r5 = "msg_";
        r4.<init>(r5);
        r0 = r18;
        r8 = r0.field_msgSvrId;
        r5 = java.lang.Long.toString(r8);
        r4 = r4.append(r5);
        r4 = r4.toString();
        r6.putExtra(r2, r4);
        r2 = "KAppId";
        r4 = r3.appId;
        r6.putExtra(r2, r4);
        r2 = "geta8key_username";
        r4 = r17.getTalkerUserName();
        r6.putExtra(r2, r4);
        r2 = "pre_username";
        r0 = r17;
        r1 = r18;
        r4 = r15.b(r0, r1);
        r6.putExtra(r2, r4);
        r2 = "from_scence";
        r4 = 2;
        r6.putExtra(r2, r4);
        r2 = "expid_str";
        r0 = r18;
        r4 = r0.cGK;
        r6.putExtra(r2, r4);
        r0 = r17;
        r1 = r18;
        r2 = r15.b(r0, r1);
        r4 = r17.getTalkerUserName();
        r2 = com.tencent.mm.model.t.N(r2, r4);
        r4 = "prePublishId";
        r5 = new java.lang.StringBuilder;
        r7 = "msg_";
        r5.<init>(r7);
        r0 = r18;
        r8 = r0.field_msgSvrId;
        r7 = java.lang.Long.toString(r8);
        r5 = r5.append(r7);
        r5 = r5.toString();
        r6.putExtra(r4, r5);
        r4 = "preUsername";
        r0 = r17;
        r1 = r18;
        r5 = r15.b(r0, r1);
        r6.putExtra(r4, r5);
        r4 = "preChatName";
        r5 = r17.getTalkerUserName();
        r6.putExtra(r4, r5);
        r4 = "preChatTYPE";
        r6.putExtra(r4, r2);
        r4 = "preMsgIndex";
        r5 = 0;
        r6.putExtra(r4, r5);
        switch(r2) {
            case 1: goto L_0x0828;
            case 2: goto L_0x0826;
            case 3: goto L_0x07ba;
            case 4: goto L_0x07ba;
            case 5: goto L_0x07ba;
            case 6: goto L_0x082a;
            case 7: goto L_0x082a;
            default: goto L_0x07ba;
        };
    L_0x07ba:
        r2 = 0;
    L_0x07bb:
        r4 = "share_report_pre_msg_url";
        r5 = r3.url;
        r6.putExtra(r4, r5);
        r4 = "share_report_pre_msg_title";
        r5 = r3.title;
        r6.putExtra(r4, r5);
        r4 = "share_report_pre_msg_desc";
        r5 = r3.description;
        r6.putExtra(r4, r5);
        r4 = "share_report_pre_msg_icon_url";
        r5 = r3.thumburl;
        r6.putExtra(r4, r5);
        r4 = "share_report_pre_msg_appid";
        r3 = r3.appId;
        r6.putExtra(r4, r3);
        r3 = "share_report_from_scene";
        r6.putExtra(r3, r2);
        r3 = 5;
        if (r2 != r3) goto L_0x07f6;
    L_0x07ec:
        r2 = "share_report_biz_username";
        r3 = r17.getTalkerUserName();
        r6.putExtra(r2, r3);
    L_0x07f6:
        r2 = 536870912; // 0x20000000 float:1.0842022E-19 double:2.652494739E-315;
        r6.addFlags(r2);
        r0 = r17;
        r2 = r0.tTq;
        r2 = r2.getContext();
        r3 = "webview";
        r4 = ".ui.tools.WebViewUI";
        com.tencent.mm.bg.d.b(r2, r3, r4, r6);
        r2 = 1;
        goto L_0x0013;
    L_0x080f:
        r2 = "singlemessage";
        goto L_0x0676;
    L_0x0814:
        r2 = "shortUrl";
        r4 = r3.url;
        r6.putExtra(r2, r4);
        goto L_0x06e1;
    L_0x081e:
        r2 = r5.versionName;
        goto L_0x06e7;
    L_0x0822:
        r2 = r5.versionCode;
        goto L_0x06f0;
    L_0x0826:
        r2 = 2;
        goto L_0x07bb;
    L_0x0828:
        r2 = 3;
        goto L_0x07bb;
    L_0x082a:
        r2 = 5;
        goto L_0x07bb;
    L_0x082c:
        r2 = 0;
        goto L_0x0013;
    L_0x082f:
        r2 = move-exception;
        goto L_0x0655;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.c$d.b(android.view.View, com.tencent.mm.ui.chatting.c.a, com.tencent.mm.storage.bd):boolean");
    }
}
