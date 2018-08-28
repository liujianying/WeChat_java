package com.tencent.mm.plugin.card.sharecard.a;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.card.a$g;
import com.tencent.mm.plugin.card.d.s;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.plugin.card.sharecard.model.i;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.plugin.card.sharecard.model.m;
import com.tencent.mm.plugin.card.sharecard.model.p;
import com.tencent.mm.plugin.card.sharecard.ui.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class b {
    private static boolean dFt = false;
    public static boolean hyf = false;
    public a hye = null;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
        hyf = false;
    }

    public final void init() {
        if (((l) am.axn().getValue("key_share_card_layout_data")) == null) {
            x.e("MicroMsg.ShareCardDataMgr", "initShareCardLayoutData, data cache is empty!, load data from db!");
            Object azU = com.tencent.mm.plugin.card.d.l.azU();
            if (TextUtils.isEmpty(azU)) {
                x.e("MicroMsg.ShareCardDataMgr", "initShareCardLayoutData, json is empty");
                return;
            }
            l yf = s.yf(azU);
            if (yf != null) {
                x.i("MicroMsg.ShareCardDataMgr", "load share card layout data success!");
                am.axn().putValue("key_share_card_layout_data", yf);
                a(yf, true);
                return;
            }
            x.e("MicroMsg.ShareCardDataMgr", "load share card layout data fail!");
            return;
        }
        x.i("MicroMsg.ShareCardDataMgr", "the share card layout cache is valid!");
    }

    public static int axE() {
        int i = 0;
        c axi = am.axi();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where (status=0 OR status=5) AND card_type=10");
        Cursor b = axi.diF.b("select count(*) from UserCardInfo" + stringBuilder.toString(), null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                i = b.getInt(0);
            }
            b.close();
        }
        return i;
    }

    public final void af(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.ShareCardDataMgr", "updateGetShareLayoutData json is empty");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        l yf = s.yf(str);
        l lVar = (l) am.axn().getValue("key_share_card_layout_data");
        if (yf == null) {
            x.e("MicroMsg.ShareCardDataMgr", "updateGetShareLayoutData data == null");
            a(yf, lVar, z);
            am.axn().putValue("key_share_card_layout_data", yf);
            return;
        }
        if (z) {
            com.tencent.mm.plugin.card.d.l.xX(str);
        }
        a(yf, z);
        a(yf, lVar, z);
        am.axn().putValue("key_share_card_layout_data", yf);
        int i = 0;
        if (yf.hyt != null && yf.hyt.size() > 0) {
            i = yf.hyt.size();
        }
        if (yf.hyu != null && yf.hyu.size() > 0) {
            i += yf.hyu.size();
        }
        if (i > 0) {
            int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(10);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(11);
            iDKey2.SetValue((long) currentTimeMillis2);
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(281);
            iDKey3.SetKey(12);
            iDKey3.SetValue((long) i);
            IDKey iDKey4 = new IDKey();
            iDKey4.SetID(281);
            iDKey4.SetKey(14);
            iDKey4.SetValue((long) (currentTimeMillis2 / i));
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            arrayList.add(iDKey3);
            arrayList.add(iDKey4);
            h.mEJ.b(arrayList, true);
        }
    }

    private void a(l lVar, boolean z) {
        int i = 0;
        if (lVar == null) {
            x.e("MicroMsg.ShareCardDataMgr", "don't parserShareCardListData, data is null");
            return;
        }
        Map hashMap;
        Map hashMap2;
        Map hashMap3;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        m mVar;
        x.i("MicroMsg.ShareCardDataMgr", "parserShareCardListData()");
        Map map = (Map) am.axn().getValue("key_share_card_annoucement_map");
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = map;
        }
        map = (Map) am.axn().getValue("key_share_card_count_map");
        if (map == null) {
            hashMap2 = new HashMap();
        } else {
            hashMap2 = map;
        }
        map = (Map) am.axn().getValue("key_share_card_username_map");
        if (map == null) {
            hashMap3 = new HashMap();
        } else {
            hashMap3 = map;
        }
        ArrayList arrayList4 = (ArrayList) am.axn().getValue("key_share_card_local_city_ids");
        if (arrayList4 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList4;
        }
        arrayList4 = (ArrayList) am.axn().getValue("key_share_card_other_city_ids");
        if (arrayList4 == null) {
            arrayList2 = new ArrayList();
        } else {
            arrayList2 = arrayList4;
        }
        arrayList4 = (ArrayList) am.axn().getValue("key_share_card_other_city_top_info_list");
        if (arrayList4 == null) {
            arrayList3 = new ArrayList();
        } else {
            arrayList3 = arrayList4;
        }
        if (z) {
            arrayList.clear();
            arrayList2.clear();
            arrayList3.clear();
        }
        ArrayList arrayList5 = new ArrayList();
        if (lVar.hyt != null && lVar.hyt.size() > 0) {
            for (int i2 = 0; i2 < lVar.hyt.size(); i2++) {
                mVar = (m) lVar.hyt.get(i2);
                if (!TextUtils.isEmpty(mVar.hyB)) {
                    hashMap.put(mVar.huU, mVar.hyB);
                }
                hashMap2.put(mVar.huU, Integer.valueOf(am.axq().xz(mVar.huU)));
                hashMap3.put(mVar.huU, l(am.axq().xy(mVar.huU)));
                if (!arrayList5.contains(mVar.huU)) {
                    CharSequence xA = am.axq().xA(mVar.huU);
                    if (!TextUtils.isEmpty(xA) && !arrayList.contains(xA)) {
                        arrayList.add(xA);
                    } else if (!arrayList.contains(mVar.cac)) {
                        arrayList.add(mVar.cac);
                    }
                    arrayList5.add(mVar.huU);
                    p pVar = new p();
                    pVar.huU = mVar.huU;
                    pVar.top = mVar.top;
                    arrayList3.add(pVar);
                }
            }
        }
        arrayList5.clear();
        if (lVar.hyu != null && lVar.hyu.size() > 0) {
            while (i < lVar.hyu.size()) {
                mVar = (m) lVar.hyu.get(i);
                if (!TextUtils.isEmpty(mVar.hyB)) {
                    hashMap.put(mVar.huU, mVar.hyB);
                }
                hashMap2.put(mVar.huU, Integer.valueOf(am.axq().xz(mVar.huU)));
                hashMap3.put(mVar.huU, l(am.axq().xy(mVar.huU)));
                if (!arrayList5.contains(mVar.huU)) {
                    CharSequence xA2 = am.axq().xA(mVar.huU);
                    if (!TextUtils.isEmpty(xA2) && !arrayList2.contains(xA2)) {
                        arrayList2.add(xA2);
                    } else if (!arrayList2.contains(mVar.cac)) {
                        arrayList2.add(mVar.cac);
                    }
                    arrayList5.add(mVar.huU);
                    p pVar2 = new p();
                    pVar2.huU = mVar.huU;
                    pVar2.top = mVar.top;
                    arrayList3.add(pVar2);
                }
                i++;
            }
        }
        am.axn().putValue("key_share_card_annoucement_map", hashMap);
        am.axn().putValue("key_share_card_count_map", hashMap2);
        am.axn().putValue("key_share_card_username_map", hashMap3);
        am.axn().putValue("key_share_card_local_city", lVar.hyv);
        am.axn().putValue("key_share_card_local_city_ids", arrayList);
        am.axn().putValue("key_share_card_other_city_ids", arrayList2);
        am.axn().putValue("key_share_card_other_city_top_info_list", arrayList3);
    }

    private static void a(l lVar, l lVar2, boolean z) {
        if (lVar == null && lVar2 == null) {
            x.e("MicroMsg.ShareCardDataMgr", "don't updateCategoryType(), newData == null && oldData == null");
        } else if (lVar != null && lVar.hyu == null && lVar.hyt == null && lVar2 != null && lVar2.hyu == null && lVar2.hyt == null) {
            x.e("MicroMsg.ShareCardDataMgr", "don't updateCategoryType(), newData.local_city_list == null && oldData.local_city_list == null");
        } else {
            ArrayList arrayList;
            ArrayList arrayList2;
            int i;
            int i2;
            m mVar;
            x.i("MicroMsg.ShareCardDataMgr", "updateCategoryType()");
            ArrayList arrayList3 = (ArrayList) am.axn().getValue("key_share_card_local_city_category_info_list");
            if (arrayList3 == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = arrayList3;
            }
            arrayList3 = (ArrayList) am.axn().getValue("key_share_card_other_city_category_info_list");
            if (arrayList3 == null) {
                arrayList2 = new ArrayList();
            } else {
                arrayList2 = arrayList3;
            }
            int i3 = 0;
            if (z) {
                am.axq().nN(10);
                arrayList.clear();
                am.axq().nN(0);
                arrayList2.clear();
                i = 0;
            } else {
                if (!(lVar2 == null || lVar2.hyt == null || lVar2.hyt.size() < 0)) {
                    i3 = lVar2.hyt.size();
                }
                if (lVar2 == null || lVar2.hyu == null || lVar2.hyu.size() < 0) {
                    i = 0;
                } else {
                    i = lVar2.hyu.size();
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            long dO = g.Ei().dqq.dO(Thread.currentThread().getId());
            if (lVar != null && lVar.hyt != null && lVar.hyt.size() > 0) {
                i2 = 0;
                while (true) {
                    int i4 = i2;
                    if (i4 >= lVar.hyt.size()) {
                        break;
                    }
                    mVar = (m) lVar.hyt.get(i4);
                    am.axq().I(mVar.huU, 10, i4 + i3);
                    i iVar = new i();
                    iVar.huU = mVar.huU;
                    iVar.hyo = i4 + i3;
                    arrayList.add(iVar);
                    i2 = i4 + 1;
                }
                if (!(z || lVar2 == null || lVar2.hyt == null)) {
                    lVar.hyt.addAll(lVar2.hyt);
                }
            } else if (!(lVar == null || z || lVar2 == null || lVar2.hyt == null)) {
                lVar.hyt = lVar2.hyt;
            }
            am.axn().putValue("key_share_card_local_city_category_info_list", arrayList);
            if (lVar != null && lVar.hyu != null && lVar.hyu.size() > 0) {
                i2 = 0;
                while (true) {
                    int i5 = i2;
                    if (i5 >= lVar.hyu.size()) {
                        break;
                    }
                    mVar = (m) lVar.hyu.get(i5);
                    am.axq().I(mVar.huU, 0, i5 + i);
                    i iVar2 = new i();
                    iVar2.huU = mVar.huU;
                    iVar2.hyo = i5 + i;
                    arrayList2.add(iVar2);
                    i2 = i5 + 1;
                }
                if (!(z || lVar2 == null || lVar2.hyu == null)) {
                    lVar.hyu.addAll(lVar2.hyu);
                }
            } else if (!(lVar == null || z || lVar2 == null || lVar2.hyu == null)) {
                lVar.hyu = lVar2.hyu;
            }
            am.axn().putValue("key_share_card_other_city_category_info_list", arrayList2);
            g.Ei().dqq.gp(dO);
            x.d("MicroMsg.ShareCardDataMgr", "updateCategoryType  >> updateCategoryInfo use time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
    }

    public static void axF() {
        ArrayList arrayList;
        ArrayList arrayList2;
        i iVar;
        long currentTimeMillis = System.currentTimeMillis();
        long dO = g.Ei().dqq.dO(Thread.currentThread().getId());
        x.i("MicroMsg.ShareCardDataMgr", "updateShareCardCategory()");
        ArrayList arrayList3 = (ArrayList) am.axn().getValue("key_share_card_local_city_category_info_list");
        if (arrayList3 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList3;
        }
        arrayList3 = (ArrayList) am.axn().getValue("key_share_card_other_city_category_info_list");
        if (arrayList3 == null) {
            arrayList2 = new ArrayList();
        } else {
            arrayList2 = arrayList3;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            iVar = (i) arrayList.get(i);
            am.axq().I(iVar.huU, 10, iVar.hyo);
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            iVar = (i) arrayList2.get(i2);
            am.axq().I(iVar.huU, 0, iVar.hyo);
        }
        g.Ei().dqq.gp(dO);
        x.i("MicroMsg.ShareCardDataMgr", "updateShareCardCategory  >> updateCategoryInfo use time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    private String l(ArrayList<String> arrayList) {
        return a(this.mContext, (ArrayList) arrayList);
    }

    private static String a(Context context, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            x.e("MicroMsg.ShareCardDataMgr", "getShareUserName， username_list == null || username_list.size() == 0");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < arrayList.size() && i < 2) {
            if (i != 0) {
                stringBuilder.append("、");
            }
            Object gU = r.gU((String) arrayList.get(i));
            String gT = r.gT((String) arrayList.get(i));
            if (TextUtils.isEmpty(gU)) {
                stringBuilder.append(gT);
            } else {
                stringBuilder.append(gU);
            }
            i++;
        }
        if (context == null) {
            x.e("MicroMsg.ShareCardDataMgr", "context == null");
            return "";
        } else if (arrayList.size() == 1 || arrayList.size() == 2) {
            return context.getString(a$g.card_share_card_users, new Object[]{stringBuilder.toString()});
        } else {
            return context.getString(a$g.card_share_card_list_more_users, new Object[]{stringBuilder.toString(), Integer.valueOf(arrayList.size())});
        }
    }

    public static void xs(String str) {
        x.i("MicroMsg.ShareCardDataMgr", "updateShareUserInfo()");
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.ShareCardDataMgr", "updateShareUserInfo(), card_tp_id is empty");
        } else {
            e.post(new 1(str, new ag(Looper.getMainLooper())), "updateShareUserInfo_thread");
        }
    }

    public static ArrayList<String> nJ(int i) {
        ArrayList<String> arrayList;
        if (i == 1) {
            arrayList = (ArrayList) am.axn().getValue("key_share_card_local_city_ids");
            if (arrayList != null && arrayList.size() != 0) {
                return arrayList;
            }
            x.e("MicroMsg.ShareCardDataMgr", "getCardIds() ids == null || ids.size() == 0 for showType == " + i);
            return nK(i);
        } else if (i != 2) {
            return null;
        } else {
            arrayList = (ArrayList) am.axn().getValue("key_share_card_other_city_ids");
            if (arrayList != null && arrayList.size() != 0) {
                return arrayList;
            }
            x.e("MicroMsg.ShareCardDataMgr", "getCardIds() ids == null || ids.size() == 0 for showType == " + i);
            return nK(i);
        }
    }

    private static ArrayList<String> nK(int i) {
        int i2 = 0;
        l lVar = (l) am.axn().getValue("key_share_card_layout_data");
        if (lVar == null) {
            x.e("MicroMsg.ShareCardDataMgr", "getCardIdsByType() data == null for showType = " + i);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i3;
        m mVar;
        CharSequence xA;
        if (i == 1) {
            if (lVar.hyt != null && lVar.hyt.size() > 0) {
                while (true) {
                    i3 = i2;
                    if (i3 >= lVar.hyt.size()) {
                        break;
                    }
                    mVar = (m) lVar.hyt.get(i3);
                    if (!arrayList2.contains(mVar.huU)) {
                        xA = am.axq().xA(mVar.huU);
                        if (!TextUtils.isEmpty(xA) && !arrayList.contains(xA)) {
                            arrayList.add(xA);
                        } else if (!arrayList.contains(mVar.cac)) {
                            arrayList.add(mVar.cac);
                        }
                        arrayList2.add(mVar.huU);
                    }
                    i2 = i3 + 1;
                }
                am.axn().putValue("key_share_card_local_city_ids", arrayList);
            }
            return arrayList;
        } else if (i != 2) {
            return null;
        } else {
            if (lVar.hyu != null && lVar.hyu.size() > 0) {
                while (true) {
                    i3 = i2;
                    if (i3 >= lVar.hyu.size()) {
                        break;
                    }
                    mVar = (m) lVar.hyu.get(i3);
                    if (!arrayList2.contains(mVar.huU)) {
                        xA = am.axq().xA(mVar.huU);
                        if (!TextUtils.isEmpty(xA) && !arrayList.contains(xA)) {
                            arrayList.add(xA);
                        } else if (!arrayList.contains(mVar.cac)) {
                            arrayList.add(mVar.cac);
                        }
                        arrayList2.add(mVar.huU);
                    }
                    i2 = i3 + 1;
                }
                am.axn().putValue("key_share_card_other_city_ids", arrayList);
            }
            return arrayList;
        }
    }

    public static void cb(String str, String str2) {
        if (dFt) {
            x.i("MicroMsg.ShareCardDataMgr", "is isUpdating data, don't do updateCardIdsListByCardId");
            return;
        }
        CharSequence ce;
        x.i("MicroMsg.ShareCardDataMgr", "do updateCardIdsListByCardId");
        dFt = true;
        ArrayList nJ = nJ(1);
        if (nJ != null && nJ.contains(str)) {
            nJ.remove(str);
            ce = am.axq().ce(str, str2);
            if (!TextUtils.isEmpty(ce)) {
                nJ.add(ce);
            }
            am.axn().putValue("key_share_card_local_city_ids", nJ);
        }
        nJ = nJ(2);
        if (nJ != null && nJ.contains(str)) {
            nJ.remove(str);
            ce = am.axq().ce(str, str2);
            if (!TextUtils.isEmpty(ce)) {
                nJ.add(ce);
            }
            am.axn().putValue("key_share_card_other_city_ids", nJ);
        }
        dFt = false;
    }

    public static void cc(String str, String str2) {
        x.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId card_id:" + str + ", card_tp_id:" + str2);
        ArrayList nJ = nJ(1);
        if (nJ == null || !nJ.contains(str)) {
            ArrayList nJ2 = nJ(2);
            if (nJ2 == null || !nJ2.contains(str)) {
                l lVar = (l) am.axn().getValue("key_share_card_layout_data");
                if (lVar == null) {
                    x.e("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId data == null");
                    return;
                }
                int xz = am.axq().xz(str2);
                int xu = xu(str2);
                x.e("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId realCount:" + xz + " cacheCount:" + xu);
                if (lVar.hyt != null && lVar.hyt.size() > 0 && (xu <= 0 || xz == 1)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= lVar.hyt.size()) {
                            break;
                        }
                        m mVar = (m) lVar.hyt.get(i2);
                        if (str2 == null || !str2.contains(mVar.huU)) {
                            i = i2 + 1;
                        } else {
                            nJ.add(str);
                            am.axn().putValue("key_share_card_local_city_ids", nJ);
                            x.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId add for local ids, card id is " + str);
                            return;
                        }
                    }
                }
                x.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId, not add for local_ids");
                if (nJ2 == null || (xu > 0 && xz != 1)) {
                    x.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId, not add for other_ids");
                    return;
                }
                nJ2.add(str);
                am.axn().putValue("key_share_card_other_city_ids", nJ2);
                x.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId add for other ids, card id is " + str);
            }
        }
    }

    public static int axG() {
        if (axI()) {
            return 1;
        }
        if (!axH()) {
            return 0;
        }
        if (hyf) {
            return 3;
        }
        return 4;
    }

    public static boolean axH() {
        ArrayList arrayList = (ArrayList) am.axn().getValue("key_share_card_other_city_ids");
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return true;
    }

    public static boolean axI() {
        ArrayList arrayList = (ArrayList) am.axn().getValue("key_share_card_local_city_ids");
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return true;
    }

    public static String xt(String str) {
        Map map = (Map) am.axn().getValue("key_share_card_annoucement_map");
        if (map == null) {
            return "";
        }
        return (String) map.get(str);
    }

    public static int xu(String str) {
        Map map = (Map) am.axn().getValue("key_share_card_count_map");
        if (map == null) {
            return 0;
        }
        Integer num = (Integer) map.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static String ld(String str) {
        Map map = (Map) am.axn().getValue("key_share_card_username_map");
        if (map == null) {
            return "";
        }
        return (String) map.get(str);
    }

    public static ArrayList<com.tencent.mm.plugin.card.sharecard.model.r> xv(String str) {
        Map map = (Map) am.axn().getValue("key_share_user_info_map");
        if (map == null) {
            map = new HashMap();
        }
        ArrayList<com.tencent.mm.plugin.card.sharecard.model.r> arrayList = (ArrayList) map.get(str);
        if (arrayList == null) {
            return new ArrayList();
        }
        return arrayList;
    }

    private static void I(String str, String str2, String str3) {
        Map hashMap;
        ArrayList arrayList;
        Map map = (Map) am.axn().getValue("key_share_user_info_map");
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = map;
        }
        ArrayList arrayList2 = (ArrayList) hashMap.get(str2);
        if (arrayList2 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList2;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.tencent.mm.plugin.card.sharecard.model.r rVar = (com.tencent.mm.plugin.card.sharecard.model.r) arrayList.get(i);
            if (str3 != null && str3.equals(rVar.hyG)) {
                rVar.hyI = false;
                rVar.share_count--;
                rVar.hyH.remove(str);
                arrayList.set(i, rVar);
            }
        }
        hashMap.put(str2, arrayList);
        am.axn().putValue("key_share_user_info_map", hashMap);
    }

    public static void axJ() {
        x.i("MicroMsg.ShareCardDataMgr", "delelteAllIllegalStatusCard()");
        e.post(new 2(), "delelteAllIllegalStatusCard");
    }

    public static void aa(Context context, String str) {
        Map hashMap;
        x.i("MicroMsg.ShareCardDataMgr", "updateCardCountbyCardTpId() card_tp_id:" + str);
        Map map = (Map) am.axn().getValue("key_share_card_count_map");
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = map;
        }
        map = (Map) am.axn().getValue("key_share_card_username_map");
        if (map == null) {
            map = new HashMap();
        }
        hashMap.put(str, Integer.valueOf(am.axq().xz(str)));
        map.put(str, a(context, am.axq().xy(str)));
        am.axn().putValue("key_share_card_count_map", hashMap);
        am.axn().putValue("key_share_card_username_map", map);
    }

    public static boolean nL(int i) {
        Integer num = (Integer) am.axn().getValue("key_share_card_show_type");
        if (num == null) {
            return false;
        }
        if (num.intValue() == 0) {
            return false;
        }
        ArrayList arrayList;
        if (i == 0) {
            arrayList = (ArrayList) am.axn().getValue("key_share_card_other_city_ids");
            if (arrayList == null || arrayList.size() == 0) {
                return false;
            }
            return true;
        } else if (i != 10) {
            return false;
        } else {
            arrayList = (ArrayList) am.axn().getValue("key_share_card_local_city_ids");
            if (arrayList == null || arrayList.size() == 0) {
                return false;
            }
            return true;
        }
    }

    public static boolean xw(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ArrayList arrayList = (ArrayList) am.axn().getValue("key_share_card_other_city_top_info_list");
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            if (pVar != null && str.equals(pVar.huU) && pVar.top == 1) {
                return true;
            }
        }
        return false;
    }

    public static void xx(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList;
            ArrayList arrayList2 = (ArrayList) am.axn().getValue("key_share_card_other_city_top_info_list");
            if (arrayList2 == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = arrayList2;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    p pVar = (p) arrayList.get(i2);
                    if (pVar != null && str.equals(pVar.huU) && pVar.top == 1) {
                        pVar.hyF = true;
                        arrayList.set(i2, pVar);
                        am.axn().putValue("key_share_card_other_city_top_info_list", arrayList);
                        return;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public static String cd(String str, String str2) {
        x.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId()");
        if (str2 != null) {
            ArrayList xv = xv(str2);
            if (xv == null || xv.size() <= 0) {
                x.e("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), shareUserInfoList is null");
                return str;
            }
            com.tencent.mm.plugin.card.sharecard.model.r rVar = (com.tencent.mm.plugin.card.sharecard.model.r) xv.get(0);
            if (rVar == null || rVar.hyH == null || rVar.hyH.size() <= 0 || str.equals(rVar.hyH.get(0))) {
                x.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), mCardId is first!");
                return str;
            }
            String str3 = (String) rVar.hyH.get(0);
            x.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), mCardId is not first!, reset it");
            return str3;
        }
        x.e("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), card_tp_id is null");
        return str;
    }

    public static boolean axK() {
        l lVar = (l) am.axn().getValue("key_share_card_layout_data");
        if (lVar == null) {
            return true;
        }
        return lVar.hyw;
    }

    public static boolean axL() {
        l lVar = (l) am.axn().getValue("key_share_card_layout_data");
        if (lVar == null) {
            return true;
        }
        return lVar.hyx;
    }

    public static void a(Context context, com.tencent.mm.plugin.card.base.b bVar) {
        x.i("MicroMsg.ShareCardDataMgr", "updateShareCardData()");
        x.i("MicroMsg.ShareCardDataMgr", "card id:" + bVar.awq() + " cardtpid:" + bVar.awr());
        cb(bVar.awq(), bVar.awr());
        if (context != null) {
            aa(context, bVar.awr());
        }
        I(bVar.awq(), bVar.awr(), bVar.aws());
        xs(bVar.awr());
    }
}
