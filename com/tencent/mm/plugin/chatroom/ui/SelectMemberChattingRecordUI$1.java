package com.tencent.mm.plugin.chatroom.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.storage.bd;

class SelectMemberChattingRecordUI$1 implements OnItemClickListener {
    final /* synthetic */ SelectMemberChattingRecordUI hPm;

    SelectMemberChattingRecordUI$1(SelectMemberChattingRecordUI selectMemberChattingRecordUI) {
        this.hPm = selectMemberChattingRecordUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bd bdVar = (bd) SelectMemberChattingRecordUI.a(this.hPm).getItem(i);
        if (bdVar != null) {
            SelectMemberChattingRecordUI.a(this.hPm, bdVar.field_msgId);
        }
    }
}
