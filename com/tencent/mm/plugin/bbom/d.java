package com.tencent.mm.plugin.bbom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.brandservice.a.a;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.chatting.f;
import com.tencent.mm.ui.chatting.r;
import com.tencent.mm.ui.chatting.viewitems.au;
import com.tencent.mm.ui.tools.b;

public final class d implements a {
    private OnClickListener heo = new 1(this);
    private OnClickListener hep = new OnClickListener() {
        public final void onClick(View view) {
            Context context = view.getContext();
            au auVar = (au) view.getTag();
            q qVar = auVar.ufF;
            if (qVar == null) {
                x.e("MicroMsg.ChattingItemHelper", "onBizTimeLineWebViewClick info is null");
                return;
            }
            x.d("MicroMsg.ChattingItemHelper", "onWebViewClick = " + System.currentTimeMillis());
            if (!f.a(auVar.ceR, context, null, qVar.field_talker)) {
                String str = auVar.userName;
                String str2 = auVar.ufy;
                if (str != null && !str.equals("")) {
                    int i;
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("shortUrl", str);
                    intent.putExtra("webpageTitle", str2);
                    Bundle bundle = new Bundle();
                    com.tencent.mm.model.au.HU();
                    ab Yg = c.FR().Yg(qVar.field_talker);
                    if (Yg == null || !Yg.ckW()) {
                        i = 0;
                    } else {
                        i = 4;
                        x.d("MicroMsg.ChattingItemHelper", "hakon click biz msg %s", new Object[]{Yg.field_username});
                    }
                    intent.putExtra("msg_id", qVar.field_msgId);
                    intent.putExtra("KPublisherId", "msg_" + Long.toString(qVar.field_msgSvrId));
                    intent.putExtra("pre_username", qVar.field_talker);
                    intent.putExtra("prePublishId", "msg_" + Long.toString(qVar.field_msgSvrId));
                    intent.putExtra("preUsername", qVar.field_talker);
                    intent.putExtra("preChatName", qVar.field_talker);
                    intent.putExtra("preChatTYPE", 7);
                    intent.putExtra("preMsgIndex", auVar.pSA);
                    Bundle bundle2 = auVar.ufE;
                    if (bundle2 != null) {
                        intent.putExtras(bundle2);
                    }
                    bundle.putInt("snsWebSource", i);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("geta8key_username", qVar.field_talker);
                    if (!ai.oW(auVar.bZG)) {
                        intent.putExtra("srcUsername", auVar.bZG);
                        intent.putExtra("srcDisplayname", auVar.bZH);
                        intent.putExtra("mode", 1);
                    }
                    intent.putExtra("message_id", auVar.pSz);
                    intent.putExtra("message_index", auVar.pSA);
                    intent.putExtra("from_scence", 1);
                    intent.putExtra("geta8key_scene", auVar.cfR);
                    intent.addFlags(536870912);
                    com.tencent.mm.bg.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        }
    };

    public final void a(View view, long j, String str, String str2, int i) {
        com.tencent.mm.ui.chatting.viewitems.c.f fVar = new com.tencent.mm.ui.chatting.viewitems.c.f();
        fVar.bJC = j;
        fVar.uaH = i;
        fVar.bVv = str2;
        fVar.bSw = str;
        view.setTag(fVar);
        view.setOnClickListener(this.heo);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.y.m r17, com.tencent.mm.storage.q r18, int r19, com.tencent.mm.y.l r20, android.view.View r21, boolean r22) {
        /*
        r16 = this;
        r0 = r18;
        r2 = r0.field_talker;
        r8 = com.tencent.mm.model.r.gT(r2);
        r3 = 0;
        r0 = r17;
        r2 = r0.url;
        r0 = r18;
        r4 = r0.field_talker;
        r5 = android.text.TextUtils.isEmpty(r2);
        if (r5 != 0) goto L_0x00c8;
    L_0x0017:
        r5 = "http://weixin.qq.com/emoticonstore/";
        r5 = r2.contains(r5);
        if (r5 == 0) goto L_0x00c8;
    L_0x0020:
        r5 = "/";
        r5 = r2.lastIndexOf(r5);
        r5 = r5 + 1;
        r12 = r2.substring(r5);
        r2 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r2 = com.tencent.mm.kernel.g.l(r2);
        r2 = (com.tencent.mm.plugin.messenger.foundation.a.i) r2;
        r2 = r2.FR();
        r2 = r2.Yg(r4);
        r5 = r2.field_type;
        r5 = com.tencent.mm.l.a.gd(r5);
        if (r5 == 0) goto L_0x00c8;
    L_0x0045:
        r2 = r2.ckW();
        if (r2 == 0) goto L_0x00c8;
    L_0x004b:
        r2 = com.tencent.mm.ac.f.kH(r4);
        if (r2 == 0) goto L_0x00c8;
    L_0x0051:
        r4 = 0;
        r2 = r2.bG(r4);
        if (r2 == 0) goto L_0x00c8;
    L_0x0058:
        r4 = r2.Mx();
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 != 0) goto L_0x00c8;
    L_0x0062:
        r2 = r2.Mx();
        r2 = r12.contains(r2);
        if (r2 == 0) goto L_0x00c8;
    L_0x006c:
        r2 = android.text.TextUtils.isEmpty(r12);
        if (r2 != 0) goto L_0x00ca;
    L_0x0072:
        r2 = new com.tencent.mm.ui.chatting.viewitems.au;
        r3 = 0;
        r4 = 0;
        r0 = r17;
        r6 = r0.url;
        r0 = r20;
        r9 = r0.bZG;
        r0 = r20;
        r10 = r0.bZH;
        r0 = r17;
        r11 = r0.title;
        r13 = 0;
        r14 = 0;
        r15 = 0;
        r5 = r19;
        r7 = r22;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
        r3 = new com.tencent.mm.plugin.bbom.d$3;
        r0 = r16;
        r1 = r18;
        r3.<init>(r0, r1);
        r0 = r21;
        r0.setOnClickListener(r3);
    L_0x009e:
        if (r2 == 0) goto L_0x00b2;
    L_0x00a0:
        r0 = r18;
        r4 = r0.field_msgSvrId;
        r2.pSz = r4;
        r3 = 0;
        r2.pSA = r3;
        r0 = r18;
        r2.ufF = r0;
        r0 = r21;
        r0.setTag(r2);
    L_0x00b2:
        r0 = r17;
        r2 = r0.dzD;
        r2 = com.tencent.mm.y.i.gr(r2);
        if (r2 == 0) goto L_0x00c7;
    L_0x00bc:
        r0 = r18;
        r2 = r0.field_talker;
        r0 = r17;
        r1 = r21;
        com.tencent.mm.ui.chatting.r.a(r0, r1, r2);
    L_0x00c7:
        return;
    L_0x00c8:
        r12 = 0;
        goto L_0x006c;
    L_0x00ca:
        r0 = r17;
        r2 = r0.url;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 != 0) goto L_0x0147;
    L_0x00d4:
        r2 = new com.tencent.mm.ui.chatting.viewitems.au;
        r3 = 0;
        r4 = 0;
        r0 = r17;
        r6 = r0.url;
        r0 = r20;
        r9 = r0.bZG;
        r0 = r20;
        r10 = r0.bZH;
        r0 = r17;
        r11 = r0.title;
        r5 = r19;
        r7 = r22;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11);
        r3 = 56;
        r2.cfR = r3;
        r0 = r18;
        r3 = r0.field_talker;
        r4 = new android.os.Bundle;
        r4.<init>();
        r5 = "share_report_pre_msg_url";
        r0 = r17;
        r6 = r0.url;
        r4.putString(r5, r6);
        r5 = "share_report_pre_msg_title";
        r0 = r17;
        r6 = r0.title;
        r4.putString(r5, r6);
        r5 = "share_report_pre_msg_desc";
        r0 = r17;
        r6 = r0.dzA;
        r4.putString(r5, r6);
        r5 = "share_report_pre_msg_icon_url";
        r0 = r17;
        r6 = r0.dzy;
        r4.putString(r5, r6);
        r5 = "share_report_pre_msg_appid";
        r6 = "";
        r4.putString(r5, r6);
        r5 = "share_report_from_scene";
        r6 = 5;
        r4.putInt(r5, r6);
        r5 = "share_report_biz_username";
        r4.putString(r5, r3);
        r2.ufE = r4;
        r0 = r16;
        r3 = r0.hep;
        r0 = r21;
        r0.setOnClickListener(r3);
        goto L_0x009e;
    L_0x0147:
        r2 = r3;
        goto L_0x009e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.bbom.d.a(com.tencent.mm.y.m, com.tencent.mm.storage.q, int, com.tencent.mm.y.l, android.view.View, boolean):void");
    }

    public final void b(com.tencent.mm.ac.d dVar, Activity activity, ab abVar) {
        b.a(dVar, activity, abVar, 3);
    }

    public final void a(int i, Context context, String str, String str2, long j, long j2) {
        r.a(i, context, str, str2, j, j2);
    }

    public final void a(long j, int i, Context context, Activity activity, bd bdVar) {
        r.a(j, i, context, null, activity, bdVar);
    }

    public final void a(bd bdVar, Activity activity) {
        if (!bdVar.aQm()) {
            ch chVar = new ch();
            e.a(chVar, bdVar);
            chVar.bJF.activity = activity;
            chVar.bJF.bJM = 43;
            com.tencent.mm.sdk.b.a.sFg.m(chVar);
            if (chVar.bJG.ret == 0) {
                com.tencent.mm.modelstat.b.ehL.x(bdVar);
            }
        }
    }

    public final void a(bd bdVar, Context context) {
        r.a(bdVar, context, null);
    }
}
