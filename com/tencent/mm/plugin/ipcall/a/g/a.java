package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class a {
    private static String TAG = "MicroMsg.IPCallActivityMsgInfo";
    public String bHD = "";
    public int hcE = 0;
    public String jOS = "";
    public String ksv = "";
    public String ksw = "";

    public static a EN(String str) {
        x.d(TAG, "getIPCallActivityMsgInfoFromXML:" + str);
        a aVar = new a();
        int indexOf = str.indexOf("<ActivityInfo");
        if (indexOf == -1) {
            x.e(TAG, "msgContent not start with <ActivityInfo");
            return aVar;
        }
        Map z = bl.z(str.substring(indexOf), "ActivityInfo");
        if (z == null) {
            x.e(TAG, "XmlParser values is null, xml %s", new Object[]{str});
            return null;
        }
        if (z.containsKey(".ActivityInfo.Title")) {
            aVar.bHD = (String) z.get(".ActivityInfo.Title");
        }
        if (z.containsKey(".ActivityInfo.Desc")) {
            aVar.jOS = (String) z.get(".ActivityInfo.Desc");
        }
        if (z.containsKey(".ActivityInfo.ImgUrl")) {
            aVar.ksv = (String) z.get(".ActivityInfo.ImgUrl");
        }
        if (z.containsKey(".ActivityInfo.StartBtnText")) {
            aVar.ksw = (String) z.get(".ActivityInfo.StartBtnText");
        }
        if (z.containsKey(".ActivityInfo.ActivityType")) {
            aVar.hcE = bi.getInt((String) z.get(".ActivityInfo.ActivityType"), 0);
        }
        x.d(TAG, "msgInfo:", new Object[]{aVar.toString()});
        return aVar;
    }
}
