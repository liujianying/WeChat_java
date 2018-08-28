package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.design.widget.c;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class j {
    public String cZH = "";
    public String doU = "";
    public View hyK;
    public String iAb = "";
    public Context mContext;
    private int nDA = -1;
    private boolean nDB = false;
    private boolean nDC = false;
    public a nDD;
    public c nDy;
    private int nDz = -1;

    public j(Context context, i iVar, String str, String str2, String str3, boolean z, boolean z2) {
        this.doU = str;
        this.cZH = str2;
        this.iAb = str3;
        this.mContext = context;
        this.nDB = z;
        this.nDC = z2;
        if (iVar != null && iVar.getView() != null) {
            this.nDy = new c(context);
            this.nDy.setCanceledOnTouchOutside(true);
            this.hyK = View.inflate(context, g.sns_ad_native_landing_pages_item_bottom_sheet, null);
            if (this.hyK == null) {
                x.e("MicroMsg.AdLandingPageBottomSheet", "mRootView init fail!");
                return;
            }
            LinearLayout linearLayout = (LinearLayout) this.hyK.findViewById(f.component_container);
            View view = iVar.getView();
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.nDz = (int) iVar.bzT().nBc;
            this.nDA = (int) iVar.bzT().nBd;
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            Object obj = (this.nDz == Integer.MAX_VALUE || this.nDA == Integer.MAX_VALUE) ? null : 1;
            if (obj != null) {
                layoutParams.width = this.nDz;
                layoutParams.height = this.nDA;
            }
            linearLayout.addView(view, layoutParams);
            ((TextView) this.hyK.findViewById(f.bottom_sheet_title)).setText(str2);
            View findViewById = this.hyK.findViewById(f.close_dialog_area);
            findViewById.setOnClickListener(new 1(this));
            View findViewById2 = this.hyK.findViewById(f.bottom_sheet_cancel_area);
            findViewById2.setOnClickListener(new 2(this));
            if (!this.nDC) {
                findViewById2.setVisibility(8);
            }
            if (this.nDB) {
                findViewById.setVisibility(8);
            }
            ImageView imageView = (ImageView) this.hyK.findViewById(f.tips_icon);
            imageView.setVisibility(8);
            if (!bi.oW(str3)) {
                Bitmap eK = d.eK("adId", str3);
                if (eK != null) {
                    imageView.setImageBitmap(eK);
                    imageView.setVisibility(0);
                    return;
                }
                d.a(str3, 0, new 3(this, imageView));
            }
        }
    }

    public final void bzW() {
        if (this.nDy != null) {
            this.nDy.dismiss();
        }
    }
}
