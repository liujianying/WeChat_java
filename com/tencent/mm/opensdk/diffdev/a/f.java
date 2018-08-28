package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;

final class f extends AsyncTask<Void, Void, a> {
    private OAuthListener l;
    private String o;
    private int u;
    private String url;

    public f(String str, OAuthListener oAuthListener) {
        this.o = str;
        this.l = oAuthListener;
        this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", new Object[]{str});
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        a aVar;
        if (this.o == null || this.o.length() == 0) {
            Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
            aVar = new a();
            aVar.n = OAuthErrCode.WechatAuth_Err_NormalErr;
            return aVar;
        }
        while (!isCancelled()) {
            String str = this.url + (this.u == 0 ? "" : "&last=" + this.u);
            long currentTimeMillis = System.currentTimeMillis();
            byte[] a = e.a(str, 60000);
            long currentTimeMillis2 = System.currentTimeMillis();
            aVar = a.b(a);
            Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", new Object[]{str, aVar.n.toString(), Integer.valueOf(aVar.w), Long.valueOf(currentTimeMillis2 - currentTimeMillis)}));
            if (aVar.n == OAuthErrCode.WechatAuth_Err_OK) {
                this.u = aVar.w;
                if (aVar.w == g.UUID_SCANED.getCode()) {
                    this.l.onQrcodeScanned();
                } else if (aVar.w != g.UUID_KEEP_CONNECT.getCode() && aVar.w == g.UUID_CONFIRM.getCode()) {
                    if (aVar.v != null && aVar.v.length() != 0) {
                        return aVar;
                    }
                    Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                    aVar.n = OAuthErrCode.WechatAuth_Err_NormalErr;
                    return aVar;
                }
            }
            Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", new Object[]{aVar.n.toString(), Integer.valueOf(aVar.w)}));
            return aVar;
        }
        Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
        aVar = new a();
        aVar.n = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        return aVar;
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        a aVar = (a) obj;
        this.l.onAuthFinish(aVar.n, aVar.v);
    }
}
