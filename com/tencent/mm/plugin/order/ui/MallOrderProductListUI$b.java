package com.tencent.mm.plugin.order.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.platformtools.y.a;

class MallOrderProductListUI$b implements a {
    ImageView hFT;
    String huW;
    final /* synthetic */ MallOrderProductListUI lPE;
    TextView lPF;
    TextView lPG;
    TextView lPH;
    TextView lPI;
    TextView lPJ;

    private MallOrderProductListUI$b(MallOrderProductListUI mallOrderProductListUI) {
        this.lPE = mallOrderProductListUI;
    }

    /* synthetic */ MallOrderProductListUI$b(MallOrderProductListUI mallOrderProductListUI, byte b) {
        this(mallOrderProductListUI);
    }

    public final void m(String str, Bitmap bitmap) {
        if (str != null && str.equals(this.huW)) {
            this.hFT.post(new 1(this, bitmap));
        }
    }
}
