package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.GridView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.n;
import com.tencent.mm.ar.j;
import com.tencent.mm.ar.k;
import com.tencent.mm.ar.r;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

public class SettingsSelectBgUI extends MMActivity implements e {
    private boolean mRY;
    private a mTN;
    private GridView mTO;
    private j mTP;
    private List<j> mTQ = new ArrayList();
    private al mTR = new al(new 1(this), true);
    private String username;

    static /* synthetic */ void a(SettingsSelectBgUI settingsSelectBgUI) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) settingsSelectBgUI.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        settingsSelectBgUI.mTN = new a(settingsSelectBgUI, settingsSelectBgUI, ((displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.widthPixels : displayMetrics.heightPixels) - 60) / 3);
        settingsSelectBgUI.mTO = (GridView) settingsSelectBgUI.findViewById(f.settings_select_bg_gv);
        r.Qp().c(settingsSelectBgUI.mTN);
        settingsSelectBgUI.mTO.setAdapter(settingsSelectBgUI.mTN);
        settingsSelectBgUI.mTO.setOnItemClickListener(new 3(settingsSelectBgUI));
    }

    static /* synthetic */ void f(int i, List list) {
        for (j jVar : list) {
            if (jVar.ecO == i) {
                r.Qp().bm(jVar.ecO, 1);
                list.remove(jVar);
                return;
            }
        }
    }

    protected final int getLayoutId() {
        return g.settings_select_bg;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        com.tencent.mm.kernel.g.DF().a(159, this);
        com.tencent.mm.kernel.g.DF().a(160, this);
        if (com.tencent.mm.kernel.g.Ei().isSDCardAvailable()) {
            com.tencent.mm.kernel.g.DF().a(new k(1), 0);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mTP != null) {
            com.tencent.mm.kernel.g.DF().c(this.mTP);
            r.Qp().bm(this.mTP.ecO, 1);
        }
        List<j> list = this.mTQ;
        for (j jVar : list) {
            r.Qp().bm(jVar.ecO, 1);
        }
        list.clear();
        com.tencent.mm.kernel.g.DF().b(159, this);
        com.tencent.mm.kernel.g.DF().b(160, this);
        this.mTN.aYc();
        r.Qp().d(this.mTN);
    }

    protected final void initView() {
        setMMTitle(i.settings_chatting_bg_select_bg);
        setBackBtn(new 2(this));
        this.mRY = getIntent().getBooleanExtra("isApplyToAll", true);
        this.username = getIntent().getStringExtra("username");
        this.mTR.J(20, 20);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if ((lVar instanceof n) && ((n) lVar).Lf() == 1) {
            int type = lVar.getType();
            if (type == 159 || type == 160) {
                if (type == 160) {
                    cc(this.mTQ);
                }
                if (i != 0 || i2 != 0) {
                    return;
                }
                return;
            }
            return;
        }
        x.d("MicroMsg.SettingsSelectBgUI", "another scene");
    }

    private void cc(List<j> list) {
        if (list.size() > 0) {
            this.mTP = (j) list.remove(0);
            com.tencent.mm.kernel.g.DF().a(this.mTP, 0);
            return;
        }
        this.mTP = null;
    }
}
