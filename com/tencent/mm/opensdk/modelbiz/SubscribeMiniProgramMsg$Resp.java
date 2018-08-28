package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class SubscribeMiniProgramMsg$Resp extends BaseResp {
    private static final String TAG = "MicroMsg.SDK.SubscribeMessage.Resp";
    public String nickname;
    public String unionId;

    public SubscribeMiniProgramMsg$Resp(Bundle bundle) {
        fromBundle(bundle);
    }

    public boolean checkArgs() {
        return true;
    }

    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.unionId = bundle.getString("_wxapi_subscribeminiprogram_resp_unionId");
        this.nickname = bundle.getString("_wxapi_subscribeminiprogram_resp_nickname");
    }

    public int getType() {
        return 23;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_wxapi_subscribeminiprogram_resp_unionId", this.unionId);
        bundle.putString("_wxapi_subscribeminiprogram_resp_nickname", this.nickname);
    }
}
