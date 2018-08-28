package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.widget.a.d;
import java.util.Map;

final class s$a implements OnClickListener {
    final /* synthetic */ s ucn;

    private s$a(s sVar) {
        this.ucn = sVar;
    }

    /* synthetic */ s$a(s sVar, byte b) {
        this(sVar);
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof bd) {
            bd bdVar = (bd) view.getTag();
            if (bdVar == null) {
                x.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, msg null.");
                return;
            }
            Map z = bl.z(bdVar.field_content, "msg");
            if (z == null || z.size() == 0) {
                x.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, values null.");
                return;
            }
            String oV = bi.oV((String) z.get(".msg.fromusername"));
            d dVar = new d(view.getContext(), 1, false);
            dVar.ofp = new 1(this, view);
            dVar.ofq = new 2(this, view, bdVar, oV);
            dVar.bXO();
            return;
        }
        x.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, tag not msg.");
    }
}
