package com.tencent.mm.plugin.chatroom.ui;

import android.text.Editable;
import android.text.TextWatcher;

class RoomCardUI$a implements TextWatcher {
    private boolean hNA;
    final /* synthetic */ RoomCardUI hNw;
    private int hNy;
    private String hNz;

    private RoomCardUI$a(RoomCardUI roomCardUI) {
        this.hNw = roomCardUI;
        this.hNy = 280;
        this.hNz = "";
        this.hNA = false;
    }

    /* synthetic */ RoomCardUI$a(RoomCardUI roomCardUI, byte b) {
        this(roomCardUI);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        RoomCardUI.d(this.hNw);
    }

    public final void afterTextChanged(Editable editable) {
    }
}
