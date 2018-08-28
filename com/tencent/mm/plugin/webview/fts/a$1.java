package com.tencent.mm.plugin.webview.fts;

import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.ui.base.n$a;
import java.util.List;

class a$1 implements n$a {
    final /* synthetic */ List iYC;
    final /* synthetic */ a pNN;

    public a$1(a aVar, List list) {
        this.pNN = aVar;
        this.iYC = list;
    }

    public final void a(ImageView imageView, MenuItem menuItem) {
        a.Pq().a(((aa) this.iYC.get(menuItem.getItemId())).iconUrl, imageView, a.a(this.pNN));
    }
}
