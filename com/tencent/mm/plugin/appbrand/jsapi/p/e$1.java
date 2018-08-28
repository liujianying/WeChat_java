package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.x;
import com.tencent.mm.plugin.webview.ui.tools.widget.k;
import org.json.JSONObject;

class e$1 extends k {
    final /* synthetic */ e gdb;

    e$1(e eVar) {
        this.gdb = eVar;
    }

    public final Bundle g(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("key_webview_container_env", "miniProgram");
        switch (i) {
            case 101:
                bundle.setClassLoader(e.class.getClassLoader());
                d.b(e.f(this.gdb), bundle.getString("open_ui_with_webview_ui_plugin_name"), bundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(bundle.getBundle("open_ui_with_webview_ui_extras")));
                break;
            case x.CTRL_INDEX /*139*/:
                try {
                    e.b(this.gdb).w(new JSONObject(bundle.getString("info")));
                    break;
                } catch (Exception e) {
                    break;
                }
            case b.CTRL_INDEX /*140*/:
                bundle2.putInt("key_webview_preverify_info_scene", 1);
                bundle2.putString("key_webview_preverify_info_source_appid", e.b(this.gdb).getAppId());
                break;
            case 145:
                bundle2.putStringArray("key_webview_apbrand_jsapi_report_args", e.b(this.gdb).getJsApiReportArgs());
                break;
        }
        return bundle2;
    }

    public final void e(String str, final String str2, int i, int i2) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "result: " + str2);
        if (this.gdb.gcU != null && str != null && str.equals(this.gdb.gcU.pUp) && i == 22) {
            if (this.gdb.gcU != null) {
                this.gdb.gcU.bVc();
            }
            this.gdb.gcS = i;
            this.gdb.gcT = i2;
            if (str2 != null && e.g(this.gdb) != null) {
                e.b(this.gdb).runOnUiThread(new Runnable() {
                    public final void run() {
                        e.b(e$1.this.gdb, str2);
                        e.g(e$1.this.gdb).b(e.c(e$1.this.gdb), new OnCreateContextMenuListener() {
                            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                                if (e$1.this.gdb.gcV != null) {
                                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "show webkit menu");
                                    e.a(e$1.this.gdb, contextMenu, e$1.this.gdb.gcV);
                                    e$1.this.gdb.gcV = null;
                                } else if (e$1.this.gdb.gcW != null) {
                                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "show IX5 menu");
                                    e.b(e$1.this.gdb, contextMenu, e$1.this.gdb.gcW);
                                    e$1.this.gdb.gcW = null;
                                }
                            }
                        }, null);
                        e.g(e$1.this.gdb).bEo();
                    }
                });
            }
        }
    }
}
