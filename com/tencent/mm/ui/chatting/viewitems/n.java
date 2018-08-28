package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import android.support.design.a$i;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u$b;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.f;
import com.tencent.mm.ui.chatting.b.b.i;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.m;
import java.lang.ref.WeakReference;

public final class n {

    static class c implements m {
        private WeakReference<com.tencent.mm.ui.chatting.c.a> ubz;

        c() {
        }

        final void j(com.tencent.mm.ui.chatting.c.a aVar) {
            this.ubz = new WeakReference(aVar);
            ((f) aVar.O(f.class)).a(this);
        }

        public final void cpF() {
        }

        public final void cpG() {
        }

        public final void cpH() {
        }

        public final void cpI() {
            if (this.ubz != null) {
                com.tencent.mm.ui.chatting.c.a aVar = (com.tencent.mm.ui.chatting.c.a) this.ubz.get();
                if (aVar != null) {
                    ((e) g.l(e.class)).JM().jk(k.bq(aVar));
                }
            }
        }

        public final void cpJ() {
            if (this.ubz != null) {
                com.tencent.mm.ui.chatting.c.a aVar = (com.tencent.mm.ui.chatting.c.a) this.ubz.get();
                if (aVar != null) {
                    ((e) g.l(e.class)).JM().jj(k.bq(aVar));
                }
            }
        }

        public final void cpK() {
            x.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
            if (this.ubz != null) {
                com.tencent.mm.ui.chatting.c.a aVar = (com.tencent.mm.ui.chatting.c.a) this.ubz.get();
                if (aVar != null) {
                    u.Hx().ib(k.bq(aVar));
                    ((f) aVar.O(f.class)).b(this);
                    ((e) g.l(e.class)).jl(k.bq(aVar));
                }
            }
        }

        public final void cpL() {
        }
    }

    public static class a extends b implements com.tencent.mm.modelappbrand.f {
        private com.tencent.mm.modelappbrand.u fye = new v((com.tencent.mm.modelappbrand.f) this);
        private com.tencent.mm.ui.chatting.c.a tKy;

        public final boolean bba() {
            return false;
        }

