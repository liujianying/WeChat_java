package com.tencent.mm.plugin.facedetect.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FaceDebugUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FaceDebugUI iPS;

    FaceDebugUI$1(FaceDebugUI faceDebugUI) {
        this.iPS = faceDebugUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.iPS.finish();
        return false;
    }
}
