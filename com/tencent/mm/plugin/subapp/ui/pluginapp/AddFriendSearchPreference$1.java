package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.view.View;
import android.view.View.OnClickListener;

class AddFriendSearchPreference$1 implements OnClickListener {
    final /* synthetic */ AddFriendSearchPreference otj;

    AddFriendSearchPreference$1(AddFriendSearchPreference addFriendSearchPreference) {
        this.otj = addFriendSearchPreference;
    }

    public final void onClick(View view) {
        if (AddFriendSearchPreference.a(this.otj) != null && AddFriendSearchPreference.b(this.otj) != null && AddFriendSearchPreference.b(this.otj).getText() != null) {
            AddFriendSearchPreference.b(this.otj).getText().toString();
        }
    }
}
