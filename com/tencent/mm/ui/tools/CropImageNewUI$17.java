package com.tencent.mm.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CropImageNewUI$17 implements OnMenuItemClickListener {
    final /* synthetic */ CropImageNewUI uwf;
    final /* synthetic */ boolean uwi;
    final /* synthetic */ boolean uwj;

    CropImageNewUI$17(CropImageNewUI cropImageNewUI, boolean z, boolean z2) {
        this.uwf = cropImageNewUI;
        this.uwi = z;
        this.uwj = z2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (!this.uwi || !this.uwj) {
            switch (CropImageNewUI.f(this.uwf)) {
                case 1:
                    if (CropImageNewUI.e(this.uwf) == null) {
                        CropImageNewUI.a(this.uwf, CropImageNewUI.j(this.uwf), CropImageNewUI.i(this.uwf));
                        break;
                    }
                    CropImageNewUI.a(this.uwf, CropImageNewUI.e(this.uwf).getCropImageIV(), CropImageNewUI.i(this.uwf));
                    break;
                case 2:
                    CropImageNewUI.k(this.uwf);
                    break;
                case 3:
                    CropImageNewUI.l(this.uwf);
                    break;
                case 4:
                    CropImageNewUI.m(this.uwf);
                    break;
                case 5:
                    CropImageNewUI.n(this.uwf);
                    break;
            }
        }
        CropImageNewUI.a(this.uwf, true);
        return true;
    }
}
