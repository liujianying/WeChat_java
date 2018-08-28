package com.tencent.mm.plugin.appbrand.game.widget.input;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.widget.input.l;
import com.tencent.mm.plugin.appbrand.widget.input.s;
import com.tencent.mm.plugin.appbrand.widget.input.u;

public final class a extends u {
    private static final int fDq = g.app_brand_game_input_panel;
    public a fDr;
    private WAGamePanelInputEditText fDs;
    private OnClickListener fDt;

    protected final /* synthetic */ View ahq() {
        a aVar = new a(getContext());
        this.fDs = (WAGamePanelInputEditText) aVar.findViewById(g.game_edit_text);
        aVar.getConfirmButton().setOnClickListener(new 1(this));
        this.gIp = this.fDs;
        this.fDr = aVar;
        return aVar;
    }

    private a(Context context) {
        super(context);
        mb(fDq);
    }

    public static a bH(View view) {
        return (a) view.getRootView().findViewById(fDq);
    }

    public static a bI(View view) {
        l bV = l.bV(view);
        if (bV.getOnLayoutListener() == null || !(bV.getOnLayoutListener() instanceof s)) {
            bV.setOnLayoutListener(new s());
        }
        a bH = bH(view);
        if (bH != null) {
            return bH;
        }
        bH = new a(view.getContext());
        bV.bW(bH);
        return bH;
    }

    protected final void aho() {
        this.fDr.setIsHide(false);
    }

    protected final void ahp() {
        int i;
        int i2 = 0;
        if ((this.fDs.getInputType() & 131072) > 0) {
            i = 1;
        } else {
            i = 0;
        }
        View confirmButton = this.fDr.getConfirmButton();
        if (i == 0) {
            i2 = 8;
        }
        confirmButton.setVisibility(i2);
    }

    public final WAGamePanelInputEditText getAttachedEditText() {
        return (WAGamePanelInputEditText) super.getAttachedEditText();
    }

    public final void show() {
        this.gIp = this.fDs;
        this.fDs.requestFocus();
        super.show();
    }

    public final void setOnConfirmClickListener(OnClickListener onClickListener) {
        this.fDt = onClickListener;
    }
}
