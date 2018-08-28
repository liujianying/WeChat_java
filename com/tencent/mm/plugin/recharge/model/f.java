package com.tencent.mm.plugin.recharge.model;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.a.m;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.azc;
import com.tencent.mm.protocal.c.azd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f extends l implements k {
    public String Yy;
    public String appId;
    public int cmdId;
    public String desc;
    private b diG;
    private e diJ;
    public String eTa;
    public int errCode;
    public boolean moQ;
    public ArrayList<n> moR;
    public ArrayList<n> moS;
    public d moT;
    public d moU;
    public d moV;
    public d moW;
    public d moX;
    public m moY;
    public List<a> moZ;
    public boolean mpa;

    public f(String str) {
        this(str, 0);
    }

    public f(String str, int i) {
        this.eTa = "";
        this.appId = "";
        this.moQ = false;
        this.desc = "";
        this.errCode = 0;
        this.Yy = "";
        this.mpa = false;
        this.eTa = str;
        a aVar = new a();
        aVar.dIG = new azc();
        aVar.dIH = new azd();
        aVar.uri = "/cgi-bin/mmpay-bin/paychargeproxy";
        aVar.dIF = 1571;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        azc azc = (azc) this.diG.dID.dIL;
        azc.rtM = i;
        this.cmdId = i;
        x.i("MicroMsg.NetScenePayChargeProxy", "cmdId: %d", new Object[]{Integer.valueOf(i)});
        if (!bi.oW(this.eTa)) {
            x.i("MicroMsg.NetScenePayChargeProxy", "hy: requesting phone num: %s", new Object[]{this.eTa});
            azc.sbT = String.format("phone=%s", new Object[]{this.eTa});
        }
    }

    public final int getType() {
        return 1571;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetScenePayChargeProxy", "hy: NetScenePayChargeProxy end: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.errCode = i3;
        if (i2 == 0 && i3 == 0) {
            try {
                int i4;
                String optString;
                String optString2;
                String optString3;
                String optString4;
                JSONArray optJSONArray;
                JSONObject jSONObject = new JSONObject(((azd) ((b) qVar).dIE.dIL).sbU);
                x.d("MicroMsg.NetScenePayChargeProxy", "tofutest: json: %s", new Object[]{jSONObject.toString()});
                this.appId = jSONObject.optString("appId");
                this.errCode = jSONObject.optInt("errCode", -1);
                this.Yy = jSONObject.optString("errMsg", ad.getContext().getString(i.wallet_json_err));
                if (this.errCode < 0) {
                    this.moQ = true;
                } else {
                    this.moQ = false;
                }
                this.desc = jSONObject.optString("desc");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("productList");
                if (optJSONArray2 != null) {
                    this.moR = new ArrayList();
                    this.moS = new ArrayList();
                    for (i4 = 0; i4 < optJSONArray2.length(); i4++) {
                        JSONObject jSONObject2 = optJSONArray2.getJSONObject(i4);
                        n nVar = new n();
                        nVar.desc = jSONObject2.optString("desc", "");
                        nVar.id = jSONObject2.optString("id", "");
                        nVar.name = jSONObject2.optString("name", "");
                        nVar.status = jSONObject2.optInt("status", 0);
                        nVar.url = jSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL, "");
                        nVar.type = jSONObject2.optInt("type");
                        nVar.peu = jSONObject2.optString("typeName");
                        nVar.pew = jSONObject2.optString("isColor", "0");
                        nVar.pex = jSONObject2.optString("colorCode", "0");
                        nVar.pey = jSONObject2.optInt("isReConfirm", 0);
                        nVar.pdR = jSONObject2.optString("weappID");
                        nVar.dzE = jSONObject2.optString("weappPath");
                        nVar.pez = jSONObject2.optInt("isRecommend", 0);
                        if (nVar.type == 1) {
                            this.moR.add(nVar);
                        } else {
                            nVar.pev = jSONObject2.optString("productAttr");
                            this.moS.add(nVar);
                        }
                    }
                } else {
                    this.moR = null;
                    this.moS = null;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("weSim");
                if (optJSONObject != null) {
                    optString = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    optString2 = optJSONObject.optString("name");
                    optString3 = optJSONObject.optString("weappID");
                    optString4 = optJSONObject.optString("weappPath");
                    if (bi.oW(optString2)) {
                        x.w("MicroMsg.NetScenePayChargeProxy", "tf: weSim is missing");
                        this.moW = null;
                    } else {
                        this.moW = new d();
                        this.moW.url = optString;
                        this.moW.name = optString2;
                        this.moW.pdR = optString3;
                        this.moW.dzE = optString4;
                    }
                }
                optJSONObject = jSONObject.optJSONObject("wxRemind");
                if (optJSONObject != null) {
                    optString = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    optString2 = optJSONObject.optString("name");
                    optString3 = optJSONObject.optString("weappID");
                    optString4 = optJSONObject.optString("weappPath");
                    if (bi.oW(optString2)) {
                        x.w("MicroMsg.NetScenePayChargeProxy", "hy: remind unicom unnecessary element missing");
                    } else {
                        this.moT = new d();
                        this.moT.url = optString;
                        this.moT.name = optString2;
                        this.moT.pdR = optString3;
                        this.moT.dzE = optString4;
                        optJSONObject = jSONObject.optJSONObject("wxCard");
                        if (optJSONObject != null) {
                            optString = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                            optString2 = optJSONObject.optString("name");
                            optString3 = optJSONObject.optString("weappID");
                            optString4 = optJSONObject.optString("weappPath");
                            if (bi.oW(optString2)) {
                                x.w("MicroMsg.NetScenePayChargeProxy", "hy: phone card necessary element missing");
                            } else {
                                this.moU = new d();
                                this.moU.url = optString;
                                this.moU.name = optString2;
                                this.moU.pdR = optString3;
                                this.moU.dzE = optString4;
                                optJSONObject = jSONObject.optJSONObject("wxWt");
                                if (optJSONObject != null) {
                                    optString = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                    optString2 = optJSONObject.optString("name");
                                    optString3 = optJSONObject.optString("weappID");
                                    optString4 = optJSONObject.optString("weappPath");
                                    if (bi.oW(optString2)) {
                                        x.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
                                    } else {
                                        this.moV = new d();
                                        this.moV.url = optString;
                                        this.moV.name = optString2;
                                        this.moV.pdR = optString3;
                                        this.moV.dzE = optString4;
                                        optJSONObject = jSONObject.optJSONObject("banner");
                                        if (optJSONObject == null) {
                                            this.moY = new m();
                                            this.moY.id = optJSONObject.getInt("id");
                                            this.moY.name = optJSONObject.optString("name");
                                            this.moY.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                            this.moY.pdR = optJSONObject.optString("weappID");
                                            this.moY.dzE = optJSONObject.optString("weappPath");
                                        } else {
                                            this.moY = null;
                                        }
                                        optJSONObject = jSONObject.optJSONObject("headEnter");
                                        if (optJSONObject != null) {
                                            optString = optJSONObject.optString("name");
                                            optString2 = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                            optString3 = optJSONObject.optString("weappID");
                                            optString4 = optJSONObject.optString("weappPath");
                                            if (bi.oW(optString)) {
                                                x.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                                            } else {
                                                this.moX = new d();
                                                this.moX.name = optString;
                                                this.moX.url = optString2;
                                                this.moX.pdR = optString3;
                                                this.moX.dzE = optString4;
                                                optJSONArray = jSONObject.optJSONArray("numberList");
                                                if (optJSONArray != null) {
                                                    if (bi.oW(this.eTa)) {
                                                        this.mpa = true;
                                                    }
                                                    if (optJSONArray.length() <= 0) {
                                                        x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                                                        this.moZ = null;
                                                    } else {
                                                        this.moZ = new ArrayList();
                                                        for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                                                            if (optJSONObject2 != null) {
                                                                optString2 = optJSONObject2.optString("number");
                                                                optString = optJSONObject2.optString("desc");
                                                                if (!bi.oW(optString2)) {
                                                                    this.moZ.add(new a(optString2, "", optString, 2));
                                                                }
                                                            }
                                                        }
                                                        x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.moZ.size())});
                                                    }
                                                } else {
                                                    this.moZ = null;
                                                    x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                                                }
                                            }
                                        }
                                        this.moX = null;
                                        optJSONArray = jSONObject.optJSONArray("numberList");
                                        if (optJSONArray != null) {
                                            this.moZ = null;
                                            x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                                        } else {
                                            if (bi.oW(this.eTa)) {
                                                this.mpa = true;
                                            }
                                            if (optJSONArray.length() <= 0) {
                                                x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                                                this.moZ = null;
                                            } else {
                                                this.moZ = new ArrayList();
                                                for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                                    JSONObject optJSONObject22 = optJSONArray.optJSONObject(i4);
                                                    if (optJSONObject22 != null) {
                                                        optString2 = optJSONObject22.optString("number");
                                                        optString = optJSONObject22.optString("desc");
                                                        if (!bi.oW(optString2)) {
                                                            this.moZ.add(new a(optString2, "", optString, 2));
                                                        }
                                                    }
                                                }
                                                x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.moZ.size())});
                                            }
                                        }
                                    }
                                }
                                this.moV = null;
                                optJSONObject = jSONObject.optJSONObject("banner");
                                if (optJSONObject == null) {
                                    this.moY = null;
                                } else {
                                    this.moY = new m();
                                    this.moY.id = optJSONObject.getInt("id");
                                    this.moY.name = optJSONObject.optString("name");
                                    this.moY.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                    this.moY.pdR = optJSONObject.optString("weappID");
                                    this.moY.dzE = optJSONObject.optString("weappPath");
                                }
                                optJSONObject = jSONObject.optJSONObject("headEnter");
                                if (optJSONObject != null) {
                                    optString = optJSONObject.optString("name");
                                    optString2 = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                    optString3 = optJSONObject.optString("weappID");
                                    optString4 = optJSONObject.optString("weappPath");
                                    if (bi.oW(optString)) {
                                        x.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                                    } else {
                                        this.moX = new d();
                                        this.moX.name = optString;
                                        this.moX.url = optString2;
                                        this.moX.pdR = optString3;
                                        this.moX.dzE = optString4;
                                        optJSONArray = jSONObject.optJSONArray("numberList");
                                        if (optJSONArray != null) {
                                            if (bi.oW(this.eTa)) {
                                                this.mpa = true;
                                            }
                                            if (optJSONArray.length() <= 0) {
                                                x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                                                this.moZ = null;
                                            } else {
                                                this.moZ = new ArrayList();
                                                for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                                    JSONObject optJSONObject222 = optJSONArray.optJSONObject(i4);
                                                    if (optJSONObject222 != null) {
                                                        optString2 = optJSONObject222.optString("number");
                                                        optString = optJSONObject222.optString("desc");
                                                        if (!bi.oW(optString2)) {
                                                            this.moZ.add(new a(optString2, "", optString, 2));
                                                        }
                                                    }
                                                }
                                                x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.moZ.size())});
                                            }
                                        } else {
                                            this.moZ = null;
                                            x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                                        }
                                    }
                                }
                                this.moX = null;
                                optJSONArray = jSONObject.optJSONArray("numberList");
                                if (optJSONArray != null) {
                                    if (bi.oW(this.eTa)) {
                                        this.mpa = true;
                                    }
                                    if (optJSONArray.length() <= 0) {
                                        x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                                        this.moZ = null;
                                    } else {
                                        this.moZ = new ArrayList();
                                        for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                            JSONObject optJSONObject2222 = optJSONArray.optJSONObject(i4);
                                            if (optJSONObject2222 != null) {
                                                optString2 = optJSONObject2222.optString("number");
                                                optString = optJSONObject2222.optString("desc");
                                                if (!bi.oW(optString2)) {
                                                    this.moZ.add(new a(optString2, "", optString, 2));
                                                }
                                            }
                                        }
                                        x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.moZ.size())});
                                    }
                                } else {
                                    this.moZ = null;
                                    x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                                }
                            }
                        }
                        this.moU = null;
                        optJSONObject = jSONObject.optJSONObject("wxWt");
                        if (optJSONObject != null) {
                            optString = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                            optString2 = optJSONObject.optString("name");
                            optString3 = optJSONObject.optString("weappID");
                            optString4 = optJSONObject.optString("weappPath");
                            if (bi.oW(optString2)) {
                                x.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
                            } else {
                                this.moV = new d();
                                this.moV.url = optString;
                                this.moV.name = optString2;
                                this.moV.pdR = optString3;
                                this.moV.dzE = optString4;
                                optJSONObject = jSONObject.optJSONObject("banner");
                                if (optJSONObject == null) {
                                    this.moY = new m();
                                    this.moY.id = optJSONObject.getInt("id");
                                    this.moY.name = optJSONObject.optString("name");
                                    this.moY.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                    this.moY.pdR = optJSONObject.optString("weappID");
                                    this.moY.dzE = optJSONObject.optString("weappPath");
                                } else {
                                    this.moY = null;
                                }
                                optJSONObject = jSONObject.optJSONObject("headEnter");
                                if (optJSONObject != null) {
                                    optString = optJSONObject.optString("name");
                                    optString2 = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                    optString3 = optJSONObject.optString("weappID");
                                    optString4 = optJSONObject.optString("weappPath");
                                    if (bi.oW(optString)) {
                                        x.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                                    } else {
                                        this.moX = new d();
                                        this.moX.name = optString;
                                        this.moX.url = optString2;
                                        this.moX.pdR = optString3;
                                        this.moX.dzE = optString4;
                                        optJSONArray = jSONObject.optJSONArray("numberList");
                                        if (optJSONArray != null) {
                                            if (bi.oW(this.eTa)) {
                                                this.mpa = true;
                                            }
                                            if (optJSONArray.length() <= 0) {
                                                x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                                                this.moZ = null;
                                            } else {
                                                this.moZ = new ArrayList();
                                                for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                                    JSONObject optJSONObject22222 = optJSONArray.optJSONObject(i4);
                                                    if (optJSONObject22222 != null) {
                                                        optString2 = optJSONObject22222.optString("number");
                                                        optString = optJSONObject22222.optString("desc");
                                                        if (!bi.oW(optString2)) {
                                                            this.moZ.add(new a(optString2, "", optString, 2));
                                                        }
                                                    }
                                                }
                                                x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.moZ.size())});
                                            }
                                        } else {
                                            this.moZ = null;
                                            x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                                        }
                                    }
                                }
                                this.moX = null;
                                optJSONArray = jSONObject.optJSONArray("numberList");
                                if (optJSONArray != null) {
                                    this.moZ = null;
                                    x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                                } else {
                                    if (bi.oW(this.eTa)) {
                                        this.mpa = true;
                                    }
                                    if (optJSONArray.length() <= 0) {
                                        x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                                        this.moZ = null;
                                    } else {
                                        this.moZ = new ArrayList();
                                        for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                            JSONObject optJSONObject222222 = optJSONArray.optJSONObject(i4);
                                            if (optJSONObject222222 != null) {
                                                optString2 = optJSONObject222222.optString("number");
                                                optString = optJSONObject222222.optString("desc");
                                                if (!bi.oW(optString2)) {
                                                    this.moZ.add(new a(optString2, "", optString, 2));
                                                }
                                            }
                                        }
                                        x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.moZ.size())});
                                    }
                                }
                            }
                        }
                        this.moV = null;
                        optJSONObject = jSONObject.optJSONObject("banner");
                        if (optJSONObject == null) {
                            this.moY = new m();
                            this.moY.id = optJSONObject.getInt("id");
                            this.moY.name = optJSONObject.optString("name");
                            this.moY.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                            this.moY.pdR = optJSONObject.optString("weappID");
                            this.moY.dzE = optJSONObject.optString("weappPath");
                        } else {
                            this.moY = null;
                        }
                        optJSONObject = jSONObject.optJSONObject("headEnter");
                        if (optJSONObject != null) {
                            optString = optJSONObject.optString("name");
                            optString2 = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                            optString3 = optJSONObject.optString("weappID");
                            optString4 = optJSONObject.optString("weappPath");
                            if (bi.oW(optString)) {
                                x.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                            } else {
                                this.moX = new d();
                                this.moX.name = optString;
                                this.moX.url = optString2;
                                this.moX.pdR = optString3;
                                this.moX.dzE = optString4;
                                optJSONArray = jSONObject.optJSONArray("numberList");
                                if (optJSONArray != null) {
                                    if (bi.oW(this.eTa)) {
                                        this.mpa = true;
                                    }
                                    if (optJSONArray.length() <= 0) {
                                        x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                                        this.moZ = null;
                                    } else {
                                        this.moZ = new ArrayList();
                                        for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                            JSONObject optJSONObject2222222 = optJSONArray.optJSONObject(i4);
                                            if (optJSONObject2222222 != null) {
                                                optString2 = optJSONObject2222222.optString("number");
                                                optString = optJSONObject2222222.optString("desc");
                                                if (!bi.oW(optString2)) {
                                                    this.moZ.add(new a(optString2, "", optString, 2));
                                                }
                                            }
                                        }
                                        x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.moZ.size())});
                                    }
                                } else {
                                    this.moZ = null;
                                    x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                                }
                            }
                        }
                        this.moX = null;
                        optJSONArray = jSONObject.optJSONArray("numberList");
                        if (optJSONArray != null) {
                            this.moZ = null;
                            x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                        } else {
                            if (bi.oW(this.eTa)) {
                                this.mpa = true;
                            }
                            if (optJSONArray.length() <= 0) {
                                x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                                this.moZ = null;
                            } else {
                                this.moZ = new ArrayList();
                                for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                    JSONObject optJSONObject22222222 = optJSONArray.optJSONObject(i4);
                                    if (optJSONObject22222222 != null) {
                                        optString2 = optJSONObject22222222.optString("number");
                                        optString = optJSONObject22222222.optString("desc");
                                        if (!bi.oW(optString2)) {
                                            this.moZ.add(new a(optString2, "", optString, 2));
                                        }
                                    }
                                }
                                x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.moZ.size())});
                            }
                        }
                    }
                }
                this.moT = null;
                optJSONObject = jSONObject.optJSONObject("wxCard");
                if (optJSONObject != null) {
                    optString = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    optString2 = optJSONObject.optString("name");
                    optString3 = optJSONObject.optString("weappID");
                    optString4 = optJSONObject.optString("weappPath");
                    if (bi.oW(optString2)) {
                        x.w("MicroMsg.NetScenePayChargeProxy", "hy: phone card necessary element missing");
                    } else {
                        this.moU = new d();
                        this.moU.url = optString;
                        this.moU.name = optString2;
                        this.moU.pdR = optString3;
                        this.moU.dzE = optString4;
                        optJSONObject = jSONObject.optJSONObject("wxWt");
                        if (optJSONObject != null) {
                            optString = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                            optString2 = optJSONObject.optString("name");
                            optString3 = optJSONObject.optString("weappID");
                            optString4 = optJSONObject.optString("weappPath");
                            if (bi.oW(optString2)) {
                                x.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
                            } else {
                                this.moV = new d();
                                this.moV.url = optString;
                                this.moV.name = optString2;
                                this.moV.pdR = optString3;
                                this.moV.dzE = optString4;
                                optJSONObject = jSONObject.optJSONObject("banner");
                                if (optJSONObject == null) {
                                    this.moY = new m();
                                    this.moY.id = optJSONObject.getInt("id");
                                    this.moY.name = optJSONObject.optString("name");
                                    this.moY.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                    this.moY.pdR = optJSONObject.optString("weappID");
                                    this.moY.dzE = optJSONObject.optString("weappPath");
                                } else {
                                    this.moY = null;
                                }
                                optJSONObject = jSONObject.optJSONObject("headEnter");
                                if (optJSONObject != null) {
                                    optString = optJSONObject.optString("name");
                                    optString2 = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                    optString3 = optJSONObject.optString("weappID");
                                    optString4 = optJSONObject.optString("weappPath");
                                    if (bi.oW(optString)) {
                                        x.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                                    } else {
                                        this.moX = new d();
                                        this.moX.name = optString;
                                        this.moX.url = optString2;
                                        this.moX.pdR = optString3;
                                        this.moX.dzE = optString4;
                                        optJSONArray = jSONObject.optJSONArray("numberList");
                                        if (optJSONArray != null) {
                                            if (bi.oW(this.eTa)) {
                                                this.mpa = true;
                                            }
                                            if (optJSONArray.length() <= 0) {
                                                x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                                                this.moZ = null;
                                            } else {
                                                this.moZ = new ArrayList();
                                                for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                                    JSONObject optJSONObject222222222 = optJSONArray.optJSONObject(i4);
                                                    if (optJSONObject222222222 != null) {
                                                        optString2 = optJSONObject222222222.optString("number");
                                                        optString = optJSONObject222222222.optString("desc");
                                                        if (!bi.oW(optString2)) {
                                                            this.moZ.add(new a(optString2, "", optString, 2));
                                                        }
                                                    }
                                                }
                                                x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.moZ.size())});
                                            }
                                        } else {
                                            this.moZ = null;
                                            x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                                        }
                                    }
                                }
                                this.moX = null;
                                optJSONArray = jSONObject.optJSONArray("numberList");
                                if (optJSONArray != null) {
                                    this.moZ = null;
                                    x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                                } else {
                                    if (bi.oW(this.eTa)) {
                                        this.mpa = true;
                                    }
                                    if (optJSONArray.length() <= 0) {
                                        x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                                        this.moZ = null;
                                    } else {
                                        this.moZ = new ArrayList();
                                        for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                            JSONObject optJSONObject2222222222 = optJSONArray.optJSONObject(i4);
                                            if (optJSONObject2222222222 != null) {
                                                optString2 = optJSONObject2222222222.optString("number");
                                                optString = optJSONObject2222222222.optString("desc");
                                                if (!bi.oW(optString2)) {
                                                    this.moZ.add(new a(optString2, "", optString, 2));
                                                }
                                            }
                                        }
                                        x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.moZ.size())});
                                    }
                                }
                            }
                        }
                        this.moV = null;
                        optJSONObject = jSONObject.optJSONObject("banner");
                        if (optJSONObject == null) {
                            this.moY = null;
                        } else {
                            this.moY = new m();
                            this.moY.id = optJSONObject.getInt("id");
                            this.moY.name = optJSONObject.optString("name");
                            this.moY.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                            this.moY.pdR = optJSONObject.optString("weappID");
                            this.moY.dzE = optJSONObject.optString("weappPath");
                        }
                        optJSONObject = jSONObject.optJSONObject("headEnter");
                        if (optJSONObject != null) {
                            optString = optJSONObject.optString("name");
                            optString2 = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                            optString3 = optJSONObject.optString("weappID");
                            optString4 = optJSONObject.optString("weappPath");
                            if (bi.oW(optString)) {
                                x.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                            } else {
                                this.moX = new d();
                                this.moX.name = optString;
                                this.moX.url = optString2;
                                this.moX.pdR = optString3;
                                this.moX.dzE = optString4;
                                optJSONArray = jSONObject.optJSONArray("numberList");
                                if (optJSONArray != null) {
                                    if (bi.oW(this.eTa)) {
                                        this.mpa = true;
                                    }
                                    if (optJSONArray.length() <= 0) {
                                        x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                                        this.moZ = null;
                                    } else {
                                        this.moZ = new ArrayList();
                                        for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                            JSONObject optJSONObject22222222222 = optJSONArray.optJSONObject(i4);
                                            if (optJSONObject22222222222 != null) {
                                                optString2 = optJSONObject22222222222.optString("number");
                                                optString = optJSONObject22222222222.optString("desc");
                                                if (!bi.oW(optString2)) {
                                                    this.moZ.add(new a(optString2, "", optString, 2));
                                                }
                                            }
                                        }
                                        x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.moZ.size())});
                                    }
                                } else {
                                    this.moZ = null;
                                    x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                                }
                            }
                        }
                        this.moX = null;
                        optJSONArray = jSONObject.optJSONArray("numberList");
                        if (optJSONArray != null) {
                            if (bi.oW(this.eTa)) {
                                this.mpa = true;
                            }
                            if (optJSONArray.length() <= 0) {
                                x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                                this.moZ = null;
                            } else {
                                this.moZ = new ArrayList();
                                for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                    JSONObject optJSONObject222222222222 = optJSONArray.optJSONObject(i4);
                                    if (optJSONObject222222222222 != null) {
                                        optString2 = optJSONObject222222222222.optString("number");
                                        optString = optJSONObject222222222222.optString("desc");
                                        if (!bi.oW(optString2)) {
                                            this.moZ.add(new a(optString2, "", optString, 2));
                                        }
                                    }
                                }
                                x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.moZ.size())});
                            }
                        } else {
                            this.moZ = null;
                            x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                        }
                    }
                }
                this.moU = null;
                optJSONObject = jSONObject.optJSONObject("wxWt");
                if (optJSONObject != null) {
                    optString = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    optString2 = optJSONObject.optString("name");
                    optString3 = optJSONObject.optString("weappID");
                    optString4 = optJSONObject.optString("weappPath");
                    if (bi.oW(optString2)) {
                        x.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
                    } else {
                        this.moV = new d();
                        this.moV.url = optString;
                        this.moV.name = optString2;
                        this.moV.pdR = optString3;
                        this.moV.dzE = optString4;
                        optJSONObject = jSONObject.optJSONObject("banner");
                        if (optJSONObject == null) {
                            this.moY = new m();
                            this.moY.id = optJSONObject.getInt("id");
                            this.moY.name = optJSONObject.optString("name");
                            this.moY.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                            this.moY.pdR = optJSONObject.optString("weappID");
                            this.moY.dzE = optJSONObject.optString("weappPath");
                        } else {
                            this.moY = null;
                        }
                        optJSONObject = jSONObject.optJSONObject("headEnter");
                        if (optJSONObject != null) {
                            optString = optJSONObject.optString("name");
                            optString2 = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                            optString3 = optJSONObject.optString("weappID");
                            optString4 = optJSONObject.optString("weappPath");
                            if (bi.oW(optString)) {
                                x.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                            } else {
                                this.moX = new d();
                                this.moX.name = optString;
                                this.moX.url = optString2;
                                this.moX.pdR = optString3;
                                this.moX.dzE = optString4;
                                optJSONArray = jSONObject.optJSONArray("numberList");
                                if (optJSONArray != null) {
                                    if (bi.oW(this.eTa)) {
                                        this.mpa = true;
                                    }
                                    if (optJSONArray.length() <= 0) {
                                        x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                                        this.moZ = null;
                                    } else {
                                        this.moZ = new ArrayList();
                                        for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                            JSONObject optJSONObject2222222222222 = optJSONArray.optJSONObject(i4);
                                            if (optJSONObject2222222222222 != null) {
                                                optString2 = optJSONObject2222222222222.optString("number");
                                                optString = optJSONObject2222222222222.optString("desc");
                                                if (!bi.oW(optString2)) {
                                                    this.moZ.add(new a(optString2, "", optString, 2));
                                                }
                                            }
                                        }
                                        x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.moZ.size())});
                                    }
                                } else {
                                    this.moZ = null;
                                    x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                                }
                            }
                        }
                        this.moX = null;
                        optJSONArray = jSONObject.optJSONArray("numberList");
                        if (optJSONArray != null) {
                            this.moZ = null;
                            x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                        } else {
                            if (bi.oW(this.eTa)) {
                                this.mpa = true;
                            }
                            if (optJSONArray.length() <= 0) {
                                x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                                this.moZ = null;
                            } else {
                                this.moZ = new ArrayList();
                                for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                    JSONObject optJSONObject22222222222222 = optJSONArray.optJSONObject(i4);
                                    if (optJSONObject22222222222222 != null) {
                                        optString2 = optJSONObject22222222222222.optString("number");
                                        optString = optJSONObject22222222222222.optString("desc");
                                        if (!bi.oW(optString2)) {
                                            this.moZ.add(new a(optString2, "", optString, 2));
                                        }
                                    }
                                }
                                x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.moZ.size())});
                            }
                        }
                    }
                }
                this.moV = null;
                optJSONObject = jSONObject.optJSONObject("banner");
                if (optJSONObject == null) {
                    this.moY = null;
                } else {
                    this.moY = new m();
                    this.moY.id = optJSONObject.getInt("id");
                    this.moY.name = optJSONObject.optString("name");
                    this.moY.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    this.moY.pdR = optJSONObject.optString("weappID");
                    this.moY.dzE = optJSONObject.optString("weappPath");
                }
                optJSONObject = jSONObject.optJSONObject("headEnter");
                if (optJSONObject != null) {
                    optString = optJSONObject.optString("name");
                    optString2 = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    optString3 = optJSONObject.optString("weappID");
                    optString4 = optJSONObject.optString("weappPath");
                    if (bi.oW(optString)) {
                        x.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                    } else {
                        this.moX = new d();
                        this.moX.name = optString;
                        this.moX.url = optString2;
                        this.moX.pdR = optString3;
                        this.moX.dzE = optString4;
                        optJSONArray = jSONObject.optJSONArray("numberList");
                        if (optJSONArray != null) {
                            if (bi.oW(this.eTa)) {
                                this.mpa = true;
                            }
                            if (optJSONArray.length() <= 0) {
                                x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                                this.moZ = null;
                            } else {
                                this.moZ = new ArrayList();
                                for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                    JSONObject optJSONObject222222222222222 = optJSONArray.optJSONObject(i4);
                                    if (optJSONObject222222222222222 != null) {
                                        optString2 = optJSONObject222222222222222.optString("number");
                                        optString = optJSONObject222222222222222.optString("desc");
                                        if (!bi.oW(optString2)) {
                                            this.moZ.add(new a(optString2, "", optString, 2));
                                        }
                                    }
                                }
                                x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.moZ.size())});
                            }
                        } else {
                            this.moZ = null;
                            x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                        }
                    }
                }
                this.moX = null;
                optJSONArray = jSONObject.optJSONArray("numberList");
                if (optJSONArray != null) {
                    if (bi.oW(this.eTa)) {
                        this.mpa = true;
                    }
                    if (optJSONArray.length() <= 0) {
                        x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                        this.moZ = null;
                    } else {
                        this.moZ = new ArrayList();
                        for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                            JSONObject optJSONObject2222222222222222 = optJSONArray.optJSONObject(i4);
                            if (optJSONObject2222222222222222 != null) {
                                optString2 = optJSONObject2222222222222222.optString("number");
                                optString = optJSONObject2222222222222222.optString("desc");
                                if (!bi.oW(optString2)) {
                                    this.moZ.add(new a(optString2, "", optString, 2));
                                }
                            }
                        }
                        x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.moZ.size())});
                    }
                } else {
                    this.moZ = null;
                    x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                }
            } catch (Exception e) {
                x.e("MicroMsg.NetScenePayChargeProxy", "hy: exception occurred when parsing json: %s", new Object[]{e.toString()});
                this.moQ = true;
                this.Yy = ad.getContext().getString(i.wallet_json_err);
            }
        } else {
            this.moQ = true;
            if (bi.oW(str)) {
                str = ad.getContext().getString(i.wallet_data_err);
            }
            this.Yy = str;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
