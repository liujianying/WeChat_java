package com.tencent.mm.plugin.wallet_core.model.mall;

import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public static int prX = -256;
    public static int prY = 621019136;
    public static int prZ = 637534720;

    public static ArrayList<MallNews> u(JSONArray jSONArray) {
        try {
            ArrayList<MallNews> arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                MallNews mallNews = new MallNews(jSONObject.optString("activity_jump_funcid"));
                mallNews.psf = jSONObject.optString("activity_icon_link");
                mallNews.psd = jSONObject.optString("activity_msg_content");
                mallNews.psh = jSONObject.optString("activity_tips");
                arrayList.add(mallNews);
            }
            return arrayList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MallLogic", e, "", new Object[0]);
            return null;
        }
    }

    public static ArrayList<a> v(JSONArray jSONArray) {
        try {
            ArrayList<a> arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                a aVar = new a();
                aVar.prP = jSONObject.optInt("banner_id");
                aVar.prQ = jSONObject.optString("banner_title");
                aVar.prR = jSONObject.optString("banner_link");
                arrayList.add(aVar);
            }
            return arrayList;
        } catch (JSONException e) {
            x.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + e.getMessage());
            return null;
        }
    }

    public static SparseArray<String> w(JSONArray jSONArray) {
        try {
            SparseArray<String> sparseArray = new SparseArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                int optInt = jSONObject.optInt("type_id", 0);
                if (optInt != 0) {
                    sparseArray.put(optInt, jSONObject.optString("type_name"));
                }
            }
            return sparseArray;
        } catch (JSONException e) {
            x.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + e.getMessage());
            return null;
        }
    }

    public static boolean cE(List<a> list) {
        g.Ek();
        int intValue = ((Integer) g.Ei().DT().get(270342, Integer.valueOf(0))).intValue();
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                x.d("MicroMsg.MallLogic", "i:" + size + ", lastClickedListMaxId:" + intValue + ", actId:" + ((a) list.get(size)).prP);
                if (((a) list.get(size)).prP > intValue) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void cF(List<a> list) {
        if (list == null || list.size() <= 0) {
            x.w("MicroMsg.MallLogic", "func[setBannerRedDotClick] actList null or empty");
            return;
        }
        int i = ((a) list.get(0)).prP;
        x.d("MicroMsg.MallLogic", "func[setBannerRedDotClick], lastClickedListMaxId" + i);
        g.Ek();
        g.Ei().DT().set(270342, Integer.valueOf(i));
        g.Ek();
        g.Ei().DT().lm(true);
    }

    public static ArrayList<MallFunction> x(JSONArray jSONArray) {
        try {
            ArrayList<MallFunction> arrayList = new ArrayList();
            int length = jSONArray.length();
            x.d("MicroMsg.MallLogic", "functions.jsonArray.length : " + length);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                MallFunction mallFunction = new MallFunction();
                mallFunction.moy = jSONObject.getString("func_id");
                mallFunction.cbR = jSONObject.getString("func_name");
                mallFunction.prS = jSONObject.optString("func_icon_url");
                mallFunction.kYQ = jSONObject.optString("hd_icon_url");
                mallFunction.kYR = jSONObject.optString("func_foregroud_icon_url");
                mallFunction.ceR = jSONObject.optString("native_url");
                mallFunction.kck = jSONObject.optString("h5_url");
                mallFunction.type = jSONObject.optInt("property_type", 0);
                mallFunction.prV = jSONObject.optString("third_party_disclaimer");
                mallFunction.prW = jSONObject.optInt("download_restrict", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("remark_name_list");
                if (optJSONArray != null) {
                    mallFunction.prT = new ArrayList();
                    int length2 = optJSONArray.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        mallFunction.prT.add(optJSONArray.getString(i2));
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("activity_info_list");
                if (!(optJSONArray2 == null || optJSONArray2.length() == 0)) {
                    String str = mallFunction.moy;
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(0);
                    MallNews mallNews = new MallNews(str);
                    mallNews.oqH = jSONObject2.optString("activity_id");
                    mallNews.bLe = jSONObject2.optString("activity_ticket");
                    mallNews.psd = jSONObject2.optString("activity_msg_content");
                    mallNews.pse = jSONObject2.optString("activity_link");
                    mallNews.psf = jSONObject2.optString("activity_icon_link");
                    mallNews.psg = jSONObject2.optInt("activity_expired_time");
                    mallNews.psh = jSONObject2.optString("activity_tips");
                    mallNews.ppS = jSONObject2.optInt("activity_type");
                    mallNews.psk = jSONObject2.optString("activity_url");
                    mallNews.psi = jSONObject2.optInt("is_msg_reserved");
                    mallFunction.prU = mallNews;
                }
                arrayList.add(mallFunction);
            }
            return arrayList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MallLogic", e, "", new Object[0]);
            return null;
        }
    }

    public static String bPJ() {
        TelephonyManager telephonyManager = (TelephonyManager) ad.getContext().getSystemService("phone");
        String str = "";
        if (telephonyManager != null) {
            return telephonyManager.getNetworkCountryIso();
        }
        return str;
    }

    public static void zn(int i) {
        boolean z;
        if ((d.qVN & prX) == i) {
            g.Ek();
            int intValue = ((Integer) g.Ei().DT().get(270343, Integer.valueOf(0))).intValue();
            if (i != intValue) {
                x.d("MicroMsg.MallLogic", "Mall reddot show, targetV=" + i + ", clickedV=" + intValue);
                z = true;
                if (z && q.GO()) {
                    x.d("MicroMsg.MallLogic", "Show mall entry redot");
                    c.Cp().u(262156, true);
                    g.Ek();
                    g.Ei().DT().set(270343, Integer.valueOf(i));
                    g.Ek();
                    g.Ei().DT().a(a.sXJ, Long.valueOf(System.currentTimeMillis()));
                    return;
                }
            }
        }
        z = false;
        if (z) {
        }
    }
}
