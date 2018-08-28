package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.base.sortview.a.b;

public final class e extends a {
    private static b hoi;
    long hon;
    String hoo;
    String hpK;
    int tH;

    public e(long j, int i, String str) {
        super(2, null);
        this.hon = j;
        this.hoo = str;
        this.tH = i;
    }

    public final b auQ() {
        if (hoi == null) {
            hoi = new b() {
                public final boolean a(Context context, a aVar, Object... objArr) {
                    if (!(context == null || aVar == null)) {
                        int i = 0;
                        if (objArr != null && objArr.length >= 2 && (objArr[1] instanceof Integer)) {
                            i = ((Integer) objArr[1]).intValue();
                        }
                        e eVar = (e) aVar;
                        Intent intent = new Intent(context, BizSearchDetailPageUI.class);
                        intent.putExtra("keyword", eVar.hoo);
                        intent.putExtra("businessType", eVar.hon);
                        intent.putExtra("offset", eVar.tH);
                        intent.putExtra("showEditText", true);
                        intent.putExtra("fromScene", i);
                        context.startActivity(intent);
                    }
                    return true;
                }

                public final View b(Context context, View view) {
                    if (view == null) {
                        return View.inflate(context, com.tencent.mm.plugin.brandservice.b.e.search_result_item_more, null);
                    }
                    return view;
                }

                public final void a(Context context, a.a aVar, a aVar2) {
                    if (context == null || aVar == null || aVar2 == null) {
                        x.e("MicroMsg.ReadMoreBtnDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
                    } else if (!(aVar instanceof a)) {
                        x.e("MicroMsg.ReadMoreBtnDataItem", "The ViewHolder is not a instance of MoreBtnViewHolder.");
                    } else if (aVar2 instanceof e) {
                        ((a) aVar).gmo.setText(((e) aVar2).hpK);
                    } else {
                        x.e("MicroMsg.ReadMoreBtnDataItem", "The DataItem is not a instance of MoreBtnDataItem.");
                    }
                }

                public final void a(View view, a.a aVar) {
                    if (view != null && aVar != null && (aVar instanceof a)) {
                        ((a) aVar).gmo = (TextView) view.findViewById(d.tipsTV);
                    }
                }
            };
        }
        return hoi;
    }

    public final a.a auR() {
        return new a();
    }

    public final void a(Context context, a.a aVar, Object... objArr) {
        this.hpK = "";
    }
}
