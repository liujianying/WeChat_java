package com.tencent.mm.ui.chatting.viewitems;

import android.text.SpannableString;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.model.u;
import com.tencent.mm.modelappbrand.b.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.i;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.viewitems.o.d;
import com.tencent.mm.y.e;
import com.tencent.mm.y.g;

public class o$a extends b {
    private a tKy;

    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (z || i != 587202609) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_from_appmsg_wxa);
        rVar.setTag(new d().t(rVar, true));
        return rVar;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        g.a J;
        this.tKy = aVar2;
        d dVar = (d) aVar;
        i iVar = (i) aVar2.O(i.class);
        iVar.aV(bdVar);
        iVar.aW(bdVar);
        iVar.aX(bdVar);
        String str2 = bdVar.field_content;
        if (str2 != null) {
            J = g.a.J(str2, bdVar.field_reserved);
        } else {
            x.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", Long.valueOf(bdVar.field_msgId), str);
            J = null;
        }
        au auVar = new au(bdVar, aVar2.cwr(), i, null, 0);
        if (J != null) {
            dVar.tZS.setVisibility(8);
            dVar.tZR.setVisibility(8);
            dVar.uaq.setVisibility(8);
            e eVar = (e) J.u(e.class);
            if (dVar.tZV.l(eVar == null ? null : eVar.dwk, bdVar.field_talker)) {
                dVar.hrH.setBackgroundResource(R.g.chatfrom_bg_apptop);
            } else {
                dVar.hrH.setBackgroundResource(R.g.chatfrom_bg_app);
            }
            f cP = com.tencent.mm.pluginsdk.model.app.g.cP(J.appId, J.cbu);
            if (cP != null && cP.aaq()) {
                b.b(aVar2, J, bdVar);
            }
            if (J.cGB == null || J.cGB.length() == 0) {
                dVar.tZU.setVisibility(8);
            } else {
                dVar.tZU.setVisibility(0);
                b(aVar2, dVar.tZU, (Object) au.aaI(J.cGB));
            }
            WxaAttributes rR = ((c) com.tencent.mm.kernel.g.l(c.class)).rR(J.dyS);
            dVar.tZX.setVisibility(0);
            dVar.tZO.setVisibility(8);
            dVar.uaa.setVisibility(0);
            dVar.tZY.setVisibility(8);
            dVar.uao.setText(rR != null ? rR.field_nickname : J.bZH);
            str2 = rR != null ? rR.field_brandIconURL : J.dzb;
            o.Pj().a(str2, dVar.uan, d.ubC);
            dVar.uaq.setVisibility(0);
            dVar.uam.setVisibility(8);
            dVar.uam.setText(J.description);
            dVar.uat.setText(J.title);
            switch (J.dyZ) {
                case 1:
                    dVar.uap.setText(R.l.app_brand_share_wxa_testing_tag);
                    break;
                case 2:
                    dVar.uap.setText(R.l.app_brand_share_wxa_preview_tag);
                    break;
                default:
                    dVar.uap.setText(R.l.app_brand_entrance);
                    break;
            }
            o.Pj().a(str2, dVar.uan, d.ubC);
            if (aVar2.cwr()) {
                dVar.tZW.setVisibility(8);
            } else if (com.tencent.mm.pluginsdk.model.app.g.g(cP)) {
                dVar.tZW.setVisibility(0);
                b.c(aVar2, dVar.tZW, au.a(J, bdVar));
            } else {
                dVar.tZW.setVisibility(8);
            }
            str2 = o.Pf().d(bdVar.field_imgPath, false, true);
            dVar.uar.setImageBitmap(null);
            dVar.uar.setVisibility(4);
            dVar.uas.setVisibility(0);
            b.Ka().a(new 1(this, dVar), "file://" + str2, null, ((com.tencent.mm.modelappbrand.g) com.tencent.mm.kernel.g.l(com.tencent.mm.modelappbrand.g.class)).bc(240, 192));
            dVar.ubK.setVisibility(8);
            dVar.ubL.setVisibility(8);
            com.tencent.mm.y.a aVar3 = (com.tencent.mm.y.a) J.u(com.tencent.mm.y.a.class);
            if (aVar3 != null && aVar3.dvF) {
                dVar.ubK.setTag(J.dyY);
                com.tencent.mm.y.a.b jm = ((com.tencent.mm.modelappbrand.i) com.tencent.mm.kernel.g.l(com.tencent.mm.modelappbrand.i.class)).jm(J.dyY);
                if (jm != null && !bi.oW(jm.field_content)) {
                    dVar.ubK.setVisibility(0);
                    dVar.ubK.setText(jm.field_content);
                    dVar.ubK.setTextColor(bi.bc(jm.field_contentColor, aVar2.tTq.getContext().getResources().getColor(R.e.normal_text_color)));
                } else if (bi.oW(aVar3.dvG)) {
                    dVar.ubK.setVisibility(8);
                } else {
                    dVar.ubK.setVisibility(0);
                    dVar.ubK.setText(aVar3.dvG);
                    dVar.ubK.setTextColor(bi.bc(aVar3.dvH, aVar2.tTq.getContext().getResources().getColor(R.e.normal_text_color)));
                }
                if (jm == null || jm.field_btnState == 0) {
                    dVar.ubL.setVisibility(8);
                } else if (jm.field_btnState == 1) {
                    dVar.ubL.setVisibility(0);
                    String replace = aVar3.dvI.replace("$button$", aVar3.dvJ);
                    CharSequence spannableString = new SpannableString(replace);
                    spannableString.setSpan(new 2(this, J.dyY, dVar, aVar3.dvK), replace.indexOf(aVar3.dvJ), replace.indexOf(aVar3.dvJ) + aVar3.dvJ.length(), 17);
                    dVar.ubL.setMovementMethod(ay.getInstance());
                    dVar.ubL.setText(spannableString);
                } else if (jm.field_btnState == 2) {
                    dVar.ubL.setVisibility(0);
                    dVar.ubL.setText(aVar3.dvK);
                }
                int i2 = aVar3.dvL;
                if (!(jm == null || jm.field_updatePeroid == 0)) {
                    i2 = jm.field_updatePeroid;
                }
                if (i2 > 0) {
                    ((com.tencent.mm.modelappbrand.i) com.tencent.mm.kernel.g.l(com.tencent.mm.modelappbrand.i.class)).a(o.e.bq(aVar2), J.dyT, J.dyY, i2, new 3(this, dVar));
                }
            }
        }
        dVar.hrH.setTag(auVar);
        dVar.hrH.setOnClickListener(d(aVar2));
        u.b v = u.Hx().v(o.e.bq(aVar2), true);
        o.c cVar = (o.c) v.get("listener", null);
        if (cVar == null) {
            cVar = new o.c();
            v.p("listener", cVar);
        }
        cVar.j(aVar2);
        if (this.qUB) {
            dVar.hrH.setOnLongClickListener(c(aVar2));
            dVar.hrH.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        int i = ((au) view.getTag()).position;
        g.a gp = g.a.gp(com.tencent.mm.model.bd.b(this.tKy.cwr(), bdVar.field_content, bdVar.field_isSend));
        if (com.tencent.mm.pluginsdk.model.app.g.h(com.tencent.mm.pluginsdk.model.app.g.bl(gp.appId, false)) && !j.au(bdVar)) {
            if (gp.type == 6) {
                com.tencent.mm.pluginsdk.model.app.b SZ = l.SZ(gp.bGP);
                if ((SZ == null || !c.b.e(bdVar, SZ.field_fileFullPath)) && !bdVar.cmu()) {
                    contextMenu.add(i, 111, 0, this.tKy.tTq.getMMResources().getString(R.l.retransmit));
                }
            } else {
                contextMenu.add(i, 111, 0, this.tKy.tTq.getMMResources().getString(R.l.retransmit));
            }
        }
        dj djVar = new dj();
        djVar.bLf.bJC = bdVar.field_msgId;
        com.tencent.mm.sdk.b.a.sFg.m(djVar);
        if (djVar.bLg.bKE || c.b.a(this.tKy.tTq.getContext(), gp)) {
            contextMenu.add(i, 129, 0, view.getContext().getString(R.l.chatting_long_click_menu_open));
        }
        if (!this.tKy.cws()) {
            contextMenu.add(i, 100, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        switch (menuItem.getItemId()) {
            case 100:
                String str = bdVar.field_content;
                g.a aVar2 = null;
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
                    f bl = com.tencent.mm.pluginsdk.model.app.g.bl(aVar2.appId, false);
                    if (bl != null && bl.aaq()) {
                        b.a(aVar, aVar2, bdVar, bl);
                    }
                }
                com.tencent.mm.model.bd.aU(bdVar.field_msgId);
                break;
            case 111:
                c.b.a(aVar, bdVar, b(aVar, bdVar));
                break;
        }
        return false;
    }

    public final boolean b(View view, a aVar, bd bdVar) {
        com.tencent.mm.modelstat.a.a(bdVar, com.tencent.mm.modelstat.a.a.ehI);
        if (bdVar.field_content == null) {
            return false;
        }
        g.a gp = g.a.gp(com.tencent.mm.model.bd.b(aVar.cwr(), bdVar.field_content, bdVar.field_isSend));
        if (gp == null) {
            return false;
        }
        f bl = com.tencent.mm.pluginsdk.model.app.g.bl(gp.appId, false);
        if (bl != null && bl.aaq()) {
            b.a(aVar, gp, b.d(aVar, bdVar), bl, bdVar.field_msgSvrId);
        }
        x.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", gp.dyS, gp.dyR, gp.dyT, gp.url, Integer.valueOf(gp.dyZ), gp.dyV);
        qu quVar = new qu();
        quVar.cbq.appId = gp.dyT;
        quVar.cbq.userName = gp.dyS;
        quVar.cbq.cbs = gp.dyR;
        quVar.cbq.cbt = gp.dyZ;
        quVar.cbq.cbw = gp.dyV;
        quVar.cbq.cbu = gp.dza;
        quVar.cbq.cbx = gp.dyZ != 0;
        quVar.cbq.cbz.dFy = aVar.getTalkerUserName();
        quVar.cbq.cbz.dzR = gp.dyY;
        String str = gp.dyX;
        StringBuilder stringBuilder;
        if (aVar.cwr()) {
            quVar.cbq.scene = 1008;
            stringBuilder = new StringBuilder(aVar.getTalkerUserName());
            stringBuilder.append(":");
            stringBuilder.append(b(aVar, bdVar));
            stringBuilder.append(":");
            stringBuilder.append(str);
            quVar.cbq.bGG = stringBuilder.toString();
        } else {
            quVar.cbq.scene = 1007;
            stringBuilder = new StringBuilder(b(aVar, bdVar));
            stringBuilder.append(":");
            stringBuilder.append(str);
            quVar.cbq.bGG = stringBuilder.toString();
        }
        com.tencent.mm.sdk.b.a.sFg.m(quVar);
        return true;
    }
}
