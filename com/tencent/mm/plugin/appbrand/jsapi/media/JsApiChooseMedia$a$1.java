package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a;
import com.tencent.mm.plugin.appbrand.s.j;

class JsApiChooseMedia$a$1 implements OnCreateContextMenuListener {
    final /* synthetic */ a fUI;

    JsApiChooseMedia$a$1(a aVar) {
        this.fUI = aVar;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 1, 0, a.a(this.fUI).getString(j.app_field_mmsight));
        contextMenu.add(0, 2, 1, a.b(this.fUI).getString(j.app_field_select_new_pic));
    }
}
