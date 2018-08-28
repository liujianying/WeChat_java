package com.tencent.mm.ui.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.widget.picker.d.a;

class d$a$1 implements OnClickListener {
    final /* synthetic */ int hW;
    final /* synthetic */ a uLA;
    final /* synthetic */ m uLz;

    d$a$1(a aVar, int i, m mVar) {
        this.uLA = aVar;
        this.hW = i;
        this.uLz = mVar;
    }

    public final void onClick(View view) {
        if (this.uLA.uLw.ofq != null) {
            this.uLA.uLw.ofq.onMMMenuItemSelected(this.uLA.uLw.ofr.getItem(this.hW), this.hW);
        }
        if (!this.uLz.spC) {
            if (((Boolean) a.a(this.uLA).get(Integer.valueOf(this.hW))).booleanValue()) {
                a.a(this.uLA).put(Integer.valueOf(this.hW), Boolean.valueOf(false));
            } else {
                a.a(this.uLA).put(Integer.valueOf(this.hW), Boolean.valueOf(true));
            }
            this.uLA.uLx = a.a(this.uLA);
            this.uLA.notifyDataSetChanged();
        }
    }
}