        public final boolean aq(int i, boolean z) {
            if (z || i != 553648177) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new r(layoutInflater, R.i.chatting_item_from_appmsg_wxa_dynamic);
            d s = new d().s(view, true);
            View bH = ((e) g.l(e.class)).bH(view.getContext());
            s.ubE = bH;
            s.ubD.addView(bH, new LayoutParams(-1, -1));
            view.setTag(s);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.c.a aVar2, bd bdVar, String str) {
            com.tencent.mm.y.g.a J;
            this.tKy = aVar2;
            d dVar = (d) aVar;
            String str2 = bdVar.field_content;
            i iVar = (i) aVar2.O(i.class);
            iVar.aV(bdVar);
            iVar.aW(bdVar);
            iVar.aX(bdVar);
            x.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "filling Wxa dynamic from ChattingItem(%s)", new Object[]{str});
            if (str2 != null) {
                J = com.tencent.mm.y.g.a.J(str2, bdVar.field_reserved);
            } else {
                x.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", new Object[]{Long.valueOf(bdVar.field_msgId), str});
                J = null;
            }
            au auVar = new au(bdVar, aVar2.cwr(), i, null, 0);
            if (J != null) {
                CharSequence charSequence;
                dVar.tZS.setVisibility(8);
                dVar.tZR.setVisibility(8);
                dVar.uaq.setVisibility(8);
                com.tencent.mm.y.e eVar = (com.tencent.mm.y.e) J.u(com.tencent.mm.y.e.class);
                if (dVar.tZV.l(eVar == null ? null : eVar.dwk, bdVar.field_talker)) {
                    dVar.hrH.setBackgroundResource(R.g.chatfrom_bg_apptop);
                } else {
                    dVar.hrH.setBackgroundResource(R.g.chatfrom_bg_app);
                }
                com.tencent.mm.pluginsdk.model.app.f cP = com.tencent.mm.pluginsdk.model.app.g.cP(J.appId, J.cbu);
                if (cP != null && cP.aaq()) {
                    b(aVar2, J, bdVar);
                }
                if (J.cGB == null || J.cGB.length() == 0) {
                    dVar.tZU.setVisibility(8);
                } else {
                    dVar.tZU.setVisibility(0);
                    b(aVar2, dVar.tZU, au.aaI(J.cGB));
                }
                WxaAttributes rR = ((com.tencent.mm.plugin.appbrand.n.c) g.l(com.tencent.mm.plugin.appbrand.n.c.class)).rR(J.dyS);
                dVar.tZX.setVisibility(0);
                dVar.tZO.setVisibility(8);
                dVar.uaa.setVisibility(0);
                dVar.tZY.setVisibility(8);
                if (rR != null) {
                    charSequence = rR.field_nickname;
                } else {
                    Object charSequence2 = J.bZH;
                }
                str2 = rR != null ? rR.field_brandIconURL : J.dzb;
                dVar.uaq.setVisibility(0);
                dVar.uam.setVisibility(8);
                dVar.uat.setText(J.title);
                dVar.uam.setText(J.description);
                dVar.uao.setText(charSequence2);
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
                    c(aVar2, dVar.tZW, au.a(J, bdVar));
                } else {
                    dVar.tZW.setVisibility(8);
                }
                com.tencent.mm.y.a aVar3 = (com.tencent.mm.y.a) J.u(com.tencent.mm.y.a.class);
                Bundle bundle = new Bundle();
                bundle.putString("app_id", J.dyT);
                bundle.putString("msg_id", bdVar.field_msgId);
                bundle.putString("cache_key", aVar3 != null ? aVar3.dvD : null);
                bundle.putString("msg_title", J.title);
                bundle.putString("msg_path", J.dyR);
                bundle.putInt("msg_pkg_type", J.dyZ);
                bundle.putInt("pkg_version", J.cbu);
                bundle.putInt("widget_type", 0);
                bundle.putInt("scene", aVar2.cwr() ? 1008 : 1007);
                bundle.putInt("view_init_width", d.ubA);
                bundle.putInt("view_init_height", d.ubB);
                dVar.ubE.setTag(dVar);
                ((e) g.l(e.class)).a(k.bq(aVar2), dVar.ubE, bundle, this.fye);
            }
            dVar.hrH.setTag(auVar);
            dVar.hrH.setOnClickListener(d(aVar2));
            u$b v = u.Hx().v(k.bq(aVar2), true);
            c cVar = (c) v.get("listener", null);
            if (cVar == null) {
                cVar = new c();
                v.p("listener", cVar);
            }
            cVar.j(aVar2);
            if (this.qUB) {
                dVar.hrH.setOnLongClickListener(c(aVar2));
            }
        }

        public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
            int i = ((au) view.getTag()).position;
            com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(com.tencent.mm.model.bd.b(this.tKy.cwr(), bdVar.field_content, bdVar.field_isSend));
            if (com.tencent.mm.pluginsdk.model.app.g.h(com.tencent.mm.pluginsdk.model.app.g.bl(gp.appId, false)) && !j.au(bdVar)) {
                if (gp.type == 6) {
                    b SZ = l.SZ(gp.bGP);
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
            if (bf.l(bdVar)) {
                contextMenu.clear();
            }
            if (!this.tKy.cws()) {
                contextMenu.add(i, 100, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
            }
            com.tencent.mm.modelappbrand.j JN = ((e) g.l(e.class)).JN();
            if (JN.JP() || JN.ho(gp.dyZ)) {
                contextMenu.add(i, d.CTRL_INDEX, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_open_wxa_widget_debugger_settings));
                contextMenu.add(i, 132, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_open_wxa_widget_debugger));
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.c.a aVar, bd bdVar) {
            com.tencent.mm.y.g.a aVar2 = null;
            String str;
            switch (menuItem.getItemId()) {
                case a$i.AppCompatTheme_buttonStyle /*100*/:
                    str = bdVar.field_content;
                    if (str != null) {
                        aVar2 = com.tencent.mm.y.g.a.gp(str);
                    }
                    if (aVar2 != null) {
                        l.fJ(bdVar.field_msgId);
                        if (19 == aVar2.type) {
                            mw mwVar = new mw();
                            mwVar.bXL.type = 3;
                            mwVar.bXL.bJC = bdVar.field_msgId;
                            com.tencent.mm.sdk.b.a.sFg.m(mwVar);
                        }
                        com.tencent.mm.pluginsdk.model.app.f bl = com.tencent.mm.pluginsdk.model.app.g.bl(aVar2.appId, false);
                        if (bl != null && bl.aaq()) {
                            a(aVar, aVar2, bdVar, bl);
                        }
                    }
                    com.tencent.mm.model.bd.aU(bdVar.field_msgId);
                    break;
                case 111:
                    c.b.a(aVar, bdVar, b(aVar, bdVar));
                    break;
                case 132:
                    ((e) g.l(e.class)).JN().bI(aVar.tTq.getContext());
                    break;
                case d.CTRL_INDEX /*133*/:
                    str = bdVar.field_content;
                    if (str != null) {
                        aVar2 = com.tencent.mm.y.g.a.gp(str);
                    }
                    if (aVar2 != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("app_id", aVar2.dyT);
                        bundle.putString("msg_id", bdVar.field_msgId);
                        bundle.putInt("pkg_type", aVar2.dyZ);
                        bundle.putInt("pkg_version", aVar2.dyW);
                        ((e) g.l(e.class)).JN().d(aVar.tTq.getContext(), bundle);
                        break;
                    }
                    break;
            }
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.c.a aVar, bd bdVar) {
            com.tencent.mm.modelstat.a.a(bdVar, com.tencent.mm.modelstat.a.a.ehI);
            if (bdVar.field_content == null) {
                return false;
            }
            com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(com.tencent.mm.model.bd.b(aVar.cwr(), bdVar.field_content, bdVar.field_isSend));
            if (gp == null) {
                return false;
            }
            com.tencent.mm.pluginsdk.model.app.f bl = com.tencent.mm.pluginsdk.model.app.g.bl(gp.appId, false);
            if (bl != null && bl.aaq()) {
                a(aVar, gp, d(aVar, bdVar), bl, bdVar.field_msgSvrId);
            }
            x.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[]{gp.dyS, gp.dyR, gp.dyT, gp.url, Integer.valueOf(gp.dyZ), gp.dyV});
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

        public final void q(View view, int i) {
            Object tag = view.getTag();
            if (tag instanceof d) {
                x.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "onWidgetStateChanged(%s, state : %d)", new Object[]{Integer.valueOf(view.hashCode()), Integer.valueOf(i)});
                d dVar = (d) tag;
                switch (i) {
                    case 0:
                        dVar.gzp.setVisibility(0);
                        dVar.gzp.cAG();
                        dVar.oBp.setVisibility(4);
                        dVar.ubE.setVisibility(4);
                        return;
                    case 1:
                        dVar.gzp.cAH();
                        dVar.gzp.setVisibility(4);
                        dVar.ubE.setVisibility(4);
                        dVar.oBp.setVisibility(0);
                        dVar.oBp.setImageResource(R.k.dynamic_page_res_not_found);
                        return;
                    case 4:
                        dVar.gzp.cAH();
                        dVar.gzp.setVisibility(4);
                        dVar.ubE.setVisibility(0);
                        dVar.oBp.setVisibility(4);
                        return;
                    default:
                        dVar.gzp.cAH();
                        dVar.gzp.setVisibility(4);
                        dVar.ubE.setVisibility(4);
                        dVar.oBp.setVisibility(0);
                        dVar.oBp.setImageResource(R.k.app_brand_share_page_cover_default);
                        return;
                }
            }
        }
    }
}
