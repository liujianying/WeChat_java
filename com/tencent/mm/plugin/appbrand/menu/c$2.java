package com.tencent.mm.plugin.appbrand.menu;

import a.a;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.ui.base.n.d;
import java.io.File;

class c$2 implements d {
    final /* synthetic */ p fIY;
    final /* synthetic */ c gjl;
    final /* synthetic */ Context val$context;

    c$2(c cVar, p pVar, Context context) {
        this.gjl = cVar;
        this.fIY = pVar;
        this.val$context = context;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                t.i(this.fIY.fdO);
                return;
            case 2:
                File rb = this.fIY.fdO.fcw.rb("wxfile://usr/");
                Toast.makeText(this.val$context, this.val$context.getString(j.app_brand_actionsheet_debug_entrance_nfs_path_clipborad_tip, new Object[]{rb.getAbsolutePath()}), 0).show();
                ((ClipboardManager) this.val$context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", rb.getAbsolutePath()));
                return;
            case 3:
                ((ClipboardManager) this.val$context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", this.fIY.mAppId));
                Toast.makeText(this.val$context, this.val$context.getString(j.app_brand_actionsheet_debug_entrance_appid_clipboard_tip, new Object[]{this.fIY.mAppId}), 1).show();
                return;
            case 4:
                this.fIY.getContentView().postDelayed(new Runnable() {
                    public final void run() {
                        try {
                            if (c$2.this.fIY.gns instanceof com.tencent.mm.plugin.appbrand.page.t) {
                                a.cJ(c$2.this.fIY.gns.getX5WebViewExtension()).y("notifyMemoryPressure", new Object[]{Integer.valueOf(80)});
                            }
                        } catch (Exception e) {
                        }
                    }
                }, 1000);
                return;
            default:
                return;
        }
    }
}
