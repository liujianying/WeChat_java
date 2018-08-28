package com.tencent.mm.plugin.chatroom.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class SelectMemberUI$3 implements OnItemClickListener {
    final /* synthetic */ SelectMemberUI hPv;

    SelectMemberUI$3(SelectMemberUI selectMemberUI) {
        this.hPv = selectMemberUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (SelectMemberUI.d(this.hPv)) {
            case 1:
                if (SelectMemberUI.b(this.hPv).ok(i) == null) {
                    x.e("MicroMsg.SelectMemberUI", "getItem is null! position:%s", new Object[]{Integer.valueOf(i)});
                    return;
                }
                SelectMemberUI.a(this.hPv, SelectMemberUI.b(this.hPv).ok(i).guS.field_username);
                return;
            case 2:
                SelectMemberUI.a(this.hPv, i);
                return;
            default:
                x.w("MicroMsg.SelectMemberUI", "mFromScene is default");
                return;
        }
    }
}
