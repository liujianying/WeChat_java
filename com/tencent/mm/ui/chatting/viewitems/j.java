package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.c;
import com.tencent.mm.ui.chatting.c.a;

public final class j {
    static /* synthetic */ boolean a(a aVar, MenuItem menuItem, bd bdVar) {
        switch (menuItem.getItemId()) {
            case 131:
                x.i("MicroMsg.ChattingItemAppMsgImg", "long click go to photo eidt");
                Intent intent = menuItem.getIntent();
                if (intent == null) {
                    x.e("MicroMsg.ChattingItemAppMsgImg", "[LONGCLICK_MENU_PHOTO_EDIT] intent is null!");
                    return true;
                }
                Object obj;
                e eVar;
                e bq;
                String o;
                int intExtra = intent.getIntExtra("img_gallery_width", 0);
                int intExtra2 = intent.getIntExtra("img_gallery_height", 0);
                int[] iArr = new int[]{intent.getIntExtra("img_gallery_left", 0), intent.getIntExtra("img_gallery_top", 0)};
                String str = null;
                if (!s.fq(aVar.getTalkerUserName())) {
                    if (!((c) aVar.O(c.class)).cus()) {
                        obj = null;
                        if (obj != null) {
                            str = bdVar.field_talker;
                        }
                        eVar = null;
                        if (bdVar.field_msgId > 0) {
                            eVar = o.Pf().br(bdVar.field_msgId);
                        }
                        bq = ((eVar != null || eVar.dTK <= 0) && bdVar.field_msgSvrId > 0) ? o.Pf().bq(bdVar.field_msgSvrId) : eVar;
                        o = bq != null ? "" : o.Pf().o(bq.dTL, "", "");
                        if (bq != null || bq.status == -1 || bdVar.field_status == 5) {
                            x.e("MicroMsg.ChattingItemAppMsgImg", "raw img not get successfully ,msgId:%s", new Object[]{Long.valueOf(bdVar.field_msgId)});
                        } else {
                            x.i("MicroMsg.ChattingItemAppMsgImg", "[LONGCLICK_MENU_PHOTO_EDIT] msgId:%s imgFullPath:%s", new Object[]{Long.valueOf(bdVar.field_msgId), o});
                            z.c.a(aVar, bdVar, bdVar.field_msgId, bdVar.field_msgSvrId, bdVar.field_talker, str, iArr, intExtra, intExtra2, true);
                        }
                        return true;
                    }
                }
                obj = 1;
                if (obj != null) {
                    str = bdVar.field_talker;
                }
                eVar = null;
                if (bdVar.field_msgId > 0) {
                    eVar = o.Pf().br(bdVar.field_msgId);
                }
                if (eVar != null) {
                    break;
                }
                if (bq != null) {
                }
                if (bq != null) {
                    break;
                }
                x.e("MicroMsg.ChattingItemAppMsgImg", "raw img not get successfully ,msgId:%s", new Object[]{Long.valueOf(bdVar.field_msgId)});
                return true;
            default:
                return false;
        }
    }
}
