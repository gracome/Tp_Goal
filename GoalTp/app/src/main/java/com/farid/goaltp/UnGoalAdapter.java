package com.farid.goaltp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class UnGoalAdapter extends BaseAdapter {
    private Context context;
    private List<UnGoal> GoalItemList;
    private LayoutInflater inflater;

    public UnGoalAdapter(Context context, List<UnGoal> GoalItemList) {
        this.context = context;
        this.GoalItemList = GoalItemList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return GoalItemList.size();
    }

    @Override
    public UnGoal getItem(int position) {
        return GoalItemList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.adapter_goal, null);

        UnGoal itemCourant = getItem(i);
        String itemName = itemCourant.getNom();
        String itemExercice = itemCourant.getExercice();
        String memonic = itemCourant.getMemonic();


        ImageView itemIconView = view.findViewById(R.id.imageIcon);
        String ressourceName = "item_" +memonic+ "_icon";
        int resID = context.getResources().getIdentifier(ressourceName, "drawable", context.getPackageName());
        itemIconView.setImageResource(resID);

        TextView textName = view.findViewById(R.id.nom_goal);
        textName.setText(itemName);

        TextView textExo = view.findViewById(R.id.exo_goal);
        textExo.setText(itemExercice);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( context,LaListe.class);
                context.startActivity(intent);
            }
        });

        return view;
    }
}
