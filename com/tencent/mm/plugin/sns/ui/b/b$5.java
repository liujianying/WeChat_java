package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.sdk.b.a;

class b$5 extends c {
    final /* synthetic */ b olf;

    b$5(b bVar) {
        this.olf = bVar;
    }

    public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (view != null && (view.getTag() instanceof ap)) {
            int width;
            int height;
            String str = ((ap) view.getTag()).bNH;
            n Nl = af.byo().Nl(str);
            if (d.QS("favorite")) {
                contextMenu.add(0, 2, 0, this.olf.activity.getString(j.plugin_favorite_opt));
                dj djVar = new dj();
                djVar.bLf.bKW = str;
                a.sFg.m(djVar);
                if (djVar.bLg.bKE) {
                    contextMenu.add(0, 18, 0, this.olf.activity.getString(j.app_open));
                }
            }
            com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, Nl);
            MenuItem add = contextMenu.add(0, 21, 0, this.olf.activity.getString(j.sns_edit_image));
            int[] iArr = new int[2];
            if (view != null) {
                width = view.getWidth();
                height = view.getHeight();
                view.getLocationInWindow(iArr);
            } else {
                height = 0;
                width = 0;
            }
            Intent intent = new Intent();
            intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
            add.setIntent(intent);
        }
    }

    public final boolean cO(View view) {
        if (!(view.getTag() instanceof ap)) {
            return false;
        }
        String str = ((ap) view.getTag()).bNH;
        this.olf.okv.a(view, str, af.byo().Nl(str).bAJ());
        return true;
    }
}
