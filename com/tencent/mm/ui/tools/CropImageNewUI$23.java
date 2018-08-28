package com.tencent.mm.ui.tools;

class CropImageNewUI$23 implements Runnable {
    final /* synthetic */ CropImageNewUI uwf;

    CropImageNewUI$23(CropImageNewUI cropImageNewUI) {
        this.uwf = cropImageNewUI;
    }

    public final void run() {
        if (this.uwf.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
            this.uwf.finish();
            return;
        }
        CropImageNewUI.e(this.uwf).setVisibility(8);
        CropImageNewUI.p(this.uwf).setVisibility(0);
        CropImageNewUI.q(this.uwf).setVisibility(((Integer) CropImageNewUI.q(this.uwf).getTag()).intValue());
        CropImageNewUI.j(this.uwf).setVisibility(0);
    }
}
