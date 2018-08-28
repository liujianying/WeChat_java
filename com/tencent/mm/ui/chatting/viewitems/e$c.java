package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.y.b;
import com.tencent.mm.y.g$a;

public class e$c extends b {
    private a tKy;

    public final boolean bba() {
        return true;
    }

    public final boolean aq(int i, boolean z) {
        if (z && i == 536870961) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_to_appmsg_c2c);
        rVar.setTag(new e$a().dz(rVar));
        return rVar;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        g$a J;
        this.tKy = aVar2;
        e$a e_a = (e$a) aVar;
        String str2 = bdVar.field_content;
        if (str2 != null) {
            J = g$a.J(str2, bdVar.field_reserved);
        } else {
            J = null;
        }
        if (J != null) {
            e_a.hrH.setBackgroundResource(R.g.honey_pay_chatto);
            e_a.uaJ.setTypeface(Typeface.defaultFromStyle(0));
            e_a.hrH.setPadding(aVar2.tTq.getContext().getResources().getDimensionPixelSize(R.f.chattingBubblepadding), 0, aVar2.tTq.getContext().getResources().getDimensionPixelSize(R.f.SmallPadding), 0);
            b bVar = (b) J.u(b.class);
            CharSequence charSequence = bdVar.field_isSend == 1 ? bVar.dvY : bVar.dvX;
            if (bi.oW(charSequence)) {
                charSequence = J.description;
                e_a.uaJ.setSingleLine(false);
                e_a.uaJ.setMaxLines(3);
            } else {
                e_a.uaJ.setSingleLine(true);
            }
            e_a.uaJ.setText(j.a(aVar2.tTq.getContext(), charSequence, e_a.uaM));
            e_a.uaJ.setTextSize(0, (float) e_a.uaM);
            if (!bi.oW(bVar.dvZ)) {
                e_a.uaJ.setTextColor(Color.parseColor(bVar.dvZ));
            }
            e_a.uaK.setText(bdVar.field_isSend == 1 ? bVar.dwc : bVar.dwd);
            if (!bi.oW(bVar.dwe)) {
                e_a.uaK.setTextColor(Color.parseColor(bVar.dwe));
            }
            e_a.uaL.setText(bdVar.field_isSend == 1 ? bVar.dwa : bVar.dwb);
            e_a.uaI.setImageBitmap(null);
            if (!bi.oW(bVar.dvS)) {
                c.a aVar3 = new c.a();
                au.HU();
                aVar3.dXB = com.tencent.mm.model.c.Gc();
                aVar3.dXy = true;
                aVar3.dXV = true;
                o.Pj().a(bVar.dvS, e_a.uaI, aVar3.Pt());
            }
        }
        aVar.hrH.setOnClickListener(d(aVar2));
        aVar.hrH.setOnLongClickListener(c(aVar2));
        aVar.hrH.setOnTouchListener(((g) aVar2.O(g.class)).ctw());
        aVar.hrH.setTag(new au(bdVar, this.tKy.cwr(), i, null, 0));
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        contextMenu.add(((au) view.getTag()).position, 100, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
        return false;
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        switch (menuItem.getItemId()) {
            case 100:
                com.tencent.mm.model.bd.aU(bdVar.field_msgId);
                return true;
            case 103:
                String str = bdVar.field_content;
                g$a g_a = null;
                if (str != null) {
                    g_a = g$a.J(str, bdVar.field_reserved);
                }
                if (g_a != null) {
                    String str2 = bdVar.field_talker;
                    String str3 = g_a.dxV;
                    String str4 = g_a.dxW;
                    String str5 = g_a.dxX;
                    String str6 = g_a.dxY;
                    String str7 = g_a.dxT;
                    String str8 = g_a.dya;
                    String str9 = g_a.dyb;
                    Context context = aVar.tTq.getContext();
                    String string = aVar.tTq.getMMResources().getString(R.l.chatting_resend_content);
                    String string2 = aVar.tTq.getMMResources().getString(R.l.app_remind);
                    String string3 = aVar.tTq.getMMResources().getString(R.l.chatting_resend_title);
                    String string4 = aVar.tTq.getMMResources().getString(R.l.app_cancel);
                    1 1 = new 1(this, str2, str3, str4, str5, str6, str7, str8, str9, aVar);
                    h.a(context, string, string2, string3, string4, 1, new 2(this));
                }
                return true;
            default:
                return false;
        }
    }

    public final boolean b(View view, a aVar, bd bdVar) {
        String str = bdVar.field_content;
        g$a g_a = null;
        if (str != null) {
            g_a = g$a.J(str, bdVar.field_reserved);
        }
        if (g_a != null) {
            x.i("MicroMsg.ChattingItemAppMsgC2CTo", "click honey pay");
            String queryParameter = Uri.parse(((b) g_a.u(b.class)).dvP).getQueryParameter("cardNo");
            Intent intent = new Intent();
            intent.putExtra("key_is_payer", true);
            intent.putExtra("key_card_no", queryParameter);
            d.b(aVar.tTq.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", intent);
        }
        return true;
    }
}
