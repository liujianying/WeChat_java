package com.tencent.mm.plugin.webview.model;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONStringer;

public final class aj {
    public static String Qr(String str) {
        File file = new File(e.dgl);
        if (!file.mkdirs()) {
            x.i("MicroMsg.WebviewJSSDKUtil", "mkdirs failed.File is exist = " + file.exists());
        }
        if (!file.exists()) {
            x.e("MicroMsg.WebviewJSSDKUtil", "camera storage path do not exist.(%s)", new Object[]{e.dgl});
        }
        x.i("MicroMsg.WebviewJSSDKUtil", "get file path from capture file name : %s == %s", new Object[]{str, file.getAbsolutePath() + File.separator + str + ".jpg"});
        return file.getAbsolutePath() + File.separator + str + ".jpg";
    }

    public static Intent Qs(String str) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", Uri.fromFile(new File(Qr(str))));
        return intent;
    }

    public static Intent bUn() {
        return new Intent("android.media.action.VIDEO_CAPTURE");
    }

    public static Intent bUo() {
        return new Intent("android.provider.MediaStore.RECORD_SOUND");
    }

    public static String Qt(String str) {
        x.i("MicroMsg.WebviewJSSDKUtil", "genLocalIdByFilePath, file path is ：%s", new Object[]{str});
        if (bi.oW(str)) {
            return null;
        }
        x.i("MicroMsg.WebviewJSSDKUtil", "gen local id by filepath, filepath : %s, localid : %s", new Object[]{str, "weixin://resourceid/" + ac.ce(str)});
        return "weixin://resourceid/" + ac.ce(str);
    }

    public static String Qu(String str) {
        WebViewJSSDKFileItem Qq = com.tencent.mm.plugin.webview.modeltools.e.bUX().Qq(str);
        if (Qq != null) {
            x.i("MicroMsg.WebviewJSSDKUtil", "get local thumb filepath from local id :%s", new Object[]{Qq.fOs});
            return Qq.fOs;
        }
        x.e("MicroMsg.WebviewJSSDKUtil", "fromLocalIdToFilePath, local map not contains the local id : %s", new Object[]{str});
        return null;
    }

    public static String U(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            x.e("MicroMsg.WebviewJSSDKUtil", "data is null");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return jSONArray.toString();
            }
            jSONArray.put((String) arrayList.get(i2));
            i = i2 + 1;
        }
    }

    public static String V(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            x.e("MicroMsg.WebviewJSSDKUtil", "data is null");
            return "";
        }
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.array();
            jSONStringer.object();
            for (int i = 0; i < arrayList.size(); i++) {
                String str = (String) arrayList.get(i);
                jSONStringer.key("localId");
                jSONStringer.value(str);
            }
            jSONStringer.endObject();
            jSONStringer.endArray();
            return jSONStringer.toString();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", e, "", new Object[0]);
            return "";
        }
    }

    public static String c(String str, String str2, int i, int i2, int i3, int i4) {
        if (bi.oW(str)) {
            x.e("MicroMsg.WebviewJSSDKUtil", "parseVideoItemToJson localId is null");
            return "";
        }
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.array();
            jSONStringer.object();
            jSONStringer.key("localId");
            jSONStringer.value(str);
            jSONStringer.key("thumbLocalId");
            jSONStringer.value(str2);
            jSONStringer.key("duration");
            jSONStringer.value(String.valueOf(i));
            jSONStringer.key("height");
            jSONStringer.value(String.valueOf(i2));
            jSONStringer.key("width");
            jSONStringer.value(String.valueOf(i3));
            jSONStringer.key("size");
            jSONStringer.value(String.valueOf(i4));
            jSONStringer.endObject();
            jSONStringer.endArray();
            return jSONStringer.toString();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", e, "", new Object[0]);
            return "";
        }
    }

    private static InputStream Qv(String str) {
        x.i("MicroMsg.WebviewJSSDKUtil", "getDataFromLocalId : %s", new Object[]{str});
        if (bi.oW(str) || bi.oW(str) || !com.tencent.mm.a.e.cn(str)) {
            return null;
        }
        try {
            return new FileInputStream(str);
        } catch (Exception e) {
            x.e("MicroMsg.WebviewJSSDKUtil", "init file input stream error : %s", new Object[]{e.getMessage()});
            return null;
        }
    }

    public static InputStream Qw(String str) {
        if (!bi.oW(str)) {
            return Qv(str);
        }
        x.e("MicroMsg.WebviewJSSDKUtil", "local is is null or nil");
        return null;
    }

    public static String Qx(String str) {
        return "_USER_FOR_WEBVIEW_JSAPI" + o.l(str, bi.VF());
    }
}
