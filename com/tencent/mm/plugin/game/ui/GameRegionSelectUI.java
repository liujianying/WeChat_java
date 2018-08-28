package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.game.model.i;
import com.tencent.mm.plugin.game.ui.GameRegionPreference.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s.b;
import java.util.Map;

public class GameRegionSelectUI extends MMPreference {
    private f eOE;
    private Map<String, a> kbB;
    private a kbx;

    static /* synthetic */ void a(GameRegionSelectUI gameRegionSelectUI) {
        if (gameRegionSelectUI.kbx != null) {
            com.tencent.mm.plugin.game.model.f.ak(gameRegionSelectUI, gameRegionSelectUI.kbx.csQ);
            com.tencent.mm.plugin.game.e.a.a.aVh().kdd = true;
            i.aTO().ft(true);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eOE = this.tCL;
        initView();
    }

    protected void onDestroy() {
        com.tencent.mm.plugin.game.e.a.a.aVh().aVe();
        super.onDestroy();
    }

    public final int Ys() {
        return -1;
    }

    protected final void initView() {
        setMMTitle(com.tencent.mm.plugin.game.f.i.game_region_setting_title);
        setBackBtn(new 1(this));
        a(0, getString(com.tencent.mm.plugin.game.f.i.game_region_setting_save), new 2(this), b.tmX);
        this.eOE.removeAll();
        this.kbB = com.tencent.mm.plugin.game.e.a.a.aVh().aVg();
        a dr = com.tencent.mm.plugin.game.model.f.dr(this);
        if (dr != null) {
            dr.eQK = true;
        }
        for (a dr2 : this.kbB.values()) {
            if (dr2 != null) {
                GameRegionPreference gameRegionPreference = new GameRegionPreference(this);
                if (dr2 == null || bi.oW(dr2.csQ)) {
                    x.e("MicroMsg.GameRegionPreference", "setData region error");
                } else {
                    gameRegionPreference.kbx = dr2;
                    gameRegionPreference.setKey(dr2.csQ);
                }
                if (dr2.isDefault) {
                    this.eOE.a(gameRegionPreference, 0);
                } else {
                    this.eOE.a(gameRegionPreference);
                }
            }
        }
        this.eOE.a(new PreferenceCategory(this));
        this.eOE.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        if (!(preference instanceof GameRegionPreference)) {
            return false;
        }
        a aVar = ((GameRegionPreference) preference).kbx;
        if (aVar == null) {
            return false;
        }
        this.kbx = aVar;
        for (a aVar2 : this.kbB.values()) {
            aVar2.eQK = false;
        }
        aVar.eQK = true;
        fVar.notifyDataSetChanged();
        return true;
    }
}
