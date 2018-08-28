package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class MallEditText$4 implements OnItemClickListener {
    final /* synthetic */ MallEditText mpl;

    MallEditText$4(MallEditText mallEditText) {
        this.mpl = mallEditText;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        MallEditText.a(this.mpl, MallEditText.d(this.mpl).vg(i));
        if (MallEditText.e(this.mpl) != null) {
            x.d("MicroMsg.MallEditText", "onItemClick record.record " + MallEditText.e(this.mpl).mov + ", record.name " + MallEditText.e(this.mpl).name);
            this.mpl.setInput(MallEditText.e(this.mpl));
        }
        MallEditText.a(this.mpl).dismissDropDown();
    }
}
