package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class GameJsApiGetGameCommInfo extends a {
    public static final int CTRL_BYTE = 241;
    public static final String NAME = "getGameCommInfo";

    private static class GetGameCommInfoTask extends GWMainProcessTask {
        public static final Creator<GetGameCommInfoTask> CREATOR = new 1();
        public String bPE;
        public int nc;
        public String result;

        /* synthetic */ GetGameCommInfoTask(Parcel parcel, byte b) {
            this(parcel);
        }

        public final void aai() {
            gl glVar = new gl();
            glVar.bPC.nc = this.nc;
            glVar.bPC.bPE = this.bPE;
            glVar.bPC.context = ad.getContext();
            com.tencent.mm.sdk.b.a.sFg.m(glVar);
            this.result = glVar.bPD.result;
        }

        public final void g(Parcel parcel) {
            this.nc = parcel.readInt();
            this.bPE = parcel.readString();
            this.result = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.nc);
            parcel.writeString(this.bPE);
            parcel.writeString(this.result);
        }

        private GetGameCommInfoTask(Parcel parcel) {
            g(parcel);
        }
    }

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiGetGameCommInfo", "invoke");
        if (jSONObject == null) {
            x.e("MicroMsg.GameJsApiGetGameCommInfo", "data is null");
            dVar.E(i, a.f("getGameCommInfo:fail_invalid_data", null));
            return;
        }
        GWMainProcessTask getGameCommInfoTask = new GetGameCommInfoTask();
        getGameCommInfoTask.nc = jSONObject.optInt("cmd", 0);
        getGameCommInfoTask.bPE = jSONObject.optString("param");
        GameWebViewMainProcessService.b(getGameCommInfoTask);
        Map hashMap = new HashMap();
        hashMap.put("gameRegionName", getGameCommInfoTask.result);
        dVar.E(i, a.f("getGameCommInfo:ok", hashMap));
    }
}
