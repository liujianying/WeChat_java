package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

class WebViewUI$23$31 implements Runnable {
    final /* synthetic */ Bundle bAE;
    final /* synthetic */ int pUS;
    final /* synthetic */ 23 pZM;

    WebViewUI$23$31(23 23, int i, Bundle bundle) {
        this.pZM = 23;
        this.pUS = i;
        this.bAE = bundle;
    }

    public final void run() {
        if (this.pZM.pZJ.mhH != null) {
            x.i("MicroMsg.WebViewUI", "setMenuItemsVisible, actionCode = " + this.pUS);
            Set<Object> hashSet = new HashSet();
            if (this.pUS == 3003 || this.pUS == 3004) {
                hashSet.add("menuItem:share:brand");
                hashSet.add("menuItem:share:appMessage");
                hashSet.add("menuItem:share:dataMessage");
                hashSet.add("menuItem:share:timeline");
                hashSet.add("menuItem:favorite");
                hashSet.add("menuItem:profile");
                hashSet.add("menuItem:addContact");
                hashSet.add("menuItem:copyUrl");
                hashSet.add("menuItem:openWithSafari");
                hashSet.add("menuItem:share:email");
                hashSet.add("menuItem:delete");
                hashSet.add("menuItem:editTag");
                hashSet.add("menuItem:readMode");
                hashSet.add("menuItem:originPage");
                hashSet.add("menuItem:share:qq");
                hashSet.add("menuItem:share:weiboApp");
                hashSet.add("menuItem:share:QZone");
                hashSet.add("menuItem:share:Facebook");
                hashSet.add("menuItem:share:enterprise");
                hashSet.add("menuItem:share:wework");
                hashSet.add("menuItem:share:weread");
                hashSet.add("menuItem:addShortcut");
            } else if (this.bAE == null) {
                x.w("MicroMsg.WebViewUI", "setMenuItemsVisible data is null.");
                return;
            } else {
                Collection stringArrayList = this.bAE.getStringArrayList("menu_item_list");
                if (stringArrayList == null || stringArrayList.size() == 0) {
                    x.w("MicroMsg.WebViewUI", "setMenuItemsVisible menuItems is null or nil.");
                    return;
                }
                hashSet.addAll(stringArrayList);
                hashSet.remove("menuItem:exposeArticle");
                hashSet.remove("menuItem:setFont");
                hashSet.remove("menuItem:keepTop");
                hashSet.remove("menuItem:cancelKeepTop");
                hashSet.remove("menuItem:profile");
                hashSet.remove("menuItem:addContact");
                hashSet.remove("menuItem:refresh");
            }
            String url = this.pZM.pZJ.mhH.getUrl();
            SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) WebViewUI.f(this.pZM.pZJ).get(url);
            switch (this.pUS) {
                case 3001:
                case 3003:
                    SparseBooleanArray sparseBooleanArray2;
                    if (sparseBooleanArray == null) {
                        sparseBooleanArray = new SparseBooleanArray();
                        WebViewUI.f(this.pZM.pZJ).put(url, sparseBooleanArray);
                        sparseBooleanArray2 = sparseBooleanArray;
                    } else {
                        sparseBooleanArray2 = sparseBooleanArray;
                    }
                    for (Object obj : hashSet) {
                        int a = bi.a((Integer) WebViewUI.g(this.pZM.pZJ).get(obj), -1);
                        if (a >= 0) {
                            sparseBooleanArray2.put(a, true);
                        }
                    }
                    return;
                case 3002:
                case 3004:
                    if (sparseBooleanArray != null) {
                        for (Object obj2 : hashSet) {
                            int a2 = bi.a((Integer) WebViewUI.g(this.pZM.pZJ).get(obj2), -1);
                            if (a2 >= 0) {
                                sparseBooleanArray.delete(a2);
                            }
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
