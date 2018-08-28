package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.y.g;
import java.util.Map;

public class f$b extends b {
    private a tKy;
    private final int uaV = 1;

    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (z || i != 469762097) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_from_appmsg_c2c_newyear);
        rVar.setTag(new f.a().dA(rVar));
        return rVar;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        g.a J;
        this.tKy = aVar2;
        String str2 = bdVar.field_content;
        if (str2 != null) {
            J = g.a.J(str2, bdVar.field_reserved);
        } else {
            J = null;
        }
        f.a aVar3 = (f.a) aVar;
        if (J != null) {
            aVar3.uaU.setText(bdVar.field_isSend == 1 ? J.dxX : J.dxY);
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
        if (str != null) {
            g.a J = g.a.J(str, bdVar.field_reserved);
            if (!bi.oW(J.dyc)) {
                Intent intent;
                if (J.dyd == 1) {
                    x.d("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", "onItemClick hasplay, skip");
                    intent = new Intent();
                    intent.putExtra("key_native_url", J.dyc);
                    intent.putExtra("key_username", aVar.getTalkerUserName());
                    intent.putExtra("key_image_id", J.dyf);
                    intent.putExtra("key_image_aes_key", J.dyg);
                    intent.putExtra("key_image_length", J.dyh);
                    d.b(aVar.tTq.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", intent);
                } else {
                    x.d("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", "onItemClick play egg emoj");
                    intent = new Intent();
                    intent.putExtra("key_native_url", J.dyc);
                    intent.putExtra("key_username", aVar.getTalkerUserName());
                    intent.putExtra("key_image_id", J.dyf);
                    intent.putExtra("key_image_aes_key", J.dyg);
                    intent.putExtra("key_image_length", J.dyh);
                    d.b(aVar.tTq.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", intent);
                    J.dyd = 1;
                    bdVar.setContent(g.a.a(J, null, null));
                    if (bdVar != null && bdVar.aQm()) {
                        try {
                            str = bdVar.field_content;
                            int indexOf = str.indexOf("<msg>");
                            if (indexOf > 0 && indexOf < str.length()) {
                                str = str.substring(indexOf).trim();
                            }
                            Map z = bl.z(str, "msg");
                            if (z != null && z.size() > 0) {
                                bdVar.er(ay.au(z));
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", e.getMessage());
                        }
                    }
                    au.HU();
                    c.FT().a(bdVar.field_msgId, bdVar);
                }
            }
        }
        return true;
    }
}
