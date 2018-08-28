package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import com.tencent.mm.bw.a.f;
import com.tencent.mm.bw.a.g;
import com.tencent.mm.ui.ap;

public final class c implements OnGlobalLayoutListener {
    private Button eGn = ((Button) this.ilW.findViewById(f.ok_btn));
    private Button haQ;
    private View ilW = View.inflate(this.mContext, g.time_picker_panel, null);
    private Context mContext;
    public android.support.design.widget.c tYZ = new android.support.design.widget.c(this.mContext);
    private int tZa;
    private BottomSheetBehavior tZb;
    public CustomTimePicker uLn = ((CustomTimePicker) this.ilW.findViewById(f.time_picker));
    public a uLo;

    static /* synthetic */ void a(c cVar, boolean z, Object obj) {
        if (cVar.uLo != null) {
            cVar.uLo.f(z, obj);
        }
    }

    public c(Context context) {
        this.mContext = context;
        this.eGn.setOnClickListener(new 1(this));
        this.haQ = (Button) this.ilW.findViewById(f.cancel_btn);
        this.haQ.setOnClickListener(new 2(this));
        this.tYZ.setContentView(this.ilW);
        this.tZa = ap.fromDPToPix(this.mContext, 288);
        this.tZb = BottomSheetBehavior.h((View) this.ilW.getParent());
        if (this.tZb != null) {
            this.tZb.q(this.tZa);
            this.tZb.cv = false;
        }
        this.tYZ.setOnDismissListener(new 3(this));
    }

    public final void onGlobalLayout() {
    }
}
