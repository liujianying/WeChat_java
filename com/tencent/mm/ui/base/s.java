package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public final class s extends Toast {
    public final al bAZ = new al(new 1(this), true);
    private final Context context;
    public long duration;
    private View fXP;
    public int hFO;
    private final TextView kva;
    private int level;

    public s(Context context) {
        super(context);
        this.context = context;
        reset();
        this.fXP = View.inflate(context, h.toast_view, null);
        setView(this.fXP);
        setGravity(55, 0, b.b(context, 40.0f));
        setDuration(0);
        this.kva = (TextView) this.fXP.findViewById(g.toast_view_text);
        switch (this.level) {
            case 1:
                this.kva.setTextColor(-1);
                return;
            case 2:
                this.kva.setTextColor(this.context.getResources().getColor(d.toasterro));
                return;
            default:
                return;
        }
    }

    public final void setText(CharSequence charSequence) {
        this.kva.setText(charSequence);
    }

    public final void setText(int i) {
        this.kva.setText(i);
    }

    public final void reset() {
        this.level = 1;
        this.duration = 2000;
        this.hFO = ((int) (this.duration / 70)) + 1;
    }

    public static o a(Activity activity, String str, long j) {
        View inflate = View.inflate(activity, h.toast_view, null);
        ((TextView) inflate.findViewById(g.toast_view_text)).setText(str);
        o oVar = new o(inflate);
        oVar.setWidth(-1);
        oVar.setHeight(-2);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        oVar.showAtLocation(activity.getWindow().getDecorView(), 48, 0, rect.top + cM(activity));
        new 4(oVar).sendEmptyMessageDelayed(0, j);
        return oVar;
    }

    private static int cM(Context context) {
        int dimensionPixelSize;
        if (!(context instanceof ActionBarActivity) || ((ActionBarActivity) context).getSupportActionBar() == null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(e.DefaultActionbarHeightLand);
            } else {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(e.DefaultActionbarHeightPort);
            }
        } else {
            dimensionPixelSize = ((ActionBarActivity) context).getSupportActionBar().getHeight();
        }
        if (dimensionPixelSize == 0) {
            return context.getResources().getDimensionPixelSize(e.DefaultActionbarHeightPort);
        }
        return dimensionPixelSize;
    }

    public static o a(Activity activity, int i, String str) {
        View inflate = View.inflate(activity, h.listen_model_notify, null);
        TextView textView = (TextView) inflate.findViewById(g.listen_model_notify_text);
        textView.setText(str);
        textView.setOnClickListener(null);
        ImageView imageView = (ImageView) inflate.findViewById(g.listen_model_notify_imageview);
        if (i == 0) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(i);
        }
        o oVar = new o(inflate);
        oVar.setWidth(-1);
        oVar.setHeight(-2);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i2 = rect.top;
        int cM = cM(activity);
        if (i2 == 0) {
            i2 = ap(activity, 25);
        }
        ah.A(new 7(oVar, activity, i2 + cM));
        ah.i(new 2(oVar), 2000);
        ImageButton imageButton = (ImageButton) inflate.findViewById(g.listen_model_notify_btn);
        imageButton.setVisibility(8);
        imageButton.setOnClickListener(new 3(oVar));
        return oVar;
    }

    public static o a(Activity activity, int i, int i2, String str, int i3, OnClickListener onClickListener) {
        View inflate = View.inflate(activity, h.tipsbar_style_two, null);
        ((LinearLayout) inflate.findViewById(g.tipsbar_item)).setBackgroundColor(activity.getResources().getColor(i));
        TextView textView = (TextView) inflate.findViewById(g.tipsbar_text);
        textView.setText(str);
        textView.setOnClickListener(null);
        if (i == d.tipsbar_white_bg_color || i == d.tipsbar_red_bg_color) {
            textView.setTextColor(activity.getResources().getColor(d.black_text_color));
        }
        ImageView imageView = (ImageView) inflate.findViewById(g.tipsbar_left_icon);
        if (i2 == 0) {
            imageView.setVisibility(8);
            int fromDPToPix = a.fromDPToPix(activity, 16);
            textView.setPadding(fromDPToPix, 0, fromDPToPix, 0);
        } else {
            imageView.setImageResource(i2);
        }
        o oVar = new o(inflate);
        oVar.setWidth(-1);
        oVar.setHeight(-2);
        Rect rect = new Rect();
        Window window = activity.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        int i4 = rect.top;
        int cM = cM(activity);
        if (i4 == 0) {
            i4 = ap(activity, 25);
        }
        i4 += cM;
        if (window.getDecorView() != null) {
            window.getDecorView().post(new 5(oVar, window, i4));
        }
        ImageView imageView2 = (ImageView) inflate.findViewById(g.tipsbar_right_icon);
        if (i3 == 0) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setImageResource(i3);
        }
        imageView2.setOnClickListener(new 6(oVar, onClickListener));
        return oVar;
    }

    public static void gH(Context context) {
        if (com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted_ro")) {
            a.aq(context, 3);
        } else {
            a.aq(context, 1);
        }
    }

    public static void gI(Context context) {
        a.aq(context, 2);
    }

    public static int gJ(Context context) {
        return ap(context, 25);
    }

    public static int ap(Context context, int i) {
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(bi.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMToast", e, "", new Object[0]);
            return i;
        }
    }
}
