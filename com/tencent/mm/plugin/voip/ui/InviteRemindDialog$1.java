package com.tencent.mm.plugin.voip.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bh.d.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.voip.model.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class InviteRemindDialog$1 implements OnClickListener {
    final /* synthetic */ InviteRemindDialog oPZ;

    InviteRemindDialog$1(InviteRemindDialog inviteRemindDialog) {
        this.oPZ = inviteRemindDialog;
    }

    public final void onClick(View view) {
        if (InviteRemindDialog.a(this.oPZ) != null) {
            try {
                au.HU();
                Map Uv = a.Uv((String) c.DT().get(77829, null));
                a aVar;
                if (Uv != null) {
                    if (Uv != null && Uv.size() > 0) {
                        if (Uv.containsKey(InviteRemindDialog.a(this.oPZ))) {
                            aVar = (a) Uv.get(InviteRemindDialog.a(this.oPZ));
                            aVar.ecL++;
                            Uv.put(InviteRemindDialog.a(this.oPZ), aVar);
                        } else {
                            aVar = new a();
                            aVar.ecL++;
                            Uv.put(InviteRemindDialog.a(this.oPZ), aVar);
                        }
                    }
                    au.HU();
                    c.DT().set(77829, a.at(Uv));
                    for (Entry value : Uv.entrySet()) {
                        aVar = (a) value.getValue();
                        x.d("MMInviteRemindDialog", "val " + aVar.hitCount + " " + aVar.ecL);
                    }
                } else {
                    Map hashMap = new HashMap();
                    a aVar2 = new a();
                    aVar2.ecL++;
                    hashMap.put(InviteRemindDialog.a(this.oPZ), aVar2);
                    au.HU();
                    c.DT().set(77829, a.at(hashMap));
                    for (Entry value2 : hashMap.entrySet()) {
                        aVar = (a) value2.getValue();
                        x.d("MMInviteRemindDialog", "val " + aVar.hitCount + " " + aVar.ecL);
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MMInviteRemindDialog", e, "", new Object[0]);
            }
        }
        String string = InviteRemindDialog.b(this.oPZ) == 0 ? this.oPZ.getString(R.l.voip_invite_msg_text) : InviteRemindDialog.b(this.oPZ) == 1 ? this.oPZ.getString(R.l.voip_voice_invite_msg_text) : null;
        au.DF().a(new g(InviteRemindDialog.a(this.oPZ), string, s.hQ(InviteRemindDialog.a(this.oPZ))), 0);
        Intent intent = new Intent();
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("Chat_User", InviteRemindDialog.a(this.oPZ));
        com.tencent.mm.plugin.voip.a.a.ezn.e(intent, this.oPZ);
        this.oPZ.finish();
    }
}
