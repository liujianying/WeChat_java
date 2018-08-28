package com.tencent.mm.wallet_core.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public final class s {
    private static s uXE;
    public String TAG = "MicroMsg.WalletDigCertManager";
    public String uXA = "";
    public String uXB = "";
    public String uXC = "";
    public Vector<r> uXD = new Vector();
    private int uXy = 0;
    public String uXz = "";

    public static void abU(String str) {
        g.Ek();
        g.Ei().DT().a(a.sUn, str);
    }

    public static String cDh() {
        g.Ek();
        return (String) g.Ei().DT().get(a.sUn, "");
    }

    public static s cDi() {
        if (uXE == null) {
            uXE = new s();
        }
        return uXE;
    }

    public final boolean cDj() {
        if (bi.oW(cDh()) || this.uXy <= 0) {
            return false;
        }
        return true;
    }

    public final void aq(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("cert_info");
        if (optJSONObject != null) {
            this.uXD = new Vector();
            int optInt = optJSONObject.optInt("show_crt_info");
            this.uXy = optJSONObject.optInt("is_crt_install");
            this.uXC = optJSONObject.optString("crt_item_logo_url");
            this.uXz = optJSONObject.optString("crt_entry_desc");
            this.uXA = optJSONObject.optString("crt_entry_title");
            this.uXB = optJSONObject.optString("crt_status_name");
            g.Ek();
            g.Ei().DT().a(a.sUo, Integer.valueOf(optInt));
            String cDh = cDh();
            JSONArray optJSONArray = optJSONObject.optJSONArray("crt_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        r rVar = new r(optJSONArray.getJSONObject(i));
                        if (rVar.uXx == 0) {
                            this.uXD.add(rVar);
                        } else if (bi.oW(cDh)) {
                            x.i(this.TAG, "drop crt list no exist local drop: %s", new Object[]{rVar.spW});
                        } else if (rVar.spW.equals(cDh)) {
                            this.uXD.add(rVar);
                        } else {
                            x.i(this.TAG, "drop crt list %s drop: %s", new Object[]{cDh, rVar.spW});
                        }
                    } catch (Exception e) {
                        x.i(this.TAG, "WalletDigCertManager error %s", new Object[]{e.getMessage()});
                    }
                }
            }
        }
    }

    public final void abV(String str) {
        if (!bi.oW(str)) {
            if (str.equals(cDh())) {
                this.uXy = 0;
                abU("");
                x.i(this.TAG, "clean token %s  stack %s ", new Object[]{str, bi.cjd().toString()});
                a.cCW();
                a.clearCert(str);
            }
            Iterator it = this.uXD.iterator();
            if (it.hasNext()) {
                this.uXD.remove((r) it.next());
            }
        }
    }
}
