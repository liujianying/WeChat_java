package com.tencent.mm.plugin.location.ui.impl;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.location.ui.RemarkUI;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

class a$1 implements OnClickListener {
    final /* synthetic */ a kIc;

    a$1(a aVar) {
        this.kIc = aVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.kIc.activity, RemarkUI.class);
        intent.putExtra("key_nullable", true);
        intent.putExtra("key_value", this.kIc.aZU());
        intent.putExtra("key_hint", this.kIc.getString(h.location_remark_hint));
        intent.putExtra("Kwebmap_locaion", this.kIc.kHP.kCz);
        intent.putExtra("kFavInfoLocalId", this.kIc.activity.getIntent().getLongExtra("kFavInfoLocalId", -1));
        intent.putExtra("kRemark", this.kIc.activity.getIntent().getStringExtra("kRemark"));
        this.kIc.activity.startActivityForResult(intent, Downloads.RECV_BUFFER_SIZE);
    }
}
