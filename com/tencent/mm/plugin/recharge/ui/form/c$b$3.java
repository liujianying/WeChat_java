package com.tencent.mm.plugin.recharge.ui.form;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.recharge.ui.form.c.b;
import com.tencent.mm.sdk.platformtools.x;

class c$b$3 implements OnItemClickListener {
    final /* synthetic */ b mqS;
    final /* synthetic */ InstantAutoCompleteTextView mqT;

    public c$b$3(b bVar, InstantAutoCompleteTextView instantAutoCompleteTextView) {
        this.mqS = bVar;
        this.mqT = instantAutoCompleteTextView;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.mqS.mph = this.mqS.mqQ.vg(i);
        if (this.mqS.mph != null) {
            x.i(c.TAG, "onItemClick record.record " + this.mqS.mph.mov + ", record.name " + this.mqS.mph.name);
            this.mqS.mqR = true;
            this.mqS.setInput(this.mqS.mph);
        } else {
            x.w(c.TAG, "record is null");
        }
        this.mqT.dismissDropDown();
    }
}
