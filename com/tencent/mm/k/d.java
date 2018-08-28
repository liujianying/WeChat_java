package com.tencent.mm.k;

import android.view.ContextMenu.ContextMenuInfo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d {
    public static final int[] dgR = new int[]{1};
    HashMap<String, HashMap<String, String>> dgS = new HashMap();
    public Map<String, String> dgT = null;
    private int id;
    int version;

    public static class a {
        public String id;
        public String title;
        public String url;

        public a(String str, String str2, String str3) {
            this.id = str;
            this.title = str2;
            this.url = str3;
        }
    }

    public static class b implements ContextMenuInfo {
        private static int dgU = 10000;
        public final String aAL;
        public final int id;
        public final String title;

        public b(String str, String str2) {
            int i = dgU;
            dgU = i + 1;
            this.id = i;
            this.aAL = str;
            this.title = str2;
        }
    }

    public d(int i) {
        this.id = i;
    }

    static boolean fk(String str) {
        try {
            if (bi.oW(str)) {
                return false;
            }
            List<String> arrayList = new ArrayList();
            if (!bi.oW(str)) {
                String[] split = str.split(",");
                if (split != null && split.length > 0) {
                    for (int i = 0; i < split.length; i++) {
                        if (!bi.oW(split[i])) {
                            arrayList.add(split[i]);
                        }
                    }
                }
            }
            String chP = w.chP();
            if (bi.oW(chP)) {
                return false;
            }
            x.d("MicroMsg.ConfigListInfo", "locale is " + chP);
            for (String str2 : arrayList) {
                if (str2.trim().toLowerCase().equals("other") && !chP.equals("zh_CN")) {
                    x.d("MicroMsg.ConfigListInfo", "find other");
                    return true;
                } else if (str2.trim().toLowerCase().equals(chP.trim().toLowerCase())) {
                    x.d("MicroMsg.ConfigListInfo", "find ");
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            x.e("MicroMsg.ConfigListInfo", "exception:%s", bi.i(e));
            x.d("MicroMsg.ConfigListInfo", "isContainLocale failed " + e.getMessage());
        }
    }

    private static LinkedList<a> d(Map<String, String> map, String str) {
        LinkedList<a> linkedList = null;
        int i = 0;
        while (true) {
            String str2 = str + (i == 0 ? "" : Integer.valueOf(i));
            if (map.get(str2) == null) {
                break;
            }
            String str3 = str2 + ".id";
            String str4 = str2 + ".title";
            String str5 = str2 + ".url";
            if (!map.containsKey(str3)) {
                break;
            }
            LinkedList<a> linkedList2;
            a aVar = new a((String) map.get(str3), (String) map.get(str4), (String) map.get(str5));
            if (linkedList == null) {
                linkedList2 = new LinkedList();
            } else {
                linkedList2 = linkedList;
            }
            linkedList2.add(aVar);
            i++;
            linkedList = linkedList2;
        }
        return linkedList;
    }

    public static LinkedList<a> j(Map<String, String> map) {
        LinkedList<a> linkedList = null;
        int i = 0;
        while (true) {
            String str = ".ConfigList.Config" + (i == 0 ? "" : Integer.valueOf(i));
            if (map.get(str + ".$name") == null) {
                break;
            }
            LinkedList<a> d;
            if (((String) map.get(str + ".$name")).equalsIgnoreCase("JDWebViewMenu")) {
                d = d(map, str + ".menuItems.menuItem");
                linkedList = d(map, str + ".menuItems.newMenuItem");
                if (d == null) {
                    break;
                } else if (linkedList != null && linkedList.size() > 0) {
                    x.d("MicroMsg.ConfigListInfo", "has menuItem2, %s, %s", Integer.valueOf(d.size()), Integer.valueOf(linkedList.size()));
                    d.addAll(linkedList);
                }
            } else {
                d = linkedList;
            }
            i++;
            linkedList = d;
        }
        return linkedList;
    }
}
