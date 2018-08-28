package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.c;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceAddDataSourceUI$6 implements OnItemClickListener {
    final /* synthetic */ ExdeviceAddDataSourceUI iAm;

    ExdeviceAddDataSourceUI$6(ExdeviceAddDataSourceUI exdeviceAddDataSourceUI) {
        this.iAm = exdeviceAddDataSourceUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ExdeviceAddDataSourceUI$b pd = ExdeviceAddDataSourceUI.c(this.iAm).pd(i - ((ListView) adapterView).getHeaderViewsCount());
        if (pd.iAt == c.iAu) {
            if (ExdeviceAddDataSourceUI.Ap(pd.mac)) {
                ExdeviceAddDataSourceUI.a(this.iAm, pd.mac);
                pd.iAt = c.iAv;
                ExdeviceAddDataSourceUI.c(this.iAm).notifyDataSetChanged();
                return;
            }
            x.i("MicroMsg.ExdeviceAddDataSourceUI", "try connect device failed.");
        }
    }
}
