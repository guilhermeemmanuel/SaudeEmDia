package com.northeast.saudeemdia.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.northeast.saudeemdia.R;
import com.northeast.saudeemdia.model.Person;

import java.util.List;

/**
 * Created by Guiga on 19/09/2015.
 */
public class PersonAdapter extends BaseAdapter{

    private LayoutInflater mInflater;
    private List<Person> items;

    public PersonAdapter(Activity context, List<Person> list) {
        this.items = list;
        mInflater = LayoutInflater.from(context);

    }

    //Retorna a quantidade de Itens
    @Override
    public int getCount() {
        return items.size();
    }


    /**
     * Retorna o item de acordo com a posicao dele na tela.
     *
     * @param position
     * @return
     */
    public Person getItem(int position) {
        return items.get(position);
    }

    /**
     * Sem implementação
     *
     * @param position
     * @return
     */
    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View view, ViewGroup parent) {

        Person item = items.get(position);
        //infla o layout para podermos preencher os dados
        view = mInflater.inflate(R.layout.item_person_layout, null);


        ((TextView) view.findViewById(R.id.item_person_name_tv)).setText(item.getName());



        return view;
    }


    public void removeItem(int positionToRemove){
        items.remove(positionToRemove);
        notifyDataSetChanged();
    }

    public void updateItems(List<Person> items) {
        this.items = items;
        notifyDataSetChanged();
    }


}
