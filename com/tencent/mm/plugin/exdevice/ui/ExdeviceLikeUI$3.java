package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.exdevice.f.b.a.e;

class ExdeviceLikeUI$3 implements OnItemClickListener {
    final /* synthetic */ ExdeviceLikeUI iDa;

    ExdeviceLikeUI$3(ExdeviceLikeUI exdeviceLikeUI) {
        this.iDa = exdeviceLikeUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar = (e) ExdeviceLikeUI.b(this.iDa).getItem(i);
        Intent intent = new Intent(this.iDa, ExdeviceRankInfoUI.class);
        intent.putExtra("app_username", eVar.field_appusername);
        intent.putExtra("rank_id", eVar.field_rankID);
        intent.putExtra("device_type", 1);
        this.iDa.startActivity(intent);
        this.iDa.finish();
    }
}
