package com.tencent.mm.ui.widget.snackbar;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bw.a.f;
import com.tencent.mm.bw.a.g;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aq;

public final class a {
    Handler mHandler = new Handler();
    View mParentView;
    SnackContainer uMA;
    b uMB;
    c uMC;
    private final OnClickListener uMD = new 1(this);

    public interface b {
        void aMj();
    }

    public a(Activity activity, int i) {
        View findViewById = activity.findViewById(16908290);
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService("layout_inflater");
        layoutInflater.inflate(g.snackbar_container, (ViewGroup) findViewById);
        a((ViewGroup) findViewById, layoutInflater.inflate(g.snackbar_main, (ViewGroup) findViewById, false), i, activity);
    }

    public a(Context context, View view, int i) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        layoutInflater.inflate(g.snackbar_container, (ViewGroup) view);
        a((ViewGroup) view, layoutInflater.inflate(g.snackbar_main, (ViewGroup) view, false), i, context);
    }

    private void a(ViewGroup viewGroup, View view, int i, Context context) {
        boolean z;
        if (viewGroup != null) {
            this.uMA = (SnackContainer) viewGroup.findViewById(f.snackContainer);
        }
        if (this.uMA == null) {
            this.uMA = new SnackContainer(viewGroup);
        }
        this.mParentView = view;
        if (i == 36) {
            this.uMA.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (b.aKp() && a.this.uMA.isShowing()) {
                        b.mH(false);
                        a.this.mHandler.postDelayed(new 1(this), 100);
                    }
                    return true;
                }
            });
        }
        ((TextView) view.findViewById(f.snackButton)).setOnClickListener(this.uMD);
        ao.t("snackbar:isNavBarVisibility : %B,navBarHeightd:%d", new Object[]{Boolean.valueOf(aq.gt(context)), Integer.valueOf(aq.gs(context))});
        Activity activity = (Activity) context;
        if (VERSION.SDK_INT >= 19) {
            LayoutParams attributes = activity.getWindow().getAttributes();
            if (attributes.flags == ((attributes.flags & -134217729) | 134217728)) {
                z = true;
                ao.t("snackbar:isNavBarTranslucent : %B", new Object[]{Boolean.valueOf(z)});
                if (z && r3) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(f.snackBar);
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) linearLayout.getLayoutParams();
                    marginLayoutParams.bottomMargin = r4;
                    linearLayout.setLayoutParams(marginLayoutParams);
                    return;
                }
            }
        }
        z = false;
        ao.t("snackbar:isNavBarTranslucent : %B", new Object[]{Boolean.valueOf(z)});
        if (z) {
        }
    }
}
