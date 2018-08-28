package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.chatting.AtSomeoneUI.a;

class AtSomeoneUI$3 implements OnItemClickListener {
    final /* synthetic */ AtSomeoneUI tHd;

    AtSomeoneUI$3(AtSomeoneUI atSomeoneUI) {
        this.tHd = atSomeoneUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = 1;
        Intent intent = new Intent();
        if (i == 0 && AtSomeoneUI.access$100()) {
            intent.putExtra("Select_Conv_User", this.tHd.getString(R.l.at_all, new Object[]{""}));
            intent.putExtra("select_raw_user_name", "notify@all");
        } else {
            a a = AtSomeoneUI.a(this.tHd);
            if (!AtSomeoneUI.access$100()) {
                i2 = 0;
            }
            ab abVar = (ab) a.getItem(i - i2);
            String a2 = AtSomeoneUI.a(AtSomeoneUI.b(this.tHd), abVar.field_username);
            if (ai.oW(a2)) {
                a2 = abVar.BK();
            }
            intent.putExtra("select_raw_user_name", abVar.field_username);
            intent.putExtra("Select_Conv_User", a2);
        }
        this.tHd.setResult(-1, intent);
        this.tHd.finish();
    }
}
