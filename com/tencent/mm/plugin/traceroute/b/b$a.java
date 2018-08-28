package com.tencent.mm.plugin.traceroute.b;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

class b$a implements Runnable {
    private List<Object> jte;
    private String[] oDx;

    public b$a(String[] strArr, List<Object> list) {
        this.oDx = strArr;
        this.jte = list;
    }

    public final void run() {
        IOException e;
        Throwable th;
        InterruptedException e2;
        Exception e3;
        StringBuilder stringBuilder = new StringBuilder();
        ProcessBuilder processBuilder = new ProcessBuilder(this.oDx);
        processBuilder.redirectErrorStream(true);
        long VF = bi.VF();
        long VF2 = bi.VF();
        Process start;
        BufferedReader bufferedReader;
        try {
            start = processBuilder.start();
            try {
                bi.d(start.getOutputStream());
                VF2 = bi.VF();
                bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream()), 8096);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuilder.append(readLine);
                    } catch (IOException e4) {
                        e = e4;
                        try {
                            x.e("MicroMsg.MMTraceRoute", "run cmd err, io exception: " + e.getMessage());
                            b.a(start, bufferedReader);
                            this.jte.add(stringBuilder.toString());
                            this.jte.add(Long.valueOf(VF2 - VF));
                            x.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                        } catch (Throwable th2) {
                            th = th2;
                            b.a(start, bufferedReader);
                            throw th;
                        }
                    } catch (InterruptedException e5) {
                        e2 = e5;
                        x.e("MicroMsg.MMTraceRoute", "run cmd err, interruptedexception: " + e2.getMessage());
                        b.a(start, bufferedReader);
                        this.jte.add(stringBuilder.toString());
                        this.jte.add(Long.valueOf(VF2 - VF));
                        x.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                    } catch (Exception e6) {
                        e3 = e6;
                        x.e("MicroMsg.MMTraceRoute", "run cmd err: " + e3.getMessage());
                        b.a(start, bufferedReader);
                        this.jte.add(stringBuilder.toString());
                        this.jte.add(Long.valueOf(VF2 - VF));
                        x.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                    }
                }
                start.waitFor();
                b.a(start, bufferedReader);
            } catch (IOException e7) {
                e = e7;
                bufferedReader = null;
                x.e("MicroMsg.MMTraceRoute", "run cmd err, io exception: " + e.getMessage());
                b.a(start, bufferedReader);
                this.jte.add(stringBuilder.toString());
                this.jte.add(Long.valueOf(VF2 - VF));
                x.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
            } catch (InterruptedException e8) {
                e2 = e8;
                bufferedReader = null;
                x.e("MicroMsg.MMTraceRoute", "run cmd err, interruptedexception: " + e2.getMessage());
                b.a(start, bufferedReader);
                this.jte.add(stringBuilder.toString());
                this.jte.add(Long.valueOf(VF2 - VF));
                x.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
            } catch (Exception e9) {
                e3 = e9;
                bufferedReader = null;
                x.e("MicroMsg.MMTraceRoute", "run cmd err: " + e3.getMessage());
                b.a(start, bufferedReader);
                this.jte.add(stringBuilder.toString());
                this.jte.add(Long.valueOf(VF2 - VF));
                x.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                b.a(start, bufferedReader);
                throw th;
            }
        } catch (IOException e10) {
            e = e10;
            bufferedReader = null;
            start = null;
        } catch (InterruptedException e11) {
            e2 = e11;
            bufferedReader = null;
            start = null;
            x.e("MicroMsg.MMTraceRoute", "run cmd err, interruptedexception: " + e2.getMessage());
            b.a(start, bufferedReader);
            this.jte.add(stringBuilder.toString());
            this.jte.add(Long.valueOf(VF2 - VF));
            x.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
        } catch (Exception e12) {
            e3 = e12;
            bufferedReader = null;
            start = null;
            x.e("MicroMsg.MMTraceRoute", "run cmd err: " + e3.getMessage());
            b.a(start, bufferedReader);
            this.jte.add(stringBuilder.toString());
            this.jte.add(Long.valueOf(VF2 - VF));
            x.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            start = null;
            b.a(start, bufferedReader);
            throw th;
        }
        this.jte.add(stringBuilder.toString());
        this.jte.add(Long.valueOf(VF2 - VF));
        x.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
    }
}
