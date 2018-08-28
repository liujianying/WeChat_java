package com.tencent.mm.plugin.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.chatroom.d.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;

public class RoomUpgradeUI extends MMActivity implements e {
    private String chatroomName;
    private ProgressDialog eHw = null;
    private int hKY;
    private int hKZ;
    private u hLB;
    private View hNT;
    private ImageView hNU;
    private TextView hNV;
    private TextView hNW;
    private TextView hNX;
    private TextView hOb;
    private View hOc;
    private TextView hOd;
    private h hOe;
    private String hOf;
    private boolean hOg;
    private boolean hOh;
    private int status;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Wj();
        initView();
    }

    public void onNewIntent(Intent intent) {
        boolean booleanExtra;
        if (intent.hasExtra("upgrade_success")) {
            booleanExtra = intent.getBooleanExtra("upgrade_success", false);
        } else {
            if (intent.hasExtra("wizard_activity_result_code") && intent.getIntExtra("wizard_activity_result_code", -1) == -1) {
                aAQ();
            }
            if (intent.hasExtra("announce_ok")) {
                aAQ();
            }
            booleanExtra = false;
        }
        if (booleanExtra) {
            Wj();
            int intExtra = intent.getIntExtra("left_quota", 0);
            aAR();
            this.hOd.setVisibility(8);
            this.hKZ = intExtra;
            if (this.hKZ > 0) {
                this.hNX.setText(getString(R.l.room_upgrade_info_quota_left, new Object[]{Integer.valueOf(this.hKZ)}));
            } else {
                this.hNX.setText(getString(R.l.room_upgrade_info_quota_run_out));
            }
            if (!this.hOh) {
                this.hOb.setVisibility(0);
            }
            this.hOb.setText(R.l.room_upgrade_how_to_upgrade_maxcount_member_view);
        }
    }

    private void aAQ() {
        Intent intent = new Intent(this, RoomAlphaProcessUI.class);
        intent.addFlags(67108864);
        intent.addFlags(GLIcon.RIGHT);
        intent.putExtra("RoomInfo_Id", this.chatroomName);
        startActivity(intent);
    }

    private void Wj() {
        boolean z = true;
        this.chatroomName = getIntent().getStringExtra("room_name");
        x.i("MicroMsg.RoomUpgradeProductsUI", "the roomName is %s", new Object[]{this.chatroomName});
        au.DF().a(519, this);
        au.HU();
        this.hLB = c.Ga().ih(this.chatroomName);
        if (this.hLB == null) {
            finish();
            return;
        }
        this.hOg = q.GF().equals(this.hLB.field_roomowner);
        if (w.chM()) {
            z = false;
        }
        this.hOh = z;
    }

    protected final void initView() {
        setMMTitle(R.l.room_upgrade_entry_maxcount);
        setBackBtn(new 1(this));
        this.hNT = findViewById(R.h.upgrader_info_container);
        this.hOc = findViewById(R.h.upgrader_responsibility);
        this.hNU = (ImageView) findViewById(R.h.upgrader_avatar);
        this.hNV = (TextView) findViewById(R.h.upgrader_nickname);
        this.hNW = (TextView) findViewById(R.h.upgrade_intro);
        this.hNX = (TextView) findViewById(R.h.upgrade_quota_left);
        this.hOd = (TextView) findViewById(R.h.upgrade_button);
        this.hOd.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                switch (RoomUpgradeUI.this.status) {
                    case 1:
                        if (RoomUpgradeUI.this.hOh) {
                            a.a(RoomUpgradeUI.this, RoomUpgradeUI.this.chatroomName, true);
                            return;
                        } else {
                            RoomUpgradeUI.a(RoomUpgradeUI.this, true);
                            return;
                        }
                    case 2:
                    case 5:
                        if (RoomUpgradeUI.this.hOh) {
                            RoomUpgradeUI.this.aAQ();
                            return;
                        } else {
                            RoomUpgradeUI.a(RoomUpgradeUI.this, false);
                            return;
                        }
                    default:
                        return;
                }
            }
        });
        this.hOb = (TextView) findViewById(R.h.how_to_upgrade_maxcount);
        this.hOb.setOnClickListener(new 3(this));
        if (this.hOg) {
            this.eHw = com.tencent.mm.ui.base.h.a(this, getString(R.l.loading_tips), true, new 5(this));
            this.hOe = new h(this.chatroomName);
            au.DF().a(this.hOe, 0);
        } else {
            aAR();
            if (!this.hOh) {
                this.hOb.setVisibility(0);
            }
            this.hOb.setText(R.l.room_upgrade_how_to_upgrade_maxcount_member_view);
            this.hOd.setVisibility(8);
            this.hNX.setVisibility(8);
        }
        if (this.hOh) {
            this.hOb.setVisibility(8);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        au.DF().c(this.hOe);
        au.DF().b(519, this);
        if (this.eHw != null) {
            this.eHw.dismiss();
        }
        super.onDestroy();
    }

    private void aAR() {
        final String str = this.hLB.field_roomowner;
        au.HU();
        ab Yg = c.FR().Yg(str);
        if (Yg == null || ((int) Yg.dhP) > 0) {
            yo(str);
        } else {
            a.dBr.a(str, this.chatroomName, new b.a() {
                public final void x(String str, boolean z) {
                    if (z) {
                        RoomUpgradeUI.this.hNT.post(new 1(this));
                    }
                }
            });
        }
        int ckO = this.hLB.ckO();
        this.hNW.setVisibility(0);
        if (ckO <= 40) {
            this.hNW.setText(getString(R.l.room_upgrade_intro_maxcount, new Object[]{getString(R.l.room_upgrade_entry_maxcount_summary_normal)}));
            return;
        }
        this.hNW.setText(getString(R.l.room_upgrade_intro_maxcount, new Object[]{getString(R.l.room_upgrade_entry_maxcount_summary_biggroup)}));
    }

    private void yo(String str) {
        String str2;
        CharSequence charSequence = null;
        au.HU();
        ab Yg = c.FR().Yg(str);
        if (Yg == null || ((int) Yg.dhP) <= 0) {
            str2 = null;
        } else {
            str2 = Yg.field_conRemark;
        }
        if (!bi.oW(str2)) {
            Object charSequence2 = str2;
        } else if (this.hLB != null) {
            charSequence2 = this.hLB.gT(str);
        }
        if (bi.oW(charSequence2) && Yg != null && ((int) Yg.dhP) > 0) {
            charSequence2 = Yg.BK();
        }
        if (bi.oW(charSequence2)) {
            charSequence2 = str;
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(this.hNU, str);
        this.hNV.setVisibility(0);
        this.hNV.setText(j.a(this, charSequence2, (int) this.hNV.getTextSize()));
    }

    public final int getLayoutId() {
        return R.i.chatroom_upgrade;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.RoomUpgradeProductsUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        switch (i) {
            case 400:
                finish();
                return;
            default:
                x.e("MicroMsg.RoomUpgradeProductsUI", "onActivityResult unknow request");
                return;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.RoomUpgradeProductsUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.eHw != null) {
            this.eHw.dismiss();
        }
        if (i != 0 || i2 != 0) {
            com.tencent.mm.ui.base.h.a(this, getString(R.l.room_upgrade_info_err), getString(R.l.app_tip), false, new 6(this));
        } else if (i == 0 && i2 == 0 && lVar.getType() == 519) {
            h hVar = (h) lVar;
            this.status = hVar.status;
            this.hKY = hVar.hKY;
            this.hKZ = hVar.hKZ;
            aAR();
            this.hNX.setVisibility(0);
            this.hOd.setText(getString(R.l.room_upgrade_button_bigchatroom));
            if (this.hKZ > 0) {
                this.hNX.setText(getString(R.l.room_upgrade_info_quota_left, new Object[]{Integer.valueOf(this.hKZ)}));
            } else {
                this.hNX.setText(getString(R.l.room_upgrade_info_quota_run_out));
            }
            if (!this.hOh) {
                this.hOb.setVisibility(0);
            }
            switch (this.status) {
                case 1:
                case 2:
                case 5:
                    this.hOd.setVisibility(0);
                    this.hOb.setText(R.l.room_upgrade_how_to_upgrade_maxcount_owner_view);
                    return;
                case 3:
                case 4:
                case 6:
                    this.hOd.setVisibility(0);
                    this.hOd.setEnabled(false);
                    this.hOb.setText(R.l.room_upgrade_how_to_upgrade_maxcount_owner_view);
                    return;
                case 7:
                    this.hOd.setVisibility(8);
                    this.hOb.setText(R.l.room_upgrade_how_to_upgrade_maxcount_member_view);
                    this.hOd.setEnabled(false);
                    return;
                default:
                    return;
            }
        }
    }
}
