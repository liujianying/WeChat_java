package com.tencent.mm.plugin.clean.ui.newui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.clean.c.c;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.c.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.i;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONObject;

public class CleanNewUI extends MMActivity implements g {
    private JSONObject hRA;
    private long hRw;
    private String hRx = "com.tencent.qqpimsecure";
    private String hRy = "00B1208638DE0FCD3E920886D658DAF6";
    private String hRz = "11206657";
    private LinearLayout hSO;
    private TextView hSP;
    private TextView hSQ;
    private Button hSR;
    private Button hSS;
    private TextView hST;
    private LinearLayout hSU;
    private TextView hSV;
    private TextView hSW;
    private Button hSX;
    private View hSY;
    private c hTw;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.clean_ui_title);
        setBackBtn(new 1(this));
        this.hSO = (LinearLayout) findViewById(R.h.wechat_root);
        this.hSP = (TextView) findViewById(R.h.wechat_size);
        this.hSQ = (TextView) findViewById(R.h.wechat_size_tip);
        this.hSR = (Button) findViewById(R.h.wechat_clean_msg_btn);
        this.hSS = (Button) findViewById(R.h.wechat_clean_cache_btn);
        this.hSS.setVisibility(8);
        this.hST = (TextView) findViewById(R.h.process_info_tv);
        this.hSR.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.CleanNewUI", "goto clean msg ui");
                CleanNewUI.this.startActivityForResult(new Intent(CleanNewUI.this, CleanMsgUI.class), 0);
            }
        });
        this.hSS.setOnClickListener(new 3(this));
        this.hSU = (LinearLayout) findViewById(R.h.mobile_root);
        this.hSV = (TextView) findViewById(R.h.mobile_size);
        this.hSW = (TextView) findViewById(R.h.mobile_size_tip);
        this.hSX = (Button) findViewById(R.h.qq_manager_clean_btn);
        this.hSY = findViewById(R.h.qq_manager_padding);
        this.hSX.setOnClickListener(new 4(this));
        if (bk.cjj() || e.bxk == 1) {
            this.hSX.setVisibility(8);
            this.hSY.setVisibility(0);
        }
        this.hSV.setText(bi.bF(c.aBa() - c.aBb()));
        this.hSW.setText(getString(R.l.clean_mobile_size_tips, new Object[]{bi.bF(r2)}));
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
        sendBroadcast(intent);
        try {
            b bVar = new b();
            bVar.sFu = "https://";
            bVar.host = "jtool.qq.com";
            bVar.uri = "/channel?productId=31&channelId=102133";
            new a((HttpURLConnection) new URL(bVar.getUrl()).openConnection()).a(bVar, new 5(this, ""), new ag());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CleanNewUI", e, e.getMessage(), new Object[0]);
        }
        d.a(new com.tencent.mm.plugin.clean.c.a.b());
        if (d.aBi() == null) {
            com.tencent.mm.plugin.clean.c.a.b aBg = d.aBg();
            if (aBg != null) {
                this.hTw = new c(aBg, this);
                com.tencent.mm.sdk.f.e.post(this.hTw, "CleanUI_clean");
                this.hSS.setEnabled(false);
                this.hSP.setVisibility(8);
                this.hSQ.setVisibility(8);
                this.hST.setVisibility(0);
                this.hST.setText(getString(R.l.analyse_file_profress, new Object[]{"0%"}));
            }
        }
    }

    public void onResume() {
        super.onResume();
        if (d.aBi() != null) {
            o(d.aBj(), c.aBa());
        }
    }

    private void o(long j, long j2) {
        this.hSS.setEnabled(true);
        this.hST.setVisibility(8);
        this.hSP.setVisibility(0);
        this.hSQ.setVisibility(0);
        this.hSP.setText(bi.bF(j));
        int i = (int) ((100 * j) / j2);
        this.hSQ.setText(getString(R.l.clean_wechat_size_tips, new Object[]{i + "%"}));
    }

    protected final int getLayoutId() {
        return R.i.clean_new_ui;
    }

    public final void cp(int i, int i2) {
        this.hST.setText(getString(R.l.analyse_file_profress, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void a(long j, long j2, long j3, ArrayList<com.tencent.mm.plugin.clean.c.b> arrayList, long j4, HashSet<String> hashSet) {
        x.i("MicroMsg.CleanNewUI", "wechatSize[%d] accSize[%d] otherAccSize[%d]", new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)});
        d.ci(j);
        d.cf(j2);
        d.ch(j4);
        d.b(hashSet);
        d.cg(j3);
        d.m(arrayList);
        o(d.aBj(), c.aBa());
    }

    private boolean aBv() {
        au.HU();
        String str = (String) com.tencent.mm.model.c.DT().get(aa.a.sSl, "");
        if (bi.oW(str)) {
            return false;
        }
        try {
            this.hRA = new JSONObject(str);
            this.hRx = this.hRA.getString("packageName");
            this.hRA.get("md5");
            this.hRz = this.hRA.getString("launcherID");
            this.hRy = this.hRA.getString("signature");
            this.hRA.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
            this.hRw = this.hRA.getLong("size");
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
            return false;
        }
    }

    private boolean aBu() {
        aBv();
        if (!p.r(this.mController.tml, this.hRx)) {
            return false;
        }
        Signature[] bh = p.bh(this, this.hRx);
        if (bh == null || bh[0] == null) {
            return false;
        }
        String u = com.tencent.mm.a.g.u(bh[0].toByteArray());
        if (u == null || !u.equalsIgnoreCase(this.hRy)) {
            return false;
        }
        try {
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(this.hRx);
            if (launchIntentForPackage != null) {
                Bundle bundle = new Bundle();
                p.g(bundle, this.hRz);
                launchIntentForPackage.putExtras(bundle);
                launchIntentForPackage.addFlags(268435456);
                startActivity(launchIntentForPackage);
                h.mEJ.a(282, 6, 1, false);
                return true;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
        }
        return true;
    }
}
