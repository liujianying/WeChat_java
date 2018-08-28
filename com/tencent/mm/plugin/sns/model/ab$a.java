package com.tencent.mm.plugin.sns.model;

import android.content.SharedPreferences;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class ab$a extends k<String, String, Boolean> {
    private String aAL;
    private SharedPreferences duR;
    final /* synthetic */ ab npf;
    private String npg;
    PInt nph;
    PInt npi;
    private String npj;
    private String username;

    public final /* synthetic */ void onPostExecute(Object obj) {
        Boolean bool = (Boolean) obj;
        x.d("MicroMsg.RemoveSnsTask", "onPostExecute " + bool);
        ab.d(this.npf);
        if (bool.booleanValue()) {
            ab.b(this.nph, this.npi);
            if (this.duR != null) {
                this.duR.edit().putInt(this.npg, this.nph.value).commit();
                this.duR.edit().putInt(this.aAL, this.npi.value).commit();
                x.d("MicroMsg.RemoveSnsTask", "update dir " + this.nph.value + " " + this.npi.value + " cleanCount: " + ab.a(this.npf));
            }
            ab.e(this.npf).sendEmptyMessageDelayed(0, 20000);
        }
        ab.a(this.npf, false);
    }

    public ab$a(ab abVar) {
        this.npf = abVar;
        this.duR = null;
        this.npg = "";
        this.aAL = "";
        this.nph = new PInt();
        this.npi = new PInt();
        this.duR = ad.getContext().getSharedPreferences("preferences_remove_task", 0);
        g.Ek();
        if (g.Eg().Dx()) {
            this.username = q.GF();
            this.npg = "remove_key_base" + this.username;
            this.aAL = "remove_key" + this.username;
            g.Ek();
            if (g.Eg().Dx() && !af.bxX() && af.FO() != null && af.bys() != null) {
                l Np = af.bys().Np(this.username);
                if (Np != null) {
                    this.npj = Np.field_bgId;
                }
                x.d("MicroMsg.RemoveSnsTask", "my bgid %s", new Object[]{this.npj});
                ab.a(abVar, true);
            }
        }
    }

    private Boolean bxN() {
        x.d("MicroMsg.RemoveSnsTask", "simpleCleans sns");
        if (!ab.kEE) {
            return Boolean.valueOf(false);
        }
        if (!ab.c(this.npf)) {
            return Boolean.valueOf(false);
        }
        if (af.bxX()) {
            ab.kEE = false;
            return Boolean.valueOf(false);
        }
        this.nph.value = this.duR.getInt(this.npg, 0);
        this.npi.value = this.duR.getInt(this.aAL, 0);
        String accSnsPath = af.getAccSnsPath();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (!ab.Y(accSnsPath + ab.npe[this.nph.value % 36] + "/" + ab.npe[this.npi.value % 36], this.npj, this.username)) {
                return Boolean.valueOf(false);
            }
            x.d("MicroMsg.RemoveSnsTask", "clean sns uses time : " + (System.currentTimeMillis() - currentTimeMillis) + " " + this.nph.value + " " + this.npi.value);
            return Boolean.valueOf(true);
        } catch (Exception e) {
        }
    }

    public final ag bxH() {
        return af.bya();
    }
}
