package com.tencent.mm.ac;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d$b {
    private int dCn = 0;
    public JSONObject dKT = null;
    private boolean dKU = true;
    public boolean dKV = false;
    private boolean dKW = false;
    public boolean dKX = false;
    private String dKY;
    private String dKZ;
    private List<f> dLa = null;
    private d dLb = null;
    private c dLc = null;
    private e dLd = null;
    d$b$c$a dLe = null;
    private boolean dLf = false;
    boolean dLg = false;
    int dLh;
    public boolean dLi = false;
    public int dLj = 0;
    private String dLk;
    private b dLl = null;
    private int dLm = 0;
    private int dLn = d.dKM;
    private String dLo;
    private boolean dLp = false;
    private int dLq;
    private g dLr;
    private String dLs;
    private String dLt;
    private boolean dLu = false;
    public a dLv;
    private List<WxaEntryInfo> dLw;

    public final List<WxaEntryInfo> getWxaEntryInfoList() {
        if (this.dLw == null) {
            this.dLw = new LinkedList();
            if (this.dKT != null) {
                JSONObject jSONObject;
                JSONArray optJSONArray;
                Object optString = this.dKT.optString("BindWxaInfo");
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        jSONObject = new JSONObject(optString);
                    } catch (JSONException e) {
                    }
                    if (jSONObject == null) {
                        optJSONArray = jSONObject.optJSONArray("wxaEntryInfo");
                    } else {
                        optJSONArray = null;
                    }
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                Object optString2 = optJSONObject.optString("username");
                                Object optString3 = optJSONObject.optString("title");
                                Object optString4 = optJSONObject.optString("title_key");
                                String optString5 = optJSONObject.optString("icon_url");
                                if (!(TextUtils.isEmpty(optString2) || (TextUtils.isEmpty(optString3) && TextUtils.isEmpty(optString4)))) {
                                    WxaEntryInfo wxaEntryInfo = new WxaEntryInfo();
                                    wxaEntryInfo.username = optString2;
                                    wxaEntryInfo.title = optString3;
                                    wxaEntryInfo.fsh = optString4;
                                    wxaEntryInfo.iconUrl = optString5;
                                    this.dLw.add(wxaEntryInfo);
                                }
                            }
                        }
                    }
                }
                jSONObject = null;
                if (jSONObject == null) {
                    optJSONArray = null;
                } else {
                    optJSONArray = jSONObject.optJSONArray("wxaEntryInfo");
                }
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            Object optString22 = optJSONObject2.optString("username");
                            Object optString32 = optJSONObject2.optString("title");
                            Object optString42 = optJSONObject2.optString("title_key");
                            String optString52 = optJSONObject2.optString("icon_url");
                            if (!(TextUtils.isEmpty(optString22) || (TextUtils.isEmpty(optString32) && TextUtils.isEmpty(optString42)))) {
                                WxaEntryInfo wxaEntryInfo2 = new WxaEntryInfo();
                                wxaEntryInfo2.username = optString22;
                                wxaEntryInfo2.title = optString32;
                                wxaEntryInfo2.fsh = optString42;
                                wxaEntryInfo2.iconUrl = optString52;
                                this.dLw.add(wxaEntryInfo2);
                            }
                        }
                    }
                }
            }
        }
        return this.dLw;
    }

    public final boolean Mi() {
        if (!(this.dKT == null || this.dKT.optJSONObject("WifiBizInfo") == null || this.dKT.optJSONObject("WifiBizInfo").optInt("IsWXWiFi") != 1)) {
            this.dLu = true;
        }
        return this.dLu;
    }

    public final boolean Mj() {
        if (this.dKT != null) {
            this.dKW = "1".equals(this.dKT.optString("IsShowMember"));
        }
        return this.dKW;
    }

    public final boolean Mk() {
        if (this.dKT != null) {
            this.dLn = bi.getInt(this.dKT.optString("NotifyManage"), d.dKM);
        }
        return this.dLn == d.dKL;
    }

    public final String Ml() {
        if (this.dKT != null) {
            this.dKY = this.dKT.optString("VerifyContactPromptTitle");
        }
        return this.dKY;
    }

    public final String Mm() {
        if (this.dKT != null) {
            this.dLs = this.dKT.optString("TrademarkUrl");
        }
        return this.dLs;
    }

    public final String Mn() {
        if (this.dKT != null) {
            this.dLt = this.dKT.optString("TrademarkName");
        }
        return this.dLt;
    }

    public final String Mo() {
        if (this.dKT != null) {
            this.dKZ = this.dKT.optString("ConferenceContactExpireTime");
        }
        return this.dKZ;
    }

    public final List<f> Mp() {
        if (this.dKT != null && this.dLa == null) {
            this.dLa = f.b(this.dKT.optJSONArray("Privilege"));
        }
        return this.dLa;
    }

    public final int Mq() {
        if (this.dKT != null) {
            this.dLm = this.dKT.optInt("InteractiveMode");
        }
        return this.dLm;
    }

    public final e Mr() {
        if (this.dKT != null && this.dLd == null) {
            this.dLd = e.ky(this.dKT.optString("PayShowInfo"));
        }
        return this.dLd;
    }

    public final b Ms() {
        if (this.dKT != null && this.dLl == null) {
            String optString = this.dKT.optString("HardwareBizInfo");
            if (optString != null) {
                this.dLl = b.ku(optString);
            }
        }
        return this.dLl;
    }

    public final d Mt() {
        if (this.dKT != null && this.dLb == null) {
            this.dLb = d.kx(this.dKT.optString("VerifySource"));
        }
        return this.dLb;
    }

    public final g Mu() {
        if (this.dKT != null && this.dLr == null) {
            String optString = this.dKT.optString("RegisterSource");
            if (optString != null) {
                this.dLr = g.kz(optString);
            }
        }
        return this.dLr;
    }

    public final boolean LU() {
        boolean z = false;
        if (this.dKT != null) {
            if (bi.getInt(this.dKT.optString("ReportLocationType"), 0) > 0) {
                z = true;
            }
            this.dLf = z;
        }
        return this.dLf;
    }

    public final boolean Mv() {
        boolean z = true;
        if (this.dKT != null) {
            if (bi.getInt(this.dKT.optString("IsTrademarkProtection"), 0) != 1) {
                z = false;
            }
            this.dLp = z;
        }
        return this.dLp;
    }

    public final int Mw() {
        if (this.dKT != null) {
            this.dCn = this.dKT.optInt("ServiceType", 0);
        }
        return this.dCn;
    }

    public final String Mx() {
        if (this.dKT != null) {
            this.dLk = this.dKT.optString("SupportEmoticonLinkPrefix");
        }
        return this.dLk;
    }

    public final c My() {
        if (this.dKT != null && this.dLc == null) {
            String optString = this.dKT.optString("MMBizMenu");
            if (optString != null) {
                this.dLc = c.kv(optString);
            }
        }
        return this.dLc;
    }

    public final String Mz() {
        if (this.dKT != null) {
            this.dLo = this.dKT.optString("ServicePhone");
        }
        return this.dLo;
    }

    public final boolean MA() {
        if (this.dKT != null) {
            this.dLq = this.dKT.optInt("FunctionFlag");
        }
        return (this.dLq & d.dKN) > 0;
    }

    private d$b() {
    }

    static d$b ks(String str) {
        d$b d_b = new d$b();
        if (!bi.oW(str)) {
            try {
                System.currentTimeMillis();
                d_b.dKT = new JSONObject(str);
            } catch (Throwable e) {
                x.e("MicroMsg.BizInfo", "exception:%s", new Object[]{bi.i(e)});
            }
        }
        return d_b;
    }

    public final d$b$c$a MB() {
        if (this.dKT != null && this.dLe == null) {
            String optString = this.dKT.optString("EnterpriseBizInfo");
            if (optString != null) {
                this.dLe = d$b$c$a.kw(optString);
            }
        }
        return this.dLe;
    }
}
