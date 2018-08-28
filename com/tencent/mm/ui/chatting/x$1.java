package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.sport.b.d;

class x$1 implements OnClickListener {
    final /* synthetic */ x tLX;

    x$1(x xVar) {
        this.tLX = xVar;
    }

    public final void onClick(View view) {
        d.kB(1);
        s.hg("gh_43f2581f6fd6");
        Intent intent = new Intent();
        intent.putExtra("key_is_latest", true);
        intent.putExtra("rank_id", "#");
        intent.putExtra("key_only_show_latest_rank", true);
        intent.putExtra("app_username", r.gT("gh_43f2581f6fd6"));
        intent.putExtra("device_type", 1);
        com.tencent.mm.bg.d.b(view.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", intent);
    }
}
