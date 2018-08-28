package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.ui.base.n$d;
import com.tencent.mm.ui.tools.CropImageNewUI.20;

class CropImageNewUI$20$2 implements n$d {
    final /* synthetic */ 20 uwk;

    CropImageNewUI$20$2(20 20) {
        this.uwk = 20;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        Intent intent;
        switch (menuItem.getItemId()) {
            case 0:
                intent = new Intent();
                intent.putExtra("CropImage_OutputPath", this.uwk.uwf.getIntent().getStringExtra("CropImage_OutputPath"));
                intent.putExtra("OP_CODE", 1);
                this.uwk.uwf.setResult(-1, intent);
                this.uwk.uwf.finish();
                return;
            case 1:
                intent = new Intent();
                intent.putExtra("CropImage_OutputPath", this.uwk.uwf.getIntent().getStringExtra("CropImage_OutputPath"));
                intent.putExtra("OP_CODE", 2);
                this.uwk.uwf.setResult(-1, intent);
                this.uwk.uwf.finish();
                return;
            default:
                return;
        }
    }
}
