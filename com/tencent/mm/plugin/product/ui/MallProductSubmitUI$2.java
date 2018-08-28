package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.product.b.m;
import java.util.ArrayList;
import java.util.Iterator;

class MallProductSubmitUI$2 implements OnItemClickListener {
    final /* synthetic */ MallProductSubmitUI lTQ;

    MallProductSubmitUI$2(MallProductSubmitUI mallProductSubmitUI) {
        this.lTQ = mallProductSubmitUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        b bVar = (b) view.getTag();
        switch (bVar.type) {
            case 1:
                if (bVar.lSn instanceof String) {
                    MallProductSubmitUI.b(this.lTQ).lQU = (String) bVar.lSn;
                    break;
                }
                break;
            case 2:
                m mVar = MallProductSubmitUI.b(this.lTQ).lQL;
                if (mVar.lRp.lRD != null && mVar.lRp.lRD.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = mVar.lRp.lRD.iterator();
                    while (it.hasNext()) {
                        arrayList.add((String) it.next());
                    }
                    bVar.lSn = arrayList;
                    break;
                }
        }
        MallProductSubmitUI.c(this.lTQ).a(this.lTQ, view, i);
    }
}
