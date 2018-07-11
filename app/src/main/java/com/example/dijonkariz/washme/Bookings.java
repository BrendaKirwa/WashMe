//package com.example.dijonkariz.washme;
//
//import android.content.res.Resources;
//import android.graphics.Rect;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.DefaultItemAnimator;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.util.TypedValue;
//import android.view.View;
//
//import com.example.dijonkariz.washme.Model.Vehicle;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Bookings extends AppCompatActivity {
//    private List<Vehicle> itemList = new ArrayList<>();
//    private List<Package> packageItemList = new ArrayList<>();
//    private List<Service> serviceItemList = new ArrayList<>();
//    private RecyclerView recyclerView, recyclerView1, recyclerView2;
//    private VehicleViewAdapter mAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_bookings);
//
//        recyclerView = (RecyclerView) findViewById(R.id.vehicletype);
//        recyclerView1 = (RecyclerView) findViewById(R.id.packagetype);
//        recyclerView2 = (RecyclerView) findViewById(R.id.servicetype);
//
//        itemList = new ArrayList<>();
//        mAdapter = new VehicleViewAdapter(this, itemList);
//
//        //Vehicles
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.addItemDecoration(new LinearSpacingItemDecoration(2, dpToPx(10), true));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(mAdapter);
//
//        //Packages
//        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
//        recyclerView1.setLayoutManager(mLayoutManager2);
//        recyclerView1.addItemDecoration(new LinearSpacingItemDecoration(2, dpToPx(10), true));
//        recyclerView1.setItemAnimator(new DefaultItemAnimator());
//        recyclerView1.setAdapter(mAdapter);
//
//        //Services
//        RecyclerView.LayoutManager mLayoutManager3 = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
//        recyclerView2.setLayoutManager(mLayoutManager3);
//        recyclerView2.addItemDecoration(new LinearSpacingItemDecoration(2, dpToPx(10), true));
//        recyclerView2.setItemAnimator(new DefaultItemAnimator());
//        recyclerView2.setAdapter(mAdapter);
//
//        prepareVehicleData();
//        preparePackageData();
//        prepareServiceData();
//    }
//
//    private void prepareServiceData() {
//        //        for the service
//        Service a = new Service(getString(R.string.vehicle_suv));
//        serviceItemList.add(a);
//
//        a = new Service(getString(R.string.vehicle_sedan));
//        serviceItemList.add(a);
//
//        a = new Service(getString(R.string.vehicle_hatchback));
//        serviceItemList.add(a);
//
//        a = new Service(getString(R.string.vehicle_van));
//        serviceItemList.add(a);
//
//        a = new Service(getString(R.string.vehicle_convertible));
//        serviceItemList.add(a);
//
//        mAdapter.notifyDataSetChanged();
//    }
//
//    private void preparePackageData() {
//        //        for the package
//        Package pa = new Package(getString(R.string.vehicle_suv));
//        packageItemList.add(pa);
//
//        pa = new Package(getString(R.string.vehicle_sedan));
//        packageItemList.add(pa);
//
//        pa = new Package(getString(R.string.vehicle_hatchback));
//        packageItemList.add(pa);
//
//        pa = new Package(getString(R.string.vehicle_van));
//        packageItemList.add(pa);
//
//        pa = new Package(getString(R.string.vehicle_convertible));
//        packageItemList.add(pa);
//
//        mAdapter.notifyDataSetChanged();
//    }
//
//    private int dpToPx(int dp) {
//        Resources r = getResources();
//        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
//    }
//
//    private void prepareVehicleData() {
//        //        for the vehicle pictures
//        int[] covers = new int[]{
//                R.drawable.vehicle_suv,
//                R.drawable.vehicle_sedan,
//                R.drawable.vehicle_hatchback,
//                R.drawable.vehicle_van,
//                R.drawable.vehicle_convertible};
//
//        Item a = new Item(getString(R.string.vehicle_suv), covers[0]);
//        itemList.add(a);
//
//        a = new Item(getString(R.string.vehicle_sedan), covers[1]);
//        itemList.add(a);
//
//        a = new Item(getString(R.string.vehicle_hatchback), covers[2]);
//        itemList.add(a);
//
//        a = new Item(getString(R.string.vehicle_van), covers[3]);
//        itemList.add(a);
//
//        a = new Item(getString(R.string.vehicle_convertible), covers[4]);
//        itemList.add(a);
//
//        mAdapter.notifyDataSetChanged();
//    }
//
//    private class LinearSpacingItemDecoration extends RecyclerView.ItemDecoration {
//        private int spanCount;
//        private int spacing;
//        private boolean includeEdge;
//
//        public LinearSpacingItemDecoration(int i, int o, boolean b)
//        {
//            this.spanCount = i;
//            this.spacing = o;
//            this.includeEdge = b;
//        }
//
//        @Override
//        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//            int position = parent.getChildAdapterPosition(view); // item position
//            int column = position % spanCount; // item column
//
//            if (includeEdge) {
//                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
//                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)
//
//                if (position < spanCount) { // top edge
//                    outRect.top = spacing;
//                }
//                outRect.bottom = spacing; // item bottom
//            } else {
//                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
//                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
//                if (position >= spanCount) {
//                    outRect.top = spacing; // item top
//                }
//            }
//        }
//    }
//}
