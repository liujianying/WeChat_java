package com.tencent.mm.plugin.appbrand.widget.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.y;

public class b extends c implements h {
    private View contentView;
    private OnCancelListener ePB;
    private OnShowListener gFL;
    private OnDismissListener gFM;
    private boolean gFN;
    private i gFO;

    public b(Context context) {
        super(context);
        setContentView(super.getContentView());
    }

    public b(Context context, byte b) {
        super(context);
    }

    public final void a(i iVar) {
        if (this.gFL != null) {
            this.gFL.onShow(this);
        }
        this.gFO = iVar;
    }

    public final View getContentView() {
        if (this.contentView != null) {
            return this.contentView;
        }
        return super.getContentView();
    }

    public void setContentView(int i) {
        setContentView(y.gq(getContext()).inflate(i, null));
    }

    public void setContentView(View view) {
        if (!(view instanceof a)) {
            view = new a(view.getContext(), view);
        }
        this.contentView = view;
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        if (layoutParams != null) {
            view.setLayoutParams(layoutParams);
        }
        setContentView(view);
    }

    public void show() {
    }

    public void setOnShowListener(OnShowListener onShowListener) {
        super.setOnShowListener(onShowListener);
        this.gFL = onShowListener;
    }

    public final void onCancel() {
        if (this.ePB != null) {
            this.ePB.onCancel(this);
        }
    }

    public void dismiss() {
        if (this.gFO != null) {
            this.gFO.b(this);
            if (this.gFM != null) {
                this.gFM.onDismiss(this);
            }
        }
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
        this.gFM = onDismissListener;
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        this.gFN = z;
    }

    public final boolean ape() {
        return this.gFN;
    }

    public void setOnCancelListener(OnCancelListener onCancelListener) {
        super.setOnCancelListener(onCancelListener);
        this.ePB = onCancelListener;
    }
}
