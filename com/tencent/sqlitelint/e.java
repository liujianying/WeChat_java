package com.tencent.sqlitelint;

import android.content.Context;
import android.content.res.XmlResourceParser;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLite3ProfileHooker;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public class e {
    static final /* synthetic */ boolean $assertionsDisabled = (!e.class.desiredAssertionStatus());
    public static String bqz = null;
    private static int vni = 0;
    static com.tencent.sqlitelint.behaviour.b.a.a vnj;

    public static final class a {
        static final /* synthetic */ boolean $assertionsDisabled = (!e.class.desiredAssertionStatus());
        public final String vnk;
        final c vnl;

        public a(String str, c cVar) {
            if ($assertionsDisabled || str != null) {
                this.vnk = str;
                this.vnl = cVar;
                return;
            }
            throw new AssertionError();
        }
    }

    public static final class b {
        public static final b vnm = new a().cGg();
        int vnn;

        public static final class a {
            public int vno;

            public a() {
                this.vno |= 1;
            }

            public final b cGg() {
                b bVar = new b();
                bVar.vnn = this.vno;
                return bVar;
            }
        }
    }

    public enum c {
        ;

        static {
            vnp = 1;
            vnq = 2;
            vnr = new int[]{vnp, vnq};
        }
    }

    static {
        SQLiteLintNativeBridge.loadLibrary();
    }

    private e() {
    }

    public static void Hs(int i) {
        if (vni == 0) {
            vni = i;
            if (i == c.vnp) {
                SQLite3ProfileHooker.cGj();
            }
        }
    }

    public static int cGf() {
        return vni;
    }

    public static void a(Context context, a aVar, b bVar) {
        if (!$assertionsDisabled && aVar == null) {
            throw new AssertionError();
        } else if ($assertionsDisabled || vni != 0) {
            if (bVar == null) {
                bVar = b.vnm;
            }
            g gVar = g.vnt;
            String str = aVar.vnk;
            if (gVar.vnu.containsKey(str)) {
                SLog.w("SQLiteLint.SQLiteLintAndroidCoreManager", "install twice!! ignore", new Object[0]);
                return;
            }
            gVar.vnu.put(str, new f(context, aVar, bVar));
        } else {
            throw new AssertionError("SqlExecutionCallbackMode is UNKNOWN！setSqlExecutionCallbackMode must be called before install");
        }
    }

    public static void M(String str, String str2, int i) {
        if (g.vnt.acI(str) != null) {
            g.vnt.acI(str);
            SQLiteLintNativeBridge.nativeNotifySqlExecute(str, str2, (long) i, SQLiteLintUtil.getThrowableStack(new Throwable()));
        }
    }

    public static void acH(String str) {
        f acI = g.vnt.acI(str);
        if (vni == c.vnp) {
            SQLite3ProfileHooker.cGk();
        }
        SQLiteLintNativeBridge.nativeUninstall(acI.vnk);
        g.vnt.vnu.remove(str);
    }

    public static void dD(String str, int i) {
        String str2 = null;
        if (g.vnt.acI(str) != null) {
            f acI = g.vnt.acI(str);
            Context context = acI.mContext;
            String str3 = acI.vnk;
            try {
                XmlResourceParser xml = context.getResources().getXml(i);
                if (xml == null) {
                    SLog.w("SQLiteLint.CheckerWhiteListLogic", "buildWhiteListSet: parser null", new Object[0]);
                    return;
                }
                try {
                    int eventType = xml.getEventType();
                    Map hashMap = new HashMap();
                    int i2 = 0;
                    while (eventType != 1) {
                        switch (eventType) {
                            case 0:
                            case 3:
                                break;
                            case 2:
                                String name = xml.getName();
                                String attributeValue = "checker".equalsIgnoreCase(name) ? xml.getAttributeValue(null, "name") : str2;
                                if ("element".equalsIgnoreCase(name) && !SQLiteLintUtil.oW(attributeValue)) {
                                    name = xml.nextText();
                                    if (hashMap.get(attributeValue) == null) {
                                        List arrayList = new ArrayList();
                                        arrayList.add(name);
                                        hashMap.put(attributeValue, arrayList);
                                    } else {
                                        ((List) hashMap.get(attributeValue)).add(name);
                                    }
                                    SLog.v("SQLiteLint.CheckerWhiteListLogic", "buildWhiteListMap: add to whiteList[%s]: %s", attributeValue, name);
                                    str2 = attributeValue;
                                    break;
                                }
                                str2 = attributeValue;
                                break;
                            default:
                                SLog.w("SQLiteLint.CheckerWhiteListLogic", "buildWhiteListMap: default branch , eventType:%d", Integer.valueOf(eventType));
                                break;
                        }
                        xml.next();
                        eventType = xml.getEventType();
                        i2++;
                        if (i2 > 10000) {
                            SLog.e("SQLiteLint.CheckerWhiteListLogic", "buildWhiteListMap:maybe dead loop!!", new Object[0]);
                            a.u(str3, hashMap);
                            xml.close();
                        }
                    }
                    a.u(str3, hashMap);
                } catch (XmlPullParserException e) {
                    SLog.w("SQLiteLint.CheckerWhiteListLogic", "buildWhiteListSet: exp=%s", e.getLocalizedMessage());
                } catch (IOException e2) {
                    SLog.w("SQLiteLint.CheckerWhiteListLogic", "buildWhiteListSet: exp=%s", e2.getLocalizedMessage());
                }
                xml.close();
            } catch (Exception e3) {
                SLog.w("SQLiteLint.CheckerWhiteListLogic", "buildWhiteListSet: getResources exp=%s", e3.getLocalizedMessage());
            }
        }
    }

    public static void v(String str, List<String> list) {
        if (g.vnt.acI(str) != null && list != null && !list.isEmpty()) {
            f acI = g.vnt.acI(str);
            String[] strArr = new String[list.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    strArr[i2] = (String) list.get(i2);
                    i = i2 + 1;
                } else {
                    SQLiteLintNativeBridge.nativeEnableCheckers(acI.vnk, strArr);
                    return;
                }
            }
        }
    }

    static void a(com.tencent.sqlitelint.behaviour.b.a.a aVar) {
        vnj = aVar;
    }

    public static void ay(Context context) {
        if (bqz == null) {
            bqz = context.getPackageName();
        }
    }
}
