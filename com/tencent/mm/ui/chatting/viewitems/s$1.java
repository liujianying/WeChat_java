package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.widget.a.d;
import java.util.Map;

class s$1 implements OnClickListener {
    final /* synthetic */ s ucn;

    s$1(s sVar) {
        this.ucn = sVar;
    }

    public final void onClick(View view) {
        bd bdVar = (bd) view.getTag(R.h.new_dyeing_template_more_v);
        if (bdVar == null) {
            x.w("MicroMsg.ChattingItemDyeingTemplate", "on more view click, but msg is null.");
            return;
        }
        Map z = bl.z(bdVar.field_content, "msg");
        if (z != null && z.size() != 0) {
            String oV = bi.oV((String) z.get(".msg.fromusername"));
            int p = bi.p(z.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), -1);
            int p2 = bi.p(z.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_version"), -1);
            d dVar = new d(view.getContext(), 1, false);
            dVar.ofp = new 1(this, view);
            dVar.ofq = new 2(this, view, oV, p, p2, bdVar);
            dVar.bXO();
        }
    }
}
