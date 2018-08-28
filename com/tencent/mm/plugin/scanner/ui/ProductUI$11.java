package com.tencent.mm.plugin.scanner.ui;

class ProductUI$11 implements e$a {
    final /* synthetic */ ProductUI mJt;

    ProductUI$11(ProductUI productUI) {
        this.mJt = productUI;
    }

    public final void a(String str, Boolean bool) {
        if (str != null && str.length() > 0) {
            ProductUI.i(this.mJt).put(str, bool);
        }
    }

    public final Boolean KI(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return (Boolean) ProductUI.i(this.mJt).get(str);
    }

    public final void bsE() {
        if (this.mJt.eOE != null) {
            this.mJt.eOE.notifyDataSetChanged();
        }
    }
}
