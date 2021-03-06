package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class am extends a {
    public static final int CTRL_BYTE = 40;
    public static final String NAME = "queryDownloadTask";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        int i2 = 0;
        JSONArray optJSONArray = jSONObject.optJSONArray("appIdArray");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            QueryDownloadInfoTask queryDownloadInfoTask = new QueryDownloadInfoTask();
            long optLong = jSONObject.optLong("download_id", -1);
            String optString = jSONObject.optString("appid");
            if (optLong > 0) {
                queryDownloadInfoTask.type = 1;
                queryDownloadInfoTask.bGm = optLong;
                GameWebViewMainProcessService.b(queryDownloadInfoTask);
                if (queryDownloadInfoTask.ixN == null || queryDownloadInfoTask.ixN.size() == 0) {
                    a(dVar, new FileDownloadTaskInfo(), i);
                    return;
                } else {
                    a(dVar, (FileDownloadTaskInfo) queryDownloadInfoTask.ixN.get(0), i);
                    return;
                }
            } else if (bi.oW(optString)) {
                x.e("MicroMsg.GameJsApiQueryDownloadTask", "invalid params");
                dVar.E(i, a.f("query_download_task:fail_invalid_params", null));
                return;
            } else {
                queryDownloadInfoTask.type = 2;
                queryDownloadInfoTask.jHC = new ArrayList();
                queryDownloadInfoTask.jHC.add(optString);
                GameWebViewMainProcessService.b(queryDownloadInfoTask);
                if (queryDownloadInfoTask.ixN == null || queryDownloadInfoTask.ixN.size() == 0) {
                    a(dVar, new FileDownloadTaskInfo(), i);
                    return;
                } else {
                    a(dVar, (FileDownloadTaskInfo) queryDownloadInfoTask.ixN.get(0), i);
                    return;
                }
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        ArrayList arrayList = new ArrayList();
        while (i2 < optJSONArray.length()) {
            arrayList.add(optJSONArray.optString(i2));
            i2++;
        }
        QueryDownloadInfoTask queryDownloadInfoTask2 = new QueryDownloadInfoTask();
        queryDownloadInfoTask2.type = 2;
        queryDownloadInfoTask2.jHC = arrayList;
        GameWebViewMainProcessService.b(queryDownloadInfoTask2);
        ArrayList arrayList2 = queryDownloadInfoTask2.ixN;
        Map hashMap;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            x.e("MicroMsg.GameJsApiQueryDownloadTask", "taskInfos is null");
            a(jSONObject2, arrayList);
            hashMap = new HashMap();
            hashMap.put("result", jSONObject2.toString());
            dVar.E(i, a.f("query_download_task:ok", hashMap));
            return;
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            String str;
            FileDownloadTaskInfo fileDownloadTaskInfo = (FileDownloadTaskInfo) it.next();
            JSONObject jSONObject3 = new JSONObject();
            switch (fileDownloadTaskInfo.status) {
                case -1:
                    str = "api_not_support";
                    break;
                case 1:
                    str = "downloading";
                    break;
                case 2:
                    str = "download_pause";
                    break;
                case 3:
                    if (!e.cn(fileDownloadTaskInfo.path)) {
                        str = "default";
                        break;
                    } else {
                        str = "download_succ";
                        break;
                    }
                case 4:
                    str = "download_fail";
                    break;
                default:
                    str = "default";
                    break;
            }
            try {
                jSONObject3.put("download_id", fileDownloadTaskInfo.id);
                jSONObject3.put(OpenSDKTool4Assistant.EXTRA_STATE, str);
                if (str == "downloading" && fileDownloadTaskInfo.gTK != 0) {
                    jSONObject3.put("progress", (fileDownloadTaskInfo.icq / fileDownloadTaskInfo.gTK) * 100);
                }
                jSONObject2.put(fileDownloadTaskInfo.appId, jSONObject3);
                arrayList.remove(fileDownloadTaskInfo.appId);
            } catch (Exception e) {
                x.e("MicroMsg.GameJsApiQueryDownloadTask", e.getMessage());
            }
        }
        a(jSONObject2, arrayList);
        hashMap = new HashMap();
        hashMap.put("result", jSONObject2.toString());
        dVar.E(i, a.f("query_download_task:ok", hashMap));
    }

    private static void a(d dVar, FileDownloadTaskInfo fileDownloadTaskInfo, int i) {
        String str;
        Map hashMap = new HashMap();
        switch (fileDownloadTaskInfo.status) {
            case -1:
                str = "api_not_support";
                break;
            case 1:
                str = "downloading";
                break;
            case 2:
                str = "download_pause";
                break;
            case 3:
                if (!e.cn(fileDownloadTaskInfo.path)) {
                    str = "default";
                    break;
                } else {
                    str = "download_succ";
                    break;
                }
            case 4:
                str = "download_fail";
                break;
            default:
                str = "default";
                break;
        }
        try {
            hashMap.put("download_id", Long.valueOf(fileDownloadTaskInfo.id));
            hashMap.put(OpenSDKTool4Assistant.EXTRA_STATE, str);
            if (str == "downloading" && fileDownloadTaskInfo.gTK != 0) {
                hashMap.put("progress", Long.valueOf((fileDownloadTaskInfo.icq / fileDownloadTaskInfo.gTK) * 100));
            }
            dVar.E(i, a.f("query_download_task:ok", hashMap));
        } catch (Exception e) {
            x.e("MicroMsg.GameJsApiQueryDownloadTask", e.getMessage());
        }
    }

    private static void a(JSONObject jSONObject, ArrayList<String> arrayList) {
        if (!bi.cX(arrayList)) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("download_id", -1);
                    jSONObject2.put(OpenSDKTool4Assistant.EXTRA_STATE, "default");
                    jSONObject.put(str, jSONObject2);
                } catch (Exception e) {
                    x.e("MicroMsg.GameJsApiQueryDownloadTask", e.getMessage());
                }
            }
        }
    }
}
