package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.permission.a;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.chatting.b.c;
import com.tencent.mm.ui.x;

@SuppressLint({"DefaultLocale", "ValidFragment"})
@TargetApi(11)
public class ChattingUI extends MMFragmentActivity {
    public ag tGH = new ag();
    public x tLY;

    public void onCreate(Bundle bundle) {
        getWindow().setFormat(-2);
        e.N(this);
        super.onCreate(null);
        if (c.av(getIntent())) {
            finish();
            return;
        }
        setContentView(R.i.chattingui_activity_container);
        this.tLY = new y((byte) 0);
        Bundle extras = getIntent().getExtras();
        extras.putBoolean("FROM_CHATTING_ACTIVITY", true);
        this.tLY.setArguments(extras);
        getSupportFragmentManager().bk().a(R.h.mm_root_view, this.tLY).commit();
        getSupportActionBar().show();
        if (getIntent().getBooleanExtra("resend_fail_messages", false)) {
            ah.i(new 1(this), 500);
            getIntent().putExtra("is_need_resend_sns", false);
        }
        a.Vj().Vk();
        initNavigationSwipeBack();
        this.tGH.post(new Runnable() {
            public final void run() {
                if (ChattingUI.this.tLY != null) {
                    e.a(ChattingUI.this, ChattingUI.this.tLY.getBodyView());
                }
                b.bu(ChattingUI.this.tLY.getContext());
            }
        });
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "chatting ui dispatch key event %s", new Object[]{keyEvent});
        if (this.tLY == null || !this.tLY.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "chatting ui on key up");
        return super.onKeyUp(i, keyEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "chatting ui on key down, %d, %s", new Object[]{Integer.valueOf(i), keyEvent});
        return super.onKeyDown(i, keyEvent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "chatting onRequestPermissionsResult");
        this.tLY.onRequestPermissionsResult(i, strArr, iArr);
    }
}
