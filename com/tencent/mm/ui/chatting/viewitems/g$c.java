package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.t.m;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.y.g;
import java.net.URLDecoder;

public class g$c extends b implements m {
    private a tKy;

    public final boolean bba() {
        return true;
    }

    public final boolean aq(int i, boolean z) {
        if (z && i == 503316529) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_to_text_c2c);
        rVar.setTag(new g.a().q(rVar, false));
        return rVar;
    }

    private static String aaB(String str) {
        try {
            g.a gp = g.a.gp(str);
            if (gp != null) {
                return URLDecoder.decode(gp.content, "UTF-8");
            }
        } catch (Exception e) {
            x.e("MicroMsg.ChattingItemTextTo", "getMsgContent error: %s", new Object[]{e.getMessage()});
        }
        return "";
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        this.tKy = aVar2;
        g.a aVar3 = (g.a) aVar;
        if (cxN()) {
            if (aVar3.mgA != null) {
                aVar3.mgA.setVisibility(8);
            }
            if (bdVar.field_status == 1 || bdVar.field_status == 5) {
                if (aVar3.uai != null) {
                    aVar3.uai.setVisibility(8);
                }
                aVar3.uaW.setBackgroundResource(R.g.chatto_bg_alpha);
                bdVar.tbz = true;
            } else {
                aVar3.uaW.setBackgroundResource(R.g.chatto_bg);
                if (aVar3.uai != null) {
                    if (a((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class), bdVar.field_msgId)) {
                        if (bdVar.tbz) {
                            Animation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                            alphaAnimation.setDuration(300);
                            aVar3.uaW.startAnimation(alphaAnimation);
                            bdVar.tbz = false;
                        }
                        aVar3.uai.setVisibility(0);
                    } else {
                        aVar3.uai.setVisibility(8);
                    }
                }
            }
        } else if (aVar3.mgA != null) {
            aVar3.mgA.setVisibility(bdVar.field_status >= 2 ? 8 : 0);
        }
        CharSequence aaB = aaB(bdVar.field_content);
        if (bi.oW(aaB)) {
            x.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", new Object[]{Long.valueOf(bdVar.field_msgId), Long.valueOf(bdVar.field_msgSvrId)});
        }
        aVar3.uaW.setMinWidth(0);
        aVar3.uaW.setText(aaB);
        MMTextView mMTextView = aVar3.uaW;
        int type = bdVar.getType();
        String talkerUserName = aVar2.getTalkerUserName();
        if (type != 301989937) {
            j.a(mMTextView, talkerUserName);
        }
        mMTextView.getText();
        aVar3.uaW.setTag(au.b(bdVar, aVar2.cwr(), i));
        aVar3.uaW.setOnLongClickListener(c(aVar2));
        aVar3.uaW.setOnDoubleClickLitsener(((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctv());
        a(i, aVar3, bdVar, aVar2.cwp(), aVar2.cwr(), aVar2, this);
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        contextMenu.add(((au) view.getTag()).position, 100, 0, view.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
        return false;
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        return false;
    }

    public final boolean b(View view, a aVar, bd bdVar) {
        return false;
    }

    public final void a(a aVar, bd bdVar) {
        if (bdVar.aQm()) {
            l.ae(bdVar);
            com.tencent.mm.model.bd.aU(bdVar.field_msgId);
            aVar.lT(true);
        }
    }
}
