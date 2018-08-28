package com.tencent.mm.ui.chatting;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.n$d;
import com.tencent.mm.ui.widget.textview.a;

class TextPreviewUI$9 implements n$d {
    final /* synthetic */ TextPreviewUI tNo;

    TextPreviewUI$9(TextPreviewUI textPreviewUI) {
        this.tNo = textPreviewUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                ((ClipboardManager) this.tNo.mController.tml.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(TextPreviewUI.b(this.tNo), TextPreviewUI.b(this.tNo)));
                if (TextPreviewUI.c(this.tNo) != null) {
                    TextPreviewUI.c(this.tNo).cBo();
                    TextPreviewUI.c(this.tNo).cBn();
                }
                Toast.makeText(this.tNo.mController.tml, this.tNo.mController.tml.getString(R.l.app_copy_ok), 0).show();
                return;
            case 1:
                if (TextPreviewUI.c(this.tNo) != null) {
                    TextPreviewUI.c(this.tNo).cBn();
                    a c = TextPreviewUI.c(this.tNo);
                    c.ccw = true;
                    if (c.uOZ != null) {
                        c.uOZ.uPs.dismiss();
                    }
                    if (c.uPa != null) {
                        c.uPa.uPs.dismiss();
                    }
                    TextPreviewUI.c(this.tNo).fp(0, TextPreviewUI.a(this.tNo).getText().length());
                    TextPreviewUI.c(this.tNo).ccw = false;
                    c = TextPreviewUI.c(this.tNo);
                    c.a(c.uOZ);
                    c.a(c.uPa);
                }
                ah.i(new 1(this), 100);
                return;
            case 2:
                TextPreviewUI.b(this.tNo.mController.tml, TextPreviewUI.b(this.tNo));
                return;
            default:
                return;
        }
    }
}
