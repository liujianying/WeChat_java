package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.platformtools.y.a;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ProductFurtherInfoUI$a extends u implements a {
    private Context mContext;
    final /* synthetic */ ProductFurtherInfoUI mIE;
    List<String> mIG = new ArrayList();
    private Map<String, ImageView> mIH = new HashMap();
    private int mII;

    public ProductFurtherInfoUI$a(ProductFurtherInfoUI productFurtherInfoUI, Context context) {
        this.mIE = productFurtherInfoUI;
        this.mContext = context;
        y.a(this);
        this.mII = this.mContext.getResources().getColor(R.e.hint_text_color_dark_bg);
    }

    private ImageView KJ(String str) {
        if (this.mIH.containsKey(str)) {
            return (ImageView) this.mIH.get(str);
        }
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ScaleType.FIT_XY);
        imageView.setLayoutParams(new LayoutParams(-1, -1));
        this.mIH.put(str, imageView);
        return imageView;
    }

    public final Object b(ViewGroup viewGroup, int i) {
        String str = (String) this.mIG.get(i);
        View KJ = KJ(str);
        Bitmap a = y.a(new o(str));
        if (a == null || a.isRecycled()) {
            KJ.setImageBitmap(null);
            KJ.setBackgroundColor(this.mII);
        } else {
            KJ.setImageBitmap(a);
            KJ.setBackgroundColor(0);
        }
        try {
            viewGroup.addView(KJ);
        } catch (Exception e) {
            x.e("MicroMsg.ProductFurtherInfoUI", "Add view failed: " + e.getMessage());
        }
        return KJ;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((ImageView) obj);
        String str = (String) this.mIG.get(i);
        if (this.mIH.containsKey(str)) {
            this.mIH.remove(str);
        }
    }

    public final int getCount() {
        return this.mIG.size();
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }

    public final void m(String str, Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled() && !bi.oW(str)) {
            ImageView KJ = KJ(str);
            if (KJ != null) {
                ah.A(new 1(this, KJ, bitmap));
            }
        }
    }
}
