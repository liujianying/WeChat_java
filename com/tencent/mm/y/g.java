package com.tencent.mm.y;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.by.c;
import com.tencent.mm.g.c.q;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import junit.framework.Assert;

public final class g extends q {
    public static a dhO;

    public static class b {
        private static final ArrayList<c<? extends d>> dzq = new ArrayList();
        private static final HashMap<Integer, c<? extends d>> dzr = new HashMap();

        static /* synthetic */ d gQ(int i) {
            c cVar = (c) dzr.get(Integer.valueOf(i));
            if (cVar != null) {
                d dVar = (d) cVar.get();
                dVar.type = i;
                return dVar;
            }
            x.w("MicroMsg.AppMessage", "get for type(%s) is null", new Object[]{Integer.valueOf(i)});
            return null;
        }

        public static void a(c<? extends d> cVar) {
            dzq.add(cVar);
        }
    }

    static {
        a aVar = new a();
        aVar.sKy = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.sKA.put("msgId", "LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(" msgId LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "msgId";
        aVar.columns[1] = "xml";
        aVar.sKA.put("xml", "TEXT");
        stringBuilder.append(" xml TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "appId";
        aVar.sKA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = SlookSmartClipMetaTag.TAG_TYPE_TITLE;
        aVar.sKA.put(SlookSmartClipMetaTag.TAG_TYPE_TITLE, "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "description";
        aVar.sKA.put("description", "TEXT");
        stringBuilder.append(" description TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "source";
        aVar.sKA.put("source", "TEXT");
        stringBuilder.append(" source TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "type";
        aVar.sKA.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        aVar.columns[7] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
        if (com.tencent.mm.sdk.a.b.chp()) {
            Assert.assertTrue(FE());
        }
    }

    protected final a AX() {
        return dhO;
    }

    private static final boolean FE() {
        Field[] declaredFields = a.class.getDeclaredFields();
        int i = 0;
        for (Field modifiers : declaredFields) {
            if (!Modifier.isStatic(modifiers.getModifiers())) {
                i++;
            }
        }
        if (i > JsApiChooseMedia.CTRL_INDEX) {
            x.e("MicroMsg.AppMessage", "AppMessage.Content should not add new field!!! (%d) is over the limit(%d)!!!", new Object[]{Integer.valueOf(i), Integer.valueOf(JsApiChooseMedia.CTRL_INDEX)});
            return false;
        }
        x.i("MicroMsg.AppMessage", "AppMessage.Content nonStaticFieldCount: %d", new Object[]{Integer.valueOf(i)});
        return true;
    }
}
