package com.tencent.mm.ui.conversation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.ui.conversation.BaseConversationUI.a;
import com.tencent.mm.ui.x;

public class BaseConversationUI$b extends x {
    private a fmStatus = a.unr;
    public BaseConversationUI ui;

    public int getLayoutId() {
        return 0;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fmStatus = a.unr;
        this.ui = (BaseConversationUI) thisActivity();
        View inflate = layoutInflater.inflate(getLayoutId(), viewGroup, false);
        setHasOptionsMenu(true);
        return inflate;
    }

    public void setMMTitle(String str) {
        if (this.ui != null) {
            this.ui.setTitle(str);
        }
    }

    public void finish() {
        thisActivity().finish();
    }

    public void onResume() {
        super.onResume();
        this.fmStatus = a.uns;
    }

    public void onPause() {
        super.onPause();
        this.fmStatus = a.unt;
    }

    public void onDestroy() {
        if (this.fmStatus != a.unt) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.BaseConversationUI", "fmStatus != ActivityStatus.ACTIVITY_PAUSE when fm onDestroy");
            onPause();
        }
        super.onDestroy();
    }

    public String getUserName() {
        return null;
    }
}
