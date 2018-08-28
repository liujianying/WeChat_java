package com.tencent.mm.ac;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j {
    public static String dMg = "menu_click";
    public static String dMh = "menu_action_start";
    public static String dMi = "menu_action_success";
    public String aAL;
    public String ceR;
    public String content;
    public List<j> dMj = null;
    public int dMk;
    public int id;
    public String name;
    public String state;
    public int type;
    public String value;

    public final void e(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            x.e("MicroMsg.BizMenuItem", "value null!");
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pic_md5", str);
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pics", jSONArray);
            this.content = jSONObject2.toString();
            x.v("MicroMsg.BizMenuItem", this.content);
        } catch (JSONException e) {
            x.e("MicroMsg.BizMenuItem", e.toString());
        }
    }

    public final String getInfo() {
        if (this.content == null) {
            this.content = "";
        }
        if (this.state == null) {
            if (this.type == 4) {
                this.state = dMh;
            } else {
                this.state = dMg;
            }
        }
        return String.format("%s<info><id><![CDATA[%d]]></id><key><![CDATA[%s]]></key><status><![CDATA[%s]]></status><content><![CDATA[%s]]></content></info>", new Object[]{"#bizmenu#", Integer.valueOf(this.id), this.aAL, this.state, this.content});
    }

    public final String toString() {
        String str = "id:%d, type:%d, acttype:%s, name:%s, key:%s, value:%s, content:%s";
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(this.id);
        objArr[1] = Integer.valueOf(this.dMk);
        objArr[2] = Integer.valueOf(this.type);
        objArr[3] = this.name == null ? "" : this.name;
        objArr[4] = this.aAL == null ? "" : this.aAL;
        objArr[5] = this.value == null ? "" : this.value;
        objArr[6] = this.content == null ? "" : this.content;
        return String.format(str, objArr);
    }

    public static List<j> c(JSONArray jSONArray) {
        List<j> arrayList;
        if (jSONArray != null) {
            try {
                arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    j jVar = new j();
                    jVar.id = jSONObject.getInt("id");
                    jVar.type = jSONObject.getInt("type");
                    jVar.name = jSONObject.getString("name");
                    jVar.aAL = jSONObject.getString("key");
                    jVar.value = jSONObject.optString("value");
                    jVar.ceR = jSONObject.optString("native_url");
                    x.d("MicroMsg.BizMenuItem", "menuItem.nativeurl : " + jVar.ceR);
                    jVar.dMj = c(jSONObject.optJSONArray("sub_button_list"));
                    jVar.dMk = jSONObject.optInt("acttype");
                    arrayList.add(jVar);
                }
            } catch (Throwable e) {
                x.e("MicroMsg.BizMenuItem", "exception:%s", new Object[]{bi.i(e)});
                return null;
            }
        }
        arrayList = null;
        return arrayList;
    }

    public static LinkedList<j> s(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        int i = bi.getInt((String) map.get(".msg.appmsg.buttonlist.$count"), 0);
        if (i <= 0) {
            return null;
        }
        try {
            LinkedList<j> linkedList = new LinkedList();
            x.v("MicroMsg.BizMenuItem", "menuItem.jsonArray.length : " + i);
            int i2 = 0;
            while (i2 < i) {
                j jVar = new j();
                String str = ".msg.appmsg.buttonlist.button" + (i2 == 0 ? "" : String.valueOf(i2));
                jVar.id = bi.getInt((String) map.get(str + ".id"), 0);
                jVar.type = bi.getInt((String) map.get(str + ".type"), 0);
                jVar.name = (String) map.get(str + ".name");
                jVar.aAL = (String) map.get(str + ".key");
                jVar.value = (String) map.get(str + ".value");
                jVar.dMk = bi.getInt((String) map.get(str + ".acttype"), 0);
                linkedList.add(jVar);
                i2++;
            }
            return linkedList;
        } catch (Throwable e) {
            x.e("MicroMsg.BizMenuItem", "exception:%s", new Object[]{bi.i(e)});
            return null;
        }
    }
}
