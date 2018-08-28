package com.tencent.mm.plugin.wallet_core.d;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.c.c;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.util.EncodingUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    private static final String hwK = (e.bnE + "wallet");
    private static Map<String, String> psu = null;

    public static boolean Pi(String str) {
        try {
            if (psu == null) {
                psu = new HashMap();
            }
            x.d("MicroMsg.WalletBankLogoStorage", "bank logo:" + str);
            Editor edit = ad.getContext().getSharedPreferences("bank_logo", 0).edit();
            JSONArray jSONArray = new JSONObject(str).getJSONArray("bank_urls_list");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String optString;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (q.GS()) {
                    optString = jSONObject.optString("bank_desc");
                } else {
                    optString = jSONObject.optString("bank_type");
                }
                String jSONObject2 = jSONObject.toString();
                if (bi.oW(optString) || bi.oW(jSONObject2)) {
                    break;
                }
                edit.putString(optString, jSONObject2);
                psu.put(optString, jSONObject2);
            }
            edit.commit();
            x.d("MicroMsg.WalletBankLogoStorage", "update BankLogo config file. success!");
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.WalletBankLogoStorage", "parse band logo error. %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e, "", new Object[0]);
            return false;
        }
    }

    public static boolean aj(LinkedList<String> linkedList) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        try {
            if (psu == null) {
                psu = new HashMap();
            }
            Editor edit = ad.getContext().getSharedPreferences("bank_logo", 0).edit();
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                String optString;
                JSONObject jSONObject = new JSONObject((String) linkedList.get(i));
                if (q.GS()) {
                    optString = jSONObject.optString("bank_desc");
                } else {
                    optString = jSONObject.optString("bank_type");
                }
                jSONObject.put("timestamp", currentTimeMillis);
                String jSONObject2 = jSONObject.toString();
                if (bi.oW(optString) || bi.oW(jSONObject2)) {
                    break;
                }
                edit.putString(optString, jSONObject2);
                psu.put(optString, jSONObject2);
            }
            edit.commit();
            x.d("MicroMsg.WalletBankLogoStorage", "update BankLogo config file. success!");
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.WalletBankLogoStorage", "parse band logo error. %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e, "", new Object[0]);
            return false;
        }
    }

    public static com.tencent.mm.plugin.wallet_core.model.e Pj(String str) {
        int i;
        if (psu == null) {
            bPQ();
        }
        if (bi.oW((String) psu.get(str))) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            return null;
        }
        String str2 = (String) psu.get(str);
        if (bi.oW(str2)) {
            return null;
        }
        com.tencent.mm.plugin.wallet_core.model.e eVar = new com.tencent.mm.plugin.wallet_core.model.e();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            long optLong = jSONObject.optLong("timestamp", 0);
            eVar.lCU = jSONObject.getString("logo2x_url");
            eVar.pmn = jSONObject.getString("bg2x_url");
            eVar.pmo = jSONObject.getString("wl2x_url");
            eVar.pmt = (System.currentTimeMillis() / 1000) - optLong > 7200;
            eVar.pmp = JC(eVar.lCU);
            eVar.mcD = jSONObject.optString("bank_name_pinyin", "");
            eVar.timestamp = optLong;
            return eVar;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e, "", new Object[0]);
            return null;
        }
    }

    private static void bPQ() {
        psu = new HashMap();
        for (Entry entry : ad.getContext().getSharedPreferences("bank_logo", 0).getAll().entrySet()) {
            psu.put(entry.getKey(), (String) entry.getValue());
        }
    }

    public static com.tencent.mm.plugin.wallet_core.model.e h(Context context, String str, boolean z) {
        if (!z) {
            return aQ(context, str);
        }
        if (!"CITIC_CREDIT".equals(str)) {
            return null;
        }
        com.tencent.mm.plugin.wallet_core.model.e eVar = new com.tencent.mm.plugin.wallet_core.model.e();
        eVar.pmr = a$e.wallet_bankcard_white_bg;
        eVar.pms = a$e.wallet_bankcard_wxcredit_citic_water_mask;
        com.tencent.mm.plugin.wallet_core.model.e aQ = aQ(context, str);
        if (aQ == null) {
            return eVar;
        }
        eVar.lCU = aQ.lCU;
        return eVar;
    }

    private static com.tencent.mm.plugin.wallet_core.model.e aQ(Context context, String str) {
        String str2;
        boolean z;
        com.tencent.mm.plugin.wallet_core.model.e eVar;
        boolean z2 = true;
        if (psu == null) {
            bPQ();
            str2 = (String) psu.get(str);
        } else {
            str2 = (String) psu.get(str);
            if (str2 == null) {
                x.i("MicroMsg.WalletBankLogoStorage", "can not get from bankLogoCache %s", new Object[]{str});
                str2 = ad.getContext().getSharedPreferences("bank_logo", 0).getString(str, "");
                if (str2 != null) {
                    x.w("MicroMsg.WalletBankLogoStorage", "get from sp %s", new Object[]{str});
                    psu.put(str, str2);
                }
            }
        }
        if (bi.oW(str2)) {
            g.Ek();
            if (g.Ei().isSDCardAvailable()) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(str);
                c cVar = new c(linkedList);
                g.Ek();
                g.Eh().dpP.a(cVar, 0);
            }
            Pi(aR(context, "config/bank_logo.xml"));
            if (psu != null) {
                str2 = (String) psu.get(str);
                z = true;
            } else {
                z = true;
            }
        } else {
            z = false;
        }
        if (bi.oW(str2)) {
            eVar = null;
        } else {
            com.tencent.mm.plugin.wallet_core.model.e eVar2 = new com.tencent.mm.plugin.wallet_core.model.e();
            try {
                JSONObject jSONObject = new JSONObject(str2);
                long optLong = jSONObject.optLong("timestamp", 0);
                eVar2.lCU = jSONObject.getString("logo2x_url");
                eVar2.pmn = jSONObject.getString("bg2x_url");
                eVar2.pmo = jSONObject.getString("wl2x_url");
                if (!z && (System.currentTimeMillis() / 1000) - optLong <= 7200) {
                    z2 = false;
                }
                eVar2.pmt = z2;
                eVar2.pmp = JC(eVar2.lCU);
                eVar2.mcD = jSONObject.optString("bank_name_pinyin", "");
                eVar2.timestamp = optLong;
                eVar = eVar2;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e, "", new Object[0]);
                return null;
            }
        }
        return eVar;
    }

    private static String aR(Context context, String str) {
        String str2 = "";
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            str2 = EncodingUtils.getString(bArr, "UTF-8");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e, "close", new Object[0]);
                }
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e2, "getFromAssets", new Object[0]);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e22, "close", new Object[0]);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e222) {
                    x.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e222, "close", new Object[0]);
                }
            }
        }
        return str2;
    }

    public static String bPR() {
        return hwK;
    }

    public static String JC(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.WalletBankLogoStorage", "getStoragePath: but url is null");
            return null;
        }
        return String.format("%s/%s", new Object[]{hwK, com.tencent.mm.a.g.u(str.getBytes())});
    }
}
