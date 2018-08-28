package com.tencent.mm.ui.chatting.viewitems;

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
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.y.b;
import com.tencent.mm.y.g;

public class e$b extends b {
    private a tKy;

    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (z || i != 536870961) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_from_appmsg_c2c);
        rVar.setTag(new e.a().dz(rVar));
        return rVar;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        g.a J;
        this.tKy = aVar2;
        e.a aVar3 = (e.a) aVar;
        String str2 = bdVar.field_content;
        if (str2 != null) {
            J = g.a.J(str2, bdVar.field_reserved);
        } else {
            J = null;
        }
        if (J != null) {
            aVar3.hrH.setBackgroundResource(R.g.honey_pay_chatfrom);
            aVar3.uaJ.setTypeface(Typeface.defaultFromStyle(0));
            aVar3.hrH.setPadding(aVar2.tTq.getContext().getResources().getDimensionPixelSize(R.f.chattingBubblepadding), 0, aVar2.tTq.getContext().getResources().getDimensionPixelSize(R.f.SmallPadding), 0);
            b bVar = (b) J.u(b.class);
            CharSequence charSequence = bdVar.field_isSend == 1 ? bVar.dvY : bVar.dvX;
            if (bi.oW(charSequence)) {
                charSequence = J.description;
                aVar3.uaJ.setSingleLine(false);
                aVar3.uaJ.setMaxLines(3);
            } else {
                aVar3.uaJ.setSingleLine(true);
            }
            aVar3.uaJ.setText(j.a(aVar2.tTq.getContext(), charSequence, aVar3.uaM));
            aVar3.uaJ.setTextSize(0, (float) aVar3.uaM);
            if (!bi.oW(bVar.dvZ)) {
                aVar3.uaJ.setTextColor(Color.parseColor(bVar.dvZ));
            }
            aVar3.uaK.setText(bdVar.field_isSend == 1 ? bVar.dwc : bVar.dwd);
            if (!bi.oW(bVar.dwe)) {
                aVar3.uaK.setTextColor(Color.parseColor(bVar.dwe));
            }
            aVar3.uaL.setText(bdVar.field_isSend == 1 ? bVar.dwa : bVar.dwb);
            aVar3.uaI.setImageBitmap(null);
            if (!bi.oW(bVar.dvS)) {
                c.a aVar4 = new c.a();
                au.HU();
                aVar4.dXB = com.tencent.mm.model.c.Gc();
                aVar4.dXy = true;
                aVar4.dXV = true;
                o.Pj().a(bVar.dvS, aVar3.uaI, aVar4.Pt());
            }
        }
        aVar.hrH.setOnClickListener(d(aVar2));
        aVar.hrH.setOnLongClickListener(c(aVar2));
        aVar.hrH.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
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
            default:
                return false;
        }
    }

    public final boolean b(View view, a aVar, bd bdVar) {
        String str = bdVar.field_content;
        g.a aVar2 = null;
        if (str != null) {
            aVar2 = g.a.J(str, bdVar.field_reserved);
        }
        if (aVar2 != null) {
            x.i("MicroMsg.ChattingItemAppMsgC2CFrom", "click honey pay");
            String queryParameter = Uri.parse(((b) aVar2.u(b.class)).dvR).getQueryParameter("cardNo");
            Intent intent = new Intent();
            intent.putExtra("key_is_payer", false);
            intent.putExtra("key_card_no", queryParameter);
            d.b(aVar.tTq.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", intent);
        }
        return true;
    }
}
