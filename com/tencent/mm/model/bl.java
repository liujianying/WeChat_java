package com.tencent.mm.model;

import com.tencent.mm.a.e;
import com.tencent.mm.bk.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.auy;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.RegionCodeDecoder;

public final class bl {
    public String countryCode = "";
    public int csJ = 0;
    public String csO = "";
    private String dDc = "";
    private String dDd = "";
    public String dDe = "";
    public String dDf = "";
    public int sex = 0;
    public String signature = "";

    public static bl IC() {
        bl blVar = new bl();
        blVar.csJ = 1;
        blVar.sex = bi.a((Integer) g.Ei().DT().get(12290, null), 0);
        blVar.dDc = (String) g.Ei().DT().get(12293, null);
        blVar.dDd = (String) g.Ei().DT().get(12292, null);
        blVar.signature = (String) g.Ei().DT().get(12291, null);
        blVar.csO = (String) g.Ei().DT().get(12307, null);
        blVar.countryCode = (String) g.Ei().DT().get(12324, null);
        blVar.dDf = (String) g.Ei().DT().get(12325, null);
        blVar.dDe = (String) g.Ei().DT().get(12326, null);
        return blVar;
    }

    public static bl ID() {
        if (bi.a((Integer) g.Ei().DT().get(12289, null), 0) == 0) {
            return null;
        }
        return IC();
    }

    public static auy a(bl blVar) {
        g.Ei().DT().set(12289, Integer.valueOf(blVar.csJ));
        g.Ei().DT().set(12290, Integer.valueOf(blVar.sex));
        if (a.V((String) g.Ei().DT().get(12293, null), blVar.getProvince())) {
            g.Ei().DT().set(12293, blVar.getProvince());
        }
        if (a.V((String) g.Ei().DT().get(12292, null), blVar.getCity())) {
            g.Ei().DT().set(12292, blVar.getCity());
        }
        if (a.V((String) g.Ei().DT().get(12291, null), blVar.signature)) {
            g.Ei().DT().set(12291, blVar.signature);
        }
        if (a.V((String) g.Ei().DT().get(12307, null), blVar.csO)) {
            g.Ei().DT().set(12307, blVar.csO);
        }
        if (a.V((String) g.Ei().DT().get(12324, null), blVar.countryCode)) {
            g.Ei().DT().set(12324, blVar.countryCode);
        }
        if (a.V((String) g.Ei().DT().get(12325, null), blVar.dDf)) {
            g.Ei().DT().set(12325, blVar.dDf);
        }
        if (a.V((String) g.Ei().DT().get(12326, null), blVar.dDe)) {
            g.Ei().DT().set(12326, blVar.dDe);
        }
        auy auy = new auy();
        auy.rXT = 128;
        auy.rvi = new bhz().VO("");
        auy.rQz = new bhz().VO("");
        auy.ray = 0;
        auy.rXU = new bhz().VO("");
        auy.rXV = new bhz().VO("");
        auy.hcd = 0;
        byte[] e = e.e("", 0, -1);
        auy.rXR = new b(e == null ? new byte[0] : e);
        auy.rXQ = e == null ? 0 : e.length;
        auy.eJH = blVar.sex;
        auy.eJL = blVar.csJ;
        auy.eJK = bi.oV(blVar.signature);
        auy.eJJ = bi.oV(blVar.dDe);
        auy.eJI = bi.oV(blVar.dDf);
        auy.raB = 0;
        auy.rTg = bi.oV(blVar.csO);
        auy.rYa = 0;
        auy.eJM = "";
        auy.rTi = 0;
        auy.rTh = "";
        auy.eJQ = bi.oV(blVar.countryCode);
        return auy;
    }

    public final String getCity() {
        if (!bi.oW(this.countryCode)) {
            if (bi.oW(this.dDf)) {
                this.dDd = "";
            } else if (bi.oW(this.dDe)) {
                RegionCodeDecoder.cmS();
                this.dDd = RegionCodeDecoder.ga(this.countryCode, this.dDf);
            } else {
                RegionCodeDecoder.cmS();
                this.dDd = RegionCodeDecoder.ar(this.countryCode, this.dDf, this.dDe);
            }
        }
        if (bi.oW(this.dDd)) {
            return bi.oV(this.dDe);
        }
        return this.dDd;
    }

    public final String getProvince() {
        if (!bi.oW(this.countryCode)) {
            if (bi.oW(this.dDf) || bi.oW(this.dDe) || !RegionCodeDecoder.Zh(this.countryCode)) {
                RegionCodeDecoder.cmS();
                this.dDc = RegionCodeDecoder.Zi(this.countryCode);
            } else {
                RegionCodeDecoder.cmS();
                this.dDc = RegionCodeDecoder.ga(this.countryCode, this.dDf);
            }
        }
        return bi.oW(this.dDc) ? bi.oV(this.dDf) : this.dDc;
    }
}
