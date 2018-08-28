package com.tencent.mm.ui.chatting.b;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;
import com.tencent.mm.ac.f;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.k;
import com.tencent.wework.api.WWAPIFactory;

class j$5 implements OnClickListener {
    final /* synthetic */ j tOS;

    j$5(j jVar) {
        this.tOS = jVar;
    }

    public final void onClick(View view) {
        if (((g) this.tOS.bAG.O(g.class)).boX() == 0) {
            x.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
        } else if ((!s.hf(j.e(this.tOS).field_username) || f.eZ(j.e(this.tOS).field_username)) && !s.hP(j.e(this.tOS).field_username)) {
            j.g(this.tOS).b(view, new OnCreateContextMenuListener() {
                public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                    contextMenu.add(0, 0, 0, R.l.multi_select_send_normal);
                    contextMenu.add(0, 1, 1, R.l.multi_select_send_record);
                    if (WWAPIFactory.ii(j$5.this.tOS.bAG.tTq.getContext()).cIf()) {
                        contextMenu.add(0, 2, 2, j$5.this.tOS.bAG.tTq.getContext().getString(R.l.multi_select_send_wework, new Object[]{WWAPIFactory.ii(j$5.this.tOS.bAG.tTq.getContext()).cIg()}));
                    }
                }
            }, new 2(this));
        } else {
            j.a(this.tOS, true);
            k.a(this.tOS.bAG.tTq.getContext(), j.c(this.tOS), j.d(this.tOS), j.e(this.tOS).field_username, this.tOS);
        }
    }
}
