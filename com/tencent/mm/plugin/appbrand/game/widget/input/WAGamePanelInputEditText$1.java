package com.tencent.mm.plugin.appbrand.game.widget.input;

import android.text.Editable;
import android.text.Editable.Factory;

class WAGamePanelInputEditText$1 extends Factory {
    final /* synthetic */ WAGamePanelInputEditText fDB;

    WAGamePanelInputEditText$1(WAGamePanelInputEditText wAGamePanelInputEditText) {
        this.fDB = wAGamePanelInputEditText;
    }

    public final Editable newEditable(CharSequence charSequence) {
        return WAGamePanelInputEditText.a(this.fDB).c((Editable) WAGamePanelInputEditText.a(this.fDB, super.newEditable(charSequence)));
    }
}
