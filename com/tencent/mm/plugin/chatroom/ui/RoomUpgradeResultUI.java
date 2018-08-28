package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public class RoomUpgradeResultUI extends MMActivity {
    private String chatroomName;
    private u hLB;
    private Button hNS;
    private View hNT;
    private ImageView hNU;
    private TextView hNV;
    private TextView hNW;
    private TextView hNX;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.chatroomName = getIntent().getStringExtra("chatroom");
        x.i("MicroMsg.RoomUpgradeResultUI", "the roomName is %s", new Object[]{this.chatroomName});
        au.HU();
        this.hLB = c.Ga().ih(this.chatroomName);
        if (this.hLB == null) {
            goBack();
        }
        initView();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.room_upgrade_entry_maxcount);
        setBackBtn(new 1(this));
        this.hNT = findViewById(R.h.upgrader_info_container);
        this.hNU = (ImageView) findViewById(R.h.upgrader_avatar);
        this.hNV = (TextView) findViewById(R.h.upgrader_nickname);
        this.hNW = (TextView) findViewById(R.h.upgrade_intro);
        this.hNX = (TextView) findViewById(R.h.upgrade_quota_left);
        this.hNS = (Button) findViewById(R.h.how_to_upgrade_maxcount);
        this.hNS.setOnClickListener(new 2(this));
        this.hNS.setVisibility(0);
        String str = this.hLB.field_roomowner;
        au.HU();
        ab Yg = c.FR().Yg(str);
        if (Yg == null || ((int) Yg.dhP) > 0) {
            yo(str);
        } else {
            a.dBr.a(str, this.chatroomName, new 3(this, str));
        }
        int ckO = this.hLB.ckO();
        this.hNW.setVisibility(0);
        this.hNW.setText(getString(R.l.room_upgrade_intro_maxcount, new Object[]{Integer.valueOf(ckO)}));
        this.hNS.setText(R.l.room_upgrade_how_to_upgrade_maxcount_member_view);
        this.hNX.setVisibility(8);
    }

    private void yo(String str) {
        au.HU();
        ab Yg = c.FR().Yg(str);
        if (Yg != null && ((int) Yg.dhP) > 0) {
            CharSequence BK = Yg.BK();
            b.a(this.hNU, str);
            this.hNV.setVisibility(0);
            this.hNV.setText(BK);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        Intent intent = new Intent(this, RoomUpgradeUI.class);
        intent.addFlags(67108864);
        intent.putExtra("finish_self", true);
        startActivity(intent);
    }

    protected final int getLayoutId() {
        return R.i.chatroom_upgrade;
    }
}
