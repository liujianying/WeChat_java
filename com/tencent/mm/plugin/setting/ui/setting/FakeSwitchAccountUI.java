package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@a(3)
public class FakeSwitchAccountUI extends MMActivity {
    private int cXC;
    private int count;
    private String country;
    private String eSe;
    private SwitchAccountGridView mPR;
    private View mPS;
    private View mPT;
    private ArrayList<SwitchAccountModel> mPU;
    private Map<String, SwitchAccountModel> mPV = new HashMap();
    private al mPW;

    static /* synthetic */ void e(FakeSwitchAccountUI fakeSwitchAccountUI) {
        x.i("MicroMsg.FakeSwitchAccountUI", "jump to launcher");
        fakeSwitchAccountUI.mPW.SO();
        Intent intent = new Intent();
        intent.setClassName(fakeSwitchAccountUI, "com.tencent.mm.ui.LauncherUI");
        intent.addFlags(67108864);
        intent.putExtra("LauncherUI.jump_switch_account", true);
        intent.putExtra("key_switch_from_wx_username", fakeSwitchAccountUI.eSe);
        intent.putParcelableArrayListExtra("key_switch_account_users", fakeSwitchAccountUI.mPU);
        fakeSwitchAccountUI.startActivity(intent);
        fakeSwitchAccountUI.finish();
        b.gG(fakeSwitchAccountUI);
    }

    protected final int getLayoutId() {
        return g.settings_switch_account;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.country = getIntent().getStringExtra("key_langauage_code");
        if (!bi.oW(this.country)) {
            x.i("MicroMsg.FakeSwitchAccountUI", "country %s", new Object[]{this.country});
            be.setProperty("language_key", this.country);
            s.bw(ad.getContext(), this.country);
        }
        initView();
    }

    protected final void initView() {
        x.i("MicroMsg.FakeSwitchAccountUI", "FakeSwitchAccount onCreate");
        setMMTitle("");
        getSupportActionBar().hide();
        this.mPR = (SwitchAccountGridView) findViewById(f.switch_account_grid);
        this.mPR.setRowCount(1);
        this.mPR.setClickable(false);
        this.cXC = getIntent().getIntExtra("key_mm_process_pid", 0);
        this.eSe = getIntent().getStringExtra("key_switch_from_wx_username");
        x.i("MicroMsg.FakeSwitchAccountUI", "title %s", new Object[]{getResources().getString(i.settings_switch_account_login_title)});
        this.mPU = getIntent().getParcelableArrayListExtra("key_switch_account_users");
        if (this.mPU != null) {
            Iterator it = this.mPU.iterator();
            while (it.hasNext()) {
                SwitchAccountModel switchAccountModel = (SwitchAccountModel) it.next();
                this.mPV.put(switchAccountModel.mOP, switchAccountModel);
            }
        }
        this.mPS = findViewById(f.switch_account_delete_btn);
        this.mPS.setVisibility(8);
        this.mPT = findViewById(f.switch_account_cancel_btn);
        this.mPT.setVisibility(8);
        x.i("MicroMsg.FakeSwitchAccountUI", "account count %d", new Object[]{Integer.valueOf(this.mPV.size())});
        this.mPR.setUseSystemDecoder(true);
        this.mPR.L(this.mPV);
        this.mPR.setLastLoginWxUsername(this.eSe);
        this.mPR.setLogoutState(true);
        this.mPR.bum();
        this.mPW = new al(Looper.myLooper(), new 1(this), true);
        if (this.mPW != null) {
            this.mPW.J(1500, 500);
        }
    }

    private int btt() {
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals("com.tencent.mm")) {
                    x.i("MicroMsg.FakeSwitchAccountUI", "process %s, %s", new Object[]{runningAppProcessInfo.processName, Integer.valueOf(runningAppProcessInfo.pid)});
                    return runningAppProcessInfo.pid;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.FakeSwitchAccountUI", "isMMProcessExist Exception: " + e.toString());
        } catch (Error e2) {
            x.e("MicroMsg.FakeSwitchAccountUI", "isMMProcessExist Error: " + e2.toString());
        }
        return 0;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected void onResume() {
        super.onResume();
        x.i("MicroMsg.FakeSwitchAccountUI", "fake switch account resume");
    }

    protected void onStop() {
        super.onStop();
        x.i("MicroMsg.FakeSwitchAccountUI", "fake switch account stop");
    }

    protected void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.FakeSwitchAccountUI", "fake switch account destroy");
    }
}
