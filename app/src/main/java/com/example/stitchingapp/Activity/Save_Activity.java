package com.example.stitchingapp.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stitchingapp.R;
import com.example.stitchingapp.Adapter.SavedLinkAdapter;

import java.util.ArrayList;
import java.util.List;

public class Save_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    SavedLinkAdapter adapter;
    List<String> savedLinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        savedLinks = loadSavedLinks();
        adapter = new SavedLinkAdapter(savedLinks, this);
        recyclerView.setAdapter(adapter);
    }

    private List<String> loadSavedLinks() {
        SharedPreferences sharedPreferences1 = getSharedPreferences("liked_Images1", MODE_PRIVATE);
        List<String> links = new ArrayList<>();

        // Add links from the first SharedPreferences
        if (sharedPreferences1.getBoolean("isLiked1", false)) {
            links.add("https://youtu.be/W97Xqd2HaxI?si=EC-N8aQ1Xa0gxqFv");
        }
        if (sharedPreferences1.getBoolean("isLiked2", false)) {
            links.add("https://youtu.be/9IG4o3OnqG0?si=zFM-d0dyawqxCwRJ");
        }
        if (sharedPreferences1.getBoolean("isLiked3", false)) {
            links.add("https://youtu.be/5roWm1ZI3Ck?si=6bM6-RP2eL4iXR-V");
        }
        if (sharedPreferences1.getBoolean("isLiked4", false)) {
            links.add("https://youtu.be/y3jTg0x59aM?si=Hysyv4wDaKu4OqSH");
        }
        if (sharedPreferences1.getBoolean("isLiked5", false)) {
            links.add("https://youtu.be/YeFGIBe35QM?si=DKFdOv7N53sMpHEO");
        }
        if (sharedPreferences1.getBoolean("isLiked6", false)) {
            links.add("https://youtu.be/P2-TjjHqIQ0?si=xSAL1gG1aFQRbs-g");
        }
        if (sharedPreferences1.getBoolean("isLiked7", false)) {
            links.add("https://youtu.be/Noszb6420Mw?si=PS-0SaBOqINuq_xi");
        }
        if (sharedPreferences1.getBoolean("isLiked8", false)) {
            links.add("https://youtu.be/7qsK55n5jKE?si=npkuURCSIKzbT6o_");
        }

        // Add links from the second SharedPreferences
        SharedPreferences sharedPreferences2 = getSharedPreferences("liked_Images2", MODE_PRIVATE);
        if (sharedPreferences2.getBoolean("isLiked9", false)) {
            links.add("https://youtu.be/hqQWd_cGrfk?si=yRpVm_clfn-UiVoW");
        }
        if (sharedPreferences2.getBoolean("isLiked10", false)) {
            links.add("https://youtu.be/aIXBOVCnRs0?si=Uqj6D7z57H29JR49");
        }
        if (sharedPreferences2.getBoolean("isLiked11", false)) {
            links.add("https://youtu.be/lU7V6BxgiJE?si=gMGOZumZwGvTRIX9");
        }
        if (sharedPreferences2.getBoolean("isLiked12", false)) {
            links.add("https://youtu.be/_tDpMDN3Rdc?si=c88dZVlhlqb4vhde");
        }
        if (sharedPreferences2.getBoolean("isLiked13", false)) {
            links.add("https://youtu.be/5uhCzmdncaE?si=bboX4E7Mdm-12fsz");
        }
        if (sharedPreferences2.getBoolean("isLiked14", false)) {
            links.add("https://youtu.be/rdgKpCr8Id4?si=k03MllVLnvz6rtA3");
        }
        if (sharedPreferences2.getBoolean("isLiked15", false)) {
            links.add("https://youtu.be/rvDsgZK83yQ?si=3UxQYFx7fApe13u1");
        }
        if (sharedPreferences2.getBoolean("isLiked16", false)) {
            links.add("https://youtu.be/KxuOTYCbu0U?si=Imw5ucZV-TEDfl_V");
        }

        SharedPreferences sharedPreferences3 = getSharedPreferences("liked_Images3", MODE_PRIVATE);
        if (sharedPreferences3.getBoolean("isLiked17", false)) {
            links.add("https://youtu.be/cwZfv3Xzg5s?si=KhEUN76tyrXqJsXv");
        }
        if (sharedPreferences3.getBoolean("isLiked18", false)) {
            links.add("https://youtu.be/ubNkn4uj-5g?si=B-TiIGdfDfS4jMma");
        }
        if (sharedPreferences3.getBoolean("isLiked19", false)) {
            links.add("https://youtu.be/2o3sCsIsDhk?si=LsJ0GrBr9JmGy4dF");
        }
        if (sharedPreferences3.getBoolean("isLiked20", false)) {
            links.add("https://youtu.be/MUX31UFg89E?si=SwnQaa1JzcqJP-zN");
        }
        if (sharedPreferences3.getBoolean("isLiked21", false)) {
            links.add("https://youtu.be/YyIdfbIRmuU?si=xqe2pqxm7NYdBXEy");
        }
        if (sharedPreferences3.getBoolean("isLiked22", false)) {
            links.add("https://youtu.be/x-Jy61ZBP1E?si=s5UgT_S7nxeNiQYO");
        }
        if (sharedPreferences3.getBoolean("isLiked23", false)) {
            links.add("https://youtu.be/ssvY53MYSM8?si=Hs7v8_CAa0rB9O5i");
        }
        if (sharedPreferences3.getBoolean("isLiked24", false)) {
            links.add("https://youtu.be/MyBWdpgJSPs?si=DSPdDpaG3nGyuSTd");
        }

        SharedPreferences sharedPreferences4 = getSharedPreferences("liked_Images4", MODE_PRIVATE);
        if (sharedPreferences4.getBoolean("isLiked25", false)) {
            links.add("https://youtu.be/EONbpM0iDfs?si=qgnRJqOJtuOr6j_C");
        }
        if (sharedPreferences4.getBoolean("isLiked26", false)) {
            links.add("https://youtu.be/bk-IrOaDhVY?si=uiJEuQFJRJGaoXgS");
        }
        if (sharedPreferences4.getBoolean("isLiked27", false)) {
            links.add("https://youtu.be/cz0CAM-fRpA?si=aCCCqYDIzygfmkwO");
        }
        if (sharedPreferences4.getBoolean("isLiked28", false)) {
            links.add("https://youtu.be/3pTwzitPTsk?si=mqD4jl85yTheKmn6");
        }
        if (sharedPreferences4.getBoolean("isLiked29", false)) {
            links.add("https://youtu.be/S2thSeazPWc?si=TAadLbziPTYTEYSE");
        }
        if (sharedPreferences4.getBoolean("isLiked30", false)) {
            links.add("https://youtu.be/FMA9cOlgRwQ?si=v687z-J8cx9f4-ZR");
        }
        if (sharedPreferences4.getBoolean("isLiked31", false)) {
            links.add("https://youtu.be/1sfJoht8GlM?si=0C_EfDTq2i4McVMC");
        }
        if (sharedPreferences4.getBoolean("isLiked32", false)) {
            links.add("https://youtu.be/rnanhIYvEVk?si=3s-JX9eWbofoxedP");
        }

        SharedPreferences sharedPreferences5 = getSharedPreferences("liked_Images5", MODE_PRIVATE);
        if (sharedPreferences5.getBoolean("isLiked33", false)) {
            links.add("https://youtu.be/o-DvwbtB2Gw?si=pApkBKlKGpL9AR67");
        }
        if (sharedPreferences5.getBoolean("isLiked34", false)) {
            links.add("https://youtu.be/o4h4uHCWSnU?si=T2lP7Jf2txTs0EVn");
        }
        if (sharedPreferences5.getBoolean("isLiked35", false)) {
            links.add("https://youtu.be/O-cQoIWr_fg?si=PvTiW38iZuh7d4ID");
        }
        if (sharedPreferences5.getBoolean("isLiked36", false)) {
            links.add("https://youtu.be/xyzKzkfkPjs?si=IUorja1mj0qg8394");
        }
        if (sharedPreferences5.getBoolean("isLiked37", false)) {
            links.add("https://youtu.be/zBJmJ2hOSdc?si=HgPrB_d99TeoHeK6");
        }
        if (sharedPreferences5.getBoolean("isLiked38", false)) {
            links.add("https://youtu.be/rUM1i7YbYPo?si=8dG9It_PB1ZPjI6B");
        }
        if (sharedPreferences5.getBoolean("isLiked39", false)) {
            links.add("https://youtu.be/VW28pSLCVu0?si=hEkaBwvH5_cBcdGj");
        }
        if (sharedPreferences5.getBoolean("isLiked40", false)) {
            links.add("https://youtu.be/xdKQohKz7aY?si=Abv7_y6TYlHTwZQ8");
        }
        SharedPreferences sharedPreferences6 = getSharedPreferences("liked_Images6", MODE_PRIVATE);
        if (sharedPreferences6.getBoolean("isLiked41", false)) {
            links.add("https://youtu.be/p2eMAwF1h4o?si=U9lxHg10Bcp872bd");
        }
        if (sharedPreferences6.getBoolean("isLiked42", false)) {
            links.add("https://youtu.be/YRBM5I7yk08?si=JBmY0AIyaz2i-PKF");
        }
        if (sharedPreferences6.getBoolean("isLiked43", false)) {
            links.add("https://youtu.be/vad4XSRY-Tc?si=a68I8GhEHqBNYwFs");
        }
        if (sharedPreferences6.getBoolean("isLiked44", false)) {
            links.add("https://youtu.be/re1hiSHGZEA?si=tpJic744crW8g8YJ");
        }
        if (sharedPreferences6.getBoolean("isLiked45", false)) {
            links.add("https://youtu.be/sbbmKPUiJkI?si=IzqJ95LMIG5WdZfU");
        }
        if (sharedPreferences6.getBoolean("isLiked46", false)) {
            links.add("https://youtu.be/sWPpTvElcCc?si=wHWC79pcDCbQMbO9");
        }
        if (sharedPreferences6.getBoolean("isLiked47", false)) {
            links.add("https://youtu.be/PCaIw2hDPzo?si=yGPYlAdKqt6HTZGP");
        }
        if (sharedPreferences6.getBoolean("isLiked48", false)) {
            links.add("https://youtu.be/76BZnkJwZxE?si=dVAcWkiyqzxhUkyX");
        }
        return links;
    }
}
