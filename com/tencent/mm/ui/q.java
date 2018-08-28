package com.tencent.mm.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.l;

final class q extends Dialog implements DialogInterface {
    private boolean eWV;
    private View gEZ = this.tlw.findViewById(g.mm_alert_title_area);
    private TextView iDE = ((TextView) this.tlw.findViewById(g.mm_alert_title));
    private Context mContext;
    Button pxh = ((Button) this.tlw.findViewById(g.mm_alert_ok_btn));
    private LinearLayout tlA = ((LinearLayout) this.tlw.findViewById(g.mm_alert_custom_area));
    private LinearLayout tlw = ((LinearLayout) y.gq(this.mContext).inflate(h.mm_alert_comfirm_lite_dependency, null));
    TextView tlx = ((TextView) this.tlw.findViewById(g.mm_alert_msg));
    private TextView tly = ((TextView) this.tlw.findViewById(g.mm_alert_msg_subtitle));
    LinearLayout tlz = ((LinearLayout) this.tlw.findViewById(g.mm_alert_msg_area));

    /* renamed from: com.tencent.mm.ui.q$1 */
    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ DialogInterface.OnClickListener tlB;
        final /* synthetic */ boolean tlC = true;

        AnonymousClass1(DialogInterface.OnClickListener onClickListener) {
            this.tlB = onClickListener;
        }

        public final void onClick(View view) {
            if (this.tlB != null) {
                this.tlB.onClick(q.this, -1);
            }
            if (this.tlC) {
                q.this.dismiss();
            }
        }
    }

    public q(Context context) {
        super(context, l.mmalertdialog);
        this.mContext = context;
        setCanceledOnTouchOutside(true);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.tlw);
    }

    public final void setTitle(CharSequence charSequence) {
        this.gEZ.setVisibility(0);
        this.iDE.setVisibility(0);
        this.iDE.setMaxLines(2);
        this.iDE.setText(charSequence);
        DK(d.dialog_msg_color);
    }

    public final void setTitle(int i) {
        this.gEZ.setVisibility(0);
        this.iDE.setVisibility(0);
        this.iDE.setMaxLines(2);
        this.iDE.setText(i);
        DK(d.dialog_msg_color);
    }

    private void DK(int i) {
        if (this.tlx != null) {
            this.tlx.setTextColor(this.tlx.getContext().getResources().getColor(i));
        }
    }

    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        this.eWV = z;
        setCanceledOnTouchOutside(this.eWV);
    }

    public final void cpX() {
        super.setCancelable(true);
    }

    public final void show() {
        try {
            super.show();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.LiteDependDialog", e, "", new Object[0]);
        }
    }

    public final void dismiss() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ah.A(new Runnable() {
                public final void run() {
                    q.this.dismiss();
                }
            });
            x.e("MicroMsg.LiteDependDialog", bi.cjd().toString());
            return;
        }
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.LiteDependDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
