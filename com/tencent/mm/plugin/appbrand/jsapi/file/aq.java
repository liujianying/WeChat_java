package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.net.Uri;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

final class aq extends d {
    aq() {
    }

    final a a(l lVar, String str, JSONObject jSONObject) {
        j jVar;
        Uri parse = Uri.parse(str);
        List<h> linkedList = new LinkedList();
        if (bi.oV(parse.getScheme()).equals("wxfile") && bi.oW(parse.getAuthority())) {
            com.tencent.mm.plugin.appbrand.q.h hVar = new com.tencent.mm.plugin.appbrand.q.h();
            ((com.tencent.mm.plugin.appbrand.appstorage.a) lVar.fdO.fcw.B(com.tencent.mm.plugin.appbrand.appstorage.a.class)).b("", hVar);
            if (!bi.cX((List) hVar.value)) {
                for (h hVar2 : (List) hVar.value) {
                    hVar2.fileName = hVar2.fileName.replaceFirst(Pattern.quote("wxfile://"), "");
                }
            }
            e.d(linkedList, (List) hVar.value);
            hVar = new com.tencent.mm.plugin.appbrand.q.h();
            ((com.tencent.mm.plugin.appbrand.appstorage.e) lVar.fdO.fcw.B(com.tencent.mm.plugin.appbrand.appstorage.e.class)).b("wxfile://usr", hVar);
            e.d(linkedList, (List) hVar.value);
            jVar = j.OK;
        } else {
            com.tencent.mm.plugin.appbrand.q.h hVar3 = new com.tencent.mm.plugin.appbrand.q.h();
            j b = lVar.fdO.fcw.b(str, hVar3);
            e.d(linkedList, (List) hVar3.value);
            jVar = b;
        }
        switch (jVar) {
            case ERR_PARENT_DIR_NOT_EXISTS:
            case RET_NOT_EXISTS:
                return new a("fail no such file or directory \"%s\"", new Object[]{str});
            case ERR_IS_FILE:
                return new a("fail not a directory \"%s\"", new Object[]{str});
            case ERR_PERMISSION_DENIED:
                return new a("fail permission denied, open \"%s\"", new Object[]{str});
            case ERR_SYMLINK:
                return new a("fail \"%s\" is not a regular file", new Object[]{str});
            case OK:
                JSONArray jSONArray = new JSONArray();
                for (h hVar22 : linkedList) {
                    jSONArray.put(hVar22.fileName);
                }
                return new a("ok", new Object[0]).t("files", jSONArray);
            default:
                return new a("fail " + jVar.name(), new Object[0]);
        }
    }
}
