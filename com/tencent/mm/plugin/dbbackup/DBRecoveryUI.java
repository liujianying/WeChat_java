package com.tencent.mm.plugin.dbbackup;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.dbbackup.a.a;
import com.tencent.mm.plugin.dbbackup.a.a.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Arrays;

public class DBRecoveryUI extends MMActivity implements b {
    private static final int[] hZI = new int[]{0, 5, 70, 80, 90, 100, 100};
    private ProgressBar eWx;
    private int fdx;
    private a hZA;
    private View hZB;
    private View hZC;
    private TextView hZD;
    private View hZE;
    private int hZF;
    private boolean hZG;
    private OnClickListener hZH = new 1(this);

    static /* synthetic */ void e(DBRecoveryUI dBRecoveryUI) {
        if (dBRecoveryUI.hZA != null) {
            x.e("MicroMsg.DBRecoveryUI", "Recovery task has already started.");
            return;
        }
        StringBuilder append = new StringBuilder().append(q.zy());
        g.Eg();
        byte[] bytes = append.append(com.tencent.mm.kernel.a.Df()).toString().getBytes();
        String DP = g.Ei().DP();
        String path = g.Ei().dqq.getPath();
        String str = path + "-recovery";
        dBRecoveryUI.hZF = 0;
        String str2 = g.Ei().dqp + "dbback/";
        a.a aVar = new a.a();
        aVar.iaK = dBRecoveryUI;
        aVar.iaH = com.tencent.mm.a.g.v(bytes);
        aVar.iaI = com.tencent.mm.a.g.u(bytes).substring(0, 7).getBytes();
        aVar.iaD = DP;
        aVar.iaC = path;
        aVar.iaB = str;
        aVar.iaE = g.Ei().cachePath + "heavyDetailInfo";
        aVar.iaJ = dBRecoveryUI.fdx == 0;
        a.a yJ = aVar.yI(DP + ".sm").yJ(DP + ".bak").yI(str2 + "corrupted/EnMicroMsg.db.sm").yJ(str2 + "corrupted/EnMicroMsg.db.bak").yI(str2 + "EnMicroMsg.db.sm").yJ(str2 + "EnMicroMsg.db.bak");
        a aVar2 = new a((byte) 0);
        a.a(aVar2, yJ.iaB);
        a.b(aVar2, yJ.iaC);
        a.c(aVar2, yJ.iaD);
        a.d(aVar2, yJ.iaE);
        a.a(aVar2, new ArrayList(yJ.iaF));
        a.b(aVar2, new ArrayList(yJ.iaG));
        a.a(aVar2, Arrays.copyOf(yJ.iaH, yJ.iaH.length));
        a.b(aVar2, Arrays.copyOf(yJ.iaI, yJ.iaI.length));
        a.a(aVar2, yJ.iaJ);
        a.a(aVar2, yJ.iaK);
        dBRecoveryUI.hZA = aVar2;
        dBRecoveryUI.hZA.execute(new Void[0]);
        dBRecoveryUI.hZG = true;
    }

    static /* synthetic */ void f(DBRecoveryUI dBRecoveryUI) {
        if (dBRecoveryUI.hZA != null) {
            dBRecoveryUI.hZA.mCancellationSignal.cancel();
            x.i("MicroMsg.DBRecoveryTask", "Recovery cancel triggered.");
            dBRecoveryUI.hZA = null;
            return;
        }
        x.e("MicroMsg.DBRecoveryUI", "Recovery task is not running.");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fdx = getIntent().getIntExtra("scene", 2);
        this.hZG = false;
        setMMTitle(R.l.data_recovery);
        this.hZB = findViewById(R.h.start_recover);
        this.hZC = findViewById(R.h.do_recover);
        this.eWx = (ProgressBar) findViewById(R.h.progress_bar);
        this.hZD = (TextView) findViewById(R.h.progress_text);
        View findViewById = findViewById(R.h.start_btn);
        findViewById.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                h.a(DBRecoveryUI.this, R.l.data_recover_warning, 0, R.l.data_recovery_sure, R.l.data_recovery_cancel, false, new 1(this), null, R.e.backup_green);
            }
        });
        this.hZE = findViewById(R.h.cancel_btn);
        this.hZE.setOnClickListener(new 3(this));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (DBRecoveryUI.this.hZG) {
                    DBRecoveryUI.this.hZE.callOnClick();
                } else {
                    DBRecoveryUI.this.finish();
                }
                return true;
            }
        });
        if (this.fdx == 0) {
            findViewById.callOnClick();
        }
        f.mDy.a(873, 14, 1, false);
        if (this.fdx == 3) {
            f.mDy.a(873, 15, 1, false);
        } else {
            f.mDy.a(181, (long) (this.fdx + 51), 1, true);
        }
    }

    public void onBackPressed() {
        if (this.hZG) {
            this.hZE.callOnClick();
        } else {
            finish();
        }
    }

    protected final int getLayoutId() {
        return R.i.db_recover_ui;
    }

    public final void G(int i, int i2, int i3) {
        float f = 1.0f;
        if (i > 0 && i <= 6) {
            if (i3 > 0) {
                int i4 = hZI[i - 1];
                int i5 = hZI[i] - i4;
                float f2 = ((float) i2) / ((float) i3);
                if (f2 <= 1.0f) {
                    f = f2;
                }
                this.eWx.setProgress((int) ((f * ((float) i5)) + ((float) i4)));
            } else if (this.hZF != i) {
                this.eWx.setProgress(hZI[i - 1]);
            }
            this.hZF = i;
            String str = getResources().getStringArray(R.c.data_recovery_progress)[i - 1];
            this.hZD.setText(String.format(str, new Object[]{Integer.valueOf(i2)}));
        }
    }

    public final void p(long j, long j2) {
        this.hZG = false;
        aCC();
        h.a(this, getString(R.l.data_recovery_space_not_enough, new Object[]{Long.valueOf((j2 / 1024) / 1024), Long.valueOf((j / 1024) / 1024)}), null, false, this.hZH);
    }

    public final void onSuccess() {
        this.hZG = false;
        ah.i(new 6(this, h.a(this, R.l.data_recovery_success, 0, false, new 5(this))), 5000);
    }

    public final void aCB() {
        this.hZG = false;
        aCC();
        h.a(this, R.l.data_recovery_canceled, 0, false, this.hZH);
    }

    public final void aid() {
        this.hZG = false;
        aCC();
        h.a(this, R.l.data_recovery_failed, 0, false, this.hZH);
    }

    private static void aCC() {
        com.tencent.mm.storage.x DT = g.Ei().DT();
        DT.set(89, Integer.valueOf(2));
        DT.lm(true);
    }
}
