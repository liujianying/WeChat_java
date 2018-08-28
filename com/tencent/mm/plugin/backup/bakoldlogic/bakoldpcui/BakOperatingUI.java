package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

public class BakOperatingUI extends MMWizardActivity implements d {
    private int haC = -1;
    private boolean haG = false;
    private ProgressBar haH = null;
    private TextView haI = null;
    private TextView haJ = null;
    private TextView haK = null;
    private boolean haL = false;
    private int haM = 0;
    private boolean haN = false;
    private ag handler = new ag(Looper.getMainLooper());

    public void onCreate(Bundle bundle) {
        x.i("MicroMsg.BakOperatingUI", "onCreate");
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            x.i("MicroMsg.BakOperatingUI", "onCreate WizardRootKillSelf cmd:%d", new Object[]{Integer.valueOf(this.haC)});
            return;
        }
        a.asN().asO().a(this);
        a.asN().asO().dD(true);
        this.haL = getIntent().getBooleanExtra("from_bak_banner", false);
        if (this.haL) {
            int i = a.asN().asO().gZV;
            if (2 == i || a.asN().asO().gZU == 2) {
                this.haC = 1;
                this.haM = a.asN().asO().asY();
            } else if (4 == i) {
                this.haC = 6;
                this.haM = a.asN().asO().asY();
            } else if (5 == i) {
                this.haC = 6;
                this.haG = true;
                com.tencent.mm.plugin.backup.a.ezn.vo();
                a.asN().asO().arg();
            }
        } else {
            this.haC = getIntent().getIntExtra("cmd", 6);
        }
        if (this.haC == 6 && a.asN().asO().gZO.haf) {
            this.haG = true;
            com.tencent.mm.plugin.backup.a.ezn.vo();
            a.asN().asO().arg();
        }
        x.i("MicroMsg.BakOperatingUI", "before initView onCreate BakOperatingUI  nowCmd:%d fromBanner:%b status:%d opePercent:%d", new Object[]{Integer.valueOf(this.haC), Boolean.valueOf(this.haL), Integer.valueOf(a.asN().asO().gZV), Integer.valueOf(this.haM)});
        initView();
        if (a.asN().asO().gZU == 2) {
            this.haJ.setText(getString(R.l.bak_chat_to_pc_prepareing_tip));
            this.haI.setText(getString(R.l.bak_chat_pc_prepare_progress_tip) + this.haM + "%");
            this.haK.setText(getString(R.l.bak_chat_to_pc_operating_tip));
        } else if (6 == this.haC) {
            if (this.haG) {
                this.haJ.setText(getString(R.l.bak_chat_to_pc_merging_tip));
                this.haK.setText(getString(R.l.bak_chat_to_pc_merge_operating_tip));
                this.haI.setText(getString(R.l.bak_chat_pc_merge_progress_tip) + this.haM + "%");
                return;
            }
            this.haJ.setText(getString(R.l.bak_chat_to_pc_recovering_tip));
            this.haI.setText(getString(R.l.bak_chat_pc_restore_progress_tip) + this.haM + "%");
            this.haK.setText(getString(R.l.bak_chat_to_pc_operating_tip));
        } else if (1 == this.haC) {
            this.haJ.setText(getString(R.l.bak_chat_to_pc_backing_tip));
            this.haI.setText(getString(R.l.bak_chat_pc_back_progress_tip) + this.haM + "%");
            this.haK.setText(getString(R.l.bak_chat_to_pc_operating_tip));
        }
    }

    protected final void initView() {
        setMMTitle(R.l.bak_chat_to_pc_title);
        if (!this.haG) {
            if (6 == this.haC) {
                addTextOptionMenu(0, getString(R.l.bak_chat_recover_background), new 1(this));
            } else if (1 == this.haC) {
                addTextOptionMenu(0, getString(R.l.bak_chat_back_background), new 4(this));
            } else {
                x.e("MicroMsg.BakOperatingUI", "BakOperatingUI operate type is invalid");
            }
        }
        setBackBtn(new 5(this));
        this.haH = (ProgressBar) findViewById(R.h.bak_chat_operate_progress_bar);
        this.haH.setProgress(this.haM);
        this.haJ = (TextView) findViewById(R.h.bak_topc_operate_tip);
        this.haK = (TextView) findViewById(R.h.bak_topc_operate_tip_sub);
        this.haI = (TextView) findViewById(R.h.bak_chat_pc_back_tip);
    }

    protected final int getLayoutId() {
        return R.i.bak_topc_operate;
    }

    private void ati() {
        a.asN().asO().pause();
        c a = h.a(this, R.l.bak_chat_recover_cancel, 0, R.l.app_yes, R.l.app_no, new 6(this), new 7(this));
        a.setCanceledOnTouchOutside(false);
        a.setCancelable(false);
    }

    public void onDestroy() {
        super.onDestroy();
        a.asN().asO().a(null);
        a.asN().asO().dD(false);
        x.i("MicroMsg.BakOperatingUI", "BakOperatingUI onDestroy nowCmd:%d", new Object[]{Integer.valueOf(this.haC)});
    }

    public void onStart() {
        super.onStart();
    }

    protected void onResume() {
        a.asN().asO().dD(true);
        a.asN().asO().a(this);
        x.i("MicroMsg.BakOperatingUI", "onResume nowCmd:%d", new Object[]{Integer.valueOf(this.haC)});
        super.onResume();
    }

    protected void onPause() {
        a.asN().asO().dD(false);
        super.onPause();
        x.i("MicroMsg.BakOperatingUI", "onPause nowCmd:%d", new Object[]{Integer.valueOf(this.haC)});
    }

    public final synchronized void mT(final int i) {
        x.d("MicroMsg.BakOperatingUI", "BakOperatingUI onNetProgress percent:%d, isFinishingWizard:%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.haN)});
        if (!this.haN) {
            this.handler.post(new Runnable() {
                public final void run() {
                    if (BakOperatingUI.this.haH != null) {
                        BakOperatingUI.this.haH.setProgress(i);
                    }
                    if (BakOperatingUI.this.haI != null) {
                        int i = R.l.bak_chat_pc_back_progress_tip;
                        int i2 = R.l.bak_chat_to_pc_backing_tip;
                        if (6 == BakOperatingUI.this.haC) {
                            i = R.l.bak_chat_pc_restore_progress_tip;
                            i2 = R.l.bak_chat_to_pc_recovering_tip;
                        }
                        BakOperatingUI.this.haI.setText(BakOperatingUI.this.getString(i) + i + "%");
                        BakOperatingUI.this.haJ.setText(BakOperatingUI.this.getString(i2));
                    }
                }
            });
        }
    }

    public final synchronized void mU(int i) {
        if (!this.haN) {
            x.d("MicroMsg.BakOperatingUI", "BakOperatingUI onMergeProgress percent:%d", new Object[]{Integer.valueOf(i)});
            this.handler.post(new 9(this, i));
        }
    }

    public final synchronized void atb() {
        x.d("MicroMsg.BakOperatingUI", "onNetFinish now cmd:%d", new Object[]{Integer.valueOf(this.haC)});
        if (!this.haN) {
            if (6 == this.haC || 5 == a.asN().asO().gZV) {
                this.haC = 6;
                this.haG = true;
                com.tencent.mm.plugin.backup.a.ezn.vo();
                a.asN().asO().arg();
            } else {
                x.e("MicroMsg.BakOperatingUI", "onNetFinish now cmd:%d", new Object[]{Integer.valueOf(this.haC)});
            }
            this.handler.post(new Runnable() {
                public final void run() {
                    if (6 == BakOperatingUI.this.haC) {
                        BakOperatingUI.this.handler.post(new 1(this));
                    } else if (1 == BakOperatingUI.this.haC) {
                        Intent intent = new Intent(BakOperatingUI.this, BakFinishUI.class);
                        intent.putExtra("cmd", BakOperatingUI.this.haC);
                        MMWizardActivity.D(BakOperatingUI.this, intent);
                    }
                }
            });
        }
    }

    public final synchronized void aqO() {
        if (!this.haN) {
            this.haG = false;
            x.d("MicroMsg.BakOperatingUI", "onMergeFinish now cmd:%d", new Object[]{Integer.valueOf(this.haC)});
            this.handler.post(new 11(this));
        }
    }

    public synchronized boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = true;
        synchronized (this) {
            if (i != 4) {
                z = super.onKeyDown(i, keyEvent);
            } else if (this.haG) {
                ati();
                a.asN().asO().pause();
            } else {
                x.d("MicroMsg.BakOperatingUI", "onKeyDown keyCode == KeyEvent.KEYCODE_BACK  finishWizard cmd:%d", new Object[]{Integer.valueOf(this.haC)});
                this.haN = true;
                a.asN().asO().dD(false);
                DT(1);
            }
        }
        return z;
    }

    public final void onError(int i) {
        this.handler.post(new 2(this, i));
    }

    public final void atc() {
        this.handler.post(new 3(this));
    }
}
