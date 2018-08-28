package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.t.h;
import com.tencent.mm.ui.chatting.t.i;
import com.tencent.mm.ui.chatting.t.k;
import com.tencent.mm.ui.chatting.t.m;
import com.tencent.mm.ui.chatting.viewitems.c.b;
import com.tencent.mm.y.g$a;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public class c$e extends b implements m {
    private a tKy;
    private c tXU;
    protected i uaA;
    protected h uay;
    protected k uaz;

    public final boolean bba() {
        return true;
    }

    public c$e() {
        c.a aVar = new c.a();
        aVar.dXN = R.k.app_brand_app_default_icon_for_tail;
        aVar.bg(com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 20), com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 20)).dXw = true;
        this.tXU = aVar.Pt();
    }

    public final boolean aq(int i, boolean z) {
        if ((z && i == 49) || i == 335544369 || i == 402653233 || i == 369098801) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_to_appmsg);
        rVar.setTag(new c.c().p(rVar, false));
        return rVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.ui.chatting.viewitems.b.a r25, int r26, com.tencent.mm.ui.chatting.c.a r27, com.tencent.mm.storage.bd r28, java.lang.String r29) {
        /*
        r24 = this;
        r20 = r25;
        r20 = (com.tencent.mm.ui.chatting.viewitems.c.c) r20;
        r0 = r27;
        r1 = r24;
        r1.tKy = r0;
        r6 = com.tencent.mm.ui.chatting.b.b.i.class;
        r0 = r27;
        r6 = r0.O(r6);
        r6 = (com.tencent.mm.ui.chatting.b.b.i) r6;
        r0 = r28;
        r6.aX(r0);
        r20.reset();
        r0 = r28;
        r0 = r0.field_content;
        r16 = r0;
        r6 = com.tencent.mm.ui.chatting.b.b.i.class;
        r0 = r27;
        r6 = r0.O(r6);
        r6 = (com.tencent.mm.ui.chatting.b.b.i) r6;
        r0 = r28;
        r6.aV(r0);
        r7 = 0;
        r6 = 0;
        if (r16 == 0) goto L_0x151f;
    L_0x0035:
        r0 = r28;
        r6 = r0.field_reserved;
        r0 = r16;
        r7 = com.tencent.mm.y.g$a.J(r0, r6);
        r6 = com.tencent.mm.y.k.gv(r16);
        r14 = r6;
        r21 = r7;
    L_0x0046:
        r6 = new com.tencent.mm.ui.chatting.viewitems.au;
        r8 = r27.cwr();
        r10 = 0;
        r11 = 0;
        r7 = r28;
        r9 = r26;
        r6.<init>(r7, r8, r9, r10, r11);
        r15 = 0;
        if (r21 == 0) goto L_0x0313;
    L_0x0058:
        r0 = r21;
        r7 = r0.appId;
        r0 = r21;
        r8 = r0.cbu;
        r9 = com.tencent.mm.pluginsdk.model.app.g.cP(r7, r8);
        r0 = r20;
        r7 = r0.eCm;
        r0 = r21;
        r8 = r0.title;
        r7.setText(r8);
        r0 = r20;
        r7 = r0.eCn;
        r0 = r21;
        r8 = r0.description;
        r7.setText(r8);
        r0 = r20;
        r7 = r0.tZN;
        r8 = 1;
        r7.setMaxLines(r8);
        r0 = r20;
        r7 = r0.eCm;
        r0 = r27;
        r8 = r0.tTq;
        r8 = r8.getContext();
        r8 = r8.getResources();
        r10 = com.tencent.mm.R.e.normal_text_color;
        r8 = r8.getColor(r10);
        r7.setTextColor(r8);
        r0 = r20;
        r7 = r0.eCn;
        r0 = r27;
        r8 = r0.tTq;
        r8 = r8.getContext();
        r8 = r8.getResources();
        r10 = com.tencent.mm.R.e.hint_text_color;
        r8 = r8.getColor(r10);
        r7.setTextColor(r8);
        r0 = r20;
        r7 = r0.uad;
        r8 = com.tencent.mm.R.g.chat_to_content_bg_mask;
        r7.setBackgroundResource(r8);
        r0 = r20;
        r7 = r0.uad;
        r8 = 0;
        r0 = r27;
        r10 = r0.tTq;
        r10 = r10.getContext();
        r10 = r10.getResources();
        r11 = com.tencent.mm.R.f.MiddlePadding;
        r10 = r10.getDimensionPixelSize(r11);
        r11 = 0;
        r12 = 0;
        r7.setPadding(r8, r10, r11, r12);
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
        r7 = r0.uaf;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.uag;
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
        r7 = r0.tZO;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZL;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZK;
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
        if (r9 == 0) goto L_0x0167;
    L_0x0157:
        r7 = r9.field_appName;
        if (r7 == 0) goto L_0x0167;
    L_0x015b:
        r7 = r9.field_appName;
        r7 = r7.trim();
        r7 = r7.length();
        if (r7 > 0) goto L_0x036d;
    L_0x0167:
        r0 = r21;
        r7 = r0.appName;
    L_0x016b:
        r8 = 1;
        r0 = r27;
        r10 = r0.tTq;
        r10 = r10.getContext();
        r11 = 12;
        com.tencent.mm.bp.a.fromDPToPix(r10, r11);
        r0 = r21;
        r10 = r0.type;
        r11 = 20;
        if (r10 == r11) goto L_0x018e;
    L_0x0181:
        r10 = "wxaf060266bfa9a35c";
        r0 = r21;
        r11 = r0.appId;
        r10 = r10.equals(r11);
        if (r10 == 0) goto L_0x0196;
    L_0x018e:
        r8 = com.tencent.mm.pluginsdk.o.a.cbj();
        r8 = r8.buA();
    L_0x0196:
        if (r8 == 0) goto L_0x0380;
    L_0x0198:
        r0 = r21;
        r8 = r0.appId;
        if (r8 == 0) goto L_0x0380;
    L_0x019e:
        r0 = r21;
        r8 = r0.appId;
        r8 = r8.length();
        if (r8 <= 0) goto L_0x0380;
    L_0x01a8:
        r8 = com.tencent.mm.pluginsdk.model.app.g.cT(r7);
        if (r8 == 0) goto L_0x0380;
    L_0x01ae:
        r0 = r20;
        r8 = r0.jet;
        r0 = r27;
        r10 = r0.tTq;
        r10 = r10.getContext();
        r7 = com.tencent.mm.pluginsdk.model.app.g.b(r10, r9, r7);
        r8.setText(r7);
        r0 = r20;
        r7 = r0.tZM;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.jet;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.jet;
        r8 = 0;
        r10 = 0;
        r11 = 0;
        r12 = 0;
        r7.setCompoundDrawables(r8, r10, r11, r12);
        r0 = r20;
        r7 = r0.tZJ;
        r8 = 0;
        r7.setVisibility(r8);
        if (r9 == 0) goto L_0x0371;
    L_0x01e6:
        r7 = r9.aaq();
        if (r7 == 0) goto L_0x0371;
    L_0x01ec:
        r0 = r20;
        r8 = r0.jet;
        r11 = r9.field_packageName;
        r0 = r28;
        r12 = r0.field_msgSvrId;
        r7 = r27;
        r9 = r28;
        r10 = r21;
        a(r7, r8, r9, r10, r11, r12);
    L_0x01ff:
        r0 = r20;
        r7 = r0.tZJ;
        r0 = r21;
        r8 = r0.appId;
        r0 = r27;
        a(r0, r7, r8);
    L_0x020c:
        r7 = 0;
        r0 = r20;
        r8 = r0.tZI;
        r9 = 0;
        r8.setVisibility(r9);
        r0 = r24;
        r8 = r0.qUB;
        if (r8 == 0) goto L_0x0418;
    L_0x021b:
        r8 = 0;
        r0 = r21;
        r9 = r0.type;
        r10 = 33;
        if (r9 == r10) goto L_0x0245;
    L_0x0224:
        r0 = r21;
        r9 = r0.type;
        r10 = 36;
        if (r9 == r10) goto L_0x0245;
    L_0x022c:
        r8 = com.tencent.mm.ak.o.Pf();
        r0 = r28;
        r9 = r0.field_imgPath;
        r0 = r27;
        r10 = r0.tTq;
        r10 = r10.getContext();
        r10 = com.tencent.mm.bp.a.getDensity(r10);
        r11 = 0;
        r8 = r8.a(r9, r10, r11);
    L_0x0245:
        if (r8 == 0) goto L_0x0415;
    L_0x0247:
        r9 = r8.isRecycled();
        if (r9 != 0) goto L_0x0415;
    L_0x024d:
        r0 = r20;
        r9 = r0.tZI;
        r9.setImageBitmap(r8);
    L_0x0254:
        r0 = r21;
        r9 = r0.type;
        r10 = 3;
        if (r9 != r10) goto L_0x0271;
    L_0x025b:
        r0 = r20;
        r9 = r0.uad;
        r9 = r9.getViewTreeObserver();
        r10 = new com.tencent.mm.ui.chatting.viewitems.c$e$1;
        r0 = r24;
        r1 = r20;
        r2 = r27;
        r10.<init>(r0, r1, r2, r8);
        r9.addOnPreDrawListener(r10);
    L_0x0271:
        r22 = r7;
    L_0x0273:
        r23 = 0;
        r0 = r20;
        r7 = r0.tZT;
        r8 = 0;
        r7.setOnClickListener(r8);
        r0 = r21;
        r7 = r0.type;
        switch(r7) {
            case 0: goto L_0x0d48;
            case 1: goto L_0x0284;
            case 2: goto L_0x0284;
            case 3: goto L_0x0431;
            case 4: goto L_0x062f;
            case 5: goto L_0x07ed;
            case 6: goto L_0x057e;
            case 7: goto L_0x0ad1;
            case 8: goto L_0x0284;
            case 9: goto L_0x0284;
            case 10: goto L_0x0b8d;
            case 11: goto L_0x0284;
            case 12: goto L_0x0284;
            case 13: goto L_0x0c4c;
            case 14: goto L_0x0284;
            case 15: goto L_0x0dcd;
            case 16: goto L_0x10e6;
            case 17: goto L_0x0284;
            case 18: goto L_0x0284;
            case 19: goto L_0x1269;
            case 20: goto L_0x0cc6;
            case 21: goto L_0x0284;
            case 22: goto L_0x0284;
            case 23: goto L_0x0284;
            case 24: goto L_0x1181;
            case 25: goto L_0x0e98;
            case 26: goto L_0x0f72;
            case 27: goto L_0x0f72;
            case 28: goto L_0x0284;
            case 29: goto L_0x0284;
            case 30: goto L_0x0284;
            case 31: goto L_0x0284;
            case 32: goto L_0x0284;
            case 33: goto L_0x0914;
            case 34: goto L_0x12c2;
            case 35: goto L_0x0284;
            case 36: goto L_0x06c1;
            case 37: goto L_0x0284;
            case 38: goto L_0x0284;
            case 39: goto L_0x0284;
            case 40: goto L_0x149d;
            default: goto L_0x0284;
        };
    L_0x0284:
        r7 = 1;
        r12 = r6;
    L_0x0286:
        if (r7 == 0) goto L_0x1513;
    L_0x0288:
        r0 = r21;
        r6 = r0.title;
        if (r6 == 0) goto L_0x14b3;
    L_0x028e:
        r0 = r21;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x14b3;
    L_0x0298:
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
    L_0x02b3:
        r0 = r20;
        r6 = r0.eCm;
        r7 = 8;
        r6.setVisibility(r7);
        if (r22 == 0) goto L_0x1513;
    L_0x02be:
        r0 = r21;
        r6 = r0.type;
        r7 = 33;
        if (r6 == r7) goto L_0x02ce;
    L_0x02c6:
        r0 = r21;
        r6 = r0.type;
        r7 = 36;
        if (r6 != r7) goto L_0x14be;
    L_0x02ce:
        r6 = com.tencent.mm.ak.o.Pf();
        r0 = r28;
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
        r6 = r12;
    L_0x0313:
        if (r15 != 0) goto L_0x032b;
    L_0x0315:
        r0 = r20;
        r7 = r0.uac;
        r7.setTag(r6);
        r0 = r20;
        r6 = r0.uac;
        r0 = r24;
        r1 = r27;
        r7 = r0.d(r1);
        r6.setOnClickListener(r7);
    L_0x032b:
        r0 = r24;
        r6 = r0.qUB;
        if (r6 == 0) goto L_0x0355;
    L_0x0331:
        r0 = r20;
        r6 = r0.uac;
        r0 = r24;
        r1 = r27;
        r7 = r0.c(r1);
        r6.setOnLongClickListener(r7);
        r0 = r20;
        r7 = r0.uac;
        r6 = com.tencent.mm.ui.chatting.b.b.g.class;
        r0 = r27;
        r6 = r0.O(r6);
        r6 = (com.tencent.mm.ui.chatting.b.b.g) r6;
        r6 = r6.ctw();
        r7.setOnTouchListener(r6);
    L_0x0355:
        r10 = r27.cwp();
        r11 = r27.cwr();
        r6 = r24;
        r7 = r26;
        r8 = r20;
        r9 = r28;
        r12 = r27;
        r13 = r24;
        r6.a(r7, r8, r9, r10, r11, r12, r13);
        return;
    L_0x036d:
        r7 = r9.field_appName;
        goto L_0x016b;
    L_0x0371:
        r0 = r20;
        r7 = r0.jet;
        r0 = r21;
        r8 = r0.appId;
        r0 = r27;
        a(r0, r7, r8);
        goto L_0x01ff;
    L_0x0380:
        r0 = r21;
        r7 = r0.type;
        r8 = 24;
        if (r7 != r8) goto L_0x03b4;
    L_0x0388:
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
        goto L_0x020c;
    L_0x03b4:
        r0 = r21;
        r7 = r0.type;
        r8 = 19;
        if (r7 == r8) goto L_0x03c2;
    L_0x03bc:
        r7 = r14.dzv;
        r8 = 19;
        if (r7 != r8) goto L_0x03ee;
    L_0x03c2:
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
        goto L_0x020c;
    L_0x03ee:
        r0 = r21;
        r1 = r20;
        r7 = com.tencent.mm.ui.chatting.viewitems.c.a(r0, r1);
        if (r7 != 0) goto L_0x020c;
    L_0x03f8:
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
        goto L_0x020c;
    L_0x0415:
        r7 = 1;
        goto L_0x0254;
    L_0x0418:
        r0 = r20;
        r8 = r0.tZI;
        r0 = r27;
        r9 = r0.tTq;
        r9 = r9.getMMResources();
        r10 = com.tencent.mm.R.g.nosdcard_app;
        r9 = android.graphics.BitmapFactory.decodeResource(r9, r10);
        r8.setImageBitmap(r9);
        r22 = r7;
        goto L_0x0273;
    L_0x0431:
        r0 = r21;
        r7 = r0.title;
        if (r7 == 0) goto L_0x053d;
    L_0x0437:
        r0 = r21;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x053d;
    L_0x0441:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.eCm;
        r0 = r27;
        r8 = r0.tTq;
        r8 = r8.getContext();
        r8 = r8.getResources();
        r9 = com.tencent.mm.R.e.white;
        r8 = r8.getColor(r9);
        r7.setTextColor(r8);
    L_0x0462:
        r0 = r20;
        r7 = r0.eCn;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.eCn;
        r0 = r27;
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
        r7 = r0.eCn;
        r8 = 2;
        r7.setMaxLines(r8);
        r0 = r20;
        r7 = r0.tZT;
        r8 = 0;
        r7.setVisibility(r8);
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r0 = r28;
        r8 = r0.field_msgId;
        r7 = r7.append(r8);
        r7 = r7.toString();
        r0 = r25;
        r8 = r0.tZw;
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x0548;
    L_0x04bf:
        r0 = r20;
        r7 = r0.tZT;
        r8 = com.tencent.mm.R.g.music_pauseicon;
        r7.setImageResource(r8);
    L_0x04c8:
        r7 = new com.tencent.mm.ui.chatting.viewitems.c$f;
        r7.<init>();
        r0 = r28;
        r8 = r0.field_msgId;
        r7.bJC = r8;
        r0 = r28;
        r8 = r0.field_content;
        r7.bVv = r8;
        r0 = r28;
        r8 = r0.field_imgPath;
        r7.bSw = r8;
        r0 = r20;
        r8 = r0.tZT;
        r8.setTag(r7);
        r0 = r20;
        r8 = r0.tZT;
        r7 = com.tencent.mm.ui.chatting.b.b.g.class;
        r0 = r27;
        r7 = r0.O(r7);
        r7 = (com.tencent.mm.ui.chatting.b.b.g) r7;
        r7 = r7.ctx();
        r8.setOnClickListener(r7);
        if (r22 == 0) goto L_0x0523;
    L_0x04fd:
        r0 = r21;
        r7 = r0.appId;
        r8 = 1;
        r0 = r27;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = com.tencent.mm.bp.a.getDensity(r9);
        r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
        if (r7 == 0) goto L_0x051a;
    L_0x0514:
        r8 = r7.isRecycled();
        if (r8 == 0) goto L_0x0553;
    L_0x051a:
        r0 = r20;
        r7 = r0.tZI;
        r8 = com.tencent.mm.R.k.app_attach_file_icon_music;
        r7.setImageResource(r8);
    L_0x0523:
        r7 = cxN();
        if (r7 == 0) goto L_0x055b;
    L_0x0529:
        r0 = r20;
        r7 = r0.mgA;
        if (r7 == 0) goto L_0x1516;
    L_0x052f:
        r0 = r20;
        r7 = r0.mgA;
        r8 = 8;
        r7.setVisibility(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x053d:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x0462;
    L_0x0548:
        r0 = r20;
        r7 = r0.tZT;
        r8 = com.tencent.mm.R.g.music_playicon;
        r7.setImageResource(r8);
        goto L_0x04c8;
    L_0x0553:
        r0 = r20;
        r8 = r0.tZI;
        r8.setImageBitmap(r7);
        goto L_0x0523;
    L_0x055b:
        r0 = r20;
        r7 = r0.mgA;
        if (r7 == 0) goto L_0x1516;
    L_0x0561:
        r0 = r20;
        r7 = r0.mgA;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r28;
        r7 = r0.field_status;
        r8 = 2;
        if (r7 < r8) goto L_0x1516;
    L_0x0570:
        r0 = r20;
        r7 = r0.mgA;
        r8 = 8;
        r7.setVisibility(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x057e:
        r0 = r21;
        r7 = r0.title;
        if (r7 == 0) goto L_0x0611;
    L_0x0584:
        r0 = r21;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x0611;
    L_0x058e:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.eCm;
        r8 = 2;
        r7.setMaxLines(r8);
    L_0x059e:
        r0 = r20;
        r7 = r0.eCn;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZN;
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
        r0 = r20;
        r7 = r0.tZT;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.dwo;
        r0 = r20;
        r1 = r16;
        com.tencent.mm.ui.chatting.viewitems.c.c.a(r0, r1, r7);
        r7 = 0;
        r7 = java.lang.Boolean.valueOf(r7);
        r0 = r21;
        r8 = r0.bGP;
        r0 = r21;
        r9 = r0.title;
        r0 = r20;
        r1 = r28;
        com.tencent.mm.ui.chatting.viewitems.c.c.a(r0, r7, r1, r8, r9);
        if (r22 == 0) goto L_0x1516;
    L_0x05f9:
        r0 = r21;
        r7 = r0.dwp;
        r7 = com.tencent.mm.sdk.platformtools.bi.Xi(r7);
        if (r7 == 0) goto L_0x061b;
    L_0x0603:
        r0 = r20;
        r7 = r0.tZI;
        r8 = com.tencent.mm.R.g.appshareimage_icon;
        r7.setImageResource(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x0611:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x059e;
    L_0x061b:
        r0 = r20;
        r7 = r0.tZI;
        r0 = r21;
        r8 = r0.dwp;
        r8 = com.tencent.mm.pluginsdk.model.o.SQ(r8);
        r7.setImageResource(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x062f:
        r0 = r21;
        r7 = r0.title;
        if (r7 == 0) goto L_0x06af;
    L_0x0635:
        r0 = r21;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x06af;
    L_0x063f:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 0;
        r7.setVisibility(r8);
    L_0x0647:
        r0 = r20;
        r7 = r0.eCn;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZN;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.eCn;
        r8 = 2;
        r7.setMaxLines(r8);
        r0 = r20;
        r7 = r0.tZO;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZT;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZT;
        r8 = com.tencent.mm.R.g.video_download_btn;
        r7.setImageResource(r8);
        if (r22 == 0) goto L_0x1516;
    L_0x067b:
        r0 = r21;
        r7 = r0.appId;
        r8 = 1;
        r0 = r27;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = com.tencent.mm.bp.a.getDensity(r9);
        r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
        if (r7 == 0) goto L_0x0698;
    L_0x0692:
        r8 = r7.isRecycled();
        if (r8 == 0) goto L_0x06b9;
    L_0x0698:
        r0 = r20;
        r7 = r0.tZI;
        r8 = com.tencent.mm.R.k.app_attach_file_icon_video;
        r7.setImageResource(r8);
    L_0x06a1:
        r0 = r20;
        r7 = r0.tZT;
        r8 = 8;
        r7.setVisibility(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x06af:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x0647;
    L_0x06b9:
        r0 = r20;
        r8 = r0.tZI;
        r8.setImageBitmap(r7);
        goto L_0x06a1;
    L_0x06c1:
        r7 = com.tencent.mm.plugin.appbrand.n.c.class;
        r7 = com.tencent.mm.kernel.g.l(r7);
        r7 = (com.tencent.mm.plugin.appbrand.n.c) r7;
        r0 = r21;
        r8 = r0.dyS;
        r9 = r7.rR(r8);
        if (r9 == 0) goto L_0x07a7;
    L_0x06d3:
        r7 = r9.field_nickname;
        r8 = r7;
    L_0x06d6:
        if (r9 == 0) goto L_0x07ae;
    L_0x06d8:
        r7 = r9.field_brandIconURL;
    L_0x06da:
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
            case 1: goto L_0x07b4;
            case 2: goto L_0x07bf;
            default: goto L_0x0721;
        };
    L_0x0721:
        r0 = r20;
        r8 = r0.uap;
        r9 = com.tencent.mm.R.l.app_brand_entrance;
        r8.setText(r9);
    L_0x072a:
        r8 = com.tencent.mm.ak.o.Pj();
        r0 = r20;
        r9 = r0.uan;
        r0 = r24;
        r10 = r0.tXU;
        r8.a(r7, r9, r10);
        r7 = com.tencent.mm.ak.o.Pf();
        r0 = r28;
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
        r7 = cxN();
        if (r7 == 0) goto L_0x07ca;
    L_0x0782:
        r7 = com.tencent.mm.ui.chatting.b.b.g.class;
        r0 = r27;
        r7 = r0.O(r7);
        r7 = (com.tencent.mm.ui.chatting.b.b.g) r7;
        r0 = r20;
        r1 = r28;
        a(r0, r7, r1);
        r0 = r20;
        r7 = r0.mgA;
        if (r7 == 0) goto L_0x1516;
    L_0x0799:
        r0 = r20;
        r7 = r0.mgA;
        r8 = 8;
        r7.setVisibility(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x07a7:
        r0 = r21;
        r7 = r0.bZH;
        r8 = r7;
        goto L_0x06d6;
    L_0x07ae:
        r0 = r21;
        r7 = r0.dzb;
        goto L_0x06da;
    L_0x07b4:
        r0 = r20;
        r8 = r0.uap;
        r9 = com.tencent.mm.R.l.app_brand_share_wxa_testing_tag;
        r8.setText(r9);
        goto L_0x072a;
    L_0x07bf:
        r0 = r20;
        r8 = r0.uap;
        r9 = com.tencent.mm.R.l.app_brand_share_wxa_preview_tag;
        r8.setText(r9);
        goto L_0x072a;
    L_0x07ca:
        r0 = r20;
        r7 = r0.mgA;
        if (r7 == 0) goto L_0x1516;
    L_0x07d0:
        r0 = r20;
        r7 = r0.mgA;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r28;
        r7 = r0.field_status;
        r8 = 2;
        if (r7 < r8) goto L_0x1516;
    L_0x07df:
        r0 = r20;
        r7 = r0.mgA;
        r8 = 8;
        r7.setVisibility(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x07ed:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.title;
        if (r7 == 0) goto L_0x08c3;
    L_0x07fc:
        r0 = r21;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x08c3;
    L_0x0806:
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
        r0 = r21;
        r8 = r0.title;
        r7.setText(r8);
    L_0x0821:
        r0 = r20;
        r7 = r0.eCn;
        r8 = 3;
        r7.setMaxLines(r8);
        r0 = r20;
        r7 = r0.tZO;
        r8 = 4;
        r7.setVisibility(r8);
        r7 = com.tencent.mm.ui.chatting.viewitems.c.h(r21);
        if (r7 == 0) goto L_0x08ce;
    L_0x0837:
        r0 = r20;
        r7 = r0.tZT;
        r8 = com.tencent.mm.R.g.video_download_btn;
        r7.setImageResource(r8);
        r0 = r20;
        r7 = r0.tZT;
        r8 = 0;
        r7.setVisibility(r8);
    L_0x0848:
        if (r22 == 0) goto L_0x0898;
    L_0x084a:
        r0 = r21;
        r7 = r0.appId;
        r8 = 1;
        r0 = r27;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = com.tencent.mm.bp.a.getDensity(r9);
        r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
        if (r7 != 0) goto L_0x08d9;
    L_0x0861:
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
    L_0x0898:
        r7 = cxN();
        if (r7 == 0) goto L_0x08f1;
    L_0x089e:
        r7 = com.tencent.mm.ui.chatting.b.b.g.class;
        r0 = r27;
        r7 = r0.O(r7);
        r7 = (com.tencent.mm.ui.chatting.b.b.g) r7;
        r0 = r20;
        r1 = r28;
        a(r0, r7, r1);
        r0 = r20;
        r7 = r0.mgA;
        if (r7 == 0) goto L_0x1516;
    L_0x08b5:
        r0 = r20;
        r7 = r0.mgA;
        r8 = 8;
        r7.setVisibility(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x08c3:
        r0 = r20;
        r7 = r0.tZN;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x0821;
    L_0x08ce:
        r0 = r20;
        r7 = r0.tZT;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x0848;
    L_0x08d9:
        r8 = r7.isRecycled();
        if (r8 == 0) goto L_0x08e9;
    L_0x08df:
        r0 = r20;
        r7 = r0.tZI;
        r8 = com.tencent.mm.R.k.app_attach_file_icon_webpage;
        r7.setImageResource(r8);
        goto L_0x0898;
    L_0x08e9:
        r0 = r20;
        r8 = r0.tZI;
        r8.setImageBitmap(r7);
        goto L_0x0898;
    L_0x08f1:
        r0 = r20;
        r7 = r0.mgA;
        if (r7 == 0) goto L_0x1516;
    L_0x08f7:
        r0 = r20;
        r7 = r0.mgA;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r28;
        r7 = r0.field_status;
        r8 = 2;
        if (r7 < r8) goto L_0x1516;
    L_0x0906:
        r0 = r20;
        r7 = r0.mgA;
        r8 = 8;
        r7.setVisibility(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x0914:
        r7 = com.tencent.mm.plugin.appbrand.n.c.class;
        r7 = com.tencent.mm.kernel.g.l(r7);
        r7 = (com.tencent.mm.plugin.appbrand.n.c) r7;
        r0 = r21;
        r8 = r0.dyS;
        r9 = r7.rR(r8);
        r0 = r21;
        r7 = r0.dyU;
        switch(r7) {
            case 1: goto L_0x0a2f;
            case 2: goto L_0x095b;
            case 3: goto L_0x095b;
            default: goto L_0x092b;
        };
    L_0x092b:
        r23 = 1;
        r8 = r23;
    L_0x092f:
        if (r8 != 0) goto L_0x151b;
    L_0x0931:
        r7 = cxN();
        if (r7 == 0) goto L_0x0aaf;
    L_0x0937:
        r7 = com.tencent.mm.ui.chatting.b.b.g.class;
        r0 = r27;
        r7 = r0.O(r7);
        r7 = (com.tencent.mm.ui.chatting.b.b.g) r7;
        r0 = r20;
        r1 = r28;
        a(r0, r7, r1);
        r0 = r20;
        r7 = r0.mgA;
        if (r7 == 0) goto L_0x151b;
    L_0x094e:
        r0 = r20;
        r7 = r0.mgA;
        r9 = 8;
        r7.setVisibility(r9);
        r7 = r8;
        r12 = r6;
        goto L_0x0286;
    L_0x095b:
        if (r9 == 0) goto L_0x0a0e;
    L_0x095d:
        r7 = r9.field_nickname;
        r8 = r7;
    L_0x0960:
        if (r9 == 0) goto L_0x0a15;
    L_0x0962:
        r7 = r9.field_brandIconURL;
    L_0x0964:
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
            case 1: goto L_0x0a1b;
            case 2: goto L_0x0a25;
            default: goto L_0x09ab;
        };
    L_0x09ab:
        r0 = r20;
        r8 = r0.uap;
        r9 = com.tencent.mm.R.l.app_brand_entrance;
        r8.setText(r9);
    L_0x09b4:
        r8 = com.tencent.mm.ak.o.Pj();
        r0 = r20;
        r9 = r0.uan;
        r0 = r24;
        r10 = r0.tXU;
        r8.a(r7, r9, r10);
        r7 = com.tencent.mm.ak.o.Pf();
        r0 = r28;
        r8 = r0.field_imgPath;
        r9 = 0;
        r10 = 1;
        r7 = r7.d(r8, r9, r10);
        r0 = r20;
        r8 = r0.uar;
        r9 = 0;
        r8.setImageBitmap(r9);
        r8 = com.tencent.mm.modelappbrand.b.b.Ka();
        r9 = new com.tencent.mm.ui.chatting.viewitems.c$e$2;
        r0 = r24;
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
        r8 = r23;
        goto L_0x092f;
    L_0x0a0e:
        r0 = r21;
        r7 = r0.bZH;
        r8 = r7;
        goto L_0x0960;
    L_0x0a15:
        r0 = r21;
        r7 = r0.dzb;
        goto L_0x0964;
    L_0x0a1b:
        r0 = r20;
        r8 = r0.uap;
        r9 = com.tencent.mm.R.l.app_brand_share_wxa_testing_tag;
        r8.setText(r9);
        goto L_0x09b4;
    L_0x0a25:
        r0 = r20;
        r8 = r0.uap;
        r9 = com.tencent.mm.R.l.app_brand_share_wxa_preview_tag;
        r8.setText(r9);
        goto L_0x09b4;
    L_0x0a2f:
        if (r9 == 0) goto L_0x0a92;
    L_0x0a31:
        r7 = r9.field_nickname;
        r8 = r7;
    L_0x0a34:
        if (r9 == 0) goto L_0x0a98;
    L_0x0a36:
        r7 = r9.field_brandIconURL;
    L_0x0a38:
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
        if (r8 == 0) goto L_0x0a9a;
    L_0x0a5f:
        r7 = com.tencent.mm.ak.o.Pf();
        r0 = r28;
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
        r8 = r23;
        goto L_0x092f;
    L_0x0a92:
        r0 = r21;
        r7 = r0.title;
        r8 = r7;
        goto L_0x0a34;
    L_0x0a98:
        r7 = 0;
        goto L_0x0a38;
    L_0x0a9a:
        r8 = com.tencent.mm.modelappbrand.b.b.Ka();
        r0 = r20;
        r9 = r0.uak;
        r10 = com.tencent.mm.modelappbrand.b.a.JZ();
        r11 = com.tencent.mm.modelappbrand.b.f.dGr;
        r8.a(r9, r7, r10, r11);
        r8 = r23;
        goto L_0x092f;
    L_0x0aaf:
        r0 = r20;
        r7 = r0.mgA;
        if (r7 == 0) goto L_0x151b;
    L_0x0ab5:
        r0 = r20;
        r7 = r0.mgA;
        r9 = 0;
        r7.setVisibility(r9);
        r0 = r28;
        r7 = r0.field_status;
        r9 = 2;
        if (r7 < r9) goto L_0x151b;
    L_0x0ac4:
        r0 = r20;
        r7 = r0.mgA;
        r9 = 8;
        r7.setVisibility(r9);
        r7 = r8;
        r12 = r6;
        goto L_0x0286;
    L_0x0ad1:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.title;
        if (r7 == 0) goto L_0x0b58;
    L_0x0ae0:
        r0 = r21;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x0b58;
    L_0x0aea:
        r0 = r20;
        r7 = r0.tZN;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZN;
        r0 = r21;
        r8 = r0.title;
        r7.setText(r8);
    L_0x0afd:
        r0 = r20;
        r7 = r0.eCn;
        r8 = 3;
        r7.setMaxLines(r8);
        r0 = r20;
        r7 = r0.tZO;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZT;
        r8 = 8;
        r7.setVisibility(r8);
        if (r22 == 0) goto L_0x0b3e;
    L_0x0b18:
        r0 = r21;
        r7 = r0.appId;
        r8 = 1;
        r0 = r27;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = com.tencent.mm.bp.a.getDensity(r9);
        r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
        if (r7 == 0) goto L_0x0b35;
    L_0x0b2f:
        r8 = r7.isRecycled();
        if (r8 == 0) goto L_0x0b62;
    L_0x0b35:
        r0 = r20;
        r7 = r0.tZI;
        r8 = com.tencent.mm.R.k.app_attach_file_icon_webpage;
        r7.setImageResource(r8);
    L_0x0b3e:
        r7 = cxN();
        if (r7 == 0) goto L_0x0b6a;
    L_0x0b44:
        r0 = r20;
        r7 = r0.mgA;
        if (r7 == 0) goto L_0x1516;
    L_0x0b4a:
        r0 = r20;
        r7 = r0.mgA;
        r8 = 8;
        r7.setVisibility(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x0b58:
        r0 = r20;
        r7 = r0.tZN;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x0afd;
    L_0x0b62:
        r0 = r20;
        r8 = r0.tZI;
        r8.setImageBitmap(r7);
        goto L_0x0b3e;
    L_0x0b6a:
        r0 = r20;
        r7 = r0.mgA;
        if (r7 == 0) goto L_0x1516;
    L_0x0b70:
        r0 = r20;
        r7 = r0.mgA;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r28;
        r7 = r0.field_status;
        r8 = 2;
        if (r7 < r8) goto L_0x1516;
    L_0x0b7f:
        r0 = r20;
        r7 = r0.mgA;
        r8 = 8;
        r7.setVisibility(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x0b8d:
        r0 = r20;
        r7 = r0.tZN;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.dwR;
        r8 = 1;
        if (r7 != r8) goto L_0x0c10;
    L_0x0b9c:
        r0 = r20;
        r7 = r0.tZN;
        r8 = com.tencent.mm.R.l.scan_product_appmsg_top_title_book;
        r7.setText(r8);
    L_0x0ba5:
        r0 = r21;
        r7 = r0.title;
        if (r7 == 0) goto L_0x0bc8;
    L_0x0bab:
        r0 = r21;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x0bc8;
    L_0x0bb5:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.eCm;
        r0 = r21;
        r8 = r0.title;
        r7.setText(r8);
    L_0x0bc8:
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
        if (r22 == 0) goto L_0x1516;
    L_0x0be3:
        r7 = com.tencent.mm.ak.o.Pf();
        r0 = r28;
        r8 = r0.field_imgPath;
        r0 = r27;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = com.tencent.mm.bp.a.getDensity(r9);
        r10 = 0;
        r7 = r7.b(r8, r9, r10);
        if (r7 == 0) goto L_0x0c3e;
    L_0x0bfe:
        r8 = r7.isRecycled();
        if (r8 != 0) goto L_0x0c3e;
    L_0x0c04:
        r0 = r20;
        r8 = r0.tZI;
        r8.setImageBitmap(r7);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x0c10:
        r0 = r21;
        r7 = r0.dwR;
        r8 = 2;
        if (r7 != r8) goto L_0x0c21;
    L_0x0c17:
        r0 = r20;
        r7 = r0.tZN;
        r8 = com.tencent.mm.R.l.scan_product_appmsg_top_title_movie;
        r7.setText(r8);
        goto L_0x0ba5;
    L_0x0c21:
        r0 = r21;
        r7 = r0.dwR;
        r8 = 3;
        if (r7 != r8) goto L_0x0c33;
    L_0x0c28:
        r0 = r20;
        r7 = r0.tZN;
        r8 = com.tencent.mm.R.l.scan_product_appmsg_top_title_cd;
        r7.setText(r8);
        goto L_0x0ba5;
    L_0x0c33:
        r0 = r20;
        r7 = r0.tZN;
        r8 = com.tencent.mm.R.l.scan_product_appmsg_top_title_product;
        r7.setText(r8);
        goto L_0x0ba5;
    L_0x0c3e:
        r0 = r20;
        r7 = r0.tZI;
        r8 = com.tencent.mm.R.k.app_attach_file_icon_webpage;
        r7.setImageResource(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x0c4c:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.eCm;
        r0 = r21;
        r8 = r0.title;
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
        if (r22 == 0) goto L_0x1516;
    L_0x0c8b:
        r7 = com.tencent.mm.ak.o.Pf();
        r0 = r28;
        r8 = r0.field_imgPath;
        r0 = r27;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = com.tencent.mm.bp.a.getDensity(r9);
        r10 = 0;
        r7 = r7.b(r8, r9, r10);
        if (r7 == 0) goto L_0x0cb8;
    L_0x0ca6:
        r8 = r7.isRecycled();
        if (r8 != 0) goto L_0x0cb8;
    L_0x0cac:
        r0 = r20;
        r8 = r0.tZI;
        r8.setImageBitmap(r7);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x0cb8:
        r0 = r20;
        r7 = r0.tZI;
        r8 = com.tencent.mm.R.k.app_attach_file_icon_webpage;
        r7.setImageResource(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x0cc6:
        r0 = r21;
        r7 = r0.title;
        if (r7 == 0) goto L_0x0cf2;
    L_0x0ccc:
        r0 = r21;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x0cf2;
    L_0x0cd6:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.eCm;
        r0 = r21;
        r8 = r0.title;
        r7.setText(r8);
        r0 = r20;
        r7 = r0.tZN;
        r8 = 8;
        r7.setVisibility(r8);
    L_0x0cf2:
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
        if (r22 == 0) goto L_0x1516;
    L_0x0d0d:
        r7 = com.tencent.mm.ak.o.Pf();
        r0 = r28;
        r8 = r0.field_imgPath;
        r0 = r27;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = com.tencent.mm.bp.a.getDensity(r9);
        r10 = 0;
        r7 = r7.b(r8, r9, r10);
        if (r7 == 0) goto L_0x0d3a;
    L_0x0d28:
        r8 = r7.isRecycled();
        if (r8 != 0) goto L_0x0d3a;
    L_0x0d2e:
        r0 = r20;
        r8 = r0.tZI;
        r8.setImageBitmap(r7);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x0d3a:
        r0 = r20;
        r7 = r0.tZI;
        r8 = com.tencent.mm.R.k.app_attach_file_icon_webpage;
        r7.setImageResource(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x0d48:
        r0 = r21;
        r7 = r0.title;
        if (r7 == 0) goto L_0x0db7;
    L_0x0d4e:
        r0 = r21;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x0db7;
    L_0x0d58:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 0;
        r7.setVisibility(r8);
    L_0x0d60:
        r0 = r20;
        r7 = r0.eCn;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZN;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZO;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZT;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.eCn;
        r8 = 2;
        r7.setMaxLines(r8);
        if (r22 == 0) goto L_0x1516;
    L_0x0d8c:
        r0 = r21;
        r7 = r0.appId;
        r8 = 1;
        r0 = r27;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = com.tencent.mm.bp.a.getDensity(r9);
        r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
        if (r7 == 0) goto L_0x0da9;
    L_0x0da3:
        r8 = r7.isRecycled();
        if (r8 == 0) goto L_0x0dc1;
    L_0x0da9:
        r0 = r20;
        r7 = r0.tZI;
        r8 = com.tencent.mm.R.k.app_attach_file_icon_webpage;
        r7.setImageResource(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x0db7:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x0d60;
    L_0x0dc1:
        r0 = r20;
        r8 = r0.tZI;
        r8.setImageBitmap(r7);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x0dcd:
        r0 = r21;
        r6 = r0.title;
        if (r6 == 0) goto L_0x0e85;
    L_0x0dd3:
        r0 = r21;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0e85;
    L_0x0ddd:
        r0 = r20;
        r6 = r0.eCm;
        r7 = 0;
        r6.setVisibility(r7);
    L_0x0de5:
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
        if (r22 == 0) goto L_0x0e3b;
    L_0x0e11:
        r6 = com.tencent.mm.ak.o.Pf();
        r0 = r28;
        r7 = r0.field_imgPath;
        r0 = r27;
        r8 = r0.tTq;
        r8 = r8.getContext();
        r8 = com.tencent.mm.bp.a.getDensity(r8);
        r9 = 0;
        r6 = r6.b(r7, r8, r9);
        if (r6 == 0) goto L_0x0e32;
    L_0x0e2c:
        r7 = r6.isRecycled();
        if (r7 == 0) goto L_0x0e90;
    L_0x0e32:
        r0 = r20;
        r6 = r0.tZI;
        r7 = com.tencent.mm.R.k.app_attach_file_icon_webpage;
        r6.setImageResource(r7);
    L_0x0e3b:
        r6 = new com.tencent.mm.ui.chatting.viewitems.au;
        r8 = 0;
        r10 = "";
        r11 = 0;
        r12 = r27.cuz();
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
        r7 = r28;
        r9 = r26;
        r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
        r0 = r20;
        r7 = r0.uac;
        r7.setTag(r6);
        r0 = r20;
        r7 = r0.uac;
        r0 = r24;
        r1 = r27;
        r8 = r0.h(r1);
        r7.setOnClickListener(r8);
        r15 = 1;
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x0e85:
        r0 = r20;
        r6 = r0.eCm;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0de5;
    L_0x0e90:
        r0 = r20;
        r7 = r0.tZI;
        r7.setImageBitmap(r6);
        goto L_0x0e3b;
    L_0x0e98:
        r0 = r21;
        r6 = r0.title;
        if (r6 == 0) goto L_0x0f5f;
    L_0x0e9e:
        r0 = r21;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0f5f;
    L_0x0ea8:
        r0 = r20;
        r6 = r0.eCm;
        r7 = 0;
        r6.setVisibility(r7);
    L_0x0eb0:
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
        if (r22 == 0) goto L_0x0f06;
    L_0x0edc:
        r6 = com.tencent.mm.ak.o.Pf();
        r0 = r28;
        r7 = r0.field_imgPath;
        r0 = r27;
        r8 = r0.tTq;
        r8 = r8.getContext();
        r8 = com.tencent.mm.bp.a.getDensity(r8);
        r9 = 0;
        r6 = r6.b(r7, r8, r9);
        if (r6 == 0) goto L_0x0efd;
    L_0x0ef7:
        r7 = r6.isRecycled();
        if (r7 == 0) goto L_0x0f6a;
    L_0x0efd:
        r0 = r20;
        r6 = r0.tZI;
        r7 = com.tencent.mm.R.k.app_attach_file_icon_webpage;
        r6.setImageResource(r7);
    L_0x0f06:
        r6 = new com.tencent.mm.ui.chatting.viewitems.au;
        r9 = "";
        r10 = r27.cuz();
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
        r7 = r28;
        r8 = r26;
        r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
        r0 = r20;
        r7 = r0.uac;
        r7.setTag(r6);
        r0 = r20;
        r7 = r0.uac;
        r0 = r24;
        r8 = r0.uay;
        if (r8 != 0) goto L_0x0f52;
    L_0x0f47:
        r8 = new com.tencent.mm.ui.chatting.t$h;
        r0 = r27;
        r8.<init>(r0);
        r0 = r24;
        r0.uay = r8;
    L_0x0f52:
        r0 = r24;
        r8 = r0.uay;
        r7.setOnClickListener(r8);
        r15 = 1;
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x0f5f:
        r0 = r20;
        r6 = r0.eCm;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0eb0;
    L_0x0f6a:
        r0 = r20;
        r7 = r0.tZI;
        r7.setImageBitmap(r6);
        goto L_0x0f06;
    L_0x0f72:
        r0 = r21;
        r6 = r0.title;
        if (r6 == 0) goto L_0x104f;
    L_0x0f78:
        r0 = r21;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x104f;
    L_0x0f82:
        r0 = r20;
        r6 = r0.eCm;
        r7 = 0;
        r6.setVisibility(r7);
    L_0x0f8a:
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
        if (r22 == 0) goto L_0x0fcf;
    L_0x0fb6:
        r0 = r28;
        r6 = r0.field_imgPath;
        r6 = com.tencent.mm.sdk.platformtools.bi.oW(r6);
        if (r6 == 0) goto L_0x105a;
    L_0x0fc0:
        r6 = com.tencent.mm.ak.o.Pj();
        r0 = r21;
        r7 = r0.thumburl;
        r0 = r20;
        r8 = r0.tZI;
        r6.a(r7, r8);
    L_0x0fcf:
        r12 = new com.tencent.mm.ui.chatting.viewitems.au;
        r12.<init>();
        r0 = r28;
        r12.bXQ = r0;
        r6 = 0;
        r12.tGg = r6;
        r0 = r26;
        r12.position = r0;
        r6 = 0;
        r12.ufx = r6;
        r6 = r27.cuz();
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
        if (r6 != r7) goto L_0x108f;
    L_0x1002:
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
        r0 = r24;
        r7 = r0.uaz;
        if (r7 != 0) goto L_0x103b;
    L_0x1030:
        r7 = new com.tencent.mm.ui.chatting.t$k;
        r0 = r27;
        r7.<init>(r0);
        r0 = r24;
        r0.uaz = r7;
    L_0x103b:
        r0 = r24;
        r7 = r0.uaz;
        r6.setOnClickListener(r7);
        r6 = 1;
    L_0x1043:
        r0 = r20;
        r7 = r0.uac;
        r7.setTag(r12);
        r7 = r23;
        r15 = r6;
        goto L_0x0286;
    L_0x104f:
        r0 = r20;
        r6 = r0.eCm;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0f8a;
    L_0x105a:
        r6 = com.tencent.mm.ak.o.Pf();
        r0 = r28;
        r7 = r0.field_imgPath;
        r0 = r27;
        r8 = r0.tTq;
        r8 = r8.getContext();
        r8 = com.tencent.mm.bp.a.getDensity(r8);
        r9 = 0;
        r6 = r6.b(r7, r8, r9);
        if (r6 == 0) goto L_0x107b;
    L_0x1075:
        r7 = r6.isRecycled();
        if (r7 == 0) goto L_0x1086;
    L_0x107b:
        r0 = r20;
        r6 = r0.tZI;
        r7 = com.tencent.mm.R.k.app_attach_file_icon_webpage;
        r6.setImageResource(r7);
        goto L_0x0fcf;
    L_0x1086:
        r0 = r20;
        r7 = r0.tZI;
        r7.setImageBitmap(r6);
        goto L_0x0fcf;
    L_0x108f:
        r0 = r21;
        r6 = r0.type;
        r7 = 27;
        if (r6 != r7) goto L_0x10da;
    L_0x1097:
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
        r0 = r24;
        r7 = r0.uaA;
        if (r7 != 0) goto L_0x10d0;
    L_0x10c5:
        r7 = new com.tencent.mm.ui.chatting.t$i;
        r0 = r27;
        r7.<init>(r0);
        r0 = r24;
        r0.uaA = r7;
    L_0x10d0:
        r0 = r24;
        r7 = r0.uaA;
        r6.setOnClickListener(r7);
        r6 = 1;
        goto L_0x1043;
    L_0x10da:
        r6 = "MicroMsg.ChattingItemAppMsgTo";
        r7 = "unknow view type";
        com.tencent.mm.sdk.platformtools.x.i(r6, r7);
        r6 = r15;
        goto L_0x1043;
    L_0x10e6:
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
        if (r7 == 0) goto L_0x1169;
    L_0x110a:
        r0 = r21;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x1169;
    L_0x1114:
        r0 = r20;
        r7 = r0.tZN;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZN;
        r0 = r21;
        r8 = r0.title;
        r7.setText(r8);
    L_0x1127:
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
        if (r22 == 0) goto L_0x1516;
    L_0x1142:
        r7 = com.tencent.mm.ak.o.Pf();
        r0 = r28;
        r8 = r0.field_imgPath;
        r0 = r27;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = com.tencent.mm.bp.a.getDensity(r9);
        r10 = 0;
        r7 = r7.b(r8, r9, r10);
        if (r7 == 0) goto L_0x1173;
    L_0x115d:
        r0 = r20;
        r8 = r0.tZI;
        r8.setImageBitmap(r7);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x1169:
        r0 = r20;
        r7 = r0.tZN;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x1127;
    L_0x1173:
        r0 = r20;
        r7 = r0.tZI;
        r8 = com.tencent.mm.R.k.app_attach_file_icon_webpage;
        r7.setImageResource(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x1181:
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
        if (r7 == 0) goto L_0x121e;
    L_0x1198:
        r0 = r21;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x121e;
    L_0x11a2:
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
        r10 = (int) r10;
        r8 = com.tencent.mm.pluginsdk.ui.d.j.a(r8, r9, r10);
        r7.setText(r8);
    L_0x11c2:
        r0 = r20;
        r7 = r0.eCn;
        r8 = 3;
        r7.setMaxLines(r8);
        r0 = r20;
        r7 = r0.tZO;
        r8 = 4;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.tZT;
        r8 = 8;
        r7.setVisibility(r8);
        if (r22 == 0) goto L_0x11e6;
    L_0x11dd:
        r0 = r20;
        r7 = r0.tZI;
        r8 = 8;
        r7.setVisibility(r8);
    L_0x11e6:
        r0 = r27;
        r1 = r20;
        r2 = r21;
        r3 = r28;
        r4 = r22;
        com.tencent.mm.ui.chatting.viewitems.c.c.a(r0, r1, r2, r3, r4);
        r7 = cxN();
        if (r7 == 0) goto L_0x1246;
    L_0x11f9:
        r7 = com.tencent.mm.ui.chatting.b.b.g.class;
        r0 = r27;
        r7 = r0.O(r7);
        r7 = (com.tencent.mm.ui.chatting.b.b.g) r7;
        r0 = r20;
        r1 = r28;
        a(r0, r7, r1);
        r0 = r20;
        r7 = r0.mgA;
        if (r7 == 0) goto L_0x1516;
    L_0x1210:
        r0 = r20;
        r7 = r0.mgA;
        r8 = 8;
        r7.setVisibility(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x121e:
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
        r10 = (int) r10;
        r8 = com.tencent.mm.pluginsdk.ui.d.j.a(r8, r9, r10);
        r7.setText(r8);
        goto L_0x11c2;
    L_0x1246:
        r0 = r20;
        r7 = r0.mgA;
        if (r7 == 0) goto L_0x1516;
    L_0x124c:
        r0 = r20;
        r7 = r0.mgA;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r28;
        r7 = r0.field_status;
        r8 = 2;
        if (r7 < r8) goto L_0x1516;
    L_0x125b:
        r0 = r20;
        r7 = r0.mgA;
        r8 = 8;
        r7.setVisibility(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x1269:
        r0 = r27;
        r1 = r20;
        r2 = r21;
        r3 = r22;
        com.tencent.mm.ui.chatting.viewitems.c.c.a(r0, r1, r2, r3);
        r7 = cxN();
        if (r7 == 0) goto L_0x129f;
    L_0x127a:
        r7 = com.tencent.mm.ui.chatting.b.b.g.class;
        r0 = r27;
        r7 = r0.O(r7);
        r7 = (com.tencent.mm.ui.chatting.b.b.g) r7;
        r0 = r20;
        r1 = r28;
        a(r0, r7, r1);
        r0 = r20;
        r7 = r0.mgA;
        if (r7 == 0) goto L_0x1516;
    L_0x1291:
        r0 = r20;
        r7 = r0.mgA;
        r8 = 8;
        r7.setVisibility(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x129f:
        r0 = r20;
        r7 = r0.mgA;
        if (r7 == 0) goto L_0x1516;
    L_0x12a5:
        r0 = r20;
        r7 = r0.mgA;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r28;
        r7 = r0.field_status;
        r8 = 2;
        if (r7 < r8) goto L_0x1516;
    L_0x12b4:
        r0 = r20;
        r7 = r0.mgA;
        r8 = 8;
        r7.setVisibility(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x12c2:
        r0 = r21;
        r7 = r0.title;
        if (r7 == 0) goto L_0x1437;
    L_0x12c8:
        r0 = r21;
        r7 = r0.title;
        r7 = r7.length();
        if (r7 <= 0) goto L_0x1437;
    L_0x12d2:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r21;
        r7 = r0.dxO;
        r7 = com.tencent.mm.sdk.platformtools.bi.oW(r7);
        if (r7 != 0) goto L_0x141c;
    L_0x12e4:
        r0 = r21;
        r7 = r0.dxO;
        r7 = com.tencent.mm.sdk.platformtools.bi.oW(r7);
        if (r7 != 0) goto L_0x1401;
    L_0x12ee:
        r0 = r20;
        r7 = r0.eCm;
        r0 = r21;
        r8 = r0.dxO;
        r0 = r27;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = r9.getResources();
        r10 = com.tencent.mm.R.e.black;
        r9 = r9.getColor(r10);
        r8 = com.tencent.mm.sdk.platformtools.bi.bc(r8, r9);
        r7.setTextColor(r8);
    L_0x130f:
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
        if (r7 != 0) goto L_0x1442;
    L_0x1329:
        r0 = r20;
        r7 = r0.eCn;
        r0 = r21;
        r8 = r0.dxP;
        r0 = r27;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = r9.getResources();
        r10 = com.tencent.mm.R.e.grey_background_text_color;
        r9 = r9.getColor(r10);
        r8 = com.tencent.mm.sdk.platformtools.bi.bc(r8, r9);
        r7.setTextColor(r8);
    L_0x134a:
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
        if (r7 != 0) goto L_0x145d;
    L_0x137e:
        r0 = r20;
        r7 = r0.jet;
        r0 = r21;
        r8 = r0.dxK;
        r7.setText(r8);
    L_0x1389:
        r0 = r24;
        r7 = r0.qUB;
        if (r7 == 0) goto L_0x1483;
    L_0x138f:
        r7 = com.tencent.mm.ak.o.Pf();
        r0 = r28;
        r8 = r0.field_imgPath;
        r0 = r27;
        r9 = r0.tTq;
        r9 = r9.getContext();
        r9 = com.tencent.mm.bp.a.getDensity(r9);
        r10 = 0;
        r7 = r7.a(r8, r9, r10);
        if (r7 == 0) goto L_0x13c3;
    L_0x13aa:
        r8 = r7.isRecycled();
        if (r8 != 0) goto L_0x13c3;
    L_0x13b0:
        r8 = 0;
        r9 = r7.getWidth();
        r9 = r9 / 2;
        r9 = (float) r9;
        r8 = com.tencent.mm.sdk.platformtools.c.a(r7, r8, r9);
        r0 = r20;
        r9 = r0.tZI;
        r9.setImageBitmap(r8);
    L_0x13c3:
        r0 = r21;
        r8 = r0.dxN;
        r8 = com.tencent.mm.sdk.platformtools.bi.oW(r8);
        if (r8 != 0) goto L_0x1468;
    L_0x13cd:
        r7 = com.tencent.mm.ak.o.Pj();
        r0 = r21;
        r8 = r0.dxN;
        r9 = new android.widget.ImageView;
        r0 = r27;
        r10 = r0.tTq;
        r10 = r10.getContext();
        r9.<init>(r10);
        r10 = new com.tencent.mm.ak.a.a.c$a;
        r10.<init>();
        r11 = 1;
        r10.dXy = r11;
        r10 = r10.Pt();
        r11 = new com.tencent.mm.ui.chatting.viewitems.c$e$3;
        r0 = r24;
        r1 = r20;
        r2 = r27;
        r11.<init>(r0, r1, r2);
        r7.a(r8, r9, r10, r11);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x1401:
        r0 = r20;
        r7 = r0.eCm;
        r0 = r27;
        r8 = r0.tTq;
        r8 = r8.getContext();
        r8 = r8.getResources();
        r9 = com.tencent.mm.R.e.black;
        r8 = r8.getColor(r9);
        r7.setTextColor(r8);
        goto L_0x130f;
    L_0x141c:
        r0 = r20;
        r7 = r0.eCm;
        r0 = r27;
        r8 = r0.tTq;
        r8 = r8.getContext();
        r8 = r8.getResources();
        r9 = com.tencent.mm.R.e.black;
        r8 = r8.getColor(r9);
        r7.setTextColor(r8);
        goto L_0x130f;
    L_0x1437:
        r0 = r20;
        r7 = r0.eCm;
        r8 = 8;
        r7.setVisibility(r8);
        goto L_0x130f;
    L_0x1442:
        r0 = r20;
        r7 = r0.eCn;
        r0 = r27;
        r8 = r0.tTq;
        r8 = r8.getContext();
        r8 = r8.getResources();
        r9 = com.tencent.mm.R.e.grey_background_text_color;
        r8 = r8.getColor(r9);
        r7.setTextColor(r8);
        goto L_0x134a;
    L_0x145d:
        r0 = r20;
        r7 = r0.jet;
        r8 = com.tencent.mm.R.l.chatting_item_coupon_card;
        r7.setText(r8);
        goto L_0x1389;
    L_0x1468:
        r0 = r20;
        r8 = r0.uad;
        r8 = r8.getViewTreeObserver();
        r9 = new com.tencent.mm.ui.chatting.viewitems.c$e$4;
        r0 = r24;
        r1 = r20;
        r2 = r27;
        r9.<init>(r0, r1, r2, r7);
        r8.addOnPreDrawListener(r9);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x1483:
        r0 = r20;
        r7 = r0.tZI;
        r0 = r27;
        r8 = r0.tTq;
        r8 = r8.getMMResources();
        r9 = com.tencent.mm.R.g.nosdcard_app;
        r8 = android.graphics.BitmapFactory.decodeResource(r8, r9);
        r7.setImageBitmap(r8);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x149d:
        r7 = r14.dzv;
        r8 = 19;
        if (r7 != r8) goto L_0x1516;
    L_0x14a3:
        r0 = r27;
        r1 = r20;
        r2 = r21;
        r3 = r22;
        com.tencent.mm.ui.chatting.viewitems.c.c.a(r0, r1, r2, r3);
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x14b3:
        r0 = r20;
        r6 = r0.tZN;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x02b3;
    L_0x14be:
        r6 = com.tencent.mm.ak.o.Pf();
        r0 = r28;
        r7 = r0.field_imgPath;
        r0 = r27;
        r8 = r0.tTq;
        r8 = r8.getContext();
        r8 = com.tencent.mm.bp.a.getDensity(r8);
        r9 = 0;
        r6 = r6.b(r7, r8, r9);
        if (r6 == 0) goto L_0x14df;
    L_0x14d9:
        r7 = r6.isRecycled();
        if (r7 == 0) goto L_0x14f8;
    L_0x14df:
        r6 = com.tencent.mm.ak.o.Pf();
        r0 = r28;
        r7 = r0.field_imgPath;
        r0 = r27;
        r8 = r0.tTq;
        r8 = r8.getContext();
        r8 = com.tencent.mm.bp.a.getDensity(r8);
        r9 = 0;
        r6 = r6.a(r7, r8, r9);
    L_0x14f8:
        if (r6 == 0) goto L_0x150a;
    L_0x14fa:
        r7 = r6.isRecycled();
        if (r7 != 0) goto L_0x150a;
    L_0x1500:
        r0 = r20;
        r7 = r0.tZI;
        r7.setImageBitmap(r6);
        r6 = r12;
        goto L_0x0313;
    L_0x150a:
        r0 = r20;
        r6 = r0.tZI;
        r7 = com.tencent.mm.R.g.appshareimage_icon;
        r6.setImageResource(r7);
    L_0x1513:
        r6 = r12;
        goto L_0x0313;
    L_0x1516:
        r7 = r23;
        r12 = r6;
        goto L_0x0286;
    L_0x151b:
        r7 = r8;
        r12 = r6;
        goto L_0x0286;
    L_0x151f:
        r14 = r6;
        r21 = r7;
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.c$e.a(com.tencent.mm.ui.chatting.viewitems.b$a, int, com.tencent.mm.ui.chatting.c.a, com.tencent.mm.storage.bd, java.lang.String):void");
    }

    private static void a(c.c cVar, g gVar, bd bdVar) {
        if (bdVar.field_status == 2 && a(gVar, bdVar.field_msgId)) {
            if (cVar.uai != null) {
                cVar.uai.setVisibility(0);
            }
        } else if (cVar.uai != null) {
            cVar.uai.setVisibility(8);
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        int i = ((au) view.getTag()).position;
        if (bdVar.field_content == null) {
            return true;
        }
        g$a gp = g$a.gp(com.tencent.mm.model.bd.b(this.tKy.cwr(), bdVar.field_content, bdVar.field_isSend));
        if (gp == null) {
            return true;
        }
        boolean MH;
        f bl = com.tencent.mm.pluginsdk.model.app.g.bl(gp.appId, false);
        if (com.tencent.mm.pluginsdk.model.app.g.h(bl) && !j.au(bdVar)) {
            contextMenu.add(i, 111, 0, this.tKy.tTq.getMMResources().getString(R.l.retransmit));
        }
        if ((bdVar.field_status == 2 || bdVar.cGF == 1) && a(bdVar, this.tKy) && aaA(bdVar.field_talker)) {
            contextMenu.add(i, TbsListener$ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED, 0, view.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
        }
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
                if (gp.dxG != 2) {
                    contextMenu.clear();
                }
                contextMenu.add(i, 100, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
                return false;
            case 34:
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
        if (djVar.bLg.bKE || b.a(this.tKy.tTq.getContext(), gp)) {
            contextMenu.add(i, 129, 0, view.getContext().getString(R.l.chatting_long_click_menu_open));
        }
        if (!this.tKy.cws()) {
            contextMenu.add(i, 100, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        g$a g_a;
        String str;
        switch (menuItem.getItemId()) {
            case 100:
                String str2 = bdVar.field_content;
                g_a = null;
                if (str2 != null) {
                    g_a = g$a.gp(str2);
                }
                if (g_a != null && 19 == g_a.type) {
                    mw mwVar = new mw();
                    mwVar.bXL.type = 3;
                    mwVar.bXL.bJC = bdVar.field_msgId;
                    com.tencent.mm.sdk.b.a.sFg.m(mwVar);
                }
                com.tencent.mm.model.bd.aU(bdVar.field_msgId);
                if (g_a != null) {
                    f bl = com.tencent.mm.pluginsdk.model.app.g.bl(g_a.appId, false);
                    if (bl != null && bl.aaq()) {
                        a(aVar, g_a, bdVar, bl);
                    }
                }
                if (g_a.type == 3) {
                    c.f(bdVar, aVar.getTalkerUserName());
                    break;
                }
                break;
            case 103:
                str = bdVar.field_content;
                if (str != null) {
                    g_a = g$a.gp(str);
                    if (g_a != null) {
                        switch (g_a.type) {
                            case 16:
                                hz hzVar = new hz();
                                hzVar.bRv.bRw = g_a.bRw;
                                hzVar.bRv.bIZ = bdVar.field_msgId;
                                hzVar.bRv.bRx = bdVar.field_talker;
                                com.tencent.mm.sdk.b.a.sFg.m(hzVar);
                                break;
                        }
                    }
                }
                break;
            case 111:
                b.a(aVar, bdVar, b(aVar, bdVar));
                break;
            case 114:
                str = bdVar.field_content;
                if (str != null) {
                    g_a = g$a.gp(str);
                    if (g_a != null) {
                        switch (g_a.type) {
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
        r16.getTag();
        r0 = r18;
        r2 = r0.field_content;
        if (r2 != 0) goto L_0x000b;
    L_0x0009:
        r2 = 0;
    L_0x000a:
        return r2;
    L_0x000b:
        r3 = com.tencent.mm.y.g$a.gp(r2);
        if (r3 != 0) goto L_0x0013;
    L_0x0011:
        r2 = 0;
        goto L_0x000a;
    L_0x0013:
        r2 = r3.appId;
        r4 = 1;
        r5 = com.tencent.mm.pluginsdk.model.app.g.bl(r2, r4);
        if (r5 == 0) goto L_0x0037;
    L_0x001c:
        r2 = r5.field_appId;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 != 0) goto L_0x0037;
    L_0x0024:
        r2 = r5.aaq();
        if (r2 == 0) goto L_0x0037;
    L_0x002a:
        r4 = com.tencent.mm.model.q.GF();
        r0 = r18;
        r6 = r0.field_msgSvrId;
        r2 = r17;
        a(r2, r3, r4, r5, r6);
    L_0x0037:
        r7 = 0;
        r2 = r3.type;
        switch(r2) {
            case 3: goto L_0x0177;
            case 4: goto L_0x0193;
            case 5: goto L_0x01e2;
            case 6: goto L_0x0095;
            case 7: goto L_0x06a9;
            case 8: goto L_0x003d;
            case 9: goto L_0x003d;
            case 10: goto L_0x06ce;
            case 11: goto L_0x003d;
            case 12: goto L_0x003d;
            case 13: goto L_0x075e;
            case 14: goto L_0x003d;
            case 15: goto L_0x003d;
            case 16: goto L_0x0796;
            case 17: goto L_0x003d;
            case 18: goto L_0x003d;
            case 19: goto L_0x07cf;
            case 20: goto L_0x0716;
            case 21: goto L_0x003d;
            case 22: goto L_0x003d;
            case 23: goto L_0x003d;
            case 24: goto L_0x0801;
            case 25: goto L_0x003d;
            case 26: goto L_0x003d;
            case 27: goto L_0x003d;
            case 28: goto L_0x003d;
            case 29: goto L_0x003d;
            case 30: goto L_0x003d;
            case 31: goto L_0x003d;
            case 32: goto L_0x003d;
            case 33: goto L_0x0484;
            case 34: goto L_0x0835;
            case 35: goto L_0x003d;
            case 36: goto L_0x05d8;
            default: goto L_0x003d;
        };
    L_0x003d:
        r2 = r3.url;
        if (r2 == 0) goto L_0x0ad4;
    L_0x0041:
        r2 = r3.url;
        r4 = "";
        r2 = r2.equals(r4);
        if (r2 != 0) goto L_0x0ad4;
    L_0x004c:
        r2 = r3.canvasPageXml;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 != 0) goto L_0x0888;
    L_0x0054:
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
        goto L_0x000a;
    L_0x0095:
        com.tencent.mm.model.au.HU();
        r2 = com.tencent.mm.model.c.isSDCardAvailable();
        if (r2 != 0) goto L_0x00ac;
    L_0x009e:
        r0 = r17;
        r2 = r0.tTq;
        r2 = r2.getContext();
        com.tencent.mm.ui.base.s.gH(r2);
        r2 = 1;
        goto L_0x000a;
    L_0x00ac:
        r2 = r3.dwp;
        r2 = com.tencent.mm.sdk.platformtools.bi.Xi(r2);
        if (r2 == 0) goto L_0x0152;
    L_0x00b4:
        r0 = r18;
        r4 = r0.field_msgId;
        r2 = r3.bGP;
        r3 = com.tencent.mm.pluginsdk.model.app.ao.asF();
        r3 = r3.SR(r2);
        if (r3 == 0) goto L_0x00ca;
    L_0x00c4:
        r6 = r3.aSc();
        if (r6 != 0) goto L_0x00d0;
    L_0x00ca:
        r2 = 0;
    L_0x00cb:
        if (r2 == 0) goto L_0x0152;
    L_0x00cd:
        r2 = 1;
        goto L_0x000a;
    L_0x00d0:
        com.tencent.mm.model.au.HU();
        r6 = com.tencent.mm.model.c.FT();
        r6 = r6.dW(r4);
        r7 = r6.cmu();
        if (r7 == 0) goto L_0x0126;
    L_0x00e1:
        r3 = "MicroMsg.ChattingItemAppMsgTo";
        r7 = "openImg:: msg is clean, attachId %s, msgId: %d, msgSvrId: %d, imgPath: %s";
        r8 = 4;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r8[r9] = r2;
        r2 = 1;
        r4 = java.lang.Long.valueOf(r4);
        r8[r2] = r4;
        r2 = 2;
        r4 = r6.field_msgSvrId;
        r4 = java.lang.Long.valueOf(r4);
        r8[r2] = r4;
        r2 = 3;
        r4 = r6.field_imgPath;
        r8[r2] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r3, r7, r8);
        r2 = new android.content.Intent;
        r2.<init>();
        r3 = r15.tKy;
        r3 = r3.tTq;
        r3 = r3.getContext();
        r4 = "com.tencent.mm.ui.chatting.ResourcesExceedUI";
        r2.setClassName(r3, r4);
        r3 = "clean_view_type";
        r4 = 1;
        r2.putExtra(r3, r4);
        r3 = r15.tKy;
        r3.startActivity(r2);
        r2 = 1;
        goto L_0x00cb;
    L_0x0126:
        r2 = new android.content.Intent;
        r6 = r15.tKy;
        r6 = r6.tTq;
        r6 = r6.getContext();
        r7 = com.tencent.mm.ui.tools.ShowImageUI.class;
        r2.<init>(r6, r7);
        r6 = "key_image_path";
        r3 = r3.field_fileFullPath;
        r2.putExtra(r6, r3);
        r3 = "key_message_id";
        r2.putExtra(r3, r4);
        r3 = "key_favorite";
        r4 = 1;
        r2.putExtra(r3, r4);
        r3 = r15.tKy;
        r3.startActivity(r2);
        r2 = 1;
        goto L_0x00cb;
    L_0x0152:
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
        goto L_0x000a;
    L_0x0177:
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
    L_0x0193:
        r0 = r17;
        r1 = r18;
        r2 = r15.a(r0, r3, r1);
        if (r2 == 0) goto L_0x01a0;
    L_0x019d:
        r2 = 1;
        goto L_0x000a;
    L_0x01a0:
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
        if (r2 != 0) goto L_0x01dc;
    L_0x01c2:
        r6 = 0;
    L_0x01c3:
        if (r2 != 0) goto L_0x01df;
    L_0x01c5:
        r7 = 0;
    L_0x01c6:
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
        goto L_0x000a;
    L_0x01dc:
        r6 = r2.versionName;
        goto L_0x01c3;
    L_0x01df:
        r7 = r2.versionCode;
        goto L_0x01c6;
    L_0x01e2:
        r2 = r3.canvasPageXml;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 != 0) goto L_0x022b;
    L_0x01ea:
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
        goto L_0x000a;
    L_0x022b:
        r2 = com.tencent.mm.plugin.websearch.api.q.class;
        r2 = r3.u(r2);
        r2 = (com.tencent.mm.plugin.websearch.api.q) r2;
        if (r2 == 0) goto L_0x02bb;
    L_0x0235:
        r4 = r2.pLr;
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r4 != 0) goto L_0x02bb;
    L_0x023d:
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
        r2 = r2.toByteArray();	 Catch:{ IOException -> 0x0ada }
        r3.putExtra(r5, r2);	 Catch:{ IOException -> 0x0ada }
    L_0x02a5:
        r0 = r17;
        r2 = r0.tTq;
        r2 = r2.getContext();
        r5 = ".ui.video.TopStoryVideoStreamUI";
        com.tencent.mm.plugin.websearch.api.p.c(r2, r5, r3);
        r0 = r18;
        com.tencent.mm.plugin.topstory.a.h.a(r4, r0);
        r2 = 1;
        goto L_0x000a;
    L_0x02bb:
        r2 = r3.url;
        if (r2 == 0) goto L_0x0464;
    L_0x02bf:
        r2 = r3.url;
        r4 = "";
        r2 = r2.equals(r4);
        if (r2 != 0) goto L_0x0464;
    L_0x02ca:
        r4 = r3.url;
        r2 = r17.cwr();
        if (r2 == 0) goto L_0x0467;
    L_0x02d2:
        r2 = "groupmessage";
    L_0x02d5:
        r2 = com.tencent.mm.pluginsdk.model.app.p.B(r4, r2);
        r4 = r3.dwn;
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
        r2 = new android.os.Bundle;
        r2.<init>();
        r7 = "key_snsad_statextstr";
        r8 = r3.bZN;
        r2.putString(r7, r8);
        r7 = r3.appId;
        if (r7 == 0) goto L_0x0336;
    L_0x030d:
        r7 = "wx751a1acca5688ba3";
        r8 = r3.appId;
        r7 = r7.equals(r8);
        if (r7 != 0) goto L_0x032e;
    L_0x0318:
        r7 = "wxfbc915ff7c30e335";
        r8 = r3.appId;
        r7 = r7.equals(r8);
        if (r7 != 0) goto L_0x032e;
    L_0x0323:
        r7 = "wx482a4001c37e2b74";
        r8 = r3.appId;
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x0336;
    L_0x032e:
        r7 = "jsapi_args_appid";
        r8 = r3.appId;
        r2.putString(r7, r8);
    L_0x0336:
        r7 = "jsapiargs";
        r6.putExtra(r7, r2);
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r2 != 0) goto L_0x046c;
    L_0x0342:
        r2 = "shortUrl";
        r6.putExtra(r2, r4);
    L_0x0348:
        r4 = "version_name";
        if (r5 != 0) goto L_0x0476;
    L_0x034d:
        r2 = 0;
    L_0x034e:
        r6.putExtra(r4, r2);
        r4 = "version_code";
        if (r5 != 0) goto L_0x047a;
    L_0x0356:
        r2 = 0;
    L_0x0357:
        r6.putExtra(r4, r2);
        r2 = r3.bZG;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 != 0) goto L_0x0372;
    L_0x0362:
        r2 = "srcUsername";
        r4 = r3.bZG;
        r6.putExtra(r2, r4);
        r2 = "srcDisplayname";
        r4 = r3.bZH;
        r6.putExtra(r2, r4);
    L_0x0372:
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
            case 1: goto L_0x0480;
            case 2: goto L_0x047e;
            case 3: goto L_0x0417;
            case 4: goto L_0x0417;
            case 5: goto L_0x0417;
            case 6: goto L_0x0482;
            case 7: goto L_0x0482;
            default: goto L_0x0417;
        };
    L_0x0417:
        r2 = 0;
    L_0x0418:
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
        if (r2 != r3) goto L_0x0453;
    L_0x0449:
        r2 = "share_report_biz_username";
        r3 = r17.getTalkerUserName();
        r6.putExtra(r2, r3);
    L_0x0453:
        r0 = r17;
        r2 = r0.tTq;
        r2 = r2.getContext();
        r3 = "webview";
        r4 = ".ui.tools.WebViewUI";
        com.tencent.mm.bg.d.b(r2, r3, r4, r6);
    L_0x0464:
        r2 = 1;
        goto L_0x000a;
    L_0x0467:
        r2 = "singlemessage";
        goto L_0x02d5;
    L_0x046c:
        r2 = "shortUrl";
        r4 = r3.url;
        r6.putExtra(r2, r4);
        goto L_0x0348;
    L_0x0476:
        r2 = r5.versionName;
        goto L_0x034e;
    L_0x047a:
        r2 = r5.versionCode;
        goto L_0x0357;
    L_0x047e:
        r2 = 2;
        goto L_0x0418;
    L_0x0480:
        r2 = 3;
        goto L_0x0418;
    L_0x0482:
        r2 = 5;
        goto L_0x0418;
    L_0x0484:
        r2 = "MicroMsg.ChattingItemAppMsgTo";
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
        if (r2 == 0) goto L_0x0509;
    L_0x04cb:
        r4 = "stat_scene";
        r2 = 10;
        r5 = r6;
    L_0x04d1:
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
            case 1: goto L_0x0524;
            case 2: goto L_0x05a6;
            case 3: goto L_0x05ce;
            default: goto L_0x0503;
        };
    L_0x0503:
        r2 = 1;
    L_0x0504:
        if (r2 != 0) goto L_0x003d;
    L_0x0506:
        r2 = 1;
        goto L_0x000a;
    L_0x0509:
        r2 = r17.cwr();
        if (r2 == 0) goto L_0x0515;
    L_0x050f:
        r4 = "stat_scene";
        r2 = 2;
        r5 = r6;
        goto L_0x04d1;
    L_0x0515:
        r4 = "stat_scene";
        r2 = com.tencent.mm.model.s.hf(r8);
        if (r2 == 0) goto L_0x0521;
    L_0x051e:
        r2 = 7;
        r5 = r6;
        goto L_0x04d1;
    L_0x0521:
        r2 = 1;
        r5 = r6;
        goto L_0x04d1;
    L_0x0524:
        r2 = new android.content.Intent;
        r2.<init>();
        r4 = "key_username";
        r5 = r3.dyS;
        r2.putExtra(r4, r5);
        r4 = r17.cwr();
        if (r4 == 0) goto L_0x0598;
    L_0x0537:
        r4 = "key_from_scene";
        r5 = 1;
        r2.putExtra(r4, r5);
        r4 = "key_scene_note";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r8 = r17.getTalkerUserName();
        r5 = r5.append(r8);
        r8 = ":";
        r5 = r5.append(r8);
        r5 = r5.append(r9);
        r5 = r5.toString();
        r2.putExtra(r4, r5);
    L_0x0560:
        r4 = "_stat_obj";
        r2.putExtra(r4, r6);
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
        r0 = r17;
        r4 = r0.tTq;
        r4 = r4.getContext();
        r5 = "appbrand";
        r6 = ".ui.AppBrandProfileUI";
        com.tencent.mm.bg.d.b(r4, r5, r6, r2);
        r2 = r7;
        goto L_0x0504;
    L_0x0598:
        r4 = "key_from_scene";
        r5 = 2;
        r2.putExtra(r4, r5);
        r4 = "key_scene_note";
        r2.putExtra(r4, r8);
        goto L_0x0560;
    L_0x05a6:
        r0 = r17;
        r2 = r0.tTq;
        r2 = r2 instanceof com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;
        if (r2 == 0) goto L_0x05b6;
    L_0x05ae:
        r2 = 1073; // 0x431 float:1.504E-42 double:5.3E-321;
        com.tencent.mm.modelappbrand.a.a(r8, r2, r3, r6);
        r2 = r7;
        goto L_0x0504;
    L_0x05b6:
        r2 = com.tencent.mm.model.s.hf(r8);
        if (r2 == 0) goto L_0x05c4;
    L_0x05bc:
        r2 = 1074; // 0x432 float:1.505E-42 double:5.306E-321;
        com.tencent.mm.modelappbrand.a.a(r8, r2, r3, r6);
        r2 = r7;
        goto L_0x0504;
    L_0x05c4:
        r2 = r17.cwr();
        com.tencent.mm.modelappbrand.a.a(r8, r9, r2, r3, r6);
        r2 = r7;
        goto L_0x0504;
    L_0x05ce:
        r2 = r17.cwr();
        com.tencent.mm.modelappbrand.a.b(r8, r9, r2, r3, r6);
        r2 = r7;
        goto L_0x0504;
    L_0x05d8:
        r2 = r3.dyT;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 == 0) goto L_0x062a;
    L_0x05e0:
        r2 = r3.dyS;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 == 0) goto L_0x062a;
    L_0x05e8:
        r4 = r3.url;
        r2 = r17.cwr();
        if (r2 == 0) goto L_0x0626;
    L_0x05f0:
        r2 = "groupmessage";
    L_0x05f3:
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
        goto L_0x000a;
    L_0x0626:
        r2 = "singlemessage";
        goto L_0x05f3;
    L_0x062a:
        r7 = r17.getTalkerUserName();
        r0 = r17;
        r1 = r18;
        r8 = r15.b(r0, r1);
        r6 = new android.os.Bundle;
        r6.<init>();
        r2 = r17.cwr();
        if (r2 == 0) goto L_0x069a;
    L_0x0641:
        r4 = "stat_scene";
        r2 = 2;
        r5 = r6;
    L_0x0646:
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
        goto L_0x000a;
    L_0x069a:
        r4 = "stat_scene";
        r2 = com.tencent.mm.model.s.hf(r7);
        if (r2 == 0) goto L_0x06a6;
    L_0x06a3:
        r2 = 7;
        r5 = r6;
        goto L_0x0646;
    L_0x06a6:
        r2 = 1;
        r5 = r6;
        goto L_0x0646;
    L_0x06a9:
        if (r5 == 0) goto L_0x06bc;
    L_0x06ab:
        r2 = r5.aaq();
        if (r2 == 0) goto L_0x06bc;
    L_0x06b1:
        r0 = r17;
        r2 = a(r0, r5);
        if (r2 == 0) goto L_0x06bc;
    L_0x06b9:
        r2 = 1;
        goto L_0x000a;
    L_0x06bc:
        r2 = com.tencent.mm.ui.chatting.b.b.a.class;
        r0 = r17;
        r2 = r0.O(r2);
        r2 = (com.tencent.mm.ui.chatting.b.b.a) r2;
        r0 = r18;
        r2.aR(r0);
        r2 = 1;
        goto L_0x000a;
    L_0x06ce:
        r2 = r3.dwS;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 == 0) goto L_0x06d9;
    L_0x06d6:
        r2 = 0;
        goto L_0x000a;
    L_0x06d9:
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
        if (r3 != 0) goto L_0x0702;
    L_0x06f8:
        r3 = "key_ProductUI_chatting_msgId";
        r0 = r18;
        r4 = r0.field_msgId;
        r2.putExtra(r3, r4);
    L_0x0702:
        r0 = r17;
        r3 = r0.tTq;
        r3 = r3.getContext();
        r4 = "scanner";
        r5 = ".ui.ProductUI";
        com.tencent.mm.bg.d.b(r3, r4, r5, r2);
        r2 = 1;
        goto L_0x000a;
    L_0x0716:
        r2 = r3.dwV;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 == 0) goto L_0x0721;
    L_0x071e:
        r2 = 0;
        goto L_0x000a;
    L_0x0721:
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
        if (r3 != 0) goto L_0x074a;
    L_0x0740:
        r3 = "key_TVInfoUI_chatting_msgId";
        r0 = r18;
        r4 = r0.field_msgId;
        r2.putExtra(r3, r4);
    L_0x074a:
        r0 = r17;
        r3 = r0.tTq;
        r3 = r3.getContext();
        r4 = "shake";
        r5 = ".ui.TVInfoUI";
        com.tencent.mm.bg.d.b(r3, r4, r5, r2);
        r2 = 1;
        goto L_0x000a;
    L_0x075e:
        r2 = r3.dwY;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 == 0) goto L_0x0769;
    L_0x0766:
        r2 = 0;
        goto L_0x000a;
    L_0x0769:
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
        goto L_0x000a;
    L_0x0796:
        r2 = r3.bRw;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 == 0) goto L_0x07a1;
    L_0x079e:
        r2 = 0;
        goto L_0x000a;
    L_0x07a1:
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
        goto L_0x000a;
    L_0x07cf:
        r2 = new android.content.Intent;
        r2.<init>();
        r4 = "message_id";
        r0 = r18;
        r6 = r0.field_msgId;
        r2.putExtra(r4, r6);
        r4 = "record_xml";
        r3 = r3.dwW;
        r2.putExtra(r4, r3);
        r0 = r17;
        r1 = r18;
        com.tencent.mm.ui.chatting.viewitems.c.a.a(r2, r0, r1, r15);
        r0 = r17;
        r3 = r0.tTq;
        r3 = r3.getContext();
        r4 = "record";
        r5 = ".ui.RecordMsgDetailUI";
        com.tencent.mm.bg.d.b(r3, r4, r5, r2);
        r2 = 1;
        goto L_0x000a;
    L_0x0801:
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
        goto L_0x000a;
    L_0x0835:
        r2 = new android.content.Intent;
        r2.<init>();
        r4 = "key_biz_uin";
        r5 = r3.dxI;
        r2.putExtra(r4, r5);
        r4 = "key_order_id";
        r3 = r3.dxJ;
        r2.putExtra(r4, r3);
        r0 = r18;
        r3 = r0.field_talker;
        if (r3 == 0) goto L_0x0874;
    L_0x0850:
        r0 = r18;
        r3 = r0.field_talker;
        r4 = "";
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x0874;
    L_0x085d:
        r0 = r18;
        r3 = r0.field_talker;
        r4 = "@chatroom";
        r3 = r3.endsWith(r4);
        if (r3 == 0) goto L_0x0874;
    L_0x086a:
        r3 = "key_chatroom_name";
        r0 = r18;
        r4 = r0.field_talker;
        r2.putExtra(r3, r4);
    L_0x0874:
        r0 = r17;
        r3 = r0.tTq;
        r3 = r3.getContext();
        r4 = "card";
        r5 = ".ui.CardGiftAcceptUI";
        com.tencent.mm.bg.d.b(r3, r4, r5, r2);
        r2 = 1;
        goto L_0x000a;
    L_0x0888:
        r2 = com.tencent.mm.plugin.websearch.api.q.class;
        r2 = r3.u(r2);
        r2 = (com.tencent.mm.plugin.websearch.api.q) r2;
        if (r2 == 0) goto L_0x0918;
    L_0x0892:
        r4 = r2.pLr;
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r4 != 0) goto L_0x0918;
    L_0x089a:
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
        r2 = r2.toByteArray();	 Catch:{ IOException -> 0x0ad7 }
        r3.putExtra(r5, r2);	 Catch:{ IOException -> 0x0ad7 }
    L_0x0902:
        r0 = r17;
        r2 = r0.tTq;
        r2 = r2.getContext();
        r5 = ".ui.video.TopStoryVideoStreamUI";
        com.tencent.mm.plugin.websearch.api.p.c(r2, r5, r3);
        r0 = r18;
        com.tencent.mm.plugin.topstory.a.h.a(r4, r0);
        r2 = 1;
        goto L_0x000a;
    L_0x0918:
        r4 = r3.url;
        r2 = r17.cwr();
        if (r2 == 0) goto L_0x0ab7;
    L_0x0920:
        r2 = "groupmessage";
    L_0x0923:
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
        if (r2 == 0) goto L_0x0982;
    L_0x094e:
        r2 = "wx751a1acca5688ba3";
        r7 = r3.appId;
        r2 = r2.equals(r7);
        if (r2 != 0) goto L_0x096f;
    L_0x0959:
        r2 = "wxfbc915ff7c30e335";
        r7 = r3.appId;
        r2 = r2.equals(r7);
        if (r2 != 0) goto L_0x096f;
    L_0x0964:
        r2 = "wx482a4001c37e2b74";
        r7 = r3.appId;
        r2 = r2.equals(r7);
        if (r2 == 0) goto L_0x0982;
    L_0x096f:
        r2 = new android.os.Bundle;
        r2.<init>();
        r7 = "jsapi_args_appid";
        r8 = r3.appId;
        r2.putString(r7, r8);
        r7 = "jsapiargs";
        r6.putExtra(r7, r2);
    L_0x0982:
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r2 != 0) goto L_0x0abc;
    L_0x0988:
        r2 = "shortUrl";
        r6.putExtra(r2, r4);
    L_0x098e:
        r4 = "version_name";
        if (r5 != 0) goto L_0x0ac6;
    L_0x0993:
        r2 = 0;
    L_0x0994:
        r6.putExtra(r4, r2);
        r4 = "version_code";
        if (r5 != 0) goto L_0x0aca;
    L_0x099c:
        r2 = 0;
    L_0x099d:
        r6.putExtra(r4, r2);
        r2 = r3.bZG;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 != 0) goto L_0x09b8;
    L_0x09a8:
        r2 = "srcUsername";
        r4 = r3.bZG;
        r6.putExtra(r2, r4);
        r2 = "srcDisplayname";
        r4 = r3.bZH;
        r6.putExtra(r2, r4);
    L_0x09b8:
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
            case 1: goto L_0x0ad0;
            case 2: goto L_0x0ace;
            case 3: goto L_0x0a67;
            case 4: goto L_0x0a67;
            case 5: goto L_0x0a67;
            case 6: goto L_0x0ad2;
            case 7: goto L_0x0ad2;
            default: goto L_0x0a67;
        };
    L_0x0a67:
        r2 = 0;
    L_0x0a68:
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
        if (r2 != r3) goto L_0x0aa3;
    L_0x0a99:
        r2 = "share_report_biz_username";
        r3 = r17.getTalkerUserName();
        r6.putExtra(r2, r3);
    L_0x0aa3:
        r0 = r17;
        r2 = r0.tTq;
        r2 = r2.getContext();
        r3 = "webview";
        r4 = ".ui.tools.WebViewUI";
        com.tencent.mm.bg.d.b(r2, r3, r4, r6);
        r2 = 1;
        goto L_0x000a;
    L_0x0ab7:
        r2 = "singlemessage";
        goto L_0x0923;
    L_0x0abc:
        r2 = "shortUrl";
        r4 = r3.url;
        r6.putExtra(r2, r4);
        goto L_0x098e;
    L_0x0ac6:
        r2 = r5.versionName;
        goto L_0x0994;
    L_0x0aca:
        r2 = r5.versionCode;
        goto L_0x099d;
    L_0x0ace:
        r2 = 2;
        goto L_0x0a68;
    L_0x0ad0:
        r2 = 3;
        goto L_0x0a68;
    L_0x0ad2:
        r2 = 5;
        goto L_0x0a68;
    L_0x0ad4:
        r2 = 0;
        goto L_0x000a;
    L_0x0ad7:
        r2 = move-exception;
        goto L_0x0902;
    L_0x0ada:
        r2 = move-exception;
        goto L_0x02a5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.c$e.b(android.view.View, com.tencent.mm.ui.chatting.c.a, com.tencent.mm.storage.bd):boolean");
    }

    public final void a(a aVar, bd bdVar) {
        if (bdVar.aQm()) {
            l.ae(bdVar);
            com.tencent.mm.model.bd.aU(bdVar.field_msgId);
            aVar.lT(true);
        }
    }
}
