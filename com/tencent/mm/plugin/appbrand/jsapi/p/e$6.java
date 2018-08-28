package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity;

class e$6 implements OnMenuItemClickListener {
    final /* synthetic */ e gdb;
    final /* synthetic */ String gdi;
    final /* synthetic */ String gdj;

    e$6(e eVar, String str, String str2) {
        this.gdb = eVar;
        this.gdi = str;
        this.gdj = str2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        e eVar = this.gdb;
        String str = this.gdi;
        String i = e.i(this.gdb);
        String str2 = this.gdj;
        int i2 = this.gdb.gcS;
        int i3 = this.gdb.gcT;
        if (str != null) {
            Intent intent = new Intent();
            intent.setClass(eVar.gcL.getContext(), WebviewScanImageActivity.class);
            intent.putExtra("key_string_for_scan", str);
            intent.putExtra("key_string_for_url", i);
            intent.putExtra("key_string_for_image_url", str2);
            intent.putExtra("key_codetype_for_scan", i2);
            intent.putExtra("key_codeversion_for_scan", i3);
            eVar.gcL.getContext().startActivity(intent);
        }
        return false;
    }
}
