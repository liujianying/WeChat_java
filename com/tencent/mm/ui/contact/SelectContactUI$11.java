package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.platformtools.ai;

class SelectContactUI$11 implements OnClickListener {
    final /* synthetic */ SelectContactUI ulL;

    SelectContactUI$11(SelectContactUI selectContactUI) {
        this.ulL = selectContactUI;
    }

    public final void onClick(View view) {
        if (!this.ulL.cyC()) {
            Intent intent = new Intent();
            intent.setClassName(this.ulL, "com.tencent.mm.ui.contact.GroupCardSelectUI");
            intent.putExtra("group_select_type", true);
            boolean fb = s.fb(SelectContactUI.a(this.ulL), 16384);
            intent.putExtra("group_select_need_result", fb);
            if (!fb) {
                this.ulL.startActivity(intent);
            } else if (SelectContactUI.b(this.ulL) == 14) {
                intent.putExtra("group_multi_select", true);
                intent.putExtra("already_select_contact", ai.c(SelectContactUI.a(this.ulL, true), ","));
                intent.putExtra("max_limit_num", this.ulL.getIntent().getIntExtra("max_limit_num", 9));
                this.ulL.startActivityForResult(intent, 4);
            } else {
                this.ulL.startActivityForResult(intent, 0);
            }
        }
    }
}
