package com.tencent.mm.plugin.wallet_index.b.a;

import java.util.ArrayList;
import org.json.JSONObject;

public final class c {
    public String eIe;
    public String iiv;
    String mPackageName;
    public String ogj;
    String pCE;
    public String pCF;
    long pCG;
    int pCH;
    public String pCI;
    public String pCJ;
    public String pCK;
    public String pCL;

    public c(String str, String str2, String str3) {
        this.pCE = str;
        this.pCJ = str2;
        JSONObject jSONObject = new JSONObject(this.pCJ);
        this.pCF = jSONObject.optString("orderId");
        this.mPackageName = jSONObject.optString("packageName");
        this.iiv = jSONObject.optString("productId");
        this.pCG = jSONObject.optLong("purchaseTime");
        this.pCH = jSONObject.optInt("purchaseState");
        String optString = jSONObject.optString("developerPayload");
        ArrayList PA = PA(optString);
        if (PA.size() == 3) {
            this.pCI = (String) PA.get(0);
            this.pCL = (String) PA.get(1);
            this.pCK = (String) PA.get(2);
        } else {
            this.pCI = optString;
        }
        this.eIe = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
        this.ogj = str3;
    }

    public c(String str, String str2, String str3, String str4) {
        this.iiv = str;
        this.pCI = str2;
        this.pCK = str3;
        this.pCL = str4;
    }

    private static ArrayList<String> PA(String str) {
        ArrayList<String> arrayList = new ArrayList();
        while (str.indexOf("[#]") >= 0) {
            String substring = str.substring(0, str.indexOf("[#]"));
            str = str.substring(substring.length() + 3);
            arrayList.add(substring);
        }
        arrayList.add(str);
        return arrayList;
    }

    public final String toString() {
        return "PurchaseInfo(type:" + this.pCE + "):" + this.pCJ;
    }
}
