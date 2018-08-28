package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.plugin.scanner.ui.ProductUI.b;
import com.tencent.mm.sdk.platformtools.x;

class ProductUI$b$1 implements ProductScrollView$a {
    final /* synthetic */ b mJB;

    ProductUI$b$1(b bVar) {
        this.mJB = bVar;
    }

    public final void aIc() {
        float f = 1.0f;
        b bVar = this.mJB;
        int scrollY = bVar.mJy.getScrollY();
        float x = scrollY < 0 ? -1.0f : (scrollY >= ProductUI.x(bVar.mJt) - bVar.JP || ((float) ProductUI.x(bVar.mJt)) == 0.0f) ? 1.0f : (((float) scrollY) * 1.37f) / ((float) ProductUI.x(bVar.mJt));
        x.v("MicroMsg.ProductUI.HeaderEffectHelper", "rate=" + x);
        if (x != 1.0f) {
            bVar.mJz = false;
        } else if (!bVar.mJz) {
            bVar.mJz = true;
        } else {
            return;
        }
        if (ProductUI.v(bVar.mJt) != null) {
            float f2 = (1.0f - x) - 0.2f;
            if (f2 <= 0.0f) {
                f2 = 0.0f;
            }
            if (x == 0.0f) {
                f2 = 1.0f;
            }
            ProductUI.k(ProductUI.v(bVar.mJt), f2);
        }
        if (ProductUI.w(bVar.mJt) != null) {
            if (x == 0.0f) {
                f = 0.0f;
            } else if (x >= 0.0f) {
                x += 0.2f;
                if (x <= 1.0f) {
                    f = x;
                }
            }
            ProductUI.k(ProductUI.w(bVar.mJt), f);
        }
    }
}
