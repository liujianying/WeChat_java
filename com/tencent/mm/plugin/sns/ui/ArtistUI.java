package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public class ArtistUI extends MMActivity implements e {
    private SharedPreferences duR;
    private ListView eVT;
    private String kCA = "";
    private g nLk;
    private ArtistHeader nLl;
    private l nLm = null;
    private p tipDialog = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String d = w.d(getSharedPreferences(ad.chY(), 0));
        x.d("MicroMsg.ArtistUI", "filterLan temp " + d);
        if (!(d.equals("zh_CN") || d.equals("en") || d.equals("zh_TW"))) {
            d = d.equals("zh_HK") ? "zh_TW" : "en";
        }
        this.kCA = d;
        x.d("MicroMsg.ArtistUI", "lan " + this.kCA);
        g.Ek();
        g.Eh().dpP.a(159, this);
        this.duR = getSharedPreferences(ad.chY(), 0);
        initView();
        af.byj().a(this.nLl);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.tipDialog != null) {
            this.tipDialog = null;
        }
        if (this.nLl != null) {
            af.byj().b(this.nLl);
        }
        af.byl().H(this);
        g.Ek();
        g.Eh().dpP.b(159, this);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected final void initView() {
        setMMTitle(j.settings_sns_bg_title);
        getString(j.app_tip);
        this.tipDialog = h.a((Context) this, getString(j.app_loading_data), true, new 1(this));
        this.eVT = (ListView) findViewById(f.sns_artist_list);
        a.ezo.aG(false);
        this.nLk = new g(this, this.kCA, new 2(this), new 3(this));
        this.nLl = new ArtistHeader(this);
        this.eVT.addHeaderView(this.nLl);
        this.eVT.setAdapter(this.nLk);
        this.nLk.notifyDataSetChanged();
        this.nLl.setVisibility(8);
        setBackBtn(new 4(this));
    }

    protected final int getLayoutId() {
        return i.g.sns_artist_ui;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if ((lVar instanceof n) && ((n) lVar).Lf() == 4) {
            x.i("MicroMsg.ArtistUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + lVar.getType() + " @" + hashCode());
            if (i == 0 && i2 == 0) {
                switch (lVar.getType()) {
                    case 159:
                        if (this.nLk != null) {
                            this.nLk.WT();
                        }
                        this.nLm = null;
                        return;
                    default:
                        return;
                }
            } else if (lVar.getType() == 159 && this.tipDialog != null) {
                this.tipDialog.dismiss();
                return;
            } else {
                return;
            }
        }
        x.d("MicroMsg.ArtistUI", "another scene");
    }
}
