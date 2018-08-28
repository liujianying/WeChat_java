package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u.b;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.i;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.t.m;
import com.tencent.rtmp.TXLiveConstants;

public class n$b extends b implements f, m {
    private u fye = new v(this);
    private a tKy;

    public final boolean bba() {
        return true;
    }

    public final boolean aq(int i, boolean z) {
        if (z && i == 553648177) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_to_appmsg_wxa_dynamic);
        n$d s = new n$d().s(rVar, false);
        View bH = ((e) g.l(e.class)).bH(rVar.getContext());
        s.ubE = bH;
        s.ubD.addView(bH, new LayoutParams(-1, -1));
        rVar.setTag(s);
        return rVar;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        com.tencent.mm.y.g.a J;
        n$d n_d = (n$d) aVar;
        this.tKy = aVar2;
        i iVar = (i) aVar2.O(i.class);
        iVar.aX(bdVar);
        String str2 = bdVar.field_content;
        iVar.aV(bdVar);
        if (str2 != null) {
            J = com.tencent.mm.y.g.a.J(str2, bdVar.field_reserved);
        } else {
            J = null;
        }
        au auVar = new au(bdVar, aVar2.cwr(), i, null, 0);
        if (J != null) {
            CharSequence charSequence;
            n_d.tZS.setVisibility(8);
            n_d.tZR.setVisibility(8);
            n_d.tZO.setVisibility(8);
            n_d.uaq.setVisibility(8);
            WxaAttributes rR = ((c) g.l(c.class)).rR(J.dyS);
            if (rR != null) {
                charSequence = rR.field_nickname;
            } else {
                Object charSequence2 = J.bZH;
            }
            str2 = rR != null ? rR.field_brandIconURL : J.dzb;
            n_d.uaq.setVisibility(0);
            n_d.uam.setVisibility(8);
            n_d.uat.setText(J.title);
            n_d.uam.setText(J.description);
            n_d.uao.setText(charSequence2);
            switch (J.dyZ) {
                case 1:
                    n_d.uap.setText(R.l.app_brand_share_wxa_testing_tag);
                    break;
                case 2:
                    n_d.uap.setText(R.l.app_brand_share_wxa_preview_tag);
                    break;
                default:
                    n_d.uap.setText(R.l.app_brand_entrance);
                    break;
            }
            o.Pj().a(str2, n_d.uan, n$d.ubC);
            if (cxN()) {
                com.tencent.mm.ui.chatting.b.b.g gVar = (com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class);
                if (bdVar.field_status == 2 && a(gVar, bdVar.field_msgId)) {
                    if (n_d.uai != null) {
                        n_d.uai.setVisibility(0);
                    }
                } else if (n_d.uai != null) {
                    n_d.uai.setVisibility(8);
                }
                if (n_d.mgA != null) {
                    n_d.mgA.setVisibility(8);
                }
            } else if (n_d.mgA != null) {
                n_d.mgA.setVisibility(0);
                if (bdVar.field_status >= 2) {
                    n_d.mgA.setVisibility(8);
                }
            }
            com.tencent.mm.y.a aVar3 = (com.tencent.mm.y.a) J.u(com.tencent.mm.y.a.class);
            Bundle bundle = new Bundle();
            bundle.putString("app_id", J.dyT);
            bundle.putString("msg_id", bdVar.field_msgId);
            String str3 = "cache_key";
            if (aVar3 != null) {
                str2 = aVar3.dvD;
            } else {
                str2 = null;
            }
            bundle.putString(str3, str2);
            bundle.putString("msg_title", J.title);
            bundle.putString("msg_path", J.dyR);
            bundle.putInt("msg_pkg_type", J.dyZ);
            bundle.putInt("pkg_version", J.cbu);
            bundle.putInt("widget_type", 0);
            bundle.putInt("scene", aVar2.cwr() ? TXLiveConstants.PUSH_EVT_START_VIDEO_ENCODER : TXLiveConstants.PUSH_EVT_FIRST_FRAME_AVAILABLE);
            bundle.putInt("view_init_width", n$d.ubA);
            bundle.putInt("view_init_height", n$d.ubB);
            n_d.ubE.setTag(n_d);
            ((e) g.l(e.class)).a(k.bq(aVar2), n_d.ubE, bundle, this.fye);
        }
        n_d.hrH.setTag(auVar);
        n_d.hrH.setOnClickListener(d(aVar2));
        b v = com.tencent.mm.model.u.Hx().v(k.bq(aVar2), true);
        n.c cVar = (n.c) v.get("listener", null);
        if (cVar == null) {
            cVar = new n.c();
            v.p("listener", cVar);
        }
        cVar.j(aVar2);
        if (this.qUB) {
            n_d.hrH.setOnLongClickListener(c(aVar2));
        }
        a(i, n_d, bdVar, aVar2.cwp(), aVar2.cwr(), aVar2, this);
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        int i = ((au) view.getTag()).position;
        if (bdVar.field_content != null) {
            com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(com.tencent.mm.model.bd.b(this.tKy.cwr(), bdVar.field_content, bdVar.field_isSend));
            if (gp != null) {
                if (com.tencent.mm.pluginsdk.model.app.g.h(com.tencent.mm.pluginsdk.model.app.g.bl(gp.appId, false)) && !j.au(bdVar)) {
                    contextMenu.add(i, 111, 0, this.tKy.tTq.getMMResources().getString(R.l.retransmit));
                }
                if ((bdVar.field_status == 2 || bdVar.cGF == 1) && a(bdVar, this.tKy) && aaA(bdVar.field_talker)) {
                    contextMenu.add(i, 123, 0, view.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
                }
                dj djVar = new dj();
                djVar.bLf.bJC = bdVar.field_msgId;
                com.tencent.mm.sdk.b.a.sFg.m(djVar);
                if (djVar.bLg.bKE || c$b.a(this.tKy.tTq.getContext(), gp)) {
                    contextMenu.add(i, 129, 0, view.getContext().getString(R.l.chatting_long_click_menu_open));
                }
                if (!this.tKy.cws()) {
                    contextMenu.add(i, 100, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
                }
                com.tencent.mm.modelappbrand.j JN = ((e) g.l(e.class)).JN();
                if (JN.JP() || JN.ho(gp.dyZ)) {
                    contextMenu.add(i, 133, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_open_wxa_widget_debugger_settings));
                    contextMenu.add(i, 132, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_open_wxa_widget_debugger));
                }
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        com.tencent.mm.y.g.a aVar2 = null;
        String str;
        switch (menuItem.getItemId()) {
            case 100:
                str = bdVar.field_content;
                if (str != null) {
                    aVar2 = com.tencent.mm.y.g.a.gp(str);
                }
                if (aVar2 != null) {
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
            case 103:
                String str2 = bdVar.field_content;
                if (str2 != null) {
                    aVar2 = com.tencent.mm.y.g.a.gp(str2);
                    if (aVar2 != null) {
                        switch (aVar2.type) {
                            case 16:
                                hz hzVar = new hz();
                                hzVar.bRv.bRw = aVar2.bRw;
                                hzVar.bRv.bIZ = bdVar.field_msgId;
                                hzVar.bRv.bRx = bdVar.field_talker;
                                com.tencent.mm.sdk.b.a.sFg.m(hzVar);
                                break;
                        }
                    }
                }
                break;
            case 111:
                c$b.a(aVar, bdVar, b(aVar, bdVar));
                break;
            case 132:
                ((e) g.l(e.class)).JN().bI(aVar.tTq.getContext());
                break;
            case 133:
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

    public final boolean b(View view, a aVar, bd bdVar) {
        view.getTag();
        String str = bdVar.field_content;
        if (str == null) {
            return false;
        }
        com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(str);
        if (gp == null) {
            return false;
        }
        com.tencent.mm.pluginsdk.model.app.f bl = com.tencent.mm.pluginsdk.model.app.g.bl(gp.appId, true);
        if (!(bl == null || bi.oW(bl.field_appId) || !bl.aaq())) {
            a(aVar, gp, q.GF(), bl, bdVar.field_msgSvrId);
        }
        qu quVar = new qu();
        quVar.cbq.appId = gp.dyT;
        quVar.cbq.userName = gp.dyS;
        quVar.cbq.cbs = gp.dyR;
        quVar.cbq.cbt = gp.dyZ;
        quVar.cbq.cbw = gp.dyV;
        quVar.cbq.cbu = gp.dza;
        quVar.cbq.cbx = gp.dyZ != 0;
        str = gp.dyX;
        StringBuilder stringBuilder;
        if (aVar.cwr()) {
            quVar.cbq.scene = TXLiveConstants.PUSH_EVT_START_VIDEO_ENCODER;
            stringBuilder = new StringBuilder(aVar.getTalkerUserName());
            stringBuilder.append(":");
            stringBuilder.append(b(aVar, bdVar));
            stringBuilder.append(":");
            stringBuilder.append(str);
            quVar.cbq.bGG = stringBuilder.toString();
        } else {
            quVar.cbq.scene = TXLiveConstants.PUSH_EVT_FIRST_FRAME_AVAILABLE;
            stringBuilder = new StringBuilder(b(aVar, bdVar));
            stringBuilder.append(":");
            stringBuilder.append(str);
            quVar.cbq.bGG = stringBuilder.toString();
        }
        quVar.cbq.cbz.dFy = aVar.getTalkerUserName();
        quVar.cbq.cbz.dzR = gp.dyY;
        com.tencent.mm.sdk.b.a.sFg.m(quVar);
        return true;
    }

    public final void q(View view, int i) {
        Object tag = view.getTag();
        if (tag instanceof n$d) {
            x.i("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "onWidgetStateChanged(%s, state : %d)", new Object[]{Integer.valueOf(view.hashCode()), Integer.valueOf(i)});
            n$d n_d = (n$d) tag;
            switch (i) {
                case 0:
                    n_d.gzp.setVisibility(0);
                    n_d.gzp.cAG();
                    n_d.ubE.setVisibility(4);
                    n_d.oBp.setVisibility(4);
                    return;
                case 1:
                    n_d.gzp.cAH();
                    n_d.gzp.setVisibility(4);
                    n_d.ubE.setVisibility(4);
                    n_d.oBp.setVisibility(0);
                    n_d.oBp.setImageResource(R.k.dynamic_page_res_not_found);
                    return;
                case 4:
                    n_d.gzp.cAH();
                    n_d.gzp.setVisibility(4);
                    n_d.ubE.setVisibility(0);
                    n_d.oBp.setVisibility(4);
                    return;
                default:
                    n_d.gzp.cAH();
                    n_d.gzp.setVisibility(4);
                    n_d.ubE.setVisibility(4);
                    n_d.oBp.setVisibility(0);
                    n_d.oBp.setImageResource(R.k.app_brand_share_page_cover_default);
                    return;
            }
        }
    }

    public final void a(a aVar, bd bdVar) {
        if (bdVar.aQm()) {
            l.ae(bdVar);
            com.tencent.mm.model.bd.aU(bdVar.field_msgId);
            aVar.lT(true);
        }
    }
}
