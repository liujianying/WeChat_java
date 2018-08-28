package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class AddFriendSearchPreference$3 implements OnTouchListener {
    final /* synthetic */ AddFriendSearchPreference otj;

    AddFriendSearchPreference$3(AddFriendSearchPreference addFriendSearchPreference) {
        this.otj = addFriendSearchPreference;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            AddFriendSearchPreference.c(this.otj).onClick(view);
        }
        return true;
    }
}
