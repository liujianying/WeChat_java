package com.tencent.mm.ap;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public abstract class a {
    public static String ebD = "";
    public static String ebE = "";
    public String TEXT;
    public String TYPE;
    public bd bXQ;
    public String ebF = "";
    public String ebG;
    public LinkedList<String> ebH = new LinkedList();
    public LinkedList<Integer> ebI = new LinkedList();
    public LinkedList<Integer> ebJ = new LinkedList();
    public Map<String, String> values;

    public static abstract class a {
        private static HashMap<String, a> ebK = new HashMap();

        public abstract a a(Map<String, String> map, bd bdVar);

        public static void a(String str, a aVar) {
            Assert.assertNotNull(str);
            Assert.assertNotNull(aVar);
            synchronized (ebK) {
                ebK.put(str.toLowerCase(), aVar);
            }
        }

        public static a b(Map<String, String> map, bd bdVar) {
            if (map == null) {
                x.e("MicroMsg.BaseNewXmlMsg", "values is null !!!");
                return null;
            }
            String str = (String) map.get(".sysmsg.$type");
            synchronized (ebK) {
                a aVar = (a) ebK.get(str.toLowerCase());
                if (aVar == null) {
                    x.w("MicroMsg.BaseNewXmlMsg", "TYPE %s is unDefine", str);
                    return null;
                }
                a a = aVar.a((Map) map, bdVar);
                return a;
            }
        }
    }

    public interface b {
        void a(View view, bd bdVar, a aVar, int i);
    }

    public abstract boolean Qi();

    public a(Map<String, String> map, bd bdVar) {
        this.values = map;
        this.bXQ = bdVar;
    }
}
