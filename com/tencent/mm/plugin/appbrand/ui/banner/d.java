package com.tencent.mm.plugin.appbrand.ui.banner;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.b.b.h;
import com.tencent.mm.modelappbrand.b.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;

public final class d extends b implements OnClickListener, f {
    private static boolean gxY = false;
    private View gxS;
    private TextView gxT;
    private ImageView gxU;
    private String gxV;
    private final Runnable gxW;
    private final h gxX;

    public final int getLayoutId() {
        return R.i.chatting_app_brand_entrance_banner;
    }

    public final boolean anR() {
        if (!gxY) {
            ((e) g.l(e.class)).b(this);
            ((e) g.l(e.class)).anO();
            ((e) g.l(e.class)).a(this);
            gxY = true;
        }
        BannerModel anZ = BannerModel.anZ();
        if (anZ == null || bi.oW(anZ.appId)) {
            setVisibility(8);
            return false;
        }
        CharSequence charSequence = anZ.appName;
        String str = anZ.gyo;
        String str2 = anZ.fmD;
        if (!bi.oW(str)) {
            Object charSequence2 = str;
        }
        if (bi.oW(charSequence2)) {
            return false;
        }
        setVisibility(0);
        if (this.gxT != null) {
            this.gxT.setText(charSequence2);
        }
        if (!bi.oW(str2)) {
            Bitmap bitmap = null;
            if (!bi.oW(this.gxV)) {
                bitmap = com.tencent.mm.modelappbrand.b.b.Ka().jv(this.gxV);
            }
            if (bitmap == null || bitmap.isRecycled()) {
                this.gxV = com.tencent.mm.modelappbrand.b.b.Ka().a(this.gxX, str2, f.dGr);
            } else {
                this.gxX.n(bitmap);
            }
        }
        return true;
    }

    public final void setVisibility(int i) {
        if (this.gxS != null) {
            this.gxS.setVisibility(i);
        }
    }

    public final void destroy() {
        if (this.gxS != null) {
            ((ViewGroup) this.gxS).removeAllViews();
            this.gxS.setVisibility(8);
        }
        this.gxS = null;
        this.gxT = null;
        this.gxU = null;
        ((e) g.l(e.class)).b(this);
    }

    public final void onClick(View view) {
        BannerModel anZ = BannerModel.anZ();
        if (anZ != null) {
            String str = anZ.appId;
            int i = anZ.fmv;
            if (bi.oW(str)) {
                anR();
                return;
            }
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1022;
            ((com.tencent.mm.plugin.appbrand.n.d) g.l(com.tencent.mm.plugin.appbrand.n.d.class)).a(view.getContext(), null, str, i, -1, null, appBrandStatObject);
        }
    }

    public static void anS() {
        gxY = false;
    }

    public final void an(String str, int i) {
        ah.A(this.gxW);
    }
}
