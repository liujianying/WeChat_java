package com.tencent.mm.plugin.appbrand.widget.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.appbrand.s.k;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.y;

public final class f extends p implements h {
    private View contentView;
    private OnCancelListener ePB;
    private OnShowListener gFL;
    private OnDismissListener gFM;
    private boolean gFN;
    private i gFO;

    public f(Context context) {
        super(context, k.mmalertdialog, 0);
        try {
            onCreate(null);
        } catch (Exception e) {
        }
    }

    public final void a(i iVar) {
        if (this.gFL != null) {
            this.gFL.onShow(this);
        }
        this.gFO = iVar;
    }

    public final View getContentView() {
        return this.contentView;
    }

    public final void setContentView(int i) {
        setContentView(y.gq(getContext()).inflate(i, null));
    }

    public final void setContentView(View view) {
        this.contentView = view;
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        if (layoutParams != null) {
            view.setLayoutParams(layoutParams);
        }
        setContentView(view);
    }

    public final void show() {
    }

    public final void setOnShowListener(OnShowListener onShowListener) {
        super.setOnShowListener(onShowListener);
        this.gFL = onShowListener;
    }

    public final void onCancel() {
        if (this.ePB != null) {
            this.ePB.onCancel(this);
        }
    }

    public final void dismiss() {
        if (this.gFO != null) {
            this.gFO.b(this);
            if (this.gFM != null) {
                this.gFM.onDismiss(this);
            }
        }
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
        this.gFM = onDismissListener;
    }

    public final void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        this.gFN = z;
    }

    public final boolean ape() {
        return this.gFN;
    }

    public final void setOnCancelListener(OnCancelListener onCancelListener) {
        super.setOnCancelListener(onCancelListener);
        this.ePB = onCancelListener;
    }
}
