package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.base.sortview.a.b;

class d$1 extends b {
    final /* synthetic */ d hpg;

    d$1(d dVar) {
        this.hpg = dVar;
    }

    public final boolean a(Context context, a aVar, Object... objArr) {
        return true;
    }

    public final View b(Context context, View view) {
        if (view == null) {
            return View.inflate(context, e.search_result_item_catalog, null);
        }
        return view;
    }

    public final void a(Context context, a.a aVar, a aVar2) {
        if (context == null || aVar == null || aVar2 == null) {
            x.e("MicroMsg.CatalogDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
        } else if (!(aVar instanceof d$a)) {
            x.e("MicroMsg.CatalogDataItem", "The ViewHolder is not a instance of CatalogViewHolder.");
        } else if (aVar2 instanceof d) {
            com.tencent.mm.plugin.brandservice.b.a.b(((d$a) aVar).hoc, ((d) aVar2).hoj);
        } else {
            x.e("MicroMsg.CatalogDataItem", "The DataItem is not a instance of CatalogDataItem.");
        }
    }

    public final void a(View view, a.a aVar) {
        if (view != null && aVar != null && (aVar instanceof d$a)) {
            ((d$a) aVar).hoc = (TextView) view.findViewById(d.catalogTV);
        }
    }
}
