package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.plugin.notification.c.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class b$a {
    public b lHG = new b();
    public int lHH;
    public ArrayList<Long> lHI = new ArrayList();
    public ArrayList<Long> lHJ = new ArrayList();

    public b$a(b bVar, int i, ArrayList<Long> arrayList, ArrayList<Long> arrayList2) {
        this.lHG = bVar;
        this.lHH = i;
        this.lHI = arrayList;
        this.lHJ = arrayList2;
    }

    public final String bkx() {
        x.d("MicroMsg.FailMsgFileCache", "CacheObj, serializeToString");
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.lHG.lHE.size(); i++) {
                jSONArray.put(this.lHG.get(i));
            }
            x.d("MicroMsg.FailMsgFileCache", "serializeToString, msgArray.size:%d", new Object[]{Integer.valueOf(jSONArray.length())});
            jSONObject.put("msg_list", jSONArray);
            x.d("MicroMsg.FailMsgFileCache", "serializeToString, currentSendIndex:%d", new Object[]{Integer.valueOf(this.lHH)});
            jSONObject.put("current_send_index", this.lHH);
            jSONArray = new JSONArray();
            Iterator it = this.lHI.iterator();
            while (it.hasNext()) {
                jSONArray.put((Long) it.next());
            }
            x.d("MicroMsg.FailMsgFileCache", "serializeToString, successArray.size:%d", new Object[]{Integer.valueOf(jSONArray.length())});
            jSONObject.put("success_msg_list", jSONArray);
            jSONArray = new JSONArray();
            it = this.lHJ.iterator();
            while (it.hasNext()) {
                jSONArray.put((Long) it.next());
            }
            x.d("MicroMsg.FailMsgFileCache", "serializeToString, failArray.size:%d", new Object[]{Integer.valueOf(jSONArray.length())});
            jSONObject.put("fail_msg_list", jSONArray);
            return jSONObject.toString();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FailMsgFileCache", e, "", new Object[0]);
            return null;
        }
    }

    public final void IS(String str) {
        x.d("MicroMsg.FailMsgFileCache", "CacheObj, createFromFileContent");
        if (bi.oW(str)) {
            x.e("MicroMsg.FailMsgFileCache", "[createFromFileContent] content is null! stack:%s", new Object[]{bi.cjd()});
            return;
        }
        try {
            int i;
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("msg_list");
            JSONArray jSONArray2 = jSONObject.getJSONArray("fail_msg_list");
            JSONArray jSONArray3 = jSONObject.getJSONArray("success_msg_list");
            x.d("MicroMsg.FailMsgFileCache", "createFromFileContent, msgArray.size:%d, failArray.size:%d, successArray.size:%d, index:%d", new Object[]{Integer.valueOf(jSONArray.length()), Integer.valueOf(jSONArray2.length()), Integer.valueOf(jSONArray3.length()), Integer.valueOf(jSONObject.getInt("current_send_index"))});
            this.lHG.clear();
            this.lHJ.clear();
            this.lHI.clear();
            for (i = 0; i < jSONArray.length(); i++) {
                this.lHG.ej(jSONArray.getLong(i));
            }
            for (i = 0; i < jSONArray2.length(); i++) {
                this.lHJ.add(Long.valueOf(jSONArray2.getLong(i)));
            }
            for (i = 0; i < jSONArray3.length(); i++) {
                this.lHI.add(Long.valueOf(jSONArray3.getLong(i)));
            }
            this.lHH = r5;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FailMsgFileCache", e, str, new Object[0]);
        }
    }
}
