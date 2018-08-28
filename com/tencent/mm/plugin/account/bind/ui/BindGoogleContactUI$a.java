package com.tencent.mm.plugin.account.bind.ui;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI.4;
import com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI.5;
import com.tencent.mm.plugin.account.friend.a.w;
import com.tencent.mm.plugin.appbrand.jsapi.f.m;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.json.JSONObject;

class BindGoogleContactUI$a extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ BindGoogleContactUI eFm;
    private String eFo;
    private String eFp;
    private boolean eFq;

    protected final /* synthetic */ void onPostExecute(Object obj) {
        super.onPostExecute((Void) obj);
        x.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPostExecute");
        BindGoogleContactUI bindGoogleContactUI = this.eFm;
        boolean z = this.eFq;
        String str = this.eFp;
        if (!z || TextUtils.isEmpty(str)) {
            bindGoogleContactUI.WJ();
            bindGoogleContactUI.WG();
        } else if (TextUtils.isEmpty(bindGoogleContactUI.eEW) || TextUtils.isEmpty(str) || bindGoogleContactUI.eEW.equalsIgnoreCase(str)) {
            bindGoogleContactUI.eEW = str;
            bindGoogleContactUI.Z(bindGoogleContactUI.eEW, w.eKF);
        } else {
            bindGoogleContactUI.WJ();
            h.a(bindGoogleContactUI, bindGoogleContactUI.getString(j.gcontact_msg_no_same_account), "", new 4(bindGoogleContactUI, str), new 5(bindGoogleContactUI));
        }
    }

    public BindGoogleContactUI$a(BindGoogleContactUI bindGoogleContactUI, String str) {
        this.eFm = bindGoogleContactUI;
        this.eFo = str;
    }

    protected final void onPreExecute() {
        super.onPreExecute();
        x.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPreExecute");
        this.eFq = false;
    }

    private Void WK() {
        x.i("MicroMsg.GoogleContact.BindGoogleContactUI", "doInBackground");
        try {
            String str = "";
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + this.eFo).openConnection();
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(20000);
            httpURLConnection.setReadTimeout(20000);
            int responseCode = httpURLConnection.getResponseCode();
            x.e("MicroMsg.GoogleContact.BindGoogleContactUI", "responseCode:" + responseCode);
            if (m.CTRL_INDEX == responseCode) {
                StringBuffer stringBuffer = new StringBuffer();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                }
                bufferedReader.close();
                str = stringBuffer.toString();
                x.i("MicroMsg.GoogleContact.BindGoogleContactUI", "get EmailAccount respone:%s", new Object[]{str});
            }
            httpURLConnection.disconnect();
            this.eFp = new JSONObject(str).optString("email");
            if (!TextUtils.isEmpty(this.eFp)) {
                this.eFq = true;
            }
        } catch (MalformedURLException e) {
            x.e("MicroMsg.GoogleContact.BindGoogleContactUI", "MalformedURLException:%s", new Object[]{e.getMessage()});
        } catch (ProtocolException e2) {
            x.e("MicroMsg.GoogleContact.BindGoogleContactUI", "ProtocolException:%s", new Object[]{e2.getMessage()});
        } catch (UnsupportedEncodingException e3) {
            x.e("MicroMsg.GoogleContact.BindGoogleContactUI", "UnsupportedEncodingException:%s", new Object[]{e3.getMessage()});
        } catch (IOException e4) {
            x.e("MicroMsg.GoogleContact.BindGoogleContactUI", "IOException:%s", new Object[]{e4.getMessage()});
        } catch (Throwable e5) {
            x.printErrStackTrace("MicroMsg.GoogleContact.BindGoogleContactUI", e5, "", new Object[0]);
        }
        return null;
    }
}
