package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.report.service.h;

class IPCallContactUI$6 implements OnItemClickListener {
    final /* synthetic */ IPCallContactUI kuK;

    IPCallContactUI$6(IPCallContactUI iPCallContactUI) {
        this.kuK = iPCallContactUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!IPCallContactUI.d(this.kuK).qY(i)) {
            c rA = IPCallContactUI.d(this.kuK).getItem(i);
            if (rA != null) {
                if (!IPCallContactUI.e(this.kuK)) {
                    h.mEJ.h(12767, new Object[]{Integer.valueOf(2)});
                }
                Intent intent = new Intent(this.kuK.mController.tml, IPCallUserProfileUI.class);
                intent.putExtra("IPCallProfileUI_contactid", rA.field_contactId);
                intent.putExtra("IPCallProfileUI_systemUsername", rA.field_systemAddressBookUsername);
                intent.putExtra("IPCallProfileUI_wechatUsername", rA.field_wechatUsername);
                this.kuK.mController.tml.startActivity(intent);
            }
        }
    }
}
