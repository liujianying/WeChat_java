package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.y;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.l;

public class p extends q {
    private View FU;
    public ProgressBar gFh;
    private Context mContext;
    private int style;
    private TextView tlx;

    public p(Context context, int i, int i2) {
        int i3;
        super(context, i);
        this.mContext = context;
        this.style = i2;
        switch (this.style) {
            case 0:
                i3 = h.mm_progress_dialog;
                break;
            case 1:
                i3 = h.mm_progress_dialog_with_bg;
                break;
            case 2:
                i3 = h.mm_progress_dialog;
                break;
            default:
                i3 = h.mm_progress_dialog;
                break;
        }
        this.FU = y.gq(this.mContext).inflate(i3, null);
        this.tlx = (TextView) this.FU.findViewById(g.mm_progress_dialog_msg);
        this.gFh = (ProgressBar) this.FU.findViewById(g.mm_progress_dialog_icon);
        setCanceledOnTouchOutside(true);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.FU, new LayoutParams(-1, -1));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        if (this.style == 2) {
            getWindow().addFlags(2);
            attributes.dimAmount = 0.65f;
        }
        onWindowAttributesChanged(attributes);
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
    }

    public void setMessage(CharSequence charSequence) {
        this.tlx.setText(charSequence);
    }

    public static p a(Context context, CharSequence charSequence, boolean z, int i, OnCancelListener onCancelListener) {
        int i2;
        switch (i) {
            case 0:
                i2 = l.mmalertdialog;
                break;
            case 1:
                i2 = l.mmalertdialog;
                break;
            case 2:
                i2 = l.mmalertdialog;
                break;
            default:
                i2 = l.mmtipsdialog;
                break;
        }
        p pVar = new p(context, i2, i);
        pVar.setMessage(charSequence);
        pVar.setCancelable(z);
        pVar.setOnCancelListener(onCancelListener);
        pVar.setCanceledOnTouchOutside(false);
        return pVar;
    }

    public static p b(Context context, CharSequence charSequence, boolean z, int i, OnCancelListener onCancelListener) {
        p a = a(context, charSequence, z, i, onCancelListener);
        a.show();
        return a;
    }

    public void show() {
        try {
            super.show();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMProgressDialog", e, "", new Object[0]);
        }
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.MMProgressDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
