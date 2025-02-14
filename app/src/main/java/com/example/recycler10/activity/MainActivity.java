package com.example.recycler10.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycler10.R;
import com.example.recycler10.adapter.MemberAdapter;
import com.example.recycler10.model.Member;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    ArrayList<Member>members = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        refreshAdapter(members);
    }
    void initViews(){
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
    }

    void refreshAdapter(ArrayList<Member>members){
        MemberAdapter adapter = new MemberAdapter(context, members);
        recyclerView.setAdapter(adapter);
        loadMember();
    }
    void loadMember(){
        members.add(new Member(Member.HEADER,"Axrorov","Azizbek"));
        for (int i = 0; i<40;i++){


            if (i % 2 == 0){
                members.add(new Member(Member.TYPE_MEMBER_ONE,"Axrorov"+i,"azizbek"+i));

            } else if (i % 5 == 0) {
                members.add(new Member(Member.TYPE_MEMBER_THRE,"Axrorov"+i,"Azizbek"+i));

            }
            else {
                members.add(new Member(Member.TYPE_MEMBER_TWO,"Axrorov"+i,"Azizbek"+i));

            }

        }
        members.add(new Member(Member.FOOTER,"Axrorov","Azibek"));

    }
}