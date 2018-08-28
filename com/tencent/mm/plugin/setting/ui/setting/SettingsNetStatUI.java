package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import com.tencent.mm.modelstat.m;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SettingsNetStatUI extends MMPreference {
    private f eOE;
    private long period;

    public final int Ys() {
        return k.settings_pref_netstat;
    }

    protected final boolean Yy() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onResume() {
        super.onResume();
        btP();
    }

    protected final void initView() {
        setMMTitle(i.settings_traffic_statistic);
        m Sj = q.Sj();
        int ciY = (int) (bi.ciY() / 86400000);
        if (Sj.it(ciY) == null) {
            com.tencent.mm.modelstat.k kVar = new com.tencent.mm.modelstat.k();
            kVar.ejM = ciY;
            kVar.id = -1;
            Sj.b(kVar);
        }
        this.eOE = this.tCL;
        this.period = q.Sj().Sb();
        Preference ZZ = this.eOE.ZZ("settings_netstat_info");
        String format = new SimpleDateFormat(getString(i.fmt_longdate), Locale.US).format(new Date(this.period));
        ZZ.setTitle(getString(i.settings_traffic_all_statistic, new Object[]{format}));
        x.i("MicroMsg.SettingsNetStatUI", "title datatime = " + format);
        x.d("MicroMsg.SettingsNetStatUI", "title datatime = " + format);
        setBackBtn(new 1(this));
        addTextOptionMenu(0, getString(i.settings_traffic_statistic_clear), new 2(this));
    }

    private void btP() {
        com.tencent.mm.modelstat.k iu = q.Sj().iu((int) (this.period / 86400000));
        if (iu == null) {
            iu = new com.tencent.mm.modelstat.k();
        }
        this.period = q.Sj().Sb();
        Preference ZZ = this.eOE.ZZ("settings_netstat_info");
        String charSequence = DateFormat.format(getString(i.fmt_longdate, new Object[]{""}), this.period).toString();
        ZZ.setTitle(getString(i.settings_traffic_all_statistic, new Object[]{charSequence}));
        ZZ = this.eOE.ZZ("settings_netstat_mobile");
        x.i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic mobile out:%d in:%d", new Object[]{Integer.valueOf(iu.ekh), Integer.valueOf(iu.ejV)});
        ZZ.setSummary(j(this, ((long) iu.ekh) + ((long) iu.ejV)));
        ZZ = this.eOE.ZZ("settings_netstat_wifi");
        x.i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic wifi out:%d in:%d", new Object[]{Integer.valueOf(iu.eki), Integer.valueOf(iu.ejW)});
        ZZ.setSummary(j(this, ((long) iu.eki) + ((long) iu.ejW)));
        ((NetStatPreference) this.eOE.ZZ("settings_netstat_mobile_detail")).mQa = false;
        ((NetStatPreference) this.eOE.ZZ("settings_netstat_wifi_detail")).mQa = true;
        this.eOE.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    private static String j(Context context, long j) {
        return context.getString(i.settings_total_traffic_statistic_all, new Object[]{bi.bF(j)});
    }
}
