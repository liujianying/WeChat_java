package com.tencent.mm.plugin.account.friend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;

class FindMContactInviteUI$7 implements OnClickListener {
    final /* synthetic */ FindMContactInviteUI eLY;

    FindMContactInviteUI$7(FindMContactInviteUI findMContactInviteUI) {
        this.eLY = findMContactInviteUI;
    }

    public final void onClick(View view) {
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(a.DA()).append(",").append(this.eLY.getClass().getName()).append(",R300_400_AddAllButton,");
        g.Eg();
        com.tencent.mm.plugin.c.a.pV(stringBuilder.append(a.gd("R300_300_AddAllButton")).append(",3").toString());
        if (FindMContactInviteUI.d(this.eLY) == 2) {
            FindMContactInviteUI.b(this.eLY).ci(true);
            FindMContactInviteUI.b(this.eLY).notifyDataSetChanged();
            FindMContactInviteUI.e(this.eLY).setVisibility(8);
            if (FindMContactInviteUI.f(this.eLY) != null) {
                FindMContactInviteUI.f(this.eLY).setVisibility(0);
            }
        } else if (FindMContactInviteUI.d(this.eLY) == 1) {
            FindMContactInviteUI.b(this.eLY).ci(true);
            FindMContactInviteUI.b(this.eLY).notifyDataSetChanged();
            FindMContactInviteUI.h(this.eLY);
        } else {
            FindMContactInviteUI.b(this.eLY).ci(true);
            FindMContactInviteUI.b(this.eLY).notifyDataSetChanged();
            FindMContactInviteUI.e(this.eLY).setVisibility(8);
            if (FindMContactInviteUI.f(this.eLY) != null) {
                FindMContactInviteUI.f(this.eLY).setVisibility(0);
            }
        }
    }
}
