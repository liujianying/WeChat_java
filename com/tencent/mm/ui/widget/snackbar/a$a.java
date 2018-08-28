package com.tencent.mm.ui.widget.snackbar;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.bw.a.c;
import com.tencent.mm.ui.widget.snackbar.SnackContainer.a;

public class a$a {
    String kjg;
    private Context mContext;
    a uMH;
    private int uMI = 0;
    String uMv;
    private int uMw = 0;
    private Parcelable uMx;
    private short uMy = (short) 3500;
    private int vD = -1;

    public a$a(Activity activity) {
        this.mContext = activity.getApplicationContext();
        this.uMH = new a(activity, this.uMI);
    }

    public a$a(Context context, View view) {
        this.mContext = context;
        this.uMH = new a(context, view, this.uMI);
    }

    public final a$a a(Short sh) {
        this.uMy = sh.shortValue();
        return this;
    }

    public final a cBa() {
        int i;
        String str = this.kjg;
        String toUpperCase = this.uMv != null ? this.uMv.toUpperCase() : null;
        int i2 = this.uMw;
        Parcelable parcelable = this.uMx;
        short s = this.uMy;
        if (this.vD != -1) {
            i = this.vD;
        } else {
            i = this.mContext.getResources().getColor(c.wechat_green);
        }
        Snack snack = new Snack(str, toUpperCase, i2, parcelable, s, i);
        a aVar = this.uMH;
        SnackContainer snackContainer = aVar.uMA;
        View view = aVar.mParentView;
        a$c a_c = aVar.uMC;
        if (!(view.getParent() == null || view.getParent() == snackContainer)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        a aVar2 = new a(snack, view, a_c, (byte) 0);
        snackContainer.uMK.offer(aVar2);
        if (snackContainer.uMK.size() == 1) {
            snackContainer.a(aVar2);
        }
        return this.uMH;
    }
}
