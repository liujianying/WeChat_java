package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.al.b;
import com.tencent.mm.ax.e;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.g.a.ra;
import com.tencent.mm.l.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.x;

public final class l implements OnClickListener {
    private Context context;

    public l(Context context) {
        this.context = context;
    }

    public final void onClick(View view) {
        boolean z = true;
        Object tag = view.getTag();
        if (tag instanceof b) {
            b bVar = (b) tag;
            if (bVar == null || view == null) {
                x.w("MicroMsg.SourceClickListener", "localAppRedirectHandle: but info or v is null");
            } else {
                Intent intent;
                if ("wx7fa037cc7dfabad5".equals(bVar.appId)) {
                    d.kB(33);
                    au.HU();
                    if (a.gd(c.FR().Yg("gh_43f2581f6fd6").field_type)) {
                        intent = new Intent();
                        intent.putExtra("Chat_User", "gh_43f2581f6fd6");
                        intent.putExtra("finish_direct", true);
                        com.tencent.mm.bg.d.e(this.context, ".ui.chatting.ChattingUI", intent);
                    } else {
                        intent = new Intent();
                        intent.putExtra("Contact_User", "gh_43f2581f6fd6");
                        com.tencent.mm.bg.d.b(this.context, "profile", ".ui.ContactInfoUI", intent);
                    }
                } else if ("wx485a97c844086dc9".equals(bVar.appId)) {
                    intent = new Intent();
                    intent.putExtra("shake_music", true);
                    com.tencent.mm.bg.d.b(this.context, "shake", ".ui.ShakeReportUI", intent);
                } else if ("wxfbc915ff7c30e335".equals(bVar.appId)) {
                    if (!b.PC()) {
                        intent = new Intent();
                        intent.putExtra("BaseScanUI_select_scan_mode", 1);
                        if (!(com.tencent.mm.p.a.bx(this.context) || e.Sz())) {
                            com.tencent.mm.bg.d.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                        }
                    }
                } else if ("wx482a4001c37e2b74".equals(bVar.appId)) {
                    if (!b.PC()) {
                        intent = new Intent();
                        intent.putExtra("BaseScanUI_select_scan_mode", 2);
                        if (!(com.tencent.mm.p.a.bx(this.context) || e.Sz())) {
                            com.tencent.mm.bg.d.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                        }
                    }
                } else if ("wx751a1acca5688ba3".equals(bVar.appId)) {
                    if (!b.PC()) {
                        intent = new Intent();
                        intent.putExtra("BaseScanUI_select_scan_mode", 5);
                        if (!(com.tencent.mm.p.a.bx(this.context) || e.Sz())) {
                            com.tencent.mm.bg.d.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                        }
                    }
                } else if ("wxaf060266bfa9a35c".equals(bVar.appId)) {
                    intent = new Intent();
                    intent.putExtra("shake_tv", true);
                    com.tencent.mm.bg.d.b(this.context, "shake", ".ui.ShakeReportUI", intent);
                }
                if (!z) {
                    String h = p.h(this.context, bVar.appId, bVar.bXS);
                    ra raVar = new ra();
                    raVar.cbO.cbP = h;
                    raVar.cbO.context = this.context;
                    com.tencent.mm.sdk.b.a.sFg.m(raVar);
                }
            }
            z = false;
            if (!z) {
                String h2 = p.h(this.context, bVar.appId, bVar.bXS);
                ra raVar2 = new ra();
                raVar2.cbO.cbP = h2;
                raVar2.cbO.context = this.context;
                com.tencent.mm.sdk.b.a.sFg.m(raVar2);
            }
        } else if (tag instanceof a) {
            a aVar = (a) tag;
            gk gkVar = new gk();
            gkVar.bPB.actionCode = 2;
            gkVar.bPB.scene = aVar.scene;
            gkVar.bPB.extMsg = "chatting_src=" + aVar.scene;
            gkVar.bPB.appId = aVar.appId;
            gkVar.bPB.context = this.context;
            com.tencent.mm.sdk.b.a.sFg.m(gkVar);
            nk nkVar = new nk();
            nkVar.bYs.context = this.context;
            nkVar.bYs.scene = aVar.scene;
            nkVar.bYs.bPS = aVar.appId;
            nkVar.bYs.packageName = aVar.byT;
            nkVar.bYs.msgType = aVar.qMW;
            nkVar.bYs.bSS = aVar.bYo;
            nkVar.bYs.bYt = 5;
            nkVar.bYs.mediaTagName = aVar.qMX;
            nkVar.bYs.bYu = aVar.bYu;
            nkVar.bYs.bYv = "";
            com.tencent.mm.sdk.b.a.sFg.m(nkVar);
        }
    }
}
