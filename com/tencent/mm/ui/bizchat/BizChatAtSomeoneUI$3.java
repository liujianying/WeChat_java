package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ac.a.j;

class BizChatAtSomeoneUI$3 implements OnItemClickListener {
    final /* synthetic */ BizChatAtSomeoneUI tDX;

    BizChatAtSomeoneUI$3(BizChatAtSomeoneUI bizChatAtSomeoneUI) {
        this.tDX = bizChatAtSomeoneUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent intent = new Intent();
        if (i == 0 && BizChatAtSomeoneUI.access$100()) {
            intent.putExtra("Select_Conv_User", this.tDX.getString(R.l.at_all, new Object[]{""}));
            intent.putExtra("select_raw_user_name", "notify@all");
        } else {
            j jVar = (j) BizChatAtSomeoneUI.a(this.tDX).getItem(i);
            String a = BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.b(this.tDX), jVar.field_userId);
            intent.putExtra("select_raw_user_name", jVar.field_userId);
            intent.putExtra("Select_Conv_User", a);
        }
        this.tDX.setResult(-1, intent);
        this.tDX.finish();
    }
}
