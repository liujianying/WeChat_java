package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.exdevice.f.b.a.e;

class ExdeviceLikeUI$4 implements OnItemClickListener {
    final /* synthetic */ ExdeviceLikeUI iDa;

    ExdeviceLikeUI$4(ExdeviceLikeUI exdeviceLikeUI) {
        this.iDa = exdeviceLikeUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar = (e) ExdeviceLikeUI.c(this.iDa).get(i);
        Intent intent = new Intent();
        intent.putExtra("rank_id", eVar.field_rankID);
        intent.putExtra("device_type", 1);
        intent.putExtra("locate_to_username", eVar.field_username);
        intent.putExtra("app_username", r.gT("gh_43f2581f6fd6"));
        d.b(this.iDa, "exdevice", ".ui.ExdeviceRankInfoUI", intent);
    }
}
