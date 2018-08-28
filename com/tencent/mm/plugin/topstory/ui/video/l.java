package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v4.e.k;
import android.support.v7.widget.RecyclerView$t;
import android.support.v7.widget.RecyclerView.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.u;
import com.tencent.mm.network.v;
import com.tencent.mm.plugin.topstory.a.c.b;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.topstory.ui.a.c;
import com.tencent.mm.plugin.topstory.ui.a.d;
import com.tencent.mm.protocal.c.bth;
import com.tencent.mm.protocal.c.bti;
import com.tencent.mm.protocal.c.ps;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l extends a<RecyclerView$t> {
    e dKj = new 3(this);
    a oAb;
    k<View> oAp = new k();
    private k<View> oAq = new k();
    List<bti> oAr = new ArrayList();
    boolean oAs;
    boolean oAt;
    boolean oAu;
    int oAv;
    b oAw;
    private int oAx;
    private int oAy;
    private bth oyK;

    public l(a aVar, bth bth) {
        this.oyK = bth;
        if (bth.sqM != null) {
            this.oAr.add(bth.sqM);
        }
        this.oAb = aVar;
    }

    public final RecyclerView$t a(ViewGroup viewGroup, int i) {
        if (this.oAp.get(i) != null) {
            return new 1(this, (View) this.oAp.get(i));
        }
        if (this.oAq.get(i) != null) {
            return new 2(this, (View) this.oAq.get(i));
        }
        View inflate;
        if (i == 0) {
            inflate = LayoutInflater.from(viewGroup.getContext()).inflate(com.tencent.mm.plugin.topstory.ui.b.e.top_story_video_item_view, null);
            inflate.setTag("video");
            return new c(inflate, this.oAb);
        }
        inflate = LayoutInflater.from(viewGroup.getContext()).inflate(com.tencent.mm.plugin.topstory.ui.b.e.top_story_video_item_view_with_tag, null);
        inflate.setTag("video");
        return new d(inflate, this.oAb);
    }

    public final void a(RecyclerView$t recyclerView$t, int i) {
        boolean z = true;
        if (!yi(i) && !yj(i)) {
            int size = i - this.oAp.size();
            c cVar = (c) recyclerView$t;
            bti bti = (bti) this.oAr.get(size);
            cVar.a(bti, size);
            if (!this.oAs || size != 0) {
                this.oAb.bHU().a(bti);
            } else if (bi.oW(bti.videoUrl)) {
                this.oAt = true;
            } else {
                if (this.oAb.bHR().ozV) {
                    z = false;
                }
                cVar.iE(z);
                this.oAs = false;
                this.oAb.bHU().a(bti);
                this.oAt = false;
            }
        }
    }

    public final int getItemCount() {
        return (this.oAr.size() + this.oAp.size()) + this.oAq.size();
    }

    public final boolean yh(int i) {
        if (this.oAu) {
            x.w("MicroMsg.TopStory.TopStoryVideoStreamAdapter", "RequestingData");
            return false;
        }
        ps psVar;
        ps psVar2;
        String stringBuffer;
        x.i("MicroMsg.TopStory.TopStoryVideoStreamAdapter", "requestData: %s", new Object[]{Integer.valueOf(i)});
        this.oAu = true;
        bth a = g.a(this.oyK);
        a.offset = i;
        if (!bi.oW(this.oyK.sqH)) {
            psVar = new ps();
            psVar.aAL = "relevant_vid";
            psVar.rtV = this.oyK.sqH;
            a.pKZ.add(psVar);
        }
        if (!bi.oW(this.oyK.sqI)) {
            psVar = new ps();
            psVar.aAL = "relevant_expand";
            psVar.rtV = this.oyK.sqI;
            a.pKZ.add(psVar);
        }
        if (!bi.oW(this.oyK.sqJ)) {
            psVar = new ps();
            psVar.aAL = "relevant_pre_searchid";
            psVar.rtV = this.oyK.sqJ;
            a.pKZ.add(psVar);
        }
        if (!bi.oW(this.oyK.sqK)) {
            psVar = new ps();
            psVar.aAL = "relevant_shared_openid";
            psVar.rtV = this.oyK.sqK;
            a.pKZ.add(psVar);
        }
        if (this.oyK.sqN != null) {
            psVar = new ps();
            psVar.aAL = "rec_category";
            psVar.rtU = this.oyK.sqN.slJ;
            a.pKZ.add(psVar);
        } else {
            psVar = new ps();
            psVar.aAL = "rec_category";
            psVar.rtU = this.oyK.sqL;
            a.pKZ.add(psVar);
        }
        if (this.oyK.sqN != null) {
            psVar = new ps();
            psVar.aAL = "show_tag_list";
            psVar.rtV = this.oyK.sqN.id;
            a.pKZ.add(psVar);
        }
        if (this.oAr.size() == 1) {
            bti bti = (bti) this.oAr.get(0);
            psVar2 = new ps();
            psVar2.aAL = "first_video_tag_list";
            psVar2.rtV = g.cA(bti.rBV).toString();
            a.pKZ.add(psVar2);
        }
        j bHU = this.oAb.bHU();
        if (bHU.oAk.size() > 0) {
            List<com.tencent.mm.plugin.topstory.a.b.b> arrayList = new ArrayList();
            arrayList.addAll(bHU.oAk.values());
            StringBuffer stringBuffer2 = new StringBuffer("");
            for (com.tencent.mm.plugin.topstory.a.b.b bVar : arrayList) {
                int i2;
                if (bVar.ozk) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                stringBuffer2.append(i2);
                stringBuffer2.append("_");
                stringBuffer2.append(bVar.ozj.sqS);
                stringBuffer2.append(";");
            }
            stringBuffer = stringBuffer2.toString();
        } else {
            stringBuffer = null;
        }
        if (!bi.oW(stringBuffer)) {
            psVar2 = new ps();
            psVar2.aAL = "client_exposed_info";
            psVar2.rtV = stringBuffer;
            a.pKZ.add(psVar2);
        }
        psVar = new ps();
        psVar.aAL = "is_prefetch";
        psVar.rtU = (long) this.oAv;
        a.pKZ.add(psVar);
        this.oAw = new b(a);
        com.tencent.mm.kernel.g.DF().a(this.oAw, 0);
        com.tencent.mm.kernel.g.DF().a(1943, this.dKj);
        com.tencent.mm.plugin.websearch.api.a.a.kB(0);
        return true;
    }

    private static void a(bti bti, String str, String str2) {
        InputStream inputStream;
        u uVar;
        Throwable e;
        int i = 0;
        String str3 = null;
        StringBuilder stringBuilder = new StringBuilder("");
        v oy;
        try {
            if (URLUtil.isHttpsUrl(str)) {
                oy = com.tencent.mm.network.b.oy(str);
                try {
                    oy.UM();
                    oy.UK();
                    oy.UL();
                    inputStream = oy.esX.getInputStream();
                    uVar = null;
                } catch (Exception e2) {
                    e = e2;
                    uVar = null;
                    inputStream = null;
                    try {
                        x.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoStreamAdapter", e, "getVideoUrlByVideoApi error: %s", new Object[]{e.getMessage()});
                        if (uVar != null) {
                            uVar.aBv.disconnect();
                        }
                        if (oy != null) {
                            oy.esX.disconnect();
                        }
                        if (inputStream == null) {
                            com.tencent.mm.a.e.f(inputStream);
                        }
                    } catch (Throwable th) {
                        e = th;
                        if (uVar != null) {
                            uVar.aBv.disconnect();
                        }
                        if (oy != null) {
                            oy.esX.disconnect();
                        }
                        if (inputStream != null) {
                            com.tencent.mm.a.e.f(inputStream);
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    uVar = null;
                    inputStream = null;
                    if (uVar != null) {
                        uVar.aBv.disconnect();
                    }
                    if (oy != null) {
                        oy.esX.disconnect();
                    }
                    if (inputStream != null) {
                        com.tencent.mm.a.e.f(inputStream);
                    }
                    throw e;
                }
            }
            uVar = com.tencent.mm.network.b.a(str, null);
            try {
                uVar.setUseCaches(true);
                uVar.setConnectTimeout(3000);
                uVar.setReadTimeout(3000);
                inputStream = uVar.getInputStream();
                oy = null;
            } catch (Exception e3) {
                e = e3;
                oy = null;
                inputStream = null;
                x.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoStreamAdapter", e, "getVideoUrlByVideoApi error: %s", new Object[]{e.getMessage()});
                if (uVar != null) {
                    uVar.aBv.disconnect();
                }
                if (oy != null) {
                    oy.esX.disconnect();
                }
                if (inputStream == null) {
                    com.tencent.mm.a.e.f(inputStream);
                }
            } catch (Throwable th3) {
                e = th3;
                oy = null;
                inputStream = null;
                if (uVar != null) {
                    uVar.aBv.disconnect();
                }
                if (oy != null) {
                    oy.esX.disconnect();
                }
                if (inputStream != null) {
                    com.tencent.mm.a.e.f(inputStream);
                }
                throw e;
            }
            try {
                String readLine;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuilder.append(readLine);
                }
                JSONObject jSONObject = new JSONObject(stringBuilder.toString().substring(13));
                JSONObject optJSONObject = jSONObject.optJSONObject("fl");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("fi");
                    if (optJSONArray != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                            if (jSONObject2.optInt("sl", 0) == 1) {
                                bti.srb = jSONObject2.optLong("fs");
                                break;
                            }
                        }
                    }
                }
                optJSONObject = jSONObject.optJSONObject("vl");
                if (optJSONObject != null) {
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("vi");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        String str4 = null;
                        readLine = null;
                        while (true) {
                            String str5 = str3;
                            if (i >= optJSONArray2.length()) {
                                break;
                            }
                            JSONObject jSONObject3 = optJSONArray2.getJSONObject(i);
                            if (jSONObject3 != null) {
                                readLine = jSONObject3.optString("fn");
                                str3 = jSONObject3.optString("fvkey");
                                optJSONObject = jSONObject3.optJSONObject("ul");
                                if (optJSONObject != null) {
                                    JSONArray optJSONArray3 = optJSONObject.optJSONArray("ui");
                                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                                        optJSONObject = optJSONArray3.getJSONObject(0);
                                        if (optJSONObject != null) {
                                            str5 = optJSONObject.optString("url");
                                        }
                                    }
                                }
                            } else {
                                str3 = str4;
                            }
                            str4 = bi.oW(str5);
                            if (str4 == null) {
                                str4 = bi.oW(str3);
                                if (str4 == null) {
                                    str4 = bi.oW(readLine);
                                    if (str4 == null) {
                                        str4 = str5 + readLine + "?vkey=" + str3;
                                        if (!bi.oW(str2)) {
                                            str4 = str4 + "&platform=" + str2;
                                        }
                                        bti.srd.add(str4);
                                    }
                                }
                            }
                            i++;
                        }
                    }
                }
                if (uVar != null) {
                    uVar.aBv.disconnect();
                }
                if (oy != null) {
                    oy.esX.disconnect();
                }
                if (inputStream != null) {
                    com.tencent.mm.a.e.f(inputStream);
                }
            } catch (Exception e4) {
                e = e4;
                x.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoStreamAdapter", e, "getVideoUrlByVideoApi error: %s", new Object[]{e.getMessage()});
                if (uVar != null) {
                    uVar.aBv.disconnect();
                }
                if (oy != null) {
                    oy.esX.disconnect();
                }
                if (inputStream == null) {
                    com.tencent.mm.a.e.f(inputStream);
                }
            }
        } catch (Exception e5) {
            e = e5;
            oy = null;
            uVar = null;
            inputStream = null;
            x.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoStreamAdapter", e, "getVideoUrlByVideoApi error: %s", new Object[]{e.getMessage()});
            if (uVar != null) {
                uVar.aBv.disconnect();
            }
            if (oy != null) {
                oy.esX.disconnect();
            }
            if (inputStream == null) {
                com.tencent.mm.a.e.f(inputStream);
            }
        } catch (Throwable th4) {
            e = th4;
            oy = null;
            uVar = null;
            inputStream = null;
            if (uVar != null) {
                uVar.aBv.disconnect();
            }
            if (oy != null) {
                oy.esX.disconnect();
            }
            if (inputStream != null) {
                com.tencent.mm.a.e.f(inputStream);
            }
            throw e;
        }
    }

    final void aK(final int i, final String str) {
        x.e("MicroMsg.TopStory.TopStoryVideoStreamAdapter", "callbackToFailed, msg: %s", new Object[]{str});
        ah.A(new Runnable() {
            public final void run() {
                if (l.this.oAb != null) {
                    l.this.oAb.Ou(str);
                }
            }
        });
    }

    private boolean yi(int i) {
        return i < this.oAp.size();
    }

    private boolean yj(int i) {
        return i >= this.oAp.size() + this.oAr.size();
    }

    public final int getItemViewType(int i) {
        if (yi(i)) {
            return this.oAp.keyAt(i);
        }
        if (yj(i)) {
            return this.oAq.keyAt((i - this.oAp.size()) - this.oAr.size());
        }
        if (((bti) this.oAr.get(i - this.oAp.size())).rBV.size() > 0) {
            return 1;
        }
        return 0;
    }

    public final void addHeaderView(View view) {
        this.oAp.put(this.oAp.size() + 100000, view);
    }

    public final void cW(View view) {
        this.oAq.put(this.oAq.size() + 200000, view);
    }
}
