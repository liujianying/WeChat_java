package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.ti;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.y.c;
import com.tencent.mm.y.g;

public class d$c extends b {
    private a tKy;

    public final boolean bba() {
        return true;
    }

    public final boolean aq(int i, boolean z) {
        if (z && i == 436207665) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_to_appmsg_c2c);
        rVar.setTag(new d$a().dy(rVar));
        return rVar;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        g.a J;
        this.tKy = aVar2;
        d$a d_a = (d$a) aVar;
        String str2 = bdVar.field_content;
        if (str2 != null) {
            J = g.a.J(str2, bdVar.field_reserved);
        } else {
            J = null;
        }
        if (J != null) {
            TextView textView;
            int a;
            int i2;
            boolean equals = "1001".equals(J.dyb);
            ti tiVar = new ti();
            if (!(bi.oW(J.dyc) || equals)) {
                tiVar.ceP.ceR = J.dyc;
                com.tencent.mm.sdk.b.a.sFg.m(tiVar);
            }
            d$a.P(d_a.hrH, d_a.uau);
            if ("1001".equals(J.dyb)) {
                d_a.hrH.setBackgroundResource(com.tencent.mm.ui.chatting.g.c(J, bdVar.field_isSend == 1));
                d_a.uaJ.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                d_a.hrH.setBackgroundResource(com.tencent.mm.ui.chatting.g.s(tiVar.ceQ.ceS, tiVar.ceQ.ceT, bdVar.field_isSend == 1));
                d_a.uaJ.setTypeface(Typeface.defaultFromStyle(0));
                d_a.uaM = d_a.uaM > d_a.maxSize ? d_a.maxSize : d_a.uaM;
            }
            int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(aVar2.tTq.getContext(), 13);
            int dimensionPixelSize = aVar2.tTq.getContext().getResources().getDimensionPixelSize(R.f.MiddlePadding);
            d_a.hrH.setPadding(dimensionPixelSize, 0, fromDPToPix, 0);
            CharSequence charSequence = bdVar.field_isSend == 1 ? J.dxW : J.dxV;
            if (bi.oW(charSequence)) {
                charSequence = J.description;
                d_a.uaJ.setSingleLine(false);
                d_a.uaJ.setMaxLines(3);
            } else {
                d_a.uaJ.setSingleLine(true);
            }
            d_a.uaJ.setText(j.a(aVar2.tTq.getContext(), charSequence, d_a.uaM));
            d_a.uaJ.setTextSize(0, (float) d_a.uaM);
            if (equals) {
                textView = d_a.uaK;
                charSequence = j.a(aVar2.tTq.getContext(), com.tencent.mm.ui.chatting.g.b(J, bdVar.field_isSend == 1), d_a.uaK.getTextSize());
            } else if (bi.oW(J.dyc)) {
                textView = d_a.uaK;
                charSequence = bdVar.field_isSend == 1 ? J.dxX : J.dxY;
            } else {
                textView = d_a.uaK;
                charSequence = com.tencent.mm.ui.chatting.g.a(tiVar.ceQ.ceS, tiVar.ceQ.ceT, bdVar.field_isSend == 1, J);
            }
            textView.setText(charSequence);
            charSequence = J.dxZ;
            if (bi.oW(charSequence)) {
                charSequence = J.title;
            }
            d_a.uaL.setText(charSequence);
            c cVar = (c) J.u(c.class);
            int i3 = 0;
            if (!bi.oW(cVar.dwg)) {
                o.Pj().a("", d_a.uaI);
                i3 = aVar2.tTq.getMMResources().getIdentifier(cVar.dwg, "drawable", ad.getPackageName());
                if (i3 <= 0) {
                    i3 = aVar2.tTq.getMMResources().getIdentifier(cVar.dwg, "raw", ad.getPackageName());
                }
            }
            x.v("MicroMsg.ChattingItemAppMsgC2CTo", "c2c localResId: %s", new Object[]{Integer.valueOf(i3)});
            if (i3 > 0) {
                x.v("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from localRes");
                d_a.uaI.setImageResource(i3);
            }
            if ("1001".equals(J.dyb)) {
                a = com.tencent.mm.ui.chatting.g.a(J, bdVar.field_isSend == 1);
            } else {
                a = com.tencent.mm.ui.chatting.g.t(tiVar.ceQ.ceS, tiVar.ceQ.ceT, bdVar.field_isSend == 1);
            }
            if (a > 0) {
                x.i("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconRes");
                d_a.uaI.setImageResource(a);
            } else if (i3 <= 0) {
                x.i("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconUrl");
                str2 = J.dxU;
                if (bi.oW(str2)) {
                    str2 = J.thumburl;
                }
                d_a.uaI.setImageBitmap(null);
                if (!bi.oW(str2)) {
                    com.tencent.mm.ak.a.a.c.a aVar3 = new com.tencent.mm.ak.a.a.c.a();
                    au.HU();
                    aVar3.dXB = com.tencent.mm.model.c.Gc();
                    aVar3.dXy = true;
                    aVar3.dXV = true;
                    o.Pj().a(str2, d_a.uaI, aVar3.Pt());
                }
            }
            if (bi.oW(cVar.dwh)) {
                i2 = -1;
            } else {
                i2 = aVar2.tTq.getMMResources().getIdentifier(cVar.dwh, "drawable", ad.getPackageName());
            }
            x.i("MicroMsg.ChattingItemAppMsgC2CTo", "backgroundResId: %s", new Object[]{Integer.valueOf(i2)});
            if (i2 > 0) {
                d_a.hrH.setBackgroundResource(i2);
                d_a.hrH.setPadding(dimensionPixelSize, 0, fromDPToPix, 0);
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
            case 103:
                String str = bdVar.field_content;
                g.a aVar2 = null;
                if (str != null) {
                    aVar2 = g.a.J(str, bdVar.field_reserved);
                }
                if (aVar2 != null) {
                    String str2 = bdVar.field_talker;
                    String str3 = aVar2.dxV;
                    String str4 = aVar2.dxW;
                    String str5 = aVar2.dxX;
                    String str6 = aVar2.dxY;
                    String str7 = aVar2.dxT;
                    String str8 = aVar2.dya;
                    String str9 = aVar2.dyb;
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
        g.a J;
        String str = bdVar.field_content;
        if (str != null) {
            J = g.a.J(str, bdVar.field_reserved);
        } else {
            J = null;
        }
        if (J != null) {
            String str2 = bi.oW(J.dxT) ? J.url : J.dxT;
            x.i("MicroMsg.ChattingItemAppMsgC2CTo", "url==null: %s, billNo==null: %s", new Object[]{Boolean.valueOf(bi.oW(str2)), Boolean.valueOf(bi.oW(J.dyk))});
            Intent intent;
            Intent intent2;
            if (bi.oW(J.dyc)) {
                if (!bi.oW(J.dyk)) {
                    x.i("MicroMsg.ChattingItemAppMsgC2CTo", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", new Object[]{J.dyk, Integer.valueOf(J.dyl), J.bSS});
                    intent = new Intent();
                    intent.putExtra("bill_no", J.dyk);
                    intent.putExtra("launcher_user_name", J.bSS);
                    intent.putExtra("enter_scene", 1);
                    intent.putExtra("chatroom", aVar.getTalkerUserName());
                    d.b(aVar.tTq.getContext(), "aa", ".ui.PaylistAAUI", intent);
                    com.tencent.mm.plugin.report.service.h.mEJ.h(13721, new Object[]{Integer.valueOf(4), Integer.valueOf(1)});
                } else if (!(bi.oW(str2) || bi.oW(str2))) {
                    intent2 = new Intent();
                    intent2.putExtra("rawUrl", str2);
                    d.b(aVar.tTq.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                }
            } else if (J.dyc.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
                intent = new Intent();
                intent.putExtra("key_way", 1);
                intent.putExtra("key_native_url", J.dyc);
                intent.putExtra("key_username", aVar.getTalkerUserName());
                intent.putExtra("key_static_from_scene", 100002);
                d.b(aVar.tTq.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent);
            } else if (J.dyc.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                int i;
                Intent intent3 = new Intent();
                String str3 = "key_way";
                if (aVar.cwr()) {
                    i = 0;
                } else {
                    i = 1;
                }
                intent3.putExtra(str3, i);
                intent3.putExtra("key_native_url", J.dyc);
                intent3.putExtra("key_username", aVar.getTalkerUserName());
                d.b(aVar.tTq.getContext(), "luckymoney", ".ui.LuckyMoneyReceiveUI", intent3);
            } else {
                x.i("MicroMsg.ChattingItemAppMsgC2CTo", "native url not match:" + J.dyc + ", go webview:" + str2);
                if (!bi.oW(str2)) {
                    intent2 = new Intent();
                    intent2.putExtra("rawUrl", str2);
                    d.b(aVar.tTq.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                }
            }
        }
        return true;
    }
}
