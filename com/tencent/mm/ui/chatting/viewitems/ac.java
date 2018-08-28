package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ar.r;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.u;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.ae.b;

final class ac implements a {
    ac() {
    }

    public final void b(b$a b_a, int i, a aVar, bd bdVar) {
        final b bVar = (b) b_a;
        final com.tencent.mm.ap.a.b bVar2 = (com.tencent.mm.ap.a.b) aVar.O(u.class);
        int color = bVar.ucQ.getContext().getResources().getColor(R.e.link_color);
        int color2 = bVar.ucQ.getContext().getResources().getColor(R.e.link_color_pressed);
        final com.tencent.mm.ap.a cmI = bdVar.cmI();
        if (cmI == null) {
            bVar.jEz.setVisibility(8);
        } else {
            int i2;
            CharSequence charSequence;
            bVar.jEz.setVisibility(0);
            bVar.ucQ.setText(j.a(bVar.ucQ.getContext(), bi.oV(cmI.ebF), bVar.ucQ.getTextSize()));
            bVar.ucQ.setMovementMethod(new ay());
            Object charSequence2;
            if (cmI.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication") || cmI.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")) {
                color = bVar.ucQ.getContext().getResources().getColor(R.e.green_text_color);
                color2 = bVar.ucQ.getContext().getResources().getColor(R.e.btn_green_color_pressed);
                if (bdVar.cmC()) {
                    color = bVar.ucQ.getContext().getResources().getColor(R.e.green_text_color);
                    color2 = bVar.ucQ.getContext().getResources().getColor(R.e.btn_green_color_pressed);
                    i2 = 0;
                    charSequence2 = Factory.getInstance().newSpannable(bVar.ucQ.getText());
                } else {
                    Spannable newSpannable = Factory.getInstance().newSpannable("    " + bVar.ucQ.getText());
                    Drawable drawable = bVar.ucQ.getContext().getResources().getDrawable(R.k.invite_sysmsg_icon);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    com.tencent.mm.ui.widget.a aVar2 = new com.tencent.mm.ui.widget.a(drawable);
                    aVar2.uFY = (int) (((((float) drawable.getIntrinsicHeight()) - bVar.ucQ.getTextSize()) + ((float) com.tencent.mm.bp.a.fromDPToPix(bVar.ucQ.getContext(), 2))) / 2.0f);
                    newSpannable.setSpan(aVar2, 0, 3, 33);
                    i2 = 4;
                    charSequence2 = newSpannable;
                }
            } else {
                i2 = 0;
                charSequence2 = Factory.getInstance().newSpannable(bVar.ucQ.getText());
            }
            for (int i3 = 0; i3 < cmI.ebH.size(); i3++) {
                a aVar3 = new a();
                final bd bdVar2 = bdVar;
                final int i4 = i;
                aVar3.udA = new bc(color, color2) {
                    public final void onClick(View view) {
                        x.i("MicroMsg.ChattingItemNewXmlSysImpl", "[onClick] pBaseNewXmlMsg:%s", new Object[]{cmI});
                        bVar2.a(bVar.jEz, bdVar2, cmI, i3);
                    }
                };
                aVar3.start = ((Integer) cmI.ebI.get(i3)).intValue();
                aVar3.end = ((Integer) cmI.ebJ.get(i3)).intValue();
                charSequence2.setSpan(aVar3.udA, aVar3.start + i2, aVar3.end + i2, 33);
            }
            bVar.ucQ.setText(charSequence2);
            bVar.ucQ.setOnClickListener(new 2(this));
        }
        com.tencent.mm.ar.a mw = r.Qq().mw(aVar.getTalkerUserName());
        au.HU();
        int intValue = ((Integer) c.DT().get(12311, Integer.valueOf(-2))).intValue();
        if ((mw == null || mw.ecv == -2) && (mw != null || intValue == -2)) {
            bVar.ucQ.setTextColor(aVar.tTq.getContext().getResources().getColor(R.e.white_text_color));
            bVar.ucQ.setBackground(aVar.tTq.getContext().getResources().getDrawable(R.g.chat_tips_bg));
        } else {
            bVar.ucQ.setTextColor(aVar.tTq.getContext().getResources().getColor(R.e.black_text_color));
            bVar.ucQ.setBackground(aVar.tTq.getContext().getResources().getDrawable(R.g.chat_tips_light_bg));
        }
        bVar.ucQ.invalidate();
    }
}
