package com.example.joban.SmartHome;


import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import com.joaquimley.faboptions.FabOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    private FabOptions mFabOptions;
    private RecyclerView recyclerView;
    private AlbumsAdapter adapter;
    private List<Album> albumList;
    private CardView cv;
    int[] covers = new int[]{
            R.drawable.album1,
            R.drawable.album2,
            R.drawable.album3,
            R.drawable.album4};
            Album a;
            private Toolbar mActionBarToolbar;
            int bed=-1;




    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar1);
        mActionBarToolbar.setTitle("MyHome");
        mFabOptions = findViewById(R.id.fab_options);
        mFabOptions.setOnClickListener(this);

        recyclerView = findViewById(R.id.recycler_view);
        cv = findViewById(R.id.card_view);

        albumList = new ArrayList<>();
        adapter = new AlbumsAdapter(this, albumList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


    }


    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.faboptions_favorite:
               // bed=bed+1;
              //  if(bed==0){
                a = new Album("BedRoom1", 13, covers[0]);
                albumList.add(a);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "BedRoom", Toast.LENGTH_SHORT).show();
                break;
                //}
                /**else if(bed==1){
                a = new Album("BedRoom2", 13, covers[0]);
                albumList.add(a);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "BedRoom", Toast.LENGTH_SHORT).show();
                break;
            }else if(bed==2){
                a = new Album("BedRoom3", 13, covers[0]);
                albumList.add(a);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "BedRoom", Toast.LENGTH_SHORT).show();
                break;
            }else if(bed==3){
                a = new Album("BedRoom4", 13, covers[0]);
                albumList.add(a);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "BedRoom", Toast.LENGTH_SHORT).show();
                break;
            }else if(bed==4){
                a = new Album("BedRoom5", 13, covers[0]);
                albumList.add(a);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "BedRoom", Toast.LENGTH_SHORT).show();
                break;
            }else if(bed==5){
                a = new Album("BedRoom6", 13, covers[0]);
                albumList.add(a);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "BedRoom", Toast.LENGTH_SHORT).show();
                break;
            }else if(bed==6){
                a = new Album("BedRoom7", 13, covers[0]);
                albumList.add(a);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "BedRoom", Toast.LENGTH_SHORT).show();
                break;
            }else if(bed==7){
                a = new Album("BedRoom8", 13, covers[0]);
                albumList.add(a);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "BedRoom", Toast.LENGTH_SHORT).show();
                break;
            }else if(bed==8){
                a = new Album("BedRoom9", 13, covers[0]);
                albumList.add(a);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "BedRoom", Toast.LENGTH_SHORT).show();
                break;
            }else if(bed==9){
                a = new Album("BedRoom10", 13, covers[0]);
                albumList.add(a);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "BedRoom", Toast.LENGTH_SHORT).show();
                break;
            }*/

            case R.id.faboptions_textsms:
                a = new Album("WashRoom", 8, covers[1]);
                albumList.add(a);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "WashRoom", Toast.LENGTH_SHORT).show();
                break;


            case R.id.faboptions_download:
                a = new Album("Kitchen", 11, covers[2]);
                albumList.add(a);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Kitchen", Toast.LENGTH_SHORT).show();
                break;


            case R.id.faboptions_share:
                a = new Album("DrawingRoom", 12, covers[3]);
                albumList.add(a);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "DrawingRoom", Toast.LENGTH_SHORT).show();
                break;

            default:
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


}
