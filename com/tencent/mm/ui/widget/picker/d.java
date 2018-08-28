package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.bw.a.f;
import com.tencent.mm.bw.a.g;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.ArrayList;

public final class d {
    public Button eGn = ((Button) this.ilW.findViewById(f.ok_btn));
    public Button haQ = ((Button) this.ilW.findViewById(f.cancel_btn));
    public View ilW = View.inflate(this.mContext, g.multi_picker_panel, null);
    public Context mContext;
    public c ofp;
    public com.tencent.mm.ui.base.n.d ofq;
    public l ofr = new l(this.mContext);
    public android.support.design.widget.c tYZ = new android.support.design.widget.c(this.mContext);
    public int tZa;
    private BottomSheetBehavior tZb;
    public ListView uLq = ((ListView) this.ilW.findViewById(f.multi_listview));
    public View uLr = this.ilW.findViewById(f.header_ll);
    public TextView uLs = ((TextView) this.ilW.findViewById(f.header_title));
    public ArrayList<Integer> uLt;
    public a uLu;
    public b uLv;

    public interface b {
        void hq(boolean z);
    }

    static /* synthetic */ void a(d dVar, boolean z) {
        if (dVar.uLv != null) {
            dVar.uLv.hq(z);
        }
    }

    public d(Context context) {
        this.mContext = context;
        this.tYZ.setContentView(this.ilW);
        this.tZa = ap.ae(this.mContext, com.tencent.mm.bw.a.d.BottomSheetListMaxHeight) + ap.ae(this.mContext, com.tencent.mm.bw.a.d.BottomSheetTextTitleHeight);
        this.tZb = BottomSheetBehavior.h((View) this.ilW.getParent());
        if (this.tZb != null) {
            this.tZb.q(this.tZa);
            this.tZb.cv = false;
        }
        this.tYZ.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                d.this.tYZ = null;
            }
        });
    }

    public final void hide() {
        if (this.tYZ != null) {
            this.tYZ.dismiss();
        }
    }
}
