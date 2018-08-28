package com.tencent.mm.plugin.sns.ui.widget;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.plugin.sns.i$d;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private static b onb = new b();
    private a omZ = null;
    public int ona = 0;

    public static b bEX() {
        return onb;
    }

    public final a getTextViewConfig() {
        int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), (int) (15.0f * com.tencent.mm.bp.a.fe(ad.getContext())));
        if (this.omZ == null || ((int) this.omZ.duz) != fromDPToPix) {
            this.omZ = com.tencent.mm.kiss.widget.textview.a.b.Fe().V((float) fromDPToPix).gN(ad.getContext().getResources().getColor(c.sns_comment_color)).gM(16).duk;
        }
        return this.omZ;
    }

    public final int getViewWidth() {
        if (this.ona <= 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int dimension = (int) (ad.getResources().getDimension(i$d.NormalPadding) + ad.getResources().getDimension(i$d.NormalPadding));
            int dimension2 = (int) ad.getResources().getDimension(i$d.sns_timeilne_margin_left);
            int dimension3 = (int) ad.getResources().getDimension(i$d.NormalPadding);
            this.ona = ((i - dimension2) - dimension) - dimension3;
            x.i("MicroMsg.SnsCommentPreloadTextViewConfig", "screenWidth " + i + " textViewWidth " + this.ona + " padding: " + dimension + " marginLeft: " + dimension2 + " thisviewPadding: " + dimension3);
        }
        return this.ona;
    }
}
