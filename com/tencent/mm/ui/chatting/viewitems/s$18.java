package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.widget.a.d;
import java.util.Map;

class s$18 implements OnClickListener {
    final /* synthetic */ bd dAs;
    final /* synthetic */ Map qiX;
    final /* synthetic */ boolean ucD;
    final /* synthetic */ s ucn;
    final /* synthetic */ az ucz;

    s$18(s sVar, Map map, boolean z, az azVar, bd bdVar) {
        this.ucn = sVar;
        this.qiX = map;
        this.ucD = z;
        this.ucz = azVar;
        this.dAs = bdVar;
    }

    public final void onClick(View view) {
        String oV = bi.oV((String) this.qiX.get(".msg.fromusername"));
        d dVar = new d(s.b(this.ucn).tTq.getContext(), 1, true);
        if (this.ucD) {
            dVar.i(s.b(this.ucn).tTq.getMMResources().getString(R.l.notify_message_settings_receive_app_brand_msg_title), 3);
        } else {
            dVar.i(s.b(this.ucn).tTq.getMMResources().getString(R.l.notify_message_settings_ban_receive_app_brand_msg_title), 3);
        }
        dVar.ofp = new 1(this);
        dVar.ofq = new 2(this, oV);
        dVar.bXO();
    }
}
