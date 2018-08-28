package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.aa.a.c.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LaunchAAByPersonAmountSelectUI extends BaseAAPresenterActivity {
    private String bIY;
    private ag dvh = new ag(Looper.getMainLooper());
    private c eCQ = ((c) w(c.class));
    private ListView eCR;
    private TextView eCS;
    private TextView eCT;
    private View eCU;
    private TextView eCV;
    private boolean eCW = false;
    private Map<String, String> eCX = new HashMap();
    private a eCY = null;
    private double eCZ;
    private long eDa = -1;
    private int eDb = -1;
    private boolean eDc;
    private boolean eDd = false;
    private Runnable eDe = new Runnable() {
        public final void run() {
            LaunchAAByPersonAmountSelectUI.this.Wr();
            LaunchAAByPersonAmountSelectUI.this.Ws();
        }
    };

    static /* synthetic */ void d(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        launchAAByPersonAmountSelectUI.Wr();
        launchAAByPersonAmountSelectUI.Ws();
        if (!launchAAByPersonAmountSelectUI.eDc) {
            ArrayList arrayList = new ArrayList();
            for (String str : launchAAByPersonAmountSelectUI.eCX.keySet()) {
                arrayList.add(str + "," + ((String) launchAAByPersonAmountSelectUI.eCX.get(str)));
            }
            Intent intent = new Intent();
            intent.putStringArrayListExtra("selectUI", arrayList);
            launchAAByPersonAmountSelectUI.setResult(-1, intent);
            launchAAByPersonAmountSelectUI.finish();
        }
    }

    static /* synthetic */ void m(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        try {
            launchAAByPersonAmountSelectUI.eCS.setTextColor(launchAAByPersonAmountSelectUI.getResources().getColor(a.c.btn_green_color_disable));
            launchAAByPersonAmountSelectUI.eCW = false;
            launchAAByPersonAmountSelectUI.eCZ = 0.0d;
            launchAAByPersonAmountSelectUI.eCT.setText(launchAAByPersonAmountSelectUI.getString(a$i.launch_aa_by_person_amount_select_summary, new Object[]{Double.valueOf(launchAAByPersonAmountSelectUI.eCZ)}));
            launchAAByPersonAmountSelectUI.eCX.clear();
            launchAAByPersonAmountSelectUI.Wr();
            launchAAByPersonAmountSelectUI.Ws();
            if (launchAAByPersonAmountSelectUI.eCY != null) {
                a aVar = launchAAByPersonAmountSelectUI.eCY;
                for (b bVar : aVar.dataList) {
                    bVar.eDm = "";
                }
                aVar.notifyDataSetChanged();
            }
        } catch (Exception e) {
            x.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "clearAmount error: %s", new Object[]{e.getMessage()});
        }
        h.mEJ.h(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(9)});
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(a$i.launch_aa_by_person_amount_select_title);
        setBackBtn(new 2(this));
        a(233, getString(a$i.app_ok), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (LaunchAAByPersonAmountSelectUI.this.eDb <= 0 || LaunchAAByPersonAmountSelectUI.this.eCX == null || LaunchAAByPersonAmountSelectUI.this.eCX.size() <= LaunchAAByPersonAmountSelectUI.this.eDb) {
                    LaunchAAByPersonAmountSelectUI.d(LaunchAAByPersonAmountSelectUI.this);
                    h.mEJ.h(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(4)});
                } else {
                    com.tencent.mm.ui.base.h.b(LaunchAAByPersonAmountSelectUI.this.mController.tml, LaunchAAByPersonAmountSelectUI.this.getString(a$i.launch_aa_by_person_number_exceed_limit_alert, new Object[]{Integer.valueOf(LaunchAAByPersonAmountSelectUI.this.eDb)}), "", true);
                    h.mEJ.h(13722, new Object[]{Integer.valueOf(8)});
                }
                return true;
            }
        }, b.tmX);
        this.eCR = (ListView) findViewById(f.amount_select_list);
        this.eCS = (TextView) findViewById(f.clear_amount);
        this.eCT = (TextView) findViewById(f.amount_summary);
        this.eCT.setText(getString(a$i.launch_aa_by_person_amount_select_summary, new Object[]{Float.valueOf(0.0f)}));
        this.eCU = findViewById(f.summary_layout);
        this.eCV = (TextView) findViewById(f.alert_tip_tv);
        this.eCD = this.eCR;
        this.eCU.setVisibility(8);
        this.eCS.setOnTouchListener(new 5(this));
        this.eCS.setOnClickListener(new 6(this));
        this.eCW = true;
        this.eCR.setOnScrollListener(new 7(this));
        this.bIY = getIntent().getStringExtra("chatroom");
        this.eDa = getIntent().getLongExtra("maxPerAmount", -1);
        this.eDb = getIntent().getIntExtra("maxUserNumber", -1);
        ArrayList stringArrayListExtra = getIntent().getStringArrayListExtra("oldAmountData");
        x.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate, chatroom: %s, maxPerAmount: %s, oldDataList: %s", new Object[]{this.bIY, Long.valueOf(this.eDa), stringArrayListExtra});
        this.eCX = new HashMap();
        HashMap hashMap = new HashMap();
        if (stringArrayListExtra != null) {
            try {
                if (stringArrayListExtra.size() > 0) {
                    Iterator it = stringArrayListExtra.iterator();
                    while (it.hasNext()) {
                        String[] split = ((String) it.next()).split(",");
                        if (split != null && split.length == 2) {
                            hashMap.put(split[0], Double.valueOf(bi.getDouble(split[1], 0.0d)));
                            this.eCX.put(split[0], getString(a$i.aa_amount_format, new Object[]{Double.valueOf(r4)}));
                        }
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate parse old data error: %s", new Object[]{e.getMessage()});
            }
        }
        this.eCQ.Q(c.a.class);
        this.eCQ.a(c.a.class, new 4(this, hashMap));
    }

    protected final int getForceOrientation() {
        return 1;
    }

    private void Wr() {
        try {
            this.eCZ = 0.0d;
            this.eDc = false;
            if (this.eCX != null) {
                for (String str : this.eCX.values()) {
                    double d = bi.getDouble(str, 0.0d);
                    this.eCZ += d;
                    if (this.eDa > 0 && d * 100.0d > ((double) this.eDa)) {
                        this.eDc = true;
                    }
                }
                if (this.eCY != null) {
                    a aVar = this.eCY;
                    Map map = this.eCX;
                    for (b bVar : aVar.dataList) {
                        bVar.eDm = "";
                    }
                    if (map != null && map.size() > 0) {
                        for (b bVar2 : aVar.dataList) {
                            if (map.containsKey(bVar2.username)) {
                                bVar2.eDm = (String) map.get(bVar2.username);
                            }
                        }
                    }
                }
            }
            this.eCT.setText(getString(a$i.launch_aa_by_person_amount_select_summary, new Object[]{Double.valueOf(this.eCZ)}));
            if (this.eCX == null || this.eCX.size() <= 0) {
                updateOptionMenuText(233, getString(a$i.app_ok));
            } else {
                updateOptionMenuText(233, getString(a$i.aa_confirm_num, new Object[]{Integer.valueOf(this.eCX.size())}));
            }
            if (this.eDc) {
                h.mEJ.h(13722, new Object[]{Integer.valueOf(7)});
                enableOptionMenu(233, false);
                CharSequence string = getString(a$i.launch_aa_money_exceed_avg_amount_alert, new Object[]{Float.valueOf(((float) this.eDa) / 100.0f)});
                if (!bi.oW(string)) {
                    this.eCV.setText(string);
                    if (!this.eCV.isShown()) {
                        this.eCV.startAnimation(AnimationUtils.loadAnimation(this, a.a.in_from_up));
                        this.eCV.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            }
            enableOptionMenu(233, true);
            if (this.eCV.isShown()) {
                this.eCV.setText("");
                this.eCV.startAnimation(AnimationUtils.loadAnimation(this, a.a.out_to_up));
                this.eCV.setVisibility(8);
            }
        } catch (Exception e) {
            x.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "updateTotalAmount error: %s", new Object[]{e.getMessage()});
        }
    }

    private void Ws() {
        if (this.eCZ > 0.0d) {
            this.eCW = true;
            this.eCS.setTextColor(getResources().getColor(a.c.btn_green_color_normal));
            return;
        }
        this.eCW = false;
        this.eCS.setTextColor(getResources().getColor(a.c.btn_green_color_disable));
    }

    protected final int getLayoutId() {
        return g.launch_aa_by_person_amount_select_ui;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.eCX != null) {
            this.eCX.clear();
        }
    }
}
