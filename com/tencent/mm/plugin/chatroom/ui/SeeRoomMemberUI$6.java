package com.tencent.mm.plugin.chatroom.ui;

import android.text.Editable;
import android.text.TextWatcher;

class SeeRoomMemberUI$6 implements TextWatcher {
    final /* synthetic */ SeeRoomMemberUI hOM;

    SeeRoomMemberUI$6(SeeRoomMemberUI seeRoomMemberUI) {
        this.hOM = seeRoomMemberUI;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        SeeRoomMemberUI.c(this.hOM).yr(charSequence.toString());
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
    }
}
