package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.jj;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.clean.b.a;
import com.tencent.mm.plugin.clean.b.c;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.j.b.5;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.c.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
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
import org.json.JSONObject;

public class CleanNewUI extends MMActivity {
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
    private boolean hSZ = false;
    private a hTa;
    private long hTb = 0;
    private long hTc = 0;
    private long hTd = 0;
    private long hTe = 0;
    private c hTf = new 6(this);
    private com.tencent.mm.sdk.b.c<jj> hTg = new 9(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.clean_msg_ui_title);
        setBackBtn(new 1(this));
        this.hSO = (LinearLayout) findViewById(R.h.wechat_root);
        this.hSP = (TextView) findViewById(R.h.wechat_size);
        this.hSQ = (TextView) findViewById(R.h.wechat_size_tip);
        this.hSR = (Button) findViewById(R.h.wechat_clean_msg_btn);
        this.hSR.setEnabled(false);
        this.hSS = (Button) findViewById(R.h.wechat_clean_cache_btn);
        this.hSS.setVisibility(8);
        this.hST = (TextView) findViewById(R.h.process_info_tv);
        this.hSR.setOnClickListener(new 2(this));
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
        j.aBt();
        long aBa = j.aBa();
        j.aBt();
        this.hSV.setText(bi.bF(aBa - j.aBb()));
        this.hSW.setText(getString(R.l.clean_mobile_size_tips, new Object[]{bi.bF(r4)}));
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
        sendBroadcast(intent);
        try {
            b bVar = new b();
            bVar.sFu = "https://";
            bVar.host = "jtool.qq.com";
            bVar.uri = "/channel?productId=31&channelId=102133";
            new com.tencent.mm.sdk.c.a((HttpURLConnection) new URL(bVar.getUrl()).openConnection()).a(bVar, new 5(this, ""), new ag());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CleanNewUI", e, e.getMessage(), new Object[0]);
        }
        if (com.tencent.mm.plugin.j.b.avr().avu()) {
            x.i("MicroMsg.CleanNewUI", "%s it scan finish", new Object[]{avy()});
            this.hSZ = false;
            aBz();
            this.hST.setText(getString(R.l.analyse_file_profress, new Object[]{"0%"}));
            h.mEJ.a(714, 50, 1, false);
        } else {
            x.w("MicroMsg.CleanNewUI", "%s it scan not finish", new Object[]{avy()});
            this.hTb = bi.VF();
            this.hSZ = true;
            com.tencent.mm.sdk.b.a.sFg.a(this.hTg);
            com.tencent.mm.plugin.j.b.avr().dN(true);
            aBy();
            cr(0, 100);
        }
        h.mEJ.a(714, 1, 1, false);
    }

    public void onResume() {
        super.onResume();
        if (this.hTe > 0 && j.aBt().hQC != 0) {
            long j = j.aBt().hQC;
            j.aBt();
            o(j, j.aBa());
        }
    }

    protected void onDestroy() {
        boolean z = false;
        super.onDestroy();
        x.i("MicroMsg.CleanNewUI", "%s stop maunal scan needScanWxFileIndex[%b]", new Object[]{avy(), Boolean.valueOf(this.hSZ)});
        if (this.hSZ) {
            com.tencent.mm.sdk.b.a.sFg.c(this.hTg);
            com.tencent.mm.plugin.j.b avr = com.tencent.mm.plugin.j.b.avr();
            String str = "MicroMsg.CalcWxService";
            String str2 = "%s stop manual scan now manualScanTask[%b]";
            Object[] objArr = new Object[2];
            objArr[0] = avr.avy();
            if (avr.hsL != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            avr.j(new 5(avr));
        }
        if (this.hTa != null) {
            this.hTa.stop();
        }
    }

    private void o(long j, long j2) {
        this.hSS.setEnabled(true);
        this.hST.setVisibility(8);
        this.hSP.setVisibility(0);
        this.hSQ.setVisibility(0);
        this.hSR.setEnabled(true);
        this.hSP.setText(bi.bF(j));
        if (((int) ((100 * j) / j2)) > 0) {
            this.hSQ.setText(getString(R.l.clean_wechat_size_tips, new Object[]{r0 + "%"}));
            return;
        }
        this.hSQ.setText(R.l.clean_wechat_size_tips_less_1_percent);
    }

    private void aBy() {
        this.hSS.setEnabled(false);
        this.hSP.setVisibility(8);
        this.hSQ.setVisibility(8);
        this.hST.setVisibility(0);
    }

    private void aBz() {
        this.hTa = new a(this.hTf);
        this.hTd = bi.VF();
        com.tencent.mm.sdk.f.e.post(this.hTa, "cleanUI_calc");
        aBy();
        h.mEJ.a(714, 52, 1, false);
    }

    protected final int getLayoutId() {
        return R.i.clean_new_ui;
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
        String u = g.u(bh[0].toByteArray());
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
                h.mEJ.a(714, 7, 1, false);
                return true;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
        }
        return true;
    }

    public final void cr(int i, int i2) {
        ah.A(new 7(this, i, i2));
    }

    private String avy() {
        return hashCode();
    }
}
