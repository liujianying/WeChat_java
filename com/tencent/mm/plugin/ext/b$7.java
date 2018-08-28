package com.tencent.mm.plugin.ext;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Looper;
import android.os.Message;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.mm.compatible.a.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.i;
import com.tencent.mm.pluginsdk.model.i$a;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

class b$7 extends ag {
    final /* synthetic */ b iJo;

    b$7(b bVar, Looper looper) {
        this.iJo = bVar;
        super(looper);
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140514", reviewer = 20, vComment = {EType.INTENTCHECK})
    public final void handleMessage(Message message) {
        if (ad.getContext() == null || !au.HX()) {
            x.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong status");
            return;
        }
        Cursor cmR = b.aIL().cmR();
        if (cmR == null) {
            x.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler getValidOpenMsgListener cu == null");
            return;
        }
        x.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler listener count = %s", new Object[]{Integer.valueOf(cmR.getCount())});
        if (cmR.getCount() <= 0) {
            cmR.close();
            x.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler cu.getCount() <= 0");
            return;
        }
        try {
            if (cmR.moveToFirst()) {
                HashMap hashMap = new HashMap();
                synchronized (this.iJo) {
                    hashMap.putAll(b.a(this.iJo));
                    b.a(this.iJo).clear();
                }
                do {
                    LinkedList linkedList = new LinkedList();
                    ArrayList arrayList = new ArrayList();
                    if (hashMap.entrySet() == null) {
                        x.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler waitForNotify.entrySet() == null");
                        return;
                    }
                    bj bjVar = new bj();
                    bjVar.d(cmR);
                    if (bi.oW(bjVar.field_appId) || bi.oW(bjVar.field_packageName)) {
                        x.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong msgListener, appid = %s, package = %s", new Object[]{bjVar.field_appId, bjVar.field_packageName});
                    } else {
                        for (Entry entry : hashMap.entrySet()) {
                            String oV = bi.oV((String) entry.getKey());
                            Integer num = (Integer) entry.getValue();
                            au.HU();
                            ai Yq = c.FW().Yq(oV);
                            if (Yq != null && !bi.oW(Yq.field_username) && Yq.field_unReadCount <= 0) {
                                x.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler no unread in conversation");
                            } else if (!(s.hP(oV) || s.fq(oV) || s.hf(oV))) {
                                bu buVar;
                                bv aIM = b.aIM();
                                String str = bjVar.field_appId;
                                if (str == null || str.length() <= 0 || oV == null || oV.length() <= 0) {
                                    buVar = null;
                                } else {
                                    Cursor a = aIM.diF.a("UserOpenIdInApp", null, "appId=? and username=? ", new String[]{bi.oU(str), bi.oU(oV)}, null, null, null, 2);
                                    if (a.moveToFirst()) {
                                        buVar = new bu();
                                        buVar.d(a);
                                        a.close();
                                    } else {
                                        x.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with appId-%s, username-%s:", new Object[]{str, oV});
                                        a.close();
                                        buVar = null;
                                    }
                                }
                                if (buVar == null || bi.oW(buVar.field_openId) || bi.oW(buVar.field_username)) {
                                    x.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler openId is null, go get it.");
                                    Integer num2 = (Integer) b.a(this.iJo).get(oV);
                                    if (num2 == null) {
                                        b.a(this.iJo).put(oV, num);
                                    } else {
                                        b.a(this.iJo).put(oV, Integer.valueOf(num2.intValue() + num.intValue()));
                                    }
                                    linkedList.add(oV);
                                } else {
                                    x.v("MicroMsg.SubCoreExt", "username[%s], appId[%s], openId[%s]", new Object[]{buVar.field_username, buVar.field_appId, buVar.field_openId});
                                    arrayList.add(String.format("%s,%s,%s", new Object[]{buVar.field_openId, num, Long.valueOf(System.currentTimeMillis() - 1600)}));
                                }
                            }
                        }
                        if (linkedList.size() > 0) {
                            x.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler doGetGetUserInfoInApp");
                            b bVar = this.iJo;
                            String str2 = bjVar.field_appId;
                            if (!bi.oW(str2) && linkedList.size() > 0) {
                                i cbs = i.cbs();
                                Context context = ad.getContext();
                                i$a i_a = bVar.iJf;
                                x.d("MicroMsg.GetUserInfoInAppLogic", "getGetUserInfoInApp");
                                if (!i.qyP) {
                                    cbs.cbt();
                                }
                                if (au.HX() && context != null) {
                                    if (linkedList.size() == 0) {
                                        x.d("MicroMsg.GetUserInfoInAppLogic", "userNameList empty");
                                    } else {
                                        cbs.qyR = i_a;
                                        com.tencent.mm.pluginsdk.model.app.x lVar = new l(str2, linkedList);
                                        ao.bmi();
                                        d.a(14, lVar);
                                    }
                                }
                            }
                        }
                        if (arrayList.size() <= 0) {
                            cmR.close();
                            x.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler userDataList.size() <= 0");
                            return;
                        }
                        if ((bjVar.field_status == 1 ? 1 : null) == null) {
                            x.w("MicroMsg.SubCoreExt", "invalid msgListener, appid = %s, package = %s", new Object[]{bjVar.field_appId, bjVar.field_packageName});
                        } else if (!(bi.oW(bjVar.field_appId) || bi.oW(bjVar.field_packageName))) {
                            x.i("MicroMsg.SubCoreExt", "notify app, appId = %s, package = %s", new Object[]{bjVar.field_appId, bjVar.field_packageName});
                            Intent intent = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_NOTIFY_MSG");
                            intent.addCategory("com.tencent.mm.category." + bjVar.field_packageName);
                            a.a(12, new 1(this, intent));
                            intent.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "NEW_MESSAGE");
                            intent.putStringArrayListExtra("EXTRA_EXT_OPEN_USER_DATA", arrayList);
                            ad.getContext().sendBroadcast(intent);
                        }
                    }
                } while (cmR.moveToNext());
            }
            cmR.close();
        } catch (Exception e) {
            x.e("MicroMsg.SubCoreExt", "Exception in handleMessage, %s", new Object[]{e.getMessage()});
            if (cmR != null) {
                cmR.close();
            }
        }
    }
}
