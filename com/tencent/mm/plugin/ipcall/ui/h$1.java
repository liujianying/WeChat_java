package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.plugin.report.service.h;

class h$1 implements OnClickListener {
    final /* synthetic */ h kxi;

    h$1(h hVar) {
        this.kxi = hVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (c.dK(h.a(this.kxi))) {
                k rG = this.kxi.rG(intValue);
                com.tencent.mm.plugin.ipcall.a.g.c cVar = null;
                if (rG.field_addressId > 0) {
                    if (h.b(this.kxi).containsKey(Long.valueOf(rG.field_addressId))) {
                        cVar = (com.tencent.mm.plugin.ipcall.a.g.c) h.b(this.kxi).get(Long.valueOf(rG.field_addressId));
                    } else {
                        cVar = i.aXv().dN(rG.field_addressId);
                    }
                    if (cVar != null) {
                        h.b(this.kxi).put(Long.valueOf(rG.field_addressId), cVar);
                    }
                }
                Intent intent;
                if (cVar != null) {
                    intent = new Intent(h.c(this.kxi), IPCallTalkUI.class);
                    intent.putExtra("IPCallTalkUI_phoneNumber", rG.field_phonenumber);
                    intent.putExtra("IPCallTalkUI_contactId", cVar.field_contactId);
                    intent.putExtra("IPCallTalkUI_nickname", cVar.field_systemAddressBookUsername);
                    intent.putExtra("IPCallTalkUI_toWechatUsername", cVar.field_wechatUsername);
                    intent.putExtra("IPCallTalkUI_dialScene", 3);
                    h.mEJ.h(12059, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3)});
                    ((FragmentActivity) h.d(this.kxi)).startActivityForResult(intent, 1001);
                    return;
                }
                intent = new Intent(h.e(this.kxi), IPCallTalkUI.class);
                intent.putExtra("IPCallTalkUI_phoneNumber", rG.field_phonenumber);
                intent.putExtra("IPCallTalkUI_dialScene", 3);
                h.mEJ.h(12059, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3)});
                ((FragmentActivity) h.f(this.kxi)).startActivityForResult(intent, 1001);
            }
        }
    }
}
