package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.g.a;
import com.tencent.mm.ab.g.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.k;
import junit.framework.Assert;

public class MassSendHistoryUI extends MMActivity implements a, b, SensorController.a {
    private static SensorController hlW;
    private com.tencent.mm.e.a.a bAW;
    private boolean hlZ = true;
    private d hqV = new 4(this);
    private View kwy;
    private ListView laZ;
    private c lba;
    private Button lbb;
    private Button lbc;
    private MMPullDownView lbd;
    private boolean lbe = false;
    private LinearLayout lbf;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.mass_send_helper);
        if (hlW == null) {
            hlW = new SensorController(getApplicationContext());
        }
        initView();
        this.bAW = new com.tencent.mm.e.a.a(this);
        this.bAW.bCU = this;
        this.bAW.bCT = this;
        this.lba.laP = new 1(this);
        if (this.mController != null) {
            this.mController.ak(3, false);
        }
    }

    protected void onResume() {
        super.onResume();
        h.bco().c(this.lba);
        this.lba.a(null, null);
        this.laZ.setSelection(this.lba.getCount() - 1);
    }

    protected void onPause() {
        super.onPause();
        au.HV().yO();
        h.bco().d(this.lba);
        hlW.ciL();
    }

    protected void onDestroy() {
        this.lba.aYc();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.mass_send_history;
    }

    protected final void initView() {
        this.lbe = getIntent().getBooleanExtra("finish_direct", false);
        x.d("MicroMsg.MassSendHistoryUI", "isFromSearch  " + this.lbe);
        this.lbf = (LinearLayout) findViewById(R.h.mass_send_next_ll);
        this.laZ = (ListView) findViewById(R.h.mass_send_history_list);
        this.laZ.setTranscriptMode(0);
        this.lbd = (MMPullDownView) findViewById(R.h.mass_send_history_pull_down_view);
        this.lbd.setOnTopLoadDataListener(new 5(this));
        this.lbd.setTopViewVisible(true);
        this.lbd.setAtBottomCallBack(new 6(this));
        this.lbd.setAtTopCallBack(new 7(this));
        this.lbd.setIsBottomShowAll(true);
        this.lba = new c(this);
        this.lba.tlG = new 8(this);
        this.kwy = findViewById(R.h.mass_send_history_empty_view);
        this.laZ.setAdapter(this.lba);
        this.laZ.setOnItemClickListener(new 9(this));
        this.laZ.setOnTouchListener(new 10(this));
        this.lbb = (Button) findViewById(R.h.mass_send_next);
        this.lbb.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                MassSendHistoryUI.this.startActivity(new Intent(MassSendHistoryUI.this, MassSendSelectContactUI.class));
            }
        });
        this.lbc = (Button) findViewById(R.h.mass_send_next_two);
        this.lbc.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                MassSendHistoryUI.this.startActivity(new Intent(MassSendHistoryUI.this, MassSendSelectContactUI.class));
            }
        });
        setBackBtn(new 2(this));
        addIconOptionMenu(0, R.l.app_set, R.k.actionbar_setting_icon, new 3(this));
        new k(this).a(this.laZ, this, this.hqV);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.lbe) {
            a();
        } else {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            com.tencent.mm.plugin.masssend.a.ezn.q(intent, this);
            a();
        }
        return true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        x.v("MicroMsg.MassSendHistoryUI", "onCreateContextMenu");
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        String[] split = ((com.tencent.mm.plugin.masssend.a.a) this.lba.getItem(adapterContextMenuInfo.position)).bcj().split(";");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : split) {
            au.HU();
            ab Yg = c.FR().Yg(str);
            if (Yg != null) {
                stringBuilder.append(Yg.BL() + ";");
            }
        }
        contextMenu.setHeaderTitle(stringBuilder.toString());
        contextMenu.add(adapterContextMenuInfo.position, 1, 0, getString(R.l.chatting_long_click_menu_delete_msg));
    }

    protected final void releaseWakeLock() {
        this.laZ.setKeepScreenOn(false);
    }

    public final void dK(boolean z) {
        if (this.bAW != null) {
            if (this.bAW.isPlaying()) {
                this.bAW.aK(z);
                au.HV().e(z, false, false);
                this.hlZ = z;
                if (!z) {
                    if (Gn(this.lba.laO)) {
                        this.lba.Gl(this.lba.laO);
                        return;
                    } else {
                        this.lba.Gl("");
                        return;
                    }
                }
                return;
            }
            this.bAW.aK(true);
            au.HV().e(true, false, false);
            this.hlZ = true;
        }
    }

    private boolean Gn(String str) {
        Assert.assertTrue(str != null);
        hlW.a(this);
        com.tencent.mm.plugin.masssend.a.a Gi = h.bco().Gi(str);
        au.HU();
        if (c.isSDCardAvailable() || bi.oW(Gi.bch())) {
            if (this.bAW == null) {
                this.bAW = new com.tencent.mm.e.a.a(this);
            }
            this.bAW.aJ(false);
            if (this.bAW.m(Gi.bch(), this.hlZ)) {
                au.HV().e(this.hlZ, false, false);
                this.bAW.bCU = this;
                this.bAW.bCT = this;
                return true;
            }
            Toast.makeText(this, getString(R.l.chatting_play_err), 0).show();
            return false;
        }
        s.gH(this);
        return false;
    }

    private void stopPlay() {
        hlW.ciL();
        this.bAW.aJ(false);
        this.lba.Gl("");
        releaseWakeLock();
    }

    public final void wd() {
        stopPlay();
    }

    public final void onError() {
        stopPlay();
    }
}
