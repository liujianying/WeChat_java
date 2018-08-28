package com.tencent.mm.plugin.sns.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s.b;

@a(17)
public class SnsCommentUI extends MMActivity implements e {
    private int bNv;
    private SnsEditText nVT;
    private int nVU = 0;
    private boolean nVV = false;
    private boolean nVW = false;
    private int nkZ;
    private p tipDialog = null;

    static /* synthetic */ void a(SnsCommentUI snsCommentUI, String str) {
        n xd = af.byo().xd(snsCommentUI.nkZ);
        if (xd != null) {
            snsCommentUI.nVV = true;
            if (xd.bBd()) {
                am.a.a(xd, 2, str, "", snsCommentUI.bNv);
            } else {
                am.a.a(xd.field_userName, 3, str, xd, snsCommentUI.bNv);
            }
            snsCommentUI.YC();
            snsCommentUI.getString(i$j.app_tip);
            snsCommentUI.tipDialog = h.a(snsCommentUI, snsCommentUI.getString(i$j.app_sending), true, new 1(snsCommentUI));
        }
    }

    static /* synthetic */ void b(SnsCommentUI snsCommentUI, String str) {
        if (!snsCommentUI.isFinishing()) {
            q.GF();
            ax axVar = new ax(2);
            axVar.My(str);
            if (snsCommentUI.nVT.getPasterLen() > com.tencent.mm.plugin.sns.c.a.nkE) {
                axVar.wC(2);
            }
            axVar.commit();
            snsCommentUI.setResult(-1);
            snsCommentUI.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nkZ = getIntent().getIntExtra("sns_comment_localId", 0);
        this.nVU = getIntent().getIntExtra("sns_comment_type", 0);
        this.bNv = getIntent().getIntExtra("sns_source", 0);
        g.Ek();
        g.Eh().dpP.a(213, this);
        initView();
    }

    public void onPause() {
        super.onPause();
        if (this.nVT != null) {
            String trim = this.nVT.getText().toString().trim();
            g.Ek();
            g.Ei().DT().set(68408, trim);
            if (bi.oW(trim)) {
                g.Ek();
                g.Ei().DT().set(7489, Integer.valueOf(0));
                return;
            }
            g.Ek();
            g.Ei().DT().set(7489, Integer.valueOf(this.nVT.getPasterLen()));
        }
    }

    public void onResume() {
        super.onResume();
        showVKB();
    }

    public void onDestroy() {
        super.onDestroy();
        g.Ek();
        g.Eh().dpP.b(213, this);
    }

    protected final void initView() {
        this.nVT = (SnsEditText) findViewById(i$f.content);
        this.nVT.setTextSize(1, (ah.fe(this.mController.tml) * this.nVT.getTextSize()) / com.tencent.mm.bp.a.getDensity(this.mController.tml));
        a(0, getString(i$j.app_send), new 2(this), b.tmX);
        if (this.nVU == 0) {
            setMMTitle(i$j.sns_comment_title);
        } else if (this.nVU == 1) {
            setMMTitle(i$j.sns_wirte_down);
            g.Ek();
            String aG = bi.aG((String) g.Ei().DT().get(68408, ""), "");
            g.Ek();
            this.nVT.setPasterLen(bi.a((Integer) g.Ei().DT().get(7489, Integer.valueOf(0)), 0));
            this.nVT.append(bi.aG(aG, ""));
            if (aG == null || aG.length() <= 0) {
                enableOptionMenu(false);
            } else {
                enableOptionMenu(true);
            }
        } else if (this.nVU == 2) {
            setMMTitle(i$j.sns_ad_abtest_not_like_title);
            enableOptionMenu(false);
        }
        setBackBtn(new 3(this));
        this.nVT.addTextChangedListener(new 4(this));
    }

    protected final int getLayoutId() {
        return i$g.sns_comment_ui;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.SnsCommentUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + lVar.getType() + " @" + hashCode());
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        switch (lVar.getType()) {
            case 213:
                if (this.nVV) {
                    finish();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void finish() {
        super.finish();
        if (!this.nVW && this.nVU == 2) {
            long longExtra = getIntent().getLongExtra("sns_id", 0);
            long longExtra2 = getIntent().getLongExtra("action_st_time", 0);
            String aG = bi.aG(getIntent().getStringExtra("sns_uxinfo"), "");
            String str = bi.aG(getIntent().getStringExtra("sns_actionresult"), "") + "|4:0:";
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.plugin.sns.f.h bzh = af.byg().bzh();
            if (bzh != null && bzh.bzi()) {
                String str2 = bzh.ntY;
                String str3 = bzh.ntX;
                x.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + longExtra + " uxinfo:" + aG + " actionresult: " + str + " " + longExtra2 + " " + currentTimeMillis);
                com.tencent.mm.plugin.report.service.h.mEJ.h(11988, new Object[]{str2, str3, "", "", i.eF(longExtra), aG, str, Long.valueOf(longExtra2 / 1000), Long.valueOf(currentTimeMillis / 1000)});
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        YC();
        finish();
        return true;
    }
}
