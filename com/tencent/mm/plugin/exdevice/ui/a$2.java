package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class a$2 implements OnClickListener {
    final /* synthetic */ String dMs;
    final /* synthetic */ a iDD;

    a$2(a aVar, String str) {
        this.iDD = aVar;
        this.dMs = str;
    }

    public final void onClick(View view) {
        Context b = a.b(this.iDD);
        Intent intent = new Intent(b, ExdeviceProfileUI.class);
        intent.putExtra("username", this.dMs);
        b.startActivity(intent);
    }
}
