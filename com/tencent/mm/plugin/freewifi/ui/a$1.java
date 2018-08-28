package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import java.util.Date;

class a$1 implements OnClickListener {
    final /* synthetic */ a jml;

    a$1(a aVar) {
        this.jml = aVar;
    }

    public final void onClick(View view) {
        Date date = new Date();
        if (a.aPx() == null || date.getTime() - a.aPx().getTime() >= 1000) {
            a.a(date);
            Intent intent = new Intent();
            intent.putExtra("free_wifi_source", 2);
            intent.addFlags(67108864);
            d.b((Context) a.a(this.jml).get(), "freewifi", ".ui.FreeWifiEntryUI", intent);
        }
    }
}
