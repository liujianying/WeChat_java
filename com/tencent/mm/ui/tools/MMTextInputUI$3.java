package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MMTextInputUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ MMTextInputUI uAI;

    MMTextInputUI$3(MMTextInputUI mMTextInputUI) {
        this.uAI = mMTextInputUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.uAI.w(MMTextInputUI.b(this.uAI).getText());
        Intent intent = new Intent();
        intent.putExtra("key_result", MMTextInputUI.b(this.uAI).getText());
        this.uAI.setResult(-1, intent);
        this.uAI.finish();
        return true;
    }
}
