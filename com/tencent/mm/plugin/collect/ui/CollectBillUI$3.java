package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.collect.b.a;
import com.tencent.mm.sdk.platformtools.x;

class CollectBillUI$3 implements OnItemClickListener {
    final /* synthetic */ CollectBillUI hXA;

    CollectBillUI$3(CollectBillUI collectBillUI) {
        this.hXA = collectBillUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < 0 || i >= adapterView.getAdapter().getCount()) {
            x.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(adapterView.getAdapter().getCount())});
            return;
        }
        a aVar = (a) CollectBillUI.b(this.hXA).getItemAtPosition(i);
        if (aVar == null) {
            x.w("MicroMsg.CollectBillUI", "invalid position: %d", new Object[]{Integer.valueOf(i)});
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("scene", 2);
        intent.putExtra("trans_id", aVar.hTI);
        intent.putExtra("bill_id", aVar.hTH);
        d.b(this.hXA.mController.tml, "order", ".ui.MallOrderTransactionInfoUI", intent);
    }
}
