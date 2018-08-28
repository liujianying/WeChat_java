package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

public class BakWaitingUI extends MMWizardActivity implements c {
    private boolean haU;
    private ag handler = new ag(Looper.getMainLooper());
    private int nc;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            a.asN().asO().gZK = this;
            this.nc = a.asN().asO().gZR;
            this.haU = getIntent().getBooleanExtra("from_back_finish", false);
            x.i("MicroMsg.BakWaitingUI", "BakWaitingUI onCreate nowCmd:%d isFromFinish:%b", new Object[]{Integer.valueOf(this.nc), Boolean.valueOf(this.haU)});
            initView();
            atk();
        }
    }

    protected final void initView() {
        setMMTitle(R.l.bak_chat_to_pc_title);
        if (this.haU) {
            findViewById(R.h.bak_topc_tip).setVisibility(8);
        } else {
            findViewById(R.h.bak_topc_tip).setVisibility(0);
        }
        setBackBtn(new 1(this));
    }

    protected final int getLayoutId() {
        return R.i.bak_topc_wait;
    }

    public final void mR(int i) {
        this.nc = i;
        this.handler.post(new 2(this));
    }

    public void onDestroy() {
        super.onDestroy();
        a.asN().asO().gZK = null;
        x.i("MicroMsg.BakWaitingUI", "BakWaitingUI onDestroy nowCmd:%d isFromFinish:%b", new Object[]{Integer.valueOf(this.nc), Boolean.valueOf(this.haU)});
    }

    public final void mS(final int i) {
        this.handler.post(new Runnable() {
            public final void run() {
                x.d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", new Object[]{Integer.valueOf(i)});
                if (i == -1) {
                    x.d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
                    Intent intent = new Intent();
                    intent.putExtra("title", BakWaitingUI.this.getString(R.l.backup_pc_not_support_title));
                    intent.putExtra("rawUrl", BakWaitingUI.this.getString(R.l.backup_not_support_doc, new Object[]{w.chP()}));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    d.b(BakWaitingUI.this, "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        });
    }

    final void atk() {
        if (6 == this.nc || 1 == this.nc) {
            Intent intent = new Intent(this, BakOperatingUI.class);
            intent.putExtra("cmd", this.nc);
            MMWizardActivity.D(this, intent);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        DT(1);
        return true;
    }

    public final void onError(final int i) {
        this.handler.post(new Runnable() {
            public final void run() {
                x.d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", new Object[]{Integer.valueOf(i)});
                if (i == -1) {
                    x.d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
                    Intent intent = new Intent();
                    intent.putExtra("title", BakWaitingUI.this.getString(R.l.backup_pc_not_support_title));
                    intent.putExtra("rawUrl", BakWaitingUI.this.getString(R.l.backup_not_support_doc, new Object[]{w.chP()}));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    d.b(BakWaitingUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                }
                MMWizardActivity.D(BakWaitingUI.this, new Intent(BakWaitingUI.this, BakConnErrorUI.class));
            }
        });
    }
}
