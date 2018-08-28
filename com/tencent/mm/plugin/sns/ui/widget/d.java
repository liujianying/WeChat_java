package com.tencent.mm.plugin.sns.ui.widget;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.kiss.widget.textview.a.b;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    private static d one = new d();
    public int ona = 0;
    private a onf = null;
    private a ong = null;

    public static d bEY() {
        return one;
    }

    public final a getTextViewConfig() {
        int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), (int) (16.0f * com.tencent.mm.bp.a.fe(ad.getContext())));
        if (this.onf == null || ((int) this.onf.duz) != fromDPToPix) {
            this.onf = b.Fe().gM(8388627).gN(ad.getContext().getResources().getColor(c.normal_text_color)).V((float) fromDPToPix).duk;
        }
        return this.onf;
    }

    public final a bEZ() {
        int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), (int) (16.0f * com.tencent.mm.bp.a.fe(ad.getContext())));
        if (this.ong == null || ((int) this.ong.duz) != fromDPToPix) {
            b V = b.Fe().gM(8388627).gN(ad.getContext().getResources().getColor(c.normal_text_color)).V((float) fromDPToPix);
            V.duk.maxLines = 6;
            this.ong = V.duk;
        }
        return this.ong;
    }

    public final int getViewWidth() {
        if (this.ona <= 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int dimension = (int) (ad.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.NormalPadding) + ad.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.NormalPadding));
            int dimension2 = (int) ad.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.sns_timeilne_margin_left);
            int dimension3 = (int) ad.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.NormalPadding);
            this.ona = (i - dimension2) - dimension;
            x.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "screenWidth " + i + " textViewWidth " + this.ona + " padding: " + dimension + " marginLeft: " + dimension2 + " thisviewPadding: " + dimension3);
        }
        return this.ona;
    }

    public static float getTextSize() {
        return (float) com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), (int) (16.0f * com.tencent.mm.bp.a.fe(ad.getContext())));
    }
}
