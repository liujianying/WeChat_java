package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI.a;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class GoogleFriendUI$b extends AsyncTask<Void, Void, Void> {
    private String eIe;
    final /* synthetic */ GoogleFriendUI eIi;
    private a eIq;
    private Context mContext;

    /* synthetic */ GoogleFriendUI$b(GoogleFriendUI googleFriendUI, Context context, String str, byte b) {
        this(googleFriendUI, context, str);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        super.onPostExecute((Void) obj);
        x.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "onPostExecute");
        if (this.eIq != a.eIl) {
            GoogleFriendUI.a(this.eIi, this.eIq, null);
        } else if (GoogleFriendUI.e(this.eIi) == null || GoogleFriendUI.e(this.eIi).size() <= 0) {
            GoogleFriendUI.a(this.eIi, a.eIm, null);
        } else {
            GoogleFriendUI.a(this.eIi, a.eIl, GoogleFriendUI.e(this.eIi));
        }
    }

    private GoogleFriendUI$b(GoogleFriendUI googleFriendUI, Context context, String str) {
        this.eIi = googleFriendUI;
        this.eIq = a.eIo;
        this.mContext = context;
        this.eIe = str;
    }

    protected final void onPreExecute() {
        super.onPreExecute();
        x.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "onPreExecute");
        GoogleFriendUI.e(this.eIi).clear();
        GoogleFriendUI.f(this.eIi).clear();
    }

    private Void WK() {
        x.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "doInBackground");
        int i = 0;
        int i2 = 1;
        while (true) {
            try {
                String o;
                Object obj;
                x.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "startInde:%d, totalCount:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
                x.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "requestURL:%s", new Object[]{new URL("https://www.google.com/m8/feeds/contacts/default/property-email?alt=" + "json" + "&max-results=100&start-index=" + i2 + "&access_token=" + this.eIe).toString()});
                HttpURLConnection httpURLConnection = (HttpURLConnection) r6.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(20000);
                int responseCode = httpURLConnection.getResponseCode();
                x.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "responseCode:%d", new Object[]{Integer.valueOf(responseCode)});
                if (responseCode == 200) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    o = o(inputStream);
                    inputStream.close();
                } else {
                    if (responseCode == 401) {
                        x.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Server OAuth Error,Please Try Again.");
                    } else {
                        x.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Unknow Error.");
                    }
                    httpURLConnection.disconnect();
                    o = null;
                }
                responseCode = new JSONObject(o).getJSONObject("feed").getJSONObject("openSearch$totalResults").getInt("$t");
                if (responseCode > 0) {
                    pl(o);
                }
                if (responseCode - i2 > 100) {
                    i2 += 100;
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null || GoogleFriendUI.g(this.eIi)) {
                    this.eIq = a.eIl;
                } else {
                    i = responseCode;
                }
            } catch (IOException e) {
                this.eIq = a.eIn;
                x.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "IOException" + e.getMessage());
            } catch (JSONException e2) {
                this.eIq = a.eIo;
                x.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "JSONException" + e2.getMessage());
            }
        }
        this.eIq = a.eIl;
        return null;
    }

    private static String o(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[20480];
        while (true) {
            int read = inputStream.read(bArr, 0, 20480);
            if (read == -1) {
                return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private void pl(String str) {
        JSONArray jSONArray = new JSONObject(str).getJSONObject("feed").getJSONArray("entry");
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String string;
                String str2 = "";
                String str3 = "";
                String str4 = "";
                JSONObject optJSONObject = jSONArray.getJSONObject(i).optJSONObject("id");
                JSONObject optJSONObject2 = jSONArray.getJSONObject(i).optJSONObject("title");
                JSONArray optJSONArray = jSONArray.getJSONObject(i).optJSONArray("gd$email");
                JSONArray optJSONArray2 = jSONArray.getJSONObject(i).optJSONArray("link");
                if (optJSONObject != null) {
                    string = optJSONObject.getString("$t");
                    int lastIndexOf = string.lastIndexOf("/");
                    if (lastIndexOf > 0) {
                        String string2;
                        string = string.substring(lastIndexOf + 1);
                        if (optJSONObject2 == null) {
                            str2 = optJSONObject2.getString("$t");
                        } else {
                            str2 = str3;
                        }
                        if (optJSONArray2 != null) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                string2 = optJSONArray2.getJSONObject(i2).getString("rel");
                                lastIndexOf = string2.lastIndexOf("#");
                                if (lastIndexOf > 0) {
                                    CharSequence substring = string2.substring(lastIndexOf + 1);
                                    if (!TextUtils.isEmpty(substring) && "photo".equals(substring)) {
                                        str4 = optJSONArray2.getJSONObject(i2).getString("href");
                                    }
                                }
                            }
                        }
                        str3 = str4;
                        if (optJSONArray != null) {
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                string2 = optJSONArray.getJSONObject(i3).getString("address");
                                if (!(TextUtils.isEmpty(string2) || !bi.WF(string2) || string2.equals(GoogleFriendUI.h(this.eIi)))) {
                                    n nVar = new n();
                                    nVar.field_googleid = string;
                                    nVar.field_googleitemid = string + string2;
                                    nVar.field_googlename = str2;
                                    nVar.field_googlephotourl = str3;
                                    nVar.field_googlegmail = string2;
                                    if (!GoogleFriendUI.f(this.eIi).containsKey(string2)) {
                                        GoogleFriendUI.e(this.eIi).add(nVar);
                                        GoogleFriendUI.f(this.eIi).put(string2, nVar);
                                    }
                                }
                            }
                        }
                    }
                }
                string = str2;
                if (optJSONObject2 == null) {
                    str2 = str3;
                } else {
                    str2 = optJSONObject2.getString("$t");
                }
                if (optJSONArray2 != null) {
                    for (int i22 = 0; i22 < optJSONArray2.length(); i22++) {
                        string2 = optJSONArray2.getJSONObject(i22).getString("rel");
                        lastIndexOf = string2.lastIndexOf("#");
                        if (lastIndexOf > 0) {
                            CharSequence substring2 = string2.substring(lastIndexOf + 1);
                            if (!TextUtils.isEmpty(substring2) && "photo".equals(substring2)) {
                                str4 = optJSONArray2.getJSONObject(i22).getString("href");
                            }
                        }
                    }
                }
                str3 = str4;
                if (optJSONArray != null) {
                    for (int i32 = 0; i32 < optJSONArray.length(); i32++) {
                        string2 = optJSONArray.getJSONObject(i32).getString("address");
                        if (!(TextUtils.isEmpty(string2) || !bi.WF(string2) || string2.equals(GoogleFriendUI.h(this.eIi)))) {
                            n nVar2 = new n();
                            nVar2.field_googleid = string;
                            nVar2.field_googleitemid = string + string2;
                            nVar2.field_googlename = str2;
                            nVar2.field_googlephotourl = str3;
                            nVar2.field_googlegmail = string2;
                            if (!GoogleFriendUI.f(this.eIi).containsKey(string2)) {
                                GoogleFriendUI.e(this.eIi).add(nVar2);
                                GoogleFriendUI.f(this.eIi).put(string2, nVar2);
                            }
                        }
                    }
                }
            }
        }
    }
}
