package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a;
import com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.b;
import com.tencent.mm.sdk.platformtools.x;

class SelectScanModePanel$3 implements OnItemClickListener {
    final /* synthetic */ SelectScanModePanel mMm;

    SelectScanModePanel$3(SelectScanModePanel selectScanModePanel) {
        this.mMm = selectScanModePanel;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z = true;
        if (adapterView == null || SelectScanModePanel.e(this.mMm) == null) {
            boolean z2;
            String str = "MicroMsg.scanner.SelectScanModePanel";
            StringBuilder stringBuilder = new StringBuilder("parent == null ? ");
            if (adapterView == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            StringBuilder append = stringBuilder.append(z2).append(", context == null ? ");
            if (SelectScanModePanel.e(this.mMm) != null) {
                z = false;
            }
            x.e(str, append.append(z).toString());
            return;
        }
        b bVar = (b) adapterView.getAdapter().getItem(i);
        if (bVar == null) {
            x.e("MicroMsg.scanner.SelectScanModePanel", "clickItem == null");
            return;
        }
        ((a) adapterView.getAdapter()).mLO = i;
        x.d("MicroMsg.scanner.SelectScanModePanel", "position=[%s], clickItem=[%s]", new Object[]{Integer.valueOf(i), SelectScanModePanel.e(this.mMm).getString(bVar.mLQ)});
        if (!(SelectScanModePanel.f(this.mMm) == null || bVar == null)) {
            SelectScanModePanel.f(this.mMm).vB(bVar.mLT);
        }
        this.mMm.setSelectedMode(bVar.mLT);
    }
}
