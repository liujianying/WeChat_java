package com.tencent.mm.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a$j;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.q;

public final class g extends q {
    private View FU = null;
    private ProgressBar gFh;
    private Context mContext;
    private TextView tlx;

    private g(Context context, int i) {
        super(context, i);
        this.mContext = context;
        if (this.FU == null) {
            this.FU = View.inflate(this.mContext, com.tencent.mm.plugin.wxpay.a.g.wallet_progress_bar, null);
            this.tlx = (TextView) this.FU.findViewById(f.mm_progress_dialog_msg);
            this.gFh = (ProgressBar) this.FU.findViewById(f.mm_progress_dialog_icon);
            setCanceledOnTouchOutside(true);
        }
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.FU, new LayoutParams(-1, -1));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        getWindow().addFlags(2);
        attributes.dimAmount = 0.65f;
        onWindowAttributesChanged(attributes);
    }

    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
    }

    public final void setMessage(CharSequence charSequence) {
        this.tlx.setText(charSequence);
    }

    public static Dialog a(Context context, CharSequence charSequence, OnCancelListener onCancelListener) {
        g gVar = new g(context, a$j.mmalertdialog);
        gVar.setMessage(charSequence);
        gVar.setCancelable(true);
        gVar.setOnCancelListener(onCancelListener);
        gVar.setCanceledOnTouchOutside(false);
        gVar.show();
        return gVar;
    }

    public static Dialog e(Context context, String str, OnCancelListener onCancelListener) {
        View inflate = View.inflate(context, com.tencent.mm.plugin.wxpay.a.g.wallet_progress_dialog_view, null);
        ((TextView) inflate.findViewById(f.dialog_title)).setText(str);
        i iVar = new i(context, a$j.WalletProgressDialogStyle);
        iVar.setCancelable(false);
        iVar.setContentView(inflate);
        iVar.setOnCancelListener(onCancelListener);
        iVar.show();
        return iVar;
    }

    public static Dialog a(Context context, boolean z, OnCancelListener onCancelListener) {
        View inflate = View.inflate(context, com.tencent.mm.plugin.wxpay.a.g.wallet_progress_dialog_view, null);
        i iVar = new i(context, a$j.WalletProgressDialogStyle);
        iVar.setCancelable(z);
        iVar.setContentView(inflate);
        iVar.setOnCancelListener(onCancelListener);
        iVar.show();
        return iVar;
    }

    public static Dialog e(Context context, OnCancelListener onCancelListener) {
        View inflate = View.inflate(context, com.tencent.mm.plugin.wxpay.a.g.wallet_progress_dialog_view, null);
        i iVar = new i(context, a$j.WalletProgressDialogStyle);
        iVar.setCancelable(true);
        iVar.setContentView(inflate);
        iVar.setCanceledOnTouchOutside(false);
        iVar.setOnCancelListener(onCancelListener);
        iVar.show();
        return iVar;
    }

    public static Dialog b(Context context, boolean z, OnCancelListener onCancelListener) {
        context.getString(a.i.app_empty_string);
        return h.a(context, context.getString(a.i.wallet_pay_loading), z, onCancelListener);
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.WalletProgressDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
