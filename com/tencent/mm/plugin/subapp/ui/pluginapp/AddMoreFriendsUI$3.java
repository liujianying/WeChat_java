package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fts.a.d;

class AddMoreFriendsUI$3 implements OnClickListener {
    final /* synthetic */ AddMoreFriendsUI otn;

    AddMoreFriendsUI$3(AddMoreFriendsUI addMoreFriendsUI) {
        this.otn = addMoreFriendsUI;
    }

    public final void onClick(View view) {
        Intent putExtra = new Intent().putExtra("Search_Scene", 2).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
        Bundle bundle = null;
        if (VERSION.SDK_INT >= 21) {
            bundle = ActivityOptions.makeSceneTransitionAnimation(this.otn, new Pair[0]).toBundle();
        }
        d.b(this.otn.mController.tml, ".ui.FTSAddFriendUI", putExtra, bundle);
    }
}
