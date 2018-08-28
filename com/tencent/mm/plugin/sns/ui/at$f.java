package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

abstract class at$f {
    OnClickListener nKO = new 1(this);
    OnClickListener nKP = new 2(this);
    OnClickListener nKQ = new 3(this);
    OnClickListener oar = new 4(this);
    OnClickListener oas = new 5(this);
    OnClickListener oat = new OnClickListener() {
        public final void onClick(View view) {
            if (view.getTag() != null) {
                x.d("MicroMsg.SnsphotoAdapter", "snssight click");
                at$f.this.oau = (a) view.getTag();
                at$f.this.dF(at$f.this.oau.nkZ, at$f.this.oau.position + 2);
            }
        }
    };
    public a oau = new a();

    public abstract void dE(int i, int i2);

    public abstract void dF(int i, int i2);

    public abstract void xw(int i);
}
