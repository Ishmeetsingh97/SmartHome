package com.example.joban.SmartHome.Rooms;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.joban.SmartHome.Model;
import com.example.joban.SmartHome.MyCustomArrayAdapter;
import com.example.joban.SmartHome.R;

import java.util.ArrayList;
import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public  class Room7 extends AppCompatActivity {

    TextView mItemSelected;
    String[] listItems;
    boolean[] checkedItems;
    ArrayList<Integer> mUserItems = new ArrayList<>();
    private ListView lv;
    ArrayList<Model> stringList = new ArrayList<>();
    String s;
    EditText ed;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Room7");
        setSupportActionBar(toolbar);

        lv = findViewById(R.id.lv1);
        ed = findViewById(R.id.editText);

        mItemSelected = findViewById(R.id.tvItemSelected);
        listItems = getResources().getStringArray(R.array.shopping_item);
        checkedItems = new boolean[listItems.length];

        final CoordinatorLayout container = findViewById(R.id.r1);
        FloatingTextButton callButton = findViewById(R.id.fab);

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Room7.this);
                mBuilder.setTitle(R.string.dialog_title);
                mBuilder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if (isChecked) {
                            mUserItems.add(position);
                        } else {
                            mUserItems.remove((Integer.valueOf(position)));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0; i < mUserItems.size(); i++) {
                            item = item + listItems[mUserItems.get(i)];
                            stringList.add(get(listItems[mUserItems.get(i)]));
                            if (i != mUserItems.size() - 1) {
                                item = item + ", ";
                            }
                        }
                        ArrayAdapter<Model> itemsAdapter =
                                new MyCustomArrayAdapter(Room7.this, stringList);

                        lv = findViewById(R.id.lv1);
                        lv.setAdapter(itemsAdapter);
                    }
                });

                mBuilder.setNegativeButton(R.string.dismiss_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                mBuilder.setNeutralButton(R.string.clear_all_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        for (int i = 0; i < checkedItems.length; i++) {
                            checkedItems[i] = false;
                            mUserItems.clear();
                            mItemSelected.setText("");
                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
                Snackbar.make(container, "Call button clicked", Snackbar.LENGTH_SHORT).show();
            }
        });

    }


    public void tbclick(View v)
    {
        Boolean toggleStatus;
        toggleStatus = ((ToggleButton)v).isChecked();
        String s = (String) ((TextView)v).getText();
        String et = String.valueOf(ed.getText());
        if(toggleStatus)
        {
            AsyncTask<String,Void,Void> as = new Asynctask();
            as.execute("R7"+s,et);
            Toast.makeText(Room7.this, "R7"+s, Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(Room7.this, "Off", Toast.LENGTH_SHORT).show();

        }
    }

    private Model get(String s) {
        return new Model(s);
    }

}

